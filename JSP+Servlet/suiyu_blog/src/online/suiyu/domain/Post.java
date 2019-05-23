package online.suiyu.domain;

import java.util.Date;

public class Post {
    private int aid;
    private String title;
    private String details;
    private Date creation;
    private int classify;
    private int userid;
    private int stateid;

    public Post() {
    }

    public Post(int aid, String title, String details, Date creation, int classify, int userid, int stateid) {
        this.aid = aid;
        this.title = title;
        this.details = details;
        this.creation = creation;
        this.classify = classify;
        this.userid = userid;
        this.stateid = stateid;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Date getCreation() {
        return creation;
    }

    public void setCreation(Date creation) {
        this.creation = creation;
    }

    public int getClassify() {
        return classify;
    }

    public void setClassify(int classify) {
        this.classify = classify;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getStateid() {
        return stateid;
    }

    public void setStateid(int stateid) {
        this.stateid = stateid;
    }

    @Override
    public String toString() {
        return "PostDao{" +
                "aid=" + aid +
                ", title='" + title + '\'' +
                ", details='" + details + '\'' +
                ", creation=" + creation +
                ", classify=" + classify +
                ", userid=" + userid +
                ", stateid=" + stateid +
                '}';
    }
}
