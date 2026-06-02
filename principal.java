/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author luan.vpcastro
 */
public class principal {
    public static void main(String[] args) {
    
        // Matrizes criadas localmente (não são globais)
        String[][] matrizClientes = new String[0][8];
        String[][] matrizContatos = new String[0][5];
        
        System.out.println("================================================");
        System.out.println(" SISTEMA DE CADASTRO DE CLIENTES e CONTATOS ");
        System.out.println("========================================");
        
        // Passa as matrizes para o menu principal
        menuPrincipal(matrizClientes, matrizContatos);
        
        System.out.println("\nSistema encerrado. Até logo!");
    }
    
    // ========== MENU ==========
    
    /**
     * Menu Principal
     * Permite carregar dados de arquivos CSV 
     */
    private static void menuPrincipal(String[][] matrizClientes, String[][] matrizContatos) {
        int opcao = -1;
        Scanner scanner = new Scanner(System.in);
        
        while (opcao != 0) {
            System.out.println("\n========== MENU PRINCIPAL ==========");
            System.out.println("1 - Carregar dados de teste (CSV)");
            System.out.println("2 - Gerenciar clientes");
            System.out.println("3 - Gerenciar contatos");
            System.out.println("4 - Relatorios");
            System.out.println("0 - Sair");
            System.out.println("====================================");
            System.out.print("Escolha uma opção: ");
            
            try {
                opcao = Integer.parseInt(scanner.nextLine());
                
                switch(opcao) {
                    case 1:
                        // Carrega dados dos CSVs
                        matrizClientes = carregarClientesCSV();
                        matrizContatos = carregarContatosCSV();
                        
                        System.out.println("\n============================================");
                        System.out.println("Clientes carregados: " + matrizClientes.length);
                        System.out.println("Contatos carregados: " + matrizContatos.length);
                        System.out.println("============================================");
                        System.out.println("\n✓ Dados carregados com sucesso!");
                        break;
                    
                    case 2 : 
                        menuClientes(matrizClientes, matrizContatos);
                        break;  
                    case 3 :
                        menuContatos(matrizClientes, matrizContatos);
                        break;
                    case 4: 
                        menuRelatorios(matrizClientes, matrizContatos);
                        break;
                    case 0 : System.out.println("\nEncerrando sistema...");
                        break;
                    default : System.out.println("\nOpção inválida! Tente novamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("\nEntrada inválida! Digite apenas números.");
                opcao = -1;
            }
        }
        
        scanner.close();
    }
    
    private static void menuClientes(String[][] matrizClientes, String[][] matrizContatos) {
        int opcao = -1;
        Scanner scanner = new Scanner(System.in);
        
        while (opcao != 0) {
            System.out.println("\n========== MENU CLIENTE ==========");
            System.out.println("1 - Incluir cliente");
            System.out.println("2 - Listar clientes");
            System.out.println("3 - consultar cliente por código");
            System.out.println("4 - alterar cliente");
            System.out.println("5 - Apagar clientes");
            System.out.println("6 - Ordenar por nome");
            System.out.println("0 - Voltar");
            System.out.println("====================================");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt(); 
            
            
            switch(opcao) {
                case 1: 
                    matrizClientes = incluirCliente(matrizClientes);
                    break;
                case 2:
                    listarClientes(matrizClientes);
                    break;
                case 3:
                    break;
                case 4:
                    matrizClientes = alteraçãoClientes(matrizClientes);
                    break;
                case 5:
                    matrizClientes = excluirClientes(matrizClientes);
                    break;
                case 6:
                    ordenarClientes(matrizClientes);
                    break;
                case 0:
                    break;
                default :
            }
            
        }
    }
        
        
    private static void menuContatos(String [][] matrizContatos, String[][] matrizClientes){
            int opcao = -1;
            
            Scanner scanner = new Scanner(System.in);
            
            while(opcao != 0){
                System.out.println("\n========== MENU CONTATOS ==========");
            System.out.println("1 - Incluir contato");
            System.out.println("2 - Listar contato de um cliente");
            System.out.println("3 - Listar contatos (de todos os clientes");
            System.out.println("4 - alterar contato");
            System.out.println("5 - Apagar contato");
            System.out.println("0 - votlar");
            System.out.println("====================================");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            
            
            switch(opcao) {
                case 1: 
                    matrizContatos = incluirContatos(matrizContatos);
                    break;
                case 2:
                    break;
                case 3:
                    listarContatos(matrizClientes, matrizContatos);
                    break;
                case 4:
                    alteracaoContatos(matrizContatos);
                    break;
                case 5:
                    break;
                case 0:
                    break;
                default :
            }
            }
        }
    
    public static void menuRelatorios (String[][] matrizClientes, String[][] matrizContatos) {
        int opcao = -1;
        Scanner scanner = new Scanner(System.in);
        
        while (opcao != 0) {
            System.out.println("\n========== MENU RELATORIOS ==========");
            System.out.println("1 - Total de Clientes");
            System.out.println("2 - Total de Contatos");
            System.out.println("3 - Media de Contatos por Cliente");
            System.out.println("4 - Total de Clientes sem Contatos");
            System.out.println("0 - Voltar");
            System.out.println("====================================");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt(); 
            
            
            switch(opcao) {
                case 1: 
                    int totalCli = totalClientes(matrizClientes);
                    System.out.println("Total de Clientes: " + totalCli);
                    break;
                case 2:
                    int totalCon = totalContatos(matrizContatos);
                    System.out.println("Total de Contatos: " + totalCon);
                    break;
                case 3:
                    float media = mediaContatoPorCliente(matrizClientes, matrizContatos);
                    System.out.println("Media de Contatos por Cliente: " + media);
                    break;
                case 4:
                    int totalSem = totalSemContatos(matrizClientes, matrizContatos);
                    System.out.println("Total de Clientes sem Contato: " + totalSem);
                    break;
                case 0:
                    break;
            }
        }
    }

        
    
    // ========== FUNÇÕES DE CARREGAMENTO DE DADOS ==========
    
    /**
     * Carrega clientes do arquivo clientes.csv
     * Formato: codigo,nome,cpf_cnpj,data_nascimento,sexo,cidade,estado,status
     */
    private static String[][] carregarClientesCSV() {
        String arquivo = "C:\\Users\\luan.vpcastro\\Documents\\NetBeansProjects\\principal\\src\\principal\\clientes.csv";
        String[][] matrizClientes = new String[0][8];
        int contador = 0;
        
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            boolean primeiraLinha = true;
            
            while ((linha = br.readLine()) != null) {
                // Pula o cabeçalho
                if (primeiraLinha) {
                    primeiraLinha = false;
                    continue;
                }
                
                // Divide a linha por vírgula
                String[] dados = linha.split(",");
                
                if (dados.length >= 8) {
                    // Aumenta a matriz em 1 linha
                    matrizClientes = aumentarMatrizClientes(matrizClientes);
                    int indice = matrizClientes.length - 1;
                    
                    // Preenche a nova linha com os dados do CSV
                    matrizClientes[indice][0] = dados[0].trim(); // codigo
                    matrizClientes[indice][1] = dados[1].trim(); // nome
                    matrizClientes[indice][2] = dados[2].trim(); // cpf_cnpj
                    matrizClientes[indice][3] = dados[3].trim(); // data_nascimento
                    matrizClientes[indice][4] = dados[4].trim(); // sexo
                    matrizClientes[indice][5] = dados[5].trim(); // cidade
                    matrizClientes[indice][6] = dados[6].trim(); // estado
                    matrizClientes[indice][7] = dados[7].trim().toUpperCase(); // status
                    
                    contador++;
                }
            }
            
            System.out.println("✓ " + contador + " clientes foram carregados do arquivo.");
            
        } catch (IOException e) {
            System.out.println("\n✗ Erro ao ler arquivo " + arquivo + ": " + e.getMessage());
            System.out.println("Certifique-se de que o arquivo existe no diretório do projeto.");
        }
        
        return matrizClientes;
    }
    
    private static void listarClientes(String[][] matrizClientes){
        if(matrizClientes.length == 0){
            System.out.println("Nenhum cadastro");
        } else {
            System.out.print("Codigo  | ");
            System.out.print("Nome    | ");
            System.out.print("CPF/CNPJ   | ");
            System.out.print("Data_Nascimento    | ");
            System.out.print("Sexo    | ");
            System.out.print("Cidade  | ");
            System.out.print("Estado  | ");
            System.out.println("Status");
            System.out.println("----------------------------------------------");
            for (int i = 0; i < matrizClientes.length; i++) {
                System.out.print(" | ");
                System.out.print(matrizClientes[i][0] + " | ");
                System.out.print(matrizClientes[i][1] + " | ");
                System.out.print(matrizClientes[i][2] + " | ");
                System.out.print(matrizClientes[i][3] + " | ");
                System.out.print(matrizClientes[i][4] + " | ");
                System.out.print(matrizClientes[i][5] + " | ");
                System.out.println(matrizClientes[i][6]);
            }
        }
    }
    private static void listarContatos(String[][] matrizContatos, String[][] matrizClientes){
        if(matrizContatos.length == 0){
            System.out.println("Nenhum cadastro");
        } else {
            System.out.print("CodCont  | ");
            System.out.print("CodCli   | ");
            System.out.print("Nome   | ");
            System.out.print("Tipo    | ");
            System.out.print("Valor   | ");
            System.out.println("Status");
            System.out.println("--------------------------------------------------------------");
            for (int i = 0; i < matrizContatos.length; i++) {
            String nomeCliente = "";

                for (int j = 0; j < matrizClientes.length; j++) {
                    if (matrizContatos[i][1].equals(matrizClientes[j][0])) {
                        nomeCliente = matrizClientes[j][1];
                        break;
                    }
                } 
                
                //System.out.print(i + " | "); pq isso ta aqui? - Taffarelsons :v
                System.out.printf("%s | %s | %s | %s | %s | %s\n",
                        matrizContatos[i][0],
                        matrizContatos[i][1],
                        nomeCliente,
                        matrizContatos[i][2],
                        matrizContatos[i][3],
                        matrizContatos[i][4]
                        );
                /*System.out.print(matrizContatos[i][0] + " | ");           
                System.out.print(matrizContatos[i][1] + " | ");
                System.out.println(nomeCliente + " | ");
                System.out.print(matrizContatos[i][2] + " | ");
                System.out.println(matrizContatos[i][3]);*/
            }
        }
    }   
    
    /**
     * Carrega contatos do arquivo contatos.csv
     * Formato: codigo_contato,codigo_cliente,tipo,valor,status
     */
    private static String[][] carregarContatosCSV() {
        String arquivo = "C:\\Users\\luan.vpcastro\\Documents\\NetBeansProjects\\principal\\src\\principal\\contatos.csv";
        String[][] matrizContatos = new String[0][5];
        int contador = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            boolean primeiraLinha = true;
            
            while ((linha = br.readLine()) != null) {
                // Pula o cabeçalho
                if (primeiraLinha) {
                    primeiraLinha = false;
                    continue;
                }
                
                // Divide a linha por vírgula
                String[] dados = linha.split(",");
                
                if (dados.length >= 5) {
                    // Aumenta a matriz em 1 linha
                    matrizContatos = aumentarMatrizContatos(matrizContatos);
                    int indice = matrizContatos.length - 1;
                    
                    // Preenche a nova linha com os dados do CSV
                    matrizContatos[indice][0] = dados[0].trim(); // codigo_contato
                    matrizContatos[indice][1] = dados[1].trim(); // codigo_cliente
                    matrizContatos[indice][2] = dados[2].trim(); // tipo
                    matrizContatos[indice][3] = dados[3].trim(); // valor
                    matrizContatos[indice][4] = dados[4].trim().toUpperCase(); // status
                    
                    contador++;
                }
            }
            
            System.out.println("✓ " + contador + " contatos foram carregados do arquivo.");
            
        } catch (IOException e) {
            System.out.println("\n✗ Erro ao ler arquivo " + arquivo + ": " + e.getMessage());
            System.out.println("Certifique-se de que o arquivo existe no diretório do projeto.");
        }
        
        return matrizContatos;
    }
    
