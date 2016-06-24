package com.james.services;

import com.james.entities.Anime;
import com.james.entities.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jamesyburr on 6/24/16.
 */
public interface AnimeRepository extends CrudRepository<Anime, Integer> {
    public Iterable<Anime> findByUser(User user);
}
