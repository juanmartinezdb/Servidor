package org.iesbelen.tiendainformatica.stream.test;

import java.util.*;

import org.iesbelen.tiendainformatica.dao.FabricanteDAO;
import org.iesbelen.tiendainformatica.dao.ProductoDAO;
import org.iesbelen.tiendainformatica.entity.Fabricante;
import org.iesbelen.tiendainformatica.dao.FabricanteDAOImpl;
import org.iesbelen.tiendainformatica.entity.Producto;
import org.iesbelen.tiendainformatica.dao.ProductoDAOImpl;
import org.junit.jupiter.api.Test;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


class TiendaTest {

	private FabricanteDAO fabricantesDAO;
	private ProductoDAO productosDAO;


	public TiendaTest(){
		Fabricante fabricante;
		fabricantesDAO = new FabricanteDAOImpl();
		productosDAO = new ProductoDAOImpl();

		try {
			((FabricanteDAOImpl)fabricantesDAO).beginTransaction();
			((ProductoDAOImpl)productosDAO).beginTransaction();

			// Creación de fabricantes y productos
			// Asus
			fabricante = new Fabricante("Asus");
			fabricantesDAO.create(fabricante);
			productosDAO.create(new Producto(fabricante,"Monitor 27 LED Full HD",199.25));
			productosDAO.create(new Producto(fabricante,"Monitor 24 LED Full HD",119.99));

			// Lenovo
			fabricante = new Fabricante("Lenovo");
			fabricantesDAO.create(fabricante);
			productosDAO.create(new Producto(fabricante,"Portátil IdeaPad 320",359.65));
			productosDAO.create(new Producto(fabricante,"Portátil Yoga 520",452.79));

			// Hewlett-Packard
			fabricante = new Fabricante("Hewlett-Packard");
			fabricantesDAO.create(fabricante);
			productosDAO.create(new Producto(fabricante,"Impresora HP Deskjet 3720",59.99));
			productosDAO.create(new Producto(fabricante,"Impresora HP Laserjet Pro M26nw",111.86));

			// Samsung
			fabricante = new Fabricante("Samsung");
			fabricantesDAO.create(fabricante);
			productosDAO.create(new Producto(fabricante,"Disco SSD 1 TB",72.99));

			// Seagate
			fabricante = new Fabricante("Seagate");
			fabricantesDAO.create(fabricante);
			productosDAO.create(new Producto(fabricante,"Disco duro SATA3 1TB",38.49));

			// Crucial
			fabricante = new Fabricante("Crucial");
			fabricantesDAO.create(fabricante);
			productosDAO.create(new Producto(fabricante,"GeForce GTX 1080 Xtreme",611.55));
			productosDAO.create(new Producto(fabricante,"Memoria RAM DDR4 8GB",24.19));

			// Gigabyte
			fabricante = new Fabricante("Gigabyte");
			fabricantesDAO.create(fabricante);
			productosDAO.create(new Producto(fabricante,"GeForce GTX 1050Ti",319.19));

			// Huawei sin productos a insertar
			fabricante = new Fabricante("Huawei");
			fabricantesDAO.create(fabricante);

			// Xiaomi sin productos a insertar
			fabricante = new Fabricante("Xiaomi");
			fabricantesDAO.create(fabricante);
		}
		catch (RuntimeException e) {
			((FabricanteDAOImpl)fabricantesDAO).rollbackTransaction();
			((ProductoDAOImpl)productosDAO).rollbackTransaction();
			throw e; // or display error message
		}
	}
	
	@Test
	void testSkeletonFrabricante() {

		try {
			((FabricanteDAOImpl)fabricantesDAO).beginTransaction();
	
			List<Fabricante> listFab = fabricantesDAO.findAll();
		
			
			//TODO STREAMS
			

		}
		catch (RuntimeException e) {
			((FabricanteDAOImpl)fabricantesDAO).rollbackTransaction();
		    throw e; // or display error message
		}
	}
	

