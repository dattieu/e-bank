package com.dtu.banking.core.config.cache;

import com.hazelcast.config.*;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableCaching
public class HazelcastConfig {

    private static final String CACHE_INSTANCE = "E-BANK";
    private static final String MAP_CONFIG = "default";

    @Bean
    public HazelcastInstance hazelcastInstance() {
        HazelcastInstance hazelCastInstance = Hazelcast.getHazelcastInstanceByName(CACHE_INSTANCE);
        if (hazelCastInstance != null) {
            return hazelCastInstance;
        }
        Config config = new Config();
        config.setInstanceName(CACHE_INSTANCE);
        config.getNetworkConfig().getJoin().getMulticastConfig().setEnabled(false);
        config.setManagementCenterConfig(new ManagementCenterConfig());
        config.addMapConfig(initializeDefaultMapConfig());
        return Hazelcast.newHazelcastInstance(config);
    }

    private MapConfig initializeDefaultMapConfig() {
        MapConfig mapConfig = new MapConfig(MAP_CONFIG);
        mapConfig.setBackupCount(0);
        mapConfig.getEvictionConfig().setEvictionPolicy(EvictionPolicy.LRU);
        mapConfig.getEvictionConfig().setMaxSizePolicy(MaxSizePolicy.USED_HEAP_SIZE);
        return mapConfig;
    }

}
