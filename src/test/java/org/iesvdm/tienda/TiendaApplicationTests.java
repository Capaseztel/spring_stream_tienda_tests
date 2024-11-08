package org.iesvdm.tienda;

import org.iesvdm.tienda.modelo.Fabricante;
import org.iesvdm.tienda.modelo.Producto;
import org.iesvdm.tienda.repository.FabricanteRepository;
import org.iesvdm.tienda.repository.ProductoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Comparator;
import java.util.List;
import java.util.Set;


@SpringBootTest
class TiendaApplicationTests {

	@Autowired
	FabricanteRepository fabRepo;
	
	@Autowired
	ProductoRepository prodRepo;

	@Test
	void testAllFabricante() {
		var listFabs = fabRepo.findAll();
		
		listFabs.forEach(f -> {
			System.out.println(">>"+f+ ":");
			f.getProductos().forEach(System.out::println);
		});
	}
	
	@Test
    public void testAllProducto() {
		var listProds = prodRepo.findAll();

		listProds.forEach( p -> {
			System.out.println(">>"+p+":"+"\nProductos mismo fabricante "+ p.getFabricante());
			p.getFabricante().getProductos().forEach(pF -> System.out.println(">>>>"+pF));
		});
				
	}

	
	/**
	 * 1. Lista los nombres y los precios de todos los productos de la tabla producto
	 */
	@Test
	void test1() {
		var listProds = prodRepo.findAll();
		var Stream = listProds.stream().map(p -> p.getNombre() + ": " + p.getPrecio() +"€").toList();
		Stream.forEach(System.out::println);
		Assertions.assertEquals(11, Stream.size());
		Assertions.assertTrue(Stream.getFirst().contains("Disco duro"));
	}
	
	
	/**
	 * 2. Devuelve una lista de Producto completa con el precio de euros convertido a dólares .
	 */
	@Test
	void test2() {
		var listProds = prodRepo.findAll();
		var Stream = listProds.stream().map(p -> p.getNombre() + ": " + (p.getPrecio() * 1.17) +"$").toList();
		Stream.forEach(System.out::println);
		Assertions.assertEquals(11, Stream.size());
		Assertions.assertTrue(Stream.getFirst().contains("101.7"));
	}
	
	/**
	 * 3. Lista los nombres y los precios de todos los productos, convirtiendo los nombres a mayúscula.
	 */
	@Test
	void test3() {
		var listProds = prodRepo.findAll();
		var Stream = listProds.stream().map(p -> p.getNombre().toUpperCase() + ": " + p.getPrecio() +"€").toList();
		Stream.forEach(System.out::println);
		Assertions.assertEquals(11, Stream.size());
		Assertions.assertTrue(Stream.getFirst().contains("DISCO DURO"));
	}
	
	/**
	 * 4. Lista el nombre de todos los fabricantes y a continuación en mayúsculas los dos primeros caracteres del nombre del fabricante.
	 */
	@Test
	void test4() {
		var listFabs = fabRepo.findAll();
		var Stream = listFabs.stream().map(f -> f.getNombre() + ": " + f.getNombre().substring(0, 2).toUpperCase()).toList();
		Stream.forEach(System.out::println);
		Assertions.assertEquals(9, Stream.size());
		Assertions.assertTrue(Stream.getFirst().contains("Asus: AS"));
	}
	
	/**
	 * 5. Lista el código de los fabricantes que tienen productos.
	 */
	@Test
	void test5() {
		var listFabs = fabRepo.findAll();
		var Stream = listFabs.stream().filter(f -> f.getProductos().size() > 0).map(f -> f.getCodigo()).toList();
		Stream.forEach(System.out::println);
		Assertions.assertEquals(7, Stream.size());
	}
	
	/**
	 * 6. Lista los nombres de los fabricantes ordenados de forma descendente.
	 */
	@Test
	void test6() {
		var listFabs = fabRepo.findAll();
		var Stream = listFabs.stream().map(f -> f.getNombre()).sorted(Comparator.reverseOrder()).toList();
		Stream.forEach(System.out::println);
	}
	
	/**
	 * 7. Lista los nombres de los productos ordenados en primer lugar por el nombre de forma ascendente y en segundo lugar por el precio de forma descendente.
	 */
	@Test
	void test7() {
		var listProds = prodRepo.findAll();
		var Stream = listProds.stream().sorted(Comparator.comparing(Producto::getNombre).thenComparing(Producto::getPrecio).reversed()).map(p -> p.getNombre()).toList();
		Stream.forEach(System.out::println);
		Assertions.assertEquals(11, Stream.size());
		Assertions.assertTrue(Stream.getFirst().contains("Portátil Yoga 520"));
	}
	
