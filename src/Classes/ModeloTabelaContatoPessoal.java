package Classes;

import Classes.ContatoPessoal;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModeloTabelaContatoPessoal extends AbstractTableModel {
    private static final int COLUNA_NOME = 0;
    private static final int COLUNA_EMAIL = 1;
    private static final int COLUNA_TELEFONE = 2;
    private static final int COLUNA_CELULAR = 3;
    
    private String colunas[] = new String[]{"Nome", "Email", "Telefone Fixo", "Celular"};
    private ArrayList<ContatoPessoal> clientes;
    
    public ModeloTabelaContatoPessoal(ArrayList<ContatoPessoal> clientes){
        this.clientes = new ArrayList<ContatoPessoal>(clientes);
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
        ContatoPessoal cliente = clientes.get(linha);
        switch(coluna){
            case COLUNA_NOME:
                return cliente.getNome();
            case COLUNA_EMAIL:
                return cliente.getEmail();
            case COLUNA_TELEFONE:
                return cliente.getTelefone();
            case COLUNA_CELULAR:
                return cliente.getTelCel();
        }
        return "";
    }
    @Override
    public void setValueAt(Object valor, int linha, int coluna){
        ContatoPessoal cliente = clientes.get(linha);
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
            case COLUNA_CELULAR:
                cliente.setTelCel(valor.toString());
                break;
        }
    }
    
    public ContatoPessoal getContato(int indice){
        return clientes.get(indice);
    }
    public void inserirContato(ContatoPessoal cliente){
        clientes.add(cliente);
        int ultimo = getRowCount()-1;
        fireTableRowsInserted(ultimo, ultimo);
    }
    public void atualizarContato(int indice, ContatoPessoal cliente){
        clientes.set(indice, cliente);
        fireTableRowsUpdated(indice, indice);

    }
    public void excluirContato(int indice){
        clientes.remove(indice);
        fireTableRowsDeleted(indice, indice);
        
    }

    
}
