/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import objects.AgendamentoAnimal;
import connections.MySQL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author annas
 */
public class newAgendamento extends javax.swing.JFrame {
        MySQL conectar = new MySQL();
        AgendamentoAnimal novoAgendamento = new AgendamentoAnimal();
    /**
     * Creates new form agendamento
     */
    public newAgendamento() {
        initComponents();
    }
    private void cadNovoAgendamento(AgendamentoAnimal novoAgendamento){
    this.conectar.conectaBanco();
    Date d = null;
    DateFormat data = new SimpleDateFormat("dd/MM/yyyy" );
     try{
        d = data.parse(data.format(jCalendar.getDate()));
    } catch(Exception e){
           e.printStackTrace();
       }
    novoAgendamento.setNomeDono(txt_nome_dono.getText());
    novoAgendamento.setNomeAnimal(txt_nome_animal.getText());
    novoAgendamento.setTelefone(txt_telefone.getText());
    novoAgendamento.setAnimal((String)cmb_animal.getSelectedItem());
    novoAgendamento.setKilos((String)cmb_kilos.getSelectedItem());
    novoAgendamento.setServico((String)cmb_servico.getSelectedItem());
    novoAgendamento.setHora((String)cmb_hora.getSelectedItem());
    novoAgendamento.setAgenda(data.format(d));
    novoAgendamento.setCpf(txt_cpf.getText());

    //String Animal;String nomeDono;String telefone;String dia;String servico;
    
    try{
        this.conectar.insertSQL("INSERT INTO agendamento("
    + "nomeDono,"
    + "nomeAnimal,"
    + "telefone,"
    + "animal,"
    + "servico,"
    + "hora,"
    + "kilos,"
    + "agenda,"
    + "cpf"
    + ")VALUES("
    + "'" +novoAgendamento.getNomeDono()+"',"
    + "'" +novoAgendamento.getNomeAnimal()+ "',"
    + "'" +novoAgendamento.getTelefone()+ "',"
    + "'" +novoAgendamento.getAnimal()+"',"
    + "'" +novoAgendamento.getServico()+"',"
    + "'" +novoAgendamento.getHora()+ "',"
    + "'" +novoAgendamento.getKilos()+ "',"
    + "'" +novoAgendamento.getAgenda()+ "',"
    + "'" +novoAgendamento.getCpf()+ "'" 
    + ");");
     } catch (Exception e){
            System.err.println("Erro ao cadastrar Usuario" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar Usuario");
        } finally{
            this.conectar.fechaBanco();
            JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso");
        }

    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btn_agenda = new javax.swing.JButton();
        btn_agendamento = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btn_agendar = new javax.swing.JButton();
        jLabel_Servico = new javax.swing.JLabel();
        txt_nome_dono = new javax.swing.JTextField();
        txt_telefone = new javax.swing.JTextField();
        jLabel_Animal = new javax.swing.JLabel();
        jLabel_Nome_Dono = new javax.swing.JLabel();
        cmb_animal = new javax.swing.JComboBox<>();
        jLabel_Nome_Animal = new javax.swing.JLabel();
        txt_nome_animal = new javax.swing.JTextField();
        cmb_servico = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        cmb_hora = new javax.swing.JComboBox<>();
        jLabel_Hora = new javax.swing.JLabel();
        cmb_kilos = new javax.swing.JComboBox<>();
        jCalendar = new com.toedter.calendar.JCalendar();
        txt_agendamento = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txt_cpf = new javax.swing.JTextField();
        jLabel_Nome_Dono1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(767, 540));
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
        jPanel1.setBounds(0, 0, 220, 600);

        jPanel2.setBackground(new java.awt.Color(0, 63, 89));
        jPanel2.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Telefone:");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(40, 170, 70, 20);

        btn_agendar.setBackground(new java.awt.Color(240, 140, 23));
        btn_agendar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_agendar.setForeground(new java.awt.Color(255, 255, 255));
        btn_agendar.setText("Agendar");
        btn_agendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agendarActionPerformed(evt);
            }
        });
        jPanel2.add(btn_agendar);
        btn_agendar.setBounds(190, 480, 220, 40);

        jLabel_Servico.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel_Servico.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Servico.setText("Serviço:");
        jPanel2.add(jLabel_Servico);
        jLabel_Servico.setBounds(170, 380, 61, 20);
        jPanel2.add(txt_nome_dono);
        txt_nome_dono.setBounds(40, 50, 240, 30);

        txt_telefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_telefoneActionPerformed(evt);
            }
        });
        jPanel2.add(txt_telefone);
        txt_telefone.setBounds(40, 190, 240, 30);

        jLabel_Animal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel_Animal.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Animal.setText("Animal:");
        jPanel2.add(jLabel_Animal);
        jLabel_Animal.setBounds(170, 310, 61, 20);

        jLabel_Nome_Dono.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel_Nome_Dono.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nome_Dono.setText("Horário:");
        jPanel2.add(jLabel_Nome_Dono);
        jLabel_Nome_Dono.setBounds(310, 230, 110, 20);

        cmb_animal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gato", "Cachorro" }));
        cmb_animal.setFocusable(false);
        cmb_animal.setLightWeightPopupEnabled(false);
        cmb_animal.setRequestFocusEnabled(false);
        cmb_animal.setVerifyInputWhenFocusTarget(false);
        cmb_animal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_animalActionPerformed(evt);
            }
        });
        jPanel2.add(cmb_animal);
        cmb_animal.setBounds(170, 330, 110, 30);

        jLabel_Nome_Animal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel_Nome_Animal.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nome_Animal.setText("Nome Animal:");
        jPanel2.add(jLabel_Nome_Animal);
        jLabel_Nome_Animal.setBounds(40, 240, 100, 20);

        txt_nome_animal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nome_animalActionPerformed(evt);
            }
        });
        jPanel2.add(txt_nome_animal);
        txt_nome_animal.setBounds(40, 260, 240, 30);

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
        cmb_servico.setBounds(170, 400, 110, 30);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("CPF:");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(40, 100, 61, 20);

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
        cmb_hora.setBounds(40, 400, 110, 30);

        jLabel_Hora.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel_Hora.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Hora.setText("Horário:");
        jPanel2.add(jLabel_Hora);
        jLabel_Hora.setBounds(40, 380, 61, 20);

        cmb_kilos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0-5 KG", "5-10 KG", "10-15 KG", "15-20 KG", "20-25 KG", "25-30 KG", "30+" }));
        cmb_kilos.setFocusable(false);
        cmb_kilos.setLightWeightPopupEnabled(false);
        cmb_kilos.setRequestFocusEnabled(false);
        cmb_kilos.setVerifyInputWhenFocusTarget(false);
        cmb_kilos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_kilosActionPerformed(evt);
            }
        });
        jPanel2.add(cmb_kilos);
        cmb_kilos.setBounds(40, 330, 110, 30);
        jPanel2.add(jCalendar);
        jCalendar.setBounds(310, 50, 280, 170);

        txt_agendamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_agendamentoActionPerformed(evt);
            }
        });
        jPanel2.add(txt_agendamento);
        txt_agendamento.setBounds(310, 250, 110, 30);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Nome:");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(40, 30, 61, 20);
        jPanel2.add(txt_cpf);
        txt_cpf.setBounds(40, 120, 240, 30);

        jLabel_Nome_Dono1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel_Nome_Dono1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nome_Dono1.setText("Peso do Animal:");
        jPanel2.add(jLabel_Nome_Dono1);
        jLabel_Nome_Dono1.setBounds(40, 310, 130, 20);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(220, 0, 630, 590);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_agendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agendaActionPerformed
        agenda agend = new agenda();
        agend.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_agendaActionPerformed

    private void btn_agendamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agendamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_agendamentoActionPerformed
    
    private void btn_agendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agendarActionPerformed
        cadNovoAgendamento(novoAgendamento);
    }//GEN-LAST:event_btn_agendarActionPerformed

    private void cmb_servicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_servicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_servicoActionPerformed

    private void cmb_animalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_animalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_animalActionPerformed

    private void cmb_horaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_horaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_horaActionPerformed

    private void cmb_kilosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_kilosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_kilosActionPerformed

    private void txt_telefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_telefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_telefoneActionPerformed

    private void txt_agendamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_agendamentoActionPerformed
        
    }//GEN-LAST:event_txt_agendamentoActionPerformed

    private void txt_nome_animalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nome_animalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nome_animalActionPerformed

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
            java.util.logging.Logger.getLogger(newAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(newAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(newAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(newAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new newAgendamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agenda;
    private javax.swing.JButton btn_agendamento;
    private javax.swing.JButton btn_agendar;
    private javax.swing.JComboBox<String> cmb_animal;
    private javax.swing.JComboBox<String> cmb_hora;
    private javax.swing.JComboBox<String> cmb_kilos;
    private javax.swing.JComboBox<String> cmb_servico;
    private com.toedter.calendar.JCalendar jCalendar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel_Animal;
    private javax.swing.JLabel jLabel_Hora;
    private javax.swing.JLabel jLabel_Nome_Animal;
    private javax.swing.JLabel jLabel_Nome_Dono;
    private javax.swing.JLabel jLabel_Nome_Dono1;
    private javax.swing.JLabel jLabel_Servico;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txt_agendamento;
    private javax.swing.JTextField txt_cpf;
    private javax.swing.JTextField txt_nome_animal;
    private javax.swing.JTextField txt_nome_dono;
    private javax.swing.JTextField txt_telefone;
    // End of variables declaration//GEN-END:variables

    

        
    

    
    
}
