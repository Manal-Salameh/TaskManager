package com.example.taskmanager;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class TaskManagerAdapter extends RecyclerView.Adapter<TaskManagerAdapter.MyViewHolder>  {

   Context context;
   ArrayList<MyDoes> myDoes;

   public TaskManagerAdapter (Context c, ArrayList<MyDoes> p) {
       context = c;
       myDoes = p;

   }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup ViewGroup, int viewType) {

       return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_does, ViewGroup, false));
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
       myViewHolder.titledoes.setText(myDoes.get(i).getTitledoes());
       myViewHolder.descdoes.setText(myDoes.get(i).getDescdoes());
       myViewHolder.datedoes.setText(myDoes.get(i).getDatedoes());


       final String getTitleDoes = myDoes.get(i).getTitledoes();
       final String getDescDoes = myDoes.get(i).getDescdoes();
       final String getDateDoes = myDoes.get(i).getDatedoes();
       final String getKeyDoes = myDoes.get(i).getKeydoes();

        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent aa = new Intent(context, EditTaskDesc.class);
               aa.putExtra("titledoes", getTitleDoes);
               aa.putExtra("descdoes", getDescDoes);
               aa.putExtra("datedoes", getDateDoes);
               aa.putExtra("keydoes", getKeyDoes);
               context.startActivity(aa);
           }
       });
    }

    @Override
    public int getItemCount() {
        return myDoes.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

       TextView titledoes, descdoes, datedoes, keydoes;

        public MyViewHolder (@NonNull View itemView) {

            super(itemView);
            titledoes = (TextView) itemView.findViewById(R.id.titledoes);
            descdoes = (TextView) itemView.findViewById(R.id.descdoes);
            datedoes = (TextView) itemView.findViewById(R.id.datedoes);
        }

    }
}
