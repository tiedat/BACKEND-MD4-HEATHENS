package com.heathens.music.repository;

import com.heathens.music.model.Song;
import com.heathens.music.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ISongRepo extends JpaRepository<Song, Long> {

    List<Song> findAllByUser(Optional<User> user);

    List<Song> findTop10ByNameContains(String textSeach);

    @Query(value="select * from song where number_of_plays > 0 order by number_of_plays desc limit 20", nativeQuery = true)
    List<Song> findTop20Song();
}
