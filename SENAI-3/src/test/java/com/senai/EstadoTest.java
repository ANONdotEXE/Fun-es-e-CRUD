package com.senai;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.senai.domain.Estado;
import com.senai.domain.repositories.EstadoRepository;



@SpringBootTest
public class EstadoTest {

	@Autowired
	EstadoRepository estadoRepo;
	
	//Ok
	@Test
	void Estado() {
		Estado es = new Estado();
		es.setId(null);
		es.setNome("Minas Gerais");
		estadoRepo.save(es);
	}
	
	//Ok
	@Test
	public void listaEstado() {
		List<Estado> list = estadoRepo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	
	//Ok
	@Test
	public void idEstado() {
		Estado es = estadoRepo.findById(1).get();
		assertEquals("Minas Gerais", es.getNome());
	}

	//Ok
	@Test
	public void updateEstado() {
		Estado es = estadoRepo.findById(1).get();
		es.setNome("Bibor da Silva");
		estadoRepo.save(es);
		assertNotEquals("Bibor", es.getNome());
	}

	/*
	@Test
	public void deleteEstado() {
		estadoRepo.deleteById(2);
		assertThat(estadoRepo.existsById(2));
	}*/

}
