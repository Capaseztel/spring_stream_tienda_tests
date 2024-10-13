package org.iesvdm.tienda;


import org.iesvdm.tienda.repository.FabricanteRepository;
import org.iesvdm.tienda.repository.ProductoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.support.TransactionTemplate;

@SpringBootTest
class TiendaApplicationTests {

	@Autowired
	FabricanteRepository fabRepo;
	
	@Autowired
	ProductoRepository prodRepo;

	@Autowired
	TransactionTemplate transactionTemplate;

	@Test
	void testAllFabricante() {
		transactionTemplate.execute(status -> {
			var listFabs = fabRepo.findAll();
			
			listFabs.forEach(System.out::println);

		
			return null;
		});
	}
	
	@Test
	void testAllProducto() {
		transactionTemplate.execute(status -> {
			var listProds = prodRepo.findAll();

			listProds.forEach(System.out::println);

			return null;
		});
	}
	
	/**
	 * 1. Lista los nombres y los precios de todos los productos de la tabla producto
	 */
	@Test
	void test1() {
		transactionTemplate.execute(status -> {
			var listProds = prodRepo.findAll();
			
			//TODO

			return null;
		});
	}
	
	
	/**
	 * 2. Devuelve una lista de Producto completa con el precio de euros convertido a dólares .
	 */
	@Test
	void test2() {
		transactionTemplate.execute(status -> {
			var listProds = prodRepo.findAll();
			//TODO
		
			return null;
		});
	}
	
	/**
	 * 3. Lista los nombres y los precios de todos los productos, convirtiendo los nombres a mayúscula.
	 */
	@Test
	void test3() {
		transactionTemplate.execute(status -> {
			var listProds = prodRepo.findAll();
		 	
			//TODO
		
			return null;
		});
	}
	
	/**
	 * 4. Lista el nombre de todos los fabricantes y a continuación en mayúsculas los dos primeros caracteres del nombre del fabricante.
	 */
	@Test
	void test4() {
		transactionTemplate.execute(status -> {
			var listFabs = fabRepo.findAll();
		
			//TODO
		
			return null;
		});
	}
	
	/**
	 * 5. Lista el código de los fabricantes que tienen productos.
	 */
	@Test
	void test5() {
		transactionTemplate.execute(status -> {
			var listFabs = fabRepo.findAll();
		 	
			//TODO
		
			return null;			
		});		
	}
	
	/**
	 * 6. Lista los nombres de los fabricantes ordenados de forma descendente.
	 */
	@Test
	void test6() {
		transactionTemplate.execute(status -> {
			var listFabs = fabRepo.findAll();
			//TODO
		
			return null;						
		});
	}
	
	/**
	 * 7. Lista los nombres de los productos ordenados en primer lugar por el nombre de forma ascendente y en segundo lugar por el precio de forma descendente.
	 */
	@Test
	void test7() {
		transactionTemplate.execute(status -> {
			var listProds = prodRepo.findAll();
			//TODO
		
			return null;			
		});
	}
	
	/**
	 * 8. Devuelve una lista con los 5 primeros fabricantes.
	 */
	@Test
	void test8() {
		transactionTemplate.execute(status -> {
			var listFabs = fabRepo.findAll();
			//TODO
		
			return null;			
		});
	}
	
	/**
	 * 9.Devuelve una lista con 2 fabricantes a partir del cuarto fabricante. El cuarto fabricante también se debe incluir en la respuesta.
	 */
	@Test
	void test9() {
		transactionTemplate.execute(status -> {
			var listFabs = fabRepo.findAll();
			//TODO
		
			return null;			
		});		
	}
	
	/**
	 * 10. Lista el nombre y el precio del producto más barato
	 */
	@Test
	void test10() {
		transactionTemplate.execute(status -> {
			var listProds = prodRepo.findAll();
			//TODO
		
			return null;			
		});
	}
	
	/**
	 * 11. Lista el nombre y el precio del producto más caro
	 */
	@Test
	void test11() {
		transactionTemplate.execute(status -> {
			var listProds = prodRepo.findAll();
			//TODO
		
			return null;			
		});
	}
	
	/**
	 * 12. Lista el nombre de todos los productos del fabricante cuyo código de fabricante es igual a 2.
	 * 
	 */
	@Test
	void test12() {
		transactionTemplate.execute(status -> {
			var listProds = prodRepo.findAll();
			//TODO
		
			return null;			
		});
	}
	
	/**
	 * 13. Lista el nombre de los productos que tienen un precio menor o igual a 120€.
	 */
	@Test
	void test13() {
		transactionTemplate.execute(status -> {
			var listProds = prodRepo.findAll();
			//TODO
		
			return null;			
		});
	}
	
	/**
	 * 14. Lista los productos que tienen un precio mayor o igual a 400€.
	 */
	@Test
	void test14() {
		transactionTemplate.execute(status -> {
			var listProds = prodRepo.findAll();
			//TODO
		
			return null;			
		});
	}
	
