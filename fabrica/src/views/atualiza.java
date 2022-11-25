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
public class atualiza extends javax.swing.JFrame {
        MySQL conectar = new MySQL();
        AgendamentoAnimal novoAgendamento = new AgendamentoAnimal();
    /**
     * Creates new form agendamento
     */
    public atualiza() {
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
            txt_hora.setText(novoAgendamento.getHora());
            txt_telefone.setText(novoAgendamento.getTelefone());
            txt_servico.setText(novoAgendamento.getServico());
            txt_agenda.setText(novoAgendamento.getAgenda());
            txt_cpf.setText(novoAgendamento.getCpf());
            txt_kilos.setText(novoAgendamento.getKilos());
            this.conectar.fechaBanco();
                
        }

    }
    private void atualizaAgendamento(AgendamentoAnimal novoAgendamento ){
        this.conectar.conectaBanco();

        String pesquisaNewAgendamento = this.txt_cpf.getText();
        
            novoAgendamento.setNomeDono(txt_nome_dono.getText());
            novoAgendamento.setTelefone(txt_telefone.getText());
            novoAgendamento.setServico((String)cmb_servico.getSelectedItem());
            novoAgendamento.setHora((String)cmb_hora.getSelectedItem());
            novoAgendamento.setKilos((String)cmb_kilos.getSelectedItem());
            novoAgendamento.setAgenda(txt_agenda.getText());
            
        try{
            this.conectar.updateSQL(
            " UPDATE agendamento SET "
            + " nomeDono = '" + novoAgendamento.getNomeDono()+"'"
            + ", telefone = '" + novoAgendamento.getTelefone()+"'"
            + ", servico = '" + novoAgendamento.getServico()+"'"
            + ", hora = '" + novoAgendamento.getHora()+"'"
            + ", kilos = '" + novoAgendamento.getKilos()+"'"
            + ", agenda = '" + novoAgendamento.getAgenda()+"'"
            + ", cpf = '" + novoAgendamento.getCpf()+"'"
            + " WHERE"
            + " cpf = '"+ pesquisaNewAgendamento + "'" + ";"
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

        jPanel2 = new javax.swing.JPanel();
        btn_atualiza = new javax.swing.JButton();
        txt_nome_dono = new javax.swing.JTextField();
        txt_telefone = new javax.swing.JTextField();
        txt_servico = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_agenda = new javax.swing.JTextField();
        txt_cpf = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        cmb_hora = new javax.swing.JComboBox<>();
        cmb_kilos = new javax.swing.JComboBox<>();
        btn_pesquisa = new javax.swing.JButton();
        txt_kilos = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cmb_servico = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_hora = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btn_agenda = new javax.swing.JButton();
        btn_agendamento = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 63, 89));
        jPanel2.setLayout(null);

        btn_atualiza.setText("atualiza");
        btn_atualiza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_atualizaActionPerformed(evt);
            }
        });
        jPanel2.add(btn_atualiza);
        btn_atualiza.setBounds(90, 430, 72, 22);
        jPanel2.add(txt_nome_dono);
        txt_nome_dono.setBounds(410, 130, 110, 30);
        jPanel2.add(txt_telefone);
        txt_telefone.setBounds(410, 250, 110, 30);

        txt_servico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_servicoActionPerformed(evt);
            }
        });
        jPanel2.add(txt_servico);
        txt_servico.setBounds(410, 190, 110, 30);

        jLabel2.setText("dono");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(410, 110, 60, 16);

        jLabel3.setText("kilos");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(410, 290, 60, 16);

        jLabel4.setText("servico");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(410, 170, 50, 16);

        jLabel5.setText("hora");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(70, 360, 24, 20);

        jLabel8.setText("servico");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(70, 260, 40, 16);

        txt_agenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_agendaActionPerformed(evt);
            }
        });
        jPanel2.add(txt_agenda);
        txt_agenda.setBounds(410, 370, 110, 30);
        jPanel2.add(txt_cpf);
        txt_cpf.setBounds(410, 30, 110, 30);

        jLabel10.setText("hora");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(280, 250, 40, 16);
        jPanel2.add(jCalendar1);
        jCalendar1.setBounds(0, 0, 400, 240);

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
        cmb_hora.setBounds(70, 380, 110, 30);

        cmb_kilos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0-5 KG", "5-10 KG", "10-15 KG", "15-20 KG", "20-25 KG", "25-30 KG", "30+" }));
        jPanel2.add(cmb_kilos);
        cmb_kilos.setBounds(70, 330, 110, 30);

        btn_pesquisa.setText("pesquisa");
        btn_pesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pesquisaActionPerformed(evt);
            }
        });
        jPanel2.add(btn_pesquisa);
        btn_pesquisa.setBounds(420, 70, 80, 22);
        jPanel2.add(txt_kilos);
        txt_kilos.setBounds(410, 310, 110, 30);

        jLabel6.setText("telefone");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(410, 230, 60, 16);

        jLabel11.setText("cpf");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(420, 10, 40, 16);

        cmb_servico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Banho", "Tosa", "Banho & Tosa" }));
        cmb_servico.setFocusable(false);
        cmb_servico.setLightWeightPopupEnabled(false);
        cmb_servico.setRequestFocusEnabled(false);
        cmb_servico.setVerifyInputWhenFocusTarget(false);
        cmb_servico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_servicoActionPerformed(evt);
            }
        });
        jPanel2.add(cmb_servico);
        cmb_servico.setBounds(70, 280, 110, 30);

        jLabel9.setText("kilos");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(70, 310, 24, 16);

        jLabel12.setText("data");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(410, 350, 40, 16);

        txt_hora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_horaActionPerformed(evt);
            }
        });
        jPanel2.add(txt_hora);
        txt_hora.setBounds(270, 270, 110, 30);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_atualizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_atualizaActionPerformed
        DateFormat teste = new SimpleDateFormat("dd/MM/yyyy" );
        atualizaAgendamento(novoAgendamento);

        Date dl = null;
        try{
            dl = teste.parse(teste.format(jCalendar1.getDate()));
        } catch(Exception e){
            e.printStackTrace();
        }

        txt_agenda.setText(teste.format(dl));

    }//GEN-LAST:event_btn_atualizaActionPerformed

    private void txt_agendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_agendaActionPerformed
        System.out.print(jCalendar1);
    }//GEN-LAST:event_txt_agendaActionPerformed

    private void cmb_horaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_horaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_horaActionPerformed

    private void btn_pesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pesquisaActionPerformed
        pesquisaNewAgendamento(novoAgendamento);
    }//GEN-LAST:event_btn_pesquisaActionPerformed

    private void cmb_servicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_servicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_servicoActionPerformed

    private void txt_horaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_horaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_horaActionPerformed

    private void btn_agendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_agendaActionPerformed

    private void btn_agendamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agendamentoActionPerformed
        newAgendamento agendament = new newAgendamento();
        agendament.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_agendamentoActionPerformed

    private void txt_servicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_servicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_servicoActionPerformed

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
            java.util.logging.Logger.getLogger(atualiza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(atualiza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(atualiza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(atualiza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new atualiza().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agenda;
    private javax.swing.JButton btn_agendamento;
    private javax.swing.JButton btn_atualiza;
    private javax.swing.JButton btn_pesquisa;
    private javax.swing.JComboBox<String> cmb_hora;
    private javax.swing.JComboBox<String> cmb_kilos;
    private javax.swing.JComboBox<String> cmb_servico;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txt_agenda;
    private javax.swing.JTextField txt_cpf;
    private javax.swing.JTextField txt_hora;
    private javax.swing.JTextField txt_kilos;
    private javax.swing.JTextField txt_nome_dono;
    private javax.swing.JTextField txt_servico;
    private javax.swing.JTextField txt_telefone;
    // End of variables declaration//GEN-END:variables
}