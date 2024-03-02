package com.laptop.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.naming.NameNotFoundException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptop.dao.LaptopDao;
import com.laptop.entity.Laptop;
import com.laptop.exception.PriceNotFoundException;

@Service
public class LaptopService {
	@Autowired
	LaptopDao ld;
	
	public String postAll(List<Laptop> l)
	{
		return ld.postAll(l);
	}

	
	public List<Laptop> getAll()
	{
		return ld.getAll();
	}
	public String update(Laptop l)
	{
		return ld.update(l);
		
	}
	public String updateData(Laptop l,int id)
	{
		return ld.updateData(l,id);	
	}
	
	public String modify(Laptop l,int id)
	{
		return ld.modify(l,id);
	}
	
	public List<Laptop> getByPrice(int price)throws PriceNotFoundException
	{
		
		List<Laptop> lp=ld.getAll().stream().filter(x->x.getPrice()<20000).collect(Collectors.toList());
		if(lp.isEmpty())
		{
			throw new PriceNotFoundException("No Item found");
		}
		else
		{
			return lp;
		}
	}
	
	public Optional<Laptop> getByBrand(String brand) throws NameNotFoundException
	{
		if(ld.getByBrand(brand).isEmpty())
		{
			throw new NameNotFoundException("No Item found");
		}
		else
		{
			return ld.getByBrand(brand);
		}
		//return ld.getByBrand(brand);
		
		
	}


}
