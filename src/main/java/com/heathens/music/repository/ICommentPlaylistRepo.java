package com.heathens.music.repository;

import com.heathens.music.model.CommentPlaylist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommentPlaylistRepo extends CrudRepository<CommentPlaylist, Long> {
}