    // ========== FUNÇÕES DE MANIPULAÇÃO DE MATRIZES ==========
    
    /**
     * Aumenta a matriz de clientes em 1 linha
     * Cria uma nova matriz com uma linha a mais e copia os dados existentes
     */
    private static String[][] aumentarMatrizClientes(String[][] matrizClientes) {
       String [][] novaMatriz = new String [matrizClientes.length + 1][8];
       for (int i = 0; i < matrizClientes.length; i++) {
            for (int j = 0; j < matrizClientes[i].length; j++) {
                novaMatriz[i][j] = matrizClientes[i][j];               
           }
        }
       return novaMatriz;
    }
    
    /**
     * Aumenta a matriz de contatos em 1 linha
     * Cria uma nova matriz com uma linha a mais e copia os dados existentes
     */
    private static String[][] aumentarMatrizContatos(String[][] matrizContatos) {
String [][] novaMatriz = new String [matrizContatos.length + 1] [5];
       for (int i = 0; i < matrizContatos.length; i++) {
            for (int j = 0; j < matrizContatos[i].length; j++) {
                novaMatriz[i][j] = matrizContatos[i][j];               
           }
        }
       return novaMatriz;
    }
    
    private static String [][] alteraçãoClientes(String[][] matrizClientes){
        Scanner scanner = new Scanner(System.in);
        int contador = 0;
        System.out.println("Qual cliente deseja alterar");
        String codCliente = scanner.nextLine();    
        
        for(int i = 0; i < matrizClientes.length; i ++){
        if(codCliente.equals(matrizClientes[contador][0])){           
           for (int j = 1; j < matrizClientes[contador].length; j++) {
                System.out.println("Altere os dados do cliente indice[" + j + "]");
                String dadosNovos = scanner.nextLine();
                matrizClientes[contador][j] = dadosNovos;
            }
           break;
            
        } else{
            contador++;
        }
        }
        return matrizClientes;
    }
    
