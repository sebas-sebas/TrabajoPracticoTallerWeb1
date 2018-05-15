/**
 * 
 */
package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import antlr.collections.List;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

/**
 * @author sebas
 *
 */

@Controller
public class ControladorUsuario {

	@RequestMapping("/registrousuario")
	public ModelAndView irALogin() { 

		ModelMap modelo = new ModelMap();
		// Se agrega al modelo un objeto del tipo Usuario con key 'usuario' para que el mismo sea asociado
		// al model attribute del form que esta definido en la vista 'login'
		Usuario usuario = new Usuario();
	
		/*
		 * modelmap modelo = new modelmap()
		 */
		
		modelo.put("usuario", usuario);
		// Se va a la vista login (el nombre completo de la lista se resuelve utilizando el view resolver definido en el archivo spring-servlet.xml)
		// y se envian los datos a la misma  dentro del modelo
		return new ModelAndView("registrar", modelo);
	}
	
	
	@RequestMapping(path = "/registroCorrecto", method = RequestMethod.POST)
	public ModelAndView validarLogin(@ModelAttribute("usuario") Usuario usuario, HttpServletRequest request) {
		ModelMap model = new ModelMap();
		
		model.put("email", usuario.getEmail());
		model.put("password", usuario.getPassword());
		model.put("rol", usuario.getRol());

		return new ModelAndView("registroCorrecto", model);
	}
	 
	
	@RequestMapping(path="/listarUsuarios/{cantidad}", method = RequestMethod.GET)
	public ModelAndView listaDeUsuarios(
			@PathVariable  Integer  cantidad ){
		
		
		ModelMap modelo = new ModelMap();
		ArrayList<String> listaDeUsuarios = new ArrayList<String>();
		
		for (int i = 0; i < cantidad; i++) {
			listaDeUsuarios.add("usuario1");
				
		}
		
		
		modelo.put("cantidad", cantidad);
		
		modelo.addAttribute("listaDeUsuarios", listaDeUsuarios);
		
		return new ModelAndView("mostrarUsuarios", modelo);
	}
	
	
}
