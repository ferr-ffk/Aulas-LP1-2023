package codigosFederal;

import java.util.Scanner;

public class JogoDaVelha {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		char[][] tabuleiro = { { ' ', ' ', ' ' }, { ' ', ' ', ' ' }, { ' ', ' ', ' ' } };
		int cont = 0;
		int jogadaColuna, jogadaLinha;
		char jogador;
		while ((!vitoria(tabuleiro).equals("Vitoria X") || !vitoria(tabuleiro).equals("Vitoria O")) //verifica se ñ houve vitoria nem empate
				|| !vitoria(tabuleiro).equals("Empate!!")) {
			if (cont != 9) {
				System.out.println("|--1-2-3--|"); // exibe o tabuleiro
				for (int i = 0; i < 3; i++) {
					System.out.printf("[ |%c|%c|%c| ] %d \n", tabuleiro[i][0], tabuleiro[i][1], tabuleiro[i][2], i + 1);
				}
				cont++;
				System.out.println("|---------|");
				System.out.println("Digite qual coluna deseja jogar:");
				jogadaColuna = teclado.nextInt();
				System.out.println("Digite qual linha deseja jogar:");
				jogadaLinha = teclado.nextInt();
				System.out.println("Jogador 'X' ou 'O'");
				jogador = teclado.next().charAt(0);
				if (jogador == 'X' || jogador == 'O') { // verifica se a jogada é valida
					if (jogadaColuna < 1 || jogadaColuna > 3 || jogadaLinha < 1 || jogadaLinha > 3) {
						System.out.println("Jogada inválida! Digite uma posicao entre 1 e 3!");
						cont--; // adiciona mais uma jogada se for invalida
					} else {
						tabuleiro[jogadaLinha - 1][jogadaColuna - 1] = jogador;
					}
				} else {
					System.out.println("Caracter inválido! Digite 'X' ou 'O'!");
					cont--; // adiciona mais uma jogada se for invalida
				}
			} else {
				break;
			}
			if (vitoria(tabuleiro).equals("Vitoria X") || vitoria(tabuleiro).equals("Vitoria O")) {
				break;
			}
		}
		System.out.println("|--1-2-3--|"); // exibe o tabuleiro
		for (int i = 0; i < 3; i++) {
			System.out.printf("[ |%c|%c|%c| ] %d \n", tabuleiro[i][0], tabuleiro[i][1], tabuleiro[i][2], i + 1);
		}
		System.out.println(vitoria(tabuleiro) + "!");
		teclado.close();
	}

	private static String vitoria(char[][] tabuleiro) {
		if (vitoriaLinha(tabuleiro).equals("X")) {
			return "Vitoria X";
		}
		if (vitoriaColuna(tabuleiro).equals("O")) {
			return "Vitoria O";
		}
		return "Empate!!";
	}

	private static String vitoriaLinha(char[][] tabuleiro) {
		int marcacaoX = 0;
		int marcacaoO = 0;
		for (int i = 0; i < 3; i++) {
			if (tabuleiro[0][i] == 'X') {
				marcacaoX++; // verifica na primeira coluna se há uma marcacao
			}
			if (tabuleiro[0][i] == 'O') {
				marcacaoO++;
			}
		}
		for (int i = 0; i < 3; i++) {
			if (tabuleiro[1][i] == 'X') {
				marcacaoX++; // verifica na segunda coluna se há uma marcacao
			}
			if (tabuleiro[1][i] == 'O') {
				marcacaoO++;
			}
		}
		for (int i = 0; i < 3; i++) {
			if (tabuleiro[2][i] == 'X') {
				marcacaoX++; // verifica na terceira coluna se há uma marcacao
			}
			if (tabuleiro[2][i] == 'O') {
				marcacaoO++;
			}
		}

		if (marcacaoX == 3) {
			return "X"; // retorna X para indiciar a vitoria de X, se houver 3 marcacoes consecutivas em
						// uma linha
		} else {
			if (marcacaoO == 3) {
				return "O"; // retorna O para indiciar a vitoria de X, se houver 3 marcacoes consecutivas em
							// uma linha
			} else {
				return "";
			}
		}
	}

	private static String vitoriaColuna(char[][] tabuleiro) {
		int marcacaoX = 0;
		int marcacaoO = 0;
		for (int i = 0; i < 3; i++) {
			if (tabuleiro[i][0] == 'X') {
				marcacaoX++; // verifica na primeira linha se há uma marcacao
			}
			if (tabuleiro[i][0] == 'O') {
				marcacaoO++;
			}
		}
		for (int i = 0; i < 3; i++) {
			if (tabuleiro[i][1] == 'X') {
				marcacaoX++; // verifica na segunda linha se há uma marcacao
			}
			if (tabuleiro[i][1] == 'O') {
				marcacaoO++;
			}
		}
		for (int i = 0; i < 3; i++) {
			if (tabuleiro[i][2] == 'X') {
				marcacaoX++; // verifica na terceira linha se há uma marcacao
			}
			if (tabuleiro[i][2] == 'O') {
				marcacaoO++;
			}
		}

		if (marcacaoX == 3) {
			return "X"; // retorna X para indiciar a vitoria de X, se houver 3 marcacoes consecutivas em
						// uma coluna
		} else {
			if (marcacaoO == 3) {
				return "O"; // retorna O para indiciar a vitoria de X, se houver 3 marcacoes consecutivas em
							// uma coluna
			} else {
				return "";
			}
		}
	}

}