	/**
	 * 8. Devuelve una lista con los 5 primeros fabricantes.
	 */
	@Test
	void test8() {
		var listFabs = fabRepo.findAll();
		var Stream = listFabs.stream().limit(5).toList();
		Stream.forEach(System.out::println);
		Assertions.assertEquals(5, Stream.size());
	}
	
	/**
	 * 9.Devuelve una lista con 2 fabricantes a partir del cuarto fabricante. El cuarto fabricante también se debe incluir en la respuesta.
	 */
	@Test
	void test9() {
		var listFabs = fabRepo.findAll();
		var Stream = listFabs.stream().skip(3).limit(2).toList();
		Stream.forEach(System.out::println);
		Assertions.assertEquals(2, Stream.size());
		Assertions.assertTrue(Stream.getFirst().getCodigo() == 4);
	}
	
	/**
	 * 10. Lista el nombre y el precio del producto más barato
	 */
	@Test
	void test10() {
		var listProds = prodRepo.findAll();
		var Stream = listProds.stream().min(Comparator.comparing(Producto::getPrecio)).map(p -> p.getNombre() + ": " + p.getPrecio() +"€").stream().toList();
		Stream.forEach(System.out::println);
		Assertions.assertEquals(1, Stream.size());
		Assertions.assertTrue(Stream.getFirst().contains("59.99"));
	}
	
	/**
	 * 11. Lista el nombre y el precio del producto más caro
	 */
	@Test
	void test11() {
		var listProds = prodRepo.findAll();
		var Stream = listProds.stream().max(Comparator.comparing(Producto::getPrecio)).map(p -> p.getNombre() + ": " + p.getPrecio() +"€").stream().toList();
		Stream.forEach(System.out::println);
		Assertions.assertEquals(1, Stream.size());
		Assertions.assertTrue(Stream.getFirst().contains("755"));
	}
	
	/**
	 * 12. Lista el nombre de todos los productos del fabricante cuyo código de fabricante es igual a 2.
	 * 
	 */
	@Test
	void test12() {
		var listProds = prodRepo.findAll();
		var Stream = listProds.stream().filter(p -> p.getFabricante().getCodigo() == 2).map(p -> p.getNombre()).toList();
		Stream.forEach(System.out::println);
		Assertions.assertEquals(2, Stream.size());
		Assertions.assertTrue(Stream.getFirst().contains("Portátil Yoga"));
	}
	
	/**
	 * 13. Lista el nombre de los productos que tienen un precio menor o igual a 120€.
	 */
	@Test
	void test13() {
		var listProds = prodRepo.findAll();
		var Stream = listProds.stream().filter(p -> p.getPrecio() <= 120).map(p -> p.getNombre()).toList();
		Stream.forEach(System.out::println);
		Assertions.assertEquals(3, Stream.size());
		Assertions.assertTrue(Stream.getFirst().contains("Disco duro"));
	}
	
	/**
	 * 14. Lista los productos que tienen un precio mayor o igual a 400€.
	 */
	@Test
	void test14() {
		var listProds = prodRepo.findAll();
		var Stream = listProds.stream().filter(p -> p.getPrecio() >= 400).toList();
		Stream.forEach(System.out::println);
		Assertions.assertEquals(3, Stream.size());
		Assertions.assertTrue(Stream.getFirst().getPrecio() >= 400);
	}
	
	/**
	 * 15. Lista todos los productos que tengan un precio entre 80€ y 300€. 
	 */
	@Test
	void test15() {
		var listProds = prodRepo.findAll();
		var Stream = listProds.stream().filter(p -> p.getPrecio() >= 80 && p.getPrecio() <= 300).toList();
		Stream.forEach(System.out::println);
		Assertions.assertEquals(7, Stream.size());
		Assertions.assertTrue(Stream.getFirst().getPrecio() >= 80 && Stream.getFirst().getPrecio() <= 300);
	}
	
	/**
	 * 16. Lista todos los productos que tengan un precio mayor que 200€ y que el código de fabricante sea igual a 6.
	 */
	@Test
	void test16() {
		var listProds = prodRepo.findAll();
		var Stream = listProds.stream().filter(p -> p.getPrecio() > 200 && p.getFabricante().getCodigo() == 6).toList();
		Stream.forEach(System.out::println);
		Assertions.assertTrue(Stream.getFirst().getPrecio() > 200 && Stream.getFirst().getFabricante().getCodigo() == 6);
	}
	
