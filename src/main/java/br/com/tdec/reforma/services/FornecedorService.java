package br.com.tdec.reforma.services;

import java.util.Collection;
import java.util.List;

import br.com.tdec.reforma.models.Fornecedor;

public interface FornecedorService {
	Fornecedor saveFornecedor(Fornecedor fornecedor);
	Fornecedor updateFornecedor(Fornecedor fornecedor);
	public void deleteFornecedor(Fornecedor fornecedor);
	public void deleteFornecedorByCodigo(String codigo);
	public void deleteForncedorById(String id);
	
	public Fornecedor findFornecedorByCodigo(String codigo);
	public Fornecedor findFornecedorById(String id);
	
	public Collection<Fornecedor> getAllFornecedores();	
	public List<Fornecedor> fetchFornecedores(int offset, int limit);
	
	public int getFornecedoresCount();

}
