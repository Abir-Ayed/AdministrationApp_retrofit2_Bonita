package com.example.appretrofit;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appretrofit.Model.Processus;
import com.example.appretrofit.Model.RecycleViewOnItemClick;

import java.util.ArrayList;
import java.util.List;
    public  class AdapterDashboard extends RecyclerView.Adapter<AdapterDashboard.viewHolder> {
        public List<Processus> process = new ArrayList<>();
        public Context context;

       public static RecycleViewOnItemClick recycleViewOnItemClick;


        public AdapterDashboard(Context context, List<Processus> process) {
            this.context = context;
            this.recycleViewOnItemClick = recycleViewOnItemClick;
            this.process = process;
        }

        // data is passed into the constructor
      /*  public AdapterDashboard(Context context, List<Processus> process) {
            this.process = process;
            this.context=context;
        }*/
        public void setListProcess(List<Processus> process)
        { this.process=new ArrayList<>(process);
            notifyDataSetChanged();
        }

        @NonNull
        @Override
        public viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
            //LayoutInflater inflater = LayoutInflater.from(context);
            View view= LayoutInflater.from(context).inflate(R.layout.activity_process,viewGroup,false);
            return new viewHolder(view);
        }



        @Override
        public void onBindViewHolder(@NonNull viewHolder holder, int position) {
            holder.proc.setText(process.get(position).getDisplayName());
            holder.proc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(context,ActivityProcess.class);
                    i.putExtra("id",process.get(position).getId());
                    context.startActivity(i);
                }
            });
        }
        @Override
        public int getItemCount() {
            return process.size();
        }
        @Override
        public void registerAdapterDataObserver(@NonNull RecyclerView.AdapterDataObserver observer) {
            super.registerAdapterDataObserver(observer);
        }
        @Override
        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
            super.onAttachedToRecyclerView(recyclerView);
        }
        // stores and recycles views as they are scrolled off screen
        public static class viewHolder extends RecyclerView.ViewHolder  {
            TextView proc;


            public   viewHolder(@NonNull View itemView) {
                super(itemView);
                proc = (TextView) itemView.findViewById(R.id.proc);

                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        recycleViewOnItemClick.onItemClick(getAdapterPosition());
                    }
                });



            }


        }




    }

