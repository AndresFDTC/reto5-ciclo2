package reto5java.controller;

import java.util.List;
import java.sql.SQLException;

import reto5java.model.dao.*;
import reto5java.model.vo.*;

public class InformesController {
    private PrimerInformeDao primerInformeDao;
    private SegundoInformeDao segundoInformeDao;
    private TercerInformeDao tercerInformeDao;

    public  InformesController(){
        primerInformeDao = new PrimerInformeDao();
        segundoInformeDao = new SegundoInformeDao();
        tercerInformeDao = new TercerInformeDao();
    }

    public List<PrimerInformeVo> listarPrimerInforme() throws SQLException {
        return primerInformeDao.listar();
    }

    public List<SegundoInformeVo> listarSegundoInforme() throws SQLException {
        return segundoInformeDao.listar();
    }

    public List<TercerInformeVo> listarTercerInforme() throws SQLException {
        return tercerInformeDao.listar();
    }
}
