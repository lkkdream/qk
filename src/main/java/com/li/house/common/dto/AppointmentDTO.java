package com.li.house.common.dto;

public class AppointmentDTO {
    private   String orderNo;
    private   String createTime;
    private   String rId ;
    private   String price;

    public AppointmentDTO(String orderNo, String createTime, String rId, String price) {
        this.orderNo = orderNo;
        this.createTime = createTime;
        this.rId = rId;
        this.price = price;
    }

    public AppointmentDTO() {
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getrId() {
        return rId;
    }

    public void setrId(String rId) {
        this.rId = rId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "AppointmentDTO{" +
                "orderNo='" + orderNo + '\'' +
                ", createTime='" + createTime + '\'' +
                ", rId='" + rId + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
