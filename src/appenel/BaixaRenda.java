/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appenel;



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
public class BaixaRenda extends SuperConta implements IConta{
    private final String classe = "A2 - BAIXA RENDA"; 
    private float descontoTE;
    private float descontoTUSD;
    private final float porcentagemPIS = 0.95f;
    private final float porcentagemCOFINS = 4.39f;
    
    public BaixaRenda(int consumo){
        super(consumo);   
    }
    private float obterDescontoTE(){
        if(super.getConsumo() <= 30){
            this.descontoTE = 72f;
        }else if(super.getConsumo() <= 100){
            this.descontoTE = 50f;
        }else if(super.getConsumo() <= 220){
            this.descontoTE = 30f;
        }else if(super.getConsumo() > 2200){
            this.descontoTE = 25f;
        }
        return this.descontoTE;
    }
    private float obterDescontoTUSD(){
        if(super.getConsumo() <= 30){
            this.descontoTUSD = 65f;
        }else if(super.getConsumo() <= 100){
            this.descontoTUSD = 40f;
        }else if(super.getConsumo() <= 220){
            this.descontoTUSD = 10f;
        }
        return this.descontoTUSD;
    }
    
    @Override
    public String realizarCalculo(){
        super.setCOFINS(this.porcentagemCOFINS);
        super.setPIS(this.porcentagemPIS);
        super.setDescontoTE(obterDescontoTE());
        super.setDescontoTUSD(obterDescontoTUSD());
        
        return  "\nClasse:\t" +this.classe+
                super.toString();
    }
    
    @Override
    public boolean estaNoRangeDeConsumo() {
        return super.getConsumo() <= 5000;
    }

    @Override
    public String mensagemErro() {
         return "Valor inválido!"
               + "\nPor favor, digite um valor multiplo de 10, menor que 5000"; 
    }
}
