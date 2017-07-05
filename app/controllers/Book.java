package controllers;

import models.BookDS;
import models.CardDS;
import models.UserDS;
import play.data.validation.Required;
import play.mvc.Controller;

import static controllers.Application.index;


public class Book extends Controller {

    public static void getBook(String name, String book) {
        UserDS userDS = UserDS.find("name", name).first();
        BookDS bookDS = BookDS.find("name", book).first();
        if (userDS == null) {
            flash.error("Такого читателя не существует");
            index();
        }
        if (bookDS == null) {
            flash.error("Такой книги нет в библиотеке");
            index();
        }
        if (bookDS.existence == 0) {
            flash.error("Книга уже на руках");
            index();
        } else {
            bookDS.existence = 0;
            bookDS.save();
            new CardDS(name, book).save();
            flash.success("вы успешно взяли книгу");
            index();
        }

    }

    public static void returnBook(@Required String name, @Required String book) {
        if (validation.hasErrors()) {
            flash.error("Поля не могут быть пустым");
            index();
        }
        UserDS userDS = UserDS.find("name", name).first();
        BookDS bookDS = BookDS.find("name", book).first();
        if (userDS == null) {
            flash.error("Такого читателя не существует");
            index();
        }
        if (bookDS == null) {
            flash.error("Такой книги нет в библиотеке");
            index();
        }
        if (bookDS.existence == 1) {
            flash.error("Книга уже в библиотеке, зачем вы принесли мне дупликат?");
            index();
        }else {
            bookDS.existence = 1;
            bookDS.save();
            CardDS cardDS = CardDS.find("book", book).first();
            cardDS.find("name", name);
            cardDS.find("exchange" , 1);
            cardDS.exchange = 0;
            cardDS.save();
            flash.success("вы успешно вернули книгу");
            index();
        }

    }

}