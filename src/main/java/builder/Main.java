package builder;

import java.util.ArrayList;

public class Main {

    public static void main(String args[]){
        User user = User.builder()
                .firstName("Karyna")
                .age(18)
                .lastName("Volokhatiuk")
                .build();
        System.out.println(user);
    }
}
