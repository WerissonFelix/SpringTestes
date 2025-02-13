package com.JavaProject.VeiculosLoja.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class CarroDto {

    @NotEmpty(message = "A marca é obrigatória")
    private String marca;

    @NotEmpty(message = "O modelo é obrigatório")
    private String modelo;

    @NotNull(message = "O ano é obrigatório")
    @Min(1970)
    private Integer ano;

    @NotNull(message = "a quantidade de portaas é obrigatória")
    @Min(2)
    private Integer qtd_portas;

    @NotEmpty(message = "O tipo de combstivel é obrigatório")
    private String tipo_combustivel;

    @NotNull(message = "A quantidade de passageiros é obrigatória")
    @Min(2)
    private Integer qtd_passageiros;
    @NotNull(message ="O seguro é obrigatório")
    private Boolean seguro;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Integer getQtd_portas() {
        return qtd_portas;
    }

    public void setQtd_portas(Integer qtd_portas) {
        this.qtd_portas = qtd_portas;
    }

    public String getTipo_combustivel() {
        return tipo_combustivel;
    }

    public void setTipo_combustivel(String tipo_combustivel) {
        this.tipo_combustivel = tipo_combustivel;
    }

    public Integer getQtd_passageiros() {
        return qtd_passageiros;
    }

    public void setQtd_passageiros(Integer qtd_passageiros) {
        this.qtd_passageiros = qtd_passageiros;
    }

    public Boolean getSeguro() {
        return seguro;
    }

    public void setSeguro(Boolean seguro) {
        this.seguro = seguro;
    }
}
