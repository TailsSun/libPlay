package models;

import java.util.*;
import javax.persistence.*;

import play.db.jpa.*;

/**
 * Created by DNS on 29.03.2017.
 */
@Entity
public class CardDS extends Model {



    @Column(name = "book", unique = false, updatable = true)
    public String  book;

    @Column(name = "name", unique = false, updatable = true)
    public String name;

    @Column(name = "exchange", unique = false, updatable = true)
    public int exchange;


    public CardDS(String name, String book){

        this.book = book;
        this.name = name;
        exchange = 1;

    }



    @Override
    public String toString() {
        if (exchange == 1){
            return "Книга: " + book + " все ещё на руках у: " + name ;
        }
        else return "Книгу: " + book +  " " + " брал " + name + " но уже вернул обратно" ;
    }
}
