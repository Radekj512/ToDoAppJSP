package pl.sda.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Setter
public class ToDoModel {
    private Long id;
    private Category category;
    private String description;
    private String title;
    private LocalDate creationDate;
    private LocalDate deadlineDate;
    private boolean isDone;

}
