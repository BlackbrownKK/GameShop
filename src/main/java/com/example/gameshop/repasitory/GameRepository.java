package com.example.gameshop.repasitory;

import com.example.gameshop.model.Game;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
//@RepositoryRestResource(collectionResourceRel="games", path ="games")
public interface GameRepository extends CrudRepository<Game, Integer>{
    List<Game> findAll();
}
