package Concessionaria;

import Conexao.bdados;

//testa a conecção em tempos 
import java.lang.Thread;

public class teste {

//incluir comando teste conecção
	public static void main (String[] args) throws InterruptedException {

//testa apenas uma vez
		bdados bd = new bdados();
		
//testar de tempos
		while(true) {
			bd.conectar();
			if(bd.estaConectado()) {
				System.out.println("OK");
			}else {
				System.out.println("Banco está com problemas");
			}
		Thread.sleep(4000);
		}
	}	
}
