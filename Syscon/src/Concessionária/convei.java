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
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;

public class convei {

	private JFrame frame;

// DEFININDO CAMPOS DEFININDO CAMPOS DEFININDO CAMPOS DEFININDO CAMPOS
	private JFormattedTextField veicod;
	private JFormattedTextField veiano;
	private JFormattedTextField veimod;
	private JFormattedTextField veiplaca;
	private JFormattedTextField veikm;
	
	
	private JFormattedTextField cadveicli;

// lança a APLICAÇÃO lança a APLICAÇÃO lança a APLICAÇÃO lança a APLICAÇÃO	
	public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				convei window = new convei();
				window.frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		});
	}

// cria a APLICAÇÃO cria a APLICAÇÃO cria a APLICAÇÃO cria a APLICAÇÃO
	public convei() {
		initialize();
	}

// deixa a JANELA VISIVEL QUANDO CHAMADA deixa a JANELA VISIVEL QUANDO CHAMADA
	public void visivel() {
		convei window = new convei();
		window.frame.setVisible(true);
	}

// inicia a JANELA inicia a JANELA inicia a JANELA inicia a JANELA inicia a JANELA
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1500, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
// MÁSCARAS MÁSCARAS MÁSCARAS MÁSCARAS MÁSCARAS MÁSCARAS MÁSCARAS MÁSCARAS MÁSCARAS
		NumberFormat numberFormat = NumberFormat.getIntegerInstance();
        NumberFormatter numberFormatter = new NumberFormatter(numberFormat);
        numberFormatter.setAllowsInvalid(false);
        try {
		    MaskFormatter mask = new MaskFormatter("####");
		    veicod = new JFormattedTextField(mask);
		    MaskFormatter mask1 = new MaskFormatter("####");
			veiano = new JFormattedTextField(mask1);
			MaskFormatter mask2 = new MaskFormatter("####");
			veimod = new JFormattedTextField(mask2);
			MaskFormatter mask3 = new MaskFormatter("###-####");
			veiplaca = new JFormattedTextField(mask3);
			MaskFormatter mask4 = new MaskFormatter("###.###");
			veikm = new JFormattedTextField(mask4);
			
			MaskFormatter mask6 = new MaskFormatter("####");
			cadveicli = new JFormattedTextField(mask6);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO na formatação de Campos", "erro", JOptionPane.ERROR_MESSAGE);
		}		

// label janela VEÍCULO label janela VEÍCULO label janela VEÍCULO label janela VEÍCULO
		JLabel labcli = new JLabel("Veículo");
		labcli.setFont(new Font("Tahoma", Font.BOLD, 50));
		labcli.setBounds(43, 22, 240, 61);
		frame.getContentPane().add(labcli);
		
// label janela SysCon label janela SysCon label janela SysCon label janela SysCon
		JLabel lablogo = new JLabel("SysCon");
		lablogo.setFont(new Font("Tahoma", Font.BOLD, 50));
		lablogo.setBounds(1262, 22, 183, 61);
		frame.getContentPane().add(lablogo);
		
// linha CÓDIGO VEÍCULO linha CÓDIGO VEÍCULO linha CÓDIGO VEÍCULO linha CÓDIGO VEÍCULO
		JLabel labcodvei = new JLabel("Veículo cod.");
		labcodvei.setFont(new Font("Tahoma", Font.BOLD, 24));
		labcodvei.setBounds(44, 94, 150, 35);
		frame.getContentPane().add(labcodvei);
				
		JLabel labcodveiform = new JLabel("formato 9999");
		labcodveiform.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labcodveiform.setBounds(44, 119, 150, 28);
		frame.getContentPane().add(labcodveiform);
			
		//JTextArea veicod = new JTextArea();
		veicod.setFont(new Font("Tahoma", Font.PLAIN, 16));
		veicod.setBounds(204, 105, 111, 35);
		frame.getContentPane().add(veicod);
		
// linha NOME VEÍCULO linha NOME VEÍCULO linha NOME VEÍCULO linha NOME VEÍCULO
		JLabel labnomevei = new JLabel("Nome");
		labnomevei.setFont(new Font("Tahoma", Font.BOLD, 24));
		labnomevei.setBounds(338, 94, 150, 35);
		frame.getContentPane().add(labnomevei);
				
		JLabel labnomeveiform = new JLabel("formato texto");
		labnomeveiform.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labnomeveiform.setBounds(338, 119, 150, 28);
		frame.getContentPane().add(labnomeveiform);
		
		JTextArea veinome = new JTextArea();
		veinome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		veinome.setBounds(445, 101, 485, 35);
		frame.getContentPane().add(veinome);		
		
