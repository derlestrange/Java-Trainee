import java.io.Serializable;

public class Human implements Serializable {
    public String name;
    public transient String activity;
    public int age;

    public Human(String humanName, int humanAge, String activityAge) {
        this.name = humanName;
        this.age = humanAge;
        this.activity = activityAge;
    }
}