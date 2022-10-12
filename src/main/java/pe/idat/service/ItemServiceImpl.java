package pe.idat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.idat.model.Item;
import pe.idat.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService{

	@Autowired
	private ItemRepository repository;
	
	@Override
	public List<Item> lista() {
		return repository.findAll();
	}

	@Override
	public Item obtener(Integer idItem) {
		return repository.findById(idItem).orElse(null);
	}

	@Override
	public void guardar(Item item) {
		repository.save(item);
	}

	@Override
	public void actualizar(Item item) {
		repository.saveAndFlush(item);
	}

	@Override
	public void eliminar(Integer idItem) {
		repository.deleteById(idItem);
	}

}
