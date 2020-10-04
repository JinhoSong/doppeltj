package com.predict.stock.controller;

import com.predict.stock.borad.Board;
import com.predict.stock.borad.BoardRepository;
import com.predict.stock.validator.BoardValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board")
public class BoardApiController {

    private final BoardRepository boardRepository;
    private final BoardValidator boardValidator;

    @GetMapping("/list")
    public List<Board> list(){
        return boardRepository.findAll();
    }

    @GetMapping("/list/{id}")
    public Board boardFindById(@PathVariable long id){
        return boardRepository.findById(id).orElse(null);
    }

    @PostMapping("/list")
    public Board createBoard(@RequestBody Board board){
        return boardRepository.save(board);
    }

    @PutMapping("/list/{id}")
    public Board createBoard(@RequestBody Board board, @PathVariable long id){
        return boardRepository.save(board);
    }


    @DeleteMapping("/list/{id}")
    public long boardDelete(@PathVariable long id){
        boardRepository.deleteById(id);
        return id;
    }
}
