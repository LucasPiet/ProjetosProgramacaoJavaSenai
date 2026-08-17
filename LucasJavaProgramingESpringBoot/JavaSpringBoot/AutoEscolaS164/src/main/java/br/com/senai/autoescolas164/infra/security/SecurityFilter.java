package br.com.senai.autoescolas164.infra.security;

import br.com.senai.autoescolas164.domain.usuario.UsuarioRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Component
public class SecurityFilter  extends OncePerRequestFilter {
    @Autowired
    private TokenService tokenService;
    @Autowired
    private UsuarioRepository repository;
    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {
        String tokenJWT = recuperaToken(request);

        if(tokenJWT !=null){
            String subjetc = tokenService.getSubject (tokenJWT);
            UserDetails usuario = repository.findByLogin(subjetc);
            var authenticationToken = new UsernamePasswordAuthenticationToken(
                    usuario,
                    null,
                    usuario.getAuthorities()
            );
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }

        filterChain.doFilter (request, response);
    }

    private String recuperaToken(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null){
            return authHeader.replace("Bearer ","");
        }
        return null;
    }
}
