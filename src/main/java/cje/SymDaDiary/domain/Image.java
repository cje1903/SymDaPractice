package cje.SymDaDiary.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long image_id;  // 사진 pk

    private String image;   // 이미지 주소

    private LocalDate created_at;   // 생성 시간
    @PrePersist
    public void created_at(){
        this.created_at = LocalDate.now();
    }

    @OneToOne   // 일대일 단방향 관계
    @JoinColumn(name = "diary_id")
    private Diary diary;    // 일기 pk (FK)

}