// linha ANO VEÍCULO linha ANO VEÍCULO linha ANO VEÍCULO linha ANO VEÍCULO
		JLabel labcanovei = new JLabel("Ano");
		labcanovei.setFont(new Font("Tahoma", Font.BOLD, 24));
		labcanovei.setBounds(959, 94, 150, 35);
		frame.getContentPane().add(labcanovei);
				
		JLabel labanoveiform = new JLabel("formato 9999");
		labanoveiform.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labanoveiform.setBounds(959, 119, 150, 28);
		frame.getContentPane().add(labanoveiform);
			
		JTextArea veiano = new JTextArea();
		veiano.setFont(new Font("Tahoma", Font.PLAIN, 16));
		veiano.setBounds(1344, 105, 101, 35);
		frame.getContentPane().add(veiano);
		
// linha MODELO VEÍCULO linha MODELO VEÍCULO linha MODELO VEÍCULO linha MODELO VEÍCULO
		JLabel labcmodvei = new JLabel("Modelo");
		labcmodvei.setFont(new Font("Tahoma", Font.BOLD, 24));
		labcmodvei.setBounds(1223, 94, 150, 35);
		frame.getContentPane().add(labcmodvei);
				
		JLabel labmodveiform = new JLabel("formato 9999");
		labmodveiform.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labmodveiform.setBounds(1223, 119, 150, 28);
		frame.getContentPane().add(labmodveiform);
			
		JTextArea veimod = new JTextArea();
		veimod.setFont(new Font("Tahoma", Font.PLAIN, 16));
		veimod.setBounds(1079, 101, 111, 35);
		frame.getContentPane().add(veimod);
		
// linha MARCA VEÍCULO linha MARCA VEÍCULO linha MARCA VEÍCULO linha MARCA VEÍCULO
		JLabel labmarcavei = new JLabel("Marca");
		labmarcavei.setFont(new Font("Tahoma", Font.BOLD, 24));
		labmarcavei.setBounds(43, 152, 104, 35);
		frame.getContentPane().add(labmarcavei);
		
		JLabel labmarcaveiform = new JLabel("Selecione");
		labmarcaveiform.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labmarcaveiform.setBounds(43, 177, 104, 28);
		frame.getContentPane().add(labmarcaveiform);
		
		JTextArea veimarca = new JTextArea();
		veimarca.setFont(new Font("Tahoma", Font.PLAIN, 16));
		veimarca.setBounds(157, 162, 147, 35);
		frame.getContentPane().add(veimarca);
		
// linha CONDIÇÃO VEÍCULO linha CONDIÇÃO VEÍCULO linha CONDIÇÃO VEÍCULO linha CONDIÇÃO VEÍCULO
		JLabel labcondvei = new JLabel("Condição");
		labcondvei.setFont(new Font("Tahoma", Font.BOLD, 24));
		labcondvei.setBounds(349, 152, 150, 35);
		frame.getContentPane().add(labcondvei);
		
		JLabel labcondveiform = new JLabel("Selecione");
		labcondveiform.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labcondveiform.setBounds(349, 177, 150, 28);
		frame.getContentPane().add(labcondveiform);
		
		JTextArea veicond = new JTextArea();
		veicond.setFont(new Font("Tahoma", Font.PLAIN, 16));
		veicond.setBounds(473, 162, 160, 35);
		frame.getContentPane().add(veicond);		
		
// linha PLACA VEÍCULO linha PLACA VEÍCULO linha PLACA VEÍCULO linha PLACA VEÍCULO
		JLabel labplacavei = new JLabel("Placa");
		labplacavei.setFont(new Font("Tahoma", Font.BOLD, 24));
		labplacavei.setBounds(692, 155, 150, 35);
		frame.getContentPane().add(labplacavei);
		
		JLabel labplacaveiform = new JLabel("formato XXX-XXXX");
		labplacaveiform.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labplacaveiform.setBounds(692, 180, 150, 28);
		frame.getContentPane().add(labplacaveiform);
		
		JTextArea veiplaca = new JTextArea();
		veiplaca.setFont(new Font("Tahoma", Font.PLAIN, 16));
		veiplaca.setBounds(852, 162, 150, 35);
		frame.getContentPane().add(veiplaca);
		
