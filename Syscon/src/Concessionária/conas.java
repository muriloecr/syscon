package Concessionaria;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;
import javax.swing.JFormattedTextField$AbstractFormatter;

public class conas {

	private JFrame frame;

// DEFININDO CAMPOS DEFININDO CAMPOS DEFININDO CAMPOS DEFININDO CAMPOS
	private JFormattedTextField ascod;
	private JFormattedTextField asvei;
	private JFormattedTextField asadveicod;
	private JFormattedTextField asexcveicod;
	
// lança a APLICAÇÃO lança a APLICAÇÃO lança a APLICAÇÃO lança a APLICAÇÃO	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					conas window = new conas();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

// cria a APLICAÇÃO cria a APLICAÇÃO cria a APLICAÇÃO cria a APLICAÇÃO
	public conas() {
		initialize();
	}

// deixa a JANELA VISIVEL QUANDO CHAMADA deixa a JANELA VISIVEL QUANDO CHAMADA
	public void visivel() {
		conas windows = new conas();
		windows.frame.setVisible(true);
	}
	
// inicia a JANELA inicia a JANELA inicia a JANELA inicia a JANELA
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1011, 501);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
// MÁSCARAS MÁSCARAS MÁSCARAS MÁSCARAS MÁSCARAS MÁSCARAS MÁSCARAS MÁSCARAS MÁSCARAS
		NumberFormat numberFormat = NumberFormat.getIntegerInstance();
        NumberFormatter numberFormatter = new NumberFormatter(numberFormat);
        numberFormatter.setAllowsInvalid(false);
        try {
		    MaskFormatter mask = new MaskFormatter("####");
			ascod = new JFormattedTextField(mask);
			MaskFormatter mask1 = new MaskFormatter("####");
			asvei = new JFormattedTextField(mask1);
			MaskFormatter mask2 = new MaskFormatter("####");
			asadveicod = new JFormattedTextField(mask2);
			MaskFormatter mask3 = new MaskFormatter("####");
			asexcveicod = new JFormattedTextField(mask3);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO na formatação de Campos", "erro", JOptionPane.ERROR_MESSAGE);
		}

// label janela ACESSÓRIOS label janela ACESSÓRIOS label janela ACESSÓRIOS
		JLabel labcli = new JLabel("Acessórios");
		labcli.setFont(new Font("Tahoma", Font.BOLD, 50));
		labcli.setBounds(45, 33, 293, 61);
		frame.getContentPane().add(labcli);
		
// label janela SysCon label janela SysCon label janela SysCon
		JLabel lablogo = new JLabel("SysCon");
		lablogo.setFont(new Font("Tahoma", Font.BOLD, 50));
		lablogo.setBounds(758, 33, 183, 61);
		frame.getContentPane().add(lablogo);

// linha CÓDIGO DO ACESSÓRIO linha CÓDIGO DO ACESSÓRIO linha CÓDIGO DO ACESSÓRIO
		JLabel labcodas = new JLabel("Código");
		labcodas.setFont(new Font("Tahoma", Font.BOLD, 24));
		labcodas.setBounds(45, 114, 150, 35);
		frame.getContentPane().add(labcodas);
		
		JLabel labcodasform = new JLabel("formato 9999");
		labcodasform.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labcodasform.setBounds(45, 139, 150, 28);
		frame.getContentPane().add(labcodasform);
		
		//JTextArea ascod = new JTextArea();
		ascod.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ascod.setBounds(180, 125, 104, 35);
		frame.getContentPane().add(ascod);
				
// linha NOME ACESSÓRIO linha NOME ACESSÓRIO linha NOME ACESSÓRIO linha NOME ACESSÓRIO
		JLabel labnomeas = new JLabel("Nome");
		labnomeas.setFont(new Font("Tahoma", Font.BOLD, 24));
		labnomeas.setBounds(45, 167, 150, 35);
		frame.getContentPane().add(labnomeas);
		
		JLabel labnomeasform1 = new JLabel("formato texto");
		labnomeasform1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labnomeasform1.setBounds(45, 192, 150, 28);
		frame.getContentPane().add(labnomeasform1);
		
		JTextArea asnome = new JTextArea();
		asnome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		asnome.setBounds(180, 178, 761, 35);
		frame.getContentPane().add(asnome);
				
