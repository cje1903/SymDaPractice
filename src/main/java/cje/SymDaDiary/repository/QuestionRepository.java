package cje.SymDaDiary.repository;

import cje.SymDaDiary.domain.Question;

import java.util.Optional;

public interface QuestionRepository {
    /*
    * id로 찾기
    * */
    Optional<Question> findById(Long id);
}
