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
public class Direccion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String calle;
	private String numero;
	
	@ManyToOne
	private Barrio barrio;
		
	public Direccion(){
		
	}
	
	/**
	 * 
	 * @param calle
	 * @param numero
	 * @param barrio
	 */
	public Direccion(String calle, String numero, Barrio barrio) {
		this.calle = calle;
		this.numero = numero;
		this.barrio = barrio;
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
	public String getCalle() {
		return calle;
	}
	/**
	 * 
	 * @param calle
	 */
	public void setCalle(String calle) {
		this.calle = calle;
	}
	/**
	 * 
	 * @return
	 */
	public String getNumero() {
		return numero;
	}
	/**
	 * 
	 * @param numero
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}
	/**
	 * 
	 * @return
	 */
	public Barrio getBarrio() {
		return barrio;
	}
	
	/**
	 * 
	 * @param barrio
	 */
	public void setBarrio(Barrio barrio) {
		this.barrio = barrio;
	}
	
	
	
	
}
