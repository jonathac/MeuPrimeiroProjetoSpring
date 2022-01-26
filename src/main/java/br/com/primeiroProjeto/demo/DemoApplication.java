package br.com.primeiroProjeto.demo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.primeiroProjeto.demo.model.Cliente;
import br.com.primeiroProjeto.demo.model.Endereco;
import br.com.primeiroProjeto.demo.model.Produto;
import br.com.primeiroProjeto.demo.repository.EnderecoRepository;
import br.com.primeiroProjeto.demo.service.ClienteService;
import br.com.primeiroProjeto.demo.service.EnderecoService;
import br.com.primeiroProjeto.demo.service.ProdutoService;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private EnderecoService enderecoService;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		Produto produto1 = new Produto("Maça",400);
		Produto produto2 = new Produto("Laranja",250);
		Produto produto3 = new Produto("Manga",100);
		// Cadastrando o produto
	
		Endereco endereco = new Endereco("Estrada Cajupiranga", "Jardim Planalto", "Parnamirim");
	
		
		Calendar c = Calendar.getInstance();
		c.set(1993, 2, 16);
				
		Cliente cliente = new Cliente ("Jonatha Cassio","jonathacassio@gmail.com",c,Arrays.asList(produto1, produto2, produto3), endereco);
		
		produto1.setCliente(cliente);
		produto2.setCliente(cliente);
		produto3.setCliente(cliente);
		
		clienteService.create(cliente);
		
	}

	

}
