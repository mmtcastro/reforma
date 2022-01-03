package br.com.tdec.reforma.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.tdec.reforma.models.Tipo;

@Repository
public interface TipoRepository extends MongoRepository<Tipo, String> {

}
