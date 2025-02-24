package Concessionaria;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.NumberFormat;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

public class convei {
	
	//armazena a conexão	
		private Connection connection = null;

	//armazena as consultas
		private Statement statement = null;

	//armazena os resultados
		private ResultSet resultset = null;

		public void conectar() {

	//caminho
		String servidor = "jdbc:mysql://localhost:3306/Concessionaria";

	//usuario
		String usuario = "root";

	//senha
		String senha = "arley911";

	//local driver instalado
		String driver = "com.mysql.cj.jdbc.Driver";
		try {

	//acessa o driver
			Class.forName(driver);
				this.connection = DriverManager.getConnection(servidor, usuario, senha);

	//consultas
				this.statement = this.connection.createStatement();
			}catch (Exception e) {
				System.out.println("ERROR: " + e.getMessage());
			}
		}

		public boolean estaConectado() {
			if (this.connection != null) {
				return true;
			} else {
				return false;
			}
		}
	
// DEFININDO CAMPOS DEFININDO CAMPOS DEFININDO CAMPOS DEFININDO CAMPOS
	private JFrame frame;
	
	private JFormattedTextField veicod;
	private JTextArea veinome;
	private JFormattedTextField veiano;
	private JFormattedTextField veimod;
	private JTextArea veimarca;
	private JTextArea veicondicao;
	private JTextArea veicombustivel;
	private JTextArea veicambio;
	private JTextArea veicarroc;
	private JTextArea veicor;
	private JTextArea veidescr;
	private JFormattedTextField veiplaca;
	private JFormattedTextField veikm;
	//private JFormattedTextField cadveicli;
	
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
		conectar();
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
		    veiano = new JFormattedTextField(mask);
			veimod = new JFormattedTextField(mask);
			MaskFormatter mask1 = new MaskFormatter("***-****");
			veiplaca = new JFormattedTextField(mask1);
			MaskFormatter mask2 = new MaskFormatter("###.###");
			veikm = new JFormattedTextField(mask2);
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
		veicod.getDocument().addDocumentListener(new DocumentListener(){
			@Override
			public void insertUpdate(DocumentEvent e) {
			//String id = veicod.getText();
				atualizarInformacoes(veicod.getText());
			}
			@Override
			public void removeUpdate(DocumentEvent e) {
				atualizarInformacoes(veicod.getText());
			}
			@Override
			public void changedUpdate(DocumentEvent e) {
				atualizarInformacoes(veicod.getText());
			}
		});
		
// linha NOME VEÍCULO linha NOME VEÍCULO linha NOME VEÍCULO linha NOME VEÍCULO
		JLabel labnomevei = new JLabel("Nome");
		labnomevei.setFont(new Font("Tahoma", Font.BOLD, 24));
		labnomevei.setBounds(338, 94, 150, 35);
		frame.getContentPane().add(labnomevei);
				
		JLabel labnomeveiform = new JLabel("formato texto");
		labnomeveiform.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labnomeveiform.setBounds(338, 119, 150, 28);
		frame.getContentPane().add(labnomeveiform);
		
		veinome = new JTextArea();
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
			
		//veiano = new JTextArea();
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
			
		//veimod = new JTextArea();
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
		
		veimarca = new JTextArea();
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
		
		veicondicao = new JTextArea();
		veicondicao.setFont(new Font("Tahoma", Font.PLAIN, 16));
		veicondicao.setBounds(473, 162, 160, 35);
		frame.getContentPane().add(veicondicao);		
		
// linha PLACA VEÍCULO linha PLACA VEÍCULO linha PLACA VEÍCULO linha PLACA VEÍCULO
		JLabel labplacavei = new JLabel("Placa");
		labplacavei.setFont(new Font("Tahoma", Font.BOLD, 24));
		labplacavei.setBounds(692, 155, 150, 35);
		frame.getContentPane().add(labplacavei);
		
		JLabel labplacaveiform = new JLabel("formato XXX-XXXX");
		labplacaveiform.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labplacaveiform.setBounds(692, 180, 150, 28);
		frame.getContentPane().add(labplacaveiform);
		
		//veiplaca = new JTextArea();
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
		
		//veikm = new JTextArea();
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
		
