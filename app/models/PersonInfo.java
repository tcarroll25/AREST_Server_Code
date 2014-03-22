package models;

import java.util.*;
import play.data.validation.Constraints.*;
import play.db.ebean.*;
import javax.persistence.*;

@Entity
public class PersonInfo extends Model {

    @Required
    public String firstName;
    @Required
    public String lastName;
    @Required
    public String address;
    @Required
    public String phoneNumber;

}
