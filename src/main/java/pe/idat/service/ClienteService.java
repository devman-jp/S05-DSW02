package pe.idat.service;

import java.util.List;
import pe.idat.model.Cliente;

public interface ClienteService {
	List<Cliente> lista();
	Cliente obtener(Integer idCliente);
	void guardar(Cliente cliente);
	void actualizar(Cliente cliente);
	void eliminar(Integer idCliente);
	
}
