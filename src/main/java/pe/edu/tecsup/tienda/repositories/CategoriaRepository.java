package pe.edu.tecsup.tienda.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import pe.edu.tecsup.tienda.entities.Categoria;

public interface CategoriaRepository extends CrudRepository<Categoria, Long>{

	
	@Override
	List<Categoria> findAll();

	
}
