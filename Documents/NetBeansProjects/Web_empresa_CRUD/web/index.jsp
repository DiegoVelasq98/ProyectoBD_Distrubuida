<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Banco Distribuido</title>
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
            max-width: 400px;
            text-align: center;
        }

        h1 {
            color: #2c3e50;
            margin-bottom: 30px;
        }

        ul {
            list-style-type: none;
            padding: 0;
        }

        li {
            margin: 15px 0;
        }

        a {
            display: inline-block;
            text-decoration: none;
            color: #ffffff;
            background-color: #2980b9;
            padding: 10px 20px;
            border-radius: 8px;
            transition: background-color 0.3s ease;
        }

        a:hover {
            background-color: #3498db;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Banco Distribuido</h1>
    <ul>
        <li><a href="cliente.jsp">Registrar Cliente</a></li>
        <li><a href="cuenta.jsp">Registrar Cuenta</a></li>
        <li><a href="usuario.jsp">Registrar Usuario</a></li>
    </ul>
</div>
</body>
</html>
