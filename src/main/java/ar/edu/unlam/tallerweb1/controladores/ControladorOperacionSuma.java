/**
 * 
 */
package ar.edu.unlam.tallerweb1.controladores;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author sebas
 *
 */
@Controller
public class ControladorOperacionSuma {
	
	/**
	 * 
	 * @param numeroUno
	 * @param numeroDos
	 * @return
	 */
	@RequestMapping(path="/sumar/{numeroUno}/{numeroDos}", method = RequestMethod.GET)
	public ModelAndView realizarOperacionSuma(
			@PathVariable  Integer  numeroUno,
			@PathVariable  Integer  numeroDos){
		
		ModelMap modelo = new ModelMap();
		Integer resultadoSuma = numeroUno + numeroDos;
		String mensaje = "EL RESULTADO DE SUMAR " + numeroUno + " Y " + numeroDos + " ES " + resultadoSuma;
		modelo.put("suma", mensaje);
		return new ModelAndView("operacionSuma", modelo);
	}
	

}

