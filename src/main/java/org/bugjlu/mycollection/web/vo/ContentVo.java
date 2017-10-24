package org.bugjlu.mycollection.web.vo;

import org.bugjlu.mycollection.po.Content;
import org.bugjlu.mycollection.po.Tag;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContentVo {
    private Integer id;
    private String url;
    private Date date;
    private String userName;
    private List<Tag> tags;
    private String title;
    private String pict;

    public ContentVo(Content content) {
        id = content.getId();
        url = content.getUrl();
        date = content.getDate();
        userName = content.getUser().getUserName();
        tags = new ArrayList<Tag>(content.getTags());
        fetchTitlePict();
    }

    public ContentVo() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPict() {
        return pict;
    }

    public void setPict(String pict) {
        this.pict = pict;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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

    public void fetchTitlePict() {
//        new Thread(new FetchFunc()).start();
        try {
            URL url = new URL(ContentVo.this.url);
            URLConnection connection = url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            reader.close();
            Pattern ptitle = Pattern.compile("(?<=<title>)([\\s]|[^<]*)(?=</title>)"); // group()
            Pattern ppict = Pattern.compile("(?<=<img)([\\s]|[^>])*src=\\\"([^\\\"]*)\\\""); // group(2)
            Matcher mtitle = ptitle.matcher(sb);
            Matcher mpict = ppict.matcher(sb);
//            while (mtitle.find() && )
            if (mtitle.find()) {
                ContentVo.this.title = mtitle.group();
            }
            boolean b;
            while ((b = mpict.find()) && (ContentVo.this.pict = mpict.group(2)).equals("")) ;
//            if (!b) ContentVo.this.pict = null;
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
//    private class FetchFunc implements Runnable {
//
//        @Override
//        public void run() {
//            synchronized (this) {
//                try {
//                    URL url = new URL(ContentVo.this.url);
//                    URLConnection connection = url.openConnection();
//                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//                    StringBuilder sb = new StringBuilder();
//                    String line;
//                    while ((line = reader.readLine()) != null) {
//                        sb.append(line);
//                    }
//                    reader.close();
//                    Pattern ptitle = Pattern.compile("(?<=<title>)([\\s\\S]*)(?=</title>)"); // group()
//                    Pattern ppict = Pattern.compile("(?<=<img)([\\s]|[^>])*src=\\\"([^\\\"]*)\\\""); // group(2)
//                    Matcher mtitle = ptitle.matcher(sb);
//                    Matcher mpict = ppict.matcher(sb);
////            while (mtitle.find() && )
//                    if (mtitle.find()) {
//                        ContentVo.this.title = mtitle.group();
//                    }
//                    boolean b;
//                    while ((b = mpict.find()) && (ContentVo.this.pict = mpict.group(2)) == "") ;
//                    if (!b) ContentVo.this.pict = null;
//                } catch (java.io.IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
}
