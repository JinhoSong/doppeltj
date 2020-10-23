package com.predict.stock.material;

import com.predict.stock.material.Material;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRepository extends JpaRepository<Material, Long> {

    Material findByFilePath(String filePath);
}
