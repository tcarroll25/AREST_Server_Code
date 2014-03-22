package models;

import java.util.*;
import play.data.validation.Constraints.*;
import play.db.ebean.*;
import javax.persistence.*;

@Entity
public class User extends Model {

    @Id
    public Long id;

    @Required
    public String firstName;

    @Required
    public String lastName;

    @Required
    public String email;

    public Long password;
    public int salt;

    public static Finder<Long,User> find = new Finder(Long.class, User.class);

    public static List<User> all() {
        return find.all();
    }

    public static void create(User user) {
        user.save();
    }

    public static void delete(Long id) {
        find.ref(id).delete();
    }

}
