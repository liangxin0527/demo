package com.example.elasticsearch;


import org.assertj.core.util.Lists;
import org.elasticsearch.ElasticsearchStatusException;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.IndicesClient;

import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class ElasticsearchApplicationTests {
    @Autowired
    private RestHighLevelClient restHighLevelClient;
    String INDEX_VIOLATION_RECORD = "a_edge-violation-link-record";
    String ELASTIC_INDEX_TEDR = "i_edge-threat-event-record-";
    String ELASTIC_INDEX_VLDR = "i_edge-violation-link-record-";
    String ELASTIC_INDEX_DPIDR = "i_edge-dpi-data-record-";
    String ELASTIC_INDEX_VLLOG = "i_edge-violation-link-log-record-";

    String INDEX_THREAT_EVENT_LAST72H = "a_edge-threat-event-record-last72h";
    String INDEX_VSL_DOMAIN_RECORD = "a_edge-vsl-domain-record";
    String INDEX_SYSLOG_RECdE_STATUS_RECORD = "a_edge-third-device-status-record";
    String INDEX_VLLOG_RECORD = "a_edge-violation-link-log-record";
    String INDEX_DPI_RECORD = "a_edge-dpi-data-record";
    @Test
    void contextLoads() {
        SearchRequest searchRequest = new SearchRequest(INDEX_VIOLATION_RECORD);
        searchRequest.types("doc");

        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        //添加未同步条件
        boolQueryBuilder.filter(QueryBuilders.termQuery("sync_status", "0"));

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(boolQueryBuilder);

        // 分页
        SearchRequest pageRequest = new SearchRequest(INDEX_VIOLATION_RECORD);
        pageRequest.types("doc");
        searchSourceBuilder.from(0);
        searchSourceBuilder.size(1000);
        searchSourceBuilder.sort("timestamp", SortOrder.DESC);
        searchRequest.source(searchSourceBuilder);

        List<Map<String, Object>> list = Lists.newArrayList();
        long total = 0;
        try {
            SearchResponse response = restHighLevelClient.search(searchRequest);
            for (SearchHit hit : response.getHits()) {
                Map<String, Object> latest = hit.getSourceAsMap();
                latest.put("id", hit.getId());
                list.add(latest);
            }
        } catch (ElasticsearchStatusException ese) {
            System.out.println("logger.debug(\"index not found\");");
        } catch (Exception e) {
            System.out.println("            logger.warn(\"error when querying link record\", e);\n");
        }
    }
    @Test
    public  void test01(){


    }

}
