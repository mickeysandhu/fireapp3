package com.example.fireapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;

import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.List;

public class adapter extends RecyclerView.Adapter<adapter.ViewHolder> {

     Context context;
    List<detail> mdatalist;

    public adapter(Context context, List<detail> mdatalist) {
        this.context = context;
        this.mdatalist = mdatalist;
    }

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.activity_user_list , parent , false) );

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        detail detail  = mdatalist.get(position);
holder.userName.setText(detail.getName());
        holder.userName.setText(detail.getName());
        holder.money.setText(String.valueOf(detail.getPaisa()));
        holder.coffeeName.setText(detail.getCoffeeType());
        holder.coffeeSize.setText(detail.getSize());
        holder.date.setText(detail.getDate());

    }

    @Override
    public int getItemCount() {
        return mdatalist.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{
        TextView userName, money, coffeeSize, coffeeName,  date;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            userName= itemView.findViewById(R.id.user_name);
            money= itemView.findViewById(R.id.coffee_money);
            coffeeName= itemView.findViewById(R.id.coffee_name);
            coffeeSize= itemView.findViewById(R.id.coffee_size);
            date= itemView.findViewById(R.id.Ldate);


        }
    }
}
