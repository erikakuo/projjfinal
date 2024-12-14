package acc.br.projetofinal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acc.br.projetofinal.model.LoginModel;
import acc.br.projetofinal.repository.LoginRepository;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    public boolean validateLogin(String username, String password) {
        LoginModel user = loginRepository.findByUsername(username);
        if (user != null && user.getSenhaUsuario().equals(password)) {
            return true;
        }
        return false;
    }
}