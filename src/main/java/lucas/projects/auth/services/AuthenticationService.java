package lucas.projects.auth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lucas.projects.auth.domain.user.AuthenticationDTO;
import lucas.projects.auth.domain.user.LoginResponseDTO;
import lucas.projects.auth.domain.user.RegisterDTO;
import lucas.projects.auth.domain.user.User;
import lucas.projects.auth.infra.security.TokenService;
import lucas.projects.auth.repositories.UserRepository;

@Service
public class AuthenticationService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    public LoginResponseDTO login(AuthenticationDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());
        return new LoginResponseDTO(token);
    }

    public boolean register(RegisterDTO data) {
        if(this.userRepository.findByLogin(data.login()) != null) return false;

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.login(), encryptedPassword, data.role());

        this.userRepository.save(newUser);
        return true;
    }
}
