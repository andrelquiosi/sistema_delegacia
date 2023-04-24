package br.edu.utfpr.td.tsi.projeto_delegacia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("br.edu.utfpr.td.tsi.projeto_delegacia")
public class ProjetoDelegaciaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoDelegaciaApplication.class, args);
	}

}
