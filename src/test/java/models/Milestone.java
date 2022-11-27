package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Milestone {
    private String name;
    private String description;
    private int due_on;
    private boolean is_started;
}
