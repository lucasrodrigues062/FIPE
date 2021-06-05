package br.com.codechallenge.veiculos.veiculos.cadastrousuario;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

  Optional<Usuario> findByEmail(String email);

  Optional<Usuario> findByCpf(String cpf);

  
}
