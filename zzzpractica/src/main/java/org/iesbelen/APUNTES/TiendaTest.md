

    /**
     * 1. Lista los nombres y los precios de todos los productos de la tabla producto
     */
    @Test

            listProd.stream().map(p-> p.getNombre()+ " "+p.getPrecio()).forEach(System.out::println);


    /**
     * 2. Devuelve una lista de Producto completa con el precio de euros convertido a dólares .
     */
    @Test

            listProd.stream()
                    .map(p-> {
                        p.setPrecio(p.getPrecio() * 1.1);
                        return p;
                    })
                    .forEach(System.out::println);


    /**
     * 3. Lista los nombres y los precios de todos los productos, convirtiendo los nombres a mayúscula.
     */
    @Test
            //TODO STREAMS
            listProd.stream()
                    .map(p-> {
                        p.setNombre(p.getNombre().toUpperCase());
                        return p;
                    }).forEach(System.out::println);

    /**
     * 4. Lista el nombre de todos los fabricantes y a continuación en mayúsculas los dos primeros caracteres del nombre del fabricante.
     */
    @Test

            listFab.stream()
                    .map(f-> f.getNombre() +" "+f.getNombre().toUpperCase().substring(0,2))
                    .forEach(System.out::println);
        }

    /**
     * 5. Lista el código de los fabricantes que tienen productos.
     */
    @Test

            listFab.stream()
                    .filter(f-> !f.getProductos().isEmpty())
                    .map(Fabricante::getIdFabricante)
                    .forEach(System.out::println);
        }

    /**
     * 6. Lista los nombres de los fabricantes ordenados de forma descendente.
     */
    @Test

            //TODO STREAMS
            listFab.stream()
                    .map(Fabricante::getNombre)
                    .sorted(reverseOrder())
                    .forEach(System.out::println);
        }

    /**
     * 7. Lista los nombres de los productosDAOImpl ordenados en primer lugar por el nombre de forma ascendente y en segundo lugar por el precio de forma descendente.
     */
    @Test

            listProd.stream()
                    .sorted(comparing(Producto::getPrecio).thenComparing(Producto::getNombre).reversed())
                    .forEach(System.out::println);

        
    /**
     * 8. Devuelve una lista con los 5 primeros fabricantes.
     */
    @Test

            //TODO STREAMS
            listFab.stream().limit(5).forEach(System.out::println);

    /**
     * 9.Devuelve una lista con 2 fabricantes a partir del cuarto fabricante. El cuarto fabricante también se debe incluir en la respuesta.
     */
    @Test

            listFab.stream()
                    .skip(3).limit(2).forEach(System.out::println);

    /**
     * 10. Lista el nombre y el precio del producto más barato
     */
    @Test

            listProd.stream()
                    .min(comparing(Producto::getPrecio))
                    .map(p-> p.getNombre() +" "+p.getPrecio())
                    .ifPresent(System.out::println);

    /**
     * 11. Lista el nombre y el precio del producto más caro
     */
    @Test

            listProd.stream()
                    .max(comparing(Producto::getPrecio))
                    .map(p-> p.getNombre() +" "+p.getPrecio())
                    .ifPresent(System.out::println);


    /**
     * 12. Lista el nombre de todos los productos del fabricante cuyo código de fabricante es igual a 2.
     *
     */
    @Test

            //TODO STREAMS
            listProd.stream()
                    .filter(p-> p.getFabricante().getIdFabricante()==2)
                    .map(Producto::getNombre)
                    .forEach(System.out::println);


    /**
     * 13. Lista el nombre de los productos que tienen un precio menor o igual a 120€.
     */

            List<Producto> listProd = productosDAOImpl.findAll();
            listProd.stream()
                    .filter(p-> p.getPrecio()<=120)
                    .map(Producto::getNombre)
                    .forEach(System.out::println);

    /**
     * 14. Lista los productos que tienen un precio mayor o igual a 400€.
     */
    @Test

            //TODO STREAMS
            listProd.stream()
                    .filter(p-> p.getPrecio()>=400)
                    .forEach(System.out::println);

    /**
     * 15. Lista todos los productos que tengan un precio entre 80€ y 300€.
     */
    @Test
    void test15() {

            listProd.stream()
                    .filter(p-> p.getPrecio()>=80 && p.getPrecio()<=300)
                    .forEach(System.out::println);

    /**
     * 16. Lista todos los productos que tengan un precio mayor que 200€ y que el código de fabricante sea igual a 6.
     */
    @Test

            listProd.stream()
                    .filter(p-> p.getPrecio()>=200 && p.getFabricante().getIdFabricante()==6)
                    .forEach(System.out::println);

    /**
     * 17. Lista todos los productos donde el código de fabricante sea 1, 3 o 5 utilizando un Set de codigos de fabricantes para filtrar.
     */
    @Test

            //TODO STREAMS
            Set<Integer> codeFabs =Set.of(1,5,7);

            listProd.stream()
                    .filter(p-> codeFabs.contains(p.getFabricante().getIdFabricante()))
                    .forEach(System.out::println);


    /**
     * 18. Lista el nombre y el precio de los productos en céntimos.
     */
    @Test

            listProd.stream()
                    .forEach(p-> System.out.println(p.getNombre()+" "+p.getPrecio()*100));
        }

    /**
     * 19. Lista los nombres de los fabricante cuyo nombre empiece por la letra S
     */
    @Test

            listFab.stream()
                    .filter(f-> f.getNombre().startsWith("S"))
                    .map(Fabricante::getNombre)
                    .forEach(System.out::println);

    /**
     * 20. Devuelve una lista con los productos que contienen la cadena Portátil en el nombre.
     */

            listProd.stream()
                    .filter(p-> p.getNombre().contains("Portátil")
                    ).forEach(System.out::println);

    /**
     * 21. Devuelve una lista con el nombre de todos los productos que contienen la cadena Monitor en el nombre y tienen un precio inferior a 215 €.
     */
    @Test

            listProd.stream()
                    .filter(p-> p.getNombre().contains("Monitor") && p.getPrecio()<215)
                    .map(Producto::getNombre)
                    .forEach(System.out::println);
        

    /**
     * 22. Lista el nombre y el precio de todos los productos que tengan un precio mayor o igual a 180€.
     * Ordene el resultado en primer lugar por el precio (en orden descendente) y en segundo lugar por el nombre (en orden ascendente).
     */
    @Test

            listProd.stream()
                    .filter(p-> p.getPrecio()>=180)
                    .sorted(comparing(Producto::getPrecio).reversed().thenComparing(Producto::getNombre))
                    .forEach(System.out::println);

    /**
     * 23. Devuelve una lista con el nombre del producto, precio y nombre de fabricante de todos los productos de la base de datos.
     * Ordene el resultado por el nombre del fabricante, por orden alfabético.
     */
    @Test

            listProd.stream()
                    .sorted((a,b)-> a.getFabricante().getNombre().compareTo(b.getFabricante().getNombre()))
                    .map(p-> p.getNombre()+" "+p.getPrecio()+" "+p.getFabricante().getNombre())
                    .forEach(System.out::println);


    /**
     * 24. Devuelve el nombre del producto, su precio y el nombre de su fabricante, del producto más caro.
     */
    @Test

            listProd.stream()
                    .min(comparing(Producto::getPrecio))
                    .map(p-> p.getNombre()+" "+p.getPrecio()+" "+p.getFabricante().getNombre())
                    .ifPresent(System.out::println);


    /**
     * 25. Devuelve una lista de todos los productos del fabricante Crucial que tengan un precio mayor que 200€.
     */
    @Test

            listProd.stream()
                    .filter(p-> "Crucial".equals(p.getFabricante().getNombre()) && p.getPrecio()>200)

                    .forEach(System.out::println);

    /**
     * 26. Devuelve un listado con todos los productos de los fabricantes Asus, Hewlett-Packard y Seagate
     */
    @Test

            Set<String> asHese = Set.of("Asus","Hewlett-Packard","Seagate");
            listProd.stream()
                    .filter(p-> asHese.contains(p.getFabricante().getNombre()))
                    .forEach(System.out::println);

    /**
     * 27. Devuelve un listado con el nombre de producto, precio y nombre de fabricante, de todos los productos que tengan un precio mayor o igual a 180€.
     * Ordene el resultado en primer lugar por el precio (en orden descendente) y en segundo lugar por el nombre.
     * El listado debe mostrarse en formato tabla. Para ello, procesa las longitudes máximas de los diferentes campos a presentar y compensa mediante la inclusión de espacios en blanco.
     * La salida debe quedar tabulada como sigue:

     Producto                Precio             Fabricante
     -----------------------------------------------------
     GeForce GTX 1080 Xtreme|611.5500000000001 |Crucial
     Portátil Yoga 520      |452.79            |Lenovo
     Portátil Ideapd 320    |359.64000000000004|Lenovo
     Monitor 27 LED Full HD |199.25190000000003|Asus

     */
    @Test

            listProd.stream()
                    .sorted(comparing(Producto::getPrecio).reversed().thenComparing(Producto::getNombre))
                    .filter(p-> p.getPrecio()>=180)
                    .map(p-> p.getNombre()+" "+p.getPrecio()+" "+p.getFabricante().getNombre())
                    .forEach(System.out::println);

    /**
     * 28. Devuelve un listado de los nombres fabricantes que existen en la base de datos, junto con los nombres productos que tiene cada uno de ellos.
     * El listado deberá mostrar también aquellos fabricantes que no tienen productos asociados.
     * SÓLO SE PUEDEN UTILIZAR STREAM, NO PUEDE HABER BUCLES
 
    @Test

            listFab.stream()
                    .map(f-> "\nFabricante: "+f.getNombre()+"\n\t\t\tProductos:\n\t\t\t"+f.getProductos().stream()
                            .map(Producto::getNombre )
                            .collect(Collectors.joining("\n\t\t\t")))
                    .forEach(System.out::println);

    /**
     * 29. Devuelve un listado donde sólo aparezcan aquellos fabricantes que no tienen ningún producto asociado.
     */
    @Test

            listFab.stream().filter(f->f.getProductos().isEmpty()).forEach(System.out::println);
        }

    /**
     * 30. Calcula el número total de productos que hay en la tabla productos. Utiliza la api de stream.
     */
    @Test

            System.out.println(listProd.stream().count());


    /**
     * 31. Calcula el número de fabricantes con productos, utilizando un stream de Productos.
     */
    @Test

            System.out.println(listProd.stream().map(Producto::getFabricante)
                    .distinct()
                    .count());

    /**
     * 32. Calcula la media del precio de todos los productos
     */
    @Test

            System.out.println(listProd.stream()
                    .mapToDouble(Producto::getPrecio)
                    .average());

    /**
     * 33. Calcula el precio más barato de todos los productos. No se puede utilizar ordenación de stream.
     */
    @Test

            System.out.println(listProd.stream()
                    .mapToDouble(Producto::getPrecio)
                    .min());

    /**
     * 34. Calcula la suma de los precios de todos los productos.
     */
    @Test

            System.out.println(listProd.stream()
                    .mapToDouble(Producto::getPrecio)
                    .sum());

    /**
     * 35. Calcula el número de productos que tiene el fabricante Asus.
     */
    @Test

            System.out.println(listProd.stream()
                    .filter(p-> "Asus".equals(p.getFabricante().getNombre()))
                    .count());

    /**
     * 36. Calcula la media del precio de todos los productosdel fabricante Asus.
     */
    @Test

            listProd.stream()
                    .filter(p-> "Asus".equals(p.getFabricante().getNombre()))
                    .mapToDouble(Producto::getPrecio)
                    .average().ifPresent(System.out::println);
        }

     * 37. Muestra el precio máximo, precio mínimo, precio medio y el número total de productos que tiene el fabricante Crucial.
     *  Realízalo en 1 solo stream principal. Utiliza reduce con Double[] como "acumulador".
     */
    @Test

            //TODO STREAMS

            DoubleSummaryStatistics esta = listProd.stream()
                    .filter(p-> "Crucial".equals(p.getFabricante().getNombre()))
                    .collect(summarizingDouble(Producto::getPrecio));
            System.out.println("Crucial: Max: "+esta.getMax()+" Min: "+esta.getMin()+" Avg: "+esta.getAverage()+"Cantidad "+esta.getCount());

    /**
     * 38. Muestra el número total de productos que tiene cada uno de los fabricantes.
     * El listado también debe incluir los fabricantes que no tienen ningún producto.
     * El resultado mostrará dos columnas, una con el nombre del fabricante y otra con el número de productos que tiene.
     * Ordene el resultado descendentemente por el número de productos. Utiliza String.format para la alineación de los nombres y las cantidades.

    @Test

            listFab.stream()
                    .map(f-> f.getNombre()+"\t"+f.getProductos().stream().count())
                    .sorted((a,b)-> b.split("\t")[1].compareTo(a.split("\t")[1]))
                    .forEach(System.out::println);

    /**
     * 39. Muestra el precio máximo, precio mínimo y precio medio de los productos de cada uno de los fabricantes.
     * El resultado mostrará el nombre del fabricante junto con los datos que se solicitan. Realízalo en 1 solo stream principal. Utiliza reduce con Double[] como "acumulador".
     * Deben aparecer los fabricantes que no tienen productosDAOImpl.
     */
    @Test

            listFab.stream()
                    .map(f-> {
                        DoubleSummaryStatistics esta = f.getProductos().stream()
                                .mapToDouble(Producto::getPrecio)
                                .summaryStatistics();
                        return f.getNombre()+": Max: "+esta.getMax()+" Min: "+esta.getMin()+" Avg: "+esta.getAverage()+"Cantidad "+esta.getCount();
                    })
                    .forEach(System.out::println);

    /**
     * 40. Muestra el precio máximo, precio mínimo, precio medio y el número total de productos de los fabricantes que tienen un precio medio superior a 200€.
     * No es necesario mostrar el nombre del fabricante, con el código del fabricante es suficiente.
     */
    @Test
    void test40() {

            listFab.stream()
                    .filter(f-> f.getProductos()
                            .stream()
                            .mapToDouble(Producto::getPrecio)
                            .average().orElse(0)>200)
                    .map(f-> {
                        DoubleSummaryStatistics esta = f.getProductos().stream()
                                .mapToDouble(Producto::getPrecio)
                                .summaryStatistics();
                        return f.getIdFabricante()+": Max: "+esta.getMax()+" Min: "+esta.getMin()+" Avg: "+esta.getAverage()+"Cantidad "+esta.getCount();
                    })
                    .forEach(System.out::println);


    /**
     * 41. Devuelve un listado con los nombres de los fabricantes que tienen 2 o más productos.
     */

            listFab.stream()
                    .filter(f-> f.getProductos().stream().count()>=2)
                    .map(Fabricante::getNombre)
                    .forEach(System.out::println);
        
    /**
     * 42. Devuelve un listado con los nombres de los fabricantes y el número de productos que tiene cada uno con un precio superior o igual a 220 €.
     * Ordenado de mayor a menor número de productos.
     */
    @Test

            listFab.stream()
                    .map(f->f.getNombre()+"\t"+f.getProductos().stream()
                            .filter(p-> p.getPrecio()>=220)
                            .count())
                    .sorted((a,b)-> b.split("\t")[1].compareTo(a.split("\t")[1]))
                    .forEach(System.out::println);

