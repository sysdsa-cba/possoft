/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

/**
 *
 * @author xvr
 */
class PrecioProd {

    public int idProducto;
    public String nombre;
    public double precio_1;
    public double precio_2;
    public double precio_3;

    public PrecioProd(int idProducto, String nombre, double precio_1, double precio_2, double precio_3) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precio_1 = precio_1;
        this.precio_2 = precio_2;
        this.precio_3 = precio_3;
    }

    @Override
    public String toString() {
        return idProducto + "-"
                + nombre + "-"
                + precio_1 + "-"
                + precio_2 + "-"
                + precio_3 + "-"; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

}