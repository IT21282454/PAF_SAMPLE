package net.javaguides.wmsbackend.service;

import net.javaguides.wmsbackend.dto.WorkoutsDto;

import java.util.List;

public interface WorkoutsService {
    WorkoutsDto createWorkouts(WorkoutsDto workoutsDto);
    WorkoutsDto getWorkoutsById(Long workoutsId);
    List<WorkoutsDto> getAllWorkouts();
    WorkoutsDto updateWorkouts(Long workoutsId, WorkoutsDto updatedWorkouts);
    void deleteWorkouts(Long workoutsId);
}
