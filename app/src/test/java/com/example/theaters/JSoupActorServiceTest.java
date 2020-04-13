package com.example.theaters;

import com.example.theaters.model.Actor;
import com.example.theaters.service.JSoupActorService;
import com.example.theaters.service.JSoupService;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class JSoupActorServiceTest {
    @Test
    public void test_method_getDollTheaterActorsList() {
        try {
            ArrayList<Actor> actorArrayList = new ArrayList<>();
            actorArrayList = JSoupActorService.getDollTheaterActorsList(JSoupActorService.goToHref("http://kirovkukla.ru/truppa"));
            Actor actor1 = new Actor();
            Actor actor2 = new Actor();
            Actor actor3 = new Actor();
            actor1.setName("Красильникова Наталия Викторовна");
            actor1.setImgUrl("http://kirovkukla.ru/assets/template/upload_img/Красильникова%20Для%20стенда.jpg");
            actor2.setName("Евдокимов Юрий Анатольевич");
            actor2.setImgUrl("http://kirovkukla.ru/assets/template/upload_img/Евдокимов%20ГОТОВО.jpg");
            actor3.setName("Мазик Надежда Андреевна");
            actor3.setImgUrl("http://kirovkukla.ru/assets/template/upload_img/Мазик.jpg");
            assertEquals(actorArrayList.get(0).getName(), actor1.getName());
            assertEquals(actorArrayList.get(0).getImgUrl(), actor1.getImgUrl());
            assertEquals(actorArrayList.get(1).getName(), actor2.getName());
            assertEquals(actorArrayList.get(1).getImgUrl(), actor2.getImgUrl());
            assertEquals(actorArrayList.get(2).getName(), actor3.getName());
            assertEquals(actorArrayList.get(2).getImgUrl(), actor3.getImgUrl());
        }catch (IOException e){
            assertEquals(true, false);
        }

    }

    @Test
    public void test_method_getDramaTheaterActorsList() {
        try {
            ArrayList<Actor> actorArrayList = new ArrayList<>();
            actorArrayList = JSoupActorService.getDramaTheaterActorsList(JSoupActorService.goToHref("https://kirovdramteatr.ru/truppa/"));
            Actor actor1 = new Actor();
            Actor actor2 = new Actor();
            Actor actor3 = new Actor();
            actor1.setName("Исаева Наталья Николаевна");
            actor1.setImgUrl("https://kirovdramteatr.ru/media/person/1_2aa5e14cc959d41c199ed56aa804b9.jpg");
            actor2.setName("Смирнов Владимир Александрович");
            actor2.setImgUrl("https://kirovdramteatr.ru/media/person/2_5be891a0100154144cce7ed6a5e966.jpg");
            actor3.setName("Золотарёва Светлана Леонидовна");
            actor3.setImgUrl("https://kirovdramteatr.ru/media/person/3_c7ff3381126de8e4ef07471b92e9d4.jpg");
            assertEquals(actorArrayList.get(0).getName(), actor1.getName());
            assertEquals(actorArrayList.get(0).getImgUrl(), actor1.getImgUrl());
            assertEquals(actorArrayList.get(1).getName(), actor2.getName());
            assertEquals(actorArrayList.get(1).getImgUrl(), actor2.getImgUrl());
            assertEquals(actorArrayList.get(2).getName(), actor3.getName());
            assertEquals(actorArrayList.get(2).getImgUrl(), actor3.getImgUrl());
        }catch (IOException e){
            assertEquals(true, false);
        }
    }

    @Test
    public void test_method_getTUZTheaterActorsList() {
        try {
            ArrayList<Actor> actorArrayList;
            actorArrayList = JSoupActorService.getTUZTheaterActorsList(JSoupActorService.goToHref("https://ekvus-kirov.ru/truppa/"));
            Actor actor1 = new Actor();
            Actor actor2 = new Actor();
            Actor actor3 = new Actor();
            actor1.setName("Анатолий Свинцов");
            actor1.setImgUrl("https://ekvus-kirov.ru/media/user/avatar/normal/68_6134b42ed045eb318a02cddfd823c4.jpg");
            actor2.setName("Татьяна Махнёва");
            actor2.setImgUrl("https://ekvus-kirov.ru/media/user/avatar/normal/108_913c4ba26656f8fb8a4c16e12ade03.jpg");
            actor3.setName("Александр Королевский");
            actor3.setImgUrl("https://ekvus-kirov.ru/media/user/avatar/normal/109_ea05a8456f0ae0a96238a381a0e8ed.jpg");
            assertEquals(actorArrayList.get(0).getName(), actor1.getName());
            assertEquals(actorArrayList.get(0).getImgUrl(), actor1.getImgUrl());
            assertEquals(actorArrayList.get(1).getName(), actor2.getName());
            assertEquals(actorArrayList.get(1).getImgUrl(), actor2.getImgUrl());
            assertEquals(actorArrayList.get(2).getName(), actor3.getName());
            assertEquals(actorArrayList.get(2).getImgUrl(), actor3.getImgUrl());
        }catch (IOException e){
            assertEquals(true, false);
        }
    }

}
