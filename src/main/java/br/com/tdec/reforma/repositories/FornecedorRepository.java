package br.com.tdec.reforma.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.tdec.reforma.models.Fornecedor;

@Repository
public interface FornecedorRepository extends MongoRepository<Fornecedor, String> {
	
	
	
	
	@Query("{codigo:'?0'}")
    Fornecedor findFornecedorByCodigo(String name);
	
	public long count();
	
	

}
