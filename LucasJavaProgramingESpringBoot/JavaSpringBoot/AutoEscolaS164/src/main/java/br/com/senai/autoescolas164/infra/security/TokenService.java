package br.com.senai.autoescolas164.infra.security;

import br.com.senai.autoescolas164.domain.usuario.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;
    private  final String ISSUER = "AutoEscola164";
    public String genToken(Usuario usuario) {
        try    {
        Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                .withIssuer(ISSUER)
                .withSubject(usuario.getLogin())
                .withExpiresAt(dataExpiracao())
                .sign(algorithm);
        } catch(JWTCreationException ex)

        {
           throw new RuntimeException("Erro ao gerar o token",ex); // Invalid Signing configuration / Couldn't convert Claims.
        }
    }

    private Instant dataExpiracao() {
        return LocalDateTime.now().plusMinutes(30).toInstant(ZoneOffset.of("-03:00"));
    }
    public String getSubject (String tokenJTW){

        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer(ISSUER)
                    .build()
                    .verify(tokenJTW)
                    .getSubject();

        } catch (JWTVerificationException ex){
            throw new RuntimeException("Token JWT invalido ou expirado",ex);
        }
    }

}
