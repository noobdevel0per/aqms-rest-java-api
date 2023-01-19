package com.aqms.app.rest.Repo;

import com.aqms.app.rest.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepo extends JpaRepository<User,Long> {
    //username, it will return the user of given username
    public User findByUsername(String username);
}
