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

    @Id
    public Long id;
    @Required
    public String firstName;
    @Required
    public String lastName;
    @Required
    public String address;
    @Required
    public String phoneNumber;

}

