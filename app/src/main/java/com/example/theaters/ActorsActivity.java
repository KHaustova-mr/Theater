package com.example.theaters;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.theaters.model.Actor;
import com.example.theaters.model.Theater;

import java.util.ArrayList;

public class ActorsActivity extends AppCompatActivity {

    TextView toolbarTextView;
    RecyclerView actorRecyclerView;
    ActorAdapter actorAdapter;
    ArrayList<Actor> actors;
    Theater theater;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actors);
        Bundle intent = getIntent().getExtras();
        theater = (Theater)(intent != null ? intent.getSerializable("theater") : null);

        //test data//

        actors = new ArrayList<>();

        Actor actor1 = new Actor();
        Actor actor2 = new Actor();
        Actor actor3 = new Actor();
        Actor actor4 = new Actor();

        actor1.setName("Анатолий Свинцов");
        actor1.setImgUrl("https://ekvus-kirov.ru/media/user/avatar/normal/68_6134b42ed045eb318a02cddfd823c4.jpg");
        actors.add(actor1);
        actor2.setName("Татьяна Махнёва");
        actor2.setImgUrl("https://ekvus-kirov.ru/media/user/avatar/normal/108_913c4ba26656f8fb8a4c16e12ade03.jpg");
        actors.add(actor2);
        actor3.setName("Александр Королевский");
        actor3.setImgUrl("https://ekvus-kirov.ru/media/user/avatar/normal/109_ea05a8456f0ae0a96238a381a0e8ed.jpg");
        actors.add(actor3);
        actor4.setName("Михаил Андрианов");
        actor4.setImgUrl("https://ekvus-kirov.ru/media/user/avatar/normal/117_dce649b9e43b5bc4cd0109c059492b.jpg");
        actors.add(actor4);

        //end test data//


        toolbarTextView = findViewById(R.id.toolbar_text_view);
        actorRecyclerView = findViewById(R.id.actors_recycler_view);

        toolbarTextView.setText(theater.getName());

        actorAdapter = new ActorAdapter(actors);
        actorRecyclerView.setLayoutManager(new GridLayoutManager(this,2));
        actorRecyclerView.setAdapter(actorAdapter);



    }
}
