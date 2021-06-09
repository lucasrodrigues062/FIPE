package br.com.codechallenge.veiculos.veiculos.cadastroveiculo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.codechallenge.veiculos.veiculos.cadastrousuario.Usuario;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

  List<Veiculo> findByUsuario(Usuario usuario);
  
}
