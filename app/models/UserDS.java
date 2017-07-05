package models;

import java.util.*;
import javax.persistence.*;

import play.db.jpa.*;

/**
 * Created by DNS on 29.03.2017.
 */
@Entity
public class UserDS extends Model {

    @Column(name = "name", unique = true, updatable = false)
    public String name;
    public int existence;

    public UserDS(String name, int existence){
        this.name = name;
        this.existence = existence;
    }

    @Override
    public String toString() {
        return name;
    }
}
