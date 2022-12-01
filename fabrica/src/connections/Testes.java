/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connections;
import connections.MySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import objects.AgendamentoAnimal;
/**
 *
 * @author fekwa
 */
public class Testes {
    
    MySQL conectar = new MySQL();
    
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<AgendamentoAnimal> lista = new ArrayList<>();
    
   public ArrayList<AgendamentoAnimal> PesquisarAgendamento(){
       String sql = "select * from agendamento";
       this.conectar.conectaBanco();
       conn = conectar.getConn();
       try {
           pstm = conn.prepareStatement(sql);
           rs = pstm.executeQuery();
           
           while(rs.next()){
               AgendamentoAnimal agend = new AgendamentoAnimal();
               agend.setIdDono(rs.getInt("idFuncionario"));
               agend.setNomeDono(rs.getString("idDono"));
               agend.setNomeAnimal(rs.getString("idPet"));
               
               lista.add(agend);
           }
       } catch(SQLException erro) {
           JOptionPane.showMessageDialog(null, "Algo errado aconteceu" + erro);
       }
       return lista;
   }
}


