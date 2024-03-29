package cje.SymDaDiary.domain;

import cje.SymDaDiary.constants.Emotion;
import cje.SymDaDiary.constants.Weather;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class DiaryCreateRequestDto{
    private String content;
    private Weather weather;
    private Emotion emotion;
    private Long userId;
    private Long questionId;

    // RequestDto -> Entity
    public Diary toEntity(User user, Question question ){   // content, weather, emotion 값은 이미 있음
        // 나머지 user, question, comment 값만 서비스층에서 Id로 find해서 toEntity 호출하기
        return Diary.builder()
                .content(content)
                .weather(weather)
                .emotion(emotion)
                .user(user)
                .question(question).build();
    }
}
