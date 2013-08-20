package com.chouti.Indexor;

import com.chouti.Indexor.model.Link;
import com.chouti.SearchService.result.ChouTiSearchServiceResult;
import com.chouti.SearchService.search.ChouTiSearch;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: chouchris
 * Date: 13-8-12
 * Time: PM4:35
 * To change this template use File | Settings | File Templates.
 */
public class Indexor {
    private static final Logger LOGGER = Logger.getLogger(Indexor.class);

    public static void main(String[] args){

        Integer startId = 0;
        if (args != null && args.length > 0){
            startId = Integer.valueOf(args[0]);
        }

        DateTime now = new DateTime();
        DateTimeFormatter formatter = ISODateTimeFormat.dateTime();
        LOGGER.info("Indexor start..." + formatter.print(now));

        //Integer linkCount = DBEngine.getInstance().getLinkCount(startId);
        //LOGGER.info("Links total count:" + linkCount);

        int linkCount;
        int start = 0, size = 25;
        do{
            linkCount = 0;
            List<Link> links = DBEngine.getInstance().getLinks(startId, start, size);
            if (null != links){
                ChouTiSearch chouTiSearch = IndexEngine.getInstance();
                for (Link l : links){
                    ChouTiSearchServiceResult result = chouTiSearch.putLinkData(
                            l.getId(),
                            l.getTitle(),
                            l.getSummary(),
                            l.getContent(),
                            l.getUrl(),
                            l.getJid(),
                            l.getSubjectId(),
                            l.getCreateTime(),
                            l.getUps(),
                            l.getScore()
                    );
                    if (result.getCode() != 0){
                        LOGGER.info("ChouTi Search index " + l.getId() + " failed : " + result.getDescription());
                    }else {
                        LOGGER.info("ChouTi Search index " + l.getId() + " done!");
                    }
                }
                start += links.size();
                linkCount = links.size();
                LOGGER.info("" + links.size() + " links index done at " + formatter.print(new DateTime()));
            }else {
                LOGGER.info("getLinks error..");
            }
        }while (0 < linkCount);

        DateTime end = new DateTime();
        LOGGER.info("All done at " + formatter.print(end) + ", seconds:" + (end.getMillis() - now.getMillis())/1000);
    }
}
