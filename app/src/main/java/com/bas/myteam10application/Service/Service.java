package com.bas.myteam10application.Service;


import com.bas.myteam10application.Service.DAO.Select;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by BassAye on 26/4/2560.
 */

public interface Service {
    @GET("/TSP57/ISERL/application/views/stm/test_report/service1.php")
    Call<Select> select_defect();
}
