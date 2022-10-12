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

import pe.idat.model.Item;
import pe.idat.model.Producto;
import pe.idat.service.ItemService;
import pe.idat.service.ProductoService;

@RestController
@RequestMapping("/item/v1")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<Item>> getItem(){
		return new ResponseEntity<List<Item>>(itemService.lista(), HttpStatus.OK);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> insertarItem(@RequestBody Item item) {
		itemService.guardar(item);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/listar/{codigo}", method = RequestMethod.GET)
	public ResponseEntity<Item> obtenerPorId(@PathVariable int codigo) {
		Item item = itemService.obtener(codigo);
		if(item == null) {			
			return new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Item>(item, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/editar", method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody Item item) 
	{
		Item founditem = itemService.obtener(item.getIdItem());
		if(founditem == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		itemService.actualizar(item);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(path = "/eliminar/{codigo}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable int codigo) 
	{
		Item founditem = itemService.obtener(codigo);
		if(founditem == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		itemService.eliminar(codigo);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
