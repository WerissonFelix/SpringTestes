package com.JavaProject.VeiculosLoja.service;

import com.JavaProject.VeiculosLoja.models.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository<Carro, Integer> {
}
