package Classes;

public class ContatoPessoal extends Contato {
    private String email;
    private String telefone_celular;
    
    public String getEmail(){
        return email;
    }
    public String getTelCel(){
        return telefone_celular;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setTelCel(String telcel){
        this.telefone_celular = telcel;
    }  
}
