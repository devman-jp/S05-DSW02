package pe.idat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="items")
public class Item {

	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ITEM")
	private Integer idItem;
	
	private String item;
	
	private Integer cantidad;
	
	private Double total;
	
	@ManyToOne
	@JoinColumn(
			name = "id_cliente"
	)
	private Cliente cliente;

	public Item() {
	}

	public Item(Integer idItem, String item, Integer cantidad, Double total) {
		this.idItem = idItem;
		this.item = item;
		this.cantidad = cantidad;
		this.total = total;
	}

	public Integer getIdItem() {
		return idItem;
	}

	public void setIdItem(Integer idItem) {
		this.idItem = idItem;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}
	
}
