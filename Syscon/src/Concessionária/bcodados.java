package Concessionaria;

//conexão
import java.sql.Connection;

//driver
import java.sql.DriverManager;

//resultados (select)
import java.sql.ResultSet;

//consultas
import java.sql.Statement;

public class bcodados {
//armazena a conexão	
	private Connection connection = null;

//armazena as consultas
	private Statement statement = null;

//armazena os resultados
	private ResultSet resultset = null;

	public void conectar() {

//caminho
		String servidor = "jdbc:mysql://localhost:3306/cadastro";

//usuario
		String usuario = "root";

// senha
		String senha = "Aluno";

// local driver instalado
		String driver = "com.mysql.cj.jdbc.Driver";
		try {

// carrega o driver na memória JDBC do MySQL
			Class.forName(driver);
// conecta o driver com a URL
			this.connection = DriverManager.getConnection(servidor, usuario, senha);
			
// consultas
				this.statement = this.connection.createStatement();
			} catch (Exception e) {
				System.out.println("ERROR: " + e.getMessage());
		}
	}
	
// verifica se a conexão foi estabelecida com sucesso
	public boolean estaConectado() {
		if (this.connection != null) {
			return true;
		} else {
			return false;
		}
	}

	public void listarContatos() {
		try {
			String query = "Select * from contato";
			this.resultset = this.statement.executeQuery(query);
			while (this.resultset.next()) {
				System.out.println("ID: " + this.resultset.getString("id") + " Nome: " + this.resultset.getString("nome")
						+ "Telefone: " + this.resultset.getString("telefone"));
			}
		} catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
		}
	}
}
