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
public class Residencial extends SuperConta implements IConta{
    private final String classe = "A1 - Residencial";
    private final float porcentagemPIS = 0.95f;
    private final float porcentagemCOFINS = 4.39f;
    private final float valorCOSIP = 9.70f;
    private final int consumoMinimo = 91;
    private final int consumoMaximo = 200;
    private int porcentagemICMS;
    private final int minimo = 50;
    
    
    public Residencial(int consumo){
        super(consumo);
    }
    
    private int obterAliquotaICMS(){
        if(rangeMedio())
            this.porcentagemICMS = 12;
        else if (acimaRangeMedio())
            this.porcentagemICMS = 25;
        
        return this.porcentagemICMS;
    }
    
    
    @Override
    public String realizarCalculo(){
        super.setPIS(this.porcentagemPIS);
        super.setCOSIP(this.valorCOSIP);
        super.setICMS(obterAliquotaICMS());
        super.setCOFINS(this.porcentagemCOFINS);
        return  "\nClasse:\t" +this.classe+
                super.toString();
    }
    
    
    @Override
    public boolean multiploDeDez(){
      return super.multiploDeDez();
    }
    
    @Override
    public boolean estaNoRangeDeConsumo(){
        return super.getConsumo() >= 50 && super.getConsumo() <= 5000;
    }
    
    @Override
    public String mensagemErro() {
        return "Valor inválido!"
               + "\nPor favor, digite um valor multiplo de 10, entre 50 e 5000"; 
    }
    
     private boolean acimaRangeMedio() {
        return super.getConsumo() > this.consumoMaximo;
    }

    private boolean rangeMedio() {
        return super.getConsumo() >= this.consumoMinimo && super.getConsumo() <= this.consumoMaximo;
    }


}
