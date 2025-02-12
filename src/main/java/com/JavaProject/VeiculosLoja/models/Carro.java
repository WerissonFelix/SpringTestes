package com.JavaProject.VeiculosLoja.models;


import jakarta.persistence.*;

@Entity
@Table(name = "Carro")
public class Carro{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "marca", length = 50, nullable = false )
    private String marca;
    @Column(name = "modelo", length = 50, nullable = false)
    private String modelo;
    @Column(name = "ano", nullable = false)
    private Integer ano;
    @Column(name = "qtd_portas", nullable = false)
    private int qtd_portas;
    @Column(name = "tipo_combustivel", length = 30, nullable = false)
    private String tipo_combustivel;
    @Column(name = "qtd_passageiros", nullable = false) // Corresponder ao banco de dados
    private Integer qtd_passageiros;
    @Column(name = "seguro", nullable = false)
    private Boolean seguro;
    //Composição: É usada quando um objeto depende inteiramente do outro para existir.
    // No exemplo, a Carro depende do Dono, e o vínculo é mais forte, indicando que os dois têm um ciclo de vida conjunto.
    //private Dono dono;

    /* public Carro(String marca, String modelo, int ano, int quantidadePortas, String tipoCombustivel, int QtdPassageiros, boolean Seguro, Long id) {
        super(marca, modelo, ano, QtdPassageiros, Seguro);

        this.quantidadePortas = quantidadePortas;
        this.tipoCombustivel = tipoCombustivel;
        this.id = id;
        //this.dono = dono;
    } */

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }

    // public Dono getDono() {
    //   return this.dono;
    // }

    // public void setDono(Dono dono) {
    //    this.dono = dono;
    // }


    public Boolean getSeguro() {
        return seguro;
    }

    public void setSeguro(Boolean seguro) {
        this.seguro = seguro;
    }


    public Integer getQtd_passageiros() {
        return qtd_passageiros;
    }

    public void setQtd_passageiros(Integer qtd_passageiros) {
        this.qtd_passageiros = qtd_passageiros;
    }

    public String getTipo_combustivel() {
        return tipo_combustivel;
    }

    public void setTipo_combustivel(String tipo_combustivel) {
        this.tipo_combustivel = tipo_combustivel;
    }

    public int getQtd_portas() {
        return qtd_portas;
    }

    public void setQtd_portas(int qtd_portas) {
        this.qtd_portas = qtd_portas;
    }

    // imprimir dados do carro


    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }


}
