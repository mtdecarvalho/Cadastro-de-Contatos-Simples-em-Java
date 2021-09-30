package JDialogsEFrames;

import Classes.verificarCPFCNPJ;
import Classes.ClientePJ;
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
public class CadastrarPJ extends javax.swing.JDialog {

    private ArrayList<ClientePJ> clientes = new ArrayList<ClientePJ>();
    private opcCadastro opc;
    private ClientePJ pjAlterado;
    private boolean confirmado;
    private int indice;
    
    public static boolean executar(java.awt.Frame parent, opcCadastro opc, ClientePJ pj, int i){
        CadastrarPJ cadastrar = new CadastrarPJ(parent, opc, pj, i);
        cadastrar.setLocationRelativeTo(null);
        cadastrar.setVisible(true);
        return cadastrar.opcConfirmada();
    }
    
    public CadastrarPJ(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public CadastrarPJ(java.awt.Frame parent, opcCadastro opc, ClientePJ pj, int i){
        super(parent, true);
        confirmado = false;
        this.opc = opc;
        pjAlterado = pj;
        this.indice = i;
        initComponents();
        if(opc == opc.ocAlterar){
            tbxNome.setText(pj.getNome());
            tbxCNPJ.setText(pj.getCNPJ());
            tbxTelefoneRes.setText(pj.getTelefone());
            tbxTelefoneComercial.setText(pj.getTelComercial());
            tbxTelefoneCel.setText(pj.getTelCel());
            tbxFAX.setText(pj.getFAX());
        }    
    }
    
    public boolean opcConfirmada(){
        return confirmado;
    }

    private void LerArquivo(){
        clientes.clear();
            Scanner entrada = null;
            try{
                try{
                    entrada = new Scanner(new File("ClientesPJ.txt"));
                    while (entrada.hasNext()){
                        ClientePJ leitura = new ClientePJ();
                        leitura.setNome(entrada.next());
                        leitura.setCNPJ(entrada.next());
                        leitura.setTelefone(entrada.next());
                        leitura.setTelComercial(entrada.next());
                        leitura.setTelCel(entrada.next());
                        leitura.setFAX(entrada.next());
                        clientes.add(leitura);
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
                        ClientePJ cliente = clientes.get(i);
                            saida.format("%s %s %s %s %s %s\n", cliente.getNome(), cliente.getCNPJ(), cliente.getTelefone(), 
                            cliente.getTelComercial(), cliente.getTelCel(), cliente.getFAX());
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
                    if ( !verificar.cnpjExistePJ(tbxCNPJ.getText(), clientes, indice) )
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

        tbxFAX = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnOk = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tbxNome = new javax.swing.JTextField();
        tbxCNPJ = new javax.swing.JTextField();
        tbxTelefoneRes = new javax.swing.JTextField();
        tbxTelefoneComercial = new javax.swing.JTextField();
        tbxTelefoneCel = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Pessoa Jurídica");

        tbxFAX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbxFAXActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("CNPJ:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel7.setText("Pessoa Jurídica");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Tel. Residencial:");

        btnOk.setText("Ok");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Tel. Comercial:");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Tel. Celular:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("FAX:");

        tbxTelefoneRes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbxTelefoneResActionPerformed(evt);
            }
        });

        tbxTelefoneComercial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbxTelefoneComercialActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Nome:");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JDialogsEFrames/add.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnOk)
                        .addGap(29, 29, 29)
                        .addComponent(btnCancelar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel3)
                                .addComponent(jLabel6)
                                .addComponent(jLabel2)
                                .addComponent(jLabel5))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tbxCNPJ)
                                .addComponent(tbxTelefoneRes)
                                .addComponent(tbxTelefoneComercial)
                                .addComponent(tbxTelefoneCel)
                                .addComponent(tbxFAX, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tbxNome, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel7)
                            .addGap(42, 42, 42))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
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
                    .addComponent(tbxTelefoneRes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tbxTelefoneComercial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(tbxTelefoneCel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(tbxFAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOk)
                    .addComponent(btnCancelar))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbxFAXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbxFAXActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbxFAXActionPerformed

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        ClientePJ PJ = new ClientePJ();
        LerArquivo();
        if(opc == opc.ocAlterar)
        {
            if (VerificacaoCNPJ(tbxCNPJ.getText()) == 0)
            {
                pjAlterado.setNome(tbxNome.getText());
                pjAlterado.setCNPJ(tbxCNPJ.getText());
                pjAlterado.setTelefone(tbxTelefoneRes.getText());
                pjAlterado.setTelComercial(tbxTelefoneComercial.getText());
                pjAlterado.setTelCel(tbxTelefoneCel.getText());
                pjAlterado.setFAX(tbxFAX.getText());
                clientes.set(indice, pjAlterado);
                JOptionPane.showMessageDialog(null, "Contato alterado com sucesso.");
                SalvarArquivo();
                confirmado = true;
                dispose();
            }  
        } else {
            if (VerificacaoCNPJ(tbxCNPJ.getText()) == 0)
            {
                PJ.setNome(tbxNome.getText());
                PJ.setCNPJ(tbxCNPJ.getText());
                PJ.setTelefone(tbxTelefoneRes.getText());
                PJ.setTelComercial(tbxTelefoneComercial.getText());
                PJ.setTelCel(tbxTelefoneComercial.getText());
                PJ.setFAX(tbxFAX.getText());
                clientes.add(PJ);
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

    private void tbxTelefoneResActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbxTelefoneResActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbxTelefoneResActionPerformed

    private void tbxTelefoneComercialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbxTelefoneComercialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbxTelefoneComercialActionPerformed

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
            java.util.logging.Logger.getLogger(CadastrarPJ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastrarPJ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastrarPJ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastrarPJ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CadastrarPJ dialog = new CadastrarPJ(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField tbxCNPJ;
    private javax.swing.JTextField tbxFAX;
    private javax.swing.JTextField tbxNome;
    private javax.swing.JTextField tbxTelefoneCel;
    private javax.swing.JTextField tbxTelefoneComercial;
    private javax.swing.JTextField tbxTelefoneRes;
    // End of variables declaration//GEN-END:variables
}
