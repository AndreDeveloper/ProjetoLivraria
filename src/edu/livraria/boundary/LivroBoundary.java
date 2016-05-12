package edu.livraria.boundary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import edu.livraria.control.EvBtnCarregaImagemLivro;
import edu.livraria.control.LivroController;
import edu.livraria.entity.Categoria;
import edu.livraria.entity.Livro;
import edu.livraria.infraestructure.CategoriaDAO;

public class LivroBoundary implements ActionListener, KeyListener, MouseListener{
	private JPanel tela = new JPanel(new BorderLayout());
	private JButton btnSalvar = new JButton("Salvar");
	private JButton btnAlterar = new JButton("Alterar");
	private JButton btnExcluir = new JButton("Excluir");
	private JButton btnNovo = new JButton("Novo");
	private JButton btnCarregaImagem = new JButton("Carregar Imagem");
	private JButton pesquisaEditora = new JButton();
	private JButton btnVoltar = new JButton("");
	private JButton pesquisaLivro = new JButton();
	private JButton pesquisaAutor = new JButton();
	private LivroController livroControl= new LivroController();
	private String livroPath;
	
	private JTextField txtIsbn = new JTextField(10);
	private JTextField txtTituloLivro = new JTextField(50);
	private JTextField txtNomeAutor = new JTextField(20);
	private JComboBox<String> cbCategoriaLivro = new JComboBox<String>();
	private JTextField txtEditora = new JTextField(20);
	private JDateChooser jcDataPublicacao = new JDateChooser();
	private JComboBox<String> txtFormato = new JComboBox<String>();
	String[] formato = {"BROCHURA", "CAPA DURA"}; 
	private JComboBox<String> cmbFormato = new JComboBox<String>(formato);
	private JTextField txtNumeroDePaginas = new JTextField(5);
	private JTextArea txtSumario = new JTextArea(5, 50);
	private JTextArea txtResumo = new JTextArea(5, 50);
	private JFormattedTextField txtPreçoCusto = new JFormattedTextField();
	private JFormattedTextField txtPrecoVenda = new JFormattedTextField();
	private JFormattedTextField txtMargemLucro = new JFormattedTextField();
	private JTextField txtQtdadeEstoque = new JTextField(5);
	
	private JLabel lblImagem = new JLabel("<<Selecione uma imagem>>");
	
	public String getLivroPath() {
		return livroPath;
	}

	public void setLivroPath(String livroPath) {
		this.livroPath = livroPath;
	}

