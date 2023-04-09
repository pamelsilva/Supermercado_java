package controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import model.Supermercado;
import service.SupermercadoService;


//CLASSSE CONTROLLER = ENDPOINTS DA APLICAÇÃO
@RestController
@RequestMapping("/supermercado")
public class SupermercadoController {
	

	//construtor using fields
	public SupermercadoController(SupermercadoService supermercadoService) {
			this.supermercadoService = supermercadoService;
	}

	//instanciando a service
	SupermercadoService supermercadoService;
	
	//iniciando o cadastro nesse endpoint
	@PostMapping("/produtos")
	@ResponseStatus(HttpStatus.CREATED)
	public Supermercado criarProduto(@RequestBody Supermercado produto) {
		return supermercadoService.criarProduto(produto);
	}
	
	//listando os produtos cadastrados anteriormente
	@GetMapping("/produtos")
	@ResponseStatus(HttpStatus.OK)
	public List<Supermercado>listarProdutos(){
	return supermercadoService.listarProdutos();
	}

	//listando os produtos cadastrados anteriormente pelo ID
	@GetMapping("/produtos/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Supermercado>buscarProdutoPeloId
	(@PathVariable(value="id") Long id){
	return supermercadoService.buscarProdutoPeloId(id);
	
	}
	
	//atualizando os produtos cadastrados anteriormente pelo ID
	@PutMapping("/produtos/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Supermercado>atualizarProdutoPeloId
	(@PathVariable(value="id")Long id,
	@RequestBody Supermercado produto){
	return supermercadoService.atualizarProdutoPeloId(produto,id);

	}
	
	//excluindo os produtos cadastrados anteriormente pelo ID
	@DeleteMapping("/produtos/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Object>excluirProdutoPeloId
	(@PathVariable(value="id")Long id){
	return supermercadoService.excluirProdutoPeloId(id);
	
	}
	
}
