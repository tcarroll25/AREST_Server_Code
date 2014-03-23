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
    
    /* Scala view code
                <p>Name: </p>@report.reporter.info.firstName @report.reporter.info.lastName<br>
                <p>Addr: </p>@report.reporter.info.address<br>
                <p>Phone: </p>@report.reporter.info.phoneNumber<br>
                <p>Mandated?: </p>@report.reporter.mandatedBool<br>
                <p>Relationship to Victim: </p>@report.reporter.relationshipToVictim<br>
        @inputText(reportForm("reporter.info.firstName"))
        @inputText(reportForm("reporter.info.lastName"))
        @inputText(reportForm("reporter.info.address"))
        @inputText(reportForm("reporter.info.phoneNumber"))
        @inputText(reportForm("reporter.mandatedBool"))
        @inputText(reportForm("reporter.relationshipToVictim"))
     */
    
    /*public Reporter reporter = new Reporter();
    public Victim victim = new Victim();
    public Abuser abuser = new Abuser();
    public Guardian guardian = new Guardian();*/

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