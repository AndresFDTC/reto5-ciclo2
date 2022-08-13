package reto5java.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


import java.awt.*;
import java.awt.event.*;
import java.util.List;

import reto5java.controller.InformesController;
import reto5java.model.vo.PrimerInformeVo;
import reto5java.model.vo.SegundoInformeVo;
import reto5java.model.vo.TercerInformeVo;;

public class InformesView extends JFrame implements ActionListener{
    private static InformesController controller;
    private JMenuBar mMenuBar;
    private JMenu menu;
    private JMenuItem inf1,inf2,inf3;
    private JTable tabla;
    private DefaultTableModel modelo;
    private JLabel labelTitulo, labelConsulta;
    private JTextArea textInformacionArea;
    

    public InformesView(){
        controller = new InformesController();
        Menu();
        etiqueta1();
        etiqueta2();
        etiqueta3();
        tabla();
        
    }

  
    private void tabla() {
        tabla = new JTable(modelo);
        
        add(tabla);
        JScrollPane pane = new JScrollPane(tabla);
        add(pane);
    }

    public void etiqueta1(){
        labelTitulo = new JLabel("Informes");
        labelTitulo.setPreferredSize(new Dimension (500,30));
        labelTitulo.setFont(new Font("Arial", Font.BOLD ,20));
        
        add(labelTitulo);
    }

    public void  etiqueta2(){
        labelConsulta = new JLabel();
        labelConsulta.setPreferredSize(new Dimension (500,30));
        labelConsulta.setFont(new Font("Arial", Font.BOLD,14));
        add(labelConsulta);
    }

    public void  etiqueta3(){
        textInformacionArea = new JTextArea();
        textInformacionArea.setPreferredSize(new Dimension (500,50));
        textInformacionArea.setFont(new Font("Arial",Font.BOLD, 16));
        textInformacionArea.setEditable(false);
        add(textInformacionArea);
    }



    public void Menu(){
        mMenuBar = new JMenuBar();
        setJMenuBar(mMenuBar);
        menu = new JMenu("Informes");
        mMenuBar.add(menu);
        inf1 = new JMenuItem("Primer Informe");
        inf2 = new JMenuItem("Segundo Informe");
        inf3 = new JMenuItem("tercer Informe");
        menu.add(inf1);
        menu.add(inf2);
        menu.add(inf3);
        inf1.addActionListener(this);
        inf2.addActionListener(this);
        inf3.addActionListener(this);
    }
    

   

    private void primerImformeHecho() {
        try {
            List<PrimerInformeVo> primer = controller.listarPrimerInforme();
            //Modelo tabla
            modelo = new DefaultTableModel();
            modelo.addColumn("Id");
            modelo.addColumn("Nombre");
            modelo.addColumn("Apellido");
            modelo.addColumn("Ciudad");
            for(PrimerInformeVo pri: primer){
                Object[] fila = new Object[4];
                fila[0] = pri.getId();
                fila[1] = pri.getNombre();
                fila[2] = pri.getApellido();
                fila[3] = pri.getCiudad();
                modelo.addRow(fila);
            }
            // Agrega el modelo a la tabla y actualiza los datos de la misma.
            tabla.setModel(modelo);
            modelo.fireTableDataChanged();
        } 
        catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
    }

    private void segundoInformeHecho() {
        try {
            List<SegundoInformeVo> segundo = controller.listarSegundoInforme();
            modelo = new DefaultTableModel();
            modelo.addColumn("Id Proyecto");
            modelo.addColumn("Constructura");
            modelo.addColumn("Habitaciones");
            modelo.addColumn("Ciudad");
            for(SegundoInformeVo seg: segundo) {
                Object[] fila = new Object[4];
                fila[0] = seg.getId();
                fila[1] = seg.getConstructora();
                fila[2] = seg.getHabitaciones();
                fila[3] = seg.getCiudad();
                modelo.addRow(fila);
            }
            tabla.setModel(modelo);
            modelo.fireTableDataChanged();
        }
        catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
    }

    private void tercerInformeHecho() {
        try {
            List<TercerInformeVo> tercer = controller.listarTercerInforme();
            modelo = new DefaultTableModel();
            modelo.addColumn("Id de compra");
            modelo.addColumn("Constrcutora");
            modelo.addColumn("Banco Vinculado");
            for(TercerInformeVo tre: tercer){
                Object[] fila = new Object[3];
                fila[0] = tre.getCompraNum();
                fila[1] = tre.getProveedor();
                fila[2] = tre.getBanco();
                modelo.addRow(fila);
            }
            tabla.setModel(modelo);
            modelo.fireTableDataChanged();
        }
        catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == inf1){
            primerImformeHecho();
            labelConsulta.setText("Primer informe");
            textInformacionArea.setText("Información sobre los lideres de proyecto por ciudades.");
            
        }
        if(e.getSource() == inf2){
            segundoInformeHecho();
            labelConsulta.setText("Segundo informe");
            textInformacionArea.setText("Información de proyecto tipo \"Casa Campestre\" ubicados en las \n ciudades de Barranquilla, Cartagena y Santa Marta.");
        }
        if(e.getSource() == inf3){
            tercerInformeHecho();
            labelConsulta.setText("Tercer informe");
            textInformacionArea.setText("Id de las compras realizadas al proveedor \"Homecenter\" para los \nproyectos ubicados en \"Salento\".");
        }
        
    }
    
}
