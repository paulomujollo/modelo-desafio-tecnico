package br.com.noavaipq.desafiopringboot.service;

import br.com.noavaipq.desafiopringboot.repository.ProdutoRepository;
import br.com.noavaipq.desafiopringboot.model.ProdutoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService implements IAPIService<ProdutoModel> {

    @Autowired
    ProdutoRepository produtoRepository;

    @Override
    public ProdutoModel create(ProdutoModel produto) {
        return produtoRepository.saveAndFlush(produto);
    }

    @Override
    public List<ProdutoModel> findAll() {
        return produtoRepository.findAll();
    }

    @Override
    public ProdutoModel update(Integer id, ProdutoModel produto) {
        Optional<ProdutoModel> opProduto = produtoRepository.findById(id);

        if (opProduto.isPresent()) {
            ProdutoModel produtoUpdate = opProduto.get();
            produtoUpdate.setNome(produto.getNome());
            produtoUpdate.setValor(produto.getValor());
            return produtoRepository.saveAndFlush(produtoUpdate);
        }

        return null;
    }

    @Override
    public void delete(Integer id) {
        produtoRepository.deleteById(id);
    }

    public ProdutoModel findById(Integer id) {
        Optional<ProdutoModel> opProduto = produtoRepository.findById(id);
        if (opProduto.isPresent()) {
            return opProduto.get();
        }

        return null;
    }
}
