package pe.edu.tecsup.tienda.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.tecsup.tienda.entities.Producto;
import pe.edu.tecsup.tienda.repositories.ProductoRepository;


@Service
public class ProductoServiceImpl implements ProductoService {

	private static Logger log = LoggerFactory.getLogger(ProductoServiceImpl.class);
	
	@Autowired
	private ProductoRepository productoRepository;

	
	@Override
	public List<Producto> findAll() throws Exception {
		
		log.info("Call listar() ....! ");
		return productoRepository.findAll();
	}


	@Override
	public void save(Producto producto) throws Exception {
		log.info("call registrar(producto: " + producto + ")");
		productoRepository.save(producto);
	}
	
	@Override
	public void deleteById(Long id) throws Exception {
		log.info("call eliminar(id: " + id + ")");
		productoRepository.deleteById(id);
		
	}

	@Override
	public Producto findById(Long id) throws Exception {
		// TODO Auto-generated method stub
		log.info("call findById(id: " + id + ")");
		
		Optional<Producto> optionalProd 
			= productoRepository.findById(id);
		
		if ( optionalProd.isPresent())
			return optionalProd.get();
		else
			throw new Exception("Not found record...!");
	}  
	
}
