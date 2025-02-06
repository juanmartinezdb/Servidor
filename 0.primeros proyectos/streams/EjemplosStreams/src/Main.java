import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Trader raoul = new Trader("Raul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000), new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710), new Transaction(mario, 2012, 700), new Transaction(alan, 2012, 950));

        // 1 Encuentre todas las transacciones del año 2011 y ordénelas por valor (menor a mayor).
            List<Transaction> trans2011 = transactions.stream()
                    .filter(e-> e.getAnio()==2011)
                    .sorted(comparing(Transaction::getValor)) //.sorted(comparing(e-> e.getValor ()))
                    .collect(toList());
        System.out.println(trans2011);

        // 2 ¿Cuáles son todas las ciudades (sin repetición) donde trabajan los traders?
        List<String> ciudades = transactions.stream()
                .map(e-> e.getTrader().getCiudad())
                .distinct()
                .collect(toList());
        System.out.println(ciudades);


        // O mediante toSet
    Set<String> ciudades2 = transactions.stream()
            .map(e-> e.getTrader().getCiudad())
            .collect(toSet());
        System.out.println(ciudades2);

        // 3 Encuentre todos los traders de Cambridge y ordénelos por nombre.

        List<Trader> traders = transactions.stream()
                .map(e-> e.getTrader())// se puede usar transaction::getTrader
                .filter(e-> ("Cambridge".equals(e.getCiudad())))
                .distinct()
                .sorted(comparing(Trader::getNombre))
                .collect(toList());
        System.out.println(traders);

        // 4 Devuelva los nombres de todos los traders ordenados alfabéticamente en una sola cadena
            String nombres =  transactions.stream()
                    .map(e-> e.getTrader().getNombre())
                    .distinct()
                    .sorted()
                    .reduce("", (n1,n2)->n1+n2+" ");
        System.out.println(nombres);

        // O mediante joining
    String nombres2 = transactions.stream()
            .map(e-> e.getTrader().getNombre())
            .distinct()
            .sorted()
            .collect(joining(" "));
        System.out.println(nombres2);

        // 5 ¿Hay traders con sede en Milán? Sí o no
        System.out.println(transactions.stream()
                .anyMatch(e-> e.getTrader().getCiudad().equals("Milan")));

        // 6 Imprime los valores de todas las transacciones de los traders que viven en Cambridge.
        transactions.stream()
                .filter(e-> e.getTrader().getCiudad().equals("Cambridge"))
                .map(Transaction::getValor) //igual que .map(e-> e.getValor)
                .forEach(System.out::println);


        // 7 ¿Cuál es el valor más alto de todas las transacciones?
        Optional maximo = transactions.stream()
                .map(Transaction::getValor)
                .reduce(Integer::max);
        System.out.println(maximo);
        // 8 Encuentra la transacción con el valor más pequeño.
        Optional minimo = transactions.stream()
                        .min(comparing(Transaction::getValor)); //Otra forma de hacerlo
        System.out.println(minimo);

    }

}