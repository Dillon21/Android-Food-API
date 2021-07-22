package com.example.foodsafety;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodsafety.json.business;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class BusinessAdapterView extends RecyclerView.Adapter<BusinessAdapterView.BusinessViewHolder> {

    private Context context;

    private ArrayList<business> businesses;

    public BusinessAdapterView(Context context, ArrayList<business> businesses){
        this.context = context;
        this.businesses = businesses;

    }

    @NonNull
    @NotNull
    @Override
    public BusinessViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View businessView = LayoutInflater.from(context).inflate(R.layout.list_card_view, parent, false);
        BusinessViewHolder viewHolder = new BusinessViewHolder(businessView, this);
        return viewHolder;
    }



    @Override
    public void onBindViewHolder(@NonNull @NotNull BusinessViewHolder holder, int position) {
        business business = this.businesses.get(position);

        TextView tv_rating = holder.BusinessView.findViewById(R.id.tv_businessRating);
        TextView tv_businessName = holder.BusinessView.findViewById(R.id.tv_businessName);

        tv_rating.setText(business.getRating());
        tv_businessName.setText(business.getBusiness_name());

        //tv_businessName.setText(String.valueOf(business.getID()));



    }

    @Override
    public int getItemCount(){
        return businesses.size();
    }

    public class BusinessViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private View BusinessView;
        private BusinessAdapterView adapter;

        public BusinessViewHolder(View BusinessView, BusinessAdapterView adapter){
            super(BusinessView);
            this.BusinessView = BusinessView;
            this.adapter = adapter;
            this.BusinessView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view){
            int position = getAbsoluteAdapterPosition();

            business business = businesses.get(position);




        }
    }
}
