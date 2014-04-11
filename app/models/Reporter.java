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
    /**
     * was this report mandated?
     */
    @Required
    public Boolean mandated;
    /**
     * reporter's relationship to the victim
     */
    @Required
    public String relationshipToVictim;

}

