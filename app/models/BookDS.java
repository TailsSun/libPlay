package models;

import java.util.*;
import javax.persistence.*;

import play.db.jpa.*;


@Entity
@Table(name = "book")
public class BookDS extends Model {

    @Column(name = "name")
    public String  name;

    @Column(name = "existence", unique = false, updatable = true)
    public int existence;

    public BookDS(String name){
        this.name = name;
        existence = 1;
    }

        @Override
    public String toString() {
        String s;
        if (existence == 1) {
            s = "В наличии";
        }
        else {
            s = "Отсутствует";
        }
            return " Книга: '" + name + "'   :" + s  + " \n";
    }


}
