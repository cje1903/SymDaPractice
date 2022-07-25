package cje.SymDaDiary.repository;

import cje.SymDaDiary.domain.User;

import java.util.Optional;

public interface UserRepository {
    /*
    * id로 찾기
    * */
    Optional<User> findById(Long id);   // Optional 꼭 달아야지 SpringDataJpa에서 자동 오버라이딩 가능 -> 이유.. Long 때문
}
