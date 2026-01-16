/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

class Titulo extends JLabel{

    public Titulo() {
        super();
    }
    
    public Titulo(String titulo){
        super(titulo, SwingConstants.CENTER);
       this.setFont(new java.awt.Font("Comic Sans MS", 3, 12));
    }
    
}