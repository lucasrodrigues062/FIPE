package br.com.codechallenge.veiculos.veiculos.cadastroveiculo;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAlias;

public class FipeVeiculo {
  @JsonAlias("Marca")
  private String marca;
  @JsonAlias("Modelo")
  private String modelo;
  @JsonAlias("AnoModelo")
  private String anoModelo;
  @JsonAlias("Combustivel")
  private String combustivel;
  @JsonAlias("CodigoFipe")
  private String codigoFipe;
  @JsonAlias("MesReferencia")
  private String mesReferencia;
  @JsonAlias("TipoVeiculo")
  private String tipoVeiculo;
  @JsonAlias("SiglaCombustivel")
  private String siglaCombustivel;
  @JsonAlias("Valor")
  private String valor;


  public FipeVeiculo(String marca, String modelo, String anoModelo, String combustivel, String codigoFipe, String mesReferencia, String tipoVeiculo, String siglaCombustivel, String valor) {
    this.marca = marca;
    this.modelo = modelo;
    this.anoModelo = anoModelo;
    this.combustivel = combustivel;
    this.codigoFipe = codigoFipe;
    this.mesReferencia = mesReferencia;
    this.tipoVeiculo = tipoVeiculo;
    this.siglaCombustivel = siglaCombustivel;
    this.valor = valor;
  }

  public String getMarca() {
    return this.marca;
  }

  public String getModelo() {
    return this.modelo;
  }

  public String getAnoModelo() {
    return this.anoModelo;
  }

  public String getCombustivel() {
    return this.combustivel;
  }

  public String getCodigoFipe() {
    return this.codigoFipe;
  }

  public String getMesReferencia() {
    return this.mesReferencia;
  }

  public String getTipoVeiculo() {
    return this.tipoVeiculo;
  }

  public String getSiglaCombustivel() {
    return this.siglaCombustivel;
  }

  public String getValor() {
    return this.valor;
  }

  @Override
  public String toString() {
    return "{" +
      " marca='" + getMarca() + "'" +
      ", modelo='" + getModelo() + "'" +
      ", anoModelo='" + getAnoModelo() + "'" +
      ", combustivel='" + getCombustivel() + "'" +
      ", codigoFipe='" + getCodigoFipe() + "'" +
      ", mesReferencia='" + getMesReferencia() + "'" +
      ", tipoVeiculo='" + getTipoVeiculo() + "'" +
      ", siglaCombustivel='" + getSiglaCombustivel() + "'" +
      ", valor='" + getValor() + "'" +
      "}";
  }

 @Deprecated 
 public FipeVeiculo(){}


  

}
