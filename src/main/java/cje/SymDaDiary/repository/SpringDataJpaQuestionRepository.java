package cje.SymDaDiary.repository;

import cje.SymDaDiary.domain.Diary;
import cje.SymDaDiary.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJpaQuestionRepository extends JpaRepository<Question, Long>, QuestionRepository{

}
