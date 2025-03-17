package com.ecom.plantopia.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.plantopia.model.Plantmodel;

public interface Plantrepository extends JpaRepository<Plantmodel, Long> {
  List<Plantmodel> findByPrice(float price);
}
