package Concessionaria;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class concli {

	private JFrame frame;

// CONECTANDO COM O BANCO DE DADOS
	private Connection conn;

// RECEBE A CONEXÃO
	public concli(Connection conn) {
		this.conn = conn;
		initialize();
	}

// DEFININDO CAMPOS DEFININDO CAMPOS DEFININDO CAMPOS DEFININDO CAMPOS
	private JFormattedTextField clicod;
	private JFormattedTextField concod;
	private JFormattedTextField clicpf;
	private JFormattedTextField cliwhats;
	private JFormattedTextField excveicli;
	private JFormattedTextField cadveicli;

// lança a APLICAÇÃO lança a APLICAÇÃO lança a APLICAÇÃO lança a APLICAÇÃO	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					concli window = new concli();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

// cria a APLICAÇÃO cria a APLICAÇÃO cria a APLICAÇÃO cria a APLICAÇÃO
	public concli() {
		initialize();
	}

// deixa a JANELA VISIVEL QUANDO CHAMADA deixa a JANELA VISIVEL QUANDO CHAMADA
	public void visivel() {
		concli window = new concli();
		window.frame.setVisible(true);
	}

// inicia a JANELA inicia a JANELA inicia a JANELA inicia a JANELA inicia a JANELA
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1011, 571);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
// MÁSCARAS MÁSCARAS MÁSCARAS MÁSCARAS MÁSCARAS MÁSCARAS MÁSCARAS MÁSCARAS MÁSCARAS
		NumberFormat numberFormat = NumberFormat.getIntegerInstance();
        NumberFormatter numberFormatter = new NumberFormatter(numberFormat);
        numberFormatter.setAllowsInvalid(false);
        try {
		    MaskFormatter mask = new MaskFormatter("####");
			clicod = new JFormattedTextField(mask);
			MaskFormatter mask1 = new MaskFormatter("####");
			concod = new JFormattedTextField(mask1);
			MaskFormatter mask2 = new MaskFormatter("###.###.###-##");
			clicpf = new JFormattedTextField(mask2);
			MaskFormatter mask3 = new MaskFormatter("(##) 9.####-####");
			cliwhats = new JFormattedTextField(mask3);
			MaskFormatter mask4 = new MaskFormatter("####");
			excveicli = new JFormattedTextField(mask4);
			MaskFormatter mask6 = new MaskFormatter("####");
			cadveicli = new JFormattedTextField(mask6);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO na formatação de Campos", "erro", JOptionPane.ERROR_MESSAGE);
		}		

// label janela CLIENTE label janela CLIENTE label janela CLIENTE
		JLabel labcli = new JLabel("Cliente");
		labcli.setFont(new Font("Tahoma", Font.BOLD, 50));
		labcli.setBounds(45, 33, 183, 61);
		frame.getContentPane().add(labcli);
		
// label janela SysCon label janela SysCon label janela SysCon
		JLabel lablogo = new JLabel("SysCon");
		lablogo.setFont(new Font("Tahoma", Font.BOLD, 50));
		lablogo.setBounds(758, 33, 183, 61);
		frame.getContentPane().add(lablogo);
		
// linha CÓDIGO DO CLIENTE linha CÓDIGO DO CLIENTE linha CÓDIGO DO CLIENTE
		JLabel labcodcli = new JLabel("Cliente cod.");
		labcodcli.setFont(new Font("Tahoma", Font.BOLD, 24));
		labcodcli.setBounds(45, 114, 150, 35);
		frame.getContentPane().add(labcodcli);
		
		JLabel labcodcliform = new JLabel("formato 9999");
		labcodcliform.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labcodcliform.setBounds(45, 139, 150, 28);
		frame.getContentPane().add(labcodcliform);
		
		//JTextArea clicod = new JTextArea();
		clicod.setFont(new Font("Tahoma", Font.PLAIN, 18));
		clicod.setBounds(229, 125, 160, 35);
		frame.getContentPane().add(clicod);
		
// linha CONSULTOR CLIENTE linha CONSULTOR CLIENTE linha CONSULTOR CLIENTE	
		JLabel labconcli = new JLabel("Consultor");
		labconcli.setFont(new Font("Tahoma", Font.BOLD, 24));
		labconcli.setBounds(597, 105, 183, 35);
		frame.getContentPane().add(labconcli);
		
		JLabel labconcliform = new JLabel("formato 9999");
		labconcliform.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labconcliform.setBounds(597, 130, 203, 28);
		frame.getContentPane().add(labconcliform);
		
		//JTextArea concod = new JTextArea();
		concod.setFont(new Font("Tahoma", Font.PLAIN, 18));
		concod.setBounds(781, 116, 160, 35);
		frame.getContentPane().add(concod);	
		
// linha NOME CLIENTE linha NOME CLIENTE linha NOME CLIENTE linha NOME CLIENTE
		JLabel labnomecli = new JLabel("Nome");
		labnomecli.setFont(new Font("Tahoma", Font.BOLD, 24));
		labnomecli.setBounds(45, 167, 150, 35);
		frame.getContentPane().add(labnomecli);
		
		JLabel labnomecliform = new JLabel("formato texto");
		labnomecliform.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labnomecliform.setBounds(45, 192, 150, 28);
		frame.getContentPane().add(labnomecliform);
		
		JTextArea clinome = new JTextArea();
		clinome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		clinome.setBounds(229, 178, 712, 35);
		frame.getContentPane().add(clinome);
		
