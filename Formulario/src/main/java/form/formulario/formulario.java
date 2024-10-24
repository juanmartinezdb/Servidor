package form.formulario;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "formulario", value = "/formulario")
public class formulario extends HttpServlet {
    private String nombre;
    private String apellidos;
    private String edad;
    private String sexo;
    private String estadoCivil;
    private Aficiones aficiones;

    public void init() {}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        nombre = request.getParameter("nombre");
        apellidos = request.getParameter("apellidos");
        edad = request.getParameter("edad");
        sexo = request.getParameter("sexo");
        aficiones = new Aficiones(request.getParameter("cine"),
                request.getParameter("literatura"),
                request.getParameter("tebeos"),
                request.getParameter("deporte"),
                request.getParameter("musica"),
                request.getParameter("television")
               );




        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Nombre "+nombre+"</h1>");
        out.println("<h2>Apellidos"+apellidos+"</h2>");
        out.println("<h2>Edad"+edad+"</h2>");
        out.println("<h2>Sexo"+sexo+"</h2>");
        out.println("<h2>Estado Civil"+estadoCivil+"</h2>");
        out.println("<h2>"+aficiones+"</h2>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}