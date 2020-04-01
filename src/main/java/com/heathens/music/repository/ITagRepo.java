package com.heathens.music.repository;

import com.heathens.music.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ITagRepo extends JpaRepository<Tag, Long> {
    Optional<Tag> findByNameTag(String textSearch);
}
