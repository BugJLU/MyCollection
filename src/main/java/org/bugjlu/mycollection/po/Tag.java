package org.bugjlu.mycollection.po;

import java.io.Serializable;
import java.util.Set;

public class Tag implements Comparable<Tag>, Serializable {

    private Integer id;
    private String tagName;
    private User user;
    private Set<Content> contents;

    public Set<Content> getContents() {
        return contents;
    }

    public void setContents(Set<Content> contents) {
        this.contents = contents;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int compareTo(Tag o) {
        return tagName.compareTo(o.getTagName());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj.getClass() != this.getClass()) return false;
        return id.equals(((Tag) obj).getId());
    }

    @Override
    public int hashCode() {
        return id;
    }
}
