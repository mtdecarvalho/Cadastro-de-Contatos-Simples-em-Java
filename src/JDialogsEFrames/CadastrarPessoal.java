package JDialogsEFrames;

import javax.swing.JOptionPane;
import Classes.ContatoPessoal;
import Classes.opcCadastro;
import java.io.File;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;
/**
 *
 * @author Carvalho
 */
public class CadastrarPessoal extends javax.swing.JDialog {

    private ArrayList<ContatoPessoal> contatos = new ArrayList<ContatoPessoal>();
    private opcCadastro opc;
    private ContatoPessoal pessoalAlterado;
    private boolean confirmado;
    private int indice;
    
    public static boolean executar(java.awt.Frame parent, opcCadastro opc, ContatoPessoal p, int i){
        CadastrarPessoal cadastrar = new CadastrarPessoal(parent, opc, p, i);
        cadastrar.setLocationRelativeTo(null);
        cadastrar.setVisible(true);
        return cadastrar.opcConfirmada();
    }
    
    public CadastrarPessoal(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public CadastrarPessoal(java.awt.Frame parent, opcCadastro opc, ContatoPessoal p, int i){
        super(parent, true);
        confirmado = false;
        this.opc = opc;
        pessoalAlterado = p;
        this.indice = i;
        initComponents();
        if(opc == opc.ocAlterar){
            tbxNome.setText(p.getNome());       
            tbxEmail.setText(p.getEmail());
            tbxTelefoneFixo.setText(p.getTelefone());
            tbxTelefoneCel.setText(p.getTelCel());
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
                    entrada = new Scanner(new File("ContatosPessoais.txt"));
                    while (entrada.hasNext()){
                        ContatoPessoal leitura = new ContatoPessoal();
                        leitura.setNome(entrada.next());
                        leitura.setEmail(entrada.next());
                        leitura.setTelefone(entrada.next());
                        leitura.setTelCel(entrada.next());
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
                    saida = new Formatter("ContatosPessoais.txt");
                    for (int i = 0; i < contatos.size(); i++){
                        ContatoPessoal cliente = contatos.get(i);
                            saida.format("%s %s %s %s\n", cliente.getNome(), cliente.getEmail(),
                                    cliente.getTelefone(), cliente.getTelCel());
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

        jLabel5 = new javax.swing.JLabel();
        tbxNome = new javax.swing.JTextField();
        tbxEmail = new javax.swing.JTextField();
        tbxTelefoneFixo = new javax.swing.JTextField();
        tbxTelefoneCel = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnOk = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Contato Pessoal");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Tel. Celular:");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Nome:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("E-mail:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel6.setText("Contato Pessoal");

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

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Tel. Fixo:");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JDialogsEFrames/add.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tbxNome)
                    .addComponent(tbxEmail)
                    .addComponent(tbxTelefoneFixo)
                    .addComponent(tbxTelefoneCel, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addGap(48, 48, 48))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnOk)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar)
                        .addGap(35, 35, 35))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(tbxNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tbxEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tbxTelefoneFixo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbxTelefoneCel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOk)
                    .addComponent(btnCancelar))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        ContatoPessoal pessoal = new ContatoPessoal();
        LerArquivo();
        
        if(opc == opc.ocAlterar){          
            pessoalAlterado.setNome(tbxNome.getText());
            pessoalAlterado.setEmail(tbxEmail.getText());
            pessoalAlterado.setTelefone(tbxTelefoneFixo.getText());
            pessoalAlterado.setTelCel(tbxTelefoneCel.getText());
            contatos.set(indice, pessoal);
            JOptionPane.showMessageDialog(null, "Contato alterado com sucesso.");
            SalvarArquivo();
            confirmado = true;
            dispose();
        } else {
        
            pessoal.setNome(tbxNome.getText());
            pessoal.setEmail(tbxEmail.getText());
            pessoal.setTelefone(tbxTelefoneFixo.getText());
            pessoal.setTelCel(tbxTelefoneCel.getText());
            contatos.add(pessoal);
            JOptionPane.showMessageDialog(null, "Contato inserido com sucesso.");
            SalvarArquivo();
            dispose();
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
            java.util.logging.Logger.getLogger(CadastrarPessoal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastrarPessoal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastrarPessoal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastrarPessoal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CadastrarPessoal dialog = new CadastrarPessoal(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField tbxEmail;
    private javax.swing.JTextField tbxNome;
    private javax.swing.JTextField tbxTelefoneCel;
    private javax.swing.JTextField tbxTelefoneFixo;
    // End of variables declaration//GEN-END:variables
}
