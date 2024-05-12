package net.javaguides.wmsbackend.controller;

import lombok.AllArgsConstructor;
import net.javaguides.wmsbackend.dto.WorkoutsDto;
import net.javaguides.wmsbackend.service.WorkoutsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/workouts")
public class WorkoutsController {

    private WorkoutsService workoutsService;

    //Create workouts REST API
    @PostMapping
    public ResponseEntity<WorkoutsDto> createWorkouts(@RequestBody WorkoutsDto workoutsDto){
        WorkoutsDto savedWorkouts = workoutsService.createWorkouts(workoutsDto);
        return new ResponseEntity<>(savedWorkouts, HttpStatus.CREATED);
    }

    //Get specific workout REST API
    @GetMapping("{id}")
    public ResponseEntity<WorkoutsDto> getWorkoutsById(@PathVariable("id") Long workoutsId){
        WorkoutsDto workoutsDto = workoutsService.getWorkoutsById((workoutsId));
        return ResponseEntity.ok(workoutsDto);
    }

    //Get all workouts REST API
    @GetMapping
    public ResponseEntity<List<WorkoutsDto>> getAllWorkouts(){
        List<WorkoutsDto> workouts = workoutsService.getAllWorkouts();
        return ResponseEntity.ok(workouts);
    }

    //Update specific workout REST API
    @PutMapping("{id}")
    public ResponseEntity<WorkoutsDto> updateWorkouts(@PathVariable("id") Long workoutsId, @RequestBody WorkoutsDto updatedWorkouts){
        WorkoutsDto workoutsDto = workoutsService.updateWorkouts(workoutsId, updatedWorkouts);
        return ResponseEntity.ok(workoutsDto);
    }

    //Delete specific workout REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteWorkouts(@PathVariable("id") Long workoutsId){
        workoutsService.deleteWorkouts(workoutsId);
        return ResponseEntity.ok("Workout deleted successfully!");
    }
}
