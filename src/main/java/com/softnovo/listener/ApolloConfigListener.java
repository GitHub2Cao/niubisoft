package com.softnovo.listener;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.CollectionUtils;

import java.util.Set;

/**
 * @author CGM
 */
@Configuration
public class ApolloConfigListener {
    @ApolloConfig
    private Config config;

    @ApolloConfigChangeListener
    private static void configChangeListter(ConfigChangeEvent changeEvent) {
        Set<String> changedKeys = changeEvent.changedKeys();
        if (!CollectionUtils.isEmpty(changedKeys)) {
            changedKeys.forEach(key -> System.out.println("=========== " + changeEvent.getChange(key)));
        }
    }
}
