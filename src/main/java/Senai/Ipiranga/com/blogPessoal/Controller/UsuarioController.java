//package Senai.Ipiranga.com.blogPessoal.Controller;
/*
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import Senai.Ipiranga.com.blogPessoal.Model.Usuario;
import Senai.Ipiranga.com.blogPessoal.Repository.UsuarioRepository;

@RestController
@CrossOrigin(origins="*", allowedHeaders="*")
@RequestMapping("/usuario")
public class UsuarioController {
	//@Autowired serve para injetar dependencias em uma classe
	@Autowired
	private UsuarioRepository repository;
	@GetMapping
	public ResponseEntity<List<Usuario>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Usuario>> getAllByNome(@PathVariable String nome){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Optional<Usuario>> getById(@PathVariable Long id){
		return ResponseEntity.ok(repository.findById(id));
	}
	
	/*@PostMapping("/cadastrar") falta fazer o service para implemntar o metodo post / cadastrar
	public ResponseEntity<Usuario> Post(@RequestBody Usuario usuario){
		return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioService)
	}
		
}*/


/* @CrossOrigin uma proteção/segurança, ele bloqueia ou não as requisição feira por sites nao autorizados, quando vc indica * ele diz que ele vai aceitar o cross de qq origem*/