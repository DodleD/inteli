package com.kh.boot.service;



import com.kh.boot.domain.entity.Board;
import com.kh.boot.domain.dto.BoardRequest;
import com.kh.boot.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;

    @Override
    public Boolean create(BoardRequest.CreateDTO request) throws Exception{

        if(request==null || request.getUserId() == null || request.getPwd()== null){
            throw new RuntimeException("check value");
        }
        
        //Mybatis Mapper 사용해서 insert하기

        /*
            @Builder를 객체에 추가하면 빌더 클래스가 자동으로 생성되어 객체 생성을 보다 편리하게 할 수 있다.
            객체가 가질 필드들을 설정하는 메서드들을 체이닝 방식으로 연결하여 객체 생성하는 체인이다.
         */
    try {
        Board board = Board.builder()
                .title(request.getTitle())
                .pwd(request.getPwd())
                .contents(request.getContents())
                .userId(request.getUserId())
                .build();

        boardMapper.create(board);
    } catch (Exception e){
        e.printStackTrace();
        throw new RuntimeException("BoardCreateError");
    }


        return true;
    }
}
