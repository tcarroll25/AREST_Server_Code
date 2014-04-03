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

    @Required
    public String sex;
    @Required
    public String dob;
    @Required
    public String age;
    @Required
    public String maritalStatus;
    @Required
    public String disability;
    @Required
    public String communicationNeeds;
    @Required
    public String currentlyServedBy;
    @Required
    public String typeOfService;
    @Required
    public String ethnicity;
    @Required
    public String awarenessOfReport;

}

