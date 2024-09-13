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

public class concon {
// armazena a conexão
	private Connection connection = null;

// armazena as consultas
	private Statement statement = null;

// armazena os resultados
	private ResultSet resultset = null;

	public void conectar() {

// caminho
		String servidor = "jdbc:mysql://localhost:3306/Concessionaria";

// usuario
		String usuario = "root";

// senha
		String senha = "arley911";

// local driver instalado
		String driver = "com.mysql.cj.jdbc.Driver";
		try {

// acessa o driver
			Class.forName(driver);
			this.connection = DriverManager.getConnection(servidor, usuario, senha);

// consultas
			this.statement = this.connection.createStatement();
		} catch (Exception e) {
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
	
	private JFormattedTextField concod;
	private JTextArea connome;
	private JFormattedTextField conadcli;
	private JFormattedTextField conexcli;
	private JFormattedTextField conadvei;
	private JFormattedTextField conexvei;
	
// lança a APLICAÇÃO lança a APLICAÇÃO lança a APLICAÇÃO lança a APLICAÇÃO	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					concon window = new concon();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

// cria a APLICAÇÃO cria a APLICAÇÃO cria a APLICAÇÃO cria a APLICAÇÃO
	public concon() {
		initialize();
	}

// deixa a JANELA VISIVEL QUANDO CHAMADA deixa a JANELA VISIVEL QUANDO CHAMADA
	public void visivel() {
		concon windows = new concon();
		windows.frame.setVisible(true);
	}
	
// inicia a JANELA inicia a JANELA inicia a JANELA inicia a JANELA
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1011, 609);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
// MÁSCARAS MÁSCARAS MÁSCARAS MÁSCARAS MÁSCARAS MÁSCARAS MÁSCARAS MÁSCARAS MÁSCARAS
		NumberFormat numberFormat = NumberFormat.getIntegerInstance();
        NumberFormatter numberFormatter = new NumberFormatter(numberFormat);
        numberFormatter.setAllowsInvalid(false);
        try {
		    MaskFormatter mask = new MaskFormatter("####");
		    concod = new JFormattedTextField(mask);
		    conadcli = new JFormattedTextField(mask);
			conexcli = new JFormattedTextField(mask);
			conadvei = new JFormattedTextField(mask);
			conexvei = new JFormattedTextField(mask);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO na formatação de Campos", "erro", JOptionPane.ERROR_MESSAGE);
		}

// label janela CONSULTOR label janela CONSULTOR label janela CONSULTOR
		JLabel labcli = new JLabel("Consultor");
		labcli.setFont(new Font("Tahoma", Font.BOLD, 50));
		labcli.setBounds(45, 33, 293, 61);
		frame.getContentPane().add(labcli);
		
// label janela SysCon label janela SysCon label janela SysCon
		JLabel lablogo = new JLabel("SysCon");
		lablogo.setFont(new Font("Tahoma", Font.BOLD, 50));
		lablogo.setBounds(758, 33, 183, 61);
		frame.getContentPane().add(lablogo);

// linha CÓDIGO DO CONSULTOR linha CÓDIGO DO CONSULTOR linha CÓDIGO DO CONSULTOR
		JLabel labcodcon = new JLabel("Código");
		labcodcon.setFont(new Font("Tahoma", Font.BOLD, 24));
		labcodcon.setBounds(45, 114, 150, 35);
		frame.getContentPane().add(labcodcon);
		
		JLabel labcodconform = new JLabel("formato 9999");
		labcodconform.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labcodconform.setBounds(45, 139, 150, 28);
		frame.getContentPane().add(labcodconform);
		
		//concod = new JTextArea();
		concod.setFont(new Font("Tahoma", Font.PLAIN, 18));
		concod.setBounds(180, 125, 104, 35);
		frame.getContentPane().add(concod);
		concod.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				//String id = concod.getText();
				atualizarInformacoes(concod.getText());
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				atualizarInformacoes(concod.getText());
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				atualizarInformacoes(concod.getText());
			}
		});

