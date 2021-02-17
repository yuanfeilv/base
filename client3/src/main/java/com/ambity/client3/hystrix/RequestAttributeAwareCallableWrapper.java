package com.ambity.client3.hystrix;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.concurrent.Callable;


/**
 * 将主线程中RequestAttributes传递到hystrix子线程中，这样hystrix子线程在执行feign时就可以取到RequestAttributes
 * 
 * @author haijun.gao
 *
 */
public final class RequestAttributeAwareCallableWrapper implements HystrixCallableWrapper {
	
	@Override
	public <T> Callable<T> wrap(Callable<T> callable) {
		return new RequestAttributeAwareCallable<T>(callable, RequestContextHolder.getRequestAttributes());
	}

	
	private static class RequestAttributeAwareCallable<T> implements Callable<T> {

		private final Callable<T> delegate;
		
		private final RequestAttributes requestAttributes;

		
		public RequestAttributeAwareCallable(Callable<T> callable, RequestAttributes requestAttributes) {
			this.delegate = callable;
			this.requestAttributes = requestAttributes;
		}

		
		@Override
		public T call() throws Exception {
			try {
				RequestContextHolder.setRequestAttributes(requestAttributes);
				return delegate.call();
			} finally {
				RequestContextHolder.resetRequestAttributes();
			}
		}
	}
}
