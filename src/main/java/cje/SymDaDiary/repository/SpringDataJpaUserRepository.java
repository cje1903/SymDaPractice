package cje.SymDaDiary.repository;

import cje.SymDaDiary.domain.Question;
import cje.SymDaDiary.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJpaUserRepository extends JpaRepository<User, Long>, UserRepository{

}
