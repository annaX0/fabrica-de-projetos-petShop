/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import javax.swing.JOptionPane;
import connections.MySQL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import objects.AgendamentoAnimal;

/**
 *
 * @author annas
 */
public class agenda extends javax.swing.JFrame {
        MySQL conectar = new MySQL();
        AgendamentoAnimal novoAgendamento = new AgendamentoAnimal();
    /**
     * Creates new form agendamento
     */
    public agenda() {
        initComponents();
    }
    
    private void pesquisaNewAgendamento(AgendamentoAnimal novoAgendamento){
    this.conectar.conectaBanco();
        
        String pesquisaNewAgendamento = txt_cpf.getText();
        
        try{
        this.conectar.executarSQL("SELECT "
            + "nomeDono,"
            + "nomeAnimal,"
            + "telefone,"
            + "animal,"
            + "servico,"
            + "hora,"
            + "kilos,"
            + "agenda,"
            + "cpf"
            + " FROM"
            + " agendamento"
            + " WHERE"
            + " cpf = '" + pesquisaNewAgendamento + "'" + ";"
        );
        while (this.conectar.getResultSet().next()){
            novoAgendamento.setNomeDono(this.conectar.getResultSet().getString(1));
            novoAgendamento.setNomeAnimal(this.conectar.getResultSet().getString(2));
            novoAgendamento.setTelefone(this.conectar.getResultSet().getString(3));
            novoAgendamento.setAnimal(this.conectar.getResultSet().getString(4));
            novoAgendamento.setServico(this.conectar.getResultSet().getString(5));
            novoAgendamento.setHora(this.conectar.getResultSet().getString(6));
            novoAgendamento.setKilos(this.conectar.getResultSet().getString(7));
            novoAgendamento.setAgenda(this.conectar.getResultSet().getString(8));
            novoAgendamento.setCpf(this.conectar.getResultSet().getString(9));

        }
        
        } catch (Exception e){
            System.out.println("Erro ao consultar funcionario" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao buscar funcionário!");
            
        } finally{
            txt_nome_dono.setText(novoAgendamento.getNomeDono());
            txt_nome_animal.setText(novoAgendamento.getNomeAnimal());
            txt_telefone.setText(novoAgendamento.getTelefone());
            txt_animal.setText(novoAgendamento.getAnimal());
            txt_servico.setText(novoAgendamento.getServico());
            txt_hora.setText(novoAgendamento.getHora());
            txt_kilos.setText(novoAgendamento.getKilos());
            txt_agenda.setText(novoAgendamento.getAgenda());
            txt_cpf.setText(novoAgendamento.getCpf());

            this.conectar.fechaBanco();
                
        }

    }

    private void deletaAgendamento(AgendamentoAnimal novoAgendamento ){
        this.conectar.conectaBanco();

        String pesquisaNewAgendamento = this.txt_cpf.getText();
        
            novoAgendamento.setNomeDono(txt_nome_dono.getText());
            novoAgendamento.setNomeAnimal(txt_nome_animal.getText());
            novoAgendamento.setTelefone(txt_telefone.getText());
            novoAgendamento.setAnimal(txt_animal.getText());
            novoAgendamento.setServico(txt_servico.getText());
            novoAgendamento.setHora(txt_hora.getText());
            novoAgendamento.setKilos(txt_agenda.getText());
            novoAgendamento.setAgenda(txt_kilos.getText());
            
        try{
            this.conectar.updateSQL(
            " DELETE FROM agendamento"
            + " WHERE"
            + " cpf = '" + pesquisaNewAgendamento + "'"
            );
        }catch(Exception e){
            System.out.println("Erro ao atualizar agendamento" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao atualizar agendamento");
            
        }finally{
            this.conectar.fechaBanco();
            JOptionPane.showMessageDialog(null, "Agendamento atualizado!");
        }    

    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btn_agenda = new javax.swing.JButton();
        btn_agendamento = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btn_pesquisa = new javax.swing.JButton();
        btn_deleta = new javax.swing.JButton();
        txt_nome_animal = new javax.swing.JTextField();
        txt_nome_dono = new javax.swing.JTextField();
        txt_telefone = new javax.swing.JTextField();
        txt_servico = new javax.swing.JTextField();
        txt_hora = new javax.swing.JTextField();
        txt_animal = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_kilos = new javax.swing.JTextField();
        txt_agenda = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_cpf = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        cmb_hora = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(776, 540));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(240, 140, 23));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("BEM VINDO");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 70, 220, 30);

