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

import pe.idat.model.Producto;
import pe.idat.service.ProductoService;

@RestController
@RequestMapping("/producto/v1")
public class ProductoController {

	@Autowired
	private ProductoService service;
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<Producto>> getProducto(){
		return new ResponseEntity<List<Producto>>(service.lista(), HttpStatus.OK);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> insertarProducto(@RequestBody Producto producto) {
		service.guardar(producto);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/listar/{codigo}", method = RequestMethod.GET)
	public ResponseEntity<Producto> obtenerPorId(@PathVariable int codigo) {
		Producto producto = service.obtener(codigo);
		if(producto == null) {			
			return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Producto>(producto, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/editar", method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody Producto producto) 
	{
		Producto foundProducto = service.obtener(producto.getIdProducto());
		if(foundProducto == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		service.actualizar(producto);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(path = "/eliminar/{codigo}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable int codigo) 
	{
		Producto foundProducto = service.obtener(codigo);
		if(foundProducto == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		service.eliminar(codigo);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
