
package com.bas.myteam10application.Service;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.BitSet;

public class Defect_stt {

    @SerializedName("dfs_id")
    @Expose
    private String dfsId;
    @SerializedName("dfs_code")
    @Expose
    private String dfsCode;
    @SerializedName("dfs_th_name")
    @Expose
    private String dfsThName;
    @SerializedName("dfs_en_name")
    @Expose
    private String dfsEnName;
    @SerializedName("dfs_description")
    @Expose
    private String dfsDescription;

    public String getDfsId() {
        return dfsId;
    }

    public void setDfsId(String dfsId) {
        this.dfsId = dfsId;
    }

    public String getDfsCode() {
        return dfsCode;
    }

    public void setDfsCode(String dfsCode) {
        this.dfsCode = dfsCode;
    }

    public String getDfsThName() {
        return dfsThName;
    }

    public void setDfsThName(String dfsThName) {
        this.dfsThName = dfsThName;
    }

    public String getDfsEnName() {
        return dfsEnName;
    }

    public void setDfsEnName(String dfsEnName) {
        this.dfsEnName = dfsEnName;
    }

    public String getDfsDescription() {
        return dfsDescription;
    }

    public void setDfsDescription(String dfsDescription) {
        this.dfsDescription = dfsDescription;
    }



}
