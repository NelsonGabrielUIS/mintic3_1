package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Instructores;
import modelo.InstructoresDAO;

/**
 *
 * @author Nelson Diaz
 */
@WebServlet(name = "InstructoresController", urlPatterns = {"/InstructoresController"})
public class InstructoresController extends HttpServlet {

       
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        InstructoresDAO instructoresDAO = null;
        try {
            instructoresDAO = new InstructoresDAO();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InstructoresController.class.getName()).log(Level.SEVERE, null, ex);
        }
        String accion;
        RequestDispatcher dispatcher = null;
        accion = request.getParameter("accion");
        if(accion == null || accion.isEmpty()){
            dispatcher = request.getRequestDispatcher("Instructores/Home.jsp");
            List<Instructores> listarInstructores = instructoresDAO.listarInstructores();
            request.setAttribute("lista", listarInstructores);
        } else if("nuevo".equals(accion)){
            dispatcher = request.getRequestDispatcher("Instructores/nuevo.jsp");
        } else if("insertar".equals(accion)){
            
            String num = request.getParameter("num");
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String perfil = request.getParameter("perfil");
            
            Instructores instructor = new Instructores(0, num, nombre, apellido, perfil);
            instructoresDAO.insertar(instructor);
            dispatcher = request.getRequestDispatcher("Instructores/Home.jsp");
            List<Instructores> listaInstructores = instructoresDAO.listarInstructores();
            request.setAttribute("lista", listaInstructores);
        } else if("modificar".equals(accion)){
            dispatcher = request.getRequestDispatcher("Instructores/modificar.jsp");
            int id = Integer.parseInt(request.getParameter("id"));
            Instructores instructor = instructoresDAO.mostrarInstructor(id);
            request.setAttribute("instructor", instructor);
        } else if("actualizar".equals(accion)){
            
            int id = Integer.parseInt(request.getParameter("id"));
            String num = request.getParameter("num");
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String perfil = request.getParameter("perfil");
            
            Instructores instructor = new Instructores(id, num, nombre, apellido, perfil);
            instructoresDAO.actualizar(instructor);
            dispatcher = request.getRequestDispatcher("Instructores/Home.jsp");
            List<Instructores> listaInstructores = instructoresDAO.listarInstructores();
            request.setAttribute("lista", listaInstructores);
        } else if("eliminar".equals(accion)){
            
            int id = Integer.parseInt(request.getParameter("id"));
            instructoresDAO.eliminar(id);
            dispatcher = request.getRequestDispatcher("Instructores/Home.jsp");
            List<Instructores> listarInstructores = instructoresDAO.listarInstructores();
            request.setAttribute("lista", listarInstructores);
        } else{
            dispatcher = request.getRequestDispatcher("Instructores/Home.jsp");
            List<Instructores> listarInstructores = instructoresDAO.listarInstructores();
            request.setAttribute("lista", listarInstructores);
        }
        
        dispatcher.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
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
