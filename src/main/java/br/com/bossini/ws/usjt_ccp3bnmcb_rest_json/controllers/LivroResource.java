package br.com.bossini.ws.usjt_ccp3bnmcb_rest_json.controllers;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.bossini.ws.usjt_ccp3bnmcb_rest_json.model.beans.Livro;
import br.com.bossini.ws.usjt_ccp3bnmcb_rest_json.model.repository.LivroRepository;

@RestController
@RequestMapping ("/livros")
public class LivroResource {

	@Autowired
	private LivroRepository livroRepo;
	
	@GetMapping ("/lista")
	public List <Livro> todosOsLivros (){
		return livroRepo.findAll();
	}
	
	@PostMapping ("/salvar")
	//@ResponseStatus (HttpStatus.CREATED)
	public ResponseEntity<Livro> salvar (@RequestBody Livro livro, HttpServletResponse response) {
		Livro l = livroRepo.save(livro);
		URI uri = ServletUriComponentsBuilder.
				fromCurrentServletMapping().
				path("/{id}").buildAndExpand(l.getId()).toUri();
		//response.setHeader("Location", uri.toASCIIString());
		return ResponseEntity.created(uri).body(l);
	}
	
	
	@GetMapping ("/{id}")
	public Livro buscarPeloId (@PathVariable Long id) {
		return livroRepo.getOne(id);
	}
}











