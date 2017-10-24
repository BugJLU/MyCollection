package org.bugjlu.mycollection.po;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class User implements Comparable<User>{

    private String email;
    private String userName;
    private String password;
    private Integer age;
    private Boolean gender;
    private Set<User> followee;
    private Set<Content> contents;
    private Set<Tag> tags;


    @Override
    public int compareTo(User o) {
        return userName.compareTo(o.getUserName());
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender()
    {
        if(gender != null)
        {
            return gender == true ? "M" : "F";
        }
        return null;
    }

    public void setGender(String tGender)
    {
        if(tGender != null)
        {
            gender = tGender.equals("M");
        } else
        {
            gender = null;
        }
    }



    public Boolean getBGender() {
        return gender;
    }

    public void setBGender(Boolean gender) {
        this.gender = gender;
    }


    public Set<User> getFollowee() {
        return followee;
    }

    public void setFollowee(Set<User> followee) {
        this.followee = followee;
    }

    public Set<Content> getContents() {
        return contents;
    }

    public void setContents(Set<Content> contents) {
        this.contents = contents;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }
}
