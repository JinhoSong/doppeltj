package com.predict.stock.borad;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    Page<Board> findByTitleOrContentContaining(String title,String content, Pageable pageable); // Containg으로 like 효과를 가져온다.
}
