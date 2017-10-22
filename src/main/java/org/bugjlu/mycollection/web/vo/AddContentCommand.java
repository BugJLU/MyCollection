package org.bugjlu.mycollection.web.vo;

public class AddContentCommand {
    private String url;
    private String tags;
    private Integer pms;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Integer getPms() {
        return pms;
    }

    public void setPms(Integer pms) {
        this.pms = pms;
    }
}
