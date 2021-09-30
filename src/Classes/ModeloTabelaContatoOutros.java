package Classes;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModeloTabelaContatoOutros extends AbstractTableModel {
    private static final int COLUNA_NOME = 0;
    private static final int COLUNA_EMAIL = 1;
    private static final int COLUNA_TELEFONE = 2;
    
    private String colunas[] = new String[]{"Nome", "Email", "Telefone Fixo"};
    private ArrayList<ContatoOutros> clientes;
    
    public ModeloTabelaContatoOutros(ArrayList<ContatoOutros> clientes){
        this.clientes = new ArrayList<ContatoOutros>(clientes);
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
        ContatoOutros cliente = clientes.get(linha);
        switch(coluna){
            case COLUNA_NOME:
                return cliente.getNome();
            case COLUNA_EMAIL:
                return cliente.getEmail();
            case COLUNA_TELEFONE:
                return cliente.getTelefone();
        }
        return "";
    }
    @Override
    public void setValueAt(Object valor, int linha, int coluna){
        ContatoOutros cliente = clientes.get(linha);
        switch(coluna){
            case COLUNA_NOME:
                cliente.setNome(valor.toString());
                break;
            case COLUNA_EMAIL:
                cliente.setEmail(valor.toString());
                break;
            case COLUNA_TELEFONE:
                cliente.setTelefone(valor.toString());
                break;
        }
    }
    
    public ContatoOutros getContato(int indice){
        return clientes.get(indice);
    }
    public void inserirContato(ContatoOutros cliente){
        clientes.add(cliente);
        int ultimo = getRowCount()-1;
        fireTableRowsInserted(ultimo, ultimo);
    }
    public void atualizarContato(int indice, ContatoOutros cliente){
        clientes.set(indice, cliente);
        fireTableRowsUpdated(indice, indice);

    }
    public void excluirContato(int indice){
        clientes.remove(indice);
        fireTableRowsDeleted(indice, indice);
        
    }

    
}
