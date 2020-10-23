package com.predict.stock.material;

import com.predict.stock.borad.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Material {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String filePath;

    @ManyToOne
    @JoinColumn(name="board_id")
    private Board board;

    @Builder
    public Material(Long id, String title, String filePath){
        this.id = id;
        this.title = title;
        this.filePath = filePath;
    }
}
