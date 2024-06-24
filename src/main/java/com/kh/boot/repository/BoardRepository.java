package com.kh.boot.repository;

import com.kh.boot.domain.entity.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@Service
@RequiredArgsConstructor
public interface BoardRepository extends JpaRepository<Board, String> {
}
