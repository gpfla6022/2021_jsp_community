package com.yhr.exam.exam2.service;

import com.yhr.exam.exam2.container.Container;
import com.yhr.exam.exam2.dto.Board;
import com.yhr.exam.exam2.repository.BoardRepository;

public class BoardService {
	private BoardRepository boardRepository;
	
	public BoardService() {
		boardRepository = Container.boardRepository;
	}

	public Board getBoardById(int id) {
		return boardRepository.getBoardById(id);
	}
}