// linha NOME CONSULTOR linha NOME CONSULTOR linha NOME CONSULTOR
		JLabel labnomecon = new JLabel("Nome");
		labnomecon.setFont(new Font("Tahoma", Font.BOLD, 24));
		labnomecon.setBounds(45, 167, 150, 35);
		frame.getContentPane().add(labnomecon);
		
		JLabel labnomeconform = new JLabel("formato texto");
		labnomeconform.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labnomeconform.setBounds(45, 192, 150, 28);
		frame.getContentPane().add(labnomeconform);
		
		JTextArea connome = new JTextArea();
		connome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		connome.setBounds(180, 178, 761, 35);
		frame.getContentPane().add(connome);
				
// linha de CLIENTES linha de CLIENTES linha de CLIENTES linha de CLIENTES
		JLabel labclicon = new JLabel("Clientes");
		labclicon.setFont(new Font("Tahoma", Font.BOLD, 24));
		labclicon.setBounds(44, 231, 183, 35);
		frame.getContentPane().add(labclicon);
				
		JLabel labcliconform = new JLabel("formato texto");
		labcliconform.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labcliconform.setBounds(44, 256, 203, 28);
		frame.getContentPane().add(labcliconform);
		
		JTextArea clicon = new JTextArea();
		clicon.setFont(new Font("Tahoma", Font.PLAIN, 18));
		clicon.setBounds(228, 238, 713, 35);
		frame.getContentPane().add(clicon);
					
// linha ADICIONAR CLIENTE linha ADICIONAR CLIENTE linha ADICIONAR CLIENTE
		JLabel labadclicon = new JLabel("Adicionar Cliente");
		labadclicon.setFont(new Font("Tahoma", Font.BOLD, 24));
		labadclicon.setBounds(42, 288, 230, 35);
		frame.getContentPane().add(labadclicon);
		
		JLabel labadveiconform = new JLabel("formato 9999");
		labadveiconform.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labadveiconform.setBounds(42, 313, 150, 28);
		frame.getContentPane().add(labadveiconform);
		
		//JTextArea conadcli = new JTextArea();
		conadcli.setFont(new Font("Tahoma", Font.PLAIN, 18));
		conadcli.setBounds(180, 125, 104, 35);
		frame.getContentPane().add(conadcli);
						
// linha EXCLUIR CLIENTE linha ADICIONAR CLIENTE linha EXCLUIR CLIENTE	
		JLabel labexclicon = new JLabel("Excluir Cliente");
		labexclicon.setFont(new Font("Tahoma", Font.BOLD, 24));
		labexclicon.setBounds(585, 281, 230, 35);
		frame.getContentPane().add(labexclicon);
		
		JLabel labexcliconform = new JLabel("formato 9999");
		labexcliconform.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labexcliconform.setBounds(585, 306, 150, 28);
		frame.getContentPane().add(labexcliconform);
		
		//JTextArea conexcli = new JTextArea();
		conexcli.setFont(new Font("Tahoma", Font.PLAIN, 18));
		conexcli.setBounds(791, 292, 150, 35);
		frame.getContentPane().add(conexcli);

// linha de VEÍCULOS linha de VEÍCULOS linha de VEÍCULOS linha de VEÍCULOS
		JLabel labveias = new JLabel("Veículos");
		labveias.setFont(new Font("Tahoma", Font.BOLD, 24));
		labveias.setBounds(44, 339, 183, 35);
		frame.getContentPane().add(labveias);
		
		JLabel labveiasform = new JLabel("formato texto");
		labveiasform.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labveiasform.setBounds(44, 364, 203, 28);
		frame.getContentPane().add(labveiasform);
				
		JTextArea asvei = new JTextArea();
		asvei.setFont(new Font("Tahoma", Font.PLAIN, 18));
		asvei.setBounds(228, 350, 713, 35);
		frame.getContentPane().add(asvei);
		
// linha ADICIONAR VEÍCULOS linha ADICIONAR VEÍCULOS linha ADICIONAR VEÍCULOS	
		JLabel labadveias = new JLabel("Adicionar Veículo");
		labadveias.setFont(new Font("Tahoma", Font.BOLD, 24));
		labadveias.setBounds(42, 396, 230, 35);
		frame.getContentPane().add(labadveias);
				
		JLabel labadveiasform = new JLabel("formato 9999");
		labadveiasform.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labadveiasform.setBounds(42, 421, 150, 28);
		frame.getContentPane().add(labadveiasform);
		
		//JTextArea conadvei = new JTextArea();
		conadvei.setFont(new Font("Tahoma", Font.PLAIN, 18));
		conadvei.setBounds(260, 407, 150, 35);
		frame.getContentPane().add(conadvei);
		
