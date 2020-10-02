package com.predict.stock.controller;


import com.predict.stock.borad.Board;
import com.predict.stock.borad.BoardRepository;
import com.predict.stock.validator.BoradValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardRepository boardRepository;
    private final BoradValidator boradValidator;

    @GetMapping("/list")
    public String list(Model model){
        List<Board> boards = boardRepository.findAll();
        model.addAttribute("boards", boards);
        return "board/list";
    }

    @GetMapping("/form")
    public String form(Model model ,@RequestParam(required=false) Long id){
        if( id == null){
            model.addAttribute("board", new Board());

        } else {
            model.addAttribute("board",boardRepository.findById(id));
        }
        return "board/form";
    }

    @PostMapping("/form")
    public String boardSave(@Valid Board board, BindingResult bindingResult){
        boradValidator.validate(board, bindingResult);
        if(bindingResult.hasErrors()){
            return "board/form";
        }

        boardRepository.save(board);
        return "redirect:/board/list";
    }

    @DeleteMapping("/form")
    public String boardDelete(@ModelAttribute long id){
        boardRepository.deleteById(id);
        return "redirect:/board/list";
    }
}
