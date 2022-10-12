package pe.idat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pe.idat.model.Proveedor;
import pe.idat.service.ProveedorService;


@RestController
@RequestMapping("/proveedor/v1")
public class ProveedorControler {
	
	@Autowired
	private ProveedorService service;
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<Proveedor>> getProveedor(){
		return new ResponseEntity<List<Proveedor>>(service.lista(), HttpStatus.OK);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> insertarProveedor(@RequestBody Proveedor proveedor) {
		service.guardar(proveedor);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/listar/{codigo}", method = RequestMethod.GET)
	public ResponseEntity<Proveedor> obtenerPorId(@PathVariable int codigo) {
		Proveedor proveedor = service.obtener(codigo);
		if(proveedor == null) {			
			return new ResponseEntity<Proveedor>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Proveedor>(proveedor, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/editar", method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody Proveedor proveedor) 
	{
		Proveedor foundproveedor = service.obtener(proveedor.getIdProveedor());
		if(foundproveedor == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		service.actualizar(proveedor);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(path = "/eliminar/{codigo}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable int codigo) 
	{
		Proveedor foundproveedor = service.obtener(codigo);
		if(foundproveedor == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		service.eliminar(codigo);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
