<%@ page import="java.util.List" %>
<%@ page import="modelo.Cliente" %>
<%@ page import="modelo.conexion" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Cliente> clientes = new conexion().listarClientes();
%>
<!DOCTYPE html>
<html>
<head>
    <title>Registro de Cuenta</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(to right, #ece9e6, #ffffff);
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .container {
            background-color: #ffffff;
            padding: 40px;
            border-radius: 12px;
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 500px;
            text-align: center;
        }
        h2 {
            color: #2c3e50;
            margin-bottom: 20px;
        }
        input, select {
            width: 100%;
            padding: 12px;
            margin: 10px 0;
            border-radius: 8px;
            border: 1px solid #ccc;
        }
        input[type="submit"] {
            background-color: #e67e22;
            color: white;
            border: none;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #f39c12;
        }
        a {
            display: block;
            margin-top: 20px;
            text-decoration: none;
            color: #2980b9;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Registrar Cuenta</h2>
    <form method="post" action="CuentaServlet">
        <select name="id_cliente" required>
            <option value="">-- Selecciona un cliente --</option>
            <%
                for (Cliente c : clientes) {
            %>
            <option value="<%= c.getId() %>"><%= c.getNombre() %> - <%= c.getDpi() %></option>
            <%
                }
            %>
        </select>
        <input type="text" name="numero_cuenta" placeholder="Número de cuenta" required>
        <select name="tipo">
            <option value="ahorro">Ahorro</option>
            <option value="monetaria">Monetaria</option>
        </select>
        <input type="number" step="0.01" name="saldo" placeholder="Saldo inicial" required>
        <input type="submit" value="Guardar Cuenta">
    </form>
    <a href="index.jsp">← Volver al inicio</a>
</div>
</body>
</html>
