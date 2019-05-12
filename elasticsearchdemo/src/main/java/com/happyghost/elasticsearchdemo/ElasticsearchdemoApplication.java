package com.happyghost.elasticsearchdemo;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@SpringBootApplication
public class ElasticsearchdemoApplication {




    public static final Logger logger = LoggerFactory.getLogger(ElasticsearchdemoApplication.class);

    @Autowired
    private TransportClient client;

    ElasticsearchTemplate elasticsearchTemplate;


    public static void main(String[] args) {
        SpringApplication.run(ElasticsearchdemoApplication.class, args);
    }

    @GetMapping("/get/info")
    @ResponseBody
    public ResponseEntity get(@RequestParam(name = "id",defaultValue = "") String id){

        if(id.isEmpty()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        GetResponse result = this.client.prepareGet("opportunity_transfer","opportunity_transfer",id)
                .get();
        if(!result.isExists()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(result.getSource(),HttpStatus.OK);
    }


    // 复合查询
    @PostMapping("query/info")
    @ResponseBody
    public ResponseEntity query(
            @RequestParam(name = "customer_nick_name", required = false) String customer_nick_name,
            @RequestParam(name = "customer_mobile", required = false) String customer_mobile,
            @RequestParam(name = "gt_area", defaultValue = "0") int gtArea,
            @RequestParam(name = "lt_area", required = false) Integer ltArea) {

        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();

        if (customer_mobile != null) {
            boolQuery.must(QueryBuilders.matchQuery("customer_mobile", customer_mobile));
        }

        if (customer_nick_name != null) {
            boolQuery.must(QueryBuilders.matchQuery("customer_nick_name", customer_nick_name));
        }

        RangeQueryBuilder rangeQuery = QueryBuilders.rangeQuery("area").from(gtArea);
        if (ltArea != null && ltArea > 0) {
            rangeQuery.to(ltArea);
        }
        boolQuery.filter(rangeQuery);

        SearchRequestBuilder builder = client.prepareSearch("opportunity_transfer").setTypes("opportunity_transfer")
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setQuery(boolQuery)
                .setFrom(0)
                .setSize(10);

        logger.debug("builder :" + builder.toString());
        logger.info("builder :" + builder.toString());

        SearchResponse response = builder.get();

        List result = new ArrayList<Map<String, Object>>();
        for (SearchHit hit : response.getHits()) {
            result.add(hit.getSourceAsMap());
        }

        return new ResponseEntity(result, HttpStatus.OK);

    }






}
