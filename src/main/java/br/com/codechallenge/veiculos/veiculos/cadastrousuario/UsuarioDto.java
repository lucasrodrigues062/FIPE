package br.com.codechallenge.veiculos.veiculos.cadastrousuario;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.hibernate.validator.constraints.br.CPF;

public class UsuarioDto {

  @NotNull @NotBlank
  private String nome;
  
  @Email @NotNull @NotBlank
  private String email;
  
  @CPF @NotNull @NotBlank
  private String cpf;
  
  @JsonFormat(pattern = "dd/MM/yyyy") @Past
  private LocalDate dataNascimento;

  @Deprecated
  public UsuarioDto(){}

  public Usuario toModel(){
    return new Usuario(this.nome, this.email, this.cpf, this.dataNascimento);
  }

  public UsuarioDto(String nome, String email, String cpf, LocalDate dataNascimento) {
    this.nome = nome;
    this.email = email;
    this.cpf = cpf;
    this.dataNascimento = dataNascimento;
  }

  public UsuarioDto(Usuario usuario) {
    this.nome = usuario.getNome();
    this.email = usuario.getEmail();
    this.cpf = usuario.getCpf();
    this.dataNascimento = usuario.getDataNascimento();
  }

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

}
