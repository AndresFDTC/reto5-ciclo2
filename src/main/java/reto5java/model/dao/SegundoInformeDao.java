package reto5java.model.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import reto5java.model.vo.SegundoInformeVo;
import reto5java.util.JDBCUtilities;

public class SegundoInformeDao {
    public List<SegundoInformeVo> listar() throws SQLException {
        ArrayList<SegundoInformeVo> segundoInforme = new ArrayList<SegundoInformeVo>();
        Connection conn = JDBCUtilities.getConnection();
        Statement stm = null;
        ResultSet rs = null;
        String consulta = "select ID_Proyecto as id, Constructora, Numero_Habitaciones as habitaciones, Ciudad  from Proyecto Where Clasificacion = 'Casa Campestre' and Ciudad in ('Santa Marta','Cartagena','Baranquilla')";
        try {
            stm = conn.createStatement();
            rs = stm.executeQuery(consulta);
            while(rs.next()) {
                SegundoInformeVo vo = new SegundoInformeVo();
                vo.setId(rs.getInt("id"));
                vo.setConstructora(rs.getString("constructora"));
                vo.setCiudad(rs.getString("ciudad"));
                vo.setHabitaciones(rs.getInt("habitaciones"));
                segundoInforme.add(vo);
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
        }return segundoInforme;
    }
}
