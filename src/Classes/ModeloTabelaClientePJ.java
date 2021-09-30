package Classes;

import Classes.Contato;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModeloTabelaClientePJ extends AbstractTableModel {
    private static final int COLUNA_NOME = 0;
    private static final int COLUNA_CNPJ = 1;
    private static final int COLUNA_TELEFONE = 2;
    private static final int COLUNA_TELCOMERCIAL = 3;
    private static final int COLUNA_CEL = 4;
    private static final int COLUNA_FAX = 5;
    
    private String colunas[] = new String[]{"Nome", "CNPJ", "Telefone Fixo", "Telefone Comercial", "Celular", "FAX"};
    private ArrayList<ClientePJ> clientes;
    
    public ModeloTabelaClientePJ(ArrayList<ClientePJ> clientes){
        this.clientes = new ArrayList<ClientePJ>(clientes);
    }
    
    @Override
    public int getColumnCount(){
        return colunas.length;
    }
    @Override
    public int getRowCount(){
        return clientes.size();
    }
    @Override
    public String getColumnName(int coluna){
        return colunas[coluna];
    }
    @Override
    public boolean isCellEditable(int linha, int coluna){
        return false;
    }
    @Override
    public Object getValueAt(int linha, int coluna){
        ClientePJ cliente = clientes.get(linha);
        switch(coluna){
            case COLUNA_NOME:
                return cliente.getNome();
            case COLUNA_CNPJ:
                return cliente.getCNPJ();
            case COLUNA_TELEFONE:
                return cliente.getTelefone();
            case COLUNA_TELCOMERCIAL:
                return cliente.getTelComercial();
            case COLUNA_CEL:
                return cliente.getTelCel();
            case COLUNA_FAX:
                return cliente.getFAX();
        }
        return "";
    }
    @Override
    public void setValueAt(Object valor, int linha, int coluna){
        ClientePJ cliente = clientes.get(linha);
        switch(coluna){
            case COLUNA_NOME:
                cliente.setNome(valor.toString());
                break;
            case COLUNA_CNPJ:
                cliente.setCNPJ(valor.toString());
                break;
            case COLUNA_TELEFONE:
                cliente.setTelefone(valor.toString());
                break;
            case COLUNA_TELCOMERCIAL:
                cliente.setTelComercial(valor.toString());
                break;
            case COLUNA_CEL:
                cliente.setTelCel(valor.toString());
                break;
            case COLUNA_FAX:
                cliente.setFAX(valor.toString());
                break;
        }
    }
    
    public ClientePJ getContato(int indice){
        return clientes.get(indice);
    }
    public void inserirContato(ClientePJ cliente){
        clientes.add(cliente);
        int ultimo = getRowCount()-1;
        fireTableRowsInserted(ultimo, ultimo);
    }
    public void atualizarContato(int indice, ClientePJ cliente){
        clientes.set(indice, cliente);
        fireTableRowsUpdated(indice, indice);

    }
    public void excluirContato(int indice){
        clientes.remove(indice);
        fireTableRowsDeleted(indice, indice);
        
    }

    
}
