package com.chouti.Indexor;

import com.caucho.hessian.client.HessianProxyFactory;
import com.chouti.SearchService.search.ChouTiSearch;

/**
 * Created with IntelliJ IDEA.
 * User: chouchris
 * Date: 13-8-14
 * Time: PM4:51
 * To change this template use File | Settings | File Templates.
 */
public class IndexEngine {
    private static final String SEARCH_SERVICE_URL = "http://test.zhouqiang.gozap.com:8080/service/ctSearch";
    private static ChouTiSearch chouTiSearch;

    static {
        try {
            HessianProxyFactory factory = new HessianProxyFactory();
            chouTiSearch = (ChouTiSearch)factory.create(ChouTiSearch.class, SEARCH_SERVICE_URL);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static ChouTiSearch getInstance(){
        return chouTiSearch;
    }
}
