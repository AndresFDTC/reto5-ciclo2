package reto5java.model.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import reto5java.model.vo.TercerInformeVo;
import reto5java.util.JDBCUtilities;

public class TercerInformeDao {
    public List<TercerInformeVo> listar() throws SQLException {
        ArrayList<TercerInformeVo> tercerInforme = new ArrayList<TercerInformeVo>();
        Connection conn = JDBCUtilities.getConnection();
        Statement stm = null;
        ResultSet rs = null;
        String consulta = "SELECT ID_Compra as CompraNum, Proveedor, Banco_Vinculado as Banco from Compra c, Proyecto p WHERE p.Ciudad = 'Salento' and Proveedor ='Homecenter'";
        try{
            stm = conn.createStatement();
            rs = stm.executeQuery(consulta);
            while (rs.next()) {
                TercerInformeVo vo = new TercerInformeVo();
                vo.setCompraNum(rs.getInt("CompraNum"));
                vo.setProveedor(rs.getString("Proveedor"));
                vo.setBanco(rs.getString("Banco"));
                tercerInforme.add(vo);
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
        }return tercerInforme;
    }
}
