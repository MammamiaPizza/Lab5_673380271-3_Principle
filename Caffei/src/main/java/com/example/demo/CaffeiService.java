package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class CaffeiService {
	private List<Coffee> ListOfMenu = new ArrayList<Coffee>();
	private int incrementor = 0;
	
	CaffeiService(){
		ListOfMenu.add(new Coffee(++incrementor, "O liang", 20));
		ListOfMenu.add(new Coffee(++incrementor, "Mocha", 30));
	}
	
	
	public List<Coffee> getAll() {
        return ListOfMenu;
    }
	
	public Coffee addMenu(Coffee newmenu) {
		newmenu.setId(++incrementor);
		ListOfMenu.add(newmenu);
		return newmenu;
	}
	
	public Coffee addMenu(String name, double price) {
		ListOfMenu.add(new Coffee(++incrementor, name, price));
		return ListOfMenu.get(incrementor);
	}
	
	public Coffee searchByID(int id) {
		for (Coffee each : ListOfMenu) {
			if (id == each.getId()) {
				return each;
			}
			else {
				continue;
			}
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Coffee id " + id + " not found");
	}
	
	public Coffee update(int id, String name, double price) {
		Coffee temp = searchByID(id);
		temp.setName(name);
		temp.setPrice(price);
		return temp;
	}
	
	public Coffee update(int id, Coffee UpdateData) {
		Coffee temp = searchByID(id);
		temp.setName(UpdateData.getName());
		temp.setPrice(UpdateData.getPrice());
		return temp;
	}
	
	public void delete(int id) {
		Coffee temp = searchByID(id);
		ListOfMenu.remove(temp);
	}
	
	
}
