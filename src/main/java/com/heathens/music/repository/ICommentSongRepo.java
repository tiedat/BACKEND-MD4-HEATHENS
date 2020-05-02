package com.heathens.music.repository;

import com.heathens.music.model.CommentSong;
import com.heathens.music.model.Song;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ICommentSongRepo extends CrudRepository<CommentSong, Long> {
    List<CommentSong> findAllBySong(Optional<Song> song);

}
