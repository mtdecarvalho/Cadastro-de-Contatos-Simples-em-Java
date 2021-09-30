package Classes;

public class ContatoCliente extends Contato {
    // telefone = telefone residencial
    private String telefone_celular;
    private String telefone_comercial;
    private String FAX;
    
    public String getTelCel(){
        return telefone_celular;
    }
    public String getTelComercial(){
        return telefone_comercial;
    }
    public String getFAX(){
        return FAX;
    }
    
    public void setTelCel(String telCel){
        this.telefone_celular = telCel;
    }
    public void setTelComercial(String telComercial){
        this.telefone_comercial = telComercial;
    }
    public void setFAX(String FAX){
        this.FAX = FAX;
    }
}
