package net.javaguides.wmsbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WorkoutsDto {
    private Long id;
    private String catergory;
    private String description;
    private String type;
    private String workout;
}