// linha QUILOMETRAGEM VEÍCULO linha QUILOMETRAGEM VEÍCULO linha QUILOMETRAGEM VEÍCULO
		JLabel labkmvei = new JLabel("Quilometragem");
		labkmvei.setFont(new Font("Tahoma", Font.BOLD, 24));
		labkmvei.setBounds(1076, 155, 201, 35);
		frame.getContentPane().add(labkmvei);
		
		JLabel labkmveiform = new JLabel("formato 999.999");
		labkmveiform.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labkmveiform.setBounds(1076, 180, 150, 28);
		frame.getContentPane().add(labkmveiform);
		
		JTextArea veikm = new JTextArea();
		veikm.setFont(new Font("Tahoma", Font.PLAIN, 16));
		veikm.setBounds(1298, 158, 147, 35);
		frame.getContentPane().add(veikm);
		
// linha COMBUSTÍVEL VEÍCULO linha COMBUSTÍVEL VEÍCULO linha COMBUSTÍVEL VEÍCULO	
		JLabel lblCombvei = new JLabel("Combustível");
		lblCombvei.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblCombvei.setBounds(44, 213, 150, 35);
		frame.getContentPane().add(lblCombvei);
		
		JLabel labcombveiform = new JLabel("Selecione");
		labcombveiform.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labcombveiform.setBounds(44, 238, 150, 28);
		frame.getContentPane().add(labcombveiform);
		
		JTextArea veicomb = new JTextArea();
		veicomb.setFont(new Font("Tahoma", Font.PLAIN, 18));
		veicomb.setBounds(223, 220, 148, 35);
		frame.getContentPane().add(veicomb);
		
// linha CÂMBIO VEÍCULO linha CÂMBIO VEÍCULO linha CÂMBIO VEÍCULO linha CÂMBIO VEÍCULO
		JLabel labcambvei = new JLabel("Câmbio");
		labcambvei.setFont(new Font("Tahoma", Font.BOLD, 24));
		labcambvei.setBounds(456, 213, 150, 35);
		frame.getContentPane().add(labcambvei);
		
		JLabel labcambveiform = new JLabel("Selecione");
		labcambveiform.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labcambveiform.setBounds(456, 238, 150, 28);
		frame.getContentPane().add(labcambveiform);
		
		JTextArea veicamb = new JTextArea();
		veicamb.setFont(new Font("Tahoma", Font.PLAIN, 18));
		veicamb.setBounds(570, 220, 150, 35);
		frame.getContentPane().add(veicamb);
		
// linha CARROCERIA VEÍCULO linha CARROCERIA VEÍCULO linha CARROCERIA VEÍCULO	
		JLabel labcarrocvei = new JLabel("Carroceria");
		labcarrocvei.setFont(new Font("Tahoma", Font.BOLD, 24));
		labcarrocvei.setBounds(819, 213, 150, 35);
		frame.getContentPane().add(labcarrocvei);
		
		JLabel labcarrocveiform = new JLabel("Selecione");
		labcarrocveiform.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labcarrocveiform.setBounds(819, 238, 150, 28);
		frame.getContentPane().add(labcarrocveiform);
		
		JTextArea veicarroc = new JTextArea();
		veicarroc.setFont(new Font("Tahoma", Font.PLAIN, 18));
		veicarroc.setBounds(971, 220, 150, 35);
		frame.getContentPane().add(veicarroc);
		
// linha COR VEÍCULO linha COR VEÍCULO linha COR VEÍCULO linha COR VEÍCULO	
		JLabel labcorvei = new JLabel("Cor");
		labcorvei.setFont(new Font("Tahoma", Font.BOLD, 24));
		labcorvei.setBounds(1195, 213, 150, 35);
		frame.getContentPane().add(labcorvei);
		
		JLabel labcorveiform = new JLabel("Selecione");
		labcorveiform.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labcorveiform.setBounds(1195, 238, 150, 28);
		frame.getContentPane().add(labcorveiform);
		
		JTextArea veicor = new JTextArea();
		veicor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		veicor.setBounds(1295, 220, 150, 35);
		frame.getContentPane().add(veicor);
		
