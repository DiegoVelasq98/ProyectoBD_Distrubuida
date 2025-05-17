package controlador;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.conexion;

@WebServlet(name = "UsuarioServlet", urlPatterns = {"/UsuarioServlet"})
public class UsuarioServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usuario = request.getParameter("usuario");
        String contrasena = request.getParameter("contrasena");
        String rol = request.getParameter("rol");

        conexion con = new conexion();
        boolean resultado = con.insertarUsuario(usuario, contrasena, rol);

        if (resultado) {
            response.sendRedirect("index.jsp");
        } else {
            response.getWriter().println("Error al guardar usuario.");
        }
    }
}
