package com.bas.myteam10application.Service;

import com.bas.myteam10application.Service.DAO.DefectDao;

import java.util.List;

/**
 * Created by BassAye on 13/5/2560.
 */


public class Defect_stt_DAO {

    private List<Defect_stt> defect_stt;

    public List<Defect_stt> getDefect_stt() {
        return defect_stt;
    }

    public void setDefect_stt(List<Defect_stt> defect) {
        this.defect_stt = defect;
    }

    public static class Defect_stt {


        private String dfs_id;
        private String dfs_code;
        private String dfs_th_name;
        private String dfs_en_name;

        public String getDfs_description() {
            return dfs_description;
        }

        public void setDfs_description(String dfs_description) {
            this.dfs_description = dfs_description;
        }

        public String getDfs_id() {
            return dfs_id;
        }

        public void setDfs_id(String dfs_id) {
            this.dfs_id = dfs_id;
        }

        public String getDfs_code() {
            return dfs_code;
        }

        public void setDfs_code(String dfs_code) {
            this.dfs_code = dfs_code;
        }

        public String getDfs_th_name() {
            return dfs_th_name;
        }

        public void setDfs_th_name(String dfs_th_name) {
            this.dfs_th_name = dfs_th_name;
        }

        public String getDfs_en_name() {
            return dfs_en_name;
        }

        public void setDfs_en_name(String dfs_en_name) {
            this.dfs_en_name = dfs_en_name;
        }

        private String dfs_description;

    }
}
