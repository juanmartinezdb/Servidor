package ejerciciodados.dados;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "logicaDados", value = "/logica-dados")
public class LogicaDados extends HttpServlet {
    private int cantidad;
    List<Integer> tirada;
    List<Integer> Ordenada;


    public void init() {         cantidad = (int) (Math.random() * 6) + 2;
        tirada = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            tirada.add((int) (Math.random() * 6) + 1);
        }
        Ordenada = new ArrayList<>(tirada);
        Ordenada.sort(null);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        request.setAttribute("cantidad", cantidad);
        request.setAttribute("tirada", tirada);
        request.setAttribute("Ordenada", Ordenada);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/resultadoDados.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }

    public void destroy() {
    }
}