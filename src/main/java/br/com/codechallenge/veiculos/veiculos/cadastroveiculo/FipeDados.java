package br.com.codechallenge.veiculos.veiculos.cadastroveiculo;

public class FipeDados {

  
  private String nome;
  private String codigo;

  @Deprecated
  public FipeDados(){}

  public String getNome() {
    return this.nome;
  }

  public String getCodigo() {
    return this.codigo;
  }

  public FipeDados(String nome, String codigo) {
    this.nome = nome;
    this.codigo = codigo;
  }

  @Override
  public String toString() {
    return "{" +
      " nome='" + getNome() + "'" +
      ", codigo='" + getCodigo() + "'" +
      "}";
  }
  public void setNome(String nome) {
    this.nome = nome;
  }
  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  
}
