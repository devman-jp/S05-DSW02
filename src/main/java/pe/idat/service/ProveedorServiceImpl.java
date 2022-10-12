package pe.idat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.idat.model.Proveedor;
import pe.idat.repository.ProveedorRepository;

@Service
public class ProveedorServiceImpl implements ProveedorService{

	@Autowired
	private ProveedorRepository repository;
	
	@Override
	public List<Proveedor> lista() {
		return repository.findAll();
	}

	@Override
	public Proveedor obtener(Integer idProveedor) {
		return repository.findById(idProveedor).orElse(null);
	}

	@Override
	public void guardar(Proveedor proveedor) {
		repository.save(proveedor);
	}

	@Override
	public void actualizar(Proveedor proveedor) {
		repository.saveAndFlush(proveedor);
	}

	@Override
	public void eliminar(Integer idProveedor) {
		repository.deleteById(idProveedor);
	}

}
