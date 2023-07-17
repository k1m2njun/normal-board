package com.boardapplication.service;

import com.boardapplication.dto.BoardDto;
import com.boardapplication.repository.BoardRepository;
import com.core.entity.Board;
import com.core.entity.Status;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {
    private BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }

    @Transactional
    public List<BoardDto> getBoardList(){
        List<Board> boards = boardRepository.findAll();
        List<BoardDto> boardDtoList = new ArrayList<>();
        for(Board board : boards){
            if(board.getStatus().equals(Status.NORMAL)){
                BoardDto dto = BoardDto.builder()
                        .id(board.getId())
                        .userId(board.getId())
                        .title(board.getTitle())
                        .content(board.getContent())
                        .thumbnail(board.getThumbnail())
                        .status(board.getStatus())
                        .createdAt(board.getCreatedAt())
                        .updatedAt(board.getUpdatedAt())
                        .build();
                boardDtoList.add(dto);
            }
        }
        return boardDtoList;
    }
}