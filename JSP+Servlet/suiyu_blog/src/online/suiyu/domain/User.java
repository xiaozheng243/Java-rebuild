package online.suiyu.domain;

import java.util.Date;

public class User {
    private int id;
    private String username;
    private String upassword;
    private String email;
    private Date birth;
    private String usign;
    private Date regtime;
    private String phone;
    private String github;
    private String disc;
    private String photo;

    public User() {
    }

    public User(int id, String username, String upassword, String email, Date birth, String usign, Date regtime, String phone, String github, String disc, String photo) {
        this.id = id;
        this.username = username;
        this.upassword = upassword;
        this.email = email;
        this.birth = birth;
        this.usign = usign;
        this.regtime = regtime;
        this.phone = phone;
        this.github = github;
        this.disc = disc;
        this.photo = photo;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getDisc() {
        return disc;
    }

    public void setDisc(String disc) {
        this.disc = disc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getUsign() {
        return usign;
    }

    public void setUsign(String usign) {
        this.usign = usign;
    }

    public Date getRegtime() {
        return regtime;
    }

    public void setRegtime(Date regtime) {
        this.regtime = regtime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", upassword='" + upassword + '\'' +
                ", email='" + email + '\'' +
                ", birth=" + birth +
                ", usign='" + usign + '\'' +
                ", regtime=" + regtime +
                ", phone='" + phone + '\'' +
                ", github='" + github + '\'' +
                ", disc='" + disc + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }
}
