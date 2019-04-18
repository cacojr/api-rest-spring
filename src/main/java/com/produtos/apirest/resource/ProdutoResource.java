package com.produtos.apirest.resource;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API Rest Produtos")
@CrossOrigin(origins = "*")
public class ProdutoResource {

    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping(value = "/produtos")
    @ApiOperation(value = "Retorna uma lista de Produtos")
    public List<Produto> listarProdutos(){
        return produtoRepository.findAll();
    }

    @GetMapping(value = "/produto/{id}")
    @ApiOperation(value = "Retorna um Produto pelo {id}")
    public Produto getProduto(@PathVariable(value = "id") long id){
        return produtoRepository.findById(id);
    }

    @PostMapping(value = "/produto")
    @ApiOperation(value = "Salva um produto e o retorna")
    public Produto salvaProduto(@RequestBody Produto produto){
        return produtoRepository.save(produto);
    }

    @DeleteMapping(value = "/produto/{id}")
    @ApiOperation(value = "Deleta um Produto pelo {id}")
    public void deletaProdutoId(@PathVariable(value = "id") long id){
        produtoRepository.deleteById(id);
    }

    @DeleteMapping(value = "/produto")
    @ApiOperation(value = "Deleta um Produto passando-o como parâmetro")
    public void deltaProduto(@RequestBody Produto produto){
        produtoRepository.delete(produto);
    }

    @PutMapping(value = "/produto")
    @ApiOperation(value = "Atualiza um Produto passando-o como parâmetro")
    public Produto atualizaProduto(@RequestBody Produto produto){
        return produtoRepository.save(produto);
    }
}
