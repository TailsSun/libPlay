package controllers;

import play.*;

import play.data.validation.Required;
import play.mvc.*;

import java.util.*;

import models.*;


public class Application extends Controller {

    public static void index() {
        render();
    }
    public static void sayHello(@Required String name) {
        if(validation.hasErrors()) {
            flash.error("Имя читателя не может быть пустым");
            index();
        }
        UserDS getName = UserDS.find("name",name).first();
        if (getName != null && getName.name.equals(name)){
            flash.error("пользователь " + name + " существует");
           index();
        }else {
            new UserDS(name, 1).save();
            render(name);
        }
    }
    public static void printUsers(){
        List<UserDS> user = UserDS.findAll();
        render(user);
    }
    public static void addBook(@Required String name) {
        if(validation.hasErrors()) {
            flash.error("Название книги не может быть пустым");
            index();
        }
        BookDS getNameBook = BookDS.find("name", name).first();

        if(getNameBook != null && getNameBook.name.equals(name)){
            flash.error("книга " + name + " уже добавлена в библиотеку");
            index();
        }else {
            new BookDS(name).save();
            render(name);
        }
    }
    public static void printBooks(){
        List<BookDS> books = BookDS.findAll();
        render(books);
    }

}