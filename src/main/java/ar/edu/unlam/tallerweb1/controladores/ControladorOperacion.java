/**
 * 
 */
package ar.edu.unlam.tallerweb1.controladores;
import java.util.Optional;

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
public class ControladorOperacion {
	
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
		Integer resultado = numeroUno + numeroDos;
		String mensaje = "EL RESULTADO DE SUMAR " + numeroUno + " Y " + numeroDos + " ES " + resultado;
		modelo.put("operacionMensaje", mensaje);
		return new ModelAndView("operaciones", modelo);
	}
	
	/**
	 * 
	 * @param numeroUno
	 * @param numeroDos
	 * @return
	 */
	@RequestMapping(path="/restar/{numeroUno}/{numeroDos}", method = RequestMethod.GET)
	public ModelAndView realizarOperacionResta(
			@PathVariable  Integer  numeroUno,
			@PathVariable  Integer  numeroDos){
		
		
		ModelMap modelo = new ModelMap();
		Integer resultado = numeroUno - numeroDos;
		String mensaje = "EL RESULTADO DE RESTAR " + numeroUno + " Y " + numeroDos + " ES " + resultado;
		modelo.put("operacionMensaje", mensaje);
		return new ModelAndView("operaciones", modelo);
	}
	
	/**
	 * 
	 * @param numeroUno
	 * @param numeroDos
	 * @return
	 */
	@RequestMapping(path="/multiplicar/{numeroUno}/{numeroDos}", method = RequestMethod.GET)
	public ModelAndView realizarOperacionMultiplicar(
			@PathVariable  Integer  numeroUno,
			@PathVariable  Integer  numeroDos){
		
		
		ModelMap modelo = new ModelMap();
		Integer resultado = numeroUno * numeroDos;
		String mensaje = "EL RESULTADO DE MULTIPLICAR " + numeroUno + " Y " + numeroDos + " ES " + resultado;
		modelo.put("operacionMensaje", mensaje);
		return new ModelAndView("operaciones", modelo);
	}
	
	/**
	 * 
	 * @param numeroUno
	 * @param numeroDos
	 * @return
	 */
	@RequestMapping(path="/dividir/{numeroUno}/{numeroDos}", method = RequestMethod.GET)
	public ModelAndView realizarOperacionDividir(
			@PathVariable  Float  numeroUno,
			@PathVariable  Float  numeroDos){
		
		ModelMap modelo = new ModelMap();

		if (numeroDos == 0) {
			modelo.put("operacionMensaje", "NO SE PUEDE DIVIDIR POR 0");
			return new ModelAndView("error", modelo);			
		} else {
			Float resultado = (float) (numeroUno / (float) numeroDos);
			String mensaje = "EL RESULTADO DE DIVIDIR " + (float) numeroUno + " Y " + (float) numeroDos + " ES " + resultado;
			modelo.put("operacionMensaje", mensaje);
			return new ModelAndView("operaciones", modelo);
		}


	}
}

