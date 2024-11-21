package org.iesbelen.servlet;

import java.io.Console;
import java.io.IOException;
import java.util.Comparator;
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

@WebServlet(name = "usuariosServlet", value = "/tienda/usuarios/*")
public class UsuarioServlet extends HttpServlet {
}
