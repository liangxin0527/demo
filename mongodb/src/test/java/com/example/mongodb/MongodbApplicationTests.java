package com.example.mongodb;

import com.example.mongodb.pojo.Users;
import org.bson.Document;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.TypedAggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.*;

@SpringBootTest
class MongodbApplicationTests {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    void contextLoads() {
        ArrayList<Users> users1 = new ArrayList<>();
        for (int i = 10; i < 20; i++) {
            Users users = new Users();
            users.setId(i + "");
            users.setUserage(i);
            users.setUserbirth(new Date());
            users.setUsername("lbaci" + i + "");
            users1.add(users);
        }
        Collection<Users> users = mongoTemplate.insertAll(users1);


    }

    @Test
    public void getMessage() {
        // mongoTemplate.findAll(Users.class).forEach(e-> System.out.println(e));
        Query q = new Query(Criteria.where("userage").gte(5).lte(22));

        List<Users> users = mongoTemplate.find(q, Users.class);
        users.forEach(e -> System.out.println(e));
    }

    @Test
    public void getMessage2() {
        TypedAggregation<Users> count = Aggregation.newAggregation(Users.class, Aggregation.group("userage").count().as("Count"));
        AggregationResults<Document> aggregate = this.mongoTemplate.aggregate(count, Document.class);
        List<Document> mappedResults = aggregate.getMappedResults();
        for (Document mappedResult : mappedResults) {
            System.out.println(mappedResult.get("Count"));
        }
    }

    @Test
    public void teset00() {
        Aggregation aggregation = Aggregation.newAggregation(Aggregation.match(Criteria.where("username").is("1")), Aggregation.group("username").count().as("Count"));
        AggregationResults<Document> aggregate = this.mongoTemplate.aggregate(aggregation, Users.class, Document.class);
        for (Document document : aggregate) {
            System.out.println(document.get("Count"));
        }
    }

    @Test
    public void teset() {
        Query q = new Query(Criteria.where("username").regex("lb"));
        q.with(PageRequest.of(0, 5));
        q.with(Sort.by(Sort.Direction.ASC, "userage"));
        List<Users> list = this.mongoTemplate.find(q, Users.class);
        list.forEach(System.out::println);
        Query q2 = new Query(Criteria.where("username").regex("lb"));
        long count = this.mongoTemplate.count(q2, Users.class);
        System.out.println(count);

//        list.forEach(e-> System.out.println(e));
    }

    @Test
    public void test010() {
        List<Users> agg = mongoTemplate.findAll(Users.class, "agg");
        Update update = Update.update("username", "update");
        mongoTemplate.upsert(new Query(Criteria.where("username").is("1")), update, "agg");
    }

    @Test
    public void test011() {
        Aggregation aggregation = Aggregation.newAggregation(Aggregation.match(Criteria.where("userage").gte("10")), Aggregation.group("username").count().as("count")
                , Aggregation.sort(Sort.Direction.DESC, "username"), Aggregation.limit(4));

        AggregationResults<Map> agg = mongoTemplate.aggregate(aggregation, "agg", Map.class);
        agg.forEach((e) -> System.out.println(e));
    }

    @Test
    public void test001() {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.project("username", "userage","_id").and("username").as("name"),
                Aggregation.match(Criteria.where("username").regex("lb")),
//                Aggregation.group("username").count().as("count"),
                Aggregation.sort(Sort.Direction.ASC, "username"));
        AggregationResults<Map> map = mongoTemplate.aggregate(aggregation, "agg", Map.class);
        System.out.println(map.getMappedResults());

    }

    @Test
    public void testeii(){
        Query usreage = new Query(Criteria.where("usreage").lt(99));
        List<Map> agg = mongoTemplate.find(usreage, Map.class, "agg");
        System.out.println(agg.size());
        agg.stream().forEach(e-> System.out.println(e));
//        Aggregation userage = Aggregation.newAggregation(Aggregation.match(Criteria.where("userage").lt("99")));
//        AggregationResults<Users> agg = mongoTemplate.aggregate(userage, "agg", Users.class);
//        agg.getMappedResults().forEach(e-> System.out.println(e));

    } @Test
    public void DEMO1(){

        
    }
}
