package com.laptop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.laptop.entity.Laptop;


public interface LaptopRepository extends JpaRepository<Laptop, Integer> {

	@Query(value = "SELECT * FROM laptop WHERE brand=?", nativeQuery = true)
    public Optional<Laptop> findByBrand(String brand);
}
		