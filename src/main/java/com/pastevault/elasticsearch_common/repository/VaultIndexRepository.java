package com.pastevault.elasticsearch_common.repository;

import com.pastevault.elasticsearch_common.model.IndexVaultNode;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaultIndexRepository extends ElasticsearchRepository<IndexVaultNode, String> {


}
