/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.gui;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author HP
 */
public class Select extends JComboBox<Object>{

    public Select() {
        setModel(new DefaultComboBoxModel<>(new String[]{"Uno", "Dos"}) );
        setPreferredSize(Text.MEDIUM);
        
        
        
        
        
    }
    
    
}
