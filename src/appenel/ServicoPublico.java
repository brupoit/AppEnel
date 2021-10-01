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
public class ServicoPublico extends SuperConta implements IConta{
    private final String classe = "D - SERVIÇO PUBLICO";
    private final float porcentagemDescontoTE = 40f;
    private final float porcentagemDescontoTUSD = 40f;
    private final float porcentagemPIS = 0.95f;
    private final int porcentagemICMS = 18;
    
    public ServicoPublico(int consumo){
        super(consumo);      
    }
    
     @Override
    public boolean multiploDeDez(){
      return super.multiploDeDez();
    }
    
    @Override
    public String realizarCalculo(){
        super.setDescontoTE(this.porcentagemDescontoTE);
        super.setDescontoTUSD(this.porcentagemDescontoTUSD);
        super.setICMS(this.porcentagemICMS);
        super.setPIS(this.porcentagemPIS);
        
        return "\nClasse:\t" +this.classe+
                super.toString();
    }

    @Override
    public boolean estaNoRangeDeConsumo() {
        return super.getConsumo() >= 50 && super.getConsumo() <= 5000;
    }

    @Override
    public String mensagemErro() {
        return "Valor inválido!"
              + "\nPor favor, digite um valor multiplo de 10, entre 50 e 5000"; 
    }
}