// linha EXCLUIR VEÍCULOS linha ADICIONAR VEÍCULOS linha EXCLUIR VEÍCULOS	
		JLabel labexcveias = new JLabel("Excluir Veículo");
		labexcveias.setFont(new Font("Tahoma", Font.BOLD, 24));
		labexcveias.setBounds(585, 396, 230, 35);
		frame.getContentPane().add(labexcveias);
		
		JLabel labexcveiform = new JLabel("formato 9999");
		labexcveiform.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labexcveiform.setBounds(585, 421, 150, 28);
		frame.getContentPane().add(labexcveiform);
		
		//JTextArea conexvei = new JTextArea();
		conexvei.setFont(new Font("Tahoma", Font.PLAIN, 18));
		conexvei.setBounds(791, 407, 150, 35);
		frame.getContentPane().add(conexvei);
		
// linha BOTÃO SALVAR linha BOTÃO SALVAR linha BOTÃO SALVAR	 linha BOTÃO SALVAR	
		JButton btnassalvar = new JButton("Salvar");
		btnassalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = concod.getText();
				String nome = connome.getText();
				if(verificarContato(id)) {
					editarContato(id,nome);
				}else {
					inserirContato(id,nome);
				}
			}
		});
		btnassalvar.setFont(new Font("Tahoma", Font.BOLD, 36));
		btnassalvar.setBounds(45, 483, 223, 53);
		frame.getContentPane().add(btnassalvar);

// linha BOTÃO EXCLUIR linha BOTÃO EXCLUIR linha BOTÃO EXCLUIR linha BOTÃO EXCLUIR
		JButton btnasexcluir = new JButton("Excluir");
		btnasexcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = concod.getText();
				apagarContato(id);
				connome.setText("");
			}
		});
		btnasexcluir.setFont(new Font("Tahoma", Font.BOLD, 36));
		btnasexcluir.setBounds(383, 483, 223, 53);
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
		btnasvoltar.setBounds(718, 483, 223, 53);
		frame.getContentPane().add(btnasvoltar);		
	}
	
// BUSCAR BANCO DE DADOS E IMPRIMIR BUSCAR BANCO DE DADOS E IMPRIMIR
	public void atualizarInformacoes(String id) {
	try {
		String query = "Select con_nome from COnsultor where con_id= '"+id+"'";
		this.resultset = this.statement.executeQuery(query);
		while (this.resultset.next()) {
			String nome = this.resultset.getString("con_nome");
			acenome.setText(nome);
			}
		} catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
		}
	}
// EDITAR DADOS EDITAR DADOS EDITAR DADOS EDITAR DADOS EDITAR DADOS EDITAR DADOS
	public void editarContato(String con_id,String con_nome) {
		try {
			
// aspas simple que � usado no mysql
			String query = "update Consultor set con_nome ='"+connome+"' where con_id = '"+concod+"'";
			this.statement.executeUpdate(query);
		}catch(Exception e) {
			System.out.println("ERROR: "+e.getMessage());
			}
		}
			
// APAGAR ACESSORIO APAGAR ACESSORIO APAGAR ACESSORIO APAGAR ACESSORIO APAGAR ACESSORIO
	public void apagarContato(String id) {
		try {
//aspas simple que � usado no mysql
			String query = "delete from Consultor where ace_id ='"+id+"'";
			this.statement.executeUpdate(query);
		}catch(Exception e) {
			System.out.println("ERROR: "+e.getMessage());
		}
	}
		
// CADASTRAR OU ALTERAR O ACESSORIO CADASTRAR OU ALTERAR O ACESSORIO	
	public boolean verificarContato(String id) {
		try {
			String query = "Select * from Consultor where con_id = '"+id+"'";
			this.resultset = this.statement.executeQuery(query);
			while (this.resultset.next()) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
		}
		return false;
	}
	public void inserirContato(String id, String nome) {
		try {
	//aspas simple que � usado no mysql
	String query = "insert into acessorios con_id,con_nome) values ('"+id+"','"+nome+"')";
		this.statement.executeUpdate(query);
		}catch(Exception e) {
			System.out.println("ERROR: "+e.getMessage());
		}
	}
		
		
		
	
	
	
		
		
}
