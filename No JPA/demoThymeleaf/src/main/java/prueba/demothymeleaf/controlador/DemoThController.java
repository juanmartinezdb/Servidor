package prueba.demothymeleaf.controlador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import prueba.demothymeleaf.modelo.Libro;

@Controller
public class DemoThController {

    @GetMapping("/demoth1")
    public String demoTH(Model model) {

        String textoParrafo2 = "Esto es el texto que irá dentro del párrafo...";
        model.addAttribute("parrafo2", textoParrafo2);

        return "demoth1";
    }

    @GetMapping("/demoth2")
    public String demoth2(Model model) {
        String texto = "patata";
        model.addAttribute("texto", texto);

        List<Libro> libros = new ArrayList<>();

        libros.add(new Libro("El Quijote", "Miguel Cervantes", "Anaya"));
        libros.add(new Libro("Crimen y Castigo", "Fedor Dostoievski", "Santillana"));
        libros.add(new Libro("Oliver Twist", "Charles Dickens", "Tusquests"));

        model.addAttribute("listaLibros", libros);

        return "demoth2";

    }

    @GetMapping("/demoth3")
    public String demoth3(Model model, HttpSession session) {

        String variable = "Hola, mundo!";

        model.addAttribute("unaVariable", variable);

        String variableSesion = "Esto es una variable de sesión...";

        session.setAttribute("unaVariableDeSesion", variableSesion);

        Libro libro = new Libro("El Quijote", "Miguel Cervantes", "Anaya");
        session.setAttribute("ElQuijote", libro);

        return "demoth3";
    }
    @GetMapping("/demoth4")
    public String demoth4(Model model) {

        Libro libro = new Libro("El Quijote", "Miguel Cervantes", "Anaya");

        model.addAttribute("libro", libro);

        return "demoth4";
    }

    @GetMapping("/demoth5")
    public String demoth5(Model model) {

        Libro libro = new Libro(1, "El Quijote", "Miguel Cervantes", "Anaya");

        model.addAttribute("libro", libro);

        return "demoth5";
    }
    @GetMapping("/demoth6")
    public String demoth6(Model model) {

        Libro libro = new Libro(1, "El Quijote", "Miguel Cervantes", "Anaya");

        model.addAttribute("libro", libro);

        return "demoth6";
    }

    @GetMapping("/demoth7")
    public String demoth7(Model model) {

        return "demoth7";
    }



}

