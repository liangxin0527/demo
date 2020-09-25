package com.example.elasticsearch;

import com.alibaba.fastjson.JSON;
import com.example.elasticsearch.config.DpiDataRecord;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.Map;
/**
 * @author liang
 * @date 2020/8/31
 */
@SpringBootTest
public class EsHighLevelClient {
    @Autowired
    private RestHighLevelClient restHighLevelClient;

    /**
     * 添加文档
     */


    @Test
    public void contextLoads() throws IOException {
        for (int i = 0; i < 30; i++) {
            DpiDataRecord dpiDataRecord = new DpiDataRecord("" + i, "name" + i,
                    "192.168.1.184", 1, "182.168.1.1", 1, "1" + i, "1" + 1, 1L, 1l, 1l,
                    "1" + i, "1", "1" + i, +i,
                    +i, "1" + i, "1" + i, "1" + i,
                    "1" + i, "1" + i, "1" + i, "1" + i, "1" + i, "1" + i, "1" + i, "1" + i, "1" + i, "1" + i, "1" + i, "1" + i, "1" + i, "1" + i, "1" + i, "1" + i, "1" + i, "1" + i, "1" + i, "1" + i,
                    "1" + i, "1" + i, "1" + i, "1" + i, "1" + i, "1" + i);
            dpiDataRecord.setTimestamp(1600410008061l);


            IndexRequest indexRequest = new IndexRequest("a_edge-dpi-data-record", "doc");
            Map map = JSON.parseObject(JSON.toJSONString(dpiDataRecord), Map.class);
            indexRequest.source(map);

            restHighLevelClient.index(indexRequest);
        }
//    }
//
//        @Test
//        public void test () throws IOException {
//            HashMap<String, Object> map = new HashMap<>();
//            map.put("username", "lbaci");
//            map.put("pwd", "123457");
//            map.put("address", "海淀区");
//            map.put("tel", "1111");
//            IndexRequest indexRequest = new IndexRequest("lbaci22", "doc", "111");
//            indexRequest.source(map);
//            IndexResponse index = restHighLevelClient.index(indexRequest);
////        restHighLevelClient.indexAsync(indexRequest, new ActionListener<IndexResponse>() {
////            @Override
////            public void onResponse(IndexResponse indexResponse) {
////                String index = indexResponse.getIndex();
////                indexResponse.getId();
////                System.out.println(index+indexResponse.getId()+indexResponse.getType());
////            }
////
////            @Override
////            public void onFailure(Exception e) {
////                System.out.println("async is fail ");
////            }
////        });
//
//
//        }
//
//        @Test
//        public void catIndex () throws IOException {
//            GetRequest getRequest = new GetRequest("lbaci22", "doc", "111");
//            GetResponse documentFields = restHighLevelClient.get(getRequest);
//            documentFields.getVersion();
//            System.out.println(documentFields.getIndex() + documentFields.getId());
//        }
//        @Test
//        public void delteDocument () throws IOException {
//            DeleteRequest deleteRequest = new DeleteRequest("lbaci22", "doc", "111");
//            DeleteResponse delete = restHighLevelClient.delete(deleteRequest);
//            System.out.println(delete.status());// ok not_found
//        }
//        @Test
//        public void queryDocument () throws IOException {
//            SearchRequest searchRequest = new SearchRequest("lbaci");
//            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//            searchSourceBuilder.size(10);
//            searchSourceBuilder.from(0);
//            searchSourceBuilder.timeout(new TimeValue(1000));
//            searchSourceBuilder.query(QueryBuilders.matchAllQuery());
//            SearchRequest source = searchRequest.source(searchSourceBuilder);
//            SearchResponse search = restHighLevelClient.search(searchRequest);
//            SearchHits hits = search.getHits();
//            SearchHit[] hits1 = hits.getHits();
//            for (SearchHit hit : search.getHits().getHits()) {
//                System.out.println(hit.getIndex());
//            }
//        }
//    }
    }
}

