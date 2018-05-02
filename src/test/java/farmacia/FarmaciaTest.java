package farmacia;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Farmacia;
import ar.edu.unlam.tallerweb1.modelo.Direccion;
import ar.edu.unlam.tallerweb1.modelo.Barrio;
import ar.edu.unlam.tallerweb1.modelo.Punto;
import ar.edu.unlam.tallerweb1.modelo.Comuna;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * 
 * @author sebas
 * 
 *
 */
public class FarmaciaTest extends SpringTest {
	
	private Farmacia farmaciaDrAhorro, farmaciasAbc;
	private Direccion direccion, direccionDos;
	private Punto punto, puntoDos;
	private Barrio barrio, barrioDos;
	private Comuna comuna, comunaDos;
	private Session session;
	private List<Barrio> busquedaDeFarmacias;
	
	
	
	@Before
	public void setUp(){
		session = this.getSession();
		busquedaDeFarmacias = new ArrayList<>();
		
		comuna = new Comuna("La matanza");
		session.save(comuna);
		
		comunaDos = new Comuna("ramos Mejia");
		session.save(comunaDos);		
		
		barrio = new Barrio("la tablada", comuna);
		session.save(barrio);
	
		barrioDos = new Barrio("Don Bosco", comunaDos);
		session.save(barrioDos);
		
		direccion = new Direccion("brandsen", "12515", barrio);
		session.save(direccion);
		
		direccionDos = new Direccion("saavedra", "2554", barrioDos);
		session.save(direccionDos);
		
		punto     = new Punto("13.16", "556");
		session.save(punto);
		
		puntoDos     = new Punto("13.16", "556");
		session.save(puntoDos);		
		
		farmaciaDrAhorro = new Farmacia("farmaciaDrAhorro", "1234", "martes", direccion , punto);
		session.save(farmaciaDrAhorro);
		
		farmaciasAbc = new Farmacia("farmaciasAbc", "336", "martes", direccionDos , puntoDos);
		session.save(farmaciasAbc);		
	}
	
	/**
	 * PUNTO 2
	 */
	@Test
	@Transactional
	@Rollback()
	public void buscarTodasLasFarmaciasDeTurnoLosDiasMartes(){
		
		busquedaDeFarmacias = session
				.createCriteria(Farmacia.class)
				.add(Restrictions.eq("diaDeTurno", "martes"))
				.list();
		
		assertThat(busquedaDeFarmacias.size()).isEqualTo(2);
		
	}
	
	/*
	 PUNTO 3
	 */
	@Test
	@Transactional
	@Rollback()
	public void traerTodasLasFarmaciasDeUnaCalle(){
		
		busquedaDeFarmacias = session
				.createCriteria(Farmacia.class)
				.createAlias("direccion", "traerDireccion")
				.add(Restrictions.eq("traerDireccion.calle", "brandsen"))
				.list();
		
		assertThat(busquedaDeFarmacias.size()).isEqualTo(1);
		
	}

	/*
	 * PUNTO 4
	 * */
	@Test
	@Transactional
	@Rollback()
	public void traerTodasLasFarmaciasDeUnBarrio(){
		
		busquedaDeFarmacias = session
				.createCriteria(Farmacia.class)
				.createAlias("direccion", "traerDireccion")
				.createAlias("traerDireccion.barrio", "traerElBarrio")
				.add(Restrictions.eq("traerElBarrio.nombre", "la tablada"))
				.list();
		
		assertThat(busquedaDeFarmacias.size()).isEqualTo(1);
		
	}
}


