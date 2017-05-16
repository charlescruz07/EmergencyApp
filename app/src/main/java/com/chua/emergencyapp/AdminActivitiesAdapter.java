package com.chua.emergencyapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Acer on 14/05/2017.
 */

public class AdminActivitiesAdapter extends RecyclerView.Adapter<AdminActivitiesAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Posts> postArray;

    public AdminActivitiesAdapter(Context context, ArrayList<Posts> postArray) {
        this.context = context;
        this.postArray = postArray;
    }

    @Override
    public AdminActivitiesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_layout,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(AdminActivitiesAdapter.ViewHolder holder, int position) {
        holder.activityTitle.setText(postArray.get(position).getTitle());
        holder.activityDesc.setText(postArray.get(position).getDescription());
        holder.activityDate.setText(postArray.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return postArray.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView activityTitle, activityDesc, activityDate;

        public ViewHolder(final View itemView) {
            super(itemView);
            activityTitle = (TextView) itemView.findViewById(R.id.activityTitle);
            activityDesc = (TextView) itemView.findViewById(R.id.activityDesc);
            activityDate = (TextView) itemView.findViewById(R.id.activityDate);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("bernard",postArray.get(getAdapterPosition()).getuId());
                    context.startActivity(new Intent(context,PostDetailsActivity.class).putExtra("key",postArray.get(getAdapterPosition()).getuId()));
                }
            });
        }
    }
}
