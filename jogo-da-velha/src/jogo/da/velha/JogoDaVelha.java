package jogo.da.velha; 
import java.util.Scanner;

public class JogoDaVelha {
    
    public static void main(String[] args) {
        
        System.out.println("Bem vindo ao jogo da velha!");
        
        boolean teste, resultado;
        int jogada, jogador, tab[][] = new int[3][3];
        Scanner input = new Scanner(System.in);
        
        // Todo jogo terá 9 jogadas ou até a vitória de um dos jogadores
        System.out.println("Escolha uma posição de 1 a 9\n");
        for (int k = 0; k <= 9; k++) {
            
            imprimeTab(tab);
            
            // Se a condicional for verdadeira, fim do jogo
            resultado = resJogo(tab, k);
            if(resultado){break;}
            
            if(k%2 == 0){
                System.out.print("\nJogador 1: ");
                jogador = 1;
            }else{
                System.out.print("\nJogador 2: ");
                jogador = 2;
            }
            
            teste = true;
            do{
                
                if(resultado){break;}
                
                jogada = (input.nextInt()-1);
                if(jogada < 9 && jogada >= 0){
                    
                    // Checar se a posição está sendo ocupada
                    boolean pos = true;
                    switch(jogada){
                            case 0:     if(tab[0][0]==1 | tab[0][0]==2){pos=false;}break;
                            case 1:     if(tab[0][1]==1 | tab[0][1]==2){pos=false;}break;
                            case 2:     if(tab[0][2]==1 | tab[0][2]==2){pos=false;}break;
                            case 3:     if(tab[1][0]==1 | tab[1][0]==2){pos=false;}break;
                            case 4:     if(tab[1][1]==1 | tab[1][1]==2){pos=false;}break;
                            case 5:     if(tab[1][2]==1 | tab[1][2]==2){pos=false;}break;
                            case 6:     if(tab[2][0]==1 | tab[2][0]==2){pos=false;}break;
                            case 7:     if(tab[2][1]==1 | tab[2][1]==2){pos=false;}break;
                            case 8:     if(tab[2][2]==1 | tab[2][2]==2){pos=false;}break;
                            default:    break;
                    }
                    
                    if(pos){
                        // Converter a posição escolhida na posição bidimensional
                        switch(jogada){
                            case 0:     if(jogador == 1){tab[0][0]=1;}else{tab[0][0]=2;}; break;
                            case 1:     if(jogador == 1){tab[0][1]=1;}else{tab[0][1]=2;}; break;
                            case 2:     if(jogador == 1){tab[0][2]=1;}else{tab[0][2]=2;}; break;
                            case 3:     if(jogador == 1){tab[1][0]=1;}else{tab[1][0]=2;}; break;
                            case 4:     if(jogador == 1){tab[1][1]=1;}else{tab[1][1]=2;}; break;
                            case 5:     if(jogador == 1){tab[1][2]=1;}else{tab[1][2]=2;}; break;
                            case 6:     if(jogador == 1){tab[2][0]=1;}else{tab[2][0]=2;}; break;
                            case 7:     if(jogador == 1){tab[2][1]=1;}else{tab[2][1]=2;}; break;
                            case 8:     if(jogador == 1){tab[2][2]=1;}else{tab[2][2]=2;}; break;
                            default:    break;
                        }
                        
                        // Se sucede
                        teste = false;
                        System.out.println("");
                    
                    }else{
                        System.out.print("Posição ocupada! Tente novamente: ");
                    }
                    
                }else{
                    System.out.print("Jogada inválida! Tente novamente: ");
                }
            }while(teste);   
        }
    }
    
    public static void imprimeTab(int tab[][]){
    
        for (int i = 0; i < tab.length; i++) {
                for (int j = 0; j < tab[0].length; j++) {
                    System.out.print(tab[i][j] + "\t");
                }
                System.out.println("");
        }
    }
    
    public static boolean resJogo(int tab[][], int k){
        
        boolean resultado = false;
        
        // Checar linhas
        for (int i = 0; i < tab.length; i++) {
            if(tab[i][0]==1 && tab[i][1]==1 && tab[i][2]==1){resultado = true;System.out.println("\nVitória jogador 1!");break;}
            if(tab[i][0]==2 && tab[i][1]==2 && tab[i][2]==2){resultado = true;System.out.println("\nVitória jogador 2!");break;}
        }
        
        // Checar colunas
        for (int i = 0; i < tab[0].length; i++) {
            if(tab[0][i]==1 && tab[1][i]==1 && tab[2][i]==1){resultado = true;System.out.println("\nVitória jogador 1!");break;}
            if(tab[0][i]==2 && tab[1][i]==2 && tab[2][i]==2){resultado = true;System.out.println("\nVitória jogador 2!");break;}
        }
        
        // Checar diagonais
        if(tab[0][0]==1 && tab[1][1]==1 && tab[2][2]==1){resultado = true;System.out.println("\nVitória jogador 1!");}
        if(tab[0][2]==1 && tab[1][1]==1 && tab[2][0]==1){resultado = true;System.out.println("\nVitória jogador 1!");}
        if(tab[0][0]==2 && tab[1][1]==2 && tab[2][2]==2){resultado = true;System.out.println("\nVitória jogador 2!");}
        if(tab[0][2]==2 && tab[1][1]==2 && tab[2][0]==2){resultado = true;System.out.println("\nVitória jogador 2!");}
        
        if(k == 9){resultado = true;System.out.println("\nEmpate!");}
        
        return resultado;
    }
}