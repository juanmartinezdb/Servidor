package org.iesbelen.servlet;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.iesbelen.model.Usuario;
import org.iesbelen.dao.UsuarioDAOImpl;
import org.iesbelen.dao.UsuarioDAO;
import org.iesbelen.utilities.Util;

@WebServlet(name = "usuariosServlet", value = "/tienda/usuarios/*")
public class UsuarioServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher dispatcher;
        String pathInfo = req.getPathInfo();

        if (pathInfo == null || "/".equals(pathInfo)) {

            UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
            List<Usuario> usuarios = usuarioDAO.getAll();

            req.setAttribute("usuarios", usuarios);
            dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/usuarios/usuarios.jsp");

        } else {
            pathInfo = pathInfo.replaceAll("/$", "");
            String[] pathParts = pathInfo.split("/");

            if (pathParts.length == 2 && "crear".equals(pathParts[1])) {
                dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/usuarios/crear-usuario.jsp");

            } else if (pathParts.length == 2) {
                UsuarioDAO userDAO = new UsuarioDAOImpl();
                try {
                    int id = Integer.parseInt(pathParts[1]);
                    Optional<Usuario> userSelect = userDAO.getById(id);
                    req.setAttribute("usuario", userSelect);
                    dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/usuarios/detalle-usuario.jsp");
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/usuarios/usuarios.jsp");
                }
            } else if (pathParts.length == 3 && "editar".equals(pathParts[1])) {
                UsuarioDAO userDAO = new UsuarioDAOImpl();
                try {
                    int id = Integer.parseInt(pathParts[2]);
                    Optional<Usuario> userSelect = userDAO.getById(id);
                    req.setAttribute("usuario", userSelect);
                    dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/usuarios/editar-usuario.jsp");
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/usuarios/usuarios.jsp");
                }
            } else {
                System.out.println("Opcion no soportada");
                dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/usuarios/usuarios.jsp");
            }
        }
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher dispatcher;
        String __method__ = req.getParameter("__method__");
        if (__method__ == null) {
            UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
            Usuario nuevoUsuario = new Usuario();
            String nombre = req.getParameter("nombre");
            try {
            nuevoUsuario.setPassword(Util.hashPassword(req.getParameter("password")));
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
            String rol = req.getParameter("rol");


            nuevoUsuario.setNombre(nombre);
            nuevoUsuario.setRol(rol);
            usuarioDAO.create(nuevoUsuario);
        } else if (__method__!= null && "put".equalsIgnoreCase(__method__)) {
            doPut(req, resp);
        } else if (__method__!= null && "delete".equalsIgnoreCase(__method__)) {
            doDelete(req, resp);
        } else {
            System.out.println("Opcion no soportada");
        }
        resp.sendRedirect(req.getContextPath() + "/tienda/usuarios");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
        String nombre = req.getParameter("nombre");
        String password = req.getParameter("password");
        String rol = req.getParameter("rol");
        Usuario nuevoUsuario = new Usuario();

        try {
            int id = Integer.parseInt(req.getParameter("id"));
            nuevoUsuario.setIdUsuario(id);
            nuevoUsuario.setNombre(nombre);
            nuevoUsuario.setPassword(Util.hashPassword(password));
            nuevoUsuario.setRol(rol);
            usuarioDAO.update(nuevoUsuario);


        } catch (NumberFormatException e) {
            e.printStackTrace();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher dispatcher;
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
        int id = Integer.parseInt(req.getParameter("codigo"));

        try {
            usuarioDAO.delete(id);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
