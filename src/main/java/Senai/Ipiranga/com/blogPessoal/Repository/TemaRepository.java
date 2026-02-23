package Senai.Ipiranga.com.blogPessoal.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Senai.Ipiranga.com.blogPessoal.Model.Tema;

@Repository

public interface TemaRepository extends JpaRepository<Tema,Long>{
	public List<Tema> findAllByDescricaoContainingIgnoreCase(String descricao);
	public List<Tema> findById(long id);
	
	
}
