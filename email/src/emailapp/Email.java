package emailapp;

import java.security.SecureRandom;
import java.util.Scanner;

public class Email {
	private String primeiroNome;
	private String ultimoNome;
	private String senha;
	private String email;
	private String departamento;
	private String emailAlternativo;
	private int capacidadeCxEntrada = 500;
	private int senhaTamanhoPadrao=8;
	private String sufixoEmpresa = "company.com.br";

	// construtor que recebe primeiro e segundo nome
	public Email(String primeiroNome, String ultimoNome) {
		this.primeiroNome = primeiroNome;
		this.ultimoNome = ultimoNome;
		
		// chamar um método para perguntar o departamento (retornar o departamento
		this.departamento = setDepartamento();
		
		// chamar um método que retorna uma senha aleatória
		this.senha = senhaAleatoria(senhaTamanhoPadrao);
		System.out.println("\nSua senha é: "+this.senha);
		//combinar elemntos para gerar um email valido
		email = primeiroNome.toLowerCase()+"."+ultimoNome.toLowerCase()+"@"+departamento+"."
		+sufixoEmpresa;
		
	}

	// perguntar o departamento
	private String setDepartamento() {
		System.out.println("Olá "+primeiroNome+", bem vindo(a), por favor informe"
	+" seu departamento:\n1 - Vendas\n2 - Desenvolvimento\n3 - RH");
		Scanner leia = new Scanner(System.in);
		int depEscolha = leia.nextInt();
		if (depEscolha == 1) {
			return "vendas";
		} else if (depEscolha == 2) {
			return "desenvolvimento";
		} else if (depEscolha == 3) {
			return "rh";
		} else {
			return "";
		}
	}

	// gerar senha aleatória
	private static String senhaAleatoria(int tamanho) {
		final String atribuicaoSenha = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%";
		SecureRandom aleatorio = new SecureRandom();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < tamanho; i++) {
			int rand = aleatorio.nextInt(atribuicaoSenha.length());
			sb.append(atribuicaoSenha.charAt(rand));
		}
		return sb.toString();
	}
	
	//definir capacidade da caixa de entrada
	public void setCapacidadeCxEntrada (int capacidade) {
		this.capacidadeCxEntrada = capacidade;
	}
	
	//mostrar a capacidade da caixa
	public int getCapacidadeCxEntrada() {
		return capacidadeCxEntrada;
	}
	
	//definir email alternativo
	public void setEmailAlternativo(String emailAlt) {
		this.emailAlternativo = emailAlt;
	}
	
	//mostrar o email alternativo
	public String getEmailAlternativo() {
		return emailAlternativo;
	}
	
	//trocar a senha
	public void trocarSenha(String senha) {
		this.senha = senha;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public String infoGeral() {
		return "Nome: "+primeiroNome+" "+ultimoNome+
				"\nEmail corporativo: "+email+
				"\nCapacidade da caixa de entrada: "+capacidadeCxEntrada+"mb";
	}


}
