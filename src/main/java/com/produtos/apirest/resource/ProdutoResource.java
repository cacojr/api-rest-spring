package com.produtos.apirest.resource;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ProdutoResource {

    @Autowired
    ProdutoRepository produtoRepository;

    @PostMapping(value = "/oi")
    public void get(){

    }

    @GetMapping(value = "/produtos")
    public List<Produto> listarProdutos(){
        return produtoRepository.findAll();
    }

    @GetMapping(value = "/produto/{id}")
    public Produto getProduto(@PathVariable(value = "id") long id){
        return produtoRepository.findById(id);
    }

    @PostMapping(value = "/produto")
    public Produto salvaProduto(@RequestBody Produto produto){
        return produtoRepository.save(produto);
    }

    @DeleteMapping(value = "/produto/{id}")
    public void deletaProdutoId(@PathVariable(value = "id") long id){
        produtoRepository.deleteById(id);
    }

    @DeleteMapping(value = "/produto")
    public void deltaProduto(@RequestBody Produto produto){
        produtoRepository.delete(produto);
    }

    @PutMapping(value = "/produto")
    public Produto atualizaProduto(@RequestBody Produto produto){
        return produtoRepository.save(produto);
    }
}
