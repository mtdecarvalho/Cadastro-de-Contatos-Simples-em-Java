package JFrames;

import Classes.ContatoPessoal;
import Classes.ModeloTabelaContatoPessoal;
import java.io.File;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class GradeCadastroOutrosJFORM extends javax.swing.JFrame {
    
    private ModeloTabelaContatoPessoal modeloClientes;
    private ArrayList<ContatoPessoal> clientes = new ArrayList<ContatoPessoal>();
    
    private void LerArquivo(){
        clientes.clear();
            Scanner entrada = null;
            try{
                try{
                    entrada = new Scanner(new File("ContatoPessoal.txt"));
                    while (entrada.hasNext()){
                        ContatoPessoal leitura = new ContatoPessoal();
                        leitura.setNome(entrada.next());
                        leitura.setEmail(entrada.next());
                        leitura.setTelefone(entrada.next());
                        leitura.setTelCel(entrada.next());
                        modeloClientes.inserirContato(leitura);
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
                    saida = new Formatter("ClientesPJ.txt");
                    for (int i = 0; i < clientes.size(); i++){
                        ContatoPessoal cliente = clientes.get(i);
                            saida.format("%s %s %s %s %s %s\n", cliente.getNome(), cliente.getEmail(), cliente.getTelefone(), 
                            cliente.getTelCel());
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

    public GradeCadastroOutrosJFORM() {
        initComponents();
        modeloClientes = new ModeloTabelaContatoPessoal(clientes);
        tbGradePessoal.setModel(modeloClientes);
        LerArquivo();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbGradePessoal = new javax.swing.JTable();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(tbGradePessoal);

        btnAlterar.setText("Alterar");

        btnExcluir.setText("Excluir");

        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnConsultar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnFechar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(btnAlterar)
                .addGap(33, 33, 33)
                .addComponent(btnExcluir)
                .addGap(35, 35, 35)
                .addComponent(btnConsultar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnFechar)
                .addGap(43, 43, 43))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        int indice = tbGradePessoal.getSelectedRow();
        if (indice >= 0){
            ContatoPessoal pessoal = modeloClientes.getContato(indice);
            JOptionPane.showMessageDialog(this, "Nome: " + pessoal.getNome() +  "\nE-mail: " + 
                    pessoal.getEmail() + "\nTelefone Fixo: " + pessoal.getTelefone() +
                    "\nTelefone Celular: " + pessoal.getTelCel());
        }
        else 
            JOptionPane.showMessageDialog(null, "É necessário selecionar uma pessoa");

    }//GEN-LAST:event_btnConsultarActionPerformed

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
            java.util.logging.Logger.getLogger(GradeCadastroOutrosJFORM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GradeCadastroOutrosJFORM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GradeCadastroOutrosJFORM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GradeCadastroOutrosJFORM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GradeCadastroOutrosJFORM().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFechar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbGradePessoal;
    // End of variables declaration//GEN-END:variables
}
