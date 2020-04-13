package com.li.house.common.dto;

import com.li.house.common.domain.Administration;
import com.li.house.common.domain.Atlas;
import com.li.house.common.domain.Subway;

import java.util.Date;
import java.util.List;

public class RoomDTO {
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

    private List<Atlas> atlases;


    private Administration administration;

    private Subway subway;


    public Administration getAdministration() {
        return administration;
    }

    public void setAdministration(Administration administration) {
        this.administration = administration;
    }

    public Subway getSubway() {
        return subway;
    }

    public void setSubway(Subway subway) {
        this.subway = subway;
    }

    public String getrId() {
        return rId;
    }

    public void setrId(String rId) {
        this.rId = rId;
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
        this.rOrientation = rOrientation;
    }

    public String getrVillage() {
        return rVillage;
    }

    public void setrVillage(String rVillage) {
        this.rVillage = rVillage;
    }

    public String getrAId() {
        return rAId;
    }

    public void setrAId(String rAId) {
        this.rAId = rAId;
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
        this.rSId = rSId;
    }

    public String getrHouseKeeperId() {
        return rHouseKeeperId;
    }

    public void setrHouseKeeperId(String rHouseKeeperId) {
        this.rHouseKeeperId = rHouseKeeperId;
    }

    public Date getrCreatetime() {
        return rCreatetime;
    }

    public void setrCreatetime(Date rCreatetime) {
        this.rCreatetime = rCreatetime;
    }

    public List<Atlas> getAtlases() {
        return atlases;
    }

    public void setAtlases(List<Atlas> atlases) {
        this.atlases = atlases;
    }

    @Override
    public String toString() {
        return "RoomDTO{" +
                "rId='" + rId + '\'' +
                ", rPrice=" + rPrice +
                ", rOrientation='" + rOrientation + '\'' +
                ", rVillage='" + rVillage + '\'' +
                ", rAId='" + rAId + '\'' +
                ", rFloor=" + rFloor +
                ", rTotalFloor=" + rTotalFloor +
                ", rSId='" + rSId + '\'' +
                ", rHouseKeeperId='" + rHouseKeeperId + '\'' +
                ", rCreatetime=" + rCreatetime +
                ", atlases=" + atlases +
                ", administration=" + administration +
                ", subway=" + subway +
                '}';
    }
}
