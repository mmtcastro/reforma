package br.com.tdec.reforma;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.security.core.context.SecurityContextHolder;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public abstract class AbstractModelDoc extends AbstractModel {
	@Id
	protected String id;
	protected String idOrigem;
	protected String codigo;
	protected String autor;
	protected LocalDateTime criacao;
	protected String nome;
	protected String status;
	protected String tipo;
	protected String descricao;

	public AbstractModelDoc() {
		id = this.getClass().getName() + "_" + UUID.randomUUID().toString();
		autor = SecurityContextHolder.getContext().getAuthentication().getName();
		criacao = LocalDateTime.now();

	}
	
	/** Ainda com o modelo Domino/Notes na cabeça
	 * 
	 * @return
	 */
	public String getForm() {
		return this.getClass().getName();
	}

}
