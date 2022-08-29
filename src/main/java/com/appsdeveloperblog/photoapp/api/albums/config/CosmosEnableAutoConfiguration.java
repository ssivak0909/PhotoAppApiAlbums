package com.appsdeveloperblog.photoapp.api.albums.config;

import com.azure.spring.cloud.autoconfigure.cosmos.AzureCosmosAutoConfiguration;
import com.azure.spring.cloud.autoconfigure.data.cosmos.CosmosDataAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({CosmosDataAutoConfiguration.class, AzureCosmosAutoConfiguration.class})
//@EnableCosmosRepositories({"com.appsdeveloperblog.photoapp.api.albums.cosmos.repository"})
@ConditionalOnProperty(prefix = "azure.cosmos", name = "enabled", matchIfMissing = false)
public class CosmosEnableAutoConfiguration {
}
