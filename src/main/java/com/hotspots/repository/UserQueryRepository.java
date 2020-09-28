package com.hotspots.repository;

import com.hotspots.model.UserQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserQueryRepository extends JpaRepository<UserQuery, Long> {

    List<UserQuery> findAll();

    Optional<UserQuery> findUserQueryById(Long id);

    List<UserQuery> findUserQueryByQueryDate(LocalDate queryDate);

}
