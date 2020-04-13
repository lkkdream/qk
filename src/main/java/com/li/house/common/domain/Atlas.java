package com.li.house.common.domain;

public class Atlas {
    private String atId;

    private String atUrl;

    private String rId;

    public String getAtId() {
        return atId;
    }

    public void setAtId(String atId) {
        this.atId = atId == null ? null : atId.trim();
    }

    public String getAtUrl() {
        return atUrl;
    }

    public void setAtUrl(String atUrl) {
        this.atUrl = atUrl == null ? null : atUrl.trim();
    }

    public String getrId() {
        return rId;
    }

    public void setrId(String rId) {
        this.rId = rId == null ? null : rId.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", atId=").append(atId);
        sb.append(", atUrl=").append(atUrl);
        sb.append(", rId=").append(rId);
        sb.append("]");
        return sb.toString();
    }
}