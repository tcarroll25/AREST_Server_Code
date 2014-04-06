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

    /**
     * abuser's relationship to the victim
     */
    @Required
    public String relationshipToVictim;
    /**
     * social security number of abuser
     */
    @Required
    public String social;
    /**
     * date of birth of abuser
     */
    @Required
    public String dob;

}

