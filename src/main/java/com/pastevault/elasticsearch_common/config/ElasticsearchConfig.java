package com.pastevault.elasticsearch_common.config;

import com.pastevault.elasticsearch_common.properties.ElasticsearchConfigProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.elasticsearch.support.HttpHeaders;

import java.util.function.Supplier;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.pastevault")
public class ElasticsearchConfig extends ElasticsearchConfiguration {

    private final ElasticsearchConfigProperties elasticsearchConfigProperties;

    public ElasticsearchConfig(ElasticsearchConfigProperties elasticsearchConfigProperties) {
        this.elasticsearchConfigProperties = elasticsearchConfigProperties;
    }

//    @Bean
//    public RestClient elasticsearchClient() {
//        UriComponents serverUri = UriComponentsBuilder.fromHttpUrl(elasticsearchConfigProperties.connectionUrl()).build();
//
//
//        return new RestClient(
//                RestClient.builder(new HttpHost(
//                        Objects.requireNonNull(serverUri.getHost()),
//                        serverUri.getPort(),
//                        serverUri.getScheme()
//                )).setRequestConfigCallback(requestConfigBuilder ->
//                        requestConfigBuilder.setConnectTimeout(elasticsearchConfigProperties.connectTimeoutMillis())
//                                .setSocketTimeout(elasticsearchConfigProperties.socketTimeoutMillis())
//                ).setDefaultHeaders();
//        );
//    }
//
////    @Bean
////    public ElasticsearchOperations elasticsearchTemplate() {
////        return new ElasticsearchRestTemplate(elasticsearchClient());
////    }

    @Override
    public ClientConfiguration clientConfiguration() {
        Supplier<HttpHeaders> headersSupplier = () -> {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json");
            return headers;
        };

        System.out.println("ALPI " + elasticsearchConfigProperties.connectionUrl());
        return ClientConfiguration.builder()
                .connectedTo(elasticsearchConfigProperties.connectionUrl())
                .withHeaders(headersSupplier)
                .build();
    }
}
