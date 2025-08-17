package com.foros.foroHub.controller;

import com.foros.foroHub.infra.security.DatosToken;
import com.foros.foroHub.infra.security.TokenService;
import com.foros.foroHub.usuario.DatosAutenticacion;
import com.foros.foroHub.usuario.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {


    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager manager;

    @PostMapping
    public ResponseEntity iniciarSesion(@RequestBody @Valid DatosAutenticacion datos){
        var authenticationToken = new UsernamePasswordAuthenticationToken(datos.login(),datos.contrasena());
        var authentication = manager.authenticate(authenticationToken);

        var tokenJWT = tokenService.generarToken((Usuario)authentication.getPrincipal());
        return ResponseEntity.ok(new DatosToken(tokenJWT));

    }
}
