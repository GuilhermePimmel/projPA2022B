/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import controladores.UsuarioController;
import ferramentas.CaixaDeDialogo;
import modelos.Usuario;

/**
 *
 * @author jdhein
 */
public class TelaUsuarios extends javax.swing.JFrame {
    
    Usuario objUsuario;
    UsuarioController objUsuarioController;

    /**
     * Creates new form TelaUsuarios
     */
    public TelaUsuarios() {
        initComponents();
        
        limparCampos();
        
        
    }
    
    private void atualizarLista(){
        UsuarioController controller = new UsuarioController();
        controller.preencherLista(jtbUsuarios);
    }
    
    private void preencherCampos(){
        try{
            
            txtId.setText(String.valueOf(objUsuario.getId()));
            txtNome.setText(objUsuario.getNome());
            txtLogin.setText(objUsuario.getUsuario());
            txtTelefone.setText(objUsuario.getTelefone());
            txtEmail.setText(objUsuario.getEmail());
            
            btnIncluir.setEnabled(false);            
            btnAlterar.setEnabled(true);
            btnExcluir.setEnabled(true);
            txtLogin.setEnabled(false);
            txtLogin.setEditable(false);

            
        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem(ex.getMessage());
        }
    }
    
    private void limparCampos(){
        try{
            
            txtId.setText("ID");
            txtNome.setText("");
            txtLogin.setText("");
            txtTelefone.setText("");
            pwdSenha.setText("");
            pwdConfSenha.setText("");
            txtEmail.setText("");

            
            btnIncluir.setEnabled(true);            
            btnAlterar.setEnabled(false);
            btnExcluir.setEnabled(false);
            txtLogin.setEnabled(true);
            txtLogin.setEditable(true);
            
            atualizarLista();
            
        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem(ex.getMessage());
        }
    }
    
