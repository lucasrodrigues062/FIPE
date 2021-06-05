package br.com.codechallenge.veiculos.veiculos.cadastroveiculo;

import java.util.List;

public class FipeModelo {

  List<FipeDados> anos;
  List<FipeDados> modelos;


  public FipeModelo(List<FipeDados> anos, List<FipeDados> modelos) {
    this.anos = anos;
    this.modelos = modelos;
  }

  public List<FipeDados> getAnos() {
    return this.anos;
  }

  public List<FipeDados> getModelos() {
    return this.modelos;
  }

  public FipeModelo(){}
  
}
