package com.example.scurity;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author liang
 * @date 2021/4/15
 */
@Slf4j
public class MybatisEx {
    public void test() throws IOException {
        //获取mybatis 配置文件流
        String config = "resources/mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(config);
        //创建SQLSession factory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 构建sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        MybatisEx user = (MybatisEx) sqlSession.selectOne("cn.mappers.mappers.UserMapper.selectUserById", 1);
        log.info(user + "----");
        // 下面的delete不会生效，因为mybatis默认没有开启自动提交
        int delete = sqlSession.delete("cn.lbrace.mappers.UserMapper.deleteUserById", 1);
        log.info("delete" + delete);

    }
}
