package models;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

public class Testcase {
    @Data
    @Builder
    public class TestCase {
        private String title;
        private int type;

        @SerializedName(value = "Priority")
        private int priority;

        @SerializedName(value = "References")
        private String references;
    }

}
