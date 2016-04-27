package boundary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import entity.LivroEntity;
import infraestructure.LivroDAO;

public class InfoLivroBoundary {
	private LivroEntity livro;
	private JPanel painelPrincipal = new JPanel(new BorderLayout());
	private JLabel lblISBN = new JLabel("ISNB:");
	private JLabel lblTitulo = new JLabel("Titulo:");
	private JLabel lblAutor = new JLabel("Autor:");
	private JLabel lblEditora = new JLabel("Editora:");
	private JLabel lblCategoria = new JLabel("Categoria:");
	private JLabel lblDataPublicacao = new JLabel("Data da Publicação:");
	private JLabel lblFormato = new JLabel("Formato:");
	private JLabel lblSumario = new JLabel("Sumario:");
	private JLabel lblResumo = new JLabel("Resumo:");
	private JLabel lblNPaginas = new JLabel("N° Paginas:");

	private JLabel ISBN = new JLabel();
	private JLabel Titulo = new JLabel();
	private JLabel Autor = new JLabel();
	private JLabel Editora = new JLabel();
	private JLabel Categoria = new JLabel();
	private JLabel DataPublicacao = new JLabel();
	private JLabel Formato = new JLabel();
	private JLabel NPaginas = new JLabel();
	
	private JTextArea Sumario = new JTextArea();
	private JTextArea Resumo = new JTextArea();
	
	private JLabel imagem = new JLabel();
	
	public InfoLivroBoundary(LivroEntity livro) {
		super();
		this.livro = new LivroDAO().selectByIsbn(livro.getIsbn());
		create();
	}



	public JPanel getPainelPrincipal() {
		return painelPrincipal;
	}



	public void setPainelPrincipal(JPanel painelPrincipal) {
		this.painelPrincipal = painelPrincipal;
	}



	public void create(){
		JPanel painelCentral = new JPanel(new GridLayout(8, 1,5,5));
		painelCentral.setForeground(Color.white);
		painelCentral.setBackground(Color.white);
		painelCentral.setBorder(BorderFactory.createEmptyBorder());
		Dimension e = new Dimension(700, 300);
		painelCentral.setSize(e);
		painelCentral.setPreferredSize(e);
		
		JPanel row1 = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
		row1.setForeground(Color.white);
		row1.setBackground(Color.white);
		row1.setBorder(BorderFactory.createEmptyBorder());
		
		JPanel row2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
		row2.setForeground(Color.white);
		row2.setBackground(Color.white);
		row2.setBorder(BorderFactory.createEmptyBorder());
		
		JPanel row3 = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
		row3.setForeground(Color.white);
		row3.setBackground(Color.white);
		row3.setBorder(BorderFactory.createEmptyBorder());
		
		JPanel row4 = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
		row4.setForeground(Color.white);
		row4.setBackground(Color.white);
		row4.setBorder(BorderFactory.createEmptyBorder());
		
		JPanel row5 = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
		row5.setForeground(Color.white);
		row5.setBackground(Color.white);
		row5.setBorder(BorderFactory.createEmptyBorder());
		
		JPanel row6 = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
		row6.setForeground(Color.white);
		row6.setBackground(Color.white);
		row6.setBorder(BorderFactory.createEmptyBorder());
		
		JPanel row7 = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
		row7.setForeground(Color.white);
		row7.setBackground(Color.white);
		row7.setBorder(BorderFactory.createEmptyBorder());

		JPanel row08 = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
		row08.setForeground(Color.white);
		row08.setBackground(Color.white);
		row08.setBorder(BorderFactory.createEmptyBorder());

		row1.add(lblISBN);
		row1.add(ISBN);
		row2.add(lblTitulo);
		row2.add(Titulo);
		row3.add(lblAutor);
		row3.add(Autor);
		row4.add(lblEditora);
		row4.add(Editora);
		row5.add(lblCategoria);
		row5.add(Categoria);
		row6.add(lblDataPublicacao);
		row6.add(DataPublicacao);
		row7.add(lblFormato);
		row7.add(Formato);
		row08.add(lblNPaginas);
		row08.add(NPaginas);
		
		
		painelCentral.add(row1);
		painelCentral.add(row2);
		painelCentral.add(row3);
		painelCentral.add(row4);
		painelCentral.add(row5);
		painelCentral.add(row6);
		painelCentral.add(row7);
		painelCentral.add(row08);

		
		formataLabel(lblAutor);
		formataLabel(lblCategoria);
		formataLabel(lblDataPublicacao);
		formataLabel(lblEditora);
		formataLabel(lblFormato);
		formataLabel(lblISBN);
		formataLabel(lblResumo);
		formataLabel(lblSumario);
		formataLabel(lblTitulo);
		formataLabel(lblNPaginas);
		
		formataTexto(Autor);
		formataTexto(Categoria);
		formataTexto(DataPublicacao);
		formataTexto(Editora);
		formataTexto(Formato);
		formataTexto(ISBN);
		formataTexto(Titulo);
		formataTexto(NPaginas);
		
		imagem.setHorizontalAlignment(JLabel.CENTER);
		imagem.setVerticalAlignment(JLabel.CENTER);
		imagem.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		imagem.setAlignmentY(JLabel.CENTER_ALIGNMENT);
		imagem.setForeground(Color.BLACK);
		imagem.setBackground(Color.WHITE);
		imagem.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		Resumo.setForeground(Color.BLUE);
		Resumo.setBackground(Color.WHITE);
		Resumo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Resumo.setLineWrap(true);
		Resumo.setEditable(false);
		
		Sumario.setForeground(Color.BLUE);
		Sumario.setBackground(Color.WHITE);
		Sumario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Sumario.setLineWrap(true);
		Sumario.setEditable(false);
		
		Dimension d = new Dimension(800, 130);
		
		JScrollPane painelResumo = new JScrollPane();
		painelResumo.setPreferredSize(d);
		painelResumo.setSize(d);
		painelResumo.setViewportView(Resumo);
		painelResumo.setBackground(Color.white);
		
		JScrollPane painelSumario = new JScrollPane();
		painelSumario.setPreferredSize(d);
		painelSumario.setSize(d);
		painelSumario.setViewportView(Sumario);
		painelSumario.setBackground(Color.white);
		
		FlowLayout flowLayout = new FlowLayout();
		flowLayout.setAlignment(FlowLayout.CENTER);
		JPanel painelLeste = new JPanel(flowLayout);
		painelLeste.setForeground(Color.white);
		painelLeste.setBackground(Color.white);
		painelLeste.setBorder(BorderFactory.createEmptyBorder());
		painelLeste.setAlignmentX(JPanel.CENTER_ALIGNMENT);
		painelLeste.setAlignmentY(JPanel.CENTER_ALIGNMENT);
        painelLeste.add(imagem);
		
		JPanel painelSul = new JPanel(new GridLayout(2, 1, 15, 1));
		painelSul.setForeground(Color.white);
		painelSul.setBackground(Color.white);
		painelSul.setBorder(BorderFactory.createEmptyBorder());
		
		
		JPanel row8 = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
		row8.setForeground(Color.white);
		row8.setBackground(Color.white);
		row8.setBorder(BorderFactory.createEmptyBorder());
		
		JPanel row9 = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
		row9.setForeground(Color.white);
		row9.setBackground(Color.white);
		row9.setBorder(BorderFactory.createEmptyBorder());
		
		row8.add(lblResumo);
		row8.add(painelResumo);
		row9.add(lblSumario);
		row9.add(painelSumario);
		
		painelSul.add(row8 );
		painelSul.add(row9 );
		
		livroToForm();
		painelPrincipal.setForeground(Color.white);
		painelPrincipal.setBackground(Color.white);
		painelPrincipal.setBorder(BorderFactory.createEmptyBorder());
		painelPrincipal.add(painelLeste, BorderLayout.CENTER);
		painelPrincipal.add(painelCentral, BorderLayout.WEST);
		painelPrincipal.add(painelSul, BorderLayout.SOUTH);
		
		
		
	}



	private void livroToForm() {
		ISBN.setText("" + livro.getIsbn());
		Titulo.setText(livro.getTituloLivro());
		Autor.setText(livro.getNomeAutor());
		Editora.setText(livro.getEditora());
		Categoria.setText(livro.getCategoriaLivro());
		DataPublicacao.setText("" + livro.getDataPublicacao());
		if(livro.getFormato() == 1) Formato.setText("Brochura");
		if(livro.getFormato() == 2) Formato.setText("Capa Dura");
		Sumario.setText(livro.getSumario());
		Resumo.setText(livro.getResumo());
		imagem.setIcon(livro.getImagem());
		NPaginas.setText("" + livro.getNumeroPaginas());
	}
	
	private void formataLabel(JLabel lbl){
		lbl.setHorizontalAlignment(JLabel.LEFT);
		lbl.setVerticalAlignment(JLabel.CENTER);
		lbl.setForeground(Color.BLACK);
		lbl.setBackground(Color.WHITE);
		lbl.setPreferredSize(new Dimension(250, 30));
		lbl.setFont(new Font("Tahoma", Font.BOLD, 24));
	}
	private void formataTexto(JLabel lbl){
		lbl.setHorizontalAlignment(JLabel.LEFT);
		lbl.setVerticalAlignment(JLabel.CENTER);
		lbl.setForeground(Color.BLUE);
		lbl.setBackground(Color.WHITE);
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
	}
}
