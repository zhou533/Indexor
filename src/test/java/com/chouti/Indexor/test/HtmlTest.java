package com.chouti.Indexor.test;

import com.chouti.Indexor.utils.HtmlUtil;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: chouchris
 * Date: 13-8-15
 * Time: AM11:38
 * To change this template use File | Settings | File Templates.
 */
public class HtmlTest {

    private static final String testContent = "<div class=\"cmain\"> \n" +
            " <p><span class=\"c6\"></span></p> \n" +
            " <div class=\"txt\">\n" +
            "  2013-01-08 03:10:51　来源: \n" +
            "  <a href=\"/hd.php?gsid=&amp;urlId=&amp;url=http%3A%2F%2Fwww.morningpost.com.cn%2Fszb%2Fhtml%2F2013-01%2F08%2Fcontent_203845.htm&amp;from=weibo\">北京晨报</a>(北京)　\n" +
            "  <a href=\"/hd.php?gsid=&amp;urlId=&amp;url=http%3A%2F%2Fnews.163.com%2F13%2F0108%2F03%2F8KLR4LG000011229.html%23&amp;from=weibo\">有0人参与</a>\n" +
            "  <br />\n" +
            "  <a href=\"/hd.php?gsid=&amp;urlId=&amp;url=http%3A%2F%2Fnews.163.com%2F13%2F0108%2F03%2F8KLR4LG000011229.html%23tiePostBox&amp;from=weibo\">\n" +
            "   <div class=\"new\">\n" +
            "    <div class=\"new_img\">\n" +
            "     <p style=\"text-align:center;\"><img src=\"http://r3.sinaimg.cn/201301/300/450/aHR0cDovL2ltZzEuY2FjaGUubmV0ZWFzZS5jb20vY25ld3MvY3NzMTMvZ290b3RpZS5naWY=.gif\" class=\"border\" alt=\"Loading...\" /></p>\n" +
            "    </div>\n" +
            "   </div></a> \n" +
            "  <br /> 这几天海淀区某小学5年级学生小强有点烦。因为在竞选班长的过程中给同学送礼被其他同学揭发，小强没有再次当选班长，失去了小升初评优的班干加分。据了解，近年来在北京的小学中，像小强这样在竞选中给同学送礼的现象绝非个例，而送礼只是成人世界潜规则侵入校园的诸多表象之一。\n" +
            "  <br />小学学生潜规则攻关的重点是与小升初评优相关的各类评选。据了解，北京的小升初主要通过推优加电脑派位两种模式进行。由于多数家长都期待孩子能够进入学校推优的范畴以进入更好的中学，学生推优资格的竞争日趋激烈。以西城区为例，小学区级三好生的比例平均为30%，市级三好生的比例仅为5%。而学生如果在学校获选担任班干或市区级三好生都能获得额度不等的推优加分，从而在与其他同学的推优积分竞争中胜出。\n" +
            "  <br /> 记者就这一现象分别采访了城6区的多所小学。从班主任、大队辅导员到德育副校长，这些与学生评优相关的教师均表示，在学生评优的过程中，来自学生家长的影响越来越普遍。石景山区一所小学的德育副校长说，学校曾经发生过这样一个事例，一名平时表现较差的学生出人意料地在一次班级选拔中获选，当同学质疑其没有当选资格的时候，这名小学5年级的学生说了一句话，“因为我们家有人”。她说，我在教育岗位上工作了20年，在校园里听到一个孩子说出这样一句话，感到非常羞愧！\n" +
            "  <br />21世纪教育研究院副院长熊丙奇表示，在欧美国家，学生会干部主要是培养学生服务意识和积累实践经验的岗位，要克服潜规则在学校蔓延的现象，必须将各类评优与利益脱钩。\n" +
            "  <br /> \n" +
            "  <a href=\"/hd.php?gsid=&amp;urlId=&amp;url=http%3A%2F%2Fnews.163.com%2F&amp;from=weibo\"><p style=\"text-align:center;\"><img src=\"http://r3.sinaimg.cn/201301/300/450/aHR0cDovL2ltZzEuY2FjaGUubmV0ZWFzZS5jb20vY25ld3MvY3NzMTMvaW1nL2VuZF9uZXdzLnBuZw==.png\" alt=\"Loading...\" /></p></a> 本文来源：北京晨报 责任编辑：NN102 \n" +
            "  <br />\n" +
            " </div> \n" +
            "</div>";

    @Test
    public void testHtmlCleaner() throws Exception {
        String result = HtmlUtil.cleanHtml(testContent);
        System.out.println(result);
    }

    @Test
    public void testJoda() throws Exception {
        DateTime dt = new DateTime();

        DateTimeFormatter formatter = ISODateTimeFormat.dateTime();
        System.out.println(formatter.print(dt));
    }
}
