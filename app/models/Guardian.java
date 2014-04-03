package models;

import java.util.*;
import play.data.validation.Constraints.*;
import play.db.ebean.*;
import javax.persistence.*;

/**
 * Holds all the information for the guardian in a report
 * 
 * @author Tyler Carroll
 *
 */
@Entity
public class Guardian extends PersonInfo {

    @Required
    public String relationshipToVictim;

}

