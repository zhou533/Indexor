package com.chouti.Indexor;

import com.chouti.Indexor.mapper.LinksMapper;
import com.chouti.Indexor.model.Link;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.io.Reader;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: chouchris
 * Date: 13-8-15
 * Time: AM10:44
 * To change this template use File | Settings | File Templates.
 */
public class DBEngine {

    private static final Logger LOGGER = Logger.getLogger(DBEngine.class);

    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;

    private static DBEngine dbEngine = new DBEngine();

    static {
        try {
            reader = Resources.getResourceAsReader("Configuration.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static DBEngine getInstance(){
        return dbEngine;
    }

    public Integer getLinkCount(Integer startId){
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            LinksMapper linksMapper = sqlSession.getMapper(LinksMapper.class);
            Integer count = linksMapper.getCount(startId);
            return count;
        }finally {
            sqlSession.close();
        }
    }

    public List<Link> getLinks(int startId, int start, int size){
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            LinksMapper linksMapper = sqlSession.getMapper(LinksMapper.class);
            List<Link> links = linksMapper.getLinks(startId, start, size);
            return links;
        }finally {
            sqlSession.close();
        }
    }
}
