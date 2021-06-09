package br.com.codechallenge.veiculos.veiculos.detalheveiculos;

import java.time.DayOfWeek;

import br.com.codechallenge.veiculos.veiculos.cadastroveiculo.Veiculo;

public class VeiculoRequest {
  private String marca;
  private String modelo;
  private String ano;
  private String valor;
  private DayOfWeek diaDoRodizio;
  private boolean rodizio;


  public VeiculoRequest(Veiculo veiculo){
    this.marca = veiculo.getMarca();
    this.modelo = veiculo.getModelo();
    this.ano = veiculo.getAno();
    this.valor = veiculo.getValor();
    this.diaDoRodizio = veiculo.getDiaRodizio();
    this.rodizio = veiculo.isRodizioAtivo();
  }

  @Deprecated
  public VeiculoRequest(){}
  public String getMarca() {
    return this.marca;
  }

  public String getModelo() {
    return this.modelo;
  }

  public String getAno() {
    return this.ano;
  }

  public String getValor() {
    return this.valor;
  }

  public DayOfWeek getDiaDoRodizio() {
    return this.diaDoRodizio;
  }

  public boolean getRodizio() {
    return this.rodizio;
  }

  public boolean isRodizio() {
    return this.rodizio;
  }

}
