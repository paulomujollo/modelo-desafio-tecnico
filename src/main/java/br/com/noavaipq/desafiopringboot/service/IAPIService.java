package br.com.noavaipq.desafiopringboot.service;

import br.com.noavaipq.desafiopringboot.model.ProdutoModel;

import java.util.List;

public interface IAPIService<T> {

    public ProdutoModel create(T produto);
    public List<ProdutoModel> findAll();
    public ProdutoModel update(Integer id, T produto);
    public void delete(Integer id);
}
