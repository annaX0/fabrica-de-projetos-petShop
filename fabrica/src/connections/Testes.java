/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connections;
import connections.MySQL;
import java.sql.SQLException;
/**
 *
 * @author fekwa
 */
public class Testes {
    MySQL conectar = new MySQL();
    String usuario = "ADMIN";
    String resultado = "";
    public void buscaCliente() throws SQLException{
        
        this.conectar.conectaBanco();
        
        String comando = "Select nome from funcionario where nome = '12';";
        
        this.conectar.executarSQL(comando);
        while (this.conectar.getResultSet().next()) {
             resultado = this.conectar.getResultSet().getString(1);
           
        }
        if(resultado.equals("")){
            resultado = "VAZIO";
        }else{
            System.out.println("STRING POSSUI ALGO");
        }
        System.out.println(resultado);
        
    } 
}


