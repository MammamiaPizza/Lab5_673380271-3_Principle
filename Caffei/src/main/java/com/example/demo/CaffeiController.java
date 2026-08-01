package com.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CaffeiController {
	
	private final CaffeiService coffeiService = new CaffeiService();
	
	@GetMapping("/coffees")
    public List<Coffee> showAllMenu() {
        return coffeiService.getAll();
    }
	
	
	@GetMapping(value = "/coffees/{id}")
	public Coffee ShowonlyID(@PathVariable int id) {
		return coffeiService.searchByID(id);
	}
	
	@PostMapping("/coffees")
	public Coffee addMenu(@RequestBody Coffee newMenu) {
		return coffeiService.addMenu(newMenu);
	}
	

	@PutMapping("/coffees/{id}")
	    public Coffee updateMenu(@PathVariable int id, @RequestBody Coffee updatedMenu) {
	        return coffeiService.update(id, updatedMenu);
	}

	 @DeleteMapping("/coffees/{id}")
	    public String deleteMenu(@PathVariable int id) {
	        coffeiService.delete(id);
	        return "Deleted id " + id;
	 }
	
}