	public LivroBoundary() {
		// declarando e inicializando os componentes de tela.
		
		JLabel lblIsbn = new JLabel("Isbn");
		JLabel lblTituloLivro = new JLabel("Titulo");
		JLabel lblNomeAutor = new JLabel("Autor");
		JLabel lblCategoriaLivro = new JLabel("Categoria");
		JLabel lblEditora = new JLabel("Editora");
		JLabel lblDataPublicacao = new JLabel("Data da Publicação");
		JLabel lblFormato = new JLabel("Formato");
		JLabel lblNumeroDePaginas = new JLabel("N° Paginas");
		JLabel lblSumario = new JLabel("Sumario");
		JLabel lblResumo = new JLabel("Resumo");
		JLabel lblPreçoCusto = new JLabel("Preço de custo R$:");
		JLabel lblPrecoVenda = new JLabel("Preço de venda R$:");
		JLabel lblMargemLucro = new JLabel("Margem de lucro");
		JLabel lblQtdadeEstoque = new JLabel("Quantidade em estoque");
	
		JPanel painelLeste = new JPanel(new BorderLayout());
		
		JPanel painelCentro = new JPanel(new BorderLayout());
		JPanel painelCentroCentro = new JPanel(new BorderLayout());
        JPanel painelCentroGrid = new JPanel(new GridLayout(6, 1, 1, 1));
		
		// montando a tela / painel leste
		painelLeste.add(lblImagem, BorderLayout.CENTER);
		painelLeste.add(btnCarregaImagem, BorderLayout.SOUTH);

		// motando a tela / painel centro
		FlowLayout flowLayout = new FlowLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		flowLayout.setHgap(5);
		JPanel linha1 = new JPanel(flowLayout);
		JPanel linha2 = new JPanel(flowLayout);
		JPanel linha3 = new JPanel(flowLayout);
		JPanel linha4 = new JPanel(flowLayout);
		JPanel linha5 = new JPanel(flowLayout);
		JPanel linha6 = new JPanel(flowLayout);
		JPanel linha7 = new JPanel(new BorderLayout());
		JPanel linha8 = new JPanel(new BorderLayout());
		
		linha1.add(lblIsbn);
		linha1.add(txtIsbn);
		pesquisaLivro.setIcon(
				new ImageIcon(LivroBoundary.class.getResource("/resource/search1.png"))
				);
		linha1.add(pesquisaLivro);
		pesquisaLivro.addActionListener(this);
		painelCentroGrid.add(linha1);
		
		linha2.add(lblTituloLivro);
		linha2.add(txtTituloLivro);
		painelCentroGrid.add(linha2);
		
		linha3.add(lblNomeAutor);
		linha3.add(txtNomeAutor);
		pesquisaAutor.setIcon(
				new ImageIcon(LivroBoundary.class.getResource("/resource/lupa.png"))
				);
		linha3.add(pesquisaAutor);		
		linha3.add(lblEditora);
		linha3.add(txtEditora);
		pesquisaEditora.setIcon(
				new ImageIcon(LivroBoundary.class.getResource("/resource/lupa.png"))
				);
		linha3.add(pesquisaEditora);
		painelCentroGrid.add(linha3);		

		linha4.add(lblCategoriaLivro);
		linha4.add(cbCategoriaLivro);
		linha4.add(lblDataPublicacao);
		linha4.add(jcDataPublicacao);
		linha4.add(lblFormato);
		linha4.add(txtFormato);
		painelCentroGrid.add(linha4);
		
		linha5.add(lblPreçoCusto);
		linha5.add(txtPreçoCusto);
		linha5.add(lblPrecoVenda);
		linha5.add(txtPrecoVenda);		
		linha5.add(lblMargemLucro);
		linha5.add(txtMargemLucro);
		painelCentroGrid.add(linha5);		
		
		linha6.add(lblNumeroDePaginas);
		linha6.add(txtNumeroDePaginas);
		linha6.add(lblQtdadeEstoque);
		linha6.add(txtQtdadeEstoque);
		painelCentroGrid.add(linha6);
		
		linha7.add(lblSumario, BorderLayout.NORTH);
		linha7.add(txtSumario, BorderLayout.CENTER);
		
		linha8.add(lblResumo, BorderLayout.NORTH);
		linha8.add(txtResumo, BorderLayout.CENTER);
		
		JPanel painelSetado = new JPanel(new BorderLayout());
		painelSetado.add(painelCentroGrid, BorderLayout.CENTER);
		
		JPanel painelTextAreas = new JPanel(new GridLayout(2, 1));
		painelTextAreas.add(linha7);
		painelTextAreas.add(linha8);
		
		painelSetado.add(painelTextAreas, BorderLayout.SOUTH);
	   	
		DefaultComboBoxModel<String> combomodel = 
    			new DefaultComboBoxModel<String>();
    	for(String s: new CategoriaDAO().selectAll()){
    		combomodel.addElement(s);
    	}
    	
    	
	   	cbCategoriaLivro.setModel(combomodel);
	   	cbCategoriaLivro.setToolTipText("Escolha uma categoria");    	
	   	cbCategoriaLivro.setForeground(Color.BLACK);
	   	cbCategoriaLivro.setBackground(Color.WHITE);
	   	cbCategoriaLivro.setFont(new Font("Tahoma", Font.BOLD, 14));
	   	cbCategoriaLivro.setCursor(new Cursor(Cursor.HAND_CURSOR));
	   	cbCategoriaLivro.setBorder(BorderFactory.createEtchedBorder());
	   	cbCategoriaLivro.setEditable(false);
	   	
	   	String[] values = {"<<Escolha o formato>>", "1 - Brochura", "2 - Capa dura"};
	   	DefaultComboBoxModel<String> combomodel1 = new DefaultComboBoxModel<>(values);
	   	
	   	txtFormato.setModel(combomodel1);
	   	txtFormato.setToolTipText("Escolha uma categoria");    	
	   	txtFormato.setForeground(Color.BLACK);
	   	txtFormato.setBackground(Color.WHITE);
	   	txtFormato.setFont(new Font("Tahoma", Font.BOLD, 14));
	   	txtFormato.setCursor(new Cursor(Cursor.HAND_CURSOR));
	   	txtFormato.setBorder(BorderFactory.createEtchedBorder());
	   	txtFormato.setEditable(false);
	   	
	   	// montando o painel de botoes
		
		JPanel painelBotoes = new JPanel();
		FlowLayout layoutBotoes = new FlowLayout();
		layoutBotoes.setAlignment(FlowLayout.CENTER);
		layoutBotoes.setHgap(110);
		painelBotoes.setLayout(layoutBotoes);
		painelBotoes.add(btnNovo);
		painelBotoes.add(btnSalvar);
		painelBotoes.add(btnAlterar);
		painelBotoes.add(btnExcluir);
		painelBotoes.add(btnVoltar);
		
	   	// formatando os componentes
	   	btnCarregaImagem.setIcon(
	   			new ImageIcon(LivroBoundary.class.getResource("/resource/open.png"))
	   			);
	   	btnCarregaImagem.setToolTipText("clique para carregar a imagem do livro");    	
	   	btnCarregaImagem.setForeground(Color.BLACK);
	   	btnCarregaImagem.setBackground(Color.WHITE);
	   	btnCarregaImagem.setFont(new Font("Tahoma", Font.BOLD, 18));
	   	btnCarregaImagem.setCursor(new Cursor(Cursor.HAND_CURSOR));
	   	btnCarregaImagem.setBorder(BorderFactory.createEmptyBorder());
	   	EvBtnCarregaImagemLivro evcarrega = new EvBtnCarregaImagemLivro(lblImagem, this);
	   	btnCarregaImagem.addActionListener(evcarrega);
	   	
	   	btnSalvar.addActionListener(this);
	   	btnSalvar.setToolTipText("Salvar registro");    	
	   	btnSalvar.setForeground(Color.BLACK);
	   	btnSalvar.setBackground(Color.WHITE);
	   	btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 18));
	   	btnSalvar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	   	btnSalvar.setBorder(BorderFactory.createEmptyBorder());
	   	btnSalvar.setIcon(
				new ImageIcon(LivroBoundary.class.getResource("/resource/save.png"))
				);	   	
	   	
	   	btnVoltar.addActionListener(this);
	   	btnVoltar.setToolTipText("voltar");    	
	   	btnVoltar.setForeground(Color.BLACK);
	   	btnVoltar.setBackground(Color.WHITE);
	   	btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 18));
	   	btnVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	   	btnVoltar.setBorder(BorderFactory.createEmptyBorder());
	   	btnVoltar.setIcon(
				new ImageIcon(LivroBoundary.class.getResource("/resource/back.png"))
				);	
	   	
	   	btnNovo.addActionListener(this);
	   	btnNovo.setToolTipText("Novo registro");    	
	   	btnNovo.setForeground(Color.BLACK);
	   	btnNovo.setBackground(Color.WHITE);
	   	btnNovo.setFont(new Font("Tahoma", Font.BOLD, 18));
	   	btnNovo.setCursor(new Cursor(Cursor.HAND_CURSOR));
	   	btnNovo.setBorder(BorderFactory.createEmptyBorder());
	   	btnNovo.setIcon(
				new ImageIcon(LivroBoundary.class.getResource("/resource/novo.png"))
				);
	   	
	   	btnAlterar.addActionListener(this);
	   	btnAlterar.setToolTipText("alterar dados");    	
	   	btnAlterar.setForeground(Color.BLACK);
	   	btnAlterar.setBackground(Color.WHITE);
	   	btnAlterar.setFont(new Font("Tahoma", Font.BOLD, 18));
	   	btnAlterar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	   	btnAlterar.setBorder(BorderFactory.createEmptyBorder());
	   	btnAlterar.setIcon(
				new ImageIcon(LivroBoundary.class.getResource("/resource/edit.png"))
				);
	   	
	   	btnExcluir.addActionListener(this);
	   	btnExcluir.setToolTipText("Exclui registro");    	
	   	btnExcluir.setForeground(Color.BLACK);
	   	btnExcluir.setBackground(Color.WHITE);
	   	btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 18));
	   	btnExcluir.setCursor(new Cursor(Cursor.HAND_CURSOR));
	   	btnExcluir.setBorder(BorderFactory.createEmptyBorder());
	   	btnExcluir.setIcon(
				new ImageIcon(LivroBoundary.class.getResource("/resource/delete.png"))
				);
	   	
	   	pesquisaAutor.setToolTipText("clique para pesquisar um autor");    	
	   	pesquisaAutor.setForeground(Color.BLACK);
	   	pesquisaAutor.setBackground(Color.WHITE);
	   	pesquisaAutor.setFont(new Font("Tahoma", Font.BOLD, 14));
	   	pesquisaAutor.setCursor(new Cursor(Cursor.HAND_CURSOR));
	   	pesquisaAutor.setBorder(BorderFactory.createEmptyBorder());
	   	pesquisaAutor.addActionListener(this);
	   	
	   	pesquisaEditora.setToolTipText("clique para pesquisar uma editora");    	
	   	pesquisaEditora.setForeground(Color.BLACK);
	   	pesquisaEditora.setBackground(Color.WHITE);
	   	pesquisaEditora.setFont(new Font("Tahoma", Font.BOLD, 14));
	   	pesquisaEditora.setCursor(new Cursor(Cursor.HAND_CURSOR));
	   	pesquisaEditora.setBorder(BorderFactory.createEmptyBorder());
	   	pesquisaEditora.addActionListener(this);
	   	
	   	pesquisaLivro.setToolTipText("clique para pesquisar um livro pelo isbn");    	
	   	pesquisaLivro.setForeground(Color.BLACK);
	   	pesquisaLivro.setBackground(Color.WHITE);
	   	pesquisaLivro.setFont(new Font("Tahoma", Font.BOLD, 14));
	   	pesquisaLivro.setCursor(new Cursor(Cursor.HAND_CURSOR));
	   	pesquisaLivro.setBorder(BorderFactory.createEmptyBorder());
	   	
	   	jcDataPublicacao.setForeground(Color.BLUE);
	   	jcDataPublicacao.setBackground(Color.WHITE);
	   	jcDataPublicacao.setFont(new Font("Tahoma", Font.BOLD, 14));
	   	Dimension d = new Dimension(200, 30);
	   	jcDataPublicacao.setPreferredSize(d);
	   	jcDataPublicacao.setBorder(BorderFactory.createEtchedBorder());
	   	
	   	lblImagem.setForeground(Color.GREEN);
	   	lblImagem.setBorder(new LineBorder(Color.BLACK));
	   	lblImagem.setBackground(Color.LIGHT_GRAY);
	   	lblImagem.setVerticalAlignment(JLabel.CENTER);
	   	lblImagem.setHorizontalAlignment(JLabel.CENTER);
	   	    	
	   	formataJlabel(lblQtdadeEstoque);
	   	formataJlabel(lblCategoriaLivro);
	   	formataJlabel(lblDataPublicacao);
	   	formataJlabel(lblEditora);
	   	formataJlabel(lblFormato);
	   	formataJlabel(lblIsbn);
	   	formataJlabel(lblMargemLucro);
	   	formataJlabel(lblNomeAutor);
	   	formataJlabel(lblNumeroDePaginas);
	   	formataJlabel(lblPrecoVenda);
	   	formataJlabel(lblPreçoCusto);
	   	formataJlabel(lblQtdadeEstoque);
	   	formataJlabel(lblResumo);
	   	formataJlabel(lblSumario);
	   	formataJlabel(lblTituloLivro);
	   	
	   	formataJtextField(txtEditora);
