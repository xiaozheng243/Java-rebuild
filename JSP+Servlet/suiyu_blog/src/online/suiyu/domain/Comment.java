package online.suiyu.domain;

import java.util.Date;

public class Comment {
    private int cid;
    private String cdetails;
    private int aid;
    private String commentUser;
    private int supports;
    private Date creation;

    public Comment() {
    }

    public Comment(int cid, String cdetails, int aid, String commentUser, int supports, Date creation) {
        this.cid = cid;
        this.cdetails = cdetails;
        this.aid = aid;
        this.commentUser = commentUser;
        this.supports = supports;
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

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getCommentUser() {
        return commentUser;
    }

    public void setCommentUser(String commentUser) {
        this.commentUser = commentUser;
    }

    public int getSupports() {
        return supports;
    }

    public void setSupports(int supports) {
        this.supports = supports;
    }

    public Date getCreation() {
        return creation;
    }

    public void setCreation(Date creation) {
        this.creation = creation;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "cid=" + cid +
                ", cdetails='" + cdetails + '\'' +
                ", aid=" + aid +
                ", commentUser='" + commentUser + '\'' +
                ", supports=" + supports +
                ", creation=" + creation +
                '}';
    }
}
