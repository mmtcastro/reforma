package br.com.tdec.reforma.views;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import br.com.tdec.reforma.AbstractViewDoc;
import br.com.tdec.reforma.models.Fornecedor;
import br.com.tdec.reforma.services.FornecedorServiceImpl;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Route(value = "fornecedor", layout = MainLayout.class)
@PageTitle("Fornecedor")
@Data
@EqualsAndHashCode(callSuper = false)

public class FornecedorView extends VerticalLayout implements AbstractViewDoc {

	private static final long serialVersionUID = 1L;
	private Fornecedor model;

	private final FornecedorServiceImpl fornecedorService;

	@Autowired
	public FornecedorView(FornecedorServiceImpl fornecedorService) {
		model = new Fornecedor();
		this.fornecedorService = fornecedorService;

		add(new Paragraph(fornecedorService.toString()));
	}

	

}