        btn_agenda.setBackground(new java.awt.Color(231, 168, 95));
        btn_agenda.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_agenda.setForeground(new java.awt.Color(255, 255, 255));
        btn_agenda.setText("AGENDA");
        btn_agenda.setBorder(null);
        btn_agenda.setRequestFocusEnabled(false);
        btn_agenda.setRolloverEnabled(false);
        btn_agenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agendaActionPerformed(evt);
            }
        });
        jPanel1.add(btn_agenda);
        btn_agenda.setBounds(0, 190, 220, 48);

        btn_agendamento.setBackground(new java.awt.Color(231, 168, 95));
        btn_agendamento.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_agendamento.setForeground(new java.awt.Color(255, 255, 255));
        btn_agendamento.setText("AGENDAMENTO");
        btn_agendamento.setBorder(null);
        btn_agendamento.setBorderPainted(false);
        btn_agendamento.setFocusPainted(false);
        btn_agendamento.setFocusable(false);
        btn_agendamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agendamentoActionPerformed(evt);
            }
        });
        jPanel1.add(btn_agendamento);
        btn_agendamento.setBounds(0, 140, 220, 48);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 220, 540);

        jPanel2.setBackground(new java.awt.Color(0, 63, 89));
        jPanel2.setLayout(null);

        btn_pesquisa.setText("pesquisa");
        btn_pesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pesquisaActionPerformed(evt);
            }
        });
        jPanel2.add(btn_pesquisa);
        btn_pesquisa.setBounds(60, 430, 76, 23);

        btn_deleta.setText("deleta");
        btn_deleta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deletaActionPerformed(evt);
            }
        });
        jPanel2.add(btn_deleta);
        btn_deleta.setBounds(400, 430, 72, 23);
        jPanel2.add(txt_nome_animal);
        txt_nome_animal.setBounds(40, 100, 110, 30);
        jPanel2.add(txt_nome_dono);
        txt_nome_dono.setBounds(40, 40, 110, 30);
        jPanel2.add(txt_telefone);
        txt_telefone.setBounds(40, 170, 110, 30);
        jPanel2.add(txt_servico);
        txt_servico.setBounds(160, 40, 110, 30);
        jPanel2.add(txt_hora);
        txt_hora.setBounds(160, 100, 110, 30);
        jPanel2.add(txt_animal);
        txt_animal.setBounds(40, 230, 110, 30);

        jLabel2.setText("dono");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(40, 20, 60, 16);

        jLabel3.setText("telefone");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(40, 140, 60, 16);

        jLabel4.setText("servico");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(160, 20, 50, 16);

        jLabel5.setText("hora");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(160, 70, 24, 16);

        jLabel6.setText("animal");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(40, 200, 36, 16);

        jLabel7.setText("nome animal");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(40, 70, 80, 16);

        jLabel8.setText("kilos");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(160, 140, 24, 16);
        jPanel2.add(txt_kilos);
        txt_kilos.setBounds(160, 170, 110, 30);
        jPanel2.add(txt_agenda);
        txt_agenda.setBounds(160, 230, 110, 30);

        jLabel9.setText("agenda");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(160, 200, 50, 16);
        jPanel2.add(txt_cpf);
        txt_cpf.setBounds(290, 230, 110, 30);

        jLabel10.setText("cpf");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(290, 200, 17, 16);
        jPanel2.add(jCalendar1);
        jCalendar1.setBounds(290, 20, 250, 180);

        cmb_hora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "8:00", "9:00", "10:00", "11:00", "13:00", "14:00", "15:00", "16:00" }));
        cmb_hora.setFocusable(false);
        cmb_hora.setLightWeightPopupEnabled(false);
        cmb_hora.setRequestFocusEnabled(false);
        cmb_hora.setVerifyInputWhenFocusTarget(false);
        cmb_hora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_horaActionPerformed(evt);
            }
        });
        jPanel2.add(cmb_hora);
        cmb_hora.setBounds(420, 230, 110, 30);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(220, 0, 550, 540);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_agendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_agendaActionPerformed

    private void btn_agendamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agendamentoActionPerformed
       newAgendamento agendament = new newAgendamento();
       agendament.setVisible(true);
       dispose();
    }//GEN-LAST:event_btn_agendamentoActionPerformed

    private void btn_pesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pesquisaActionPerformed
         pesquisaNewAgendamento(novoAgendamento);
    }//GEN-LAST:event_btn_pesquisaActionPerformed

    private void btn_deletaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deletaActionPerformed
        deletaAgendamento(novoAgendamento);
    }//GEN-LAST:event_btn_deletaActionPerformed

    private void cmb_horaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_horaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_horaActionPerformed

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
            java.util.logging.Logger.getLogger(agenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(agenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(agenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(agenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new agenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agenda;
    private javax.swing.JButton btn_agendamento;
    private javax.swing.JButton btn_deleta;
    private javax.swing.JButton btn_pesquisa;
    private javax.swing.JComboBox<String> cmb_hora;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txt_agenda;
    private javax.swing.JTextField txt_animal;
    private javax.swing.JTextField txt_cpf;
    private javax.swing.JTextField txt_hora;
    private javax.swing.JTextField txt_kilos;
    private javax.swing.JTextField txt_nome_animal;
    private javax.swing.JTextField txt_nome_dono;
    private javax.swing.JTextField txt_servico;
    private javax.swing.JTextField txt_telefone;
    // End of variables declaration//GEN-END:variables

    
}
