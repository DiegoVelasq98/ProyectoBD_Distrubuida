<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registro de Usuario</title>
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
            max-width: 450px;
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
            background-color: #8e44ad;
            color: white;
            border: none;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #9b59b6;
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
    <h2>Registrar Usuario</h2>
    <form method="post" action="UsuarioServlet">
        <input type="text" name="usuario" placeholder="Nombre de usuario" required>
        <input type="password" name="contrasena" placeholder="Contraseña" required>
        <select name="rol" required>
            <option value="sucursal">Sucursal</option>
            <option value="mercadeo">Mercadeo</option>
            <option value="credito">Crédito</option>
            <option value="admin">Administrador</option>
        </select>
        <input type="submit" value="Guardar Usuario">
    </form>
    <a href="index.jsp">← Volver al inicio</a>
</div>
</body>
</html>