    private void guardarDados(){
        try{
            
            objUsuario = new Usuario();
            objUsuario.setNome(txtNome.getText());
            objUsuario.setTelefone(txtTelefone.getText());
            objUsuario.setUsuario(txtLogin.getText());
            objUsuario.setSenha(pwdSenha.getText());
            objUsuario.setEmail(txtEmail.getText());
            
        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem(ex.getMessage());
        }
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtLogin = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnIncluir = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbUsuarios = new javax.swing.JTable();
        btnLimpar = new javax.swing.JButton();
        txtId = new javax.swing.JLabel();
        pwdSenha = new javax.swing.JPasswordField();
        pwdConfSenha = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Nome");

        jLabel2.setText("Login");

        jLabel3.setText("Senha");

        txtTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefoneActionPerformed(evt);
            }
        });

        jLabel4.setText("Telefone");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Cadastro de Usu??rios");

        btnIncluir.setText("INCLUIR");
        btnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluirActionPerformed(evt);
            }
        });

        btnAlterar.setText("ALTERAR");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnExcluir.setText("EXCLUIR");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        jtbUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtbUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtbUsuariosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtbUsuarios);

        btnLimpar.setText("LIMPAR");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        txtId.setText("ID");

        jLabel7.setText("E-mail");

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtId)
                                        .addGap(17, 17, 17))
                                    .addComponent(jLabel4)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(pwdSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(pwdConfSenha))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(txtTelefone)
                                    .addComponent(jLabel7)
                                    .addComponent(txtEmail))
                                .addGap(0, 76, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnIncluir)
                        .addGap(5, 5, 5)
                        .addComponent(btnAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluir)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtId)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pwdSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pwdConfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnIncluir)
                    .addComponent(btnAlterar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnExcluir)
                        .addComponent(btnLimpar)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirActionPerformed
        // INCLUI UM PALESTRANTE NA BASE DE DADOS
        if(validarDados()){

            guardarDados();
            
            //verificar se o usu??rio j?? existe
            objUsuarioController = new UsuarioController();
            if (objUsuarioController.verificaExistencia(objUsuario)) {
                CaixaDeDialogo.obterinstancia().exibirMensagem("Usu??rio j?? existe!", 'e');
            }else{
                if(objUsuarioController.incluir(objUsuario) == true){
                    CaixaDeDialogo.obterinstancia().exibirMensagem("Usu??rio inclu??do com Sucesso ("+ objUsuario.getId() +")!");
                }else{
                    CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao incluir usu??rio!", 'e');
                }
            }
            
            limparCampos();

        }
    
    }//GEN-LAST:event_btnIncluirActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        // TODO add your handling code here:
        try{
            if(validarDados()){
            
                guardarDados();
                objUsuario.setId(Integer.parseInt(txtId.getText()));

                //verificar se o usu??rio j?? existe
                objUsuarioController = new UsuarioController();
                if (objUsuarioController.verificaExistencia(objUsuario)) {
                    CaixaDeDialogo.obterinstancia().exibirMensagem("Usu??rio j?? existe!", 'e');
                }else{
                    if(objUsuarioController.alterar(objUsuario) == true){
                        CaixaDeDialogo.obterinstancia().exibirMensagem("Usu??rio alterado com Sucesso ("+ objUsuario.getId() +")!");
                    }else{
                        CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao alterar usu??rio!", 'e');
                    }
                }

                limparCampos();

            }

        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        
        try{
            boolean wPergunta = CaixaDeDialogo.obterinstancia().pedirConfirmacao("Tem certeza de que deseja excluir?","",'p');

            if (wPergunta == true){
                objUsuarioController = new UsuarioController();
                boolean retorno = objUsuarioController.excluir(Integer.parseInt(txtId.getText()));
            
            if(retorno == true){
                limparCampos();
            }else{
                CaixaDeDialogo.obterinstancia().exibirMensagem("erro ao excluir");
            }
            }
        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void jtbUsuariosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbUsuariosMousePressed
        // TODO add your handling code here:
        try{

            int linhaSelecionada = jtbUsuarios.getSelectedRow();//pega a linha selecionada
            String idUsuario = jtbUsuarios.getModel()
            .getValueAt(linhaSelecionada, 0).toString(); // Primeira coluna da linha

            //if(jtbUsuarios.isColumnSelected(2)){
                UsuarioController objUsuarioController = new UsuarioController();

                objUsuario = objUsuarioController.buscar(Integer.parseInt(idUsuario));
                if (objUsuario != null && objUsuario.getId() > 0){
                    preencherCampos();
                }else{
                    CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao buscar Usu??rio no BD!");
                }
            //}

        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem(ex.getMessage(), 'e');
        }

    }//GEN-LAST:event_jtbUsuariosMousePressed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
       limparCampos();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void txtTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefoneActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private boolean validarDados() {
        
        if (txtNome.getText().equals("")) {
            CaixaDeDialogo.obterinstancia().exibirMensagem("Informe o nome do usu??rio", 'e');
            return false;
        }else if (txtTelefone.getText().equals("")) {
            CaixaDeDialogo.obterinstancia().exibirMensagem("Informe o telefone do usu??rio", 'e');
            return false;
        }else if (txtLogin.getText().equals("")) {
            CaixaDeDialogo.obterinstancia().exibirMensagem("Informe o login do usu??rio", 'e');
            return false;
        }else if (pwdSenha.getText().equals("")) {
            CaixaDeDialogo.obterinstancia().exibirMensagem("Informe a senha do usu??rio", 'e');
            return false;
        }else if (!pwdSenha.getText().equals(pwdConfSenha.getText())) {
            CaixaDeDialogo.obterinstancia().exibirMensagem("As senhas n??o correspondem", 'e');
            return false;
        }else if (txtEmail.getText().equals("")) {
            CaixaDeDialogo.obterinstancia().exibirMensagem("Informe o e-mail do usu??rio", 'e');
            return false;}
        
        return true;
        
    }

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
            java.util.logging.Logger.getLogger(TelaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaUsuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnIncluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtbUsuarios;
    private javax.swing.JPasswordField pwdConfSenha;
    private javax.swing.JPasswordField pwdSenha;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JLabel txtId;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
