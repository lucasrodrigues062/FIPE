package br.com.codechallenge.veiculos.veiculos.cadastrousuario;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.br.CPF;

import br.com.codechallenge.veiculos.veiculos.cadastroveiculo.Veiculo;

@Entity
public class Usuario {
  
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

  private Long id;
  @Column(nullable = false)
  private @NotNull @NotBlank String nome;
  @Column(unique = true, nullable = false)
  private @Email @NotNull @NotBlank String email;
  @Column(unique = true, nullable = false)
  private @CPF @NotNull @NotBlank String cpf;
  @Column(nullable = false)
  private @Past LocalDate dataNascimento;

  @OneToMany(mappedBy = "usuario")
  private List<Veiculo> veiculos;

  public Usuario(@NotNull @NotBlank String nome, @Email @NotNull @NotBlank String email,
      @CPF @NotNull @NotBlank String cpf, @Past LocalDate dataNascimento) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
  }

  @Deprecated
  public Usuario(){}
  

  public Long getId() {
    return this.id;
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


  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", nome='" + getNome() + "'" +
      ", email='" + getEmail() + "'" +
      ", cpf='" + getCpf() + "'" +
      ", dataNascimento='" + getDataNascimento() + "'" +
      "}";
  }

}
