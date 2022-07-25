package cje.SymDaDiary.repository;

import cje.SymDaDiary.constants.Emotion;
import cje.SymDaDiary.constants.Weather;
import cje.SymDaDiary.domain.Comment;
import cje.SymDaDiary.domain.Question;

import java.util.Optional;

public interface CommentRepository {
    /*
    * emotion & weather 로 찾기
    * */
    Optional<Comment> findByEmotionAndWeather(Emotion emotion, Weather weather);
}
