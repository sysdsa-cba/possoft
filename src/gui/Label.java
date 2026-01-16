/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.gui;

import java.awt.Dimension;
import javax.swing.JLabel;

/**
 *
 * @author HP
 */
public class Label extends JLabel {

    public static final Dimension SMALL = new Dimension(75, 25);
    public static final Dimension MEDIUM = new Dimension(150, 25);
    public static final Dimension LARGE = new Dimension(250, 25);

    public Label() {

        setPreferredSize(SMALL);

    }

    public Label(Dimension dimension) {
        setPreferredSize(dimension);
    }

}
