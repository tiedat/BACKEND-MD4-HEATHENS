package com.heathens.music.repository;

import com.heathens.music.model.Playlist;
import com.heathens.music.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface IPlaylistRepo extends JpaRepository<Playlist, Long> {
    List<Playlist> findAllByUser(Optional<User> user);

    List<Playlist> findTop10ByNameContains(String textSeach);
}
