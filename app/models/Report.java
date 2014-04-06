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

    /**
     * id of the report in the database
     */
    @Id
    public Long id;
    
    /**
     * person who reported the abuse
     */
    @Required
    @OneToOne(cascade=CascadeType.ALL)
    public Reporter reporter;
    /**
     * victim of the abuse
     */
    @Required
    @OneToOne(cascade=CascadeType.ALL)
    public Victim victim;
    /**
     * person who committed the abuse
     */
    @Required
    @OneToOne(cascade=CascadeType.ALL)
    public Abuser abuser;
    /**
     * guardian of the victim
     */
    @Required
    @OneToOne(cascade=CascadeType.ALL)
    public Guardian guardian;

    /* Information */
    /**
     * username of person who filed the report
     */
    @Required
    public String username;
    /**
     * current state of the report
     */
    @Required
    public String state;
    /**
     * current status of the report
     */
    @Required
    public String status;
    /**
     * type of abuse committed
     */
    @Required
    public String typeOfAbuse;
    /**
     * description of the abuse commmitted
     */
    @Required
    public String description;

    /**
     * finder to find abuse reports in database
     */
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
     * Edit a report in database
     * 
     * @param report report to edit in database
     */
    public static void edit(Report report) {
        report.update(report.id);
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
        return find.byId(id);
    }

}
