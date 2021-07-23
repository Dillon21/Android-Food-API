package com.example.foodsafety;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodsafety.json.business;
import com.example.foodsafety.json.businessRepository;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import static androidx.core.content.ContextCompat.startActivity;

public class FavouritesAdapterView extends RecyclerView.Adapter<FavouritesAdapterView.FavouritesViewHolder> {

    private Context context;

    private ArrayList<business> businesses;

    public FavouritesAdapterView(Context context, ArrayList<business> businesses) {
        this.context = context;
        this.businesses = businesses;

    }

    @NonNull
    @NotNull
    @Override
    public FavouritesAdapterView.FavouritesViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View businessView = LayoutInflater.from(context).inflate(R.layout.list_card_view, parent, false);
        FavouritesAdapterView.FavouritesViewHolder viewHolder = new FavouritesAdapterView.FavouritesViewHolder(businessView, this);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull @NotNull FavouritesAdapterView.FavouritesViewHolder holder, int position) {
        business business = this.businesses.get(position);
        //takes business from arrayList and inserts values into single cardview
        TextView tv_rating = holder.BusinessView.findViewById(R.id.tv_businessRating);
        TextView tv_businessName = holder.BusinessView.findViewById(R.id.tv_businessName);
        TextView tv_lat = holder.BusinessView.findViewById(R.id.tv_latitude);
        TextView tv_lon = holder.BusinessView.findViewById(R.id.tv_longitude);
        TextView tv_ID = holder.BusinessView.findViewById(R.id.tv_ID);

        tv_rating.setText(business.getRating());
        tv_businessName.setText(business.getBusiness_name());
        tv_lat.setText(business.getLatitude());
        tv_lon.setText(business.getLongitude());

        String ID = String.valueOf(business.getID());
        tv_ID.setText(ID);

        //sets text of delete button
        Button delete = holder.BusinessView.findViewById(R.id.btn_favourite);
        delete.setText("Delete");

        //sets text of map button
        Button map = holder.BusinessView.findViewById(R.id.btn_location);
        map.setText("Map");

    }

    @Override
    public int getItemCount() { return businesses.size();
    }

    public class FavouritesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private View BusinessView;
        private FavouritesAdapterView adapter;
        public TextView lat;
        public TextView lon;
        public TextView ID;
        public TextView Name;
        public TextView rating;

        //initialises view holder
        public FavouritesViewHolder(View BusinessView, FavouritesAdapterView adapter) {
            super(BusinessView);
            this.BusinessView = BusinessView;
            this.adapter = adapter;
            this.BusinessView.setOnClickListener(this);

            //onclicklistener for map button
            BusinessView.findViewById(R.id.btn_location).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    lat = itemView.findViewById(R.id.tv_latitude);
                    lon = itemView.findViewById(R.id.tv_longitude);

                    String Lat = (String) lat.getText();
                    String Lon = (String) lon.getText();

                    //intent to start open google maps activity
                    String cordinates = "geo:" + Lat + "," + Lon + "?z=20&q=restaurants";
                    Log.d("cordds", cordinates);
                    Uri mapsUri = Uri.parse(cordinates);
                    Intent mapIntent = new Intent(Intent.ACTION_VIEW, mapsUri);
                    mapIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    mapIntent.setPackage("com.google.android.apps.maps");
                    startActivity(context, mapIntent, null);

                }
            });

            BusinessView.findViewById(R.id.btn_favourite).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //reference card components to get values for repository manipulation
                    lat = itemView.findViewById(R.id.tv_latitude);
                    lon = itemView.findViewById(R.id.tv_longitude);
                    ID = itemView.findViewById(R.id.tv_ID);
                    Name = itemView.findViewById(R.id.tv_businessName);
                    rating = itemView.findViewById(R.id.tv_businessRating);

                    String Lat = (String) lat.getText();
                    String Lon = (String) lon.getText();


                    business business = new business();
                    business.setID(Integer.valueOf((String) ID.getText()));
                    business.setBusiness_name((String) Name.getText());
                    business.setRating((String) rating.getText());
                    business.setLatitude((String) lat.getText());
                    business.setLongitude((String) lon.getText());

                    Log.d("favTest", business.getBusiness_name());

                    //removes business from the database
                    //ONLY UPDATES ON RESTART OF ACTIVITY
                    businessRepository.getRepository(context).deleteBusiness(business);
                    adapter.notifyDataSetChanged();
                }
            });


        }

        @Override
        public void onClick(View v) {

        }
    }
}
