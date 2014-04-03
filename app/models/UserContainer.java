package models;

import java.util.*;
import play.data.validation.Constraints.*;
import play.db.ebean.*;
import javax.persistence.*;

/**
 * Holds all the information for the user and creates, gets and deletes users to and from the database
 * 
 * @author Tyler Carroll
 *
 */
@Entity
public class UserContainer extends Model {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    public Long id;

    @Required
    public String userName;

    @Required
    public String firstName;

    @Required
    public String lastName;

    @Required
    public String email;

    @Required
    public boolean isSupervisor;

    public String password;
    public int salt;

    public static Finder<Long,UserContainer> find = new Finder<Long, UserContainer>(Long.class, UserContainer.class);

    /**
     * List all users in database
     * 
     * @return returns list of all users in database
     */
    public static List<UserContainer> all() {
        return find.all();
    }

    /**
     * Creates a user in database
     * 
     * @param user user to create in database
     */
    public static void create(UserContainer user) {
        user.save();
    }

    /**
     * Deletes a user by id from database
     * 
     * @param id id of user to delete in database
     */
    public static void delete(Long id) {
        find.ref(id).delete();
    }

    /**
     * Gets a user by id from database
     * 
     * @param id id of user to get
     * @return   returns user from database
     */
    public static UserContainer get(Long id) {
        return find.ref(id);
    }

    /**
     * Gets a user by username from database
     * 
     * @param userName username of user to get
     * @return         returns user from database
     */
    public static UserContainer getByUserName(String userName) {
        return find.where().eq("userName", userName).findUnique();
    }

    /**
     * Deletes a user by username from database
     * 
     * @param userName username of user to delete
     */
    public static void deleteByUserName(String userName) {
        find.where().eq("userName", userName).findUnique().delete();
    }

}
