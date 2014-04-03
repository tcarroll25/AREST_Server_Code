package models;

import java.util.*;
import play.data.validation.Constraints.*;
import play.db.ebean.*;
import play.db.ebean.Model.Finder;

import javax.persistence.*;

/**
 * Holds all the information for the report and creates, gets and deletes reports to and from the database
 * 
 * @author Tyler Carroll
 *
 */
@Entity
public class Report extends Model {

    @Id
    public Long id;
    
    @Required
    @OneToOne(cascade=CascadeType.ALL)
    public Reporter reporter;
    @Required
    @OneToOne(cascade=CascadeType.ALL)
    public Victim victim;
    @Required
    @OneToOne(cascade=CascadeType.ALL)
    public Abuser abuser;
    @Required
    @OneToOne(cascade=CascadeType.ALL)
    public Guardian guardian;

    /* Information */
    @Required
    public String typeOfAbuse;
    @Required
    public String description;

    public static Finder<Long,Report> find = new Finder<Long, Report>(Long.class, Report.class);

    /**
     * Lists all reports in database
     * 
     * @return returns list of all reports in database
     */
    public static List<Report> all() {
        return find.all();
    }

    /**
     * Creates a report in database
     * 
     * @param report report to create in database
     */
    public static void create(Report report) {
        report.save();
    }

    /**
     * Deletes a report by id from database
     * 
     * @param id id of report to delete in database
     */
    public static void delete(Long id) {
        find.ref(id).delete();
    }

    /**
     * Gets a report by id from database
     * 
     * @param id id of report to get
     * @return   returns report from database
     */
    public static Report get(Long id) {
        return find.ref(id);
    }

}
