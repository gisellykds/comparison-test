package com.comparison.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

public class Transaction {

    @NotNull
    @JsonProperty("PID")
    private Integer pid;

    @NotNull
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
