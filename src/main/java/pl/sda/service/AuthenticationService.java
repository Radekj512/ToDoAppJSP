package pl.sda.service;

import pl.sda.model.User;

import javax.servlet.http.HttpServletRequest;

import static pl.sda.service.UserService.*;


public class AuthenticationService {

    public static boolean authenticate(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("pass");
        User user = findUser(username);
        if (user != null && user.getPassword().equals(password)) {
            request.getSession().setAttribute("isAuthenticated", true);
            return true;
        }
        request.getSession().setAttribute("isAuthenticated", false);
        return false;
    }

    public static boolean isAuthenticated(HttpServletRequest req) {
        if (req.getSession().getAttribute("isAuthenticated") != null) {
            return (boolean) req.getSession().getAttribute("isAuthenticated");
        }
        return false;
    }
}
