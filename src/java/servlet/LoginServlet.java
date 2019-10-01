/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.AccountService;
import models.User;

/**
 *
 * @author 749300
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("user");
        String logout = request.getParameter("logout");

        if (logout == null) {
            if (username != null) {
                response.sendRedirect("home");
            } else {
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                        .forward(request, response);
            }
        } else if (logout.equals("")) {
            session.invalidate();
            request.setAttribute("mesgL", "You have successfully logged out");

            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                    .forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = request.getParameter("name");
        String password = request.getParameter("pass");
        User u = AccountService.login(username, password);

        if (u == null) {
            request.setAttribute("mesgL", "Invalid");

            getServletContext()
                    .getRequestDispatcher("/WEB-INF/login.jsp")
                    .forward(request, response);
        } else {

            session.setAttribute("user", u.getUsername());
            session.setAttribute("username", username);
            session.setAttribute("mesgH", username);
            response.sendRedirect("home");
        }
    }
}
