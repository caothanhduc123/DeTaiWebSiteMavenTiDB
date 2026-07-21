/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author parrot
 */
@WebServlet(name = "thanhtoanServlet", urlPatterns = {"/thanhtoan"})
public class thanhtoanServlet extends HttpServlet {

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
            out.println("<title>Servlet thanhtoanServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet thanhtoanServlet at " + request.getContextPath() + "</h1>");
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
        request.getRequestDispatcher("./view/thanhtoan.jsp").include(request, response);
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
        String fromAccount = request.getParameter("fromAccount");
        String toAccount = request.getParameter("toAccount");
        String amountStr = request.getParameter("amount");

        String message;

        try {
            double amount = Double.parseDouble(amountStr);

            // Kiểm tra số tiền hợp lệ
            if (amount <= 0) {
                message = "Số tiền phải lớn hơn 0!";
            } else if (fromAccount.equals(toAccount)) {
                message = "Tài khoản gửi và nhận phải khác nhau!";
            } else {
                // TODO: Thêm logic kiểm tra số dư tài khoản và cập nhật cơ sở dữ liệu
                // Ví dụ: dao.transfer(fromAccount, toAccount, amount);

                message = "Chuyển khoản thành công từ " + fromAccount + " sang " + toAccount + " số tiền: " + amount + " VND";
            }
        } catch (NumberFormatException e) {
            message = "Số tiền không hợp lệ!";
            
        request.setAttribute("message", message);
        request.getRequestDispatcher("./view/home.jsp").include(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    }

}
