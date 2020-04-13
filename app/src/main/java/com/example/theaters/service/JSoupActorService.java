package com.example.theaters.service;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.theaters.model.Actor;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class JSoupActorService extends JSoupService {

    public static ArrayList<Actor> getDollTheaterActorsList(Document doc) {
        ArrayList<Actor> actors = new ArrayList<>();

        Elements elementsImage = doc.select("img");
        elementsImage.remove(0);
        elementsImage.remove(0);
        ArrayList<String> urlImageList = new ArrayList<>();
        for (Element elementImage: elementsImage) {
            urlImageList.add("http://kirovkukla.ru"+elementImage.attr("src"));
        }
        try{
            String text = doc.selectFirst("span[style=font-family: Arial, Helvetica, sans-serif;]").text();
            String[] names = text.trim().replace(",", "").split(" ");
            names[0] = names[0].substring(0, 1) + names[0].substring(1).toLowerCase();
            Actor actor = new Actor();
            actor.setName(names[0] + " " + names[1] + " " + names[2]);
            actor.setImgUrl(urlImageList.get(0));
            actors.add(actor);
        }catch (Exception e){
            e.printStackTrace();
        }
        int i = 1;
        Elements elements = doc.select("span[style=font-size: 28px;]");
        for (Element element: elements){
            String text = element.text();
            if(text.length() > 3){
                try {
                    String[] names = text.trim().replace(",", "").split(" ");
                    names[0] = names[0].substring(0, 1) + names[0].substring(1).toLowerCase();
                    Actor actor = new Actor();
                    actor.setName(names[0] + " " + names[1] + " " + names[2]);
                    actor.setImgUrl(urlImageList.get(i));
                    actors.add(actor);
                    i++;
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        return actors;
    }

    public static ArrayList<Actor> getDramaTheaterActorsList(Document doc) {
        ArrayList<Actor> actors = new ArrayList<>();
        Elements elements = doc.selectFirst("div.t_person_list").select("img");
        for (Element element: elements) {
            Actor actor = new Actor();
            actor.setName(element.attr("alt"));
            actor.setImgUrl("https://kirovdramteatr.ru"+element.attr("src"));
            actors.add(actor);
        }
        return actors;
    }

    public static ArrayList<Actor> getTUZTheaterActorsList(Document doc) {
        ArrayList<Actor> actors = new ArrayList<>();
        Elements elements = doc.selectFirst("div.t_user").select("div[class~=td[0-9]+]");
        for (Element element: elements) {
            Actor actor = new Actor();
            Elements elementsP = element.select("p");
            actor.setImgUrl("https://ekvus-kirov.ru"+elementsP.get(0).selectFirst("a").selectFirst("img").attr("src"));
            actor.setName(elementsP.get(1).selectFirst("a").text());
            actors.add(actor);
        }
        return actors;
    }

}
