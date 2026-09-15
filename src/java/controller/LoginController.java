

package controller;

import dal.UsersDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginController", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cookie[] cookie = request.getCookies();
        if (cookie != null) {
            for (Cookie c : cookie) {
                if (c.getName().equals("password")) {
                    request.setAttribute("password", c.getValue());
                }
                if (c.getName().equals("username")) {
                    request.setAttribute("username", c.getValue());
                }
            }
        }
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String rememberMe = request.getParameter("rememberMe");
        
        UsersDAO dao = new UsersDAO();
        boolean checkLog = dao.login(username, password);
        
        if (checkLog) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
                    
                    
            Cookie cUsername = new Cookie("username", username);
            Cookie cPassword = new Cookie("password", password);
            if (rememberMe != null) {
                cUsername.setMaxAge(60*60*24*7);
                cPassword.setMaxAge(60*60*24*7);
            }
            else {
                cUsername.setMaxAge(0);
                cPassword.setMaxAge(0);
            }
            response.addCookie(cUsername);
            response.addCookie(cPassword);
            
            request.getRequestDispatcher("home.jsp").forward(request, response);
        } else {
            String errMsg = "Wrong username or password!";
            request.setAttribute("username", username);
            request.setAttribute("errMsg", errMsg);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}