	/**
	 * 17. Lista todos los productos donde el código de fabricante sea 1, 3 o 5 utilizando un Set de codigos de fabricantes para filtrar.
	 */
	@Test
	void test17() {
		var listProds = prodRepo.findAll();
		var Stream = listProds.stream().filter(p -> Set.of(1, 3, 5).contains(p.getFabricante().getCodigo())).toList();
		Stream.forEach(System.out::println);
		Assertions.assertEquals(5, Stream.size());
		Assertions.assertTrue(Set.of(1, 3, 5).contains(Stream.getFirst().getFabricante().getCodigo()));
	}
	
	/**
	 * 18. Lista el nombre y el precio de los productos en céntimos.
	 */
	@Test
	void test18() {
		var listProds = prodRepo.findAll();
		var Stream = listProds.stream().map(p -> p.getNombre() + ": " + p.getPrecio() * 100 +"€").toList();
		Stream.forEach(System.out::println);
		Assertions.assertEquals(11, Stream.size());
	}
	
	
	/**
	 * 19. Lista los nombres de los fabricantes cuyo nombre empiece por la letra S
	 */
	@Test
	void test19() {
		var listFabs = fabRepo.findAll();
		var Stream = listFabs.stream().filter(f -> f.getNombre().startsWith("S")).map(f -> f.getNombre()).toList();
		Stream.forEach(System.out::println);
		Assertions.assertTrue(Stream.getFirst().startsWith("S"));
	}
	
	/**
	 * 20. Devuelve una lista con los productos que contienen la cadena Portátil en el nombre.
	 */
	@Test
	void test20() {
		var listProds = prodRepo.findAll();
		var Stream = listProds.stream().filter(p -> p.getNombre().contains("Portátil")).toList();
		Stream.forEach(System.out::println);
		Assertions.assertTrue(Stream.getFirst().getNombre().contains("Portátil"));
	}
	
	/**
	 * 21. Devuelve una lista con el nombre de todos los productos que contienen la cadena Monitor en el nombre y tienen un precio inferior a 215 €.
	 */
	@Test
	void test21() {
		var listProds = prodRepo.findAll();
		var Stream = listProds.stream().filter(p -> p.getNombre().contains("Monitor") && p.getPrecio() < 215).map(p -> p.getNombre()).toList();
		Stream.forEach(System.out::println);
		Assertions.assertTrue(Stream.getFirst().contains("Monitor"));
	}
	
	/**
	 * 22. Lista el nombre y el precio de todos los productos que tengan un precio mayor o igual a 180€. 
	 * Ordene el resultado en primer lugar por el precio (en orden descendente) y en segundo lugar por el nombre (en orden ascendente).
	 */
	@Test
	void test22() {
		var listProds = prodRepo.findAll();
		var Stream = listProds.stream().filter(p -> p.getPrecio() >= 180);
		var StreamOrdenado = Stream.sorted(Comparator.comparing(Producto::getPrecio).reversed().thenComparing(Producto::getNombre)).map(p -> p.getNombre() + ": " + p.getPrecio() +"€").toList();
		StreamOrdenado.forEach(System.out::println);
		Assertions.assertEquals(7, StreamOrdenado.size());
	}
	
	/**
	 * 23. Devuelve una lista con el nombre del producto, precio y nombre de fabricante de todos los productos de la base de datos. 
	 * Ordene el resultado por el nombre del fabricante, por orden alfabético.
	 */
	@Test
	void test23() {
		var listProds = prodRepo.findAll();
		var Stream = listProds.stream().sorted(Comparator.comparing(p -> p.getFabricante().getNombre())).map(p -> p.getNombre() + ": " + p.getPrecio() +"€" + " - " + p.getFabricante().getNombre()).toList();
		Stream.forEach(System.out::println);
		Assertions.assertEquals(11, Stream.size());
		Assertions.assertTrue(Stream.getFirst().contains("Asus"));
	}
	
	/**
	 * 24. Devuelve el nombre del producto, su precio y el nombre de su fabricante, del producto más caro.
	 */
	@Test
	void test24() {
		var listProds = prodRepo.findAll();
		var Stream = listProds.stream().max(Comparator.comparing(Producto::getPrecio)).map(p -> p.getNombre() + ": " + p.getPrecio() +"€" + " - " + p.getFabricante().getNombre()).stream().toList();
		Stream.forEach(System.out::println);
		Assertions.assertEquals(1, Stream.size());
		Assertions.assertTrue(Stream.getFirst().contains("755"));
	}
	
