package animales.animalitos2;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String [] fotos;
    private String [] nombres;

    public void init() {
        fotos = new String[] {
                "ballena.svg",
                "caballito-mar.svg",
                "camello.svg",
                "cebra.svg",
                "elefante.svg",
                "hipopotamo.svg",
                "jirafa.svg",
                "leon.svg",
                "leopardo.svg",
                "medusa.svg",
                "mono.svg",
                "oso.svg",
                "oso-blanco.svg",
                "pajaro.svg",
                "pinguino.svg",
                "rinoceronte.svg",
                "serpiente.svg",
                "tigre.svg",
                "tortuga.svg",
                "tortuga-marina.svg"
        };

        nombres = new String[]{
                "ballena",
                "caballito-mar",
                "camello",
                "cebra",
                "elefante",
                "hipopotamo",
                "jirafa",
                "leon",
                "leopardo",
                "medusa",
                "mono",
                "oso",
                "oso-blanco",
                "pajaro",
                "pinguino",
                "rinoceronte",
                "serpiente",
                "tigre",
                "tortuga",
                "tortuga-marina"
        };

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String selecionado = fotos[(int) (Math.random() * fotos.length)];

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>"  + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}