// linha WHATS CLIENTE linha WHATS CLIENTE linha WHATS CLIENTE linha WHATS CLIENTE
		JLabel labwhatscli = new JLabel("WhatsApp");
		labwhatscli.setFont(new Font("Tahoma", Font.BOLD, 24));
		labwhatscli.setBounds(45, 231, 150, 35);
		frame.getContentPane().add(labwhatscli);
		
		JLabel labwhatscliform = new JLabel("formato (85) 9.9999-99");
		labwhatscliform.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labwhatscliform.setBounds(45, 256, 203, 28);
		frame.getContentPane().add(labwhatscliform);
		
		//JTextArea cliwhats = new JTextArea();
		cliwhats.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cliwhats.setBounds(233, 242, 316, 35);
		frame.getContentPane().add(cliwhats);
			
// linha VISITAS CLIENTE linha VISITAS CLIENTE linha VISITAS CLIENTE	
		JLabel labviscli = new JLabel("Veículos visitados");
		labviscli.setFont(new Font("Tahoma", Font.BOLD, 24));
		labviscli.setBounds(45, 295, 220, 35);
		frame.getContentPane().add(labviscli);
		
		JLabel labviscliform = new JLabel("formato 9999");
		labviscliform.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labviscliform.setBounds(45, 320, 203, 28);
		frame.getContentPane().add(labviscliform);
		
		JTextArea clivis = new JTextArea();
		clivis.setFont(new Font("Tahoma", Font.PLAIN, 18));
		clivis.setBounds(275, 302, 666, 35);
		frame.getContentPane().add(clivis);
		
// linha CADASTRAR VEÍCULO linha CADASTRAR VEÍCULO linha CADASTRAR VEÍCULO
		JLabel labadveicli = new JLabel("Cadartrar Veículo");
		labadveicli.setFont(new Font("Tahoma", Font.BOLD, 24));
		labadveicli.setBounds(45, 349, 234, 35);
		frame.getContentPane().add(labadveicli);
		
		JLabel labcadcliform = new JLabel("formato 9999");
		labcadcliform.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labcadcliform.setBounds(45, 374, 203, 28);
		frame.getContentPane().add(labcadcliform);
		
		//JTextArea cadveicli = new JTextArea();
		cadveicli.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cadveicli.setBounds(275, 360, 160, 35);
		frame.getContentPane().add(cadveicli);
		
// linha EXCLUIR VEÍCULO linha EXCLUIR VEÍCULO linha EXCLUIR VEÍCULO
		JLabel labexveicli = new JLabel("Excluir Veículo");
		labexveicli.setFont(new Font("Tahoma", Font.BOLD, 24));
		labexveicli.setBounds(572, 349, 183, 35);
		frame.getContentPane().add(labexveicli);
		
		JLabel labconcliform_1 = new JLabel("formato 9999");
		labconcliform_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labconcliform_1.setBounds(572, 374, 203, 28);
		frame.getContentPane().add(labconcliform_1);
		
		//JTextArea excveicli = new JTextArea();
		excveicli.setFont(new Font("Tahoma", Font.PLAIN, 18));
		excveicli.setBounds(781, 360, 160, 35);
		frame.getContentPane().add(excveicli);
		
// linha BOTÃO SALVAR linha BOTÃO SALVAR linha BOTÃO SALVAR	 linha BOTÃO SALVAR	
		JButton btnclisalvar = new JButton("Salvar");
		btnclisalvar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			

	
		while (true) {
					if (!cli_existe) {
						private Object statement;
//inserir dados
						public void inserirContato(String nome, String telefone) {
						try {
//aspas simple que � usado no mysql
							String query = "insert into Cliente(cli_nome,cli_whats) values"
									+ "('"+cli_nome+"','"+cli_whats+"')";
							((Statement) this.statement).executeUpdate(query);
						}catch(Exception e) {
							System.out.println("ERROR: "+e.getMessage());
						}
					}else {			
//editar dados			
						public void editarContato(int cli_id,int cli_nome, String cli_whats) {
						try {			
//aspas simple que � usado no mysql
							String query = "update contato set nome ='"+cli_nome+"',telefone = '"+cli_whats+"' where id = '"+cli_id+"'";
							((Statement) this.statement).executeUpdate(query);
						}catch(Exception e) {
							System.out.println("ERROR: "+e.getMessage());
							}
						}	
					}		
			
		});
		btnclisalvar.setFont(new Font("Tahoma", Font.BOLD, 36));
		btnclisalvar.setBounds(42, 443, 223, 53);
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
		btncliExcluir.setBounds(380, 443, 223, 53);
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
		btnclivoltar.setBounds(714, 443, 223, 53);
		frame.getContentPane().add(btnclivoltar);
	}
		
// pesquisa para saber se existe o cliente pelo codigo
	private void voidverificarCodigoCliente() {
		String codigo = clicod.getText();
		String sql = "SELECT cli_nome, cli_whats FROM cliente WHERE codigo = ?";

		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, codigo);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				
// Se o cliente existir, preencher os campos
				boolean cli_existe = (false);
				AbstractButton cli_nome;
				cli_nome.setText(rs.getString("cli_nome"));
				cli_whats.setText(rs.getString("cli_whats"));
			}
		}
	}
}
