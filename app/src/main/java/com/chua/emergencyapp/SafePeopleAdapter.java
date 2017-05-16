package com.chua.emergencyapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by Acer on 16/05/2017.
 */

public class SafePeopleAdapter extends RecyclerView.Adapter<SafePeopleAdapter.ViewHolder> {

    private Context context;
    private ArrayList<SafePeople> safePeopleList;

    public SafePeopleAdapter(Context context, ArrayList<SafePeople> safePeopleList) {
        this.context = context;
        this.safePeopleList = safePeopleList;
    }

    @Override
    public SafePeopleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.safe_people_layout,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(SafePeopleAdapter.ViewHolder holder, int position) {
        Glide.with(context).load(safePeopleList.get(position).getUserPic()).into(holder.safePic);
        holder.safeName.setText(safePeopleList.get(position).getUserName());
    }

    @Override
    public int getItemCount() {
        return safePeopleList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView safePic;
        private TextView safeName;

        public ViewHolder(final View itemView) {
            super(itemView);

            safePic = (ImageView) itemView.findViewById(R.id.safePic);
            safeName = (TextView) itemView.findViewById(R.id.safeName);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    context.startActivity(new Intent(context,ClassDetailsActivity.class).putExtra("key",subjectPrimaryKeys.get(getAdapterPosition())));
                }
            });
        }
    }
}
