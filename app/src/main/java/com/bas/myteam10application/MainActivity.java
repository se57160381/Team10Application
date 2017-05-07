package com.bas.myteam10application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


import com.bas.myteam10application.Service.DAO.Defect;
import com.bas.myteam10application.Service.DAO.Select;
import com.bas.myteam10application.Service.Service;
import com.bas.myteam10application.Service.TestDAO;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private Button bLogin;
    private Service service;
    private TestDAO testDAO;
    private ArrayList<TestDAO> mtestDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bLogin = (Button) findViewById(R.id.bLogin);



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.51.4.17")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(Service.class);

        mtestDAO = new ArrayList<>();

        service.select_defect().enqueue(new Callback<Select>() {
            @Override
            public void onResponse(Call<Select> call, Response<Select> response) {

                Log.d("RNUS1", response.body().getDefect().get(2).getDfDescription());
                Log.d("GAME1", response.body().getDefect().get(0).getDfId());

                for (int i = 0; i < response.body().getDefect().size(); i++) {
                    testDAO = new TestDAO();
                    testDAO.setDf_id(response.body().getDefect().get(i).getDfId());
                    testDAO.setDf_detected_person(response.body().getDefect().get(i).getDfDetectedPerson());
                    mtestDAO.add(testDAO);
                }

            }

            @Override
            public void onFailure(Call<Select> call, Throwable t) {

            }
        });
        bLogin.setOnClickListener(onClickLoginListener);
    }

    private View.OnClickListener onClickLoginListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), Report.class);

            intent.putExtra("data", mtestDAO);
            startActivity(intent);
        }
    };

}
