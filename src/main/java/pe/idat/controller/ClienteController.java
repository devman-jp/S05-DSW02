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

import pe.idat.model.Cliente;
import pe.idat.service.ClienteService;

@RestController
@RequestMapping("/cliente/v1")
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<Cliente>> getCliente(){
		return new ResponseEntity<List<Cliente>>(service.lista(), HttpStatus.OK);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> insertarCliente(@RequestBody Cliente cliente) {
		service.guardar(cliente);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/listar/{codigo}", method = RequestMethod.GET)
	public ResponseEntity<Cliente> obtenerPorId(@PathVariable int codigo) {
		Cliente cliente = service.obtener(codigo);
		if(cliente == null) {			
			return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/editar", method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody Cliente cliente) 
	{
		Cliente foundCliente = service.obtener(cliente.getIdCliente());
		if(foundCliente == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		service.actualizar(cliente);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(path = "/eliminar/{codigo}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable int codigo) 
	{
		Cliente foundCliente = service.obtener(codigo);
		if(foundCliente == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		service.eliminar(codigo);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
