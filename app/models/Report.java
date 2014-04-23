package models;

import java.text.SimpleDateFormat;
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
     * date of abuse
     */
    //@Required
    public String date;
    /**
     * username of person who filed the report
     */
    @Required
    public String username;
    /**
     * end result of the report
     */
    //@Required
    public String result;
    /**
     * current status of the report
     */
    //@Required
    public String status;
    /**
     * type of abuse committed
     */
    @Required
    public String abuseDescr;
    /**
     * risk of victim
     */
    @Required
    public String victimRisk;
    /**
     * list of injuries
     */
    //@Required
    public String injuryList;
    /**
     * witnesses
     */
    //@Required
    public String witnesses;
    /**
     * relationship of caregiver
     */
    //@Required
    public String caregiverRel;
    /**
     * is an oral report filed?
     */
    @Required
    public boolean isOralReportFiled;
    /**
     * time oral report was filed
     */
    @Required
    public String oralReportFiledTime;
    /**
     * is this a risk to investigator?
     */
    @Required
    public boolean isRiskToInvestigator;
    /**
     * description of risk to investigator
     */
    @Required
    public String riskDescrToInvestigator;
    
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
    /**
     * collateral contact one 
     */
    @OneToOne(cascade=CascadeType.ALL)
    public CollateralContact collateralContact1;
    /**
     * collateral contact two 
     */
    @OneToOne(cascade=CascadeType.ALL)
    public CollateralContact collateralContact2;
    /**
     * collateral contact three 
     */
    @OneToOne(cascade=CascadeType.ALL)
    public CollateralContact collateralContact3;
    /**
     * collateral contact four
     */
    @OneToOne(cascade=CascadeType.ALL)
    public CollateralContact collateralContact4;
    /**
     * collateral contact five
     */
    @OneToOne(cascade=CascadeType.ALL)
    public CollateralContact collateralContact5;

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
     * Gets all reports filed by a user by username from database
     * 
     * @param userName username that filed reports to get
     * @return         returns list of reports by that user from database
     */
    public static List<Report> allByUserName(String userName) {
        return find.where().eq("username", userName).findList();
    }

    /**
     * Creates a report in database
     * 
     * @param report report to create in database
     * 
     * @return returns id of report just created
     */
    public static Long create(Report report) {
    	SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date now = new Date();
        String strDate = sdfDate.format(now);
        report.date = strDate;
        report.save();
        return report.id;
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
