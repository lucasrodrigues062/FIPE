package br.com.codechallenge.veiculos.veiculos.cadastroveiculo;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private @NotNull @NotBlank String marca;
  private @NotNull @NotBlank String modelo;
  private @NotNull @NotBlank String ano;
  private String valor;

  @ManyToOne
  @JoinColumn(name = "usuario_id")
  private Usuario usuario;
  @Enumerated(EnumType.STRING)
  private DayOfWeek diaRodizio;
  private boolean rodizioAtivo = false;

  public Veiculo(String marca, String modelo, String ano, String valor, Usuario usuario) {

    this.marca = marca;
    this.modelo = modelo;
    this.ano = ano;
    this.valor = valor;
    this.usuario = usuario;
    String rodizio = ano.substring(3,4);
    System.out.println(rodizio);
    if (rodizio.equals("0") || rodizio.equals("1")) {
      this.diaRodizio = DayOfWeek.MONDAY;
    }
    if (rodizio.equals("2") || rodizio.equals("3")) {
      this.diaRodizio = DayOfWeek.TUESDAY;
    }
    if (rodizio.equals("4") || rodizio.equals("5")) {
      System.out.println("Entrou no if");
      this.diaRodizio = DayOfWeek.WEDNESDAY;
    }
    if (rodizio.equals("6") || rodizio.equals("7")) {
      this.diaRodizio = DayOfWeek.THURSDAY;
    }
    if (rodizio.equals("8") || rodizio.equals("9")) {
      this.diaRodizio = DayOfWeek.FRIDAY;
    }
  }

  public Veiculo(@NotNull @NotBlank String marca, @NotNull @NotBlank String modelo, @NotNull @NotBlank String ano,
      Usuario usuario) {
    this.marca = marca;
    this.modelo = modelo;
    this.ano = ano;
    this.usuario = usuario;    
    String rodizio = ano.substring(3,4);
    System.out.println(rodizio);
    if (rodizio.equals("0") || rodizio.equals("1")) {
      this.diaRodizio = DayOfWeek.MONDAY;
    }
    if (rodizio.equals("2") || rodizio.equals("3")) {
      this.diaRodizio = DayOfWeek.TUESDAY;
    }
    if (rodizio.equals("4") || rodizio.equals("5") ) {
      System.out.println("Entrou no if");
      this.diaRodizio = DayOfWeek.WEDNESDAY;
    }
    if (rodizio.equals("6") || rodizio.equals("7")) {
      this.diaRodizio = DayOfWeek.THURSDAY;
    }
    if (rodizio.equals("8") || rodizio.equals("9")) {
      this.diaRodizio = DayOfWeek.FRIDAY;
    }
  }

  @Deprecated
  public Veiculo() {
  }

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

  public DayOfWeek getDiaRodizio() {
    return this.diaRodizio;
  }

  public boolean isRodizioAtivo() {
    
    DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
    System.out.print(dayOfWeek);
    if(this.diaRodizio.equals(dayOfWeek)){
      return true;
    } else {
      return false;
    }
    
  }

}
