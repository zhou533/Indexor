package com.chouti.Indexor.test;

import com.chouti.Indexor.IndexEngine;
import com.chouti.SearchService.result.ChouTiSearchResult;
import com.chouti.SearchService.result.ChouTiSearchServiceResult;
import com.chouti.SearchService.search.ChouTiSearch;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: chouchris
 * Date: 13-8-14
 * Time: PM5:18
 * To change this template use File | Settings | File Templates.
 */
public class IndexTest {
    @Test
    public void testIndex() throws Exception {
        ChouTiSearch chouTiSearch = IndexEngine.getInstance();
        ChouTiSearchServiceResult result = chouTiSearch.searchLinks("成都", null, -1, -1, -1);
        assertEquals(ChouTiSearchServiceResult.OK, result);
        ChouTiSearchResult searchResult = (ChouTiSearchResult)result.getObject();
        if (searchResult != null){
            System.out.println(searchResult.toString());
        }
    }
}
