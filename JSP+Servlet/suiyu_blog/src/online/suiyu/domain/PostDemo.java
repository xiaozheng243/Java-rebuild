package online.suiyu.domain;

import java.util.Date;

public class PostDemo {
    private int aid;
    private String title;
    private String details;
    private String creation;
    private String classify;

    public PostDemo() {
    }

    public PostDemo(int aid, String title, String details, String creation, String classify, String stateid) {
        this.aid = aid;
        this.title = title;
        this.details = details;
        this.creation = creation;
        this.classify = classify;
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

    public String getCreation() {
        return creation;
    }

    public void setCreation(String creation) {
        this.creation = creation;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }


    @Override
    public String toString() {
        return "PostDemo{" +
                "aid=" + aid +
                ", title='" + title + '\'' +
                ", details='" + details + '\'' +
                ", creation='" + creation + '\'' +
                ", classify='" + classify + '\'' +
                '}';
    }
}