// linha ACESSÓRIOS NO VEÍCULO linha ACESSÓRIOS NO VEÍCULO linha ACESSÓRIOS NO VEÍCULO
		JLabel labasvei = new JLabel("Acessórios");
		labasvei.setFont(new Font("Tahoma", Font.BOLD, 24));
		labasvei.setBounds(43, 277, 150, 35);
		frame.getContentPane().add(labasvei);
		
		JTextArea cliasform = new JTextArea();
		cliasform.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cliasform.setBounds(213, 277, 514, 35);
		frame.getContentPane().add(cliasform);
		
// linha CLIENTES INTERESSADOS linha CLIENTES INTERESSADOS linha CLIENTES INTERESSADOS
		JLabel labclivei = new JLabel("Clientes");
		labclivei.setFont(new Font("Tahoma", Font.BOLD, 24));
		labclivei.setBounds(787, 278, 150, 35);
		frame.getContentPane().add(labclivei);
		
		JTextArea cliveiform = new JTextArea();
		cliveiform.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cliveiform.setBounds(931, 278, 514, 35);
		frame.getContentPane().add(cliveiform);
		
// linha MAIS SOBRE O VEÍCULO linha MAIS SOBRE O VEÍCULO linha MAIS SOBRE O VEÍCULO
		JLabel labmaisvei = new JLabel("Mais sobre o Veículo");
		labmaisvei.setFont(new Font("Tahoma", Font.BOLD, 24));
		labmaisvei.setBounds(43, 324, 262, 35);
		frame.getContentPane().add(labmaisvei);
		
		JTextArea maisvei = new JTextArea();
		maisvei.setFont(new Font("Tahoma", Font.PLAIN, 16));
		maisvei.setBounds(45, 361, 1400, 139);
		frame.getContentPane().add(maisvei);
				
// linha BOTÃO SALVAR linha BOTÃO SALVAR linha BOTÃO SALVAR	 linha BOTÃO SALVAR	
		JButton btnclisalvar = new JButton("Salvar");
		btnclisalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conini tel = new conini();
				tel.visivel();
				frame.dispose();
				}
			});
			btnclisalvar.setFont(new Font("Tahoma", Font.BOLD, 36));
			btnclisalvar.setBounds(292, 636, 223, 53);
			frame.getContentPane().add(btnclisalvar);

// linha BOTÃO EXCLUIR linha BOTÃO EXCLUIR linha BOTÃO EXCLUIR linha BOTÃO EXCLUIR
		JButton btncliExcluir = new JButton("Excluir");
		btncliExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conini tel = new conini();
				tel.visivel();
				frame.dispose();
			}
		});
		btncliExcluir.setFont(new Font("Tahoma", Font.BOLD, 36));
		btncliExcluir.setBounds(630, 636, 223, 53);
		frame.getContentPane().add(btncliExcluir);
				
// linha BOTÂO VOLTAR linha BOTÂO VOLTAR linha BOTÂO VOLTAR linha BOTÂO VOLTAR
		JButton btnclivoltar = new JButton("Voltar");
		btnclivoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conini tel = new conini();
				tel.visivel();
				frame.dispose();
			}
		});
		btnclivoltar.setFont(new Font("Tahoma", Font.BOLD, 36));
		btnclivoltar.setBounds(948, 636, 223, 53);
		frame.getContentPane().add(btnclivoltar);
		
// linha GALERIA linha GALERIA linha GALERIA linha GALERIA linha GALERIA linha GALERIA
		JLabel labgalvei = new JLabel("Galeria");
		labgalvei.setFont(new Font("Tahoma", Font.BOLD, 36));
		labgalvei.setBounds(88, 526, 150, 35);
		frame.getContentPane().add(labgalvei);
		
		JTextArea maisvei_1 = new JTextArea();
		maisvei_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		maisvei_1.setBounds(276, 511, 1169, 114);
		frame.getContentPane().add(maisvei_1);
		
// linha BOTÃO EDITAR GALERIA linha BOTÃO EDITAR GALERIA linha BOTÃO EDITAR GALERIA
		JButton btngalvei = new JButton("Editar");
		btnclivoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conini tel = new conini();
				tel.visivel();
				frame.dispose();
			}
		});btngalvei.setFont(new Font("Tahoma", Font.BOLD, 36));
		btngalvei.setBounds(43, 572, 223, 53);
		frame.getContentPane().add(btngalvei);
	}

}
