package com.jsw.jhse.data.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsw.jhse.data.jpa.domain.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {

}