	/**
	 * 15. Lista todos los productos que tengan un precio entre 80€ y 300€. 
	 */
	@Test
	void test15() {
		transactionTemplate.execute(status -> {
			var listProds = prodRepo.findAll();
			//TODO
		
			return null;			
		});
	}
	
	/**
	 * 16. Lista todos los productos que tengan un precio mayor que 200€ y que el código de fabricante sea igual a 6.
	 */
	@Test
	void test16() {
		transactionTemplate.execute(status -> {
			var listProds = prodRepo.findAll();
			//TODO
		
			return null;			
		});
	}
	
	/**
	 * 17. Lista todos los productos donde el código de fabricante sea 1, 3 o 5 utilizando un Set de codigos de fabricantes para filtrar.
	 */
	@Test
	void test17() {
		transactionTemplate.execute(status -> {
			var listProds = prodRepo.findAll();
			//TODO
		
			return null;
		});
	}
	
	/**
	 * 18. Lista el nombre y el precio de los productos en céntimos.
	 */
	@Test
	void test18() {
		transactionTemplate.execute(status -> {
			var listProds = prodRepo.findAll();
			//TODO
		
			return null;			
		});
	}
	
	
	/**
	 * 19. Lista los nombres de los fabricantes cuyo nombre empiece por la letra S
	 */
	@Test
	void test19() {
		transactionTemplate.execute(status -> {
			var listFabs = fabRepo.findAll();
			//TODO
		
			return null;			
		});
	}
	
	/**
	 * 20. Devuelve una lista con los productos que contienen la cadena Portátil en el nombre.
	 */
	@Test
	void test20() {
		transactionTemplate.execute(status -> {
			var listProds = prodRepo.findAll();
			//TODO
		
			return null;			
		});
	}
	
	/**
	 * 21. Devuelve una lista con el nombre de todos los productos que contienen la cadena Monitor en el nombre y tienen un precio inferior a 215 €.
	 */
	@Test
	void test21() {
		transactionTemplate.execute(status -> {
			var listProds = prodRepo.findAll();
			//TODO
		
			return null;			
		});
	}
	
	/**
	 * 22. Lista el nombre y el precio de todos los productos que tengan un precio mayor o igual a 180€. 
	 * Ordene el resultado en primer lugar por el precio (en orden descendente) y en segundo lugar por el nombre (en orden ascendente).
	 */
	void test22() {
		transactionTemplate.execute(status -> {
			var listProds = prodRepo.findAll();
			//TODO
		
			return null;			
		});
	}
	
	/**
	 * 23. Devuelve una lista con el nombre del producto, precio y nombre de fabricante de todos los productos de la base de datos. 
	 * Ordene el resultado por el nombre del fabricante, por orden alfabético.
	 */
	@Test
	void test23() {
		transactionTemplate.execute(status -> {
			var listProds = prodRepo.findAll();
			//TODO
		
			return null;			
		});
	}
	
	/**
	 * 24. Devuelve el nombre del producto, su precio y el nombre de su fabricante, del producto más caro.
	 */
	@Test
	void test24() {
		transactionTemplate.execute(status -> {
			var listProds = prodRepo.findAll();
			//TODO
		
			return null;			
		});
	}
	
	/**
	 * 25. Devuelve una lista de todos los productos del fabricante Crucial que tengan un precio mayor que 200€.
	 */
	@Test
	void test25() {
		transactionTemplate.execute(status -> {
			var listProds = prodRepo.findAll();
			//TODO
		
			return null;			
		});	
	}
	
	/**
	 * 26. Devuelve un listado con todos los productos de los fabricantes Asus, Hewlett-Packard y Seagate
	 */
	@Test
	void test26() {
		transactionTemplate.execute(status -> {
			var listProds = prodRepo.findAll();
			//TODO
		
			return null;			
		});
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
		transactionTemplate.execute(status -> {
			var listProds = prodRepo.findAll();
			//TODO
		
			return null;			
		});
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
		transactionTemplate.execute(status -> {
			var listFabs = fabRepo.findAll();
			//TODO
		
			return null;			
		});
	}
	
	/**
	 * 29. Devuelve un listado donde sólo aparezcan aquellos fabricantes que no tienen ningún producto asociado.
	 */
	@Test
	void test29() {
		transactionTemplate.execute(status -> {
			var listFabs = fabRepo.findAll();
			//TODO
		
			return null;			
		});
	}
	
	/**
	 * 30. Calcula el número total de productos que hay en la tabla productos. Utiliza la api de stream.
	 */
	@Test
	void test30() {
		transactionTemplate.execute(status -> {
			var listProds = prodRepo.findAll();
			//TODO
		
			return null;			
		});
	}

	
	/**
	 * 31. Calcula el número de fabricantes con productos, utilizando un stream de Productos.
	 */
	@Test
	void test31() {
		transactionTemplate.execute(status -> {
			var listProds = prodRepo.findAll();
			//TODO
		
			return null;			
		});
	}
	
	/**
	 * 32. Calcula la media del precio de todos los productos
	 */
	@Test
	void test32() {
		transactionTemplate.execute(status -> {
			var listProds = prodRepo.findAll();
			//TODO
		
			return null;			
		});
	}
	
