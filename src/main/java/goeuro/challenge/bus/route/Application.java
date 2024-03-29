package goeuro.challenge.bus.route;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class Application {

    public static String filePath = "example.txt";

    public static void main(String[] args) {
        if (args.length == 0) {
            throw new RuntimeException("Not command line argument found");
        }
        filePath = args[0];
        SpringApplication.run(Application.class, args);


    }

}
