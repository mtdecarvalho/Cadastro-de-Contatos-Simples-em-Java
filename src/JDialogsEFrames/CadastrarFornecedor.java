/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDialogsEFrames;

import Classes.verificarCPFCNPJ;
import Classes.ContatoFornecedor;
import Classes.opcCadastro;
import java.io.File;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Carvalho
 */
public class CadastrarFornecedor extends javax.swing.JDialog {

    private ArrayList<ContatoFornecedor> fornecedores = new ArrayList<ContatoFornecedor>();
    private opcCadastro opc;
    private ContatoFornecedor fornecedorAlterado;
    private boolean confirmado;
    private int indice;
    
    public static boolean executar(java.awt.Frame parent, opcCadastro opc, ContatoFornecedor f, int i){
        CadastrarFornecedor cadastrar = new CadastrarFornecedor(parent, opc, f, i);
        cadastrar.setLocationRelativeTo(null);
        cadastrar.setVisible(true);
        return cadastrar.opcConfirmada();
    }
    
    public CadastrarFornecedor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public CadastrarFornecedor(java.awt.Frame parent, opcCadastro opc, ContatoFornecedor f, int i){
        super(parent, true);
        confirmado = false;
        this.opc = opc;
        fornecedorAlterado = f;
        this.indice = i;
        initComponents();
        if(opc == opc.ocAlterar){
            tbxNome.setText(f.getNome());
            tbxCNPJ.setText(f.getCNPJ());
            tbxEmail.setText(f.getEmail());
            tbxTelefoneFixo.setText(f.getTelefone());
            tbxFAX.setText(f.getFAX());
        }    
    }
    
    public boolean opcConfirmada(){
        return confirmado;
    }

    private void LerArquivo(){
        fornecedores.clear();
            Scanner entrada = null;
            try{
                try{
                    entrada = new Scanner(new File("Fornecedores.txt"));
                    while (entrada.hasNext()){
                        ContatoFornecedor leitura = new ContatoFornecedor();
                        leitura.setNome(entrada.next());
                        leitura.setCNPJ(entrada.next());
                        leitura.setEmail(entrada.next());
                        leitura.setTelefone(entrada.next());
                        leitura.setFAX(entrada.next());
                        fornecedores.add(leitura);                    
                    }
                } 
                finally {
                    if (entrada != null){
                        entrada.close();
                    }
                }
            } 
            catch (Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
    }
    
    private void SalvarArquivo(){
        Formatter saida = null;
            try{
                try{
                    saida = new Formatter("Fornecedores.txt");
                    for (int i = 0; i < fornecedores.size(); i++){
                        ContatoFornecedor cliente = fornecedores.get(i);
                        saida.format("%s %s %s %s %s\n", cliente.getNome(), cliente.getCNPJ(), cliente.getEmail(), 
                        cliente.getTelefone(), cliente.getFAX());
                    }
                }
                finally{
                    if (saida!= null){
                        saida.close();
                    }
                }
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
    }
    
    public int VerificacaoCNPJ(String cnpj)
    {
        verificarCPFCNPJ verificar = new verificarCPFCNPJ();
        if ( verificar.validarFormatoCNPJ(tbxCNPJ.getText()) )
        {
            if ( verificar.verificarCNPJ(tbxCNPJ.getText()) )
            {
                    if ( !verificar.cnpjExisteFornecedor(tbxCNPJ.getText(), fornecedores, indice) )
                        return 0;
                    else
                    {
                        JOptionPane.showMessageDialog(this, "CNPJ já existe!");
                        return 3;
                    }
            } else
            {
                JOptionPane.showMessageDialog(this, "CNPJ inválido!");
                return 2;
            }
        } else
        {
            JOptionPane.showMessageDialog(this, "CNPJ com formatação inválido! Use apenas números.");
            return 1;
        }
                
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tbxTelefoneFixo = new javax.swing.JTextField();
        tbxFAX = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnOk = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tbxNome = new javax.swing.JTextField();
        tbxCNPJ = new javax.swing.JTextField();
        tbxEmail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Fornecedor");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel6.setText("Fornecedor");

        btnOk.setText("Ok");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Nome:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("CNPJ:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("E-mail:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Telefone fixo:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("FAX:");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JDialogsEFrames/add.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tbxNome)
                                    .addComponent(tbxCNPJ)
                                    .addComponent(tbxEmail)
                                    .addComponent(tbxTelefoneFixo)
                                    .addComponent(tbxFAX, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnOk)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelar))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tbxNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(tbxCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(tbxEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(tbxTelefoneFixo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(tbxFAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOk)
                    .addComponent(btnCancelar))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        ContatoFornecedor fornecedor = new ContatoFornecedor();
        LerArquivo();
        if(opc == opc.ocAlterar)
        {
            if (VerificacaoCNPJ(tbxCNPJ.getText()) == 0)
            {
                fornecedorAlterado.setNome(tbxNome.getText());
                fornecedorAlterado.setCNPJ(tbxCNPJ.getText());
                fornecedorAlterado.setEmail(tbxEmail.getText());
                fornecedorAlterado.setTelefone(tbxTelefoneFixo.getText());
                fornecedorAlterado.setFAX(tbxFAX.getText());
                fornecedores.set(indice, fornecedorAlterado);
                JOptionPane.showMessageDialog(null, "Contato alterado com sucesso.");
                SalvarArquivo();
                confirmado = true;
                dispose();
            } 
        } else {
            if (VerificacaoCNPJ(tbxCNPJ.getText()) == 0)
            {
                fornecedor.setNome(tbxNome.getText());
                fornecedor.setCNPJ(tbxCNPJ.getText());
                fornecedor.setEmail(tbxEmail.getText());
                fornecedor.setTelefone(tbxTelefoneFixo.getText());
                fornecedor.setFAX(tbxFAX.getText());
                fornecedores.add(fornecedor);
                JOptionPane.showMessageDialog(null, "Contato inserido com sucesso.");
                SalvarArquivo();
                dispose();
            }
        }
    }//GEN-LAST:event_btnOkActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if(JOptionPane.showConfirmDialog(null, "Cancelar cadastro?") == 0)
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastrarFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastrarFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastrarFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastrarFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CadastrarFornecedor dialog = new CadastrarFornecedor(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnOk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField tbxCNPJ;
    private javax.swing.JTextField tbxEmail;
    private javax.swing.JTextField tbxFAX;
    private javax.swing.JTextField tbxNome;
    private javax.swing.JTextField tbxTelefoneFixo;
    // End of variables declaration//GEN-END:variables
}
