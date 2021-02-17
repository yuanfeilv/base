package com.ambity.client3.hystrix;

import org.slf4j.MDC;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;


/**
 * 将主线程中logback的MDC上下文传递到hystrix的子线程中，这样hystrix子线程在执行的时候就可以取到MDC上下文
 * 
 * @author haijun.gao
 *
 */
public class MdcAwareCallableWrapper implements HystrixCallableWrapper {

	@Override
	public <T> Callable<T> wrap(Callable<T> callable) {
		return new MdcAwareCallable<T>(callable, MDC.getCopyOfContextMap());
	}

	
	private static class MdcAwareCallable<T> implements Callable<T> {

		private final Callable<T> delegate;

		private final Map<String, String> contextMap;

		
		public MdcAwareCallable(Callable<T> callable, Map<String, String> contextMap) {
			this.delegate = callable;
			this.contextMap = contextMap != null ? contextMap : new HashMap<String, String>();
		}

		
		@Override
		public T call() throws Exception {
			try {
				MDC.setContextMap(contextMap);
				return delegate.call();
			} finally {
				MDC.clear();
			}
		}
	}

}
