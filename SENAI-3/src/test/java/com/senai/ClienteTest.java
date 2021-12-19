package com.senai;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.senai.domain.Cliente;
import com.senai.domain.repositories.ClienteRepository;

@SpringBootTest
public class ClienteTest {
	
	@Autowired
	ClienteRepository clienteRepo;
	
	//Ok
	@Test
	void cliente() {
		Cliente cli = new Cliente();
		cli.setIdCliente(null);
		cli.setNome("Teste 1");
		cli.setCpfOuCnpj("123456789");
		cli.setEmail("teste2@gmail.com");
		clienteRepo.save(cli);
	}
	
	//Ok
	@Test
	public void listaCliente() {
		List<Cliente> list = clienteRepo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	
	//Ok
	@Test
	public void idCliente() {
		Cliente cliente = clienteRepo.findById(2).get();
		assertEquals("Bibor de Faria Lima", cliente.getNome());
	}
	
	//Ok
	@Test
	public void updateCliente() {
		Cliente cliente = clienteRepo.findById(1).get();
		cliente.setNome("Bibor da Silva");
		clienteRepo.save(cliente);
		assertNotEquals("Bibor", cliente.getNome());
	}
	
	//Ok
	@Test
	public void deleteCliente() {
		clienteRepo.deleteById(2);
		assertThat(clienteRepo.existsById(2));
	}
	
	//Ok
	@Test
	public void somar() {
		double num1 = 5.0;
		double num2 = 10.0;
		Cliente cliente = new Cliente();
		double soma = cliente.somar(num1, num2);
		assertEquals(15, soma);
	}
	
	//Ok
	@Test
	public void subtrair() {
		double num1 = 15.0;
		double num2 = 11.0;
		Cliente cliente = new Cliente();
		double subtração = cliente.subtrair(num1, num2);
		assertEquals(4, subtração);
	}
	
	//Ok
	@Test
	public void multiplicar() {
		double num1 = 2.0;
		double num2 = 5.0;
		Cliente cliente = new Cliente();
		double multiplicação = cliente.multiplicar(num1, num2);
		assertEquals(10, multiplicação);
	}
	
	//Ok
	@Test
	public void dividir() {
		double num1 = 10.0;
		double num2 = 2.0;
		Cliente cliente = new Cliente();
		double divisão = cliente.dividir(num1, num2);
		assertEquals(5, divisão);
	}

}
