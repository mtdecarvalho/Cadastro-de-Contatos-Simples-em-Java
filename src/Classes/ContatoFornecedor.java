
package Classes;

public class ContatoFornecedor extends Contato {
    private String CNPJ;
    private String email;
    private String FAX;
    
    public String getCNPJ(){
        return CNPJ;
    }
    
    public String getEmail(){
        return email;
    }
    
    public String getFAX(){
        return FAX;
    }
    public void setCNPJ(String cnpj){
        this.CNPJ = cnpj;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setFAX(String fax){
        this.FAX = fax;
    }
}
