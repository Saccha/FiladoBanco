import java.io.IOException;
import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;
import java.util.Arrays; 
import java.util.Collections;

public class FilaBanco {
  public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(System.in);
    
    ArrayList<Integer> listaSaida = new ArrayList<Integer>();

    //Recebe número de Casos de Testes
    int numCasosTestes;
    numCasosTestes = Integer.parseInt(scanner.nextLine());
    
    for(int i = 0; i < numCasosTestes; i++){
        //Recebe Qtde de Pessoas na Fila
        int numQtdPessoas = 0;
        numQtdPessoas = Integer.parseInt(scanner.nextLine());
        
        //Recebe Senhas com Posição na Fila da(s) N pessoa(s) (numQtdPessoas) separadas por " "
        String strPosicaoFila = "";
        strPosicaoFila = scanner.nextLine();

        //Transforma string em Lista
        String[] str = strPosicaoFila.split(" ", numQtdPessoas); 

        //Cria Lista Final e ordena DESC
        ArrayList<Integer> listaInicial = new ArrayList<Integer>();
        ArrayList<Integer> listaFinal   = new ArrayList<Integer>();
        for(int x = 0; x < str.length; x++){
          listaInicial.add(Integer.valueOf(str[x]));
          listaFinal.add(Integer.valueOf(str[x]));
        }

        Collections.sort(listaFinal, Collections.reverseOrder());

        //System.out.println("Lista Inicial: [" + listaInicial + "]");
        //System.out.println("Lista Final  : [" + listaFinal + "]");

        //Conta quantas posições NÃO foram trocadas
        int numPosNaoTrocadas = listaInicial.size();
        //System.out.println("numPosNaoTrocadas(antes):"+numPosNaoTrocadas);

        for(int j = 0; j < listaInicial.size(); j++){
          //System.out.printf("Comparar [%d] com [%d]\n",listaInicial.get(j), listaFinal.get(j) );
          if(listaInicial.get(j).intValue() != listaFinal.get(j).intValue())
            numPosNaoTrocadas--;
            //System.out.printf("numPosNaoTrocadas(iteracao %d): %d\n",j,numPosNaoTrocadas);
        }

        listaSaida.add(numPosNaoTrocadas);
    }

    //Imprime Qtde de Posições NÃO trocadas de cada caso de teste
    listaSaida.stream().forEach(System.out::println);
  }
}
