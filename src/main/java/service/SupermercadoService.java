package service;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import model.Supermercado;
import repository.SupermercadoRepository;

//CLASSE SERVICE = REGRAS DE NEGÓCIO
@Service
public class SupermercadoService {

	public SupermercadoService(SupermercadoRepository supermercadoRepository) {
		this.supermercadoRepository = supermercadoRepository;
	}

	// instanciando a repository
	private SupermercadoRepository supermercadoRepository;

	// método que cria e salva produto novo
	public Supermercado criarProduto(Supermercado produto) {
		return supermercadoRepository.save(produto);}

	// método que lista produtos
	public List<Supermercado> listarProdutos() 
	   {return supermercadoRepository.findAll();}
	   
	   
	//método que lista produtos pelo ID   
    public ResponseEntity<Supermercado> buscarProdutoPeloId (Long id){;
	   return supermercadoRepository.findById(id) 			   
			   .map(produto->ResponseEntity.ok().body(produto))
	   .orElse(ResponseEntity.notFound().build());
	   }
	   
	   
    //método que atualiza produtos pelo ID   
    public ResponseEntity<Supermercado> atualizarProdutoPeloId(Supermercado produto,Long id){
       return supermercadoRepository.findById(id)
         .map(produtoToUpdate->{        
	     produtoToUpdate.setProduto(produto.getProduto());
	     produtoToUpdate.setPreco(produto.getPreco());
	     produtoToUpdate.setFornecedor(produto.getFornecedor());
         Supermercado updated=supermercadoRepository.save(produtoToUpdate);
         return ResponseEntity.ok().body(updated);
       }).orElse(ResponseEntity.notFound().build());
       } 
	
    //método que exclui produtos pelo ID   
	public ResponseEntity<Object>excluirProdutoPeloId(Long id){
	   return supermercadoRepository.findById(id)
	     .map(produtoToDelete->{
	      supermercadoRepository.deleteById(id);
	      return ResponseEntity.noContent().build();
	}).orElse(ResponseEntity.notFound().build());
	}


	}


