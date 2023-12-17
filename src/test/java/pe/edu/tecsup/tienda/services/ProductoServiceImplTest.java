package pe.edu.tecsup.tienda.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import pe.edu.tecsup.tienda.entities.Categoria;
import pe.edu.tecsup.tienda.entities.Producto;

@SpringBootTest
class ProductoServiceImplTest {

	@Autowired
	ProductoService productoService;

	
	@Test
	void testFindAll() throws Exception {
		
		List<Producto> prods = productoService.findAll();
		
		// Verifica que existan productos
		//     VALOR_ESPERADO  VALOR_OBTENIDO
		assertEquals(false, prods.isEmpty());
	}

	@Test
	void testFindById() {

		Producto prod = null;
		Long ID_BUSCAR = 1L;
		String NOMBRE_ESPERADO = "Kingstone";
		String DESCRIPCION_ESPERADO = "Procesador Intel Core I7-8700 Lga 1151 8va";
		Double PRECIO_ESPERADO = 1479.99;
		
		try {
			prod = productoService.findById(ID_BUSCAR);
		} catch (Exception e) {
			fail("Exception " + e.getMessage());
		}

		// Test validation..!
		assertEquals(NOMBRE_ESPERADO, prod.getNombre());
		assertEquals(DESCRIPCION_ESPERADO, prod.getDescripcion());
		assertEquals(PRECIO_ESPERADO, prod.getPrecio());

	}	
	
	@Test
	void testSave() throws Exception {
		
		List<Producto> productos = productoService.findAll();
		
		int totalAntes = productos.size();
		
		Producto producto = new Producto();
		
		// Creo el objeto categoria oara usarlo en el objeto producto
		Categoria categoria = new Categoria();
		categoria.setId(1L);
		producto.setCategoria(categoria);
		
		producto.setNombre("AMD");
		producto.setDescripcion("AMD X10");
		producto.setPrecio(280.0);
		producto.setStock(6);
		producto.setEstado(1);
		
		// Grabar producto
		productoService.save(producto);
		
		//
		productos = productoService.findAll();
		int totalDespues = productos.size();
		
		// Verifica si hay un registro mas
		assertEquals(1,totalDespues - totalAntes);
		
	}

	@Test
	public void testDeleteById() throws Exception {
		
		List<Producto> productos = productoService.findAll();
		int totalAntes = productos.size();
		
		if (productos.isEmpty()) return; // test pass
		
		Producto ultimoProducto = productos.get(productos.size() - 1);
		
		productoService.deleteById(ultimoProducto.getId());
		
		productos = productoService.findAll();
		int totalDespues = productos.size();
		
		assertEquals(1,totalAntes - totalDespues);
	}

}
