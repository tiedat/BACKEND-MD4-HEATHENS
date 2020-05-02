package com.heathens.music.repository;

import com.heathens.music.model.CommentPlaylist;
import com.heathens.music.model.CommentSong;
import com.heathens.music.model.Playlist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ICommentPlaylistRepo extends CrudRepository<CommentPlaylist, Long> {
    List<CommentSong> findAllByPlaylist(Optional<Playlist> playlist);
}
