package com.ambity.client3.hystrix;

import com.netflix.hystrix.strategy.HystrixPlugins;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategy;
import com.netflix.hystrix.strategy.eventnotifier.HystrixEventNotifier;
import com.netflix.hystrix.strategy.executionhook.HystrixCommandExecutionHook;
import com.netflix.hystrix.strategy.metrics.HystrixMetricsPublisher;
import com.netflix.hystrix.strategy.properties.HystrixPropertiesStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


/**
 * hystrix上下文配置
 * @author haijun.gao
 *
 */
@Configuration
@ConditionalOnProperty(name = "feign.hystrix.enabled", havingValue = "true")
public class HystrixContextConfig {
	
	/**
	 * hystrix中配置日志的mdc
	 * @return
	 */
	@Bean
	public HystrixCallableWrapper mdcAwareCallableWrapper(){
	    return new MdcAwareCallableWrapper();
	}
	
	/**
	 * hystrix中配置RequestAttribute
	 * @return
	 */
	@Bean
	public HystrixCallableWrapper requestAttributeAwareCallableWrapper(){
		return new RequestAttributeAwareCallableWrapper();
	}

	
	/**
	 * HystrixCallableWrapper实现类自动注入到List中
	 */
	@Autowired(required = false)
	private List<HystrixCallableWrapper> wrappers = new ArrayList<>();
	
	
	/**
	 * 注册HystrixConcurrencyStrategy策略
	 */
	@PostConstruct
    public void init() {
//		HystrixPlugins.getInstance().registerConcurrencyStrategy(new RequestContextHystrixConcurrencyStrategy(wrappers));
		
		HystrixConcurrencyStrategy strategy = HystrixPlugins.getInstance().getConcurrencyStrategy();
		if (strategy instanceof RequestContextHystrixConcurrencyStrategy) {
			return;
		}
		HystrixEventNotifier eventNotifier = HystrixPlugins.getInstance().getEventNotifier();
		HystrixMetricsPublisher metricsPublisher = HystrixPlugins.getInstance().getMetricsPublisher();
		HystrixPropertiesStrategy propertiesStrategy = HystrixPlugins.getInstance().getPropertiesStrategy();
		HystrixCommandExecutionHook commandExecutionHook = HystrixPlugins.getInstance().getCommandExecutionHook();
		
		// 应用中加入actuator后，注册HystrixConcurrencyStrategy会失败，因为已经注册了HystrixConcurrencyStrategyDefault，所以重置后再重新注册
		HystrixPlugins.reset();
		
		HystrixPlugins.getInstance().registerConcurrencyStrategy(new RequestContextHystrixConcurrencyStrategy(wrappers));
		HystrixPlugins.getInstance().registerEventNotifier(eventNotifier);
		HystrixPlugins.getInstance().registerMetricsPublisher(metricsPublisher);
		HystrixPlugins.getInstance().registerPropertiesStrategy(propertiesStrategy);
		HystrixPlugins.getInstance().registerCommandExecutionHook(commandExecutionHook);
		
    }

}
