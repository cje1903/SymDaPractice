package cje.SymDaDiary.service;

import cje.SymDaDiary.constants.Emotion;
import cje.SymDaDiary.constants.Weather;
import cje.SymDaDiary.domain.Diary;
import cje.SymDaDiary.domain.Question;
import cje.SymDaDiary.domain.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DiaryServiceImplTest {

    @Autowired
    DiaryService diaryService;

    /*
    * 일기 작성 테스트
    * */
    @Test
    void keepDiary() {
        //given
        Diary diary = new Diary();
        diary.setContent("오늘은 맛있는 빙수를 먹어서 기분이 좋은 날이다. 내일도 재밌는 하루였으면 좋겠다");
        diary.setEmotion(Emotion.JOY);
        diary.setWeather(Weather.SUNNY);



        User user = new User();
        diary.setUser(user);

        //when
        Long diaryId = diaryService.keepDiary(diary);
        Optional<Diary> findDiary = diaryService.findDiary(diaryId);

        //then
        Assertions.assertThat(diary).isEqualTo(findDiary);
    }

    @Test
    void deleteDiary() {
    }

    @Test
    void findDiary() {
    }

    @Test
    void findMonthlyDiary() {
    }

    @Test
    void findMonthlyEmotion() {
    }

    @Test
    void cntMonthlyPlant() {
    }
}