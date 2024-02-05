package br.com.noavaipq.desafiopringboot.controller;


import br.com.noavaipq.desafiopringboot.model.ProdutoModel;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IAPIController<T> {

    public ResponseEntity<?> create(@RequestBody T produto);
    public ResponseEntity<List<T>> findAll();
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody T produto);
    public void delete(@PathVariable Integer id);
}
