package com.heathens.music.service;

public interface ICommentService<T> {
    ServiceResult findAll(Long id);
    ServiceResult findById(Long id);
    ServiceResult create(T object);
    ServiceResult update(T object);
    ServiceResult delete(Long id);
}
