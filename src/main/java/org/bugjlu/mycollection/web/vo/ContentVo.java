package org.bugjlu.mycollection.web.vo;

import org.bugjlu.mycollection.po.Tag;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class ContentVo {
    private Integer id;
    private String url;
    private Timestamp date;
    private String userName;
    private List<Tag> tags;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}
