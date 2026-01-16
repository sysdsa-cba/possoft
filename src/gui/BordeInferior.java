/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.gui;

import javax.swing.border.AbstractBorder;

/**
 *
 * @author HP
 */
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.border.AbstractBorder;

public class BordeInferior extends AbstractBorder {

    protected int thickness;

    protected Color lineColor;

    protected int gap;

    public BordeInferior() {
        this.lineColor = new Color(0, 128, 0);
        this.gap = 3;
    }

    public BordeInferior(Color color) {
        this(color, 1, 1);
    }

    public BordeInferior(Color color, int thickness) {
        this(color, thickness, thickness);
    }

    public BordeInferior(Color color, int thickness, int gap) {
        lineColor = color;
        this.thickness = thickness;
        this.gap = gap;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Color oldColor = g.getColor();
        int i;

        g.setColor(lineColor);
        //  for (i = 0; i < thickness; i++) {
        //g.drawLine(x, y + height - i - 1, x + width, y + height - i - 1);
        //  }
        g.drawLine(x + 1, y + height - 0 - 1, x + width - 2, y + height - 0 - 1);
        g.drawLine(x, y + height - 1 - 1, x + width, y + height - 1 - 1);
        g.drawLine(x + 1, y + height - 2 - 1, x + width - 2, y + height - 2 - 1);
        g.setColor(oldColor);
    }

    public Insets getBorderInsets(Component c) {
        return new Insets(0, 0, gap, 0);
    }

    public Insets getBorderInsets(Component c, Insets insets) {
        insets.left = 0;
        insets.top = 0;
        insets.right = 0;
        insets.bottom = gap;
        return insets;
    }

    /**
     * Returns the color of the border.
     */
    public Color getLineColor() {
        return lineColor;
    }

    /**
     * Returns the thickness of the border.
     */
    public int getThickness() {
        return thickness;
    }

    /**
     * Returns whether or not the border is opaque.
     */
    public boolean isBorderOpaque() {
        return false;
    }

    public int getGap() {
        return gap;
    }

}
