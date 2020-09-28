package com.hotspots.service;

import com.hotspots.dto.Location;
import com.hotspots.model.UserQuery;
import com.hotspots.repository.UserQueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class UserQueryServiceImpl implements UserQueryService {

    @Autowired
    private UserQueryRepository userQueryRepository;

    @Override
    public void createQuery(UserQuery query) {
        query.setQueryDate(LocalDate.now());
        query.setQueryTime(LocalTime.now());
        userQueryRepository.save(query);
    }

    @Override
    public UserQuery createQuery(Location location) {
        UserQuery userQuery = UserQuery.builder()
                .latitude(location.getLatitude())
                .longitude(location.getLongitude())
                .build();
        this.createQuery(userQuery);
        return userQuery;
    }

    @Override
    public UserQuery findQueryById(long id) {
        return userQueryRepository.findUserQueryById(new Long(id)).get();
    }

    @Override
    public List<UserQuery> findUserQueriesByQueryDate(LocalDate date) {
        return userQueryRepository.findUserQueryByQueryDate(date);
    }

    @Override
    public List<UserQuery> findAllUserQueries() {
        return userQueryRepository.findAll();
    }
}
