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
public class SuperConta {
    private int consumo;
    private final float TE;
    private final float TUSD;
    private float ICMS;
    private float PIS;
    private float COFINS;
    private float COSIP;
    private float descontoTE;
    private float descontoTUSD;
    
    public SuperConta(int consumo){
        this.TE = 0.25588f;
        this.TUSD = 0.25971f;
        this.descontoTE = 0f;
        this.descontoTUSD =0f;
        this.PIS = 0f;
        this.COFINS = 0f;
        this.COSIP = 0f;
        this.ICMS = 0f;
        this.consumo = consumo;
        
        
    }
    public float getICMS(){
        return this.ICMS;
    }
    public float getPIS(){
        return this.PIS;
    }
    public float getCOFINS(){
        return this.COFINS;
    }
    public float getCOSIP(){
        return this.COSIP;
    }
    
    public float getTE(){
        return this.TE;
    }
    public float getTUSD(){
        return this.TUSD;
    }
 
    public int getConsumo(){
        return this.consumo;
    }
    public float getDescontoTE(){
        return this.descontoTE;
    }
    public float getDescontoTUSD(){
        return this.descontoTUSD;
    }
    public void setICMS(int ICMS){
        this.ICMS = ICMS;
    }
    public void setPIS(float PIS){
         this.PIS = PIS;
    }
    public void setCOFINS(float COFINS){
        this.COFINS = COFINS;
    }
    public void setCOSIP(float COSIP){
       this.COSIP = COSIP;
    }
    
    public void setConsumo(int consumo){
        this.consumo = consumo;
    }
    public void setDescontoTE(float descontoTE){
        this.descontoTE = descontoTE;
    }
    public void setDescontoTUSD(float descontoTUSD){
        this.descontoTUSD = descontoTUSD;
    }
    
    public float valorTE(){
       return this.consumo * this.TE; 
    }
    
    public float valorTUSD(){
       return this.consumo * this.TUSD; 
    }
    public float valorBase(){
        return valorTE() + valorTUSD();
    }
    public float valorICMS(){
        return ((getICMS()*valorBase())/100);
    }
    public float valorPIS(){
        return ((getPIS()*valorBase())/100);
    }
    public float valorCOFINS(){
        return ((getCOFINS()*valorBase())/100);
    }
    public float valorDescontoTE(){
        return ((getDescontoTE()*valorTE())/100);
    }
    public float valorDescontoTUSD(){
        return ((getDescontoTUSD()*valorTUSD())/100);
    }
    public float totalImposto(){
        return valorICMS()+ valorPIS() + valorCOFINS() + getCOSIP();
    }
    public float totalDesconto(){
        return valorDescontoTE()+ valorDescontoTUSD();
    }
    public float valorTotal(){
        return (valorBase()+ totalImposto())-totalDesconto();
    }
    public boolean multiploDeDez(){
        
        return this.consumo%10 == 0;
    }
            
     @Override
    public String toString(){
        return "\nBase:\t" +
               "\nConsumo:\t" + getConsumo()+"kWh"+
               "\nTE:\t R$ " + String.format("%.2f", valorTE())+
               "\nTUSD:\t R$ " + String.format("%.2f",valorTUSD())+
               "\nImpostos:\t" +
               "\nICMS:\t R$ " + String.format("%.2f",valorICMS())+
               "\nPIS:\t R$ " + String.format("%.2f",valorPIS())+
               "\nCOFINS:\t R$ " + String.format("%.2f",valorCOFINS())+
               "\nCOSIP:\t R$ " + String.format("%.2f",getCOSIP())+
               "\nDescontos:\t" +
               "\nDesconto TE:\t R$ " + String.format("%.2f",valorDescontoTE())+
               "\nDesconto TUSD:\t R$ " + String.format("%.2f",valorDescontoTUSD())+
               "\nTotal a Pagar:\t R$ " + String.format("%.2f",valorTotal());
    }   
    
}
