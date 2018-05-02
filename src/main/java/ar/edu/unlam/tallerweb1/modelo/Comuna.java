package ar.edu.unlam.tallerweb1.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * 
 * @author sebas
 *
 */

@Entity
public class Comuna {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	
	@OneToMany
	private List<Barrio> barrios = new ArrayList<Barrio>();

	public Comuna(){
		
	}

	/***
	 * 
	 * @param nombre
	 */
	public Comuna(String nombre) {
		this.nombre = nombre;

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
	public List<Barrio> getBarrios() {
		return barrios;
	}
	
	/**
	 * 
	 * @param barrios
	 */
	public void setBarrios(List<Barrio> barrios) {
		this.barrios = barrios;
	}


	
	
}
