package pe.idat.service;

import java.util.List;
import pe.idat.model.Proveedor;

public interface ProveedorService {
	List<Proveedor> lista();
	Proveedor obtener(Integer idProveedor);
	void guardar(Proveedor proveedor);
	void actualizar(Proveedor proveedor);
	void eliminar(Integer idProveedor);
	
}
