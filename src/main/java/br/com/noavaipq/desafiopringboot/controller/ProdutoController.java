package br.com.noavaipq.desafiopringboot.controller;

import br.com.noavaipq.desafiopringboot.model.ProdutoModel;
import br.com.noavaipq.desafiopringboot.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/produto")
public class ProdutoController implements IAPIController<ProdutoModel> {

    @Autowired
    ProdutoService produtoService;

    @PostMapping
    @Override
    public ResponseEntity<ProdutoModel> create(@RequestBody ProdutoModel produto) {
        ProdutoModel produtoModel = produtoService.create(produto);
        return ResponseEntity.ok(produtoModel);
    }

    @GetMapping
    @Override
    public ResponseEntity<List<ProdutoModel>> findAll() {
        List<ProdutoModel> produtoModelList = produtoService.findAll();
        return ResponseEntity.ok(produtoModelList);
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<ProdutoModel> update(@PathVariable Integer id, @RequestBody ProdutoModel produto) {
        ProdutoModel produtoModel = produtoService.update(id, produto);

        if (produtoModel != null) {
            return ResponseEntity.ok(produtoModel);
        } else {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(null);
        }

    }

    @DeleteMapping("/{id}")
    @Override
    public void delete(Integer id) {
        produtoService.delete(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoModel> findById(@PathVariable Integer id) {
        ProdutoModel produtoModel = produtoService.findById(id);

        if (produtoModel != null) {
            return ResponseEntity.ok(produtoModel);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
