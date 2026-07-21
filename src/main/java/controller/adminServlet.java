/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import data.dao.Database;
import data.model.car;
import data.model.donhang;
import data.model.user;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author parrot
 */
@WebServlet(name = "adminServlet", urlPatterns = {"/admin"})
public class adminServlet extends HttpServlet {

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
            out.println("<title>Servlet adminServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet adminServlet at " + request.getContextPath() + "</h1>");
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
        request.setAttribute("adlc", Database.getCar().findAll());
//        request.setAttribute("adus", Database.getuser().findAll());
        request.setAttribute("adlus", Database.getuser().findAll());
//        request.setAttribute("ad", );
        request.setAttribute("title", "Page Admin");     
        request.setAttribute("users", Database.getuser().findAll());
        request.setAttribute("mycart", Database.getmycart().findAll());
        request.setAttribute("donghang", Database.getdonhang().findAll());
        List<Integer> userByMonth = Arrays.asList(5, 12, 20, 18, 30, 40);

        request.setAttribute("labels",
                Arrays.asList("Jan", "Feb", "Mar", "Apr", "May", "Jun"));
        request.setAttribute("data", userByMonth);
        request.getRequestDispatcher("./view/admin.jsp").include(request, response);
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
        String action = request.getParameter("action");
        switch (action) {
            case "add_cart":
                do_AddCart(request);
                break;
            case "update":
                do_UpdateCart(request);
                break;
            case "delete":
                do_DeleteCart(request);
                break;
            case "xacnhan_donhang":
                do_xacnhan_donhang(request);
                break;
            case "huybo_donhang":
                do_huybo_donhang(request);
                break;
            default:
                throw new AssertionError();
        }
        response.sendRedirect("admin");
    }
    //donhang
    void do_xacnhan_donhang(HttpServletRequest request){
        int id_dh = Integer.parseInt(request.getParameter("id_donhang"));
        Database.getdonhang().xacnhandonhang(id_dh);
    }
    void do_huybo_donhang(HttpServletRequest request){
        int id_dh = Integer.parseInt(request.getParameter("id_donhang"));
        Database.getdonhang().delete(id_dh);
    }
    //san pham
    void do_AddCart(HttpServletRequest request) {
        String ten = request.getParameter("ten");
        int id_loaixe = Integer.parseInt(request.getParameter("id_loaixe"));
        int namsanxuat = Integer.parseInt(request.getParameter("namsanxuat"));
        double giaban = Double.parseDouble(request.getParameter("giaban"));
        String kieudang = request.getParameter("kieudang");
        String hopso = request.getParameter("hopso");
        String nhienlieu = request.getParameter("nhienlieu");
        String mota = request.getParameter("mota");
        String power = request.getParameter("power");
        String acceleration = request.getParameter("acceleration");
        String topspeed = request.getParameter("topspeed");
        String engine = request.getParameter("engine");
        String DungTich = request.getParameter("DungTich");
        String TruyenDong = request.getParameter("TruyenDong");
        String CongNghe = request.getParameter("CongNghe");
        String TrongLuong = request.getParameter("TrongLuong");
        String image = request.getParameter("image");
        car c = new car(0, ten, namsanxuat, giaban, image, kieudang, hopso, nhienlieu, id_loaixe, mota, power, acceleration, topspeed, engine, DungTich, TruyenDong, CongNghe, TrongLuong);
        Database.getCar().insert(c);
    }

    void do_UpdateCart(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        String ten = request.getParameter("ten");
        int id_loaixe = Integer.parseInt(request.getParameter("id_loaixe"));
        int namsanxuat = Integer.parseInt(request.getParameter("namsanxuat"));
        double giaban = Double.parseDouble(request.getParameter("giaban"));
        String kieudang = request.getParameter("kieudang");
        String mota = request.getParameter("mota");
        Database.getCar().update(id, ten, id_loaixe, namsanxuat, giaban, kieudang, mota);
    }

    void do_DeleteCart(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Database.getCar().delete(id);
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

    private boolean data_donhang(String id_car) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
