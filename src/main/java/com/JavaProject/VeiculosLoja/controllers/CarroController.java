package com.JavaProject.VeiculosLoja.controllers;


import com.JavaProject.VeiculosLoja.models.Carro;
import com.JavaProject.VeiculosLoja.service.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import java.util.List;

@Controller
@RequestMapping("/Carros")
public class CarroController {

    @Autowired
    private CarroRepository carroDAO;

    @GetMapping
    public String ListarCarro(Model model){
        List<Carro> carros = carroDAO.findAll();
        model.addAttribute("carros",carros);
        return "Carros/index";
    }
}

