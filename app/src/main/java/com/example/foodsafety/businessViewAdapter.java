package com.example.foodsafety;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.foodsafety.json.businessesJSON;

import java.util.List;




public class businessViewAdapter extends ArrayAdapter<businessesJSON> {

    private Context context;
    private businessesJSON businesses;

    public businessViewAdapter(@NonNull Context context, int resource, @NonNull List<businessesJSON> objects){

        super(context,resource,objects);
        this.context = context;
        this.businesses= businesses;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent){
        View businessView = convertView;
        if(businessView == null){
            businessView = LayoutInflater.from(this.context).inflate(R.layout.list_card_view,parent, false);
        }

        //business businessTask = this.businesses.get(position);

        TextView tv_businessName = businessView.findViewById(R.id.tv_businessName);
        //tv_businessName.setText(businessTask.);
return null;
    }
}
