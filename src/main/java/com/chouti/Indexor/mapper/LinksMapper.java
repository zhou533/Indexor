package com.chouti.Indexor.mapper;

import com.chouti.Indexor.model.Link;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: chouchris
 * Date: 13-8-14
 * Time: PM3:34
 * To change this template use File | Settings | File Templates.
 */
public interface LinksMapper {
    public List<Link> getLinks(@Param("startId") int startId, @Param("start") int start, @Param("limit") int limit);
    //public List<Link> getFullLinks(@Param("start") int start, @Param("limit") int limit);
    public Integer getCount(@Param("startId") int startId);
}
