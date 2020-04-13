package com.example.theaters;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import com.example.theaters.model.Actor;
import com.example.theaters.model.Theater;
import com.example.theaters.service.JSoupActorService;
import com.example.theaters.service.JSoupService;

import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;

public class ActorsActivity extends AppCompatActivity {

    TextView toolbarTextView;
    RecyclerView actorRecyclerView;
    ActorAdapter actorAdapter;
    ArrayList<Actor> actors;
    Theater theater;
    int number;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actors);
        Bundle intent = getIntent().getExtras();
        theater = (Theater)(intent != null ? intent.getSerializable("theater") : null);
        number = (int)(intent != null ? intent.get("number") : -1);

        toolbarTextView = findViewById(R.id.toolbar_text_view);
        actorRecyclerView = findViewById(R.id.actors_recycler_view);

        toolbarTextView.setText(theater.getName());
        ActorsTask task = new ActorsTask();
        task.execute();
    }

    class ActorsTask extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Document document= JSoupService.goToHref(theater.getTroupeUrl());
                switch (number){
                    case 0: actors = JSoupActorService.getTUZTheaterActorsList(document); break;
                    case 1: actors = JSoupActorService.getDramaTheaterActorsList(document); break;
                    case 2: actors = JSoupActorService.getDollTheaterActorsList(document); break;
                }
            }catch (IOException e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            actorAdapter = new ActorAdapter(actors);
            actorRecyclerView.setLayoutManager(new GridLayoutManager(null,2));
            actorRecyclerView.setAdapter(actorAdapter);
        }
    }
}
