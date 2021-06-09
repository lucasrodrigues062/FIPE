package br.com.codechallenge.veiculos.veiculos.detalheveiculos;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.codechallenge.veiculos.veiculos.cadastrousuario.Usuario;
import br.com.codechallenge.veiculos.veiculos.cadastroveiculo.Veiculo;

public class ConsultaVeiculoRequest {
  
  private String nome;
  private String email;
  private String cpf;
  @JsonFormat(pattern = "dd/MM/yyyy")
  private LocalDate dataNascimento;

  private List<VeiculoRequest> veiculos;
  


  public ConsultaVeiculoRequest(Usuario usuario) {
    this.nome = usuario.getNome();
    this.email = usuario.getEmail();
    this.cpf = usuario.getCpf();
    this.dataNascimento = usuario.getDataNascimento();
    System.out.println(usuario.getVeiculos().size());
    List<VeiculoRequest> listVeiculos = new ArrayList<VeiculoRequest>();
    usuario.getVeiculos().forEach(veiculo -> {
      System.out.println(veiculo.getMarca());
      listVeiculos.add(new VeiculoRequest(veiculo));
    });
    this.veiculos = listVeiculos;

  }
  @Deprecated
  public ConsultaVeiculoRequest(){}


  public String getNome() {
    return this.nome;
  }

  public String getEmail() {
    return this.email;
  }

  public String getCpf() {
    return this.cpf;
  }

  public LocalDate getDataNascimento() {
    return this.dataNascimento;
  }

  public List<VeiculoRequest> getVeiculos() {
    return this.veiculos;
  }


}
