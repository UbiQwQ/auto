package com.innovation.auto.entity;

public class Dic {
    private Integer dicId;

    private String partitionId;

    private String partitionDesc;

    private String dicCode;

    private String dicLabel;

    private String delFlg;

    public Integer getDicId() {
        return dicId;
    }

    public void setDicId(Integer dicId) {
        this.dicId = dicId;
    }

    public String getPartitionId() {
        return partitionId;
    }

    public void setPartitionId(String partitionId) {
        this.partitionId = partitionId == null ? null : partitionId.trim();
    }

    public String getPartitionDesc() {
        return partitionDesc;
    }

    public void setPartitionDesc(String partitionDesc) {
        this.partitionDesc = partitionDesc == null ? null : partitionDesc.trim();
    }

    public String getDicCode() {
        return dicCode;
    }

    public void setDicCode(String dicCode) {
        this.dicCode = dicCode == null ? null : dicCode.trim();
    }

    public String getDicLabel() {
        return dicLabel;
    }

    public void setDicLabel(String dicLabel) {
        this.dicLabel = dicLabel == null ? null : dicLabel.trim();
    }

    public String getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(String delFlg) {
        this.delFlg = delFlg == null ? null : delFlg.trim();
    }
}