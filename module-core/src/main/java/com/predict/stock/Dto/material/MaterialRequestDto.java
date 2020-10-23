package com.predict.stock.Dto.material;

import com.predict.stock.material.Material;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MaterialRequestDto {
    private Long id;
    private String title;
    private String filePath;

    public Material toEntity(){
        Material material = Material.builder()
                .id(id)
                .title(title)
                .filePath(filePath)
                .build();
        return material;
    }

    @Builder
    public MaterialRequestDto(Long id, String title, String filePath){
        this.id = id;
        this.title = title;
        this.filePath = filePath;
    }

}
