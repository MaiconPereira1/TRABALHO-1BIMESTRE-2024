package br.unipar.trabalho1bimestre;
import javax.swing.JOptionPane;

public class Trabalho1Bimestre {

    public static void main(String[] args) {
        int tamanho = Integer.parseInt(JOptionPane.showInputDialog("Digite o tamanho do vetor:"));
        int[] vetor = new int[tamanho];

        for (int i = 0; i < tamanho; i++) {
            vetor[i] = Integer.parseInt(JOptionPane.showInputDialog("Digite o elemento " + (i + 1) + " do vetor:"));
        }

        int[] vetorOriginal = vetor.clone();
        String vetorOriginalStr = "Vetor Original:\n ";
        for (int i = 0; i < vetorOriginal.length; i++) {
            vetorOriginalStr += vetorOriginal[i];
            if (i < vetorOriginal.length - 1) {
                vetorOriginalStr += ", ";
            }
        }
        JOptionPane.showMessageDialog(null, vetorOriginalStr);

        int opcao = Integer.parseInt(JOptionPane.showInputDialog(
            "Escolha o método de ordenação:\n1 -"
                    + " Ordenação por Inserção\n2 -"
                    + " Ordenação por Seleção\n3 -"
                    + " Ordenação Bolha"));
        
        String metodoEscolhido = "";
        switch (opcao) {
            case 1:
                incersao(vetor);
                metodoEscolhido = "Ordenação por Inserção";
                break;
            case 2:
                selecao(vetor);
                metodoEscolhido = "Ordenação por Seleção";
                break;
            case 3:
                bolha(vetor);
                metodoEscolhido = "Ordenação Bolha";
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opção inválida!");
                return;
                
        }
        
        vetorOrdenado(vetor, metodoEscolhido);
    }

    private static void incersao(int[] vetor) {
        for (int i = 1; i < vetor.length; i++) {
            int chave = vetor[i];
            int j = i - 1;

            while (j >= 0 && vetor[j] > chave) {
                vetor[j + 1] = vetor[j];
                j--;
            }
            vetor[j + 1] = chave;
        }
    }

    private static void selecao(int[] vetor) {
        for (int i = 0; i < vetor.length - 1; i++) {
            int indiceMenor = i;

            for (int j = i + 1; j < vetor.length; j++) {
                if (vetor[j] < vetor[indiceMenor]) {
                    indiceMenor = j;
                }
            }
            if (indiceMenor != i) {
                int temp = vetor[i];
                vetor[i] = vetor[indiceMenor];
                vetor[indiceMenor] = temp;
            }
        }
    }

    private static void bolha(int[] vetor) {
        for (int i = 0; i < vetor.length - 1; i++) {
            for (int j = 0; j < vetor.length - 1 - i; j++) {
                if (vetor[j] > vetor[j + 1]) {
                    int temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;
                }
            }
        }
    }

    private static void vetorOrdenado(int[] vetor, String metodoEscolhido) {
        String vetorOrdenado = "Vetor Ordenado (" + metodoEscolhido + "):\n ";
        for (int i = 0; i < vetor.length; i++) {
            vetorOrdenado += vetor[i];
            if (i < vetor.length - 1) {
                vetorOrdenado += ", ";
            }
        }
        JOptionPane.showMessageDialog(null, vetorOrdenado);
    }
}
