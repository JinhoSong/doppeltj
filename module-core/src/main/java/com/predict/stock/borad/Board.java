package com.predict.stock.borad;

import com.predict.stock.material.Material;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min=1,max=30, message="제목은 1글자 이상 30글자 이하입니다.")
    private String title;

    @NotNull
    @Size(min=1,message="내용을 입력해주세요")
    private String content;

    @OneToMany
    @OrderBy("id ASC")
    private List<Material> materials = new ArrayList<>();
}
