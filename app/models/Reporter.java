package models;

import java.util.*;
import play.data.validation.Constraints.*;
import play.db.ebean.*;
import javax.persistence.*;

/**
 * Holds all the information for the reporter in a report
 * 
 * @author Tyler Carroll
 *
 */
@Entity
public class Reporter extends PersonInfo {

    /* Reporter */
    @Required
    public String mandatedBool;
    @Required
    public String relationshipToVictim;

}