		veicombustivel = new JTextArea();
		veicombustivel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		veicombustivel.setBounds(223, 220, 148, 35);
		frame.getContentPane().add(veicombustivel);
		
// linha CÂMBIO VEÍCULO linha CÂMBIO VEÍCULO linha CÂMBIO VEÍCULO linha CÂMBIO VEÍCULO
		JLabel labcambvei = new JLabel("Câmbio");
		labcambvei.setFont(new Font("Tahoma", Font.BOLD, 24));
		labcambvei.setBounds(456, 213, 150, 35);
		frame.getContentPane().add(labcambvei);
		
		JLabel labcambveiform = new JLabel("Selecione");
		labcambveiform.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labcambveiform.setBounds(456, 238, 150, 28);
		frame.getContentPane().add(labcambveiform);
		
		veicambio = new JTextArea();
		veicambio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		veicambio.setBounds(570, 220, 150, 35);
		frame.getContentPane().add(veicambio);
		
// linha CARROCERIA VEÍCULO linha CARROCERIA VEÍCULO linha CARROCERIA VEÍCULO	
		JLabel labcarrocvei = new JLabel("Carroceria");
		labcarrocvei.setFont(new Font("Tahoma", Font.BOLD, 24));
		labcarrocvei.setBounds(819, 213, 150, 35);
		frame.getContentPane().add(labcarrocvei);
		
		JLabel labcarrocveiform = new JLabel("Selecione");
		labcarrocveiform.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labcarrocveiform.setBounds(819, 238, 150, 28);
		frame.getContentPane().add(labcarrocveiform);
		
		veicarroc = new JTextArea();
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
		
		veicor = new JTextArea();
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
		
		veidescr = new JTextArea();
		veidescr.setFont(new Font("Tahoma", Font.PLAIN, 18));
		veidescr.setBounds(45, 361, 1400, 139);
		frame.getContentPane().add(veidescr);
						
// linha BOTÃO SALVAR linha BOTÃO SALVAR linha BOTÃO SALVAR	 linha BOTÃO SALVAR	
		JButton btnclisalvar = new JButton("Salvar");
		btnclisalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = veicod.getText();
				String nome = veinome.getText();
				String ano = veiano.getText();
				String mod = veimod.getText();
				String marca = veimarca.getText();
				String condicao = veicondicao.getText();
				String placa = veiplaca.getText();
				String km = veikm.getText();
				String combustivel = veicombustivel.getText();
				String cambio = veicambio.getText();
				String carroc = veicarroc.getText();
				String cor = veicor.getText();
				String descricao = veidescr.getText();
				if(verificarContato(id)) {
					editarContato(id,nome,ano,mod,marca,condicao,placa,km,combustivel,cambio,carroc,cor,descricao);
				}else {
					inserirContato(id,nome,ano,mod,marca,condicao,placa,km,combustivel,cambio,carroc,cor,descricao);
				}
			}
			});
			btnclisalvar.setFont(new Font("Tahoma", Font.BOLD, 36));
			btnclisalvar.setBounds(292, 636, 223, 53);
			frame.getContentPane().add(btnclisalvar);

// linha BOTÃO EXCLUIR linha BOTÃO EXCLUIR linha BOTÃO EXCLUIR linha BOTÃO EXCLUIR
		JButton btncliExcluir = new JButton("Excluir");
		btncliExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = veicod.getText();
				apagarContato(id);
				veinome.setText("");
				veiano.setText("");
				veimod.setText("");
				veimarca.setText("");
				veicondicao.setText("");
				veiplaca.setText("");
				veikm.setText("");
				veicombustivel.setText("");
				veicambio.setText("");
				veicarroc.setText("");
				veicor.setText("");
				veidescr.setText("");
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

	
	
