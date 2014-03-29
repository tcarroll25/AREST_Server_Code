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

public class Application extends Controller {

    static Form<User> userForm = Form.form(User.class);
    static Form<Report> reportForm = Form.form(Report.class);

    /* Redirect to Users */
    public static Result index() {
        return redirect(routes.Application.users());
    }

    /* User functions */
    public static Result users() {
        return ok(views.html.user.render(User.all(), userForm));
    }

    public static Result newUser() {
        Form<User> filledForm = userForm.bindFromRequest();
        if (filledForm.hasErrors()) {
            return badRequest(views.html.user.render(User.all(), filledForm));
        } else {
            User.create(filledForm.get());
            return redirect(routes.Application.users());
        }
    }
    
    public static Result createUser() {
        JsonNode json = request().body().asJson();
        User.create(Json.fromJson(json, User.class));
        return ok();
    }
    
   public static Result getUser(Long id) {
    	return(ok(Json.toJson(User.get(id))));
    }
    
    
    public static Result deleteUser(Long id) {
        User.delete(id);
        return redirect(routes.Application.users());
    }

    /* Report functions */
    public static Result reports() {
        return ok(views.html.report.render(Report.all(), reportForm));
    }

    public static Result newReport() {
        Form<Report> filledForm = reportForm.bindFromRequest();
        if (filledForm.hasErrors()) {
            return badRequest(views.html.report.render(Report.all(), filledForm));
        } else {
            Report.create(filledForm.get());
            return redirect(routes.Application.reports());
        }
    }
    
   public static Result getReport(Long id) {
    	return(ok(Json.toJson(Report.get(id))));
    }

    public static Result deleteReport(Long id) {
        Report.delete(id);
        return redirect(routes.Application.reports());
    }
}