	/**
	 * 33. Calcula el precio más barato de todos los productos. No se puede utilizar ordenación de stream.
	 */
	@Test
	void test33() {
		transactionTemplate.execute(status -> {
			var listProds = prodRepo.findAll();
			//TODO
		
			return null;			
		});
	}
	
	/**
	 * 34. Calcula la suma de los precios de todos los productos.
	 */
	@Test
	void test34() {
		transactionTemplate.execute(status -> {
			var listProds = prodRepo.findAll();
			//TODO
		
			return null;			
		});	
	}
	
	/**
	 * 35. Calcula el número de productos que tiene el fabricante Asus.
	 */
	@Test
	void test35() {
		transactionTemplate.execute(status -> {
			var listProds = prodRepo.findAll();
			//TODO
		
			return null;			
		});		
	}
	
	/**
	 * 36. Calcula la media del precio de todos los productos del fabricante Asus.
	 */
	@Test
	void test36() {
		transactionTemplate.execute(status -> {
			var listProds = prodRepo.findAll();
			//TODO
		
			return null;			
		});
	}
	
	
	/**
	 * 37. Muestra el precio máximo, precio mínimo, precio medio y el número total de productos que tiene el fabricante Crucial. 
	 *  Realízalo en 1 solo stream principal. Utiliza reduce con Double[] como "acumulador".
	 */
	@Test
	void test37() {
		transactionTemplate.execute(status -> {
			var listProds = prodRepo.findAll();
			//TODO
		
			return null;			
		});
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
		transactionTemplate.execute(status -> {
			var listFabs = fabRepo.findAll();
			//TODO
		
			return null;						
		});
	}
	
	/**
	 * 39. Muestra el precio máximo, precio mínimo y precio medio de los productos de cada uno de los fabricantes. 
	 * El resultado mostrará el nombre del fabricante junto con los datos que se solicitan. Realízalo en 1 solo stream principal. Utiliza reduce con Double[] como "acumulador".
	 * Deben aparecer los fabricantes que no tienen productos.
	 */
	@Test
	void test39() {
		transactionTemplate.execute(status -> {
			var listFabs = fabRepo.findAll();
			//TODO
		
			return null;			
		});
	}
	
	/**
	 * 40. Muestra el precio máximo, precio mínimo, precio medio y el número total de productos de los fabricantes que tienen un precio medio superior a 200€. 
	 * No es necesario mostrar el nombre del fabricante, con el código del fabricante es suficiente.
	 */
	@Test
	void test40() {
		transactionTemplate.execute(status -> {
			var listFabs = fabRepo.findAll();
			//TODO
		
			return null;			
		});
	}
	
	/**
	 * 41. Devuelve un listado con los nombres de los fabricantes que tienen 2 o más productos.
	 */
	@Test
	void test41() {
		transactionTemplate.execute(status -> {
			var listFabs = fabRepo.findAll();
			//TODO
		
			return null;			
		});
	}
	
	/**
	 * 42. Devuelve un listado con los nombres de los fabricantes y el número de productos que tiene cada uno con un precio superior o igual a 220 €. 
	 * Ordenado de mayor a menor número de productos.
	 */
	@Test
	void test42() {
		transactionTemplate.execute(status -> {
			var listFabs = fabRepo.findAll();
			//TODO
		
			return null;			
		});
	}
	
	/**
	 * 43.Devuelve un listado con los nombres de los fabricantes donde la suma del precio de todos sus productos es superior a 1000 €
	 */
	@Test
	void test43() {
		transactionTemplate.execute(status -> {
			var listFabs = fabRepo.findAll();
			//TODO
		
			return null;			
		});
	}
	
	/**
	 * 44. Devuelve un listado con los nombres de los fabricantes donde la suma del precio de todos sus productos es superior a 1000 €
	 * Ordenado de menor a mayor por cuantía de precio de los productos.
	 */
	@Test
	void test44() {
		transactionTemplate.execute(status -> {
			var listFabs = fabRepo.findAll();
			//TODO
		
			return null;			
		});	
	}
	
	/**
	 * 45. Devuelve un listado con el nombre del producto más caro que tiene cada fabricante. 
	 * El resultado debe tener tres columnas: nombre del producto, precio y nombre del fabricante. 
	 * El resultado tiene que estar ordenado alfabéticamente de menor a mayor por el nombre del fabricante.
	 */
	@Test
	void test45() {
		transactionTemplate.execute(status -> {
			var listFabs = fabRepo.findAll();
			//TODO
		
			return null;			
		});
	}
	
	/**
	 * 46. Devuelve un listado de todos los productos que tienen un precio mayor o igual a la media de todos los productos de su mismo fabricante.
	 * Se ordenará por fabricante en orden alfabético ascendente y los productos de cada fabricante tendrán que estar ordenados por precio descendente.
	 */
	@Test
	void test46() {
		transactionTemplate.execute(status -> {
			var listFabs = fabRepo.findAll();
			//TODO
		
			return null;
		});
	}

}