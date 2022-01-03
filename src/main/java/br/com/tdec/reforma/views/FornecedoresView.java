package br.com.tdec.reforma.views;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import br.com.tdec.reforma.AbstractViewGrid;
import br.com.tdec.reforma.models.Fornecedor;
import br.com.tdec.reforma.services.FornecedorServiceImpl;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Route(value = "fornecedores", layout = MainLayout.class)
@PageTitle("Fornecedores")
@Data
@EqualsAndHashCode(callSuper=false)
public class FornecedoresView extends VerticalLayout implements AbstractViewGrid {
	
	private static final long serialVersionUID = 1L;
	private Grid<Fornecedor> grid;
	private DataProvider<Fornecedor, Void> dataProvider;
	
	private final FornecedorServiceImpl fornecedorService;
	
	@Autowired
	public FornecedoresView(FornecedorServiceImpl fornecedorService) {
		this.fornecedorService = fornecedorService;
		init();
	}

	
	
	public void initDataProvider() {
		dataProvider =
			    DataProvider.fromCallbacks(
			        // First callback fetches items based on a query
			        query -> {
			            // The index of the first item to load
			            int offset = query.getOffset();

			            // The number of items to load
			            int limit = query.getLimit();

			            List<Fornecedor> persons = fornecedorService.fetchFornecedores(offset, limit);

			            return persons.stream();
			        },
			        // Second callback fetches the total number of items currently in the Grid.
			        // The grid can then use it to properly adjust the scrollbars.
			        query -> fornecedorService.getFornecedoresCount());
	}
	
	public void init() {
		add (new H1("Fornecedores"));
		grid = new Grid<>();
		grid.addColumn(Fornecedor::getCodigo);
		grid.addColumn(Fornecedor::getDescricao);
		grid.setItems(fornecedorService.getAllFornecedores());
		add(grid);
		add (new Button("Novo Fornecedor", event -> novoFornecedor()));
		
	}
	
	public void novoFornecedor() {
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setCodigo("FORNECEDOR_" + new Date().toString());
		fornecedor.setNome("Fornecedor Teste " + new Date().toString());
		Paragraph p1 = new Paragraph(fornecedor.getCodigo());
		add(p1);
		Paragraph p2 = new Paragraph(fornecedorService.saveFornecedor(fornecedor).toString());
		grid.setItems(fornecedorService.getAllFornecedores());
		add(p2);
		
		
	}
	
	
	
	

}
