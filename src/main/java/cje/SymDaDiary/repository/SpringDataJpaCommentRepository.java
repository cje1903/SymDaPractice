package cje.SymDaDiary.repository;

import cje.SymDaDiary.constants.Emotion;
import cje.SymDaDiary.constants.Weather;
import cje.SymDaDiary.domain.Comment;
import cje.SymDaDiary.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaCommentRepository extends JpaRepository<Comment, Long>, CommentRepository{
    @Override
    Optional<Comment> findByEmotionAndWeather(Emotion emotion, Weather weather);
}
