package com.aqms.app.rest.Repo;

import com.aqms.app.rest.Models.data;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface dataRepo extends JpaRepository<data, Long> {

}
