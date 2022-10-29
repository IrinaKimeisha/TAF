package models;

import lombok.*;

@Builder
@ToString
@EqualsAndHashCode(exclude = "id")

public class MilestoneBuilder {
    private int id;
    private String name;
    private String references;
    private String description;
    private boolean completed;
}
