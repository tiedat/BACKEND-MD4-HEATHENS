package com.heathens.music.repository;

import com.heathens.music.model.Song;
import com.heathens.music.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISongRepo extends JpaRepository<Song, Long> {

    List<Song> findAllByUser(User user);

    List<Song> findTop10ByNameContains(String textSeach);
}
