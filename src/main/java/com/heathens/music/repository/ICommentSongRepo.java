package com.heathens.music.repository;

import com.heathens.music.model.CommentSong;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommentSongRepo extends CrudRepository<CommentSong, Long> {
}
