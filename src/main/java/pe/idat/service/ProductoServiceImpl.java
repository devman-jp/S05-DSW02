package pe.idat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.idat.model.Producto;
import pe.idat.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoRepository repository;
	
	@Override
	public List<Producto> lista() {
		return repository.findAll();
	}

	@Override
	public Producto obtener(Integer idProducto) {
		return repository.findById(idProducto).orElse(null);
	}

	@Override
	public void guardar(Producto producto) {
		repository.save(producto);
	}

	@Override
	public void actualizar(Producto producto) {
		repository.saveAndFlush(producto);
	}

	@Override
	public void eliminar(Integer idProducto) {
		repository.deleteById(idProducto);
	}
	
}
