package com.examen.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.examen.dao.ViviendaDAO;
import com.examen.entity.Vivienda;


@RestController
@CrossOrigin(origins = "http://localhost:4401")
@RequestMapping("Vivienda")
public class RestVivienda {
	@Autowired
	private ViviendaDAO viviendaDAO;
	
	@RequestMapping(value ="Hello", method = RequestMethod.GET)
	public String Hello()
	{
		return "Hola Mundo";
	}
	
	@RequestMapping(value ="List", method = RequestMethod.GET)
	public ResponseEntity<List<Vivienda>> List() {
		
		try	{		
			List<Vivienda> item=viviendaDAO.findAll();
			return ResponseEntity.ok(item);
			
		}catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@RequestMapping(value ="Add", method = RequestMethod.POST)
	public ResponseEntity<Vivienda> Add(@RequestBody Vivienda persona)
	{
		try	{	
			Vivienda item= viviendaDAO.save(persona);
			return ResponseEntity.ok(item);
		}catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@RequestMapping(value ="FindById/{id}", method = RequestMethod.GET)
	public ResponseEntity<Vivienda> FindById(@PathVariable("id") Integer id) {
		try	{		
			Optional<Vivienda> item=viviendaDAO.findById(id);
			if(item.isPresent())
			{
				return ResponseEntity.ok(item.get());
			}
			else
			{
				return ResponseEntity.notFound().build();
			}
		}catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
		
	}
	@RequestMapping(value ="Edit", method = RequestMethod.PUT)
	public ResponseEntity<Vivienda> Edit(@RequestBody Vivienda vivienda)
	{
		try	{		 
			Optional<Vivienda> item= viviendaDAO.findById(vivienda.getId());
			if(item.isPresent())
			{
				item.get().setTipovivienda(vivienda.getTipovivienda());
				item.get().setArea(vivienda.getArea());
				item.get().setUbicacion(vivienda.getUbicacion());
				item.get().setPrecio(vivienda.getPrecio());
				viviendaDAO.save(item.get());
				return ResponseEntity.ok(item.get());
			}
			else
			{
				return ResponseEntity.notFound().build();
			}
		}catch (Exception e) {
			return ResponseEntity.notFound().build();
		}

	}
	@RequestMapping(value ="Delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> Delete(@PathVariable("id") Integer id)
	{
		try	{		
			viviendaDAO.deleteById(id);
			//return ResponseEntity.ok("Succes");
			 return ResponseEntity.status(HttpStatus.OK).body("Succes");
		}catch (Exception e) {
			//return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product doesn't exist in Database.");
			return ResponseEntity.ok(e.getMessage());
		}

	}
}
