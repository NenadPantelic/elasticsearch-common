package com.pastevault.elasticsearch_common.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "elasticsearch")
public record ElasticsearchConfigProperties(String indexName,
                                            String connectionUrl,
                                            Integer connectTimeoutMillis,
                                            Integer socketTimeoutMillis) {


}