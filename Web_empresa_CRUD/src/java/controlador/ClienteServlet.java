package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Cliente;
import modelo.conexion;

@WebServlet(name = "ClienteServlet", urlPatterns = {"/ClienteServlet"})
public class ClienteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String dpi = request.getParameter("dpi");
        String direccion = request.getParameter("direccion");
        String telefono = request.getParameter("telefono");

        Cliente cliente = new Cliente(nombre, dpi, direccion, telefono);
        conexion con = new conexion();

        boolean resultado = con.insertarCliente(cliente);

        if (resultado) {
            response.sendRedirect("index.jsp");
        } else {
            response.getWriter().println("Error al guardar cliente.");
        }
    }
}
