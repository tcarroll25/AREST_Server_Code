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

    /**
     * guardian's relationship to the victim
     */
    @Required
    public String relationshipToVictim;

}

