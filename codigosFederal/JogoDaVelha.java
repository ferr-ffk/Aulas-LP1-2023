package codigosFederal;

import java.util.Scanner;

public class JogoDaVelha {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		char[][] tabuleiro = { { ' ', ' ', ' ' }, { ' ', ' ', ' ' }, { ' ', ' ', ' ' } };
		int cont = 0;
		int jogadaColuna, jogadaLinha;
		char jogador;
		while (!vitoria(tabuleiro).equals("Vitoria X") || !vitoria(tabuleiro).equals("Vitoria O")
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
			if (vitoria(tabuleiro).equals("Vitoria X") ^ vitoria(tabuleiro).equals("Vitoria O")) {
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
		if (vitoriaLinha(tabuleiro).equals("O")) {
			return "Vitoria O";
		}
		if (vitoriaColuna(tabuleiro).equals("X")) {
			return "Vitoria X";
		}
		if (vitoriaColuna(tabuleiro).equals("O")) {
			return "Vitoria O";
		}
		if (vitoriaDiagonal(tabuleiro).equals("X")) {
			return "Vitoria X";
		}
		if (vitoriaDiagonal(tabuleiro).equals("O")) {
			return "Vitoria O";
		}
		return "Empate!!";
	}

	private static String vitoriaColuna(char[][] tabuleiro) {
		int marcacaoX = 0;
		int marcacaoO = 0;
		for (int i = 0; i < 3; i++) {
			if (tabuleiro[i][0] == 'X') {
				marcacaoX++; // verifica na primeira coluna se há uma marcacao
				if (marcacaoX == 3) {
					return "X";
				}
			}
			if (tabuleiro[i][0] == 'O') {
				marcacaoO++;
				if (marcacaoO == 3) {
					return "O";
				}
			}
		}
		marcacaoX = 0;
		marcacaoO = 0;
		for (int i = 0; i < 3; i++) {
			if (tabuleiro[i][1] == 'X') {
				marcacaoX++; // verifica na segunda coluna se há uma marcacao
				if (marcacaoX == 3) {
					return "X";
				}
			}
			if (tabuleiro[i][1] == 'O') {
				marcacaoO++;
				if (marcacaoO == 3) {
					return "O";
				}
			}
		}
		marcacaoX = 0;
		marcacaoO = 0;
		for (int i = 0; i < 3; i++) {
			if (tabuleiro[i][2] == 'X') {
				marcacaoX++; // verifica na terceira coluna se há uma marcacao
				if (marcacaoX == 3) {
					return "X";
				}
			}
			if (tabuleiro[i][2] == 'O') {
				marcacaoO++;
				if (marcacaoO == 3) {
					return "O";
				}
			}
		}

		return "";
	}

	private static String vitoriaLinha(char[][] tabuleiro) {
		int marcacaoX = 0;
		int marcacaoO = 0;
		for (int i = 0; i < 3; i++) {
			if (tabuleiro[0][i] == 'X') {
				marcacaoX++; // verifica na primeira linha se há uma marcacao
				if (marcacaoX == 3) {
					return "X";
				}
			}
			if (tabuleiro[0][i] == 'O') {
				marcacaoO++;
				if (marcacaoO == 3) {
					return "O";
				}
			}
		}
		marcacaoX = 0;
		marcacaoO = 0;
		for (int i = 0; i < 3; i++) {
			if (tabuleiro[1][i] == 'X') {
				marcacaoX++; // verifica na segunda linha se há uma marcacao
				if (marcacaoX == 3) {
					return "X";
				}
			}
			if (tabuleiro[1][i] == 'O') {
				marcacaoO++;
				if (marcacaoO == 3) {
					return "O";
				}
			}
		}
		marcacaoX = 0;
		marcacaoO = 0;
		for (int i = 0; i < 3; i++) {
			if (tabuleiro[2][i] == 'X') {
				marcacaoX++; // verifica na terceira linha se há uma marcacao
				if (marcacaoX == 3) {
					return "X";
				}
			}
			if (tabuleiro[2][i] == 'O') {
				marcacaoO++;
				if (marcacaoO == 3) {
					return "O";
				}
			}
		}

		return "";
	}

	private static String vitoriaDiagonal(char[][] tabuleiro) {
		int marcacaoX = 0;
		int marcacaoO = 0;
		for (int i = 0; i < 3; i++) {
			if (tabuleiro[i][i] == 'X') {
				marcacaoX++;
				if (marcacaoX == 3) {
					return "X";
				}
			}
			if (tabuleiro[i][i] == 'O') {
				marcacaoO++;
				if (marcacaoO == 3) {
					return "O";
				}
			}
		} // [2, 0], [1, 1], [0, 2]
		marcacaoX = 0;
		marcacaoO = 0;

		if (tabuleiro[0][2] == 'X') {
			marcacaoX++;
			if (marcacaoX == 3) {
				return "X";
			}
		}
		if (tabuleiro[0][2] == 'O') {
			marcacaoO++;
			if (marcacaoO == 3) {
				return "O";
			}
		}
		if (tabuleiro[1][1] == 'X') {
			marcacaoX++;
			if (marcacaoX == 3) {
				return "X";
			}
		}
		if (tabuleiro[1][1] == 'O') {
			marcacaoO++;
			if (marcacaoO == 3) {
				return "O";
			}
		}
		if (tabuleiro[2][0] == 'X') {
			marcacaoX++;
			if (marcacaoX == 3) {
				return "X";
			}
		}
		if (tabuleiro[2][0] == 'O') {
			marcacaoO++;
			if (marcacaoO == 3) {
				return "O";
			}
		}
		return "";
	}
}
