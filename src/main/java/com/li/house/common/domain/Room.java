package com.li.house.common.domain;

import java.util.Date;

public class Room {
    private String rId;

    private Float rPrice;

    private String rOrientation;

    private String rVillage;

    private String rAId;

    private Integer rFloor;

    private Integer rTotalFloor;

    private String rSId;

    private String rHouseKeeperId;

    private Date rCreatetime;

    public String getrId() {
        return rId;
    }

    public void setrId(String rId) {
        this.rId = rId == null ? null : rId.trim();
    }

    public Float getrPrice() {
        return rPrice;
    }

    public void setrPrice(Float rPrice) {
        this.rPrice = rPrice;
    }

    public String getrOrientation() {
        return rOrientation;
    }

    public void setrOrientation(String rOrientation) {
        this.rOrientation = rOrientation == null ? null : rOrientation.trim();
    }

    public String getrVillage() {
        return rVillage;
    }

    public void setrVillage(String rVillage) {
        this.rVillage = rVillage == null ? null : rVillage.trim();
    }

    public String getrAId() {
        return rAId;
    }

    public void setrAId(String rAId) {
        this.rAId = rAId == null ? null : rAId.trim();
    }

    public Integer getrFloor() {
        return rFloor;
    }

    public void setrFloor(Integer rFloor) {
        this.rFloor = rFloor;
    }

    public Integer getrTotalFloor() {
        return rTotalFloor;
    }

    public void setrTotalFloor(Integer rTotalFloor) {
        this.rTotalFloor = rTotalFloor;
    }

    public String getrSId() {
        return rSId;
    }

    public void setrSId(String rSId) {
        this.rSId = rSId == null ? null : rSId.trim();
    }

    public String getrHouseKeeperId() {
        return rHouseKeeperId;
    }

    public void setrHouseKeeperId(String rHouseKeeperId) {
        this.rHouseKeeperId = rHouseKeeperId == null ? null : rHouseKeeperId.trim();
    }

    public Date getrCreatetime() {
        return rCreatetime;
    }

    public void setrCreatetime(Date rCreatetime) {
        this.rCreatetime = rCreatetime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", rId=").append(rId);
        sb.append(", rPrice=").append(rPrice);
        sb.append(", rOrientation=").append(rOrientation);
        sb.append(", rVillage=").append(rVillage);
        sb.append(", rAId=").append(rAId);
        sb.append(", rFloor=").append(rFloor);
        sb.append(", rTotalFloor=").append(rTotalFloor);
        sb.append(", rSId=").append(rSId);
        sb.append(", rHouseKeeperId=").append(rHouseKeeperId);
        sb.append(", rCreatetime=").append(rCreatetime);
        sb.append("]");
        return sb.toString();
    }
}