package cje.SymDaDiary.service;

import cje.SymDaDiary.constants.Emotion;
import cje.SymDaDiary.domain.Diary;
import cje.SymDaDiary.repository.DiaryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.*;

@Service
@Transactional
public class DiaryServiceImpl implements DiaryService{

    // 의존성 주입
    private final DiaryRepository diaryRepository;

    public DiaryServiceImpl(DiaryRepository diaryRepository) {
        this.diaryRepository = diaryRepository;
    }

    @Override @Transactional
    public Long keepDiary(Diary diary) {
        Diary savedDiary = diaryRepository.save(diary);
        return savedDiary.getDiary_id();
    }

    @Override @Transactional
    public void deleteDiary(Long diary_id) {
        diaryRepository.deleteById(diary_id);
    }

    @Override @Transactional
    public Optional<Diary> findDiary(Long diary_id) {
        Optional<Diary> find_diary = diaryRepository.findById(diary_id);
        return find_diary;
    }

    //@Override
   // public Optional<Diary> findDiaryByDate(LocalDate localDate) {
   //     Optional<Diary> byCreated_at = diaryRepository.findByCreatedAt(localDate);
  //      return byCreated_at;
  //  }

    @Override @Transactional
    public List<Diary> findMonthlyDiary(String month) {
        List<Diary> diary_byMonth = diaryRepository.findByMonth(month);
        return diary_byMonth;
    }

    @Override @Transactional
    public Map<Long, Emotion> findMonthlyEmotion(String month) {
        List<Diary> diary_byMonth = diaryRepository.findByMonth(month);
        //List<Emotion> emotions_byMonth = new ArrayList<Emotion>();
        Map<Long, Emotion> emotions_byMonth = new HashMap<>();

        for (Diary diary: diary_byMonth) {
            //emotions_byMonth.add(diary.getEmotion());
            emotions_byMonth.put(diary.getDiary_id(), diary.getEmotion());
        }

        return emotions_byMonth;
    }

    @Override @Transactional
    public int cntMonthlyPlant(String month) {
        List<Diary> diary_byMonth = diaryRepository.findByMonth(month);
        int plant = diary_byMonth.size();
        return plant;
    }
}
