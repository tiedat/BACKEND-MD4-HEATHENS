package com.heathens.music.repository;

import com.heathens.music.model.Playlist;
import com.heathens.music.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IPlaylistRepo extends CrudRepository<Playlist, Long> {
    List<Playlist> findAllByUser(Optional<User> user);

    List<Playlist> findTop10ByNameContains(String textSeach);
}
