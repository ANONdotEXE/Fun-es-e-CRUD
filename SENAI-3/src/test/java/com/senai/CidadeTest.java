package com.senai;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.senai.domain.Cidade;
import com.senai.domain.repositories.CidadeRepository;

@SpringBootTest
public class CidadeTest {
	
	@Autowired
	CidadeRepository cidadeRepo;

	//Ok
	@Test
	void Cidade() {
		Cidade cid = new Cidade();
		cid.setId(null);
		cid.setEstado(null);
		cid.setNome("Uberlândia");
		cidadeRepo.save(cid);
	}
	
	//Ok
	@Test
	public void listaCidade() {
		List<Cidade> list = cidadeRepo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	
	//Ok
	@Test
	public void idCidade() {
		Cidade cid = cidadeRepo.findById(1).get();
		assertEquals(1, cid.getId());
	}
	
	//Ok
	@Test
	public void updateCidade() {
		Cidade cid = cidadeRepo.findById(1).get();
		cid.setNome("Uberaba");
		cidadeRepo.save(cid);
		assertNotEquals("Uberlândia", cid.getNome());
	}
	
	/*@Test
	public void deleteCidade() {
		cidadeRepo.deleteById(2);
		assertThat(cidadeRepo.existsById(2));
	}*/
}
