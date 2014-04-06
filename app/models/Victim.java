package models;

import java.util.*;
import play.data.validation.Constraints.*;
import play.db.ebean.*;
import javax.persistence.*;

/**
 * Holds all the information for the victim in a report
 * 
 * @author Tyler Carroll
 *
 */
@Entity
public class Victim extends PersonInfo {

    /**
     * sex of victim
     */
    @Required
    public String sex;
    /**
     * date of birth of victim
     */
    @Required
    public String dob;
    /**
     * age of victim
     */
    @Required
    public String age;
    /**
     * marital status of victim
     */
    @Required
    public String maritalStatus;
    /**
     * disability of victim
     */
    @Required
    public String disability;
    /**
     * communication needs of victim
     */
    @Required
    public String communicationNeeds;
    /**
     * who the victim is currently served by
     */
    @Required
    public String currentlyServedBy;
    /**
     * type of service that vitcim requires
     */
    @Required
    public String typeOfService;
    /**
     * ethnicity of victim
     */
    @Required
    public String ethnicity;
    /**
     * awareness of report
     */
    @Required
    public String awarenessOfReport;

}

