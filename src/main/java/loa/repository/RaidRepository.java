package loa.repository;

import loa.entity.Raid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface RaidRepository extends JpaRepository<Raid, Long> {
}