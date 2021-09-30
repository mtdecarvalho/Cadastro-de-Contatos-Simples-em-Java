/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDialogsEFrames;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author Juliana
 */
public class JanelaMenus extends javax.swing.JFrame {

    
    public JanelaMenus() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenuBar4 = new javax.swing.JMenuBar();
        jMenu7 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        jDialog3 = new javax.swing.JDialog();
        jDialog4 = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        menuIncluir = new javax.swing.JMenu();
        incluirFornecedor = new javax.swing.JMenuItem();
        incluirCliente = new javax.swing.JMenu();
        incluirPF = new javax.swing.JMenuItem();
        incluirPJ = new javax.swing.JMenuItem();
        incluirPessoal = new javax.swing.JMenuItem();
        incluirOutros = new javax.swing.JMenuItem();
        menuAlterar = new javax.swing.JMenu();
        editFornecedor = new javax.swing.JMenuItem();
        editCliente = new javax.swing.JMenu();
        editPF = new javax.swing.JMenuItem();
        editPJ = new javax.swing.JMenuItem();
        editPessoal = new javax.swing.JMenuItem();
        editOutros = new javax.swing.JMenuItem();
        menuExcluir = new javax.swing.JMenu();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu5.setText("File");
        jMenuBar3.add(jMenu5);

        jMenu6.setText("Edit");
        jMenuBar3.add(jMenu6);

        jMenu7.setText("File");
        jMenuBar4.add(jMenu7);

