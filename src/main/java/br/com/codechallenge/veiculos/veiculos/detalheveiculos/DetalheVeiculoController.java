package br.com.codechallenge.veiculos.veiculos.detalheveiculos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.codechallenge.veiculos.veiculos.cadastrousuario.Usuario;
import br.com.codechallenge.veiculos.veiculos.cadastrousuario.UsuarioRepository;
import br.com.codechallenge.veiculos.veiculos.cadastroveiculo.Veiculo;
import br.com.codechallenge.veiculos.veiculos.cadastroveiculo.VeiculoRepository;

@RestController
@RequestMapping("/api/detalheusuario")
public class DetalheVeiculoController {
  
  @Autowired
  private UsuarioRepository usuarioRepository;

  @GetMapping("/{idUsuario}")
  public ResponseEntity<?> detalhaUsuario(@PathVariable(name = "idUsuario") Long idUsuario){
    
    Optional<Usuario> optional = usuarioRepository.findById(idUsuario);
    if(!optional.isPresent()){
      return ResponseEntity.notFound().build();
    }
    Usuario usuario = optional.get();    
    
    
    return ResponseEntity.ok().body(new ConsultaVeiculoRequest(usuario));


  }

}
