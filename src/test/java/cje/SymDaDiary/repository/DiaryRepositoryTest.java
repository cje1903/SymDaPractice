package cje.SymDaDiary.repository;

import cje.SymDaDiary.constants.Emotion;
import cje.SymDaDiary.constants.Weather;
import cje.SymDaDiary.domain.Diary;
import cje.SymDaDiary.domain.Question;
import cje.SymDaDiary.domain.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DiaryRepositoryTest {

    @Autowired
    DiaryRepository diaryRepository;
    @Autowired
    QuestionRepository questionRepository;

    @Test
    void save() {
        Diary diary = new Diary();
        diary.setContent("오늘은 맛있는 빙수를 먹어서 기분이 좋은 날이다. 내일도 재밌는 하루였으면 좋겠다");
        diary.setEmotion(Emotion.JOY);
        diary.setWeather(Weather.SUNNY);
        diary.setCreated_at(LocalDate.now());

        Question question = questionRepository.findById(1L);
        diary.setQuestion(question);

        Diary saveDiary = diaryRepository.save(diary);
        Optional<Diary> findDiary = diaryRepository.findById(saveDiary.getDiary_id());
        Diary findDiary2 = findDiary.get();

        System.out.println(diary);
        System.out.println(findDiary2);
//        if (findDiary.isPresent()) {
//            Assertions.assertThat(saveDiary).isEqualTo(findDiary.get());
//        }
    }

    @Test
    void findById() {
    }

    @Test
    void findByMonth() {
    }

    @Test
    void deleteById() {
    }
}