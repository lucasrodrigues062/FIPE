package br.com.codechallenge.veiculos.veiculos.cadastrousuario;

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

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

  @Autowired
  private UsuarioRepository repository;

  public UsuarioController(UsuarioRepository repository){
    this.repository = repository;

  }

  @PostMapping
  public ResponseEntity<?> cadastra(@RequestBody @Valid UsuarioDto request, UriComponentsBuilder builder){

    Optional<Usuario> optionalEmail = repository.findByEmail(request.getEmail());
    Optional<Usuario> optionalCpf = repository.findByCpf(request.getCpf());

    if(optionalEmail.isPresent() || optionalCpf.isPresent()){
      String body = "Não é permitido cadastro de email ou cpf duplicado";
      return ResponseEntity.badRequest().body(body);
    }

    Usuario usuario = repository.save(request.toModel());

    URI uri = builder.path("/api/usuario/{id}").buildAndExpand(usuario.getId()).toUri();

    return ResponseEntity.created(uri).body(new UsuarioDto(usuario));
    
  }
  
}
