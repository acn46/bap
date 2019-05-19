package edu.drexel.alan.bap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.drexel.alan.bap.model.Bacteria;
import edu.drexel.alan.bap.service.BacteriaService;
import edu.drexel.alan.bap.service.ServiceException;

@RestController
public class BacteriaController {

	@Autowired
	public BacteriaService service;
	
	@GetMapping("/bacterialist")
	public List<Bacteria> getAll() {
		System.out.println("\nin getAll");
		List<Bacteria> list = null;
		try {
			list = service.findAll();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@GetMapping("/bacteria/{id}")
	public Bacteria findByID(@PathVariable("id") int id) {
		System.out.println("\nin findByID "+id);
		Bacteria bacteria = null;
		try {
			bacteria = service.findById(id);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bacteria;
	}
	
	@PostMapping("/bacteriainsert")
	public @ResponseBody int insert(@RequestBody Bacteria bacteria) {
		System.out.println("\nin Insert");
		int rowAffected = 0;
		try {
			rowAffected = service.insert(bacteria);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return rowAffected;
	}
	
	@PostMapping("/bacteriaupdate")
	public @ResponseBody int update(@RequestBody Bacteria bacteria) {
		System.out.println("\nin update");
		int rowAffected = 0;
		try {
			rowAffected = service.update(bacteria);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowAffected;
	}
	
	@DeleteMapping("/bacteria/{id}")
	public void delete(@PathVariable("id") int id) {
		System.out.println("\nin delete");
		try {
			service.delete(id);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}

