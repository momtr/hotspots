package com.hotspots.service;

import com.hotspots.dto.Location;
import com.hotspots.model.UserQuery;

import java.time.LocalDate;
import java.util.List;

public interface UserQueryService {

    void createQuery(UserQuery query);

    UserQuery createQuery(Location location);

    UserQuery findQueryById(long id);

    List<UserQuery> findUserQueriesByQueryDate(LocalDate query);

    List<UserQuery> findAllUserQueries();

}
