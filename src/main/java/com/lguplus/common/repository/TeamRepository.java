package com.lguplus.common.repository;
import com.lguplus.common.domain.Entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team,Long>{

    List<Team> findByTeamName(String name);

}
