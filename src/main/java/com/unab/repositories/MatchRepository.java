package com.unab.repositories;

import com.unab.models.MatchGame;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<MatchGame, Long> {
}
