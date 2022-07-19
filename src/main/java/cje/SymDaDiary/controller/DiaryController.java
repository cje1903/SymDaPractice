package cje.SymDaDiary.controller;

import cje.SymDaDiary.constants.Emotion;
import cje.SymDaDiary.domain.Diary;
import cje.SymDaDiary.domain.DiaryDeleteResultVO;
import cje.SymDaDiary.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class DiaryController {

    // 의존성 주입 (생성자가 하나인 경우 생략 가능)
    private final DiaryService diaryService;

    @Autowired
    public DiaryController(DiaryService diaryService) {
        this.diaryService = diaryService;
    }

    /*
    * 일기 작성 - POST
    * */
    @ResponseBody   // Long 타입을 리턴하고 싶은 경우 붙여야 함 (Long - 객체)
    @PostMapping("/diary/new")
    public Long saveDiary(@RequestBody Diary diary){
        System.out.println("DiaryController.saveDiary");

        Long diaryId = diaryService.keepDiary(diary);
        return diaryId;
    }

    /*
    * 일기 삭제 - DELETE
    * */
    @ResponseBody
    @DeleteMapping("/diary/{diaryId}")
    public DiaryDeleteResultVO deleteDiary(@PathVariable Long diaryId){
        diaryService.deleteDiary(diaryId);
        DiaryDeleteResultVO resultVO = new DiaryDeleteResultVO(1);
        return resultVO;
    }

    /*
    * id로 일기 조회 - GET
    * */
    @ResponseBody
    @GetMapping("/diary/{diaryId}")
    public Optional<Diary> getDiary(@PathVariable Long diaryId){
        Optional<Diary> diary = diaryService.findDiary(diaryId);
        return diary;
    }

    /*
    * 생성 날짜로 일기 조회 - GET
    * */
//    @ResponseBody
//    @GetMapping("/diary/{localDate}")
//    public Optional<Diary> getDiaryDate(@PathVariable LocalDate localDate){
    //       Optional<Diary> diaryByDate = diaryService.findDiaryByDate(localDate);
    //   return diaryByDate;
    //}


    /*
    * 월별 일기 조회 - GET
    * */
    @ResponseBody
    @GetMapping("/diary/monthly/{month}")
    public List<Diary> getMonthlyDiary(@PathVariable String month){
        List<Diary> monthlyDiary = diaryService.findMonthlyDiary(month);
        return monthlyDiary;
    }

    /*
    * 월별 감정 조회 - GET
    * */
    @ResponseBody
    @GetMapping("/diary/monthly/{month}/emotion")
    public Map<Long, Emotion> getMonthlyEmotion(@PathVariable String month){
        Map<Long, Emotion> monthlyEmotion = diaryService.findMonthlyEmotion(month);
        return monthlyEmotion;
    }

    /*
    * 식물 상태 조회 - GET
    * */
    @ResponseBody
    @GetMapping("/diary/monthly/{month}/plant")
    public int getMonthlyPlant(@PathVariable String month){
        int plant = diaryService.cntMonthlyPlant(month);
        return plant;
    }

}