	/**
	 * 25. Devuelve una lista de todos los productos del fabricante Crucial que tengan un precio mayor que 200€.
	 */
	@Test
	void test25() {
		var listProds = prodRepo.findAll();
		var Stream = listProds.stream().filter(p -> p.getFabricante().getNombre().equals("Crucial") && p.getPrecio() > 200).toList();
		Stream.forEach(System.out::println);
		Assertions.assertEquals(1, Stream.size());
		Assertions.assertTrue(Stream.getFirst().getFabricante().getNombre().equals("Crucial") && Stream.getFirst().getPrecio() > 200);
	}
	
	/**
	 * 26. Devuelve un listado con todos los productos de los fabricantes Asus, Hewlett-Packard y Seagate
	 */
	@Test
	void test26() {
		var listProds = prodRepo.findAll();
		var Stream = listProds.stream().filter(p -> Set.of("Asus", "Hewlett-Packard", "Seagate").contains(p.getFabricante().getNombre())).toList();
		Stream.forEach(System.out::println);
		Assertions.assertEquals(5, Stream.size());
		Assertions.assertTrue(Set.of("Asus", "Hewlett-Packard", "Seagate").contains(Stream.getFirst().getFabricante().getNombre()));
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
		var listProds = prodRepo.findAll();
		var longestName = listProds.stream().map(p -> p.getNombre().length()).max(Integer::compare).get();
		var longestPrice = listProds.stream().map(p -> String.valueOf(p.getPrecio()).length()).max(Integer::compare).get();
		var Stream = listProds.stream().filter(p -> p.getPrecio() >= 180).sorted(Comparator.comparing(Producto::getPrecio).reversed().thenComparing(Producto::getNombre)).map(p -> {
			var spacesName = " ".repeat(longestName - p.getNombre().length());
			var spacesPrice = " ".repeat(longestPrice - String.valueOf(p.getPrecio()).length());
			return p.getNombre() + spacesName + " | " + p.getPrecio() + spacesPrice + " | " + p.getFabricante().getNombre();
		}).toList();
		System.out.println("Producto" + " ".repeat(longestName - 6) + "Precio" + " ".repeat(longestPrice-3) + "Fabricante" + "\n" + "-".repeat(50));
		Stream.forEach(System.out::println);
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
		var listFabs = fabRepo.findAll();
		var Stream = listFabs.stream().map(f -> {
			var productos = f.getProductos().stream().map(p -> p.getNombre()).toList();
			var productosString = productos.isEmpty() ? "" : productos.stream().reduce("", (a, b) -> a + "\n\t\t" + b);
			return "Fabricante: " + f.getNombre() + "\n" + "\tProductos:" + productosString + "\n\n";
		}).toList();
		Stream.forEach(System.out::println);
	}
	
	/**
	 * 29. Devuelve un listado donde sólo aparezcan aquellos fabricantes que no tienen ningún producto asociado.
	 */
	@Test
	void test29() {
		var listFabs = fabRepo.findAll();
		var Stream = listFabs.stream().filter(f -> f.getProductos().isEmpty()).toList();
		Stream.forEach(System.out::println);
		Assertions.assertTrue(Stream.getFirst().getProductos().isEmpty());
	}
	
	/**
	 * 30. Calcula el número total de productos que hay en la tabla productos. Utiliza la api de stream.
	 */
	@Test
	void test30() {
		var listProds = prodRepo.findAll();
		var Stream = listProds.stream().count();
		System.out.println(Stream);
		Assertions.assertEquals(11, Stream);
	}

	
	/**
	 * 31. Calcula el número de fabricantes con productos, utilizando un stream de Productos.
	 */
	@Test
	void test31() {
		var listProds = prodRepo.findAll();
		var Stream = listProds.stream().map(p -> p.getFabricante()).distinct().count();
		System.out.println(Stream);
		Assertions.assertEquals(7, Stream);
	}
	
	/**
	 * 32. Calcula la media del precio de todos los productos
	 */
	@Test
	void test32() {
		var listProds = prodRepo.findAll();
		var Stream = listProds.stream().mapToDouble(p -> p.getPrecio()).average().getAsDouble();
		System.out.println(Stream);
		Assertions.assertEquals(271.7236363636364, Stream);
	}
	
