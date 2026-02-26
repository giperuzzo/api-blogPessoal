package Senai.Ipiranga.com.blogPessoal.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import Senai.Ipiranga.com.blogPessoal.Model.Usuario;
import Senai.Ipiranga.com.blogPessoal.Model.UsuarioLogin;
import Senai.Ipiranga.com.blogPessoal.Repository.UsuarioRepository;
import Senai.Ipiranga.com.blogPessoal.Service.UsuarioService;

@RestController
@CrossOrigin(origins="*", allowedHeaders="*")
@RequestMapping("/usuario")
public class UsuarioController {
	//@Autowired serve para injetar dependencias em uma classe
	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	// get metodo de pesquisa getmapping sem parâmetro usa pra pegar o all todo mundo
	@GetMapping
	public ResponseEntity<List<Usuario>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	//qdo falamos de api rest baseada em browser usamos os metodos http ou seja o crud, no controller dentro dessa anotação 
	//ja estamos chamando lá do springboot ja tem coisas prontas para referenciar os metodos hppt(
	// dentro do protocolo temos os metodos, o mapping esta referenciando la no nosso spring
	//ja tem um forma ao -  ao chamar o controller e usar o metodo post ele vai direto ao metodo que eu quero
	//informar o caminho - map resp (fazendo/mpeando uma verificacao da resposta ok ou unauthorized
	
	@PostMapping("/logar")
	public ResponseEntity<UsuarioLogin> Autentication(@RequestBody Optional<UsuarioLogin> user){
		return usuarioService.Logar(user).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}
	
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Usuario> getById(@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).
				orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping("/cadastrar") 
	public ResponseEntity<Usuario> Post(@RequestBody Usuario usuario){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(usuarioService.CadastrarUsuario(usuario));
	}
	
	@PutMapping
	public ResponseEntity<Usuario> Put(@RequestBody Usuario usuario){
		return ResponseEntity.ok(repository.save(usuario));
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
	
		
}

/*@GetMapping("/nome/{nome}")
public ResponseEntity<List<Usuario>> getAllByNome(@PathVariable String nome){
	return ResponseEntity.ok(repository.findAll());
}*/

/* @CrossOrigin uma proteção/segurança, ele bloqueia ou não as requisição feira por sites nao autorizados, quando vc indica * ele diz que ele vai aceitar o cross de qq origem*/