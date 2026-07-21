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
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import utils.API;

/**
 *
 * @author parrot
 */
@WebServlet(name = "homeServlet", urlPatterns = {"/home"})
public class homeServlet extends HttpServlet {

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
            out.println("<title>Servlet homeServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet homeServlet at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
// khi user dang nhap
        user u = (user) session.getAttribute("user");
        ArrayList<car> lc = (ArrayList<car>) session.getAttribute("lc");
        if (lc == null) {
            lc = Database.getCar().findAll();
        }

        lc.removeIf(Objects::isNull);
        if (u != null) {
            lc = Database.getCar().findAll();
            ArrayList<mycart> lm = Database.getmycart().find(u.getId());
            if (lm == null) {
                lm = new ArrayList<>();
            }
            
            Set<Integer> cartCarIds = lm.stream()
                    .filter(Objects::nonNull)
                    .map(mycart::getId_car)
                    .collect(Collectors.toSet());

            lc.removeIf(c -> cartCarIds.contains(c.getId()));
//            ArrayList<car> lc_user = new ArrayList<>();
//            for(car c : lc){
//                for(mycart m : lm)
//                    if(c.getId() != m.getId_car())
//                        lc_user.add(c);
//                        
//            }
//            session.setAttribute("lm", lm);
//            session.setAttribute("lc", lc_user);
//            request.setAttribute("mcs", Database.getmycart().find(u.getId()));
        }
//        else

        session.setAttribute("lc", lc);
        request.setAttribute("lcs", Database.gethangxe().findAll());
        request.setAttribute("title", "Page Home");

        request.getRequestDispatcher("./view/Home.jsp")
                .include(request, response);

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

        Integer hangxe = null;
        try {
            String hangParam = request.getParameter("hangxe");
            if (hangParam != null && !hangParam.isBlank()) {
                hangxe = Integer.parseInt(hangParam);
            }
        } catch (NumberFormatException e) {
            hangxe = null;
        }

        double price = -1;
        try {
            String priceParam = request.getParameter("price");
            if (priceParam != null && !priceParam.isBlank()) {
                price = Double.parseDouble(priceParam);
            }
        } catch (NumberFormatException e) {
            price = -1;
        }

        ArrayList<car> lc = (ArrayList<car>) request.getSession().getAttribute("lc");
        if (lc == null) {
            lc = Database.getCar().findAll();
        }

        ArrayList<car> rs = new ArrayList<>();

        for (car c : lc) {

            if (c == null) {
                continue;
            }

            boolean match = true;

            if (hangxe != null) {
                match = match && c.getId_loaixe() == hangxe;
            }

            if (price >= 0) {
                match = match && c.getGiaban() <= price;
            }

            if (match) {
                rs.add(c);
            }
        }
        try {
            String findName = request.getParameter("findxe");
            request.setAttribute("findName_data", findName);
            ArrayList<car> findCar = new ArrayList<>();
            if (!findName.equals("")) {
                for (car c : rs) {
                    if (API.tuongDoi(c.getTen(), findName)) {
                        findCar.add(c);
                    }
                }
                rs = findCar;
            } else {
                rs = Database.getCar().findAll();
            }
        } catch (Exception e) {
        }
        request.setAttribute("lc", rs);
        request.setAttribute("lcs", Database.gethangxe().findAll());

        request.getRequestDispatcher("./view/Home.jsp")
                .include(request, response);

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
