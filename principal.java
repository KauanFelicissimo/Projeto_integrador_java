/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main_estudantes;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author kauan.sfelicissimo
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
            System.out.println("2 - Grenciar clientes");
            System.out.println("3 - Grenciar contatos");
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
                    case 0 : System.out.println("\nEncerrando sistema...");
                        
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
            System.out.println("0 - votlar");
            System.out.println("====================================");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt(); 
            
            
            switch(opcao) {
                case 1: 
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
                    break;
                case 6:
                    break;
                case 0:
                    break;
                default :
            }
            
        }
    }
        
        
    private static void menuContatos(){
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
            }
            
            switch(opcao) {
                case 1: 
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 0:
                    break;
                default :
            }
            
        }

        
    
    // ========== FUNÇÕES DE CARREGAMENTO DE DADOS ==========
    
    /**
     * Carrega clientes do arquivo clientes.csv
     * Formato: codigo,nome,cpf_cnpj,data_nascimento,sexo,cidade,estado,status
     */
    private static String[][] carregarClientesCSV() {
        String arquivo = "C:\\Users\\kauan.sfelicissimo\\Documents\\NetBeansProjects\\JavaApplication1\\src\\Main_estudantes\\clientes.csv";
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
            System.out.print("Idade   | ");
            System.out.print("Sexo    | ");
            System.out.print("Cidade  | ");
            System.out.print("Estado  | ");
            System.out.println("Status");
            System.out.println("----------------------------------------------");
            for (int i = 0; i < matrizClientes.length; i++) {
                System.out.print(i + " | ");                
                System.out.print(matrizClientes[i][1] + " | ");
                System.out.print(matrizClientes[i][2] + " | ");
                System.out.print(matrizClientes[i][3] + " | ");
                System.out.print(matrizClientes[i][4] + " | ");
                System.out.println(matrizClientes[i][5]);
            }
        }
    }
    
    /**
     * Carrega contatos do arquivo contatos.csv
     * Formato: codigo_contato,codigo_cliente,tipo,valor,status
     */
    private static String[][] carregarContatosCSV() {
        String arquivo = "C:\\Users\\kauan.sfelicissimo\\Documents\\NetBeansProjects\\JavaApplication1\\src\\Main_estudantes\\contatos.csv";
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
           for (int j = 0; j < 8; j++) {
                System.out.println("Altere os dados do cliente indice[" + j + "]");
                String dadosNovos = scanner.nextLine();
                matrizClientes[contador][j] = dadosNovos;
            }
           break;
            
        } else{
            contador++;
        }
        }
        System.out.println(contador);
        return matrizClientes;
    }
    

}
