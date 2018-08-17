package com.example.android.employeesmanagementsoftware;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


/*
made by menna
 */
public class TasksAdapter extends RecyclerView.Adapter<TasksAdapter.TasksViewHolder> {

    private Context context;
    private ArrayList<Tasks> data;
    private String title;
    private String date;
    private String trainer;
    private String description;
    private  String deadline;
    private  Long id;


    public TasksAdapter(Context context, ArrayList<Tasks> data)
    {
        this.context=context;
        this.data=data;
    }



    @Override
    public TasksViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        LayoutInflater layoutInflater= LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.tasks_layout,parent,false);
        return new TasksViewHolder(view);
    }

    //show each task in recycle list
    @Override
    public void onBindViewHolder(TasksViewHolder holder, int position)
    {
        final Tasks tasks = data.get(position);
        holder.titletask.setText(tasks.getTaskName());
        holder.disctask.setText(tasks.getTaskDetails());
        holder.trainertask.setText(tasks.getTaskInstractor());
        holder.datetask.setText(tasks.getTaskDate());
        holder.deadlinetask.setText(tasks.getTaskDeadline());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
               // title = tasks.getTaskName();
                //date = tasks.getTaskDate();
                //trainer = tasks.getTaskInstractor();
                //description=tasks.getTaskDetails();
                //deadline=tasks.getTaskDeadline();
                id = tasks.getId();
                Bundle bundle=new Bundle();
               // bundle.putString("title",title);
               // bundle.putString("date",date);
                //bundle.putString("trainer",trainer);
                //bundle.putString("description",description);
                //bundle.putString("deadline",deadline);
                bundle.putString("id",id.toString());
                Intent in = new Intent(context, TaskActivity.class);
                in.putExtra("bundle", bundle);
                context.startActivity(in);



            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }



    public class TasksViewHolder extends RecyclerView.ViewHolder {
        TextView titletask;
        TextView disctask;
        TextView trainertask;
        TextView datetask;
        TextView deadlinetask;
        public TasksViewHolder(View itemView)
        {
            super(itemView);
            titletask = (TextView)itemView.findViewById(R.id.title_card);
            disctask = (TextView)itemView.findViewById(R.id.disc_card);
            trainertask=(TextView)itemView.findViewById(R.id.employee);
            datetask=(TextView)itemView.findViewById(R.id.date);
            deadlinetask=(TextView)itemView.findViewById(R.id.deadline);
        }
    }


}