	/**
	 * 33. Calcula el precio más barato de todos los productos. No se puede utilizar ordenación de stream.
	 */
	@Test
	void test33() {
		var listProds = prodRepo.findAll();
		var Stream = listProds.stream().mapToDouble(p -> p.getPrecio()).min().getAsDouble();
		System.out.println(Stream);
		Assertions.assertEquals(59.99, Stream);
	}
	
	/**
	 * 34. Calcula la suma de los precios de todos los productos.
	 */
	@Test
	void test34() {
		var listProds = prodRepo.findAll();
		var Stream = listProds.stream().mapToDouble(p -> p.getPrecio()).sum();
		System.out.println(Stream);
		Assertions.assertEquals(2988.96, Stream);
	}
	
	/**
	 * 35. Calcula el número de productos que tiene el fabricante Asus.
	 */
	@Test
	void test35() {
		var listProds = prodRepo.findAll();
		var Stream = listProds.stream().filter(p -> p.getFabricante().getNombre().equals("Asus")).count();
		System.out.println(Stream);
		Assertions.assertEquals(2, Stream);
	}
	
	/**
	 * 36. Calcula la media del precio de todos los productos del fabricante Asus.
	 */
	@Test
	void test36() {
		var listProds = prodRepo.findAll();
		var Stream = listProds.stream().filter(p -> p.getFabricante().getNombre().equals("Asus")).mapToDouble(p -> p.getPrecio()).average().getAsDouble();
		System.out.println(Stream);
		Assertions.assertEquals(223.995, Stream);
	}
	
	
	/**
	 * 37. Muestra el precio máximo, precio mínimo, precio medio y el número total de productos que tiene el fabricante Crucial. 
	 *  Realízalo en 1 solo stream principal. Utiliza reduce con Double[] como "acumulador".
	 */
	@Test
	void test37() {
		var listProds = prodRepo.findAll();
		var Stream = listProds.stream().filter(p -> p.getFabricante().getNombre().equals("Crucial")).map(p -> p.getPrecio()).reduce(new Double[] {0.0, Double.MAX_VALUE, 0.0,0.0}, (a, b) -> {
			a[0] += b;
			a[1] = Math.min(a[1], b);
			a[2] = Math.max(a[2], b);
			a[3]++;
			return a;
		}, (a, b) -> {
			a[0] += b[0];
			a[1] = Math.min(a[1], b[1]);
			a[2] = Math.max(a[2], b[2]);
			a[3] += b[3];
			return a;
		});
		System.out.println("Precio máximo: " + Stream[2] + "\nPrecio mínimo: " + Stream[1] + "\nPrecio medio: " + Stream[0] / Stream[3] + "\nNúmero total de productos: " + Stream[3]);
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
		var listFabs = fabRepo.findAll();
		var nombreLargo = listFabs.stream().map(f -> f.getNombre()).max(Comparator.comparing(String::length)).get().length();
		var Stream = listFabs.stream().sorted((p1, p2) -> Integer.compare(p2.getProductos().size(), p1.getProductos().size())).map(f -> {
			var productos = f.getProductos().size();
			var espacio = " ".repeat(nombreLargo - f.getNombre().length());
			return espacio + f.getNombre() + "\t\t\t\t " + productos;
		}).toList();
		System.out.println(" ".repeat(nombreLargo-10) + "Fabricante" + "\t\t#Productos" + "\n" + "*-".repeat(33));
		Stream.forEach(System.out::println);
	}
	
	/**
	 * 39. Muestra el precio máximo, precio mínimo y precio medio de los productos de cada uno de los fabricantes. 
	 * El resultado mostrará el nombre del fabricante junto con los datos que se solicitan. Realízalo en 1 solo stream principal. Utiliza reduce con Double[] como "acumulador".
	 * Deben aparecer los fabricantes que no tienen productos.
	 */
	@Test
	void test39() {
		var listFabs = fabRepo.findAll();
	var Stream = listFabs.stream().map(f -> {
			var productos = f.getProductos().stream().map(p -> p.getPrecio()).reduce(new Double[] {0.0, Double.MAX_VALUE, 0.0, 0.0}, (a, b) -> {
				a[0] += b;
				a[1] = Math.min(a[1], b);
				a[2] = Math.max(a[2], b);
				a[3]++;
				return a;
			}, (a, b) -> {
				a[0] += b[0];
				a[1] = Math.min(a[1], b[1]);
				a[2] = Math.max(a[2], b[2]);
				a[3] += b[3];
				return a;
			});
			return f.getNombre() + "\nPrecio máximo: " + productos[2] + "\nPrecio mínimo: " + productos[1] + "\nPrecio medio: " + productos[0] / productos[3] + "\n";
		}).toList();
		Stream.forEach(System.out::println);
	}
	
