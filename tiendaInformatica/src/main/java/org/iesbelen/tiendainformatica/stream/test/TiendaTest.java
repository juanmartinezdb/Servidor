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
		}

		catch (RuntimeException e) {
			((ProductoDAOImpl)productosDAO).rollbackTransaction();
			throw e; // or display error message
		}
		System.out.println(listProd);

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
			listProd.forEach(p-> System.out.println("nombre: "+p.getNombre().toUpperCase()+" precio: "+p.getPrecio()));

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

		}
		catch (RuntimeException e) {
			((FabricanteDAOImpl)fabricantesDAO).rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 7. Lista los nombres de los productosDAOImpl ordenados en primer lugar por el nombre de forma ascendente y en segundo lugar por el precio de forma descendente.
	 */
	@Test
	void test7() {

		try {
			((FabricanteDAOImpl)fabricantesDAO).beginTransaction();

			List<Producto> listProd = productosDAO.findAll();

			//TODO STREAMS

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

		}
		catch (RuntimeException e) {
			((FabricanteDAOImpl)fabricantesDAO).rollbackTransaction();
			throw e; // or display error message
		}
	}
	
	/**
	 * 9.Devuelve una lista con 2 fabricantes a partir del cuarto fabricante. El cuarto fabricante también se debe incluir en la respuesta.
	 */
	@Test
	void test9() {

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
	
	/**
	 * 10. Lista el nombre y el precio del producto más barato
	 */
	@Test
	void test10() {

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
	 * 11. Lista el nombre y el precio del producto más caro
	 */
	@Test
	void test11() {
	
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
	 * 12. Lista el nombre de todos los productos del fabricante cuyo código de fabricante es igual a 2.
	 * 
	 */
	@Test
	void test12() {
	
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
	 * 13. Lista el nombre de los productos que tienen un precio menor o igual a 120€.
	 */
	@Test
	void test13() {
	
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
	 * 14. Lista los productos que tienen un precio mayor o igual a 400€.
	 */
	@Test
	void test14() {
	
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
	 * 15. Lista todos los productos que tengan un precio entre 80€ y 300€.
	 */
	@Test
	void test15() {
	
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
	 * 16. Lista todos los productos que tengan un precio mayor que 200€ y que el código de fabricante sea igual a 6.
	 */
	@Test
	void test16() {
	
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
	 * 17. Lista todos los productos donde el código de fabricante sea 1, 3 o 5 utilizando un Set de codigos de fabricantes para filtrar.
	 */
	@Test
	void test17() {
	
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
	 * 18. Lista el nombre y el precio de los productos en céntimos.
	 */
	@Test
	void test18() {

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
	 * 19. Lista los nombres de los fabricante cuyo nombre empiece por la letra S
	 */
	@Test
	void test19() {

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
	
	/**
	 * 20. Devuelve una lista con los productos que contienen la cadena Portátil en el nombre.
	 */
	@Test
	void test20() {

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
	 * 21. Devuelve una lista con el nombre de todos los productos que contienen la cadena Monitor en el nombre y tienen un precio inferior a 215 €.
	 */
	@Test
	void test21() {

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
	 * 22. Lista el nombre y el precio de todos los productos que tengan un precio mayor o igual a 180€.
	 * Ordene el resultado en primer lugar por el precio (en orden descendente) y en segundo lugar por el nombre (en orden ascendente).
	 */
	@Test
	void test22() {

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
	 * 23. Devuelve una lista con el nombre del producto, precio y nombre de fabricante de todos los productos de la base de datos.
	 * Ordene el resultado por el nombre del fabricante, por orden alfabético.
	 */
	@Test
	void test23() {

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
	 * 24. Devuelve el nombre del producto, su precio y el nombre de su fabricante, del producto más caro.
	 */
	@Test
	void test24() {
		

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
	 * 25. Devuelve una lista de todos los productos del fabricante Crucial que tengan un precio mayor que 200€.
	 */
	@Test
	void test25() {

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
	 * 26. Devuelve un listado con todos los productos de los fabricantes Asus, Hewlett-Packard y Seagate
	 */
	@Test
	void test26() {

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
	 * 28. Devuelve un listado de los nombres fabricantes que existen en la base de datos, junto con los nombres productos que tiene cada uno de ellos.
	 * El listado deberá mostrar también aquellos fabricantes que no tienen productos asociados.
	 * SÓLO SE PUEDEN UTILIZAR STREAM, NO PUEDE HABER BUCLES
	 * La salida debe queda como sigue:
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

	 */
	@Test
	void test28() {

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
	
	/**
	 * 29. Devuelve un listado donde sólo aparezcan aquellos fabricantes que no tienen ningún producto asociado.
	 */
	@Test
	void test29() {

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
	
	/**
	 * 30. Calcula el número total de productos que hay en la tabla productos. Utiliza la api de stream.
	 */
	@Test
	void test30() {

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
	 * 31. Calcula el número de fabricantes con productos, utilizando un stream de Productos.
	 */
	@Test
	void test31() {

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
	 * 32. Calcula la media del precio de todos los productos
	 */
	@Test
	void test32() {

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
	 * 33. Calcula el precio más barato de todos los productos. No se puede utilizar ordenación de stream.
	 */
	@Test
	void test33() {

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
	 * 34. Calcula la suma de los precios de todos los productos.
	 */
	@Test
	void test34() {

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
	 * 35. Calcula el número de productos que tiene el fabricante Asus.
	 */
	@Test
	void test35() {

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
	 * 36. Calcula la media del precio de todos los productosdel fabricante Asus.
	 */
	@Test
	void test36() {

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
	 * 37. Muestra el precio máximo, precio mínimo, precio medio y el número total de productos que tiene el fabricante Crucial.
	 *  Realízalo en 1 solo stream principal. Utiliza reduce con Double[] como "acumulador".
	 */
	@Test
	void test37() {

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

		}
		catch (RuntimeException e) {
			((FabricanteDAOImpl)fabricantesDAO).rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 39. Muestra el precio máximo, precio mínimo y precio medio de los productos de cada uno de los fabricantes.
	 * El resultado mostrará el nombre del fabricante junto con los datos que se solicitan. Realízalo en 1 solo stream principal. Utiliza reduce con Double[] como "acumulador".
	 * Deben aparecer los fabricantes que no tienen productosDAOImpl.
	 */
	@Test
	void test39() {

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
			
		}
		catch (RuntimeException e) {
			((FabricanteDAOImpl)fabricantesDAO).rollbackTransaction();
		    throw e; // or display error message
		}
	}
}
