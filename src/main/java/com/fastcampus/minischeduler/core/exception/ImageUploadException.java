package com.fastcampus.minischeduler.core.exception;

public class ImageUploadException extends RuntimeException{
    public ImageUploadException() {
        super("이미지 업로드 오류가 발생했습니다.");
    }

}