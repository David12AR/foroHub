package com.foros.foroHub.topico;

import com.foros.foroHub.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

    boolean existsByTitulo(String titulo);
    boolean existsByMensaje(String mensaje);

}
