package com.ambity.client3.hystrix;

import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategy;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;


/**
 * Hystrix只允许有一个并发策略，因此需要将每个自定义HystrixConcurrencyStrategy注册至HystrixPlugins中，
 * 这在扩展性方面显然是缺失的，借鉴spring的实践，我们可以定义对Callable的包装接口HystrixCallableWrapper，
 * 根据实际的业务只需要对HystrixCallableWrapper进行实现，并注册对应的实现bean即可。
 * 实现线程上线文传播的核心在于对Callable进行包装，通过多次对Callable包装即实现了一个链式包装过程。
 * 示例地址：https://blog.csdn.net/songhaifengshuaige/article/details/80345012
 * 
 * @author haijun.gao
 *
 */
public class RequestContextHystrixConcurrencyStrategy extends HystrixConcurrencyStrategy {
	
	private final Collection<HystrixCallableWrapper> wrappers;

	public RequestContextHystrixConcurrencyStrategy(Collection<HystrixCallableWrapper> wrappers) {
		this.wrappers = wrappers;
	}

	@Override
	public <T> Callable<T> wrapCallable(Callable<T> callable) {
		return new CallableWrapperChain<T>(callable, wrappers.iterator()).wrapCallable();
	}

	private static class CallableWrapperChain<T> {

		private final Callable<T> callable;

		private final Iterator<HystrixCallableWrapper> wrappers;

		CallableWrapperChain(Callable<T> callable, Iterator<HystrixCallableWrapper> wrappers) {
			this.callable = callable;
			this.wrappers = wrappers;
		}

		Callable<T> wrapCallable() {
			Callable<T> delegate = callable;
			while (wrappers.hasNext()) {
				delegate = wrappers.next().wrap(delegate);
			}
			return delegate;
		}
	}
}
