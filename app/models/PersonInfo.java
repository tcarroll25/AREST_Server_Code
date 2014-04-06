package models;

import java.util.*;
import play.data.validation.Constraints.*;
import play.db.ebean.*;
import javax.persistence.*;

/**
 * Holds standard information that is used by the abuser, guardian, reporter and victim classes
 * 
 * @author Tyler Carroll
 *
 */
@MappedSuperclass
public abstract class PersonInfo extends Model {

    /**
     * id of person in database
     */
    @Id
    public Long id;
    /**
     * first name of person
     */
    @Required
    public String firstName;
    /**
     * last name of person
     */
    @Required
    public String lastName;
    /**
     * address of person
     */
    @Required
    public String address;
    /**
     * phone number of person
     */
    @Required
    public String phoneNumber;

}

