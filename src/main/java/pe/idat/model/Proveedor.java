package pe.idat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="proveedores")
public class Proveedor {

	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PROVEEDOR")
	private Integer idProveedor;
	
	private String nombreProveedor;
	
	private String direccion;

	@OneToOne()
	private Producto producto;
	
	public Proveedor() {
	}

	public Proveedor(Integer idProveedor, String nombreProveedor, String direccion) {
		this.idProveedor = idProveedor;
		this.nombreProveedor = nombreProveedor;
		this.direccion = direccion;
	}

	public Integer getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(Integer idProveedor) {
		this.idProveedor = idProveedor;
	}

	public String getNombreProveedor() {
		return nombreProveedor;
	}

	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
}
