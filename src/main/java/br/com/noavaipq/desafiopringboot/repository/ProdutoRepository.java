package br.com.noavaipq.desafiopringboot.repository;

import br.com.noavaipq.desafiopringboot.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Integer> {
}