// linha de VEÍCULOS COM O ACESSÓRIO linha de VEÍCULOS COM O ACESSÓRIO
		JLabel labveias = new JLabel("Veículos com");
		labveias.setFont(new Font("Tahoma", Font.BOLD, 24));
		labveias.setBounds(44, 223, 183, 35);
		frame.getContentPane().add(labveias);
		
		JLabel labveiasform = new JLabel("formato 9999");
		labveiasform.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labveiasform.setBounds(44, 248, 203, 28);
		frame.getContentPane().add(labveiasform);
				
		JTextArea asvei = new JTextArea();
		asvei.setFont(new Font("Tahoma", Font.PLAIN, 18));
		asvei.setBounds(228, 234, 713, 35);
		frame.getContentPane().add(asvei);
		
// linha ADICIONAR VEÍCULOS linha ADICIONAR VEÍCULOS linha ADICIONAR VEÍCULOS	
		JLabel labadveias = new JLabel("Adicionar Veículo");
		labadveias.setFont(new Font("Tahoma", Font.BOLD, 24));
		labadveias.setBounds(42, 280, 230, 35);
		frame.getContentPane().add(labadveias);
				
		JLabel labadveiasform = new JLabel("formato 9999");
		labadveiasform.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labadveiasform.setBounds(42, 305, 150, 28);
		frame.getContentPane().add(labadveiasform);
		
		//JTextArea asadveicod = new JTextArea();
		asadveicod.setFont(new Font("Tahoma", Font.PLAIN, 18));
		asadveicod.setBounds(260, 291, 150, 35);
		frame.getContentPane().add(asadveicod);
		
// linha EXCLUIR VEÍCULOS linha ADICIONAR VEÍCULOS linha EXCLUIR VEÍCULOS	
		JLabel labexcveias = new JLabel("Excluir Veículo");
		labexcveias.setFont(new Font("Tahoma", Font.BOLD, 24));
		labexcveias.setBounds(585, 280, 230, 35);
		frame.getContentPane().add(labexcveias);
		
		JLabel labexcveiform = new JLabel("formato 9999");
		labexcveiform.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labexcveiform.setBounds(585, 305, 150, 28);
		frame.getContentPane().add(labexcveiform);
		
		//JTextArea asexcveicod = new JTextArea();
		asexcveicod.setFont(new Font("Tahoma", Font.PLAIN, 18));
		asexcveicod.setBounds(791, 291, 150, 35);
		frame.getContentPane().add(asexcveicod);
		
// linha BOTÃO SALVAR linha BOTÃO SALVAR linha BOTÃO SALVAR	 linha BOTÃO SALVAR	
		JButton btnassalvar = new JButton("Salvar");
		btnassalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conini tel = new conini();
				tel.visivel();
				frame.dispose();
			}
		});
		btnassalvar.setFont(new Font("Tahoma", Font.BOLD, 36));
		btnassalvar.setBounds(45, 367, 223, 53);
		frame.getContentPane().add(btnassalvar);

// linha BOTÃO EXCLUIR linha BOTÃO EXCLUIR linha BOTÃO EXCLUIR linha BOTÃO EXCLUIR
		JButton btnasexcluir = new JButton("Excluir");
		btnasexcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conini tel = new conini();
				tel.visivel();
				frame.dispose();
			}
		});
		btnasexcluir.setFont(new Font("Tahoma", Font.BOLD, 36));
		btnasexcluir.setBounds(383, 367, 223, 53);
		frame.getContentPane().add(btnasexcluir);
		
// linha BOTÂO VOLTAR linha BOTÂO VOLTAR linha BOTÂO VOLTAR linha BOTÂO VOLTAR
		JButton btnasvoltar = new JButton("Voltar");
		btnasvoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conini tel = new conini();
				tel.visivel();
				frame.dispose();
			}
		});
		btnasvoltar.setFont(new Font("Tahoma", Font.BOLD, 36));
		btnasvoltar.setBounds(718, 367, 223, 53);
		frame.getContentPane().add(btnasvoltar);		
	}
}
