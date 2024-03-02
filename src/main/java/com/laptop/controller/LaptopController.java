package com.laptop.controller;

import java.util.List;
import java.util.Optional;

import javax.naming.NameNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laptop.entity.Laptop;
import com.laptop.exception.PriceNotFoundException;
import com.laptop.service.LaptopService;

@RestController
@RequestMapping(value="/laptop")
public class LaptopController {
	
	@Autowired
	LaptopService ls;
	
	@PostMapping(value="/postAll")
	public String postAll(@RequestBody List<Laptop> l)
	{
		return ls.postAll(l);
	}

	@GetMapping(value="/getAll")
	public List<Laptop> getAll()
	{
		return ls.getAll();
	}
	
	@PutMapping(value="/update")
	public String update(@RequestBody Laptop l)
	{
		return ls.update(l);	
	}
	
	@PutMapping(value="/updateData/{id}")
	public String updateData(@RequestBody Laptop l,@PathVariable int id)
	{
		return ls.updateData(l,id);	
	}
	
	@PatchMapping(value="/modify/{id}")
	public String modify(@RequestBody Laptop l,@PathVariable int id)
	{
		return ls.modify(l,id);
	}
	@GetMapping(value="/getByPrice/{price}")
	public List<Laptop> getByPrice(@PathVariable int price) throws PriceNotFoundException
	{
		return ls.getByPrice(price);
	}
	
	@GetMapping(value="/getByBrand/{brand}")
	public Optional<Laptop> getByBrand(@PathVariable String brand) throws NameNotFoundException
	{

		return ls.getByBrand(brand);
	}
	
	
	
	}
