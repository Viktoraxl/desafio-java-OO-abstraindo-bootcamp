package br.com.dio.desafio.dominio;

import java.lang.classfile.instruction.SwitchCase;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		List<Cursos> cursos = new ArrayList();
		List<Mentoria> mentoria = new ArrayList();
		
		Bootcamp bootcamp = new Bootcamp();
		List <Dev> dev = new ArrayList();
		
		Scanner scan = new Scanner(System.in);
		boolean resposta = true;
		// cadastro de cursos ou mentorias
		
		while(resposta) {
			System.out.println("Deseja se inscrever:\n"
							 + "1- Curso \n"
							 + "2- Mentoria");
			int op = scan.nextInt();
			scan.nextLine();  // Limpa o buffer do scanner
			if(op == 1) {
				System.out.println("Digite o nome do curso:");
				String titulo = scan.nextLine();
				System.out.println("Digite a descrição:");
				String descricao = scan.nextLine();
				System.out.println("Digite a carga horária:");
				int cargaHoraria = scan.nextInt();
				scan.nextLine(); // Limpa o buffer do scanner
				
				Cursos novoCursos = new Cursos().cadastrarCurso(titulo, descricao, cargaHoraria);
				novoCursos.calcularXP();
				cursos.add(novoCursos);
			}
			else if(op == 2) {
				System.out.println("Digite o nome da mentoria:");
				String nome = scan.nextLine();
				System.out.println("Digite a descrição:");
				String descricao = scan.nextLine();

				Mentoria novaMentoria = new Mentoria().cadastrarMentoria(nome, descricao, LocalDate.now());
				mentoria.add(novaMentoria);
			}else {
				System.out.println("Comando inválido");
				continue;
			}
			System.out.println("Deseja continuar? (s/n)");
			String opcao = scan.nextLine();
			
			if(opcao.equalsIgnoreCase("s")) {
				continue;
			}else if(opcao.equalsIgnoreCase("n")) {
				resposta = false;
				break;
			}else {
				System.out.println("Opção inválida");
				resposta = false;
				break;
			}			
		}
		int i = 1;
		// mostra os cursos e mentorias cadastrados
		for (Cursos curso : cursos) {
			if(!cursos.isEmpty()) {
				System.out.println("Curso " + i + ": " + curso);
			    i++;
			}
		}
		i = 1;
		for (Mentoria ment : mentoria) {
			if(!mentoria.isEmpty()) {
			    System.out.println("Mentoria " + i + ": " + ment);
			    i++;
			}
		}


		// cadastrar o bootcamp
		System.out.println("Digite o nome do Bootcamp.");
		String nomeBootcamp = scan.nextLine();
		System.out.println("Digite a descrição do Bootcamp:");
		String descricao = scan.nextLine();
		
		bootcamp.setNome(nomeBootcamp);
		bootcamp.setDescricao(descricao);
		
		for (Cursos curso : cursos) {
			if(!cursos.isEmpty()) {
				bootcamp.getConteudos().add(curso);
			}
		}
		for (Mentoria ment : mentoria) {
			if(!mentoria.isEmpty()) {
				bootcamp.getConteudos().add(ment);
			}
		}	
		
		resposta = true;
		// cadastro Devs e mentorias
		while(resposta) {
			System.out.println("Digite seu nome:");
			String nomeDev = scan.nextLine();
			Dev novoDev = new Dev();
			novoDev.setNome(nomeDev);
			novoDev.inscreverBootcamp(bootcamp);
			
			for (Cursos curso : cursos) {
				if(!cursos.isEmpty()) {
					System.out.println("Você progrediu no curso: "+ curso.getTitulo()+ " ? (s/n)");
					String op = scan.nextLine();
					if(op.equalsIgnoreCase("s")) {
						novoDev.progredir();
					}
				}
			}
			for (Mentoria ment : mentoria) {
				if(!mentoria.isEmpty()) {
					System.out.println("Você progrediu na mentoria: "+ ment.getTitulo()+ " ? (s/n)");
					String op = scan.nextLine();
					if(op.equalsIgnoreCase("s")) {
						novoDev.progredir();
				}
			}				
			dev.add(novoDev);
			
				System.out.println("Deseja adicionar outro Dev? (s/n)");
				String opcao = scan.nextLine();			
				if(opcao.equalsIgnoreCase("s")) {
					continue;
				}else if(opcao.equalsIgnoreCase("n")) {
					resposta = false;
				}else {
					System.out.println("Opção inválida");
					resposta = false;
				}		
			}			
		}
		for (Dev d : dev) {
			System.out.println("Conteúdos inscritos "+ d.getNome()+": "+d.getConteudosInscritos());
			System.out.println("Conteúdos concluídos "+ d.getNome()+": "+d.getConteudosConcluidos());
		}
	}
}
	