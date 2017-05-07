package com.bas.myteam10application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.bas.myteam10application.Adapter.DefectAdapter;
import com.bas.myteam10application.Service.TestDAO;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.EntryXComparator;

import java.util.ArrayList;
import java.util.Collections;

public class Report extends AppCompatActivity {
    private ArrayList<TestDAO> mtestDAO;
    private Intent in;
    private RecyclerView Report;
    private RecyclerView.LayoutManager mLayoutParam;
    private DefectAdapter mDefectAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        in = getIntent();
        mtestDAO = new ArrayList<>();
        mtestDAO = in.getParcelableArrayListExtra("data");

       /* for (int i = 0; i < mtestDAO.size(); i++) {
            Log.d("test", "" + mtestDAO.get(i).getDf_id());
        }*/

        Report = (RecyclerView) findViewById(R.id.Report);
        LineChart lineChart = (LineChart) findViewById(R.id.chart_id);

        Report.setHasFixedSize(true);
        mLayoutParam = new LinearLayoutManager(this);
        Report.setLayoutManager(mLayoutParam);

        mDefectAdapter = new DefectAdapter(Report.this,mtestDAO);
        Report.setAdapter(mDefectAdapter);

        lineChart.setVisibility(View.VISIBLE);
        YAxis leftAxis = lineChart.getAxisLeft();
        leftAxis.setInverted(true);
        leftAxis.setAxisMinimum(0f);

        YAxis rightAxis = lineChart.getAxisRight();
        rightAxis.setEnabled(false);

        Legend l = lineChart.getLegend();
        l.setForm(Legend.LegendForm.LINE);

        lineChart.invalidate();

        ArrayList<Entry> entries = new ArrayList<Entry>();
        int range = 4, count = 8;
        //for (int i = 0; i < count; i++) {
        float xVal = (float) (Math.random() * range);
        float yVal = (float) (Math.random() * range);
        entries.add(new Entry(xVal, yVal));

        float xVal1 = (float) (Math.random() * range);
        float yVal1 = (float) (Math.random() * range);
        entries.add(new Entry(xVal1, yVal1));
        //}

        // sort by x-value
        Collections.sort(entries, new EntryXComparator());

        // create a dataset and give it a type
        LineDataSet set1 = new LineDataSet(entries, "DataSet 1");

        set1.setLineWidth(1.5f);
        set1.setCircleRadius(4f);

        // create a data object with the datasets
        LineData data = new LineData(set1);

        // set data
        lineChart.setData(data);

        init();

    }

    private void init() {
        final ArrayList<ILineDataSet> lineDataSets = new ArrayList<>();

        LineChart lineChart = (LineChart) findViewById(R.id.chart_id);
        lineChart.setVisibility(View.VISIBLE);
        XAxis xl = lineChart.getXAxis();
        //  xl.setAvoidFirstLastClipping(true);
//                    xl.setAxisMinimum(0f);
        xl.setGranularity(1f);
        xl.setValueFormatter(new IAxisValueFormatter() {


            @Override
            public String getFormattedValue(float value, AxisBase axis) {


                Log.d("getFormattedValue: ", String.valueOf(value));
                if (1 == (int)value) {
                    return "ม.ค.";
                }else if(2 == (int)value){
                    return "ก.พ.";
                }else if(3 == (int)value){
                    return "มี.ค.";
                }else if(4 == (int)value){
                    return "เม.ย.";
                }else if(5 == (int)value){
                    return "พ.ค.";
                }else if(6 == (int)value){
                    return "มิ.ย.";
                }else if(7 == (int)value){
                    return "ก.ค.";
                }else if(8 == (int)value){
                    return "ส.ค.";
                }else if(9 == (int)value){
                    return "ก.ย.";
                }else if(10 == (int)value){
                    return "ต.ค.";
                }else if(11 == (int)value){
                    return "พ.ย.";
                } else{
                    return "ธ.ค.";
                }
            }


        });

        YAxis leftAxis = lineChart.getAxisLeft();
        leftAxis.setInverted(true);
        leftAxis.setAxisMinimum(0f);

        YAxis rightAxis = lineChart.getAxisRight();
        rightAxis.setEnabled(false);

        // get the legend (only possible after setting data)
        Legend l = lineChart.getLegend();

        // modify the legend ...
        l.setForm(Legend.LegendForm.LINE);

        // dont forget to refresh the drawing
        lineChart.invalidate();
        // BEGIN SET 1 =============================================
        ArrayList<Entry> entries_set1 = new ArrayList<Entry>();
//float[] a = {1f,2f,3f,4f,5f};
//        float[] b = {1f,2f,3f,4f,5f};
        for (int i = 0; i < mtestDAO.size(); i++) {

        //    float m = Float.parseFloat(mtestDAO.get(i).getDf_id()); ไปเดิมชื่อฟิลเอาเอง ชื่อตัวแปรอ่ะ
        //    float m = Float.parseFloat(mtestDAO.get(i).getDf_id()); ไปเดิมชื่อฟิลเอาเอง ชื่อตัวแปรอ่ะ
        //    entries_set1.add(new Entry(m, sum));
        }

        // sort by x-value
        Collections.sort(entries_set1, new EntryXComparator());

        // create a dataset and give it a type
        LineDataSet set1 = new LineDataSet(entries_set1, "ข้อมูลนำเข้า");

        set1.setLineWidth(1f);
        set1.setCircleRadius(2f);

        // create a data object with the datasets
        LineData data = new LineData(set1);

        // set data
        lineChart.setData(data);

        lineDataSets.add(set1);
    }

}
