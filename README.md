# 💻 Proyecto Banco Distribuido

Este proyecto simula un sistema bancario básico desarrollado en **Java EE** con **JSP, Servlets y MySQL**, orientado a la gestión de clientes, cuentas bancarias y usuarios del sistema. Forma parte del curso de Bases de Datos Distribuidas.

## 📚 Tecnologías utilizadas

- Java EE (NetBeans 17)
- JSP & Servlets
- MySQL 8.x
- HTML + CSS puro (estilo embebido)
- JDBC (mysql-connector-j)
- Servidor GlassFish o Tomcat

## 🧩 Estructura del sistema

- **Modelo (`/modelo`)**: contiene las clases `Cliente`, `Cuenta`, `Usuario` y `conexion`.
- **Controlador (`/controlador`)**: contiene los servlets `ClienteServlet`, `CuentaServlet`, `UsuarioServlet`.
- **Vista (`*.jsp`)**: formularios para registrar clientes, cuentas y usuarios, con estilo embebido.

## 📌 Funcionalidades principales

- Registrar nuevos **clientes** con datos personales.
- Crear **cuentas bancarias** asociadas a clientes.
- Registrar **usuarios internos** del sistema con roles.
- Conexión a base de datos centralizada desde una clase `conexion`.
