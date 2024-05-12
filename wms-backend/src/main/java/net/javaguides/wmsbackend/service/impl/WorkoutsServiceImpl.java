package net.javaguides.wmsbackend.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.wmsbackend.dto.WorkoutsDto;
import net.javaguides.wmsbackend.entity.Workouts;
import net.javaguides.wmsbackend.exception.ResourceNotFoundException;
import net.javaguides.wmsbackend.mapper.WorkoutsMapper;
import net.javaguides.wmsbackend.repository.WorkoutsRepository;
import net.javaguides.wmsbackend.service.WorkoutsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class WorkoutsServiceImpl implements WorkoutsService {

    private WorkoutsRepository workoutsRepository;

    @Override
    public WorkoutsDto createWorkouts(WorkoutsDto workoutsDto) {

        Workouts workouts = WorkoutsMapper.mapToWorkouts(workoutsDto);
        Workouts savedWorkouts = workoutsRepository.save(workouts);
        return WorkoutsMapper.mapToWorkoutsDto(savedWorkouts);
    }

    @Override
    public WorkoutsDto getWorkoutsById(Long workoutsId) {
        Workouts workouts = workoutsRepository.findById(workoutsId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Workouts is not exist " +workoutsId));
        return WorkoutsMapper.mapToWorkoutsDto(workouts);
    }

    @Override
    public List<WorkoutsDto> getAllWorkouts() {
        List<Workouts> workouts = workoutsRepository.findAll();
        return workouts.stream().map((workout) -> WorkoutsMapper.mapToWorkoutsDto(workout)).collect(Collectors.toList());
    }

    @Override
    public WorkoutsDto updateWorkouts(Long workoutsId, WorkoutsDto updatedWorkouts) {
        Workouts workouts = workoutsRepository.findById(workoutsId).orElseThrow(
                () -> new ResourceNotFoundException("Workouts is not exist " +workoutsId)
        );

        workouts.setCatergory(updatedWorkouts.getCatergory());
        workouts.setDescription(updatedWorkouts.getDescription());
        workouts.setType(updatedWorkouts.getType());
        workouts.setWorkout(updatedWorkouts.getWorkout());

        Workouts updateWorkoutsObj = workoutsRepository.save(workouts);
        return WorkoutsMapper.mapToWorkoutsDto(updateWorkoutsObj);
    }

    @Override
    public void deleteWorkouts(Long workoutsId) {
        Workouts workouts = workoutsRepository.findById(workoutsId).orElseThrow(
                () -> new ResourceNotFoundException("Workouts is not exist " +workoutsId)
        );

        workoutsRepository.deleteById(workoutsId);
    }
}
