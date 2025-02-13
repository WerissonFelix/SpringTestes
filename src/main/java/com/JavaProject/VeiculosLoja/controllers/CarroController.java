package com.JavaProject.VeiculosLoja.controllers;


import com.JavaProject.VeiculosLoja.models.Carro;
import com.JavaProject.VeiculosLoja.models.CarroDto;
import com.JavaProject.VeiculosLoja.service.CarroRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/create")
    public String PagCarroCad(Model model){
        CarroDto carroDto = new CarroDto();
        model.addAttribute("carroDto",carroDto);
        return "Carros/CreateCarro";
    }
    @PostMapping("/create")
    public String CadCarro(@Valid @ModelAttribute CarroDto carroDto, BindingResult result){
        if(result.hasErrors()) {
            return "Carros/CreateCarro";
        }

        Carro carro = new Carro();
        carro.setMarca(carroDto.getMarca());
        carro.setModelo(carroDto.getModelo());
        carro.setAno(carroDto.getAno());
        carro.setQtd_portas(carroDto.getQtd_portas());
        carro.setTipo_combustivel(carroDto.getTipo_combustivel());
        carro.setQtd_passageiros(carroDto.getQtd_passageiros());
        carro.setSeguro(carroDto.getSeguro());

        System.out.print(carroDto.getQtd_passageiros());
        carroDAO.save(carro);

        return "redirect:/Carros";
    }
    @GetMapping("/find")
    public String findCarroById(@RequestParam int id, Model model) {
        try {
            Carro carro = carroDAO.findById(id).get();
            model.addAttribute("carro", carro);
            return "Carros/FindCarro";
        } catch (Exception ex) {
            System.out.println("Erro: " + ex.getMessage());
            return "redirect:/Carros";
        }
    }
    @GetMapping("/edit")
    public String PagEditar(Model model,@RequestParam int id){
        try{
            Carro carro = carroDAO.findById(id).get();
            model.addAttribute("carro",carro);

            CarroDto carroDto = new CarroDto();
            carroDto.setMarca(carro.getMarca());
            carroDto.setModelo(carro.getModelo());
            carroDto.setAno(carro.getAno());
            carroDto.setQtd_portas(carro.getQtd_portas());
            carroDto.setTipo_combustivel(carro.getTipo_combustivel());
            carroDto.setQtd_passageiros(carro.getQtd_passageiros());
            carroDto.setSeguro(carro.getSeguro());

            model.addAttribute("carroDto",carroDto);
        }
        catch(Exception ex){
            System.out.println("Erro: " + ex.getMessage());
            return "redirect:/Carros";
        }

        return "Carros/EditCarro";
    }

    @PostMapping("/edit")
    public String attCarro(Model model, @RequestParam int id, @Valid @ModelAttribute CarroDto carroDto, BindingResult result){
        try{
            Carro carro = carroDAO.findById(id).get();
            model.addAttribute("carro",carro);

            if (result.hasErrors()) {
                return "Carros/EditCarro";
            }

            carro.setMarca(carroDto.getMarca());
            carro.setModelo(carroDto.getModelo());
            carro.setAno(carroDto.getAno());
            carro.setQtd_portas(carroDto.getQtd_portas());
            carro.setTipo_combustivel(carroDto.getTipo_combustivel());
            carro.setQtd_passageiros(carroDto.getQtd_passageiros());
            carro.setSeguro(carroDto.getSeguro());

            carroDAO.save(carro);

        }
        catch(Exception ex){
            System.out.println("Erro: " + ex.getMessage());
            return "redirect:/Carros";
        }
        return "redirect:/Carros";
    }

    @GetMapping("/delete")
    public String deleteCarro(@RequestParam int id){
        try {
            Carro carro = carroDAO.findById(id).get();

            carroDAO.delete(carro);
        }
        catch(Exception ex){
            System.out.println("Erro: " + ex.getMessage());
            return "redirect:/Carros";
        }
        return "redirect:/Carros";
    }
}

