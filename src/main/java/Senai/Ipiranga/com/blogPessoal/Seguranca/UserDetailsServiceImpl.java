package Senai.Ipiranga.com.blogPessoal.Seguranca;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import Senai.Ipiranga.com.blogPessoal.Model.Usuario;
import Senai.Ipiranga.com.blogPessoal.Repository.UsuarioRepository;

/* Autenticação do login do usuario @Service ele esta implementando e criando um objeto, @autowired esta fazendo a injeção 
 * ele vai verificar no banco de dados se ele acha o usuario  */ 
@Service 
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private 	UsuarioRepository userRepository;
	
	@Override 
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException{
		Optional<Usuario> user = userRepository.findByUsuario(userName);
		user.orElseThrow(()-> new UsernameNotFoundException(userName + "notfound"));
		return user.map(UserDetailsImpl::new).get();
	}
	
}
