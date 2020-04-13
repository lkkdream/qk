package com.li.house.common.domain;

import java.util.Date;

public class User {
    private String uId;

    private String uPhonenum;

    private String uNickname;

    private String uEmail;

    private String uPassword;

    private String uPicture;

    private Integer uProhibit;

    private Date uCreatetime;

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId == null ? null : uId.trim();
    }

    public String getuPhonenum() {
        return uPhonenum;
    }

    public void setuPhonenum(String uPhonenum) {
        this.uPhonenum = uPhonenum;
    }

    public String getuNickname() {
        return uNickname;
    }

    public void setuNickname(String uNickname) {
        this.uNickname = uNickname == null ? null : uNickname.trim();
    }

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail == null ? null : uEmail.trim();
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword == null ? null : uPassword.trim();
    }

    public String getuPicture() {
        return uPicture;
    }

    public void setuPicture(String uPicture) {
        this.uPicture = uPicture == null ? null : uPicture.trim();
    }

    public Integer getuProhibit() {
        return uProhibit;
    }

    public void setuProhibit(Integer uProhibit) {
        this.uProhibit = uProhibit;
    }

    public Date getuCreatetime() {
        return uCreatetime;
    }

    public void setuCreatetime(Date uCreatetime) {
        this.uCreatetime = uCreatetime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", uId=").append(uId);
        sb.append(", uPhonenum=").append(uPhonenum);
        sb.append(", uNickname=").append(uNickname);
        sb.append(", uEmail=").append(uEmail);
        sb.append(", uPassword=").append(uPassword);
        sb.append(", uPicture=").append(uPicture);
        sb.append(", uProhibit=").append(uProhibit);
        sb.append(", uCreatetime=").append(uCreatetime);
        sb.append("]");
        return sb.toString();
    }
}