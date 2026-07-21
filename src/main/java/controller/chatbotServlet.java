/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import utils.chatbot;
import data.dao.Database;
import data.model.Message;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author parrot
 */
@WebServlet(name = "chatbotServlet", urlPatterns = {"/chatbot"})
public class chatbotServlet extends HttpServlet {

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
            out.println("<title>Servlet chatbotServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet chatbotServlet at " + request.getContextPath() + "</h1>");
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
        request.setAttribute("title", "Page chatbot");
        List<Message> list = (List<Message>) request.getSession().getAttribute("messages");
        if (list == null) {
            list = new ArrayList<>();
            list.add(new Message("bot", "\"Mình có thể giúp bạn xem thông tin siêu xe, so sánh và tư vấn.\\n\"\n"
                    + "                + \"Bạn thử nhập: 'Revuelto', 'xe hybrid', 'siêu xe điện', 'coupe', 'tăng tốc nhanh', ...\";"));
        }

        request.getSession().setAttribute("messages", list);
        request.getRequestDispatcher("./view/chatbot.jsp").include(request, response);
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
        HttpSession session = request.getSession();
        List<Message> list = (List<Message>) session.getAttribute("messages");

        if (list == null) {
            list = new ArrayList<>();
        }

        String userMsg = request.getParameter("message");

        // Thêm tin nhắn người dùng
        list.add(new Message("user", userMsg));

        // Bot trả lời đơn giản
//        list.add(new Message("bot", "Bạn vừa nói: " + userMsg) );
        chatbot c = new chatbot();
        String data = c.xuLyChatbot(userMsg, Database.getCar().findAll());
        list.add(new Message("bot", "Bot: " + data));

        session.setAttribute("messages", list);

        response.sendRedirect("chatbot");
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
