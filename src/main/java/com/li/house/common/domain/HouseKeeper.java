package com.li.house.common.domain;

public class HouseKeeper {
    private String hkId;

    private String hkName;

    private String hkPicture;

    private  String hkPhonenum;

    public String getHkId() {
        return hkId;
    }

    public void setHkId(String hkId) {
        this.hkId = hkId == null ? null : hkId.trim();
    }

    public String getHkName() {
        return hkName;
    }

    public void setHkName(String hkName) {
        this.hkName = hkName == null ? null : hkName.trim();
    }

    public String getHkPicture() {
        return hkPicture;
    }

    public void setHkPicture(String hkPicture) {
        this.hkPicture = hkPicture == null ? null : hkPicture.trim();
    }

    public String getHkPhonenum() {
        return hkPhonenum;
    }

    public void setHkPhonenum(String hkPhonenum) {
        this.hkPhonenum = hkPhonenum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", hkId=").append(hkId);
        sb.append(", hkName=").append(hkName);
        sb.append(", hkPicture=").append(hkPicture);
        sb.append(", hkPhonenum=").append(hkPhonenum);
        sb.append("]");
        return sb.toString();
    }
}