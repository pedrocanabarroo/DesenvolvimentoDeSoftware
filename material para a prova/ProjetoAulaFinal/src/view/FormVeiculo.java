/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import beans.Pessoa;
import beans.Veiculo;
import dao.PessoaDAO;
import dao.VeiculoDAO;
import java.util.List;
import java.util.Set;

/**
 *
 * @author hermes
 */
public class FormVeiculo extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FormVeiculo.class.getName());

    /**
     * Creates new form FormVeiculo
     */
    public FormVeiculo() {
        initComponents();
        preencherComboPessoas();
    }
    
   
    @SuppressWarnings("unchecked")
    
    
    public void preencherComboPessoas(){
    
    PessoaDAO pDAO = new PessoaDAO();
    
    List<Pessoa> listaP = pDAO.getPessoas();
    
    for(Pessoa p :listaP){
    
    cmbpessoas.addItem(p);
    
    }
    
    
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtplaca = new javax.swing.JTextField();
        txtmodelo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cmbpessoas = new javax.swing.JComboBox();
        btnsalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Modelo do veículo:");

        jLabel2.setText("Pessoa:");

        txtplaca.setText("Digite a placa...");
        txtplaca.addActionListener(this::txtplacaActionPerformed);

        txtmodelo.setText("Digite o modelo...");

        jLabel3.setText("Placa do Automóvel:");

        cmbpessoas.addActionListener(this::cmbpessoasActionPerformed);

        btnsalvar.setText("Salvar");
        btnsalvar.addActionListener(this::btnsalvarActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnsalvar)
                .addGap(14, 14, 14))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(txtplaca, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbpessoas, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(112, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(txtmodelo, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(116, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel1)
                .addGap(44, 44, 44)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtplaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbpessoas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(btnsalvar)
                .addGap(16, 16, 16))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(71, 71, 71)
                    .addComponent(txtmodelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(206, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void limparFormulario(){
    
    txtmodelo.setText("");
    txtplaca.setText("");
    cmbpessoas.setSelectedIndex(0);
    
    
    
    }
    
    
    
    private void txtplacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtplacaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtplacaActionPerformed

    private void btnsalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalvarActionPerformed
        
        Pessoa p = (Pessoa) cmbpessoas.getSelectedItem();
        
        Veiculo v = new Veiculo();
      
        v.setModelo(txtmodelo.getText());
        v.setPlaca(txtplaca.getText());
        v.setPessoaid(p);
        
        VeiculoDAO vDAO = new VeiculoDAO();
        vDAO.inserir(v);
        
        limparFormulario();
    }//GEN-LAST:event_btnsalvarActionPerformed

    private void cmbpessoasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbpessoasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbpessoasActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new FormVeiculo().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnsalvar;
    private javax.swing.JComboBox cmbpessoas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtmodelo;
    private javax.swing.JTextField txtplaca;
    // End of variables declaration//GEN-END:variables
}
