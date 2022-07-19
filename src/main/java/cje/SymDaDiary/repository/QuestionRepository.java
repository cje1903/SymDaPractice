package cje.SymDaDiary.repository;

import cje.SymDaDiary.domain.Question;

import java.util.Optional;

public interface QuestionRepository {
    /*
    * 질문 저장
    * */
    Question save(Question question);

    /*
    * id로 찾기
    * */
    Question findById(long id);
}
