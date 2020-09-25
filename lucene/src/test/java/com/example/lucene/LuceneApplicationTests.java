package com.example.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.File;
import java.io.IOException;

@SpringBootTest
class LuceneApplicationTests {

    @Test
    void contextLoads() {


    }

    @Test
    public void testLuceneIndex() throws IOException {
        //1 创建文档对象
        for (int i = 10; i < 20; i++) {

            Document document = new Document();
            // 创建并添加字段信息。参数：字段的名称、字段的值、是否存储，这里选Store.YES代表存储到文档列表。Store.NO代表不存储
            document.add(new StringField("id", i+"", Field.Store.YES));
            // 这里我们title字段需要用TextField，即创建索引又会被分词。StringField会创建索引，但是不会被分词
            document.add(new TextField("title", "我是一句话应该不会被分词11"+i, Field.Store.YES));
            //2 索引目录类,指定索引在硬盘中的位置
            Directory directory = FSDirectory.open(new File("d:\\indexDir"));
            //3 创建分词器对象
            Analyzer analyzer = new IKAnalyzer();
            //4 索引写出工具的配置对象
            IndexWriterConfig conf = new IndexWriterConfig(Version.LATEST, analyzer);
            //5 创建索引的写出工具类。参数：索引的目录和配置信息
            IndexWriter indexWriter = new IndexWriter(directory, conf);

            //6 把文档交给IndexWriter
            indexWriter.addDocument(document);
            //7 提交
            indexWriter.commit();
            //8 关闭
            indexWriter.close();
        }

    }

    @Test
    public void queryLuceneIndex()throws Exception {
        // 索引目录对象
        Directory directory = FSDirectory.open(new File("d:\\indexDir"));
        // 索引读取工具
        IndexReader reader = DirectoryReader.open(directory);
        // 索引搜索工具
        IndexSearcher searcher = new IndexSearcher(reader);

        // 创建查询解析器,两个参数：默认要查询的字段的名称，分词器
        QueryParser parser = new QueryParser("title", new IKAnalyzer());
        // 创建查询对象
        Query query = parser.parse("我是");

        // 搜索数据,两个参数：查询条件对象要查询的最大结果条数
        // 返回的结果是 按照匹配度排名得分前N名的文档信息（包含查询到的总条数信息、所有符合条件的文档的编号信息）。
        TopDocs topDocs = searcher.search(query, 10);
        // 获取总条数
        System.out.println("本次搜索共找到" + topDocs.totalHits + "条数据");
        // 获取得分文档对象（ScoreDoc）数组.SocreDoc中包含：文档的编号、文档的得分
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;
        for (ScoreDoc scoreDoc : scoreDocs) {
            // 取出文档编号
            int docID = scoreDoc.doc;
            // 根据编号去找文档
            Document doc = reader.document(docID);
            System.out.println("id: " + doc.get("id"));
            System.out.println("title: " + doc.get("title"));
            // 取出文档得分
            System.out.println("得分： " + scoreDoc.score);
        }


    }

    public void search(Query query) throws Exception {
        // 索引目录对象
        Directory directory = FSDirectory.open(new File("d:\\indexDir"));
        // 索引读取工具
        IndexReader reader = DirectoryReader.open(directory);
        // 索引搜索工具
        IndexSearcher searcher = new IndexSearcher(reader);

        // 搜索数据,两个参数：查询条件对象要查询的最大结果条数
        // 返回的结果是 按照匹配度排名得分前N名的文档信息（包含查询到的总条数信息、所有符合条件的文档的编号信息）。
        TopDocs topDocs = searcher.search(query, 10);
        // 获取总条数
        System.out.println("本次搜索共找到" + topDocs.totalHits + "条数据");
        // 获取得分文档对象（ScoreDoc）数组.SocreDoc中包含：文档的编号、文档的得分
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;

        for (ScoreDoc scoreDoc : scoreDocs) {
            // 取出文档编号
            int docID = scoreDoc.doc;
            // 根据编号去找文档
            Document doc = reader.document(docID);
            System.out.println("id: " + doc.get("id"));
            System.out.println("title: " + doc.get("title"));
            // 取出文档得分
            System.out.println("得分： " + scoreDoc.score);
        }
    }

    /**
     * termquery  Term 是搜索的最小单位， 不可分词，精准匹配
     * term 是数据分词后的最小单位，不能继续分，如果一个字段不需要分词，可以使用termQuery
     * @throws Exception
     */
    @Test
    public  void  termQuery()throws Exception{
        TermQuery termQuery = new TermQuery(new Term("title", "我是一句话应该不会被分词111"));
        search(termQuery);
    }

    /**
     * 通配符查询，类似sql中的like
     * @throws Exception
     */
    @Test
    public void  testWildCardQuery() throws Exception{
        WildcardQuery title = new WildcardQuery(new Term("title", "*我是*"));
        search(title);
    }

    /**
     * 模糊查询
     * 编辑距离例如 facebool-facebook 需要编辑一次，编辑距离就是1 可以使手动设置，在0-2之间
     * @throws Exception
     */
    @Test
    public void testFuzzyQuery()throws Exception{
        FuzzyQuery fuzzyQuery = new FuzzyQuery(new Term("title", "我是一句话应该不会被分词11"),2);
        search(fuzzyQuery);
    }
}
