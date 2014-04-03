package models;

import java.util.*;
import play.data.validation.Constraints.*;
import play.db.ebean.*;
import javax.persistence.*;

/**
 * Holds all the information for the abuser in a report
 * 
 * @author Tyler Carroll
 *
 */
@Entity
public class Abuser extends PersonInfo {

    @Required
    public String relationshipToVictim;
    @Required
    public String social;
    @Required
    public String dob;

}

