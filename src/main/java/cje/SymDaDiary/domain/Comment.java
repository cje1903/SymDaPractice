package cje.SymDaDiary.domain;

import cje.SymDaDiary.constants.Emotion;
import cje.SymDaDiary.constants.Weather;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comment_id;    // 코멘트 pk

    private String comment;     // 코멘트

    private String music_url;   // 노래주소

    private Emotion emotion;    // 감정

    private Weather weather;    // 날씨

    @Builder
    public Comment(String comment, String music_url, Emotion emotion, Weather weather) {
        this.comment = comment;
        this.music_url = music_url;
        this.emotion = emotion;
        this.weather = weather;
    }
}