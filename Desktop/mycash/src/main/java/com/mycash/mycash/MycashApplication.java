package com.mycash.mycash;

import java.util.stream.LongStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mycash.mycash.model.Despesa;
import com.mycash.mycash.model.Receita;
import com.mycash.mycash.repository.DespesaRepository;
import com.mycash.mycash.repository.ReceitaRepository;

@SpringBootApplication
public class MycashApplication {

	public static void main(String[] args) {
		SpringApplication.run(MycashApplication.class, args);
	}	
		@Bean
		CommandLineRunner init(DespesaRepository despesaRepository, ReceitaRepository receitaRepository) {
		return args -> {
				despesaRepository.deleteAll();	
				LongStream.range(1, 10)
				.mapToObj(i -> {
				Despesa desp = new Despesa();
				desp.setData(i + i + "/" + i + i );
				desp.setDescricao("TAKARO");
				desp.setFixo(true);
				desp.setTipo("Outros");
				desp.setValor("R$: " + i + i + i + i);
				return desp;
			})
			.map(m -> despesaRepository.save(m))
			.forEach(System.out::println);
		
		receitaRepository.deleteAll();
		LongStream.range(1, 10)
		.mapToObj(i -> {
			Receita receita = new Receita();
			 receita.setData(i + i + "/" + i + i );
			 receita.setDescricao("TABARATO");
			 receita.setFixo(true);
			 receita.setTipo("Outros");
			 receita.setValor("R$: " + i + i + i + i);
			return  receita;
		})
		.map(m ->  receitaRepository.save(m))
		.forEach(System.out::println);
	};
		
	}
}