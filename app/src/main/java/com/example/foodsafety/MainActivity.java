package com.example.foodsafety;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    Button buttonAberdeen;
    Button buttonGlasgow;
    Button buttonDundee;
    Button buttonEdinburgh;
    Button buttonFavourites;
    TextView lastAccessed;
    public static final String EXTRA = "EXTRA";


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAberdeen = (Button)findViewById(R.id.btn_Aberdeen);
        buttonGlasgow = (Button)findViewById(R.id.btn_Glasgow);
        buttonDundee = (Button)findViewById(R.id.btn_dundee);
        buttonEdinburgh = (Button)findViewById(R.id.btn_Edinburgh);
        buttonFavourites = (Button)findViewById(R.id.btn_fav);
        lastAccessed = findViewById(R.id.tv_last_access);

        //called if Aberdeen button is pressed
        buttonAberdeen.setOnClickListener((new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String message ="/^/^/rating/1/760/pass/1/1/1500/json";
                Intent intent = new Intent(view.getContext(),DisplayBusinessActivity.class);
                intent.putExtra(EXTRA,message);
                startActivity(intent);
            }
        }));
        //called if Glasgow button is pressed
        buttonGlasgow.setOnClickListener((new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String message ="/^/^/rating/1/776/pass/1/1/1500/json";
                Intent intent = new Intent(view.getContext(),DisplayBusinessActivity.class);
                intent.putExtra(EXTRA,message);
                startActivity(intent);
            }
        }));

        //called if dundee button is pressed
        buttonDundee.setOnClickListener((new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String message ="/^/^/rating/1/772/pass/1/1/1500/json";
                Intent intent = new Intent(view.getContext(),DisplayBusinessActivity.class);
                intent.putExtra(EXTRA,message);
                startActivity(intent);
            }
        }));

        //called if Edinburgh button is pressed
        buttonEdinburgh.setOnClickListener((new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String message ="/^/^/rating/1/773/pass/1/1/1500/json";
                Intent intent = new Intent(view.getContext(),DisplayBusinessActivity.class);
                intent.putExtra(EXTRA,message);
                startActivity(intent);
            }
        }));

        buttonFavourites.setOnClickListener((new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(view.getContext(),FavouriteBusinessesActivity.class);
                startActivity(intent);
            }
        }));


    }

    //stores time of last access when app is paused or destroyed
    protected void onPause(){
        super.onPause();

        SharedPreferences pref = getSharedPreferences("sharedPref", MODE_PRIVATE);
        SharedPreferences.Editor edit = pref.edit();

        String timeStamp = new SimpleDateFormat("MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
        Log.d("date", timeStamp);
        edit.putString("date", timeStamp.toString());
        edit.commit();

    }

    //inserts time of last access when app is restarted
    protected void onResume(){
        super.onResume();
        SharedPreferences pref = getSharedPreferences("sharedPref", MODE_PRIVATE);

        String date = pref.getString("date", "");
        Log.d("dateLoad", date);
        lastAccessed = findViewById(R.id.tv_last_access);
        lastAccessed.setText("Last Accessed: " + date);
    }

}


