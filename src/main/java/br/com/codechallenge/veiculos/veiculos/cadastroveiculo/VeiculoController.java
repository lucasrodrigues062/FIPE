package br.com.codechallenge.veiculos.veiculos.cadastroveiculo;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.codechallenge.veiculos.veiculos.cadastrousuario.Usuario;
import br.com.codechallenge.veiculos.veiculos.cadastrousuario.UsuarioRepository;


@RestController
@RequestMapping("/api/veiculo")
public class VeiculoController {

   @Autowired
  private ConsultaFipe  consultaFipe;
  @Autowired
  private VeiculoRepository veiculoRepository;
  @Autowired
  private UsuarioRepository usuarioRepository;

  @PostMapping
  public ResponseEntity<?> cadastra(@RequestBody @Valid VeiculoDto request, UriComponentsBuilder builder){

    Optional<Usuario> optional = usuarioRepository.findById(request.getIdUsuario());
    if(!optional.isPresent()){
      return ResponseEntity.badRequest().body("Usuario nao existe");
    }

    request.pegarValor(consultaFipe);
    
    Veiculo veiculo = veiculoRepository.save(request.toModel(optional.get()));

    URI uri = builder.path("/api/veiculo/{id}").buildAndExpand(veiculo.getId()).toUri();

    return ResponseEntity.created(uri).body(new VeiculoDto(veiculo));
  }

  
}
