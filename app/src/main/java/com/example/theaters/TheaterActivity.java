package com.example.theaters;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.theaters.model.Theater;

public class TheaterActivity extends AppCompatActivity {
    private Theater theater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theater2);
        Bundle intent = getIntent().getExtras();
        //theater = (Theater) intent.getSerializable("theater");
        theater = (Theater)(intent != null ? intent.getSerializable("theater") : null);

        ((ImageView)findViewById(R.id.theater_image_view_details)).setImageResource(theater.getImageId());
        ((TextView)findViewById(R.id.theater_name_text_view_details)).setText(theater.getName());
        ((TextView)findViewById(R.id.theater_address_text_view)).setText(theater.getAddress());
        ((TextView)findViewById(R.id.theater_site_text_view)).setText(theater.getSite());
        ((TextView)findViewById(R.id.theater_vk_text_view)).setText(theater.getVk());
        ((TextView)findViewById(R.id.theater_tel_text_view)).setText(theater.getTel());


    }
}
