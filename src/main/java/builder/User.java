package builder;

import lombok.Builder;
import lombok.Singular;
import lombok.ToString;

import java.util.List;

@Builder @ToString
public class User {
    private String firstName;
    private String lastName;
    @Singular
    private List<String> occupations;
    private String gender;
    private int age;
    private int weight;
}
