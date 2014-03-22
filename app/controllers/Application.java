package controllers;

import play.*;
import play.mvc.*;
import play.data.*;
import models.*;
import views.html.*;

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

    public static Result deleteReport(Long id) {
        Report.delete(id);
        return redirect(routes.Application.reports());
    }
}

