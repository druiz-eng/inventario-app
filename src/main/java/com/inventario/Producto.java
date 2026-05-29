package com.inventario;

public class Producto {
    private int id;
    private String nombre;
    private String categoria;
    private int cantidad;
    private double precio;

    public Producto(int id, String nombre, String categoria, int cantidad, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getCategoria() { return categoria; }
    public int getCantidad() { return cantidad; }
    public double getPrecio() { return precio; }

    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
    public void setPrecio(double precio) { this.precio = precio; }

    @Override
    public String toString() {
        return String.format("| %-4d | %-20s | %-12s | %-8d | $%-9.2f |",
                id, nombre, categoria, cantidad, precio);
    }
}
