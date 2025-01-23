package emprestimos.com.credor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "emprestimos.com.credor")
public class CredorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CredorApplication.class, args);
	}

}
