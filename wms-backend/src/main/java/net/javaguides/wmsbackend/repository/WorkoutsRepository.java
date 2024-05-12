package net.javaguides.wmsbackend.repository;

import net.javaguides.wmsbackend.entity.Workouts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutsRepository extends JpaRepository<Workouts, Long> {

}
