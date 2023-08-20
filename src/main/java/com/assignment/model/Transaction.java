package com.assignment.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Transaction {
    @JsonProperty("PID")
    private Integer pid;

    @JsonProperty("PAMOUNT")
    private Double pamount;

    @JsonProperty("PDATA")
    private Long pdata;

    public Integer getPid() {
        return pid;
    }

    public Double getPamount() {
        return pamount;
    }

    public Long getPdata() {
        return pdata;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public void setPamount(Double pamount) {
        this.pamount = pamount;
    }

    public void setPdata(Long pdata) {
        this.pdata = pdata;
    }

}
