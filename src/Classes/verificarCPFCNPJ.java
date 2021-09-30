/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Classes.ClientePF;
import Classes.ClientePJ;
import Classes.ContatoFornecedor;
import java.util.ArrayList;

/**
 *
 * @author Carvalho
 */
public class verificarCPFCNPJ {
    public boolean cpfExiste(String cpf, ArrayList<ClientePF> clientes, int excecao)
    {
        
        for ( int i = 0 ; i < clientes.size() ; i++ )
        {
            ClientePF cliente = clientes.get(i);
            if ( cliente.getCPF().equals(cpf) && i != excecao )
                return true;
        }
        return false;
    }
    
    public boolean validarFormatoCPF(String cpf)
    {
        if (cpf.matches("[0-9]+") && cpf.length() == 11)
            return true;
        else if ( cpf.isBlank() )
            return false;
        else
            return false;
    }
    
    public boolean verificarCPF(String cpf)
    {
        int primeiroDigito = 0, segundoDigito = 0;
        
        for ( int i = 10, k = 0 ; i >= 2 ; i--, k++ )
        {
            int numero = Character.getNumericValue(cpf.charAt(k));
            primeiroDigito += numero * i;
        }
        if ( 11 - (primeiroDigito % 11) >= 10 ) primeiroDigito = 0;
        else primeiroDigito = 11 - (primeiroDigito % 11);

        
        for ( int i = 11, k = 0 ; i >= 2 ; i--, k++ )
        {
            int numero = Character.getNumericValue(cpf.charAt(k));
            segundoDigito += numero * i;
        }
        if ( 11 - (segundoDigito % 11) >= 10 ) segundoDigito = 0;
        else segundoDigito = 11 - (segundoDigito % 11);
        
        if (primeiroDigito == Character.getNumericValue(cpf.charAt(9)) && segundoDigito == Character.getNumericValue(cpf.charAt(10)) )
            return true; // valido
        else 
            return false;
    }
    
    public boolean cnpjExistePJ(String cnpj, ArrayList<ClientePJ> clientes, int excecao)
    {
        
        for ( int i = 0 ; i < clientes.size() ; i++ )
        {
            ClientePJ cliente = clientes.get(i);
            if ( cliente.getCNPJ().equals(cnpj) && i != excecao)
                return true;
        }
        return false;
    }
    
    public boolean cnpjExisteFornecedor(String cnpj, ArrayList<ContatoFornecedor> fornecedores, int excecao)
    {
        
        for ( int i = 0 ; i < fornecedores.size() ; i++ )
        {
            ContatoFornecedor fornecedor = fornecedores.get(i);
            if ( fornecedor.getCNPJ().equals(cnpj) && i != excecao)
                return true;
        }
        return false;
    }
    
    public boolean validarFormatoCNPJ(String cnpj)
    {
        if ( cnpj.matches("[0-9]+") && cnpj.length() == 14 )
            return true;
        else if ( cnpj.isBlank() )
            return false;
        else
            return false;
    }
    
    public boolean verificarCNPJ(String cnpj)
    {
        int primeiroDigito = 0, segundoDigito = 0;
        
        for ( int i = 0, k = 5 ; i <= 11 ; i++, k-- )
        {
            int numero = Character.getNumericValue(cnpj.charAt(i));
            primeiroDigito += numero * k;
            if ( i == 3 ) k = 10; // reseta o peso no proximo loop pra 9 (10 por que 10-1 = 9)
        }
        if ( 11 - (primeiroDigito % 11) >= 10 ) primeiroDigito = 0;
        else primeiroDigito = 11 - (primeiroDigito % 11);

        //59541264000103
        for ( int i = 0, k = 6 ; i <= 12 ; i++, k-- )
        {
            int numero = Character.getNumericValue(cnpj.charAt(i));
            segundoDigito += numero * k;
            if ( i == 4 ) k = 10; //reseta o peso no proximo loop pra 9 (10 por que 10-1 = 9)
        }
        if ( 11 - (segundoDigito % 11) >= 10 ) segundoDigito = 0;
        else segundoDigito = 11 - (segundoDigito % 11);
        
        if (primeiroDigito == Character.getNumericValue(cnpj.charAt(12)) && segundoDigito == Character.getNumericValue(cnpj.charAt(13)) )
            return true; // valido
        else 
            return false;
    }
    
}
