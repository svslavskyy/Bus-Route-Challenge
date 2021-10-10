package intellias;

import intellias.pseudorepository.model.ListOfBusRoutes;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
  public static void main(String[] args) {
    ListOfBusRoutes.initialize(args[0]);
    SpringApplication.run(Application.class, args);
  }
}
