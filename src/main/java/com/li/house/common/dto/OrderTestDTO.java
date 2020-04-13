package com.li.house.common.dto;

public class OrderTestDTO {
    private String orderNmu;
    private  String name;
    private String account;
    private String des;

    public String getOrderNmu() {
        return orderNmu;
    }

    public void setOrderNmu(String orderNmu) {
        this.orderNmu = orderNmu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    @Override
    public String toString() {
        return "OrderTestDTO{" +
                "orderNmu='" + orderNmu + '\'' +
                ", name='" + name + '\'' +
                ", account='" + account + '\'' +
                ", des='" + des + '\'' +
                '}';
    }
}
