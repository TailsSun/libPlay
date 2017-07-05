package controllers;


import models.CardDS;
import play.data.validation.Required;
import play.mvc.Controller;

import java.util.List;

import static controllers.Application.index;


public class Card extends Controller {

    public static void printCard(@Required String name) {
        if(validation.hasErrors()) {
            flash.error("Название книги не может быть пустым!!!");
            index();
        }
        List<CardDS> userList = CardDS.find("book", name).fetch();
        String users = userList.toString();

        render(users);
    }

    public static void printUsers(@Required String name) {
        if(validation.hasErrors()) {
            flash.error("Имя читателя не может быть пустым!!!");
            index();
        }
        List<CardDS> userList = CardDS.find("name", name).fetch();
        String users = userList.toString();

        render(users);
    }
    public static void printAllUsers() {

        List<CardDS> cardDSList = CardDS.findAll();

        render(cardDSList);
    }
}


