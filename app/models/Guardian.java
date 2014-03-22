package models;

import java.util.*;
import play.data.validation.Constraints.*;
import play.db.ebean.*;
import javax.persistence.*;

@Entity
public class Guardian extends Model {

    /* Reporter */
    public PersonInfo info = new PersonInfo();
    @Required
    public String relationshipToVictim;

}

