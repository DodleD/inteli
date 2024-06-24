package com.kh.boot.controller;

import com.kh.boot.domain.dto.BoardRequest;
import com.kh.boot.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController("/board")
@RequiredArgsConstructor
public class BootController {

//    @GetMapping("/dummy")
//    public String dummy() {
//        log.info("dummy성공");
//        return "ok";
//    }
//
//    @GetMapping("/Member")
//    public String getMember(@RequestParam(value = "memberKey", defaultValue = "111") String memberKey,
//                            @RequestParam(value = "age") int age){
//        log.info("memberKey  {}", memberKey);
//        log.info("age {}", age);
//        return "ok";
//    }

    private final BoardService boardService;


    //ResponseEntity : Http응답을 나타내는 클래스이다.
    @PostMapping
    public ResponseEntity<Boolean> create(BoardRequest.CreateDTO request) throws Exception{
        
        //Board객체를 생성하기위함
        // userId, pwd, title, contents

        boolean isCreated = boardService.create(request);
        
        return new ResponseEntity<>(isCreated, HttpStatus.OK);
    }

    @GetMapping
    public void getBoardList(){

    }

}