	@Test
	void testSkeletonProducto() {

		try {
			((ProductoDAOImpl)productosDAO).beginTransaction();

			List<Producto> listProd = productosDAO.findAll();
						
			//TODO STREAMS

		}
		catch (RuntimeException e) {
			((ProductoDAOImpl)productosDAO).rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	@Test
	void testAllFabricante() {

		try {
			((FabricanteDAOImpl)fabricantesDAO).beginTransaction();
	
			List<Fabricante> listFab = fabricantesDAO.findAll();
			assertEquals(9,listFab.size());
		
		}
		catch (RuntimeException e) {
			((FabricanteDAOImpl)fabricantesDAO).rollbackTransaction();
			throw e; // or display error message
		}
	}
	
	@Test
	void testAllProducto() {

		try {
			((ProductoDAOImpl)productosDAO).beginTransaction();
		
			List<Producto> listProd = productosDAO.findAll();
			assertEquals(11,listProd.size());
		}
		catch (RuntimeException e) {
			((ProductoDAOImpl)productosDAO).rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 1. Lista los nombres y los precios de todos los productos de la tabla producto
	 */
	@Test
	void test1() {

		try {
			((ProductoDAOImpl)productosDAO).beginTransaction();
			
			List<Producto> listProd = productosDAO.findAll();

			// TODO STREAM
			//Mi idea
			listProd.forEach(p-> System.out.println("nombre: "+p.getNombre()+" precio: "+p.getPrecio()));

			//version de Daniel
//			List<String> nombre;
//			List<Double> precios;
//
//			for (int i = 0; i < listProd.size(); i++) {
// 			nombre = listProd.stream()  //esto lo va a hacer todo el rato cada vez que entre en el bucle no tiene sentido
//					.map(Producto::getNombre)
//					.collect(toList());
//			precios = listProd.stream() //idem de lo mismo, habria que sacarlo del bucle por lo menos
//					.map(Producto::getPrecio)
//					.collect(toList());
// 				System.out.println("nombre: " + nombre.get(i) + "precio:" + precios.get(i));
//			}
		}
		catch (RuntimeException e) {
			((ProductoDAOImpl)productosDAO).rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	
	/**
	 * 2. Devuelve una lista de Producto completa con el precio de euros convertido a dólares .
	 */
	@Test
	void test2() {
		List<Producto> listProd = null;

		try {
			((ProductoDAOImpl)productosDAO).beginTransaction();

			listProd = productosDAO.findAll();
			System.out.println(listProd);

			//TODO STREAMS
		List<Producto> productoDolar = listProd.stream()
				.map(e-> {
					e.setPrecio(e.getPrecio()*1.1);
							return e;
				})
				.collect(toList());
			productoDolar.forEach(System.out::println);
		}

		catch (RuntimeException e) {
			((ProductoDAOImpl)productosDAO).rollbackTransaction();
			throw e; // or display error message
		}


	}
	
	/**
	 * 3. Lista los nombres y los precios de todos los productos, convirtiendo los nombres a mayúscula.
	 */
	@Test
	void test3() {
		
		try {
			((ProductoDAOImpl)productosDAO).beginTransaction();
		
			List<Producto> listProd = productosDAO.findAll();

			//TODO STREAMS
			listProd.stream()
					.forEach(p-> System.out.println("nombre: "+p.getNombre().toUpperCase()+" precio: "+p.getPrecio()));

		}
		catch (RuntimeException e) {
			((ProductoDAOImpl)productosDAO).rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 4. Lista el nombre de todos los fabricantes y a continuación en mayúsculas los dos primeros caracteres del nombre del fabricante.
	 */
	@Test
	void test4() {

		try {
			((FabricanteDAOImpl)fabricantesDAO).beginTransaction();

			List<Fabricante> listFab = fabricantesDAO.findAll();

			//TODO STREAMS
	listFab.forEach(e-> System.out.println("nombre: "+e.getNombre()+ " "+e.getNombre().substring(0,2).toUpperCase()));
		}
		catch (RuntimeException e) {
			((FabricanteDAOImpl)fabricantesDAO).rollbackTransaction();
			throw e; // or display error message
		}
	}
	
	/**
	 * 5. Lista el código de los fabricantes que tienen productos.
	 */
	@Test
	void test5() {

		try {
			((FabricanteDAOImpl)fabricantesDAO).beginTransaction();

			List<Fabricante> listFab = fabricantesDAO.findAll();
			List<Producto> listProd = productosDAO.findAll();
			//TODO STREAMS
			//version simple
			listFab.stream()
							.filter(fab -> !fab.getProductos().isEmpty())
					.forEach(fab -> {
						System.out.println("Id fabr: " + fab.getIdFabricante());
					});
			System.out.println();

	// version compleja

			listFab.stream()
					.filter(fab -> listProd.stream().anyMatch(prod -> prod.getFabricante().getIdFabricante().equals(fab.getIdFabricante())))
					.forEach(fab -> {
						System.out.println("Id fabr: " + fab.getIdFabricante());
					});

		}
		catch (RuntimeException e) {
			((FabricanteDAOImpl)fabricantesDAO).rollbackTransaction();
			throw e; // or display error message
		}
	}
	
	/**
	 * 6. Lista los nombres de los fabricantes ordenados de forma descendente.
	 */
	@Test
	void test6() {

		try {
			((FabricanteDAOImpl)fabricantesDAO).beginTransaction();

			List<Fabricante> listFab = fabricantesDAO.findAll();

			//TODO STREAMS
			listFab.stream() //da iguale l orden, y así es mas claro
					.sorted(comparing(Fabricante::getNombre))
					.forEach(p -> System.out.println(p.getNombre()));


			//version corregida
	listFab.stream()
			.map(Fabricante::getNombre)
			.sorted(Comparator.reverseOrder())
			.forEach(System.out::println);

		}

		catch (RuntimeException e) {
			((FabricanteDAOImpl)fabricantesDAO).rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 7. Lista los nombres de los productosDAOImpl ordenados en primer lugar por el nombre
	 * de forma ascendente y en segundo lugar por el precio de forma descendente.
	 */
	@Test
	void test7() {

		try {
			((FabricanteDAOImpl)fabricantesDAO).beginTransaction();

			List<Producto> listProd = productosDAO.findAll();

			//TODO STREAMS
			listProd.stream()
					.sorted(comparing(Producto::getPrecio).reversed())
					.sorted(comparing(Producto::getNombre))
					.forEach(p -> {
						System.out.println("nombre " + p.getNombre() + "precio " + p.getPrecio());
					});

			//version samuel
			listProd.stream()
					.sorted(comparing(Producto::getNombre)
					.thenComparing(comparing(Producto::getPrecio).reversed()))
					.forEach(p-> System.out.println(p.getNombre() +" "+ p.getPrecio()));
		}
		catch (RuntimeException e) {
			((ProductoDAOImpl)productosDAO).rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 8. Devuelve una lista con los 5 primeros fabricantes.
	 */
	@Test
	void test8() {

		try {
			((FabricanteDAOImpl)fabricantesDAO).beginTransaction();

			List<Fabricante> listFab = fabricantesDAO.findAll();

			//TODO STREAMS
			List<Fabricante> primerosCinco = listFab.stream()
					.limit(5)
					.collect(toList());
			primerosCinco.forEach(System.out::println);
		}
		catch (RuntimeException e) {
			((FabricanteDAOImpl)fabricantesDAO).rollbackTransaction();
			throw e; // or display error message
		}
	}
	
	/**
	 * 9.Devuelve una lista con 2 fabricantes a partir del cuarto fabricante
	 * . El cuarto fabricante también se debe incluir en la respuesta.
	 */
	@Test
	void test9() {

		try {
			((FabricanteDAOImpl)fabricantesDAO).beginTransaction();

			List<Fabricante> listFab = fabricantesDAO.findAll();

			//TODO STREAMS
			List<Fabricante> dosFab = listFab.stream()
					.filter(f->(listFab.indexOf(f)>=3))
					.limit(2)
					.collect(toList());
			System.out.println(dosFab);

			// version corregida mejor con skip
			listFab.stream()
					.skip(3)
					.limit(2)
					.forEach(System.out::println);
		}
		catch (RuntimeException e) {
			((FabricanteDAOImpl)fabricantesDAO).rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 10. Lista el nombre y el precio del producto más barato
	 */
	@Test
	void test10() {

		try {
			((ProductoDAOImpl)productosDAO).beginTransaction();

			List<Producto> listProd = productosDAO.findAll();

			//TODO STREAMS

			//mejor esta forma
			listProd.stream()
					.min(comparing(Producto::getPrecio))
					.ifPresent(p -> System.out.println("nombre:" + p.getNombre() + " precio:" + p.getPrecio()));

		}
		catch (RuntimeException e) {
			((ProductoDAOImpl)productosDAO).rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 11. Lista el nombre y el precio del producto más caro
	 */
	@Test
	void test11() {
	
		try {
			((ProductoDAOImpl)productosDAO).beginTransaction();

			List<Producto> listProd = productosDAO.findAll();

			//TODO STREAMS
			listProd.stream()
					.sorted(comparing(Producto::getPrecio).reversed())
					.findFirst()
					.ifPresent(p -> {
						System.out.println("nombre:" + p.getNombre() + " precio:" + p.getPrecio());
					});
		}
		catch (RuntimeException e) {
			((ProductoDAOImpl)productosDAO).rollbackTransaction();
			throw e; // or display error message
		}
	}
	
	/**
	 * 12. Lista el nombre de todos los productos del fabricante cuyo código de fabricante es igual a 2.
	 * 
	 */
	@Test
	void test12() {
	
		try {
			((ProductoDAOImpl)productosDAO).beginTransaction();
		
			List<Producto> listProd = productosDAO.findAll();

			//TODO STREAMS
	listProd.stream()
			.filter(p-> p.getFabricante().getIdFabricante()==2)
			.forEach(p-> {
				System.out.println("nombre:" + p.getNombre() + " fabricante: " + p.getFabricante().getNombre());
			});
		}
		catch (RuntimeException e) {
			((ProductoDAOImpl)productosDAO).rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 13. Lista el nombre de los productos que tienen un precio menor o igual a 120€.
	 */
	@Test
	void test13() {
	
		try {
			((ProductoDAOImpl)productosDAO).beginTransaction();
		
			List<Producto> listProd = productosDAO.findAll();

			//TODO STREAMS
			listProd.stream()
					.filter(p-> p.getPrecio()<=120)
					.forEach(p-> {
						System.out.println("nombre: " + p.getNombre() + " precio:" + p.getPrecio());
					});
		}
		catch (RuntimeException e) {
			((ProductoDAOImpl)productosDAO).rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 14. Lista los productos que tienen un precio mayor o igual a 400€.
	 */
	@Test
	void test14() {
	
		try {
			((ProductoDAOImpl)productosDAO).beginTransaction();

			List<Producto> listProd = productosDAO.findAll();

			//TODO STREAMS
			listProd.stream()
					.filter(p-> p.getPrecio()>=400)
					.forEach(System.out::println);
		}
		catch (RuntimeException e) {
			((ProductoDAOImpl)productosDAO).rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 15. Lista todos los productos que tengan un precio entre 80€ y 300€.
	 */
	@Test
	void test15() {
	
		try {
			((ProductoDAOImpl)productosDAO).beginTransaction();

			List<Producto> listProd = productosDAO.findAll();

			//TODO STREAMS
			listProd.stream()
					.filter(p-> (p.getPrecio()>=80)&&(p.getPrecio()<=300))
					.forEach(System.out::println);
		}
		catch (RuntimeException e) {
			((ProductoDAOImpl)productosDAO).rollbackTransaction();
			throw e; // or display error message
		}
	}
	
	/**
	 * 16. Lista todos los productos que tengan un precio mayor que 200€ y que el código de fabricante sea igual a 6.
	 */
	@Test
	void test16() {
	
		try {
			((ProductoDAOImpl)productosDAO).beginTransaction();

			List<Producto> listProd = productosDAO.findAll();

			//TODO STREAMS
			listProd.stream()
					.filter(p-> (p.getPrecio()<200)&&(p.getFabricante().getIdFabricante()==6))
					.forEach(System.out::println);
		}
		catch (RuntimeException e) {
			((ProductoDAOImpl)productosDAO).rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 17. Lista todos los productos donde el código de fabricante sea 1, 3 o 5 utilizando un Set de codigos de fabricantes para filtrar.
	 */
	@Test
	void test17() {
	
		try {
			((ProductoDAOImpl)productosDAO).beginTransaction();

			List<Producto> listProd = productosDAO.findAll();

			//TODO STREAMS
	Set<Producto> setProductos =listProd.stream()
			.filter(p-> p.getFabricante().getIdFabricante()%2==1&&p.getFabricante().getIdFabricante()<=5)
			.collect(toSet());

			setProductos.forEach(System.out::println);

			//version fliper jonathan
			Set<Integer>  codigosFabricantes = Set.of(1,3,5);

			listProd.stream()
					.filter(p -> codigosFabricantes.contains(p.getFabricante().getIdFabricante()))
					.forEach(System.out::println);
		}
		catch (RuntimeException e) {
			((ProductoDAOImpl)productosDAO).rollbackTransaction();
			throw e; // or display error message
		}
	}
	
	/**
	 * 18. Lista el nombre y el precio de los productos en céntimos.
	 */
	@Test
	void test18() {

		try {
			((ProductoDAOImpl) productosDAO).beginTransaction();

			List<Producto> listProd = productosDAO.findAll();

			//TODO STREAMS
			listProd.stream()
					.map(p -> p.getNombre() + " " + p.getPrecio() * 100 +"cents")
					.forEach(System.out::println);
		}
		catch (RuntimeException e) {
			((ProductoDAOImpl)productosDAO).rollbackTransaction();
			throw e; // or display error message
		}
	}
	
	
	/**
	 * 19. Lista los nombres de los fabricante cuyo nombre empiece por la letra S
	 */
	@Test
	void test19() {

		try {
			((FabricanteDAOImpl)fabricantesDAO).beginTransaction();

			List<Fabricante> listFab = fabricantesDAO.findAll();

			//TODO STREAMS
		listFab.stream()
				.filter(fab ->'S'==fab.getNombre().toUpperCase().charAt(0))
				.forEach(System.out::println);
		}
		catch (RuntimeException e) {
			((FabricanteDAOImpl)fabricantesDAO).rollbackTransaction();
		    throw e; // or display error message
		}
		
	}
	
	/**
	 * 20. Devuelve una lista con los productos que contienen la cadena Portátil en el nombre.
	 */
	@Test
	void test20() {

		try {
			((ProductoDAOImpl)productosDAO).beginTransaction();
		
			List<Producto> listProd = productosDAO.findAll();

			//TODO STREAMS
			List<Producto> portatiles = listProd.stream()
					.filter(p-> p.getNombre().contains("Portátil"))
					.toList();
			portatiles.forEach(System.out::println);
		}
		catch (RuntimeException e) {
			((ProductoDAOImpl)productosDAO).rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 21. Devuelve una lista con el nombre de todos los productos que
	 * contienen la cadena Monitor en el nombre y tienen un precio inferior a 215 €.
	 */
	@Test
	void test21() {

		try {
			((ProductoDAOImpl)productosDAO).beginTransaction();

			List<Producto> listProd = productosDAO.findAll();

			//TODO STREAMS
		List<String> monitoresBaratos = listProd.stream()
				.filter(p-> p.getNombre().contains("Monitor")&& p.getPrecio()<215)
				.map(Producto::getNombre)
				.toList();
		monitoresBaratos.forEach(System.out::println);
		}
		catch (RuntimeException e) {
			((ProductoDAOImpl)productosDAO).rollbackTransaction();
			throw e; // or display error message
		}
	}
	
	/**
	 * 22. Lista el nombre y el precio de todos los productos que tengan un precio mayor o igual a 180€.
	 * Ordene el resultado en primer lugar por el precio (en orden descendente)
	 * y en segundo lugar por el nombre (en orden ascendente).
	 */
	@Test
	void test22() {

		try {
			((ProductoDAOImpl)productosDAO).beginTransaction();

			List<Producto> listProd = productosDAO.findAll();

			//TODO STREAMS
			listProd.stream()
					.filter(p-> p.getPrecio()>=180)
					.sorted(comparing(Producto::getNombre))
					.sorted(comparing(Producto::getPrecio).reversed())
					.forEach(System.out::println);

			//version revisada
			listProd.stream()
					.filter(p-> p.getPrecio()>=180)
					.sorted(comparing(Producto::getPrecio).reversed()
							.thenComparing(Producto::getNombre))
					.forEach(System.out::println);
		}
		catch (RuntimeException e) {
			((ProductoDAOImpl)productosDAO).rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 23. Devuelve una lista con el nombre del producto, precio y nombre de fabricante de todos los productos de la base de datos.
	 * Ordene el resultado por el nombre del fabricante, por orden alfabético.
	 */
	@Test
	void test23() {

		try {
			((ProductoDAOImpl)productosDAO).beginTransaction();

			List<Producto> listProd = productosDAO.findAll();

			//TODO STREAMS
			List<String> fabricantesAlfabetico = listProd.stream()
					.sorted((a, b) -> a.getFabricante().getNombre().compareTo(b.getFabricante().getNombre()))
					.map(p -> p.getNombre() +" "+ p.getPrecio() +" "+ p.getFabricante().getNombre())
					.toList();
			fabricantesAlfabetico.forEach(System.out::println);



		}
		catch (RuntimeException e) {
			((ProductoDAOImpl)productosDAO).rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 24. Devuelve el nombre del producto, su precio y el nombre de su fabricante, del producto más caro.
	 */
	@Test
	void test24() {
		

		try {
			((ProductoDAOImpl)productosDAO).beginTransaction();

			List<Producto> listProd = productosDAO.findAll();

			//TODO STREAMS
			listProd.stream()
					.max(Comparator.comparing(Producto::getPrecio))
					.map(p -> p.getNombre() +" "+ p.getPrecio() +" "+ p.getFabricante().getNombre())
					.ifPresent(System.out::println);

		}
		catch (RuntimeException e) {
			((ProductoDAOImpl)productosDAO).rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 25. Devuelve una lista de todos los productos del fabricante Crucial que tengan un precio mayor que 200€.
	 */
	@Test
	void test25() {

		try {
			((ProductoDAOImpl)productosDAO).beginTransaction();

			List<Producto> listProd = productosDAO.findAll();

			//TODO STREAMS
			List<Producto> crucial200 = listProd.stream()
					.filter(p -> "Crucial".equals(p.getFabricante().getNombre())&&p.getPrecio()>200)
					.toList();
			crucial200.forEach(System.out::println);
        }
		catch (RuntimeException e) {
			((ProductoDAOImpl)productosDAO).rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 26. Devuelve un listado con todos los productos de los fabricantes Asus, Hewlett-Packard y Seagate
	 */
	@Test
	void test26() {

		try {
			((ProductoDAOImpl)productosDAO).beginTransaction();

			List<Producto> listProd = productosDAO.findAll();

			//TODO STREAMS
			List<Producto> asuHewSea = listProd.stream()
					.filter(p-> "Asus".equals(p.getFabricante().getNombre())
							||"Hewlett-Packard".equals(p.getFabricante().getNombre())
							||"Seagate".equals(p.getFabricante().getNombre()))
					.toList();
			asuHewSea.forEach(System.out::println);

			//Version mas limpita y clara
			Set<String> ahs = Set.of("Asus", "Hewlett-Packard", "Seagate");
			listProd.stream()
					.filter(p -> ahs.contains(p.getFabricante().getNombre()))
					.forEach(System.out::println);
		}
		catch (RuntimeException e) {
			((ProductoDAOImpl)productosDAO).rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
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
	void test27() {

		try {
			((ProductoDAOImpl)productosDAO).beginTransaction();

			List<Producto> listProd = productosDAO.findAll();

			//TODO STREAMS


		}
		catch (RuntimeException e) {
			((ProductoDAOImpl)productosDAO).rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
Fabricante: Asus

            	Productos:
            	Monitor 27 LED Full HD
            	Monitor 24 LED Full HD

Fabricante: Lenovo

            	Productos:
            	Portátil Ideapd 320
            	Portátil Yoga 520

Fabricante: Hewlett-Packard

            	Productos:
            	Impresora HP Deskjet 3720
            	Impresora HP Laserjet Pro M26nw

Fabricante: Samsung

            	Productos:
            	Disco SSD 1 TB

Fabricante: Seagate

            	Productos:
            	Disco duro SATA3 1TB

Fabricante: Crucial

            	Productos:
            	GeForce GTX 1080 Xtreme
            	Memoria RAM DDR4 8GB

Fabricante: Gigabyte

            	Productos:
            	GeForce GTX 1050Ti

Fabricante: Huawei

            	Productos:


Fabricante: Xiaomi

            	Productos:
	 * 28. Devuelve un listado de los nombres fabricantes que existen en la base de datos,
	 * junto con los nombres productos que tiene cada uno de ellos.
	 * El listado deberá mostrar también aquellos fabricantes que no tienen productos asociados.
	 * SÓLO SE PUEDEN UTILIZAR STREAM, NO PUEDE HABER BUCLES
	 * La salida debe queda como sigue:
	 */
	@Test
	void test28() {

		try {
			((FabricanteDAOImpl)fabricantesDAO).beginTransaction();

			List<Fabricante> listFab = fabricantesDAO.findAll();
			//TODO STREAMS
	listFab.stream()
			.map(fab-> "Fabricante: "+fab.getNombre() +"\n\t Productos:\n" + fab.getProductos().stream()
					.map(p->"\t\t"+p.getNombre())
					.collect(joining("\n"))+"\n")
			.forEach(System.out::println);

		}
		catch (RuntimeException e) {
			((FabricanteDAOImpl)fabricantesDAO).rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 29. Devuelve un listado donde sólo aparezcan aquellos fabricantes que no tienen ningún producto asociado.
	 */
	@Test
	void test29() {

		try {
			((FabricanteDAOImpl)fabricantesDAO).beginTransaction();

			List<Fabricante> listFab = fabricantesDAO.findAll();

			//TODO STREAMS
		List<Fabricante> sinProductos = listFab.stream()
				.filter(p -> p.getProductos().isEmpty() )
				.toList();
		sinProductos.forEach(System.out::println);
		}
		catch (RuntimeException e) {
			((FabricanteDAOImpl)fabricantesDAO).rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 30. Calcula el número total de productos que hay en la tabla productos. Utiliza la api de stream.
	 */
	@Test
	void test30() {

		try {
			((ProductoDAOImpl)productosDAO).beginTransaction();
		
			List<Producto> listProd = productosDAO.findAll();

			//TODO STREAMS
			System.out.println( "hay un total de: "+listProd.stream()
					.count());
		}
		catch (RuntimeException e) {
			((ProductoDAOImpl)productosDAO).rollbackTransaction();
		    throw e; // or display error message
		}
	}

	
	/**
	 * 31. Calcula el número de fabricantes con productos, utilizando un stream de Productos.
	 */
	@Test
	void test31() {

		try {
			((ProductoDAOImpl)productosDAO).beginTransaction();

			List<Producto> listProd = productosDAO.findAll();

			//TODO STREAMS
			int fabricantes = (int) listProd.stream()
					.map(Producto::getFabricante)
					.distinct()
					.count();
			System.out.println(fabricantes);


		}
		catch (RuntimeException e) {
			((ProductoDAOImpl)productosDAO).rollbackTransaction();
		    throw e; // or display error message
		}
		
	}
	
	/**
	 * 32. Calcula la media del precio de todos los productos
	 */
	@Test
	void test32() {

		try {
			((ProductoDAOImpl)productosDAO).beginTransaction();

			List<Producto> listProd = productosDAO.findAll();

			//TODO STREAMS
			System.out.println(listProd.stream()
					.mapToDouble(Producto::getPrecio) //lo va recogiendo en double
					.average());

        }
		catch (RuntimeException e) {
			((ProductoDAOImpl)productosDAO).rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 33. Calcula el precio más barato de todos los productos. No se puede utilizar ordenación de stream.
	 */
	@Test
	void test33() {

		try {
			((ProductoDAOImpl)productosDAO).beginTransaction();

			List<Producto> listProd = productosDAO.findAll();

			//TODO STREAMS
			listProd.stream()
					.mapToDouble(Producto::getPrecio)
					.min().ifPresent(System.out::println);

			//version profe


		}
		catch (RuntimeException e) {
			((ProductoDAOImpl)productosDAO).rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 34. Calcula la suma de los precios de todos los productos.
	 */
	@Test
	void test34() {

		try {
			((ProductoDAOImpl)productosDAO).beginTransaction();

			List<Producto> listProd = productosDAO.findAll();

			//TODO STREAMS
			System.out.println(listProd.stream()
					.mapToDouble(Producto::getPrecio)
					.sum());

			//version victor
			Double total = listProd.stream()
					.map(Producto::getPrecio)
					.reduce(0.0, Double::sum);
			System.out.println(total);
		}

		catch (RuntimeException e) {
			((ProductoDAOImpl)productosDAO).rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 35. Calcula el número de productos que tiene el fabricante Asus.
	 */
	@Test
	void test35() {

		try {
			((ProductoDAOImpl)productosDAO).beginTransaction();

			List<Producto> listProd = productosDAO.findAll();

			//TODO STREAMS
			System.out.println(listProd.stream()
							.filter(p-> "Asus".equals(p.getFabricante().getNombre()))
							.count());

		}
		catch (RuntimeException e) {
			((ProductoDAOImpl)productosDAO).rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 36. Calcula la media del precio de todos los productosdel fabricante Asus.
	 */
	@Test
	void test36() {

		try {
			((ProductoDAOImpl)productosDAO).beginTransaction();

			List<Producto> listProd = productosDAO.findAll();

			//TODO STREAMS
			OptionalDouble media = listProd.stream()
					.filter(p-> p.getFabricante().getNombre().equals("Asus"))
					.mapToDouble(Producto::getPrecio)
					.average();

			media.ifPresent(System.out::println);

			//corregido
//			listProd.stream()
//					.filter(p-> "Asus".equals(p.getFabricante().getNombre()))
//					.
		}
		catch (RuntimeException e) {
			((ProductoDAOImpl)productosDAO).rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	
	/**
	 * 37. Muestra el precio máximo, precio mínimo, precio medio y el número
	 * total de productos que tiene el fabricante Crucial.
	 *  Realízalo en 1 solo stream principal. Utiliza reduce con Double[] como "acumulador".
	 */
	@Test
	void test37() {

		try {
			((ProductoDAOImpl)productosDAO).beginTransaction();

			List<Producto> listProd = productosDAO.findAll();

			//TODO STREAMS
			DoubleSummaryStatistics crucial = listProd.stream()
					.filter(p -> p.getFabricante().getNombre().equals("Crucial"))
					.collect(summarizingDouble(Producto::getPrecio));
			System.out.println(crucial);

			//Version acumulador
			Double[] sum = listProd.stream()
					.filter(p -> p.getFabricante().getNombre().equals("Crucial"))
					.map(Producto::getPrecio)
					.reduce(new Double[]{Double.MIN_VALUE, Double.MAX_VALUE, 0.0, 0.0}, (acumulador, precio) -> {
								// Actualización del acumulador
								acumulador[0] = Math.max(acumulador[0], precio); // Precio máximo
								acumulador[1] = Math.min(acumulador[1], precio); // Precio mínimo
								acumulador[2] += precio; // Suma total de precios
								acumulador[3] += 1; // Contador de productos
								return acumulador;
							},
							(a1, a2) -> a1
							//{ esto no lo entiendo se supone que es si se hacen operaciones en paralelo, pero no consigo ajustar esto sin esta parte
								// Combinación de dos acumuladores????
//								a1[0] = Math.max(a1[0], a2[0]);
//								a1[1] = Math.min(a1[1], a2[1]);
//								a1[2] += a2[2];
//								a1[3] += a2[3];
//								return a1;
							//}
		);

			System.out.println("máximo: " + sum[0]);
			System.out.println("mínimo: " + sum[1]);
			System.out.println("medio: " + sum[2]/sum[3]);
			System.out.println("Total: " + sum[3]);
		}
		catch (RuntimeException e) {
			((ProductoDAOImpl)productosDAO).rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 38. Muestra el número total de productos que tiene cada uno de los fabricantes.
	 * El listado también debe incluir los fabricantes que no tienen ningún producto. 
	 * El resultado mostrará dos columnas, una con el nombre del fabricante y otra con el número de productos que tiene.
	 * Ordene el resultado descendentemente por el número de productos. Utiliza String.format para la alineación de los nombres y las cantidades.
	 * La salida debe queda como sigue:
	 
     Fabricante     #Productos
-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
           Asus              2
         Lenovo              2
Hewlett-Packard              2
        Samsung              1
        Seagate              1
        Crucial              2
       Gigabyte              1
         Huawei              0
         Xiaomi              0

	 */
	@Test
	void test38() {

		try {
			((FabricanteDAOImpl)fabricantesDAO).beginTransaction();

			List<Fabricante> listFab = fabricantesDAO.findAll();

			//TODO STREAMS
	listFab.stream()
			.map(fab-> fab.getNombre()+"\t" +fab.getProductos().stream().count())
			.sorted((a,b) ->a.split("\t")[1].compareTo(b.split("\t")[1]))
			.forEach(System.out::println);
		}
		catch (RuntimeException e) {
			((FabricanteDAOImpl)fabricantesDAO).rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 39. Muestra el precio máximo, precio mínimo y precio medio de los productos de cada uno de los fabricantes.
	 * El resultado mostrará el nombre del fabricante junto con los datos que se solicitan.
	 * Realízalo en 1 solo stream principal. Utiliza reduce con Double[] como "acumulador".
	 * Deben aparecer los fabricantes que no tienen productosDAOImpl.
	 */
	@Test
	void test39() {

		try {
			((FabricanteDAOImpl)fabricantesDAO).beginTransaction();

			List<Fabricante> listFab = fabricantesDAO.findAll();

			//TODO STREAMS


			//con sumarizingDouble
			List<String> estadisticas = listFab.stream()
							.map(f-> {
								DoubleSummaryStatistics esta = f.getProductos().stream().collect(summarizingDouble(Producto::getPrecio));
								return "Fabricante: "+f.getNombre()
										+" minimo: "+((esta.getCount()!=0)?esta.getMin():"")+
										" max:"+((esta.getCount()!=0)?esta.getMax():"")+
										" media:"+((esta.getCount()!=0)?esta.getAverage():"")+
										" cantidad:"+esta.getCount();
							}).toList();
			estadisticas.forEach(System.out::println);

//			//Retry
//			DoubleSummaryStatistics estadisticcas = listFab.stream()
//							.flatMap(f-> f.getProductos().stream()).collect(summarizingDouble(Producto::getPrecio));

			//la de antes
	listFab.stream()
			.map(fab-> fab.getNombre()+"\t" +
					Arrays.toString(fab.getProductos().stream().map(Producto::getPrecio)
					.reduce(new Double[]{Double.MIN_VALUE, Double.MAX_VALUE, 0.0, 0.0}, (acumulador, precio)->{
						acumulador[0] = Math.max(acumulador[0], precio);
						acumulador[1] = Math.min(acumulador[1], precio);
						acumulador[2] = acumulador[2] + precio;
						acumulador[3] = acumulador[3] +1;
						return acumulador;
					},
							(a1,a2) ->{
								a1[0] = Math.max(a1[0], a2[0]);
								a1[1] = Math.min(a1[1], a2[1]);
								a1[2] += a2[2];
								a1[3] += a2[3];
								return a1;
							}))).forEach(System.out::println);

		}
		catch (RuntimeException e) {
			((FabricanteDAOImpl)fabricantesDAO).rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 40. Muestra el precio máximo, precio mínimo, precio medio y el número total de productos de los fabricantes que tienen un precio medio superior a 200€.
	 * No es necesario mostrar el nombre del fabricante, con el código del fabricante es suficiente.
	 */
	@Test
	void test40() {

		try {
			((FabricanteDAOImpl)fabricantesDAO).beginTransaction();

			List<Fabricante> listFab = fabricantesDAO.findAll();

			//TODO STREAMS
//			listFab.stream()
//					.filter(fab-> fab.getProductos().stream().mapToDouble(Producto::getPrecio).average()>200)

			listFab.stream()
					.filter(fab -> {
                        return fab.getProductos().stream().mapToDouble(Producto::getPrecio).average().orElse(0) > 200; //el orElse se hace porque al final se esta generando un optional
						//entonces puede que sea un nulo y para evitar que pete se le pone un 0
                    })
					//.map(fab -> fab.getIdFabricante() +"\t" + fab.getProductos().stream().collect(summarizingDouble(Producto::getPrecio)) no furula asi
					.map(fab ->
			{
						DoubleSummaryStatistics numeros = fab.getProductos().stream()
								.collect(summarizingDouble(Producto::getPrecio));

						return fab.getIdFabricante() + " Estadísticas: " + numeros;
					})
					.forEach(System.out::println);

		}
		catch (RuntimeException e) {
			((FabricanteDAOImpl)fabricantesDAO).rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 41. Devuelve un listado con los nombres de los fabricantes que tienen 2 o más productos.
	 */
	@Test
	void test41() {

		try {
			((FabricanteDAOImpl)fabricantesDAO).beginTransaction();

			List<Fabricante> listFab = fabricantesDAO.findAll();

			//TODO STREAMS
			List<String> con2 = listFab.stream()
					.filter(fab -> fab.getProductos().size()>=2)
					.map(Fabricante::getNombre)
					.toList();
			con2.forEach(System.out::println);



		}
		catch (RuntimeException e) {
			((FabricanteDAOImpl)fabricantesDAO).rollbackTransaction();
			throw e; // or display error message
		}
	}
	
	/**
	 * 42. Devuelve un listado con los nombres de los fabricantes y el número de productos que tiene cada uno con un precio superior o igual a 220 €.
	 * Ordenado de mayor a menor número de productos.
	 */
	@Test
	void test42() {

		try {
			((FabricanteDAOImpl)fabricantesDAO).beginTransaction();

			List<Fabricante> listFab = fabricantesDAO.findAll();

			//TODO STREAMS
	listFab.stream()
			.map(fab -> fab.getNombre() +"\t"+ (fab.getProductos().stream().filter(p-> p.getPrecio()>=200)).count())
			.sorted((a,b)->b.split("\t")[1].compareTo(a.split("\t")[1]))
			.forEach(System.out::println);

	//solucion
			listFab.stream()
					.map(fab -> {
						return new Object[] {fab.getNombre(), fab.getProductos().stream().filter(p-> p.getPrecio()>=200).count()};
					})
					.sorted(comparing(o-> (Long)o[1], reverseOrder()))
					.forEach(o-> System.out.println(o[0]+": "+o[1]));
		}
		catch (RuntimeException e) {
			((FabricanteDAOImpl)fabricantesDAO).rollbackTransaction();
			throw e; // or display error message
		}
	}
	
	/**
	 * 43.Devuelve un listado con los nombres de los fabricantes donde la suma del precio de todos sus productos es superior a 1000 €
	 */
	@Test
	void test43() {

		try {
			((FabricanteDAOImpl)fabricantesDAO).beginTransaction();

			List<Fabricante> listFab = fabricantesDAO.findAll();

			//TODO STREAMS
			listFab.stream()
					.filter(fab-> fab.getProductos().stream().mapToDouble(Producto::getPrecio).sum()>500) //no sale ninguno pero si lo bajo a 500 si sale algo asi que creo que esta bien
					.map(Fabricante::getNombre)
					.forEach(System.out::println);

		}
		catch (RuntimeException e) {
			((FabricanteDAOImpl)fabricantesDAO).rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 44. Devuelve un listado con los nombres de los fabricantes donde la suma del precio de todos sus productos es superior a 1000 €
	 * Ordenado de menor a mayor por cuantía de precio de los productos.
	 */
	@Test
	void test44() {

		try {
			((FabricanteDAOImpl)fabricantesDAO).beginTransaction();

			List<Fabricante> listFab = fabricantesDAO.findAll();

			//TODO STREAMS
			listFab.stream()
					.filter(fab-> fab.getProductos().stream().mapToDouble(Producto::getPrecio).sum()>500) //no sale ninguno pero si lo bajo a 500 si sale algo asi que creo que esta bien
					.map(fab-> fab.getNombre()+"\t"+fab.getProductos().stream().mapToDouble(Producto::getPrecio).sum())
					.sorted((a,b)->a.split("\t")[1].compareTo(b.split("\t")[1]))
					.forEach(System.out::println);


		}
		catch (RuntimeException e) {
			((FabricanteDAOImpl)fabricantesDAO).rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 45. Devuelve un listado con el nombre del producto más caro que tiene cada fabricante. 
	 * El resultado debe tener tres columnas: nombre del producto, precio y nombre del fabricante. 
	 * El resultado tiene que estar ordenado alfabéticamente de menor a mayor por el nombre del fabricante.
	 */
	@Test
	void test45() {

		try {
			((FabricanteDAOImpl)fabricantesDAO).beginTransaction();

			List<Fabricante> listFab = fabricantesDAO.findAll();

			//TODO STREAMS
			listFab.stream()
					.map(fab-> fab.getProductos().stream()
							.max(Comparator.comparing(Producto::getPrecio))
							.map(p-> "PRoducto:\t"+p.getNombre()+"\t"+p.getPrecio()+" Fabricante:\t"+p.getFabricante().getNombre()).orElse("Fabricante:\t "+fab.getNombre()+" (sin productos)"))
					.sorted((a,b)->a.split("Fabricante:\t")[1].compareTo(b.split("Fabricante:\t")[1]))
					.forEach(System.out::println);


		}
		catch (RuntimeException e) {
			((FabricanteDAOImpl)fabricantesDAO).rollbackTransaction();
		    throw e; // or display error message
		}
	}
}

