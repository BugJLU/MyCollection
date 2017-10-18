package org.bugjlu.mycollection.po;

public class User {

    private String email;
    private String userName;
    private String password;
    private Integer age;
    private Boolean gender;

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
}