        jMenu8.setText("Edit");
        jMenuBar4.add(jMenu8);

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog3Layout = new javax.swing.GroupLayout(jDialog3.getContentPane());
        jDialog3.getContentPane().setLayout(jDialog3Layout);
        jDialog3Layout.setHorizontalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog3Layout.setVerticalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog4Layout = new javax.swing.GroupLayout(jDialog4.getContentPane());
        jDialog4.getContentPane().setLayout(jDialog4Layout);
        jDialog4Layout.setHorizontalGroup(
            jDialog4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog4Layout.setVerticalGroup(
            jDialog4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de Contatos");

        jLabel1.setFont(new java.awt.Font("Cambria Math", 0, 48)); // NOI18N
        jLabel1.setText("Cadastro");

        jLabel2.setFont(new java.awt.Font("Cambria Math", 0, 36)); // NOI18N
        jLabel2.setText("de");

        jLabel3.setFont(new java.awt.Font("Cambria Math", 0, 48)); // NOI18N
        jLabel3.setText("Contatos");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JDialogsEFrames/410909.png"))); // NOI18N

        menuIncluir.setText("Adicionar");

        incluirFornecedor.setText("Fornecedor");
        incluirFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                incluirFornecedorActionPerformed(evt);
            }
        });
        menuIncluir.add(incluirFornecedor);

        incluirCliente.setText("Cliente");

        incluirPF.setText("Pessoa Física");
        incluirPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                incluirPFActionPerformed(evt);
            }
        });
        incluirCliente.add(incluirPF);

        incluirPJ.setText("Pessoa Jurídica");
        incluirPJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                incluirPJActionPerformed(evt);
            }
        });
        incluirCliente.add(incluirPJ);

        menuIncluir.add(incluirCliente);

        incluirPessoal.setText("Pessoal");
        incluirPessoal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                incluirPessoalActionPerformed(evt);
            }
        });
        menuIncluir.add(incluirPessoal);

        incluirOutros.setText("Outros");
        incluirOutros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                incluirOutrosActionPerformed(evt);
            }
        });
        menuIncluir.add(incluirOutros);

        jMenuBar2.add(menuIncluir);

        menuAlterar.setText("Editar");

        editFornecedor.setText("Fornecedor");
        editFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editFornecedorActionPerformed(evt);
            }
        });
        menuAlterar.add(editFornecedor);

        editCliente.setText("Cliente");

        editPF.setText("Pessoa Física");
        editPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editPFActionPerformed(evt);
            }
        });
        editCliente.add(editPF);

        editPJ.setText("Pessoa Jurídica");
        editPJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editPJActionPerformed(evt);
            }
        });
        editCliente.add(editPJ);

        menuAlterar.add(editCliente);

        editPessoal.setText("Pessoal");
        editPessoal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editPessoalActionPerformed(evt);
            }
        });
        menuAlterar.add(editPessoal);

        editOutros.setText("Outros");
        editOutros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editOutrosActionPerformed(evt);
            }
        });
        menuAlterar.add(editOutros);

        jMenuBar2.add(menuAlterar);
        jMenuBar2.add(menuExcluir);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)))
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(9, 9, 9)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void incluirPessoalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_incluirPessoalActionPerformed
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        CadastrarPessoal abre = new CadastrarPessoal(frame, true);
        abre.setLocationRelativeTo(null);
        abre.setVisible(true);
    }//GEN-LAST:event_incluirPessoalActionPerformed

    private void incluirFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_incluirFornecedorActionPerformed
       JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        CadastrarFornecedor abre = new CadastrarFornecedor(frame, true);
        abre.setLocationRelativeTo(null);
        abre.setVisible(true);
    }//GEN-LAST:event_incluirFornecedorActionPerformed

    private void editFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editFornecedorActionPerformed
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        GradeCadastroFornecedor abre = new GradeCadastroFornecedor(frame, true);
        abre.setLocationRelativeTo(null);
        abre.setVisible(true);
    }//GEN-LAST:event_editFornecedorActionPerformed

    private void editPJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editPJActionPerformed
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        GradeCadastroPJ abre = new GradeCadastroPJ(frame, true);
        abre.setLocationRelativeTo(null);
        abre.setVisible(true);
    }//GEN-LAST:event_editPJActionPerformed

    private void incluirPJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_incluirPJActionPerformed
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        CadastrarPJ abre = new CadastrarPJ(frame, true);
        abre.setLocationRelativeTo(null);
        abre.setVisible(true);
    }//GEN-LAST:event_incluirPJActionPerformed

    private void incluirPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_incluirPFActionPerformed
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        CadastrarPF abre = new CadastrarPF(frame, true);
        abre.setLocationRelativeTo(null);
        abre.setVisible(true);
    }//GEN-LAST:event_incluirPFActionPerformed

    private void incluirOutrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_incluirOutrosActionPerformed
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        CadastrarOutros abre = new CadastrarOutros(frame, true);
        abre.setLocationRelativeTo(null);
        abre.setVisible(true);
    }//GEN-LAST:event_incluirOutrosActionPerformed

    private void editPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editPFActionPerformed
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        GradeCadastroPF abre = new GradeCadastroPF(frame, true);
        abre.setLocationRelativeTo(null);
        abre.setVisible(true);
    }//GEN-LAST:event_editPFActionPerformed

    private void editPessoalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editPessoalActionPerformed
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        GradeCadastroPessoal abre = new GradeCadastroPessoal(frame, true);
        abre.setLocationRelativeTo(null);
        abre.setVisible(true);
    }//GEN-LAST:event_editPessoalActionPerformed

    private void editOutrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editOutrosActionPerformed
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        GradeCadastroOutros abre = new GradeCadastroOutros(frame, true);
        abre.setLocationRelativeTo(null);
        abre.setVisible(true);
    }//GEN-LAST:event_editOutrosActionPerformed

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
            java.util.logging.Logger.getLogger(JanelaMenus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaMenus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaMenus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaMenus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaMenus().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu editCliente;
    private javax.swing.JMenuItem editFornecedor;
    private javax.swing.JMenuItem editOutros;
    private javax.swing.JMenuItem editPF;
    private javax.swing.JMenuItem editPJ;
    private javax.swing.JMenuItem editPessoal;
    private javax.swing.JMenu incluirCliente;
    private javax.swing.JMenuItem incluirFornecedor;
    private javax.swing.JMenuItem incluirOutros;
    private javax.swing.JMenuItem incluirPF;
    private javax.swing.JMenuItem incluirPJ;
    private javax.swing.JMenuItem incluirPessoal;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JDialog jDialog3;
    private javax.swing.JDialog jDialog4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuBar jMenuBar4;
    private javax.swing.JMenu menuAlterar;
    private javax.swing.JMenu menuExcluir;
    private javax.swing.JMenu menuIncluir;
    // End of variables declaration//GEN-END:variables
}
