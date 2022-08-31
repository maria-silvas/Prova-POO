import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class PrimeiraAvaliacao {
    public static void main(String[] args) {
        try {
            BufferedReader collection = new BufferedReader(new FileReader("Avaliacao.txt"));
            BufferedWriter arquivoArray = new BufferedWriter(new FileWriter("Array.txt"));
            BufferedWriter arquivoColection = new BufferedWriter(new FileWriter("Colectionsalvo.txt"));
            SortedSet<Integer> ColecaoOrdenada = new TreeSet<Integer>();
            String value = "";
            int count = 0;

            while (true) {
                value = collection.readLine();

                if (value != null && !value.equals("")) {
                    count++;
                } else {
                    break;
                }
            }

            collection.close();

            collection = new BufferedReader(new FileReader("Avaliacao.txt"));
            // Criar o array com tamanho das linhas para serem executadas.
            int[] array = new int[count];
            count = 0;
            value = "";

            while (true) {
                value = collection.readLine();
                if (value != null && !value.equals("")) {

                    // Aloca os valores nas posiC'C5es
                    int numero = Integer.parseInt(value);
                    array[count] = numero;
                    ColecaoOrdenada.add(numero);
                    count++;
                } else {

                    break;
                }
            } // Fechando o Buffer

            // debug;

            collection.close();

            // Metodo SELECTION SORT ele serve para pegar o numero colocar eles do menor
            // para o maior
            int n = array.length;

            for (int i = 0; i < n - 1; i++) {

                int min_idx = i;
                for (int j = i + 1; j < n; j++)
                    if (array[j] < array[min_idx])
                        min_idx = j;

                int temp = array[min_idx];
                array[min_idx] = array[i];

                array[i] = temp;
            } System.out.println(Arrays.toString(array));

            // Ordenando a Colection SortedSet
            for (Integer numeros : array) {
                ColecaoOrdenada.add(numeros);
            }

            // Salvado o Array ordenado no arquivo ArraySalvo.txt
            for (int i : array) {
                arquivoArray.append(i + "\n");
            }

            // Criar o buffer de escrita(Writer) e logo apos
            // arquivo.txt

            for (Integer numeros : ColecaoOrdenada) {
                arquivoColection.append(numeros + "\n");
            }

            // Imprimindo o sortedset no terminal
            System.out.println("ColecC#o ordenada em SortedSet");
            for (Integer numeros : ColecaoOrdenada) {
                System.out.println(numeros);
            }

            System.out.println("Array ordenado no Metodo ");
            for (int i : array) {
                System.out.println(i);
            }
            // Fechando o buffer
            arquivoArray.close();
            arquivoColection.close();
            // caso o arquivo não exite ou não pode ser encontrado 

        } catch (IOException exception) {
            System.out.println("arquivo não existente ou não encontrado: " +
                    exception.getMessage());
                
        }
    } 

}
