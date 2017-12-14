package org.bugjlu.mycollection.po;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class User implements Comparable<User>, Serializable {

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

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj.getClass() != this.getClass()) return false;
        return email.equals(((User) obj).getEmail());
    }

    @Override
    public int hashCode() {
        if (email == null) {
            return super.hashCode();
        }
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md5.update(email.getBytes());
        byte[] md5Array = md5.digest();
        return md5Array[3] & 0xFF |
                (md5Array[2] & 0xFF) << 8 |
                (md5Array[1] & 0xFF) << 16 |
                (md5Array[0] & 0xFF) << 24;
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
