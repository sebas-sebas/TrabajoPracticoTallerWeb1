package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * 
 * @author sebas
 *
 */
@Entity
public class Farmacia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String telefono;
	private String diaDeTurno;
	
	@ManyToOne
	private Direccion direccion;
	@ManyToOne
	private Punto geoLocalizacion;
	

	public Farmacia(){
		
	}
	
	
	/**
	 * 
	 * @param nombre
	 * @param telefono
	 * @param diaDeTurno
	 * @param direccion
	 * @param punto
	 */
	public Farmacia(String nombre, String telefono, String diaDeTurno, Direccion direccion, Punto punto) {
		this.nombre = nombre;
		this.telefono = telefono;
		this.diaDeTurno = diaDeTurno;
		this.direccion = direccion;
		this.geoLocalizacion = punto;
	}

	

	/**
	 * 
	 * @return
	 */
	public Punto getGeoLocalizacion() {
		return geoLocalizacion;
	}

	/**
	 * 
	 * @param punto
	 */
	public void setGeoLocalizacion(Punto punto) {
		this.geoLocalizacion = punto;
	}

	/**
	 * 
	 * @return
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * 
	 * @return
	 */
	public String getTelefono() {
		return telefono;
	}
	/**
	 * 
	 * @param telefono
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	/**
	 * 
	 * @return
	 */
	public Direccion getDireccion() {
		return direccion;
	}
	
	/**
	 * 
	 * @param direccion
	 */
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getDiaDeTurno() {
		return diaDeTurno;
	}
	/**
	 * 
	 * @param diaDeTurno
	 */
	public void setDiaDeTurno(String diaDeTurno) {
		this.diaDeTurno = diaDeTurno;
	}
	
	
}
