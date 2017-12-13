package org.bugjlu.mycollection.po;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class Content implements Comparable<Content>, Serializable{

    private Integer id;
    private String url;
    private Integer permission;
    private Date date;
    private Set<Tag> tags;
    private User user;


    @Override
    public int compareTo(Content o) {
        if (date.before(o.getDate())){
            return 1;
        } else{
            return -1;
        }
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Content) {
            if (id.equals(((Content) obj).id)) {
                return true;
            }
        }
        return false;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
