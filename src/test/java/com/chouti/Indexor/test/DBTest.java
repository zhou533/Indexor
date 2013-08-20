package com.chouti.Indexor.test;

import com.chouti.Indexor.mapper.LinksMapper;
import com.chouti.Indexor.model.Link;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.Reader;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: chouchris
 * Date: 13-8-14
 * Time: PM3:48
 * To change this template use File | Settings | File Templates.
 */
public class DBTest {
    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;

    static {
        try {
            reader = Resources.getResourceAsReader("Configuration.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testLinksMapper() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            //List<Link> links= (List<Link>)sqlSession.selectOne("com.chouti.Indexor.mapper.LinksMapper.getLinks", 0, 5);
            //System.out.println("Count: " + count);

            LinksMapper linksMapper = sqlSession.getMapper(LinksMapper.class);
            List<Link> links = linksMapper.getLinks(0, 0, 5);
            for (Link l : links){
                System.out.println("Link: " + l.getId() + ", ");
            }
        }finally {
            sqlSession.close();
        }

    }
}
