/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.gui;

import java.awt.Dimension;
import javax.swing.JTextField;

/**
 *
 * @author HP
 */
public class Text extends JTextField{

     public static final Dimension SMALL = new Dimension(75, 25);
    public static final Dimension MEDIUM = new Dimension(150, 25);
    public static final Dimension LARGE = new Dimension(250, 25);

    public Text() {

        setPreferredSize(SMALL);

    }

    public Text(Dimension dimension) {
        setPreferredSize(dimension);
    }
    
    
}
