package online.suiyu.domain;

import java.util.Date;

public class CommentDemo {
    private int cid;
    private String cdetails;
    private String title;
    private String commentUser;
    private Date creation;

    public CommentDemo() {
    }

    public CommentDemo(int cid, String cdetails, String atitle, String commentUser, Date creation) {
        this.cid = cid;
        this.cdetails = cdetails;
        this.title = atitle;
        this.commentUser = commentUser;
        this.creation = creation;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCdetails() {
        return cdetails;
    }

    public void setCdetails(String cdetails) {
        this.cdetails = cdetails;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String atitle) {
        this.title = atitle;
    }

    public String getCommentUser() {
        return commentUser;
    }

    public void setCommentUser(String commentUser) {
        this.commentUser = commentUser;
    }

    public Date getCreation() {
        return creation;
    }

    public void setCreation(Date creation) {
        this.creation = creation;
    }

    @Override
    public String toString() {
        return "CommentDemo{" +
                "cid=" + cid +
                ", cdetails='" + cdetails + '\'' +
                ", title='" + title + '\'' +
                ", commentUser='" + commentUser + '\'' +
                ", creation=" + creation +
                '}';
    }
}
