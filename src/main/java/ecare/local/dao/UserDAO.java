package ecare.local.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ecare.local.model.User;

public interface UserDAO extends JpaRepository<User, Long> {
    User findByLogin(String Login);
}
