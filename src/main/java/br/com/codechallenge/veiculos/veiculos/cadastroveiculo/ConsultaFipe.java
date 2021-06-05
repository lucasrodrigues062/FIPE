package br.com.codechallenge.veiculos.veiculos.cadastroveiculo;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "fipe", url = "https://parallelum.com.br/fipe/api/v1")
public interface ConsultaFipe {
  
  @RequestMapping(value="/carros/marcas", method=RequestMethod.GET)
  List<FipeDados> consultaMarcasCarros();

  @RequestMapping(value="/carros/marcas/{codigo}/modelos", method=RequestMethod.GET)
  FipeModelo consultaModelosCarros(@PathVariable(name="codigo") String codigoMarca);

  @RequestMapping(value="/carros/marcas/{codigoMarca}/modelos/{codigoModelo}/anos", method=RequestMethod.GET)
  List<FipeDados> consultaAnosCarros(@PathVariable(name="codigoMarca") String codigoMarca, @PathVariable(name="codigoModelo")String codigoModelo);

  @RequestMapping(value="/carros/marcas/{codigoMarca}/modelos/{codigoModelo}/anos/{codigoAno}", method=RequestMethod.GET)
  FipeVeiculo consultaValorCarros(@PathVariable(name="codigoMarca") String codigoMarca, @PathVariable(name="codigoModelo") String codigoModelo, @PathVariable(name = "codigoAno") String codigoAno );

  // FipeDados consultaMarcasMotos(String marca);
  // FipeDados consultaMarcasCaminhao(String marca);

}
