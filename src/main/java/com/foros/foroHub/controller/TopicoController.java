package com.foros.foroHub.controller;

import com.foros.foroHub.topico.DatosDetalleTopico;
import com.foros.foroHub.topico.DatosRegistroTopico;
import com.foros.foroHub.topico.Topico;
import com.foros.foroHub.topico.TopicoRepository;
import com.foros.foroHub.usuario.Usuario;
import com.foros.foroHub.usuario.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topicos")

public class TopicoController {
    @Autowired
    private TopicoRepository repository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    @PostMapping
    public ResponseEntity<DatosDetalleTopico> registrar(
            @RequestBody @Valid DatosRegistroTopico datos,
            UriComponentsBuilder uriBuilder) {

        Usuario autor = usuarioRepository.findById(datos.autorId())
                .orElseThrow(() -> new EntityNotFoundException("Autor no encontrado"));

        Topico topico = repository.save(new Topico(datos, autor));

        DatosDetalleTopico respuesta = new DatosDetalleTopico(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getStatus(),
                topico.getAutor().getNombre(),
                topico.getCurso()
        );

        URI url = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(respuesta);
    }
}
