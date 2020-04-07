package com.example.theaters;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.theaters.model.Theater;

public class MainActivity extends AppCompatActivity {

    String[] theaterName;
    String[] theaterAddress;
    String[] theaterVk;
    String[] theaterSite;
    String[] theaterTel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void CardClick(View view) {
        theaterName = getResources().getStringArray(R.array.theater_names);
        theaterAddress = getResources().getStringArray(R.array.theater_address);
        theaterVk = getResources().getStringArray(R.array.theater_vk);
        theaterSite = getResources().getStringArray(R.array.theater_site);
        theaterTel = getResources().getStringArray(R.array.theater_tel);

        Theater theater = new Theater();

       /* Intent intent = new Intent(getApplicationContext(), TheaterActivity.class);
        startActivity(intent);

        int number = (view.getId()==R.id.theaterTUZ)? 0: (view.getId()==R.id.theaterDrama)?1:2;
        //создание элемента Theater theater с помощью конструктора
        int id = (number==0)?R.drawable.spas:(number==1)? R.drawable.dram:R.drawable.dol;
        theater.setImageId(id);
        intent.putExtra("theater", theater);*/
        int number = (view.getId() == R.id.theaterTUZ) ? 0 : (view.getId()==R.id.theaterDrama) ? 1 : 2;
        //СЃРѕР·РґР°РЅРёРµ СЌР»РµРјРµРЅС‚Р° Theater theater СЃ РїРѕРјРѕС‰СЊСЋ РєРѕРЅСЃС‚СЂСѓРєС‚РѕСЂР°
        int imageId = (number == 0) ? R.drawable.spas : (number==1) ? R.drawable.dram : R.drawable.dol;
        theater.setImageId(imageId);
        theater.setName(theaterName[number]);
        theater.setVk(theaterVk[number]);
        theater.setSite(theaterSite[number]);
        theater.setTel(theaterTel[number]);
        theater.setAddress(theaterAddress[number]);

        Intent intent = new Intent(getApplicationContext(),TheaterActivity.class);
        intent.putExtra("theater", theater);
        startActivity(intent);

    }

}