//	   	formataJtextField(txtFormato);
	   	formataJtextField(txtIsbn);
	   	formataJtextField(txtMargemLucro);
	   	formataJtextField(txtNomeAutor);
	   	formataJtextField(txtNumeroDePaginas);
	   	formataJtextField(txtPrecoVenda);
	   	formataJtextField(txtPreçoCusto);
	   	formataJtextField(txtQtdadeEstoque);
	   	formataJtextField(txtTituloLivro);
	   	
	   	formataPainel(painelCentro);
	   	formataPainel(painelCentroCentro);
	   	formataPainel(painelCentroGrid);
	   	formataPainel(painelLeste);
	   	formataPainel(painelBotoes);
	   	formataPainel(linha1);
	   	formataPainel(linha2);
	   	formataPainel(linha3);
	   	formataPainel(linha4);
	   	formataPainel(linha5);
	   	formataPainel(linha6);
	   	formataPainel(linha7);
	   	formataPainel(linha8);
	   	
	   	lblIsbn.setPreferredSize(lblPreçoCusto.getPreferredSize());
	   	lblTituloLivro.setPreferredSize(lblPreçoCusto.getPreferredSize());
	   	lblNomeAutor.setPreferredSize(lblPreçoCusto.getPreferredSize());
	   	lblCategoriaLivro.setPreferredSize(lblPreçoCusto.getPreferredSize());
	   	lblNumeroDePaginas.setPreferredSize(lblPreçoCusto.getPreferredSize());
	   	
	   	lblIsbn.setHorizontalAlignment(JLabel.RIGHT);
	   	lblTituloLivro.setHorizontalAlignment(JLabel.RIGHT);
	   	lblNomeAutor.setHorizontalAlignment(JLabel.RIGHT);
	   	lblCategoriaLivro.setHorizontalAlignment(JLabel.RIGHT);
	   	lblNumeroDePaginas.setHorizontalAlignment(JLabel.RIGHT);
	   	lblSumario.setHorizontalAlignment(JLabel.CENTER);
	   	lblResumo.setHorizontalAlignment(JLabel.CENTER);
	   	
	   	txtResumo.setForeground(Color.BLUE);
		txtResumo.setBackground(Color.white);
		txtResumo.setFont(new Font("Palatino Linotype", Font.PLAIN, 18));
		txtResumo.setBorder(BorderFactory.createEtchedBorder());

		txtSumario.setForeground(Color.BLUE);
		txtSumario.setBackground(Color.white);
		txtSumario.setFont(new Font("Palatino Linotype", Font.PLAIN, 18));
		txtSumario.setBorder(BorderFactory.createEtchedBorder());
		
		txtPrecoVenda.setFormatterFactory(mascara());
	   	txtPreçoCusto.setFormatterFactory(mascara());
	   	txtMargemLucro.setFormatterFactory(mascara());
	   	
	   	txtPrecoVenda.setPreferredSize(txtIsbn.getPreferredSize());
	   	txtPreçoCusto.setPreferredSize(txtIsbn.getPreferredSize());
	   	txtMargemLucro.setPreferredSize(txtIsbn.getPreferredSize());
		
	   	txtIsbn.addKeyListener(this);
	   //	txtPrecoVenda.addKeyListener(this);
	   //	txtPreçoCusto.addKeyListener(this);
	   	txtNumeroDePaginas.addKeyListener(this);
	   //	txtMargemLucro.addKeyListener(this);
	   	txtQtdadeEstoque.addKeyListener(this);
	   	
	   	txtNomeAutor.setCursor(new Cursor(Cursor.HAND_CURSOR));
	   	txtEditora.setCursor(new Cursor(Cursor.HAND_CURSOR));
	   	txtNomeAutor.addMouseListener(this);
	   	txtEditora.addMouseListener(this);
	   	
	   	// montando a tela de fato		
		painelCentroCentro.add(painelSetado, BorderLayout.CENTER);
		painelCentro.add(painelCentroCentro, BorderLayout.CENTER);
		
		tela.add(painelLeste, BorderLayout.WEST);
		tela.add(painelCentro, BorderLayout.CENTER);
		tela.add(painelBotoes, BorderLayout.SOUTH);
		telaDefault();
	}

	public JPanel getTela() {
		return tela;
	}

	public void setTela(JPanel tela) {
		this.tela = tela;
	}
	
	public void formataJlabel(JLabel label){
		label.setForeground(Color.GRAY);
	   	label.setBackground(Color.WHITE);
	   	label.setFont(new Font("Palatino Linotype", Font.BOLD, 18));
	   	label.setBorder(BorderFactory.createEmptyBorder());
	}
	
	public void formataJtextField(JTextField txt){
		txt.setForeground(Color.BLUE);
		txt.setBackground(Color.white);
		txt.setFont(new Font("Palatino Linotype", Font.PLAIN, 18));
		txt.setBorder(BorderFactory.createEtchedBorder());
	}
	public void formataPainel(JPanel painel){
		painel.setForeground(Color.WHITE);
		painel.setBackground(Color.WHITE);
		painel.setBorder(BorderFactory.createEmptyBorder());
	 }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnSalvar){
			if(formToLivro()!= null){
				if (livroControl.salvar(formToLivro()) > 0 ){
					telaNovo();
				}
			}
		}
		else if(e.getSource() == pesquisaLivro){
			new AuxiliarPesquisa(txtIsbn, "PesquisaLivro");
				if (txtIsbn.getText().length() > 0){
					Livro livro = livroControl.pesquisar(Integer.parseInt(txtIsbn.getText()));
					livroToForm(
							livro
							);	
					telaAlterar();
				
				}else{
					JOptionPane.showMessageDialog(null, "digite algum valor no campo isbn para pesquisar!", "erro", JOptionPane.ERROR_MESSAGE);
				}
		}else if(e.getSource() == btnAlterar){
			if (formToLivro()!=null){
				livroControl.atualizar(formToLivro());
				
			}
		}else if(e.getSource() == btnExcluir){
			livroControl.deletar(formToLivro().getIsbn());
			telaDefault();
		}else if(e.getSource() == btnVoltar){
			telaDefault();
		}else if(e.getSource() == btnNovo){
			telaNovo();
		}else if(e.getSource() == pesquisaAutor){
			new AuxiliarPesquisa(txtNomeAutor, "Autor");
		}else if(e.getSource() == pesquisaEditora){
			new AuxiliarPesquisa(txtEditora, "Editora");
		}
	}
	
	public Livro formToLivro(){
		if(validaCampos()){
			Livro livro = new Livro();
			
			String autor[] = txtNomeAutor.getText().split(" ");
			String editora[] = txtEditora.getText().split(" ");
			
			livro.setIdAutor(Integer.parseInt(autor[0]));
			livro.setNomeAutor(autor[2]);
			
			livro.setIdEditora(Integer.parseInt(editora[0]));
			livro.setEditora(editora[2]);
			
			livro.setIdCategoriaLivro(cbCategoriaLivro.getSelectedIndex() + 1);//consertar
			livro.setFormato(txtFormato.getSelectedIndex());
			
			String precoCusto = txtPreçoCusto.getText().replace(".", "");
			String precovenda = txtPrecoVenda.getText().replace(".", "");
			String margemLucro = txtMargemLucro.getText().replace(".", "");
			
			precoCusto = precoCusto.replace(",", ".");
			precovenda = precovenda.replace(",", ".");
			margemLucro = margemLucro.replace(",", ".");
			
			livro.setCategoriaLivro(cbCategoriaLivro.getSelectedItem().toString());
			livro.setDataPublicacao(jcDataPublicacao.getDate());
			livro.setImagem((ImageIcon) lblImagem.getIcon());
			livro.setImagePath(livroPath);
			livro.setIsbn(Integer.parseInt(txtIsbn.getText()));
			livro.setMargemLucro(Double.parseDouble(margemLucro));
			livro.setNumeroPaginas(Integer.parseInt(txtNumeroDePaginas.getText()));
			livro.setPrecoCusto(Double.parseDouble(precoCusto));
			livro.setPrecoVenda(Double.parseDouble(precovenda));
			livro.setQtdeEmEstoque(Integer.parseInt(txtQtdadeEstoque.getText()));
			livro.setResumo(txtResumo.getText());
			livro.setSumario(txtSumario.getText());
			livro.setTituloLivro(txtTituloLivro.getText());
			
			
			return livro;
		}else{
			JOptionPane.showMessageDialog(null, "Preencha corretamente todos os campo!",null,JOptionPane.ERROR_MESSAGE);
		}
		return null;
	}
	
	public void livroToForm(Livro livro){
		String margemLucro = "" + livro.getMargemLucro();
		String precoVenda = "" + livro.getPrecoVenda();
		String precoCusto = "" + livro.getPrecoCusto();
		txtEditora.setText("" + livro.getIdEditora() + " - " + livro.getEditora());
		txtFormato.setSelectedIndex(livro.getFormato());
		txtIsbn.setText("" + livro.getIsbn());
		txtMargemLucro.setText(margemLucro.replace(".", ","));
		txtNomeAutor.setText("" + livro.getIdAutor() + " - " + livro.getNomeAutor());
		txtNumeroDePaginas.setText("" + livro.getNumeroPaginas());
		txtPrecoVenda.setText(precoVenda.replace(".", ","));
		txtPreçoCusto.setText(precoCusto.replace(".", ","));
		txtQtdadeEstoque.setText("" + livro.getQtdeEmEstoque());
		txtResumo.setText("" + livro.getResumo());
		txtSumario.setText(livro.getSumario());
		txtTituloLivro.setText(livro.getTituloLivro());
		jcDataPublicacao.setDate(livro.getDataPublicacao());
		cbCategoriaLivro.setSelectedItem(livro.getCategoriaLivro());
		lblImagem.setText("");
		lblImagem.setIcon(livro.getImagem());		
	}
	
	public void telaDefault(){
		txtEditora.setEditable(false);
		txtFormato.setEditable(false);
		txtMargemLucro.setEditable(false);
		txtNomeAutor.setEditable(false);
		txtNumeroDePaginas.setEditable(false);
		txtPrecoVenda.setEditable(false);
		txtPreçoCusto.setEditable(false);
		txtQtdadeEstoque.setEditable(false);
		txtResumo.setEditable(false);
		txtSumario.setEditable(false);
		txtTituloLivro.setEditable(false);
		txtIsbn.setEditable(true);
		
		txtEditora.setEnabled(false);
		txtFormato.setEnabled(false);
		txtMargemLucro.setEnabled(false);
		txtNomeAutor.setEnabled(false);
		txtNumeroDePaginas.setEnabled(false);
		txtPrecoVenda.setEnabled(false);
		txtPreçoCusto.setEnabled(false);
		txtQtdadeEstoque.setEnabled(false);
		txtResumo.setEnabled(false);
		txtSumario.setEnabled(false);
		txtTituloLivro.setEnabled(false);
		txtIsbn.setEnabled(true);
		cbCategoriaLivro.setEditable(false);
		cbCategoriaLivro.setEnabled(false);
		
		jcDataPublicacao.setEnabled(false);
		
		btnAlterar.setEnabled(false);
		btnCarregaImagem.setEnabled(false);
		btnExcluir.setEnabled(false);
		btnNovo.setEnabled(true);
		btnSalvar.setEnabled(false);
		btnVoltar.setEnabled(false);
		pesquisaAutor.setEnabled(false);
		pesquisaEditora.setEnabled(false);
		pesquisaLivro.setEnabled(true);
		limpaCampos();
	}
	
	public void telaAlterar(){
		txtEditora.setEditable(false);
	//	txtFormato.setEditable(true);
		txtMargemLucro.setEditable(true);
		txtNomeAutor.setEditable(false);
		txtNumeroDePaginas.setEditable(true);
		txtPrecoVenda.setEditable(true);
		txtPreçoCusto.setEditable(true);
		txtQtdadeEstoque.setEditable(true);
		txtResumo.setEditable(true);
		txtSumario.setEditable(true);
		txtTituloLivro.setEditable(true);
		txtIsbn.setEditable(false);
		
		txtEditora.setEnabled(true);
		txtFormato.setEnabled(true);
		txtMargemLucro.setEnabled(true);
		txtNomeAutor.setEnabled(true);
		txtNumeroDePaginas.setEnabled(true);
		txtPrecoVenda.setEnabled(true);
		txtPreçoCusto.setEnabled(true);
		txtQtdadeEstoque.setEnabled(true);
		txtResumo.setEnabled(true);
		txtSumario.setEnabled(true);
		txtTituloLivro.setEnabled(true);
		txtIsbn.setEnabled(false);
		
		//cbCategoriaLivro.setEditable(true);
		cbCategoriaLivro.setEnabled(true);
		
		jcDataPublicacao.setEnabled(true);
		
		btnAlterar.setEnabled(true);
		btnCarregaImagem.setEnabled(true);
		btnExcluir.setEnabled(true);
		btnNovo.setEnabled(false);
		btnSalvar.setEnabled(false);
		btnVoltar.setEnabled(true);
		pesquisaAutor.setEnabled(true);
		pesquisaEditora.setEnabled(true);
		pesquisaLivro.setEnabled(false);
		
	}
	
	public void telaNovo(){
		limpaCampos();
		txtEditora.setEditable(false);
		//txtFormato.setEditable(true);
		txtMargemLucro.setEditable(true);
		txtNomeAutor.setEditable(false);
		txtNumeroDePaginas.setEditable(true);
		txtPrecoVenda.setEditable(true);
		txtPreçoCusto.setEditable(true);
		txtQtdadeEstoque.setEditable(true);
		txtResumo.setEditable(true);
		txtSumario.setEditable(true);
		txtTituloLivro.setEditable(true);
		txtIsbn.setEditable(true);
		
		txtEditora.setEnabled(true);
		txtFormato.setEnabled(true);
		txtMargemLucro.setEnabled(true);
		txtNomeAutor.setEnabled(true);
		txtNumeroDePaginas.setEnabled(true);
		txtPrecoVenda.setEnabled(true);
		txtPreçoCusto.setEnabled(true);
		txtQtdadeEstoque.setEnabled(true);
		txtResumo.setEnabled(true);
		txtSumario.setEnabled(true);
		txtTituloLivro.setEnabled(true);
		txtIsbn.setEnabled(true);
		
		//cbCategoriaLivro.setEditable(true);
		cbCategoriaLivro.setEnabled(true);
		
		jcDataPublicacao.setEnabled(true);
		
		btnAlterar.setEnabled(false);
		btnCarregaImagem.setEnabled(true);
		btnExcluir.setEnabled(false);
		btnNovo.setEnabled(false);
		btnSalvar.setEnabled(true);
		btnVoltar.setEnabled(true);
		pesquisaAutor.setEnabled(true);
		pesquisaEditora.setEnabled(true);
		pesquisaLivro.setEnabled(false);
		
	}
	
	public void limpaCampos(){
		txtEditora.setText("");
		txtFormato.setSelectedIndex(0);
		txtMargemLucro.setText("0,00");
		txtNomeAutor.setText("");
		txtNumeroDePaginas.setText("");
		txtPrecoVenda.setText("0,00");
		txtPreçoCusto.setText("0,00");
		txtQtdadeEstoque.setText("");
		txtResumo.setText("");
		txtSumario.setText("");
		txtTituloLivro.setText("");
		txtIsbn.setText("");
		
		cbCategoriaLivro.setSelectedIndex(0);
		jcDataPublicacao.setDate(null);
		
		lblImagem.setIcon(null);
		lblImagem.setText("<<Selecione uma imagem>>");
		
	}
	
	public boolean validaCampos(){
		if(
		txtEditora.getText().length() == 0 ||
		txtFormato.getSelectedItem().toString() == "<<Escolha o formato>>" ||
		txtMargemLucro.getText().length() == 0 ||
		txtMargemLucro.getText().equals(",00") ||
		txtNomeAutor.getText().length() == 0 ||
		txtNumeroDePaginas.getText().length() == 0 ||
		txtPrecoVenda.getText().length() == 0 ||
		txtPrecoVenda.getText().equals(",00") ||
		txtPreçoCusto.getText().length() == 0 ||
		txtPreçoCusto.getText().equals(",00") ||
		txtQtdadeEstoque.getText().length() == 0 ||
		txtResumo.getText().length() == 0 ||
		txtSumario.getText().length() == 0 ||
		txtTituloLivro.getText().length() == 0 ||
		txtIsbn.getText().length() == 0 ||
		jcDataPublicacao.getDate() == null ||
		cbCategoriaLivro.getSelectedItem().toString().length() == 0 ||
		cbCategoriaLivro.getSelectedItem().toString() == "<<Escolha a Categoria>>"
				)
		{
			return false;
		}else if(lblImagem.getIcon() == null){
			JOptionPane.showMessageDialog(null, "Carregue uma imagem!", null, JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		
		
			return true;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource() == txtPrecoVenda || 
				arg0.getSource() == txtPreçoCusto ||
				arg0.getSource() == txtMargemLucro
				){
			String caracteres="0987654321.";
			if(!caracteres.contains(arg0.getKeyChar()+"")){
				arg0.consume();
			}
		}else if(arg0.getSource() == txtIsbn){
			String caracteres="0987654321";
			if(!caracteres.contains(arg0.getKeyChar()+"" ) || txtIsbn.getText().length() > 8){
				arg0.consume();
			}
			
		}else if(arg0.getSource() == txtQtdadeEstoque){
			String caracteres="0987654321";
			if(!caracteres.contains(arg0.getKeyChar()+"" ) || txtQtdadeEstoque.getText().length() > 4){
				arg0.consume();
			}
			
		}else if(arg0.getSource() == txtNumeroDePaginas){
			String caracteres="0987654321";
			if(!caracteres.contains(arg0.getKeyChar()+"" ) || txtNumeroDePaginas.getText().length() > 4){
				arg0.consume();
			}
		
	}

		
	}
	public DefaultFormatterFactory mascara(){
		DecimalFormat dFormat = new DecimalFormat("#,###,###.00") ;
        NumberFormatter formatter = new NumberFormatter(dFormat) ;
        formatter.setFormat(dFormat) ;
        formatter.setAllowsInvalid(false) ; 
        return new DefaultFormatterFactory ( formatter ) ;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == txtEditora){
			new AuxiliarPesquisa(txtEditora, "Editora");			
		}else if (e.getSource() == txtNomeAutor){
			new AuxiliarPesquisa(txtNomeAutor, "Autor");
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
