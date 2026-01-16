/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.gui;

import java.awt.Dimension;

/**
 *
 * @author HP
 */
public class TextLarge extends Text {

    public TextLarge() {
        super();
        setPreferredSize(LARGE);
    }

    @Override
    public void setPreferredSize(Dimension preferredSize) {
        super.setPreferredSize(preferredSize); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setSize(Dimension d) {
        super.setSize(d); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
