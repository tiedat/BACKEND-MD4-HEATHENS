package com.heathens.music.service;

import lombok.Data;

@Data
public class ServiceResult {
    private StatusService status = StatusService.SUCCESS;
    private String message;
    private Object data;
}
