package com.laptop.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.laptop.entity.Laptop;
import com.laptop.repository.LaptopRepository;

@Repository
public class LaptopDao {

	@Autowired
	LaptopRepository lr;
	
	public String postAll(List<Laptop> l)
	{
		lr.saveAll(l);
		return "Saved";
	}

	
	public List<Laptop> getAll()
	{
		return lr.findAll();
	}
	
	public String update(Laptop l)
	{
		lr.save(l);
		return "Updated";
	}
	public String updateData(Laptop l,int id)
	{
		Laptop lp=lr.findById(id).get();
		lp.setBrand(lp.getBrand().toLowerCase());
		lp.setPrice(lp.getPrice()+5000);
		lp.setRam(lp.getRam()+2);
			
		lr.save(lp);
		return "Updated";
	}
	
	public String modify(Laptop l,int id)
	{
		Laptop x=lr.findById(id).get();
		if(l.getPrice()>0)
		{
			x.setPrice(l.getPrice());
		}
		lr.save(x);
		return "Updated Successfully";
	}
	
	public Optional<Laptop> getByBrand(String brand) 
	{
		return lr.findByBrand(brand);
		
		
	}

}
