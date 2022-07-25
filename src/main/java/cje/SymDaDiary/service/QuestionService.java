package cje.SymDaDiary.service;

import cje.SymDaDiary.domain.Question;

public interface QuestionService {
    /*
     * 오늘의 질문 조회
     * */
    public Question findQuestion(Long question_id);
}
