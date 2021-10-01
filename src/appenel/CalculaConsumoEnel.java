/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appenel;

import java.util.Scanner;

/**
 *
 * @authors:
 * Ananda Ferreira 032445
 * Bruna Santos Poit 123821
 * Eduardo dos Santos Jacinto 112038
 * Guilherme Pereira da Silva 032397
 * Kawan contini de Souza 112512
 * Leonardo Bernardo da Paz 032599
 * Lucas Lemes Lourenço  114444
 * Matheus Oliveira da Silva 117698
 * Renata Messias da Silveira 109979
 * Rodrigo kenji isomura 031864
 */
public class CalculaConsumoEnel{
    
    public void iniciarProcesso(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Selecione uma classe: "
                + "\n1) A1 - Residencial"
                + "\n2) A2 - Residencial - Baixa Renda"
                + "\n3) B1 - Residencial Rural"
                + "\n4) D  - Serviço Publico"
                + "\n5) E  - Outros"
                + "\nR:");
        String classe = scan.nextLine();
        System.out.print("Insira o consumo do usuário: ");
        int consumo  = scan.nextInt();
        IConta conta = null;
        
        switch(classe){
            case "1":
                conta = new Residencial(consumo);
                if(!conta.estaNoRangeDeConsumo()|| !conta.multiploDeDez()){
                    System.out.println(conta.mensagemErro());
                    return;
                }
                break;
                
            case "2":
                conta = new BaixaRenda(consumo);
                if(!conta.estaNoRangeDeConsumo() || !conta.multiploDeDez()){
                    System.out.println(conta.mensagemErro());
                    return;
                } 
                break;
                
            case "3":
                conta = new ResidencialRural(consumo);
                if(!conta.estaNoRangeDeConsumo() || !conta.multiploDeDez()){
                    System.out.println(conta.mensagemErro());
                    return;
                } 
                
                break;
                
            case "4":
                conta = new ServicoPublico(consumo);
                if(!conta.estaNoRangeDeConsumo() || !conta.multiploDeDez()){
                    System.out.println(conta.mensagemErro());
                    return;
                } 
                break;
            
            case "5":
                conta = new Outros(consumo);
                if(!conta.estaNoRangeDeConsumo() || !conta.multiploDeDez()){
                    System.out.println(conta.mensagemErro());
                    return;
                } 
                
                break;
            default:
                System.out.println("Classe inválida!"
                        + "\nPor favor, Digite uma classe Válida.");
                break;
        }
        System.out.println(conta.realizarCalculo());
    }
}
