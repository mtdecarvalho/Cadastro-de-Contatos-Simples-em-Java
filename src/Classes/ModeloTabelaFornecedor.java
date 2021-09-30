package Classes;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModeloTabelaFornecedor extends AbstractTableModel {
    private static final int COLUNA_NOME = 0;
    private static final int COLUNA_CNPJ = 1;
    private static final int COLUNA_EMAIL = 2;
    private static final int COLUNA_TELEFONE = 3;
    private static final int COLUNA_FAX = 4;
    
    private String colunas[] = new String[]{"Nome", "CNPJ", "Email", "Telefone Fixo", "FAX"};
    private ArrayList<ContatoFornecedor> contatos;
    
    public ModeloTabelaFornecedor(ArrayList<ContatoFornecedor> contatos){
        this.contatos = new ArrayList<ContatoFornecedor>(contatos);
    }
    
    @Override
    public int getColumnCount(){
        return colunas.length;
    }
    @Override
    public int getRowCount(){
        return contatos.size();
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
        ContatoFornecedor fornecedor = contatos.get(linha);
        switch(coluna){
            case COLUNA_NOME:
                return fornecedor.getNome();
            case COLUNA_CNPJ:
                return fornecedor.getCNPJ();
            case COLUNA_EMAIL:
                return fornecedor.getEmail();
            case COLUNA_TELEFONE:
                return fornecedor.getTelefone();
            case COLUNA_FAX:
                return fornecedor.getFAX();
        }
        return "";
    }
    @Override
    public void setValueAt(Object valor, int linha, int coluna){
        ContatoFornecedor fornecedor = contatos.get(linha);
        switch(coluna){
            case COLUNA_NOME:
                fornecedor.setNome(valor.toString());
                break;
            case COLUNA_TELEFONE:
                fornecedor.setTelefone(valor.toString());
                break;
        }
    }
    
    public ContatoFornecedor getContato(int indice){
        return contatos.get(indice);
    }
    public void inserirContato(ContatoFornecedor fornecedor){
        contatos.add(fornecedor);
        int ultimo = getRowCount()-1;
        fireTableRowsInserted(ultimo, ultimo);
    }
    public void atualizarContato(int indice, ContatoFornecedor fornecedor){
        contatos.set(indice, fornecedor);
        fireTableRowsUpdated(indice, indice);
        fireTableDataChanged();
    }
    public void excluirContato(int indice){
        contatos.remove(indice);
        fireTableRowsDeleted(indice, indice);
        
    }
}
