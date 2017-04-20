package com.bas.myteam10application;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

public class Project extends AppCompatActivity {

    private ListView jsonListview;
    private ArrayList<String> exData;
    private ProgressDialog progressDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);


        jsonListview = (ListView) findViewById(R.id.Project);

        exData = new ArrayList<String>();
//        exData.add("Test1");
//        exData.add("Test2");
//        exData.add("Test3");
//        exData.add("Test4");
//        exData.add("Test5");

        new AsyncTask<Void, Void, Void>() {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                progressDialog = new ProgressDialog(Project.this);
                progressDialog.setCancelable(false);
                progressDialog.setMessage("Downlodind ...");
                progressDialog.show();
            }

            @Override
            protected Void doInBackground(Void... params) {
                try {
                    URL url = new URL("http://thaicfp.com/webservices/json-example.php");

                    URLConnection urlConnection = url.openConnection();

                    HttpsURLConnection httpsURLConnection = (HttpsURLConnection)urlConnection;
                    httpsURLConnection.setAllowUserInteraction(false);
                    httpsURLConnection.setInstanceFollowRedirects(true);
                    httpsURLConnection.setRequestMethod("GET");
                    httpsURLConnection.connect();

                    InputStream inputStream = null;

                    if(httpsURLConnection.getResponseCode()== HttpURLConnection.HTTP_OK)
                        inputStream= httpsURLConnection.getInputStream();

                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"),8);

                    StringBuilder stringBuilder =new StringBuilder();
                    String line = null;

                    while ((line=reader.readLine()) !=null ){
                        stringBuilder.append(line + "\n");
                    }
                    inputStream.close();
                    Log.d("JSON Result", stringBuilder.toString());


                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                progressDialog.dismiss();
            }
        }.execute();

        ArrayAdapter<String>myAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, exData);
        jsonListview.setAdapter(myAdapter);
    }
}
