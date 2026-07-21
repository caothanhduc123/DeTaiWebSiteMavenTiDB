/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import data.dao.Database;
import data.model.car;
import data.model.mycart;
import data.model.user;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author parrot
 */
@WebServlet(name = "mycartServlet", urlPatterns = {"/mycart"})
public class mycartServlet extends HttpServlet {

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
            out.println("<title>Servlet mycartServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet mycartServlet at " + request.getContextPath() + "</h1>");
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
        user u = (user) request.getSession().getAttribute("user");
        ArrayList<mycart> lm = Database.getmycart().find(u.getId());
        request.setAttribute("lm", lm);
        request.getSession().setAttribute("ld", Database.getdonhang().finddonhang(u.getId()));
        request.setAttribute("u", u);
        request.setAttribute("lc", Database.getCar().findAll());
        request.setAttribute("title", "Page Mycart");
        request.getRequestDispatcher("./view/mycart.jsp").include(request, response);
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
        delAndDelAll(request, response);
    }

    void delAndDelAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = (String) request.getParameter("acction");
        ArrayList<car> lc = (ArrayList<car>) request.getSession().getAttribute("lc");
        switch (action) {
            case "del":
                delMyCart(request, response, lc);
                break;
            case "dels":
                delAllMyCart(request, response, lc);
                break;
            case "chuyenkhoan":
                dochuyenkhoan(request, response);
                break;
            default:

        }
        lc.sort((a, b) -> {
            return a.getId() - b.getId();
        });
//        request.getSession().setAttribute("lc", lc);
        response.sendRedirect("mycart");
    }

    void dochuyenkhoan(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<mycart> lm = (ArrayList<mycart>) request.getAttribute("lm");
        user u = (user) request.getSession().getAttribute("user");
        Database.getmycart().updatetrangthai(u.getId());
        for (mycart i : lm) {
            if (!i.isTrangthai()) {
                Database.getdonhang().Insert(-1, -1, "0", Date.from(Instant.now()), i.getId_car(), u.getId());
            }
        }
    }

    void delMyCart(HttpServletRequest request, HttpServletResponse response, ArrayList<car> lc) {
        try {
            // tim vi tri xe trong my cart     
            int id_mycart_del = Integer.parseInt(request.getParameter("dcar"));
            // luu lai xe sau khi xoa khoi gio hang 
            mycart mc = Database.getmycart().find_id(id_mycart_del);
//            lc.add(Database.getCar().find(mc.getId_car()));
            //xoa xe trong gio hang
            Database.getmycart().delete(mc.getId());
        } catch (Exception e) {
        }
    }

    void delAllMyCart(HttpServletRequest request, HttpServletResponse response, ArrayList<car> lc) {
        try {
            user u = (user) request.getSession().getAttribute("user");
            ArrayList<mycart> lm = Database.getmycart().find(u.getId());
            for (int i = 0; i < lm.size(); i++) {
                //luu lai du lieu car
                if (!lm.get(i).isTrangthai()) {
                    lc.add(Database.getCar().find(lm.get(i).getId_car()));
                    //xoa trong gio hang
                    Database.getmycart().delete(lm.get(i).getId());
                }
            }
        } catch (Exception e) {
        }
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

}
