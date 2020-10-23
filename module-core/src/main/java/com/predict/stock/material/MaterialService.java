package com.predict.stock.material;

import com.predict.stock.Dto.material.MaterialRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MaterialService {
    private final MaterialRepository materialRepository;

    public void saveMaterial(MaterialRequestDto materialRequestDto){
            materialRepository.save(materialRequestDto.toEntity());
   }

}
