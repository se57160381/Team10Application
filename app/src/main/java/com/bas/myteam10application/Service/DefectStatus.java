
package com.bas.myteam10application.Service;

import java.util.List;

import com.bas.myteam10application.Service.Defect_stt;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DefectStatus {

    @SerializedName("defect_stt")
    @Expose
    private List<Defect_stt> defect_stt = null;

    public List<Defect_stt> getDefect_stt() {
        return defect_stt;
    }

    public void setDefect_stt(List<Defect_stt> defect_stt) {
        this.defect_stt = defect_stt;
    }
}
