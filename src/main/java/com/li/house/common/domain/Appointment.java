package com.li.house.common.domain;

import java.util.Date;

public class Appointment {
    private String apId;

    private String uId;

    private String rId;

    private Date apLooktime;

    private Date apCreatetime;

    private String orderNum;

    private String price;

    public String getApId() {
        return apId;
    }

    public void setApId(String apId) {
        this.apId = apId == null ? null : apId.trim();
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId == null ? null : uId.trim();
    }

    public String getrId() {
        return rId;
    }

    public void setrId(String rId) {
        this.rId = rId == null ? null : rId.trim();
    }

    public Date getApLooktime() {
        return apLooktime;
    }

    public void setApLooktime(Date apLooktime) {
        this.apLooktime = apLooktime;
    }

    public Date getApCreatetime() {
        return apCreatetime;
    }

    public void setApCreatetime(Date apCreatetime) {
        this.apCreatetime = apCreatetime;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum == null ? null : orderNum.trim();
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", apId=").append(apId);
        sb.append(", uId=").append(uId);
        sb.append(", rId=").append(rId);
        sb.append(", apLooktime=").append(apLooktime);
        sb.append(", apCreatetime=").append(apCreatetime);
        sb.append(", orderNum=").append(orderNum);
        sb.append(", price=").append(price);
        sb.append("]");
        return sb.toString();
    }
}