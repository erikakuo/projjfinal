package acc.br.projetofinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import acc.br.projetofinal.model.LoginModel;

@Repository
public interface LoginRepository extends JpaRepository<LoginModel, Long> {
    LoginModel findByUsername(String username);

}