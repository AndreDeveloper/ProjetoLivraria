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

	private JLabel ISBN = new JLabel();
	private JLabel Titulo = new JLabel();
	private JLabel Autor = new JLabel();
	private JLabel Editora = new JLabel();
	private JLabel Categoria = new JLabel();
	private JLabel DataPublicacao = new JLabel();
	private JLabel Formato = new JLabel();
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
		JPanel painelCentral = new JPanel(new GridLayout(7, 2, 15, 1));
		painelCentral.setForeground(Color.white);
		painelCentral.setBackground(Color.white);
		painelCentral.setBorder(BorderFactory.createEmptyBorder());
		
		painelCentral.add(lblISBN);
		painelCentral.add(ISBN);
		painelCentral.add(lblTitulo);
		painelCentral.add(Titulo);
		painelCentral.add(lblAutor);
		painelCentral.add(Autor);
		painelCentral.add(lblEditora);
		painelCentral.add(Editora);
		painelCentral.add(lblCategoria);
		painelCentral.add(Categoria);
		painelCentral.add(lblDataPublicacao);
		painelCentral.add(DataPublicacao);
		painelCentral.add(lblFormato);
		painelCentral.add(Formato);
		
		formataLabel(lblAutor);
		formataLabel(lblCategoria);
		formataLabel(lblDataPublicacao);
		formataLabel(lblEditora);
		formataLabel(lblFormato);
		formataLabel(lblISBN);
		formataLabel(lblResumo);
		formataLabel(lblSumario);
		formataLabel(lblTitulo);
		
		formataTexto(Autor);
		formataTexto(Categoria);
		formataTexto(DataPublicacao);
		formataTexto(Editora);
		formataTexto(Formato);
		formataTexto(ISBN);
		formataTexto(Titulo);
		
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
		
		Dimension d = new Dimension(400, 130);
		
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
		
		JPanel painelSul = new JPanel(new GridLayout(2, 2, 15, 1));
		painelSul.setForeground(Color.white);
		painelSul.setBackground(Color.white);
		painelSul.setBorder(BorderFactory.createEmptyBorder());
		
		painelSul.add(lblResumo);
		painelSul.add(painelResumo);
		painelSul.add(lblSumario);
		painelSul.add(painelSumario);
		
		livroToForm();
		painelPrincipal.setForeground(Color.white);
		painelPrincipal.setBackground(Color.white);
		painelPrincipal.setBorder(BorderFactory.createEmptyBorder());
		painelPrincipal.add(painelLeste, BorderLayout.WEST);
		painelPrincipal.add(painelCentral, BorderLayout.CENTER);
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
	}
	
	private void formataLabel(JLabel lbl){
		lbl.setHorizontalAlignment(JLabel.RIGHT);
		lbl.setVerticalAlignment(JLabel.CENTER);
		lbl.setForeground(Color.BLACK);
		lbl.setBackground(Color.WHITE);
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