// BUSCAR BANCO DE DADOS E IMPRIMIR BUSCAR BANCO DE DADOS E IMPRIMIR
	public void atualizarInformacoes(String id) {
		try {
			String query = "Select vei_nome,vei_ano,vei_mod,vei_marca,"
				+ "vei_condicao,vei_placa,vei_km,vei_combustivel,"
				+ "vei_cambio,vei_carroc,vei_cor,vei_descricao"
				+ " from Veiculo where vei_id = '"+id+"'";
			this.resultset = this.statement.executeQuery(query);
			while (this.resultset.next()) {
				String nome = this.resultset.getString("vei_nome");
				veinome.setText(nome);
				String ano =this.resultset.getString("vei_ano");
				veiano.setText(ano);
				String mod = this.resultset.getString("vei_mod");
				veimod.setText(mod);
				String marca = this.resultset.getString("vei_marca");
				veimarca.setText(marca);
				String condicao = this.resultset.getString("vei_condicao");
				veicondicao.setText(condicao);				
				String placa = this.resultset.getString("vei_placa");
				veiplaca.setText(placa);
				String km = this.resultset.getString("vei_km");
				veikm.setText(km);
				String combustivel = this.resultset.getString("vei_combustivel");
				veicombustivel.setText(combustivel);
				String cambio = this.resultset.getString("vei_cambio");
				veicambio.setText(cambio);
				String carroc = this.resultset.getString("vei_carroc");
				veicarroc.setText(carroc);
				String cor = this.resultset.getString("vei_cor");
				veicor.setText(cor);
				String descicao =this.resultset.getString("vei_descricao");
				veidescr.setText(descicao);
				}
		} catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
		}
	}

// CADASTRAR OU ALTERAR O CLIENTE CADASTRAR OU ALTERAR O CLIENTE	
	public boolean verificarContato(String id) {
		try {
			String query = "Select * from Veiculo where vei_id = '"+id+"'";
			this.resultset = this.statement.executeQuery(query);
			while (this.resultset.next()) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
		}
		return false;
	}
	public void inserirContato(String id, String nome, String ano, String mod, 
			String marca, String condicao, String placa, String km, String combustivel,
			String cambio, String carroc, String cor, String descricao) {
		try {
		//aspas simple que � usado no mysql
			String query = "insert into Veiculo(vei_id,vei_nome,vei_ano,vei_mod, vei_marca,vei_condicao,vei_placa,vei_km,vei_combustrivel,vei_cambio,vei_carroc,vei_cor,vei_descricao) values "
					+ "('"+id+"','"+nome+"','"+ano+"','"+mod+"','"+marca+"','"+condicao+"','"+placa+"','"+km+"','"+combustivel+"','"+cambio+"','"+carroc+"','"+cor+"','"+descricao+"')";
			this.statement.executeUpdate(query);
		}catch(Exception e) {
			System.out.println("ERROR: "+e.getMessage());
		}
	}

// EDITAR DADOS EDITAR DADOS EDITAR DADOS EDITAR DADOS EDITAR DADOS EDITAR DADOS
	public void editarContato(String vei_id, String vei_nome, String vei_ano, String vei_mod, 
			String vei_marca, String vei_condicao, String vei_placa, String vei_km, String vei_combustivel,
			String vei_cambio, String vei_carroc, String vei_cor, String vei_descricao) {
		try {
			
		// aspas simple que � usado no mysql
			String query = "update veiculo vei_nome = '"+vei_nome+"',vei_ano = '"+vei_ano+"',vei_mod = '"+vei_mod+"',vei_marca = '"+vei_marca+"',vei_condicao = '"+vei_condicao+"',vei_placa = '"+vei_placa+"',vei_km = '"+vei_km+"',vei_combustivel = '"+vei_combustivel+"',vei_cambio = '"+vei_cambio+"',vei_carroc = '"+vei_carroc+"',vei_cor = '"+vei_cor+"',vei_descricao = '"+vei_descricao+"' where vei_id = '"+vei_id+"'";
			this.statement.executeUpdate(query);
		}catch(Exception e) {
			System.out.println("ERROR: "+e.getMessage());
			}
		}
	
// APAGAR VEICULO APAGAR VEICULO APAGAR VEICULO APAGAR VEICULO APAGAR VEICULO
	public void apagarContato(String id) {
		try {
	//aspas simple que � usado no mysql
			String query = "delete from veiculo where vei_id ='"+id+"'";
			this.statement.executeUpdate(query);
		}catch(Exception e) {
			System.out.println("ERROR: "+e.getMessage());
		}
	}	
	
	
}
