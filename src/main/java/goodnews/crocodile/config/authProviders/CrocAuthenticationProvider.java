package goodnews.crocodile.config.authProviders;

import goodnews.crocodile.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CrocAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserService service;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        //Заменить userName на login
        String userName = authentication.getName();
        String password = authentication.getCredentials().toString();
        if(service.isUserExists(userName, password)){
            return new UsernamePasswordAuthenticationToken(userName, password, new ArrayList<>());
        }
        else return null;

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
