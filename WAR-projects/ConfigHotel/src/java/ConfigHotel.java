/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author adrian
 */
public class ConfigHotel extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    int countTimesConnect = 1;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();       
        String valor = request.getParameter("valor");
        String action = request.getParameter("accion");
              
        String nameHotel = request.getParameter("name_hotel");
        String service = request.getParameter("service_hotel");
        String discount = request.getParameter("discount_hotel");
        String persons = request.getParameter("persons_hotel");
        
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>ConfigHotel</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>ConfigHotel Information</h1>");
            
            HttpSession session = request.getSession();
            if (action.equals("invalidar")) {
                session.invalidate();
                out.println("<h1>Sesion invalidada:</h1>");
            } else {
                session.setAttribute("name_hotel", nameHotel);
                session.setAttribute("service_hotel", service);
                session.setAttribute("discount_hotel", discount);
                session.setAttribute("persons_hotel", persons);
                out.println("<ul>");
                Enumeration<String> nombresDeAtributos = session.getAttributeNames();
                out.println("<p>Number connections :"+ (countTimesConnect++) +"</p>");
            while (nombresDeAtributos.hasMoreElements()) {
                String atributo = nombresDeAtributos.nextElement();
                out.println("<li><b>" + atributo + ": </b>" + session.getAttribute(atributo) + "</li>");
            }
            out.println("</ul>");
            }
            out.println("<a href=/ConfigHotel/index.jsp>"+ "Return</a><br/>");
            //out.println(request.getQueryString());           
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
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
        processRequest(request, response);
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
        processRequest(request, response);
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
