package com.chouti.Indexor.utils;

/**
 * Created with IntelliJ IDEA.
 * User: chouchris
 * Date: 13-8-15
 * Time: AM11:35
 * To change this template use File | Settings | File Templates.
 */
public class HtmlUtil {

    public static String cleanHtml(String htmlContent){
        /*try {
            HtmlCleaner cleaner = new HtmlCleaner();
            TagNode node = cleaner.clean(htmlContent);
            String result = cleaner.getInnerHtml(node);
            return result;
        }catch (Exception e){
            e.printStackTrace();
        }
        return htmlContent;*/
        return htmlContent.replaceAll("<.*?>", "");
    }
}
