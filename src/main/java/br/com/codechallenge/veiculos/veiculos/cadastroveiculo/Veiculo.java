package br.com.codechallenge.veiculos.veiculos.cadastroveiculo;

import java.math.BigDecimal;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.codechallenge.veiculos.veiculos.cadastrousuario.Usuario;

@Entity
public class Veiculo {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private @NotNull @NotBlank String marca;
  private @NotNull @NotBlank String modelo;
  private @NotNull @NotBlank String ano;
  private String valor;

  @ManyToOne @JoinColumn(name = "usuario_id")
  private Usuario usuario;



  public Veiculo( String marca, String modelo, String ano, String valor, Usuario usuario) {
    
    this.marca = marca;
    this.modelo = modelo;
    this.ano = ano;
    this.valor = valor;
    this.usuario = usuario;
  }
  

  public Veiculo(@NotNull @NotBlank String marca, @NotNull @NotBlank String modelo, @NotNull @NotBlank String ano,
      Usuario usuario) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.usuario = usuario;
  }
  @Deprecated
  public Veiculo(){}

  public Long getId() {
    return this.id;
  }

  public String getMarca() {
    return this.marca;
  }

  public String getModelo() {
    return this.modelo;
  }

  public String getAno() {
    return this.ano;
  }

  public Usuario getUsuario() {
    return this.usuario;
  }

  public String getValor() {
    return this.valor;
  }


}
