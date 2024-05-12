package net.javaguides.wmsbackend.mapper;

import net.javaguides.wmsbackend.dto.WorkoutsDto;
import net.javaguides.wmsbackend.entity.Workouts;

public class WorkoutsMapper {
    public static WorkoutsDto mapToWorkoutsDto(Workouts workouts){
        return new WorkoutsDto(
                workouts.getId(),
                workouts.getCatergory(),
                workouts.getDescription(),
                workouts.getType(),
                workouts.getWorkout()
        );
    }

    public static Workouts mapToWorkouts(WorkoutsDto workoutsDto){
        return new Workouts(
                workoutsDto.getId(),
                workoutsDto.getCatergory(),
                workoutsDto.getDescription(),
                workoutsDto.getType(),
                workoutsDto.getWorkout()
        );
    }
}
