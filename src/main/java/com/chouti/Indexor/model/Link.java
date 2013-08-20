package com.chouti.Indexor.model;

/**
 * Created with IntelliJ IDEA.
 * User: chouchris
 * Date: 13-8-14
 * Time: PM3:08
 * To change this template use File | Settings | File Templates.
 */
public class Link {
    private Integer id;
    private String title;
    private String summary;
    private String content;
    private String jid;
    private String url;
    private Integer subjectId;
    private Long createTime;
    private Integer ups;
    private Double score;

    public String getContent() {
        return content != null ? content.replaceAll("<.*?>", "") : null;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getCreateTime() {
        return createTime != null ? createTime : 0;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJid() {
        return jid;
    }

    public void setJid(String jid) {
        this.jid = jid;
    }

    public Double getScore() {
        return score != null ? score : 0;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Integer getSubjectId() {
        return subjectId != null ? subjectId : 0;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getUps() {
        return ups != null ? ups : 0;
    }

    public void setUps(Integer ups) {
        this.ups = ups;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
