package edu.livraria.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import edu.livraria.boundary.LivroBoundary;



public class EvBtnCarregaImagemLivro implements ActionListener{

	private JLabel imagem = new JLabel();
	private LivroBoundary formLivro;

	public EvBtnCarregaImagemLivro(JLabel imagem,
			LivroBoundary formLivro) {
		super();
		this.imagem = imagem;
		this.formLivro = formLivro;
	}
	
	public void acao(){
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
		        "png","PNG");
		fileChooser.setFileFilter(filter);
		int resposta = fileChooser.showOpenDialog(imagem);
		
		if (resposta == JFileChooser.APPROVE_OPTION){
			java.io.File file = fileChooser.getSelectedFile();
			String Path = file.getAbsolutePath();
			formLivro.setLivroPath(Path);
			imagem.setText("");
			byte[] bs = ImagemFormater.imagemParaByte(new ImageIcon(Path));
			imagem.setIcon(
					ImagemFormater.bytesParaImagem(bs)
					);
			imagem.repaint();
			imagem.invalidate();
			imagem.revalidate();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.acao();
	}

}
