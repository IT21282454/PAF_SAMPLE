package net.javaguides.wmsbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "workouts")

public class Workouts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "catergory")
    private String catergory;

    @Column(name = "description")
    private String description;

    @Column(name = "type")
    private String type;

    @Column(name = "workout")
    private String workout;
}
