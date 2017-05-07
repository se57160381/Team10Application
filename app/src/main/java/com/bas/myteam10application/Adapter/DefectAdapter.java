package com.bas.myteam10application.Adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bas.myteam10application.R;
import com.bas.myteam10application.Report;
import com.bas.myteam10application.Service.TestDAO;

import java.util.ArrayList;

/**
 * Created by BassAye on 5/5/2560.
 */

public class DefectAdapter extends RecyclerView.Adapter<DefectAdapter.ViewHolder> {


    private Context mContext;
    private ArrayList<TestDAO> mTestDao;

    public DefectAdapter(Context context, ArrayList<TestDAO> mTestDao) {
        this.mContext = context;
        this.mTestDao = mTestDao;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_list_defect, parent, false);
        ViewHolder holder = new DefectAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.df_1.setText(mTestDao.get(position).getDf_id());
        holder.df_2.setText(mTestDao.get(position).getDf_detected_person());
    }

    @Override
    public int getItemCount() {
        return mTestDao.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView df_1;
        private TextView df_2;
        public ViewHolder(View itemView) {
            super(itemView);
            df_1 = (TextView) itemView.findViewById(R.id.df_1);
            df_2 = (TextView) itemView.findViewById(R.id.df_2);
        }
    }
}
