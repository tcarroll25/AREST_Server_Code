package models;

import java.util.*;
import play.data.validation.Constraints.*;
import play.db.ebean.*;
import play.db.ebean.Model.Finder;

import javax.persistence.*;

@Entity
public class Report extends Model {

    @Id
    public Long id;
    public Reporter reporter = new Reporter();
    public Victim victim = new Victim();
    public Abuser abuser = new Abuser();
    public Guardian guardin = new Guardian();

    /* Information */
    @Required
    public String typeOfAbuse;
    @Required
    public String description;

    public static Finder<Long,Report> find = new Finder<Long, Report>(Long.class, Report.class);

    public static List<Report> all() {
        return find.all();
    }

    public static void create(Report report) {
        report.save();
    }

    public static void delete(Long id) {
        find.ref(id).delete();
    }

}
