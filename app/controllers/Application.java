package controllers;

import play.*;
import play.mvc.*;
import play.api.templates.BufferedContent;
import play.api.templates.Html;
import play.data.*;
import models.*;
import views.html.*;
import play.libs.Json;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;


/**
 * Main controller of the server. This class reacts to the actions performed on routes and
 * interacts with the classes that create, get and delete information from the database
 * 
 * @author Tyler Carroll
 *
 */
public class Application extends Controller {

    /**
     * form used to input user data from scala front end
     */
    static Form<UserContainer> userForm = Form.form(UserContainer.class);
    /**
     * form used to input report data from scala front end
     */
    static Form<Report> reportForm = Form.form(Report.class);

    /**
     * Redirects index to users
     * 
     * @return returns redirect to users route
     */
    public static Result index() {
        return redirect(routes.Application.users());
    }

    /* User functions */
    /**
     * Renders users page for Scala front end for debugging only
     * 
     * @return returns user page
     */
    public static Result users() {
        return ok(views.html.user.render(UserContainer.all(), userForm));
    }

    /**
     * Creates new user in database from Scala front end for debugging only
     * 
     * @return returns user page
     */
    public static Result newUser() {
        Form<UserContainer> filledForm = userForm.bindFromRequest();
        if (filledForm.hasErrors()) {
            return badRequest(views.html.user.render(UserContainer.all(), filledForm));
        } else {
        	String name = filledForm.get().userName;
            if (UserContainer.getByUserName(name) == null) {
                UserContainer.create(filledForm.get());
                return redirect(routes.Application.users());
            } else {
                return badRequest(views.html.user.render(UserContainer.all(), filledForm));
            }
        }
    }
    
    /**
     * Creates new user in database from JSON POST request from client
     * 
     * @return 200 OK or 400 BAD REQUEST
     */
    public static Result createUser() {
        JsonNode json = request().body().asJson();
        String name = Json.fromJson(json, UserContainer.class).userName;
        if (UserContainer.getByUserName(name) == null) {
            UserContainer.create(Json.fromJson(json, UserContainer.class));
            return ok();
        } else {
        	return badRequest();
        }
    }
    
    /**
     * Replace user with new information in database from JSON POST request from client
     * 
     * @return 200 OK or 400 BAD REQUEST
     */
    public static Result editUser() {
        JsonNode json = request().body().asJson();
        String name = Json.fromJson(json, UserContainer.class).userName;
        if (UserContainer.getByUserName(name) == null) {
            return badRequest();
        } else {
            UserContainer.edit(Json.fromJson(json, UserContainer.class));
            return ok();
        } 
    }
    
    /**
     * Gets users from database
     * 
     * @return   200 OK with JSON data of users
     */
    public static Result getAllUsers() {
    	return(ok(Json.toJson(UserContainer.all())));
    }
    
   /**
    * Gets user by username from database
    * 
    * @param name username of user to get from database
    * @return     200 OK with JSON data of user
    */
    public static Result getByUserName(String name) {
    	return(ok(Json.toJson(UserContainer.getByUserName(name))));
    }
    
   /**
    * Gets user by username from database from POST
    * 
    * @return     200 OK with JSON data of user or 400 BAD REQUEST
    */
    public static Result getUser() {
        JsonNode json = request().body().asJson();
        String name = Json.fromJson(json, UserContainer.class).userName;
        if (UserContainer.getByUserName(name) == null) {
        	return badRequest();
        } else {
            return(ok(Json.toJson(UserContainer.getByUserName(name))));
        }
    }
    
   /**
    * Check password of user sent by JSON POST request from client
    * 
    * @return 200 OK or 400 BAD REQUEST
    */
    public static Result checkPassword() {
        JsonNode json = request().body().asJson();
        String name = Json.fromJson(json, UserContainer.class).userName;
        if (UserContainer.getByUserName(name) == null) {
        	return badRequest();
        } else {
            if (Json.fromJson(json, UserContainer.class).password.equals(UserContainer.getByUserName(name).password)) {
                return ok();
            } else {
                return badRequest();
            }
        }
    }
    
    /**
     * Delete user by id from database
     * 
     * @param id id of user to delete
     * @return   returns user page
     */
    public static Result deleteUserById(Long id) {
        UserContainer.delete(id);
        return redirect(routes.Application.users());
    }
    
    /**
     * Delete user by username from database
     * 
     * @param name username of user to delete
     * @return     200 OK
     */
    public static Result deleteByUserName(String name) {
        UserContainer.deleteByUserName(name);
        return ok();
    }

    /**
     * Delete user by json data from database
     * 
     * @return 200 OK or 400 BAD REQUEST
     */
    public static Result deleteUser() {
        JsonNode json = request().body().asJson();
        String name = Json.fromJson(json, UserContainer.class).userName;
        if (UserContainer.getByUserName(name) == null) {
            return badRequest();
        } else {
            UserContainer.deleteByUserName(name);
            return ok();
        } 
    }

    /* Report functions */
    /**
     * Renders reports page for Scala front end for debugging only
     * 
     * @return returns report page
     */
    public static Result reports() {
        return ok(views.html.report.render(Report.all(), reportForm));
    }

    /**
     * Creates new report in database from Scala front end for debugging only
     * 
     * @return returns report page
     */
    public static Result newReport() {
        Form<Report> filledForm = reportForm.bindFromRequest();
        if (filledForm.hasErrors()) {
            return badRequest(views.html.report.render(Report.all(), filledForm));
        } else {
            Report.create(filledForm.get());
            return redirect(routes.Application.reports());
        }
    }
    
    /**
     * Creates new report in database from JSON POST request from client
     * 
     * @return 200 OK
     */
    public static Result createReport() {
        JsonNode json = request().body().asJson();
        Report.create(Json.fromJson(json, Report.class));
        return ok();
    }
    
    /**
     * Replace report with new information in database from JSON POST request from client
     * 
     * @return 200 OK or 400 BAD REQUEST
     */
    public static Result editReport() {
        JsonNode json = request().body().asJson();
        Long id = Json.fromJson(json, Report.class).id;
        if (Report.get(id) == null) {
            return badRequest();
        } else {
            Report.edit(Json.fromJson(json, Report.class));
            return ok();
        } 
    }
    
    /**
     * Gets report by from database from JSON POST request from client
     * 
     * @return 200 OK with JSON data of report or 400 BAD REQUEST
     */
    public static Result getReport() {
        JsonNode json = request().body().asJson();
        Long id = Json.fromJson(json, Report.class).id;
        if (Report.get(id) == null) {
            return badRequest();
        } else {
            return(ok(Json.toJson(Report.get(id))));
        } 
    }
    
    /**
     * Gets reports from database
     * 
     * @return   200 OK with JSON data of reports
     */
    public static Result getAllReports() {
    	return(ok(Json.toJson(Report.all())));
    }
    
    /**
     * Deletes report by from database from JSON POST request from client
     * 
     * @return 200 OK with JSON data of report or 400 BAD REQUEST
     */
    public static Result deleteReport() {
        JsonNode json = request().body().asJson();
        Long id = Json.fromJson(json, Report.class).id;
        if (Report.get(id) == null) {
            return badRequest();
        } else {
            Report.delete(id);
            return ok();
        } 
    }

    /**
     * Delete report by id from database
     * 
     * @param id id of report to delete
     * @return   returns report page
     */
    public static Result deleteReportById(Long id) {
        Report.delete(id);
        return redirect(routes.Application.reports());
    }
}

