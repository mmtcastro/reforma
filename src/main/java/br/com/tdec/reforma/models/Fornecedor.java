package br.com.tdec.reforma.models;

import org.springframework.data.mongodb.core.mapping.Document;

import br.com.tdec.reforma.AbstractModelDoc;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Document
@Data
@EqualsAndHashCode(callSuper=false)
public class Fornecedor extends AbstractModelDoc {

	public Fornecedor() {
		super();
	}

}
