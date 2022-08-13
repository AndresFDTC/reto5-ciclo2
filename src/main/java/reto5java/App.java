package reto5java;

import javax.swing.JFrame;
import java.awt.*;


import reto5java.view.InformesView;


public class App 
{
    public static void main( String[] args )
    {
        var informesView = new InformesView();
        // el FlowLayout ayuda con el flujo de posicionamiento
        // de elementos en la ventana
        FlowLayout flowLayout = new FlowLayout();
        informesView.setLayout(flowLayout);
        informesView.setMinimumSize(new Dimension(550, 620));
        informesView.setVisible(true);
        informesView.setBackground(Color.WHITE);
        // bloquea la edicion de el tamano de la ventana
        informesView.setResizable(false);
        informesView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Pone la ventana en medio de la pantalla
        informesView.setLocationRelativeTo(null);
         
    }
}
