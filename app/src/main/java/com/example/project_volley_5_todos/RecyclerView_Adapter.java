package com.example.project_volley_5_todos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerView_Adapter extends RecyclerView.Adapter<RecyclerView_Adapter.MyClass>
{

    MainActivity mainActivity;
    ArrayList<DataModel> arrayListDataModel;

    public RecyclerView_Adapter(MainActivity mainActivity, ArrayList<DataModel> arrayListDataModel)
    {
        this.mainActivity = mainActivity;
        this.arrayListDataModel = arrayListDataModel;
    }

    public class MyClass extends RecyclerView.ViewHolder
    {
        TextView userId , id , title , completed;

        public MyClass(@NonNull View itemView)
        {
            super(itemView);

            userId = itemView.findViewById(R.id.textViewUserId);
            id = itemView.findViewById(R.id.textViewId);
            title = itemView.findViewById(R.id.textViewTitle);
            completed  = itemView.findViewById(R.id.textViewCompleted);

        }
    }

    @NonNull
    @Override
    public MyClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(mainActivity).inflate(R.layout.recycler_view_image_page , parent , false);

        MyClass M = new MyClass(view);

        return M;
    }

    @Override
    public void onBindViewHolder(@NonNull MyClass holder, int position)
    {
        holder.userId.setText("" + arrayListDataModel.get(position).getUserId());
        holder.id.setText("" + arrayListDataModel.get(position).getId());
        holder.title.setText(arrayListDataModel.get(position).getTitle());
        holder.completed.setText("" + arrayListDataModel.get(position));
    }

    @Override
    public int getItemCount()
    {
        return arrayListDataModel.size();
    }

}
