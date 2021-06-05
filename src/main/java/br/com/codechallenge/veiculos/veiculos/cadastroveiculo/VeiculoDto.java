package br.com.codechallenge.veiculos.veiculos.cadastroveiculo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.codechallenge.veiculos.veiculos.cadastrousuario.Usuario;
import br.com.codechallenge.veiculos.veiculos.cadastrousuario.UsuarioRepository;
import javassist.NotFoundException;

public class VeiculoDto {
  @NotNull @NotBlank
  private String marca;
  @NotNull @NotBlank
  private String modelo;
  @NotNull @NotBlank
  private String ano;
  
  private String valor;

  private Long idUsuario;

  public VeiculoDto(Veiculo veiculo){
    this.ano = veiculo.getAno();
    this.idUsuario = veiculo.getUsuario().getId();
    this.modelo = veiculo.getModelo();
    this.marca = veiculo.getMarca();
  }

  public Veiculo toModel(UsuarioRepository repository) throws NotFoundException {
    Optional<Usuario> optional = repository.findById(idUsuario);
    if(!optional.isPresent()){
      throw new NotFoundException("nao existe usuario cadastrado");
    }
    return new Veiculo(marca,modelo,ano,valor,optional.get());
  }

  

  public VeiculoDto(String marca, String modelo, String ano, Long idUsuario) {
    this.marca = marca;
    this.modelo = modelo;
    this.ano = ano;
    this.idUsuario = idUsuario;
  }

  @Deprecated
  public VeiculoDto(){}

  public String getMarca() {
    return this.marca;
  }

  public String getModelo() {
    return this.modelo;
  }

  public String getAno() {
    return this.ano;
  }

  public Long getIdUsuario() {
    return this.idUsuario;
  }

  public String getValor() {
    return this.valor;
  }


  @Override
  public String toString() {
    return "{" +
      " marca='" + getMarca() + "'" +
      ", modelo='" + getModelo() + "'" +
      ", ano='" + getAno() + "'" +
      ", idUsuario='" + getIdUsuario() + "'" +
      "}";
  }

  public void pegarValor(ConsultaFipe consultaFipe) {
    String codigoMarca = null;
    String codigoModelo = null;
    String codigoAno = null;
    //Pegando Marca
    List<FipeDados> fipe = consultaFipe.consultaMarcasCarros();
    for(int i =0; i < fipe.size(); i++){
      if(fipe.get(i).getNome().equals(this.getMarca())){
        codigoMarca = fipe.get(i).getCodigo();
      }
    }
    FipeModelo modelo = consultaFipe.consultaModelosCarros(codigoMarca);
    for(int i =0; i < modelo.getModelos().size(); i++){
      if(modelo.getModelos().get(i).getNome().equals(this.getModelo())){
        codigoModelo = modelo.getModelos().get(i).getCodigo();
      }
    }

    List<FipeDados> fipeAno = consultaFipe.consultaAnosCarros(codigoMarca, codigoModelo);
    for(int i =0; i < fipeAno.size(); i++){
      if(fipeAno.get(i).getNome().equals(this.getAno())){
        codigoAno = fipeAno.get(i).getCodigo();
      }
    }

    FipeVeiculo veiculo = consultaFipe.consultaValorCarros(codigoMarca, codigoModelo, codigoAno);
    this.valor = veiculo.getValor();

  }

}
