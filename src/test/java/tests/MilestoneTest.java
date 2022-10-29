package tests;

import models.Milestone;
import models.MilestoneBuilder;
import org.testng.annotations.Test;

public class MilestoneTest {
    @Test
    public void lombokTest1() {
        Milestone milestone = new Milestone();
        milestone.setId(1);
        milestone.setName("hsf");
        milestone.setDescription("mdsk");
        milestone.setCompleted(false);

        Milestone milestone1 = new Milestone();
        milestone1.setId(2);
        milestone.setName("hsf");
        milestone.setDescription("mdsk");
        milestone.setCompleted(false);

        System.out.println(milestone.toString());
        System.out.println(milestone1.toString());
        System.out.println(milestone.equals(milestone1));

    }
    @Test
    public void lombokTest2() {
        MilestoneBuilder milestone = MilestoneBuilder.builder()
                .id(1)
                .description("hj")
                .name("gf")
                .build();
        MilestoneBuilder milestone1 = MilestoneBuilder.builder()
                .id(1)
                .description("hj")
                .name("gf")
                .build();

        System.out.println(milestone.toString());
        System.out.println(milestone1.toString());
        System.out.println(milestone.equals(milestone1));
    }
}
