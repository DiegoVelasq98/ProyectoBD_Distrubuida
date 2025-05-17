package controlador;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Cuenta;
import modelo.conexion;

@WebServlet(name = "CuentaServlet", urlPatterns = {"/CuentaServlet"})
public class CuentaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idCliente = Integer.parseInt(request.getParameter("id_cliente"));
        String numeroCuenta = request.getParameter("numero_cuenta");
        String tipo = request.getParameter("tipo");
        double saldo = Double.parseDouble(request.getParameter("saldo"));

        Cuenta cuenta = new Cuenta(idCliente, numeroCuenta, tipo, saldo);
        conexion con = new conexion();

        boolean resultado = con.insertarCuenta(cuenta);

        if (resultado) {
            response.sendRedirect("index.jsp");
        } else {
            response.getWriter().println("Error al guardar cuenta.");
        }
    }
}
