package com.riwi.beautySalon.infraestructure.services;

import com.riwi.beautySalon.utils.exceptions.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.riwi.beautySalon.api.dto.request.LoginReq;
import com.riwi.beautySalon.api.dto.request.RegisterReq;
import com.riwi.beautySalon.api.dto.response.AuthResp;
import com.riwi.beautySalon.domain.entities.User;
import com.riwi.beautySalon.domain.repositories.UserRepository;
import com.riwi.beautySalon.infraestructure.abstract_service.IAuthService;
import com.riwi.beautySalon.infraestructure.helpers.JwtService;
import com.riwi.beautySalon.utils.enums.Role;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthService implements IAuthService{

    // Inyeccion de dependencias 
    @Autowired
    private final UserRepository userRepository;

    // EL servicio inyecta a un component
    @Autowired
    private final JwtService jwtService;

    // Interfaz que nos permite jachar las contraseñas
    /*
     * Encriptacion 
     */
    @Autowired
    private final PasswordEncoder passwordEncoder;

    @Override
    public AuthResp login(LoginReq request) {
        return null;
    }

    @Override
    public AuthResp register(RegisterReq request) {

        /* Validar que el usuario no exista */
        User exist = this.findUser(request.getUserName());

        if (exist != null) {
            throw new BadRequestException("El usuario ya existe");
        }

        /* Construimos el nuevo usuario */

        User user = User.builder()
                        .userName(request.getUserName())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .role(Role.CLIENT)
                        .build();

       /*3. Guardar el nuevo usuario en la db*/
       user = this.userRepository.save(user);

       return AuthResp.builder()
                .message("Se registró exitosamente")
                .token(this.jwtService.getToken(user))
                .build();
    }

    // Metodos privados
    private User findUser(String username) {

        return this.userRepository.findByUserName(username)
                .orElse(null);
    }
}