    private static String [][] alteracaoContatos(String [][] matrizContatos){
        Scanner scanner = new Scanner(System.in);
        int contador = 0;
        System.out.println("Qual contato deseja alterar:");
        String codContato = scanner.nextLine();
        for (int i = 0; i < matrizContatos.length; i++) {
            if(codContato.equals(matrizContatos[contador][0]))
            {
                for(int j = 1; j < matrizContatos[contador].length; j++) {
                    System.out.println("Altere os dados de contado no indice[" + j + "]");
                    String dadosNovos = scanner.nextLine();
                    matrizContatos[contador][j] = dadosNovos;
                }
                break;
            } else {
                contador++;
            }
        }
        return matrizContatos;
    }
    
   public static String[][] incluirCliente(String[][] matrizClientes) {
       Scanner leia = new Scanner(System.in);
       
       matrizClientes = aumentarMatrizClientes(matrizClientes);
       int l = 0;
       
       for (int i = 0; i < matrizClientes.length; i++) {
           l++;
       }
       
       String cod = String.valueOf(l);
       if(matrizClientes.length == 1){
            matrizClientes[0][0] = cod;
            
       }
       else if (matrizClientes.length > 1){
           matrizClientes[matrizClientes.length - 1][0] = cod;
       }
       
       for (int i = 0; i < matrizClientes.length; i++) {
           for (int j = 0; j < matrizClientes[i].length; j++) {
               if(i + 1 == matrizClientes.length){
                   System.out.println("Digite o seu nome");
                   String nome = leia.nextLine();
                   matrizClientes[i][1] = nome;
                   System.out.println("Digite o seu CPF/CNPJ");
                   String cpf = leia.nextLine();
                   matrizClientes[i][2] = cpf;
                   System.out.println("Digite a sua data de nascimento");
                   String data = leia.nextLine();
                   matrizClientes[i][3] = data;
                   System.out.println("Digite o seu sexo");
                   String sexo = leia.nextLine();
                   matrizClientes[i][4] = sexo;
                   System.out.println("Digite a sua cidade");
                   String cidade = leia.nextLine();
                   matrizClientes[i][5] = cidade;
                   System.out.println("Digite o seu estado");
                   String estado = leia.nextLine();
                   matrizClientes[i][6] = estado;
                   System.out.println("Digite o seu status");
                   String status = leia.nextLine();
                   matrizClientes[i][7] = status;
                   break;
               }
           }
           
       }
       return matrizClientes;
    }
   
   
   public static String[][] incluirContatos(String[][] matrizContatos){
       Scanner leia = new Scanner(System.in);
      
       matrizContatos = aumentarMatrizContatos(matrizContatos);
       int l = 0;
       
       for (int i = 0; i < matrizContatos.length; i++) {
           l++;
       }
       
       String cod = String.valueOf(l);
       if(matrizContatos.length == 1){
            matrizContatos[0][0] = cod;
            
       }
       else if (matrizContatos.length > 1){
           matrizContatos[matrizContatos.length - 1][0] = cod;
       }
       
       for (int i = 0; i < matrizContatos.length; i++) {
           for (int j = 0; j < matrizContatos[i].length; j++) {
               if(i + 1 == matrizContatos.length ){
                   System.out.println("Qual o seu id ?");
                   String id = leia.nextLine();
                   matrizContatos[i][1] = id;
                   System.out.println("Digite o tipo");
                   String nomeContato = leia.nextLine();
                   matrizContatos[i][2] = nomeContato;
                   System.out.println("Digite o tvalor do contato)");
                   String tipoContato = leia.nextLine();
                   matrizContatos[i][3] = tipoContato;
                   System.out.println("Digite o status");
                   String valor = leia.nextLine();
                   matrizContatos[i][4] = valor;
                   
                   break;
               }    
           }
           
       }
       return matrizContatos;
   }
   
