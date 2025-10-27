package co.edu.uco.treepruning.initializer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"co.edu.uco.treepruning"})
@SpringBootApplication
public class TreePruningApplication {

	public static void main(String[] args) {
		SpringApplication.run(TreePruningApplication.class, args);
	}

}
