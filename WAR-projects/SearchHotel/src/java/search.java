/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author adrian
 */
public class search extends HttpServlet {
    /*
        Zona de declaración de variables que vamos a utilizar en esta clase
    */
    Connection conn = null;
    Statement stmt;
    
    @Override
    public void init(ServletConfig config) {
        try {
            /*
            Creamos la instancia del conector MySQL
            */
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            
            /*
                Creamos la conexión, incluyendo la ip de la maquina, nombre de 
                la base de datos, el usuario y el password.                
                la ip de la máquina es 127.0.0.1 porque es la misma donde se 
                está ejecutando el servlet donde esta la base de datos.                
            */
            
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1/hoteles",
                    "root", "1234");
            stmt = (Statement) conn.createStatement();

            /**
             * Processes requests for both HTTP <code>GET</code> and
             * <code>POST</code> methods.
             *
             * @param request servlet request
             * @param response servlet response
             * @throws ServletException if a servlet-specific error occurs
             * @throws IOException if an I/O error occurs
             */
        } catch (ClassNotFoundException ex) {
            //   Logger.getLogger(db.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            //   Logger.getLogger(db.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            //   Logger.getLogger(db.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            //   Logger.getLogger(db.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

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
        PrintWriter out = response.getWriter();

        try {
            /*
                A continuación incluimos información de la cabecera de la web
            */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Hotels list</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Hotels:</h1>");
            /*
                Y la información la mostramos en una tabla
            */
            out.println("<table>");
            /*
                Ahora realizamos la consulta a la base de datos
            */
            String query = null;
            /*
                Muestrame todos los datos de la tabla hotels
            */
            query = "SELECT * FROM hotels;";
            ResultSet resultSet = null;

            try {
                synchronized (stmt) {
                    /*
                        Ejecuta la consulta y el resultado lo guardas en stmt
                    */
                    resultSet = stmt.executeQuery(query);
                }
                /*
                    Mientras existan resultados haz ...
                */
                while (resultSet.next()) {
                    /*
                        Me creas una fila y cada campo de la base de datos me lo
                        muestras en una celda
                    */
                    out.println("<tr>");
                    out.println("<td>" + resultSet.getString(1) + "</td>");
                    out.println("<td>" + resultSet.getString(2) + "</td>");                    
                }
                out.println("</tr>");
            /*
                Si algo ha fallado en el proceso muestrame el error por pantalla
            */    
            } catch (SQLException ex) {
                out.println("Excepcion: " + ex);
            } finally {
                if (resultSet != null) {
                    try {
                        resultSet.close();
                    } catch (SQLException ex) {
                        //Logger.getLogger(db.class.getName()).log(Level.SEVERE,                        
                    }
                }
            }
            out.println("</table>");
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
