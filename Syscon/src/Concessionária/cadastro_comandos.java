package IBD;

//conex�o
import java.sql.Connection;

//driver
import java.sql.DriverManager;

//resultados (select)
import java.sql.ResultSet;

//consultas
import java.sql.Statement;


public class cadastro_comandos {
	
//armazena a conex�o	
	private Connection connection = null;

//armazena as consultas
	private Statement statement = null;

//armazena os resultados
	private ResultSet resultset = null;
	
	public void conectar() {
		
//caminho
		String servidor="jdbc:mysql://localhost:3306/cadastro";
		
//usuario
		String usuario="root";
		
//senha
		String senha="Aluno";
		
//local driver instalado
		String driver="com.mysql.cj.jdbc.Driver";
		try {

//acessa o driver
			Class.forName(driver);
			this.connection = DriverManager.getConnection(servidor,usuario,senha);

//consultas
			this.statement = this.connection.createStatement();
		}catch(Exception e) {
			System.out.println("ERROR: "+e.getMessage());
		}
	}
	public boolean estaConectado() {
		if(this.connection!=null) {
			return true;
		}else {
			return false;
		}
	}
	public void listarContatos() {
		try {
			String query = "Select * from contato";
			this.resultset = this.statement.executeQuery(query);
			while(this.resultset.next()) {
				System.out.println("ID:"+this.resultset.getString("id")+
						"Nome: "+this.resultset.getString("nome")+
						"Telefone: "+this.resultset.getString("telefone"));
			}
		}catch(Exception e) {
			System.out.println("ERROR: "+e.getMessage());
		}
	}
//inserir dados
	public void inserirContato(String nome, String telefone) {
		try {

//aspas simple que � usado no mysql
	String query = "insert into contato(nome,telefone) values"
		+ "('"+nome+"','"+telefone+"')";
		this.statement.executeUpdate(query);
		}catch(Exception e) {
			System.out.println("ERROR: "+e.getMessage());
		}
	}

//editar dados
	public void editarContato(String id,String nome, String telefone) {
		try {
	
//aspas simple que � usado no mysql
			String query = "update contato set nome ='"+nome+"',telefone = '"+telefone+"' where id = '"+id+"'";
		this.statement.executeUpdate(query);
		}catch(Exception e) {
			System.out.println("ERROR: "+e.getMessage());
		}
	}	
//apagar dados
	public void apagarContato(String id) {
		try {

//aspas simple que � usado no mysql
			String query = "delete from contato where id ='"+id+"'";
		this.statement.executeUpdate(query);
		}catch(Exception e) {
			System.out.println("ERROR: "+e.getMessage());
		}
	}
	
//desconectar banco de dados
	public void desconectar() {
		try {
			this.connection.close();
		}catch (Exception e) {
			System.out.println("ERROR ao desconectar: "+e.getMessage());
		}
	}
}
