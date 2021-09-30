package JDialogsEFrames;

import Classes.ClientePF;
import Classes.opcCadastro;
import Classes.verificarCPFCNPJ;
import java.io.File;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;
import javax.swing.JOptionPane;
/**
 *
 * @author Carvalho
 */
public class CadastrarPF extends javax.swing.JDialog {

    private ArrayList<ClientePF> clientes = new ArrayList<ClientePF>();
    private opcCadastro opc;
    private ClientePF pfAlterado;
    private boolean confirmado;
    private int indice;
    
    public static boolean executar(java.awt.Frame parent, opcCadastro opc, ClientePF pf, int i){
        CadastrarPF cadastrar = new CadastrarPF(parent, opc, pf, i);
        cadastrar.setLocationRelativeTo(null);
        cadastrar.setVisible(true);
        return cadastrar.opcConfirmada();
    }
    
    public CadastrarPF(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public CadastrarPF(java.awt.Frame parent, opcCadastro opc, ClientePF pf, int i){
        super(parent, true);
        confirmado = false;
        this.opc = opc;
        pfAlterado = pf;
        this.indice = i;
        initComponents();
        if(opc == opc.ocAlterar){
            tbxNome.setText(pf.getNome());
            tbxCPF.setText(pf.getCPF());
            tbxTelefoneRes.setText(pf.getTelefone());
            tbxTelefoneComercial.setText(pf.getTelComercial());
            tbxTelefoneCel.setText(pf.getTelCel());
            tbxFAX.setText(pf.getFAX());
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
                    entrada = new Scanner(new File("ClientesPF.txt"));
                    while (entrada.hasNext()){
                        ClientePF leitura = new ClientePF();
                        leitura.setNome(entrada.next());
                        leitura.setCPF(entrada.next());
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
                    saida = new Formatter("ClientesPF.txt");
                    for (int i = 0; i < clientes.size(); i++){
                        ClientePF cliente = clientes.get(i);
                        saida.format("%s %s %s %s %s %s\n", cliente.getNome(), cliente.getCPF(), cliente.getTelefone(), 
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
    
    public int VerificacaoCPF(String cpf)
    {
        verificarCPFCNPJ verificar = new verificarCPFCNPJ();
        if ( verificar.validarFormatoCPF(tbxCPF.getText()) )
        {
            if ( verificar.verificarCPF(tbxCPF.getText()) )
            {
                    if ( !verificar.cpfExiste(tbxCPF.getText(), clientes, indice) )
                    {
                        return 0;
                    } else
                    {
                        JOptionPane.showMessageDialog(this, "CPF já existe!");
                        return 3;
                    }
            } else
            {
                JOptionPane.showMessageDialog(this, "CPF inválido!");
                return 2;
            }
        } else
        {
            JOptionPane.showMessageDialog(this, "CPF com formatação inválido! Use apenas números.");
            return 1;
        }
                
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tbxTelefoneComercial = new javax.swing.JTextField();
        tbxTelefoneCel = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
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
        tbxCPF = new javax.swing.JTextField();
        tbxTelefoneRes = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Pessoa Física");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Nome:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("CPF:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel7.setText("Pessoa Física");

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

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JDialogsEFrames/add.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(84, 84, 84))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tbxNome)
                            .addComponent(tbxCPF)
                            .addComponent(tbxTelefoneRes)
                            .addComponent(tbxTelefoneComercial)
                            .addComponent(tbxTelefoneCel)
                            .addComponent(tbxFAX, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnOk)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar)))
                .addGap(0, 21, Short.MAX_VALUE))
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
                    .addComponent(tbxCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(tbxTelefoneRes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(tbxTelefoneComercial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(btnCancelar)
                    .addComponent(btnOk))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        ClientePF PF = new ClientePF();
        LerArquivo();
        
        if(opc == opc.ocAlterar)
        {  
            if (VerificacaoCPF(tbxCPF.getText()) == 0)
            {
                pfAlterado.setNome(tbxNome.getText());
                pfAlterado.setCPF(tbxCPF.getText());
                pfAlterado.setTelefone(tbxTelefoneRes.getText());
                pfAlterado.setTelComercial(tbxTelefoneComercial.getText());
                pfAlterado.setTelCel(tbxTelefoneCel.getText());
                pfAlterado.setFAX(tbxFAX.getText());
                clientes.set(indice, pfAlterado);
                JOptionPane.showMessageDialog(null, "Contato alterado com sucesso.");
                SalvarArquivo();
                confirmado = true;
                dispose();
            }         
        } else {
            if (VerificacaoCPF(tbxCPF.getText()) == 0)
            {
                PF.setNome(tbxNome.getText());
                PF.setCPF(tbxCPF.getText());
                PF.setTelefone(tbxTelefoneRes.getText());
                PF.setTelComercial(tbxTelefoneComercial.getText());
                PF.setTelCel(tbxTelefoneCel.getText());
                PF.setFAX(tbxFAX.getText());
                clientes.add(PF);
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
            java.util.logging.Logger.getLogger(CadastrarPF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastrarPF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastrarPF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastrarPF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CadastrarPF dialog = new CadastrarPF(new javax.swing.JFrame(), true);
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
    private javax.swing.JTextField tbxCPF;
    private javax.swing.JTextField tbxFAX;
    private javax.swing.JTextField tbxNome;
    private javax.swing.JTextField tbxTelefoneCel;
    private javax.swing.JTextField tbxTelefoneComercial;
    private javax.swing.JTextField tbxTelefoneRes;
    // End of variables declaration//GEN-END:variables
}
