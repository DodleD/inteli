package com.kh.boot.domain.dto;

import lombok.Getter;
import lombok.Setter;

public class BoardRequest {

    @Getter
    @Setter
    public static class CreateDTO{
        private String userId;
        private String contents;
        private String title;
        private String pwd;
    }
    @Getter
    @Setter
    public static class UpdateDTO{
        private String BoardId;
        private String userId;
        private String contents;
        private String title;
        private String pwd;
    }

}
