package com.ambity.client3.configuration;

import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ZoneAffinityServerListFilter;
import com.netflix.niws.loadbalancer.DiscoveryEnabledServer;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

import java.util.ArrayList;
import java.util.List;

/**
 * 金丝雀发布实现类，灰度发布实现类
 */
public class RibbonGrayMetadataServerListFilter extends ZoneAffinityServerListFilter implements EnvironmentAware {
    private String version;
    private Environment environment;

    @Override
    public List<Server> getFilteredListOfServers(List servers) {
        List<Server> output = super.getFilteredListOfServers(servers);
        List<Server> local = new ArrayList<>();
        // 判断version 相等才返回
        if (this.version != null && null != output && 0 < output.size()) {
            for (Server server : output) {
                if (this.version.equalsIgnoreCase(((DiscoveryEnabledServer) server).getInstanceInfo().getMetadata().get("CPCENV"))) {
                    local.add(server);
                }
            }
        }

        return local;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
        this.version = environment.getProperty("version");
    }
}
