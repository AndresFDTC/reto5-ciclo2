package reto5java.model.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import reto5java.model.vo.PrimerInformeVo;
import reto5java.util.JDBCUtilities;

public class PrimerInformeDao {
    public List<PrimerInformeVo> listar() throws SQLException{
        ArrayList<PrimerInformeVo> primerInforme = new ArrayList<PrimerInformeVo>();
        Connection conn = JDBCUtilities.getConnection();
        Statement stm = null;
        ResultSet rs = null;
        String consulta = "SELECT ID_Lider as id, Nombre, Primer_Apellido as apellido, Ciudad_Residencia as ciudad from Lider l order by Ciudad_Residencia";
        try{
            stm = conn.createStatement();
            rs=stm.executeQuery(consulta);
            while(rs.next()){
                PrimerInformeVo vo = new PrimerInformeVo();
                vo.setId(rs.getInt("id"));
                vo.setNombre(rs.getString("Nombre"));
                vo.setApellido(rs.getString("Apellido"));
                vo.setCiudad(rs.getString("Ciudad"));
                primerInforme.add(vo);
            }
        }
        finally{
            if(rs != null){
                rs.close();
            }
            if (stm != null){
                stm.close();
            }
            if (conn != null){
                conn.close();
            }
        }return primerInforme;
    }
    
}
