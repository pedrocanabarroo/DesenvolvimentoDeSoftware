package view;

import beans.Pessoa;
import beans.Veiculo;
import dao.PessoaDAO;
import dao.VeiculoDAO;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author hermes
 */
  

    public class ConsultarVeiculos extends javax.swing.JFrame {

        private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ConsultarVeiculos.class.getName());

        /**
         * Creates new form ConsultarVeiculos
         */
        public ConsultarVeiculos() {
            initComponents();
            preencherComboPessoas();
        }

        public void preencherComboPessoas() {

            PessoaDAO pDAO = new PessoaDAO();

            List<Pessoa> listap = pDAO.getPessoas();

            for (Pessoa p : listap) {

                cmbPessoa.addItem(p);

            }

        }

        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btneditar = new javax.swing.JButton();
        txtid = new javax.swing.JTextField();
        btnbuscar = new javax.swing.JButton();
        txtmodelo = new javax.swing.JTextField();
        txtplaca = new javax.swing.JTextField();
        cmbPessoa = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("ID:");

        jLabel2.setText("Modelo:");

        jLabel3.setText("Placa:");

        jLabel4.setText("Pessoa:");

        btneditar.setText("Atualizar");
        btneditar.addActionListener(this::btneditarActionPerformed);

        btnbuscar.setText("Buscar");
        btnbuscar.addActionListener(this::btnbuscarActionPerformed);

        cmbPessoa.addActionListener(this::cmbPessoaActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(txtplaca, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(jLabel4)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnbuscar))
                            .addComponent(txtmodelo)
                            .addComponent(cmbPessoa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btneditar, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbuscar))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtmodelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtplaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(btneditar, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
       public void limparFormulario(){
    
    txtmodelo.setText("");
    txtplaca.setText("");
    cmbPessoa.setSelectedIndex(0);
    
    
    
    }

    private void btneditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarActionPerformed
       
        Pessoa p = (Pessoa) cmbPessoa.getSelectedItem();
        
        Veiculo v = new Veiculo();
      
        v.setModelo(txtmodelo.getText());
        v.setPlaca(txtplaca.getText());
        v.setPessoaid(p);
        
        VeiculoDAO vDAO = new VeiculoDAO();
        vDAO.editar(v);
        
        JOptionPane.showMessageDialog(null,"Veículo atualizado");
        
        limparFormulario();
    }//GEN-LAST:event_btneditarActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed

        int idVeiculo = Integer.parseInt(txtid.getText());

        VeiculoDAO vDAO = new VeiculoDAO();

        Veiculo v = vDAO.getVeiculo(idVeiculo);

        if (v == null) {

            //limparFormulario();
            JOptionPane.showMessageDialog(this, "Veiculo não encontrado");

        } else {

            txtid.setText(idVeiculo + "");
            txtmodelo.setText(v.getModelo());
            txtplaca.setText(v.getPlaca());

            Pessoa pessoaSelecionada = (Pessoa) v.getPessoaid();
            cmbPessoa.setSelectedItem(pessoaSelecionada);

        }
    
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void cmbPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPessoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbPessoaActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new ConsultarVeiculos().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btneditar;
    private javax.swing.JComboBox cmbPessoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtmodelo;
    private javax.swing.JTextField txtplaca;
    // End of variables declaration//GEN-END:variables
}
