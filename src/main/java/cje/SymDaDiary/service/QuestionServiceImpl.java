package cje.SymDaDiary.service;

import cje.SymDaDiary.domain.Question;
import cje.SymDaDiary.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class QuestionServiceImpl implements QuestionService{

    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question findQuestion(Long question_id) {
        Optional<Question> questionById = questionRepository.findById(question_id);
        Question question = questionById.orElseThrow();
        return question;
    }
}
