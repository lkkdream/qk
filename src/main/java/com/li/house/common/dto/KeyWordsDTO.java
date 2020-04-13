package com.li.house.common.dto;

public class KeyWordsDTO {
    private String price;//价格
    private String administrativeId;//行政区域
    private String subwayLineId;//地铁沿线

    private int pageNum;//当前页码
    private int pageSize;//显示条数

    private String startPrice;
    private String endPrice;

    public String getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(String startPrice) {
        this.startPrice = startPrice;
    }

    public String getEndPrice() {
        return endPrice;
    }

    public void setEndPrice(String endPrice) {
        this.endPrice = endPrice;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAdministrativeId() {
        return administrativeId;
    }

    public void setAdministrativeId(String administrativeId) {
        this.administrativeId = administrativeId;
    }

    public String getSubwayLineId() {
        return subwayLineId;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setSubwayLineId(String subwayLineId) {
        this.subwayLineId = subwayLineId;
    }


    @Override
    public String toString() {
        return "KeyWordsDTO{" +
                "price='" + price + '\'' +
                ", administrativeId='" + administrativeId + '\'' +
                ", subwayLineId='" + subwayLineId + '\'' +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", startPrice='" + startPrice + '\'' +
                ", endPrice='" + endPrice + '\'' +
                '}';
    }
}
