package com.kh.boot.domain.entity;

//ORM : 어플리케이션의 객체를 RDB 테이블에 자동으로 영속성을 갖게 해주는 것
//JPA : java에서 ORM을 위한 표준 인터페이스 및 규약을 정의한 api다
//Hibernate : Java 언어로 작성된 객체 관계 매핑(Object0Relational Mapping) 프레임 워크
// sql 쿼리를 직접 작성하지 않고도 데이터베이스 연산을 수행할 수 있도록 도와준다


//@Data : getter, setter, toSring, equals, hashCode를 포괄한다

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Table(name= "BOARD")
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
@Builder

public class Board {
    
    @Id // 엔티티의 기본 키 (Primary Key)임을 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키가 자동으로 증가하는 방식을 사용한다
    
    @Column(unique = true)
    private Long boardId;

    @Column(nullable = false, length = 100)
    private String title;
    
    @Column(columnDefinition = "TEXT") //해당 컬럼은 text타입이다, 일반적으로 생성시 타입은 varchar 255가 된다
    private String contents;

    @Column(length = 30)
    private String userId;

    @Column(nullable = true, length = 255)
    private String fileName;

    @Column(nullable = false, length = 100)
    private String pwd;

    @CreationTimestamp //엔티티가 처음으로 생성될 때 타임스탬프를 자동으로 설정
    @Column
    private LocalDateTime createAt;

    @UpdateTimestamp // 엔티티가 업데이트 될 때 마다 타임스탬프를 자동으로 갱신
    @Column
    private LocalDateTime updateAt;

//    private Board(){}

//    public static Builder builder(){
//        return new Builder();
//    }
//
//    public static class Builder{
//        private Board board = new BoarD();
//
//        public Builder setBoardPwd(String pwd){
//            this.board.setPwd(pwd);
//            return this;
//        }
//
//        public Board build(){
//            return board;
//        }
//    }
}
