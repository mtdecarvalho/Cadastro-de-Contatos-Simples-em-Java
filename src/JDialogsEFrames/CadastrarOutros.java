/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDialogsEFrames;

import Classes.ContatoOutros;
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
public class CadastrarOutros extends javax.swing.JDialog {

    private ArrayList<ContatoOutros> contatos = new ArrayList<ContatoOutros>();
    private opcCadastro opc;
    private ContatoOutros outrosAlterado;
    private boolean confirmado;
    private int indice;
    
    public static boolean executar(java.awt.Frame parent, opcCadastro opc, ContatoOutros o, int i){
        CadastrarOutros cadastrar = new CadastrarOutros(parent, opc, o, i);
        cadastrar.setLocationRelativeTo(null);
        cadastrar.setVisible(true);
        return cadastrar.opcConfirmada();
    }
    
    public CadastrarOutros(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public CadastrarOutros(java.awt.Frame parent, opcCadastro opc, ContatoOutros o, int i){
        super(parent, true);
        confirmado = false;
        this.opc = opc;
        outrosAlterado = o;
        this.indice = i;
        initComponents();
        if(opc == opc.ocAlterar){
            tbxNome.setText(o.getNome());       
            tbxEmail.setText(o.getEmail());
            tbxTelefoneFixo.setText(o.getTelefone());
        }    
    }
    
    public boolean opcConfirmada(){
        return confirmado;
    }

    private void LerArquivo(){
        contatos.clear();
            Scanner entrada = null;
            try{
                try{
                    entrada = new Scanner(new File("ContatosOutros.txt"));
                    while (entrada.hasNext()){
                        ContatoOutros leitura = new ContatoOutros();
                        leitura.setNome(entrada.next());
                        leitura.setEmail(entrada.next());
                        leitura.setTelefone(entrada.next());
                        contatos.add(leitura);
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
                    saida = new Formatter("ContatosOutros.txt");
                    for (int i = 0; i < contatos.size(); i++){
                        ContatoOutros cliente = contatos.get(i);
                            saida.format("%s %s %s\n", cliente.getNome(), cliente.getEmail(),
                                    cliente.getTelefone());
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        tbxNome = new javax.swing.JTextField();
        tbxEmail = new javax.swing.JTextField();
        tbxTelefoneFixo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnOk = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Outros");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Tel. Fixo:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel7.setText("Outros");

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
        jLabel2.setText("E-mail:");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JDialogsEFrames/add.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tbxNome)
                                    .addComponent(tbxEmail)
                                    .addComponent(tbxTelefoneFixo, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnOk)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelar)))))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tbxNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tbxEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tbxTelefoneFixo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOk)
                    .addComponent(btnCancelar))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        ContatoOutros outros = new ContatoOutros();
        LerArquivo();
        
        if(opc == opc.ocAlterar){          
            outrosAlterado.setNome(tbxNome.getText());
            outrosAlterado.setEmail(tbxEmail.getText());
            outrosAlterado.setTelefone(tbxTelefoneFixo.getText());
            contatos.set(indice, outros);
            JOptionPane.showMessageDialog(null, "Contato alterado com sucesso.");
            SalvarArquivo();
            confirmado = true;
            dispose();
        } else {
        
            outros.setNome(tbxNome.getText());
            outros.setEmail(tbxEmail.getText());
            outros.setTelefone(tbxTelefoneFixo.getText());
            contatos.add(outros);
            JOptionPane.showMessageDialog(null, "Contato inserido com sucesso.");
            dispose();
        }
        SalvarArquivo();
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
            java.util.logging.Logger.getLogger(CadastrarOutros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastrarOutros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastrarOutros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastrarOutros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CadastrarOutros dialog = new CadastrarOutros(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField tbxEmail;
    private javax.swing.JTextField tbxNome;
    private javax.swing.JTextField tbxTelefoneFixo;
    // End of variables declaration//GEN-END:variables
}
