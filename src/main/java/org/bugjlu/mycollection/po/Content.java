package org.bugjlu.mycollection.po;

import java.util.Date;
import java.util.Set;

public class Content {

    private Integer id;
    private String url;
    private Integer permission;
    private Date date;
    private Set<Tag> tag;

    public Set<Tag> getTag() {
        return tag;
    }

    public void setTag(Set<Tag> tag) {
        this.tag = tag;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    private String email;

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

    public Integer getPermission() {
        return permission;
    }

    public void setPermission(Integer permission) {
        this.permission = permission;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
