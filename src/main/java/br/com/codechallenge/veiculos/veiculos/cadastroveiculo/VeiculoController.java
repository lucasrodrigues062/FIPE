package br.com.codechallenge.veiculos.veiculos.cadastroveiculo;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/veiculo")
public class VeiculoController {

 @Autowired
  private ConsultaFipe  consultaFipe;

  @PostMapping
  public ResponseEntity<?> cadastra(@RequestBody @Valid VeiculoDto request){

    request.pegarValor(consultaFipe);

    return ResponseEntity.ok().body(request);
  }

  
}
