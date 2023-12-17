package pe.edu.tecsup.tienda.services;

import java.util.List;

import pe.edu.tecsup.tienda.entities.Categoria;

public interface CategoriaService {

	List<Categoria> findAll() throws Exception;
	
}
