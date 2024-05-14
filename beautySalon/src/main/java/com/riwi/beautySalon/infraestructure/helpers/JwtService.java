package com.riwi.beautySalon.infraestructure.helpers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import com.riwi.beautySalon.domain.entities.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

// Lleva @Component aunque este en service
@Component
public class JwtService {

    // Crear una variable para guardar mi llave privada (FIRMA)
    // 1. Crear la firma o clave
    private static final String SECRET_KEY = "Y2xhdmUgc3VwZXIgc2VjcmV0YSBjbGF2ZSBzdXBlciBzZWNyZXRh";

    /* Método que se va a encargar de retornar la llave de forma encriptada */
    // 2. Metodo para encriptar la clave secreta, SecretKey
    public SecretKey getKey() {

        // COnvertir la llave a byte
        // Decoders 
        // Decodifica la clave y la conviete en byte
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);

        // Retornar nuestra llave cifrada
        // Para poder cifrar hmacShaKeyFor
        return Keys.hmacShaKeyFor(keyBytes);
    }

    /* Meétodo para construir nuestro Token */
    // 3. CONSTRUIR EL JWT
    // Payload mandamos informacion pero no poner informacion privada
    public String getToken(Map<String, Object> claims, User user) {

        // Jwts 
        return Jwts.builder()
                .claims(claims) // Agregamos el payload (cuerpo) del jwt
                .subject(user.getUsername()) // Agregamos de quien es el jwt
                .issuedAt(new Date(System.currentTimeMillis()))// Agregar cuando se creo el token
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24)) // Agregamos la fecha de expiración
                .signWith(this.getKey()) // Para que el servidor Firme el token con la llave de el
                .compact(); 
    }

    // 4. Metodo para obtener el jwt
    /* Método para retornar el token con los claims configurados */
    // Sobrescritura de metodo
    public String getToken(User user) {

        // Crear el map de claims- lo que va a llevar el cuerpo
        Map<String, Object> claims = new HashMap<>();

        // Llenar los claims
        claims.put("id", user.getId());
        claims.put("role", user.getRole().name());

        // NOmbre del metodo getToken
        return getToken(claims, user);
    }

    // Todo esto es para generar el JWT 
}