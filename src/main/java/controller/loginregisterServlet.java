/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import data.dao.Database;
import data.model.user;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import utils.API;

/**
 *
 * @author parrot
 */
@WebServlet(name = "loginregisterServlet", urlPatterns = {"/login-register"})
public class loginregisterServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet loginregisterServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet loginregisterServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
        request.setAttribute("title", "Page Login Register");
        request.getRequestDispatcher("./view/login-register.jsp").include(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
//        UpdateDelete(request, response);
        loginregister(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    void loginregister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acction = request.getParameter("acction");
        switch (acction) {
            case "Login":
                doLogin(request, response);
                break;
            case "Register":
                doRegister(request, response);
                break;

        }
        request.getRequestDispatcher("./view/login-register.jsp").include(request, response);
    }

    void doLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String emailphone = request.getParameter("emailphone");
        String password = request.getParameter("password");
        user users = Database.getuser().findUser(emailphone, password);
        if (users == null) {
            request.getSession().setAttribute("err", "<div style = 'color:red;'>tai khoan hoac mat khau khong dung !</div>");
            response.sendRedirect("login-register");
        } else {
            if (users.getRole().equals("admin")) {
//                request.getSession().setAttribute("user", users);
                response.sendRedirect("admin");
            } else {
                request.getSession().setAttribute("user", users);
                request.getSession().removeAttribute("err");
                response.sendRedirect("home");
            }
        }
    }

    void doRegister(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        String repassword = request.getParameter("repassword");
        String Email_Regex = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
        String Phone_Regex = "^\\d{10}$";
        boolean err = false;
        String err_email = "";
        String err_phone = "";
        String err_password = "";
        if (!email.matches(Email_Regex)) {
            err_email = "sai email";
            request.getSession().setAttribute("err_email", err_email);
            err = true;
        } else {
            err_email = "";
            request.getSession().removeAttribute("err_email");
        }
        if (!phone.matches(Phone_Regex)) {
            err_phone = "Phone sai";
            request.getSession().setAttribute("err_phone", err_phone);
            err = true;
        } else {
            err_phone = "";
            request.getSession().removeAttribute("err_phone");
        }
//        if (!password.matches(repassword)) {
//            err_password = "nhap lai khong dung";
//            request.getSession().setAttribute("err_password", err_password);
//            err = true;
//        } else {
//            err_password = "";
//            request.getSession().removeAttribute("err_password");
//        }
        if (err) {
            response.sendRedirect("login-register");
        } else {

            if (Database.getuser().findUser(email) != null || Database.getuser().findUser(phone) != null) {
                request.getSession().setAttribute("exists_user", "co tai khoan nay trong database");
                response.sendRedirect("login-register");
            } else {
                Database.getuser().Insert(name, email, phone, API.getMd5(password), "guest");
                user u = Database.getuser().findUser(email);
                request.getSession().setAttribute("user", u);
                request.getSession().removeAttribute("exists_user");
                response.sendRedirect("home");
            }
        }
    }
}
