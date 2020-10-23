package com.predict.stock.controller;

import com.predict.stock.Dto.material.MaterialRequestDto;
import com.predict.stock.material.MaterialService;
import com.predict.stock.s3.S3Service;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;

@Controller
@AllArgsConstructor
public class FileController {

    private final S3Service s3Service;
    private final MaterialService materialService;

    @GetMapping("/fileupload")
    public String fileUpLoad() {

        return "file/fileupload";
    }

    @PostMapping("/fileupload")
    public String execWrite(@Valid MaterialRequestDto materialRequestDto,  @Valid MultipartFile file) throws IOException{
        System.out.println(materialRequestDto);
        System.out.println(file);
        String filePath = s3Service.upload(file);
        materialRequestDto.setFilePath(filePath);

        materialService.saveMaterial(materialRequestDto);

        return "redirect:/fileupload";
    }
}
