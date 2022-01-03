package br.com.tdec.reforma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import br.com.tdec.reforma.models.Fornecedor;

@Service
public class FornecedorServiceImpl implements FornecedorService {
	
	
	private final MongoTemplate mongoTemplate;
	
	@Autowired
	public FornecedorServiceImpl(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
	
	@Override
	public Fornecedor saveFornecedor(Fornecedor fornecedor) {
		mongoTemplate.save(fornecedor);
		return fornecedor;
	}

	
	@Override
	public Fornecedor updateFornecedor(Fornecedor fornecedor) {
		 mongoTemplate.save(fornecedor);
		   return fornecedor;
		
	}

	@Override
	public void deleteFornecedorByCodigo(String codigo) {
		Fornecedor fornecedor = findFornecedorByCodigo(codigo);
		if(fornecedor != null) {
			mongoTemplate.remove(fornecedor);
		}
		
	}

	@Override
	public void deleteForncedorById(String id) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Fornecedor findFornecedorByCodigo(String codigo) {
		 Query query = new Query();
		   query.addCriteria(Criteria.where("codigo").is(codigo));
		   return mongoTemplate.findOne(query, Fornecedor.class);
	}

	@Override
	public Fornecedor findFornecedorById(String id) {
		 Query query = new Query();
		   query.addCriteria(Criteria.where("id").is(id));
		   return mongoTemplate.findOne(query, Fornecedor.class);
	}

	@Override
	public List<Fornecedor> getAllFornecedores() {
		return mongoTemplate.findAll(Fornecedor.class);
	}

	@Override
	public List<Fornecedor> fetchFornecedores(int offset, int limit) {
		Query query = new Query();
		   query.skip(offset * limit);
		   query.limit(limit);
		   return mongoTemplate.find(query, Fornecedor.class);
	}

	@Override
	public int getFornecedoresCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	

	

	@Override
	public void deleteFornecedor(Fornecedor fornecedor) {
		// TODO Auto-generated method stub
		
	}

	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	

	

	

	

	

}