   public static String[][] excluirClientes(String[][] matrizClientes){
       Scanner leia = new Scanner(System.in);
       System.out.println("Qual cliente deseja alterar");
       String codCliente = leia.nextLine();
       
       String[][] matriz = new String[matrizClientes.length][8];
       for (int i = 0; i < matrizClientes.length; i++) {
           for (int j = 0; j < matrizClientes[i].length; j++) {
               if(codCliente.equals(matrizClientes[i][j]))
               {
                   matriz[matriz.length - 1][j] = matrizClientes[i][j];
               }
               else{
                   matriz[i][j]= matrizClientes[i][j];
               }
           }
       }
       
       
       
       String[][] matrizNova = new String [matriz.length - 1][8];
       
       for (int i = 0; i < matrizNova.length; i++) {
           for (int j = 0; j < matrizNova[i].length; j++) {
               matrizNova[i][j] = matriz[i][j];
           }
       }
       
       
       
       
   
       return matrizNova;
   }
   
    /**
     * RELATORIO - Fica pedindo pra por estas coisas em baixo???? alguem sabe pq?
     * @param matrizClientes
     * @return 
     */
   
    public static int totalClientes (String[][] matrizClientes) {
 
        return matrizClientes.length;
    }
    public static int totalContatos (String[][] matrizContatos) {
 
        return matrizContatos.length;
    }
    public static float mediaContatoPorCliente (String[][] matrizClientes, String[][] matrizContatos) {
        // se não por pra float ele arredonda o valor (obrigado stack overflow)
        return (float)totalContatos(matrizContatos) / (float)totalClientes(matrizClientes);
    }
    public static int totalSemContatos (String[][] matrizClientes, String[][] matrizContatos) {
        int totalSemContatos = 0;
    
        for (int i = 0; i < matrizClientes.length; i++) {
            boolean temContato = false;
            String codigoCliente = matrizClientes[i][0];
            
            for (int j = 0; j < matrizContatos.length; j++) {
                String chaveEstrangeira = matrizContatos[j][1];
                
                if(codigoCliente.equals(chaveEstrangeira)) {
                    temContato = true;
                    break;
                }
            }
            
            if(temContato == false) {
                totalSemContatos++;
            }
        }
        
        return totalSemContatos;
    }
 
    
    /**
    * ORDENAÇÃO - D; Fica pedindo pra por estas coisas em baixo???? alguem sabe pq?
     * @param matrizClientes
    */

    // Ordenando Clientes
    public static void ordenarClientes (String[][] matrizClientes) {
        // não funcionando por algum motivo
        for (int i = 0; i < matrizClientes.length - 1; i++) {
            for (int j = 0; j < matrizClientes.length - 1 - i; j++) {
                if (matrizClientes[j][1].compareTo(matrizClientes[j+1][1]) < 0) {
                    String[] temp = matrizClientes[j];
                    matrizClientes[j] = matrizClientes[j+1];
                    matrizClientes[j+1] = temp;
                }
            }
        }
        
    }
    
}


     