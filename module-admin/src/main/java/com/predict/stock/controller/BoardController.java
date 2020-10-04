package com.predict.stock.controller;


import com.predict.stock.borad.Board;
import com.predict.stock.borad.BoardRepository;
import com.predict.stock.validator.BoardValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    private final BoardValidator boardValidator;

    @GetMapping("/list")
    public String list(Model model, @PageableDefault(size=2) Pageable pageable, @RequestParam(required = false, defaultValue = "") String searchText){
        //Page<Board> boards = boardRepository.findAll(pageable); // 전체 찾기
        Page<Board> boards = boardRepository.findByTitleOrContentContaining(searchText,searchText,pageable);
        // 타이틀과 컨텐츠에 serachText가 포함된걸 모두 가져온다.

        // 페이징을 위한 코드
        int startPage = Math.max(1,boards.getPageable().getPageNumber()-4);
        int endPage = Math.min(boards.getTotalPages(),boards.getPageable().getPageNumber()+4);
        int pageNumber = boards.getPageable().getPageNumber();
        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        // 페이징 끝

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
        boardValidator.validate(board, bindingResult);
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
