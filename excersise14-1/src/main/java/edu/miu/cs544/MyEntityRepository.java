package edu.miu.cs544;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntityRepository extends JpaRepository<Movie, Integer>{

}