	/**
	 * 40. Muestra el precio máximo, precio mínimo, precio medio y el número total de productos de los fabricantes que tienen un precio medio superior a 200€. 
	 * No es necesario mostrar el nombre del fabricante, con el código del fabricante es suficiente.
	 */
	@Test
	void test40() {
		// me rindo
	}
	
	/**
	 * 41. Devuelve un listado con los nombres de los fabricantes que tienen 2 o más productos.
	 */
	@Test
	void test41() {
		var listFabs = fabRepo.findAll();
		var Stream = listFabs.stream().filter(f -> f.getProductos().size() >= 2).map(f -> f.getNombre()).toList();
		Stream.forEach(System.out::println);
		Assertions.assertEquals(4, Stream.size());
	}
	
	/**
	 * 42. Devuelve un listado con los nombres de los fabricantes y el número de productos que tiene cada uno con un precio superior o igual a 220 €. 
	 * Ordenado de mayor a menor número de productos.
	 */
	@Test
	void test42() {
		var listFabs = fabRepo.findAll();
		var Stream = listFabs.stream().sorted((f1, f2) -> Integer.compare(f2.getProductos().stream().filter(p -> p.getPrecio() >= 220).toList().size(), f1.getProductos().stream().filter(p -> p.getPrecio() >= 220).toList().size())).map(f -> {
			var productos = f.getProductos().stream().filter(p -> p.getPrecio() >= 220).count();
			return f.getNombre() + ": " + productos;
		}).toList();
		Stream.forEach(System.out::println);
		Assertions.assertTrue(Stream.getFirst().contains("2"));
	}
	
	/**
	 * 43.Devuelve un listado con los nombres de los fabricantes donde la suma del precio de todos sus productos es superior a 1000 €
	 */
	@Test
	void test43() {
		var listFabs = fabRepo.findAll();
		var Stream = listFabs.stream().filter(f -> f.getProductos().stream().mapToDouble(p -> p.getPrecio()).sum() > 1000).map(f -> f.getNombre()).toList();
		Stream.forEach(System.out::println);
		Assertions.assertTrue(Stream.getFirst().contains("Lenovo"));
	}
	
	/**
	 * 44. Devuelve un listado con los nombres de los fabricantes donde la suma del precio de todos sus productos es superior a 1000 €
	 * Ordenado de menor a mayor por cuantía de precio de los productos.
	 */
	@Test
	void test44() {
		var listFabs = fabRepo.findAll();
		var Stream = listFabs.stream().filter(f -> f.getProductos().stream().mapToDouble(p -> p.getPrecio()).sum() > 1000).sorted((f1, f2) -> Double.compare(f1.getProductos().stream().mapToDouble(p -> p.getPrecio()).sum(), f2.getProductos().stream().mapToDouble(p -> p.getPrecio()).sum())).map(f -> f.getNombre()).toList();
		Stream.forEach(System.out::println);
		Assertions.assertTrue(Stream.getFirst().contains("Lenovo"));
	}
	
	/**
	 * 45. Devuelve un listado con el nombre del producto más caro que tiene cada fabricante. 
	 * El resultado debe tener tres columnas: nombre del producto, precio y nombre del fabricante. 
	 * El resultado tiene que estar ordenado alfabéticamente de menor a mayor por el nombre del fabricante.
	 */
	@Test
	void test45() {
		var listFabs = fabRepo.findAll();
		var Stream = listFabs.stream().sorted((f1,f2)-> f1.getNombre().compareTo(f2.getNombre())).map(f -> {
			var producto = f.getProductos().stream().max(Comparator.comparing(Producto::getPrecio)).get();
			return producto.getNombre() + ": " + producto.getPrecio() + "€ - " + f.getNombre();
		}).toList();
		Stream.forEach(System.out::println);
		// no entiendo porque, pero no funciona
	}
	
	/**
	 * 46. Devuelve un listado de todos los productos que tienen un precio mayor o igual a la media de todos los productos de su mismo fabricante.
	 * Se ordenará por fabricante en orden alfabético ascendente y los productos de cada fabricante tendrán que estar ordenados por precio descendente.
	 */
	@Test
	void test46() {
	}

}
