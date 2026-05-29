package com.inventario;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Inventario {
    private List<Producto> productos;
    private int contadorId;
    private static final int STOCK_MINIMO = 5;

    public Inventario() {
        this.productos = new ArrayList<>();
        this.contadorId = 1;
    }

    // HU-001: Registrar nuevo producto
    public Producto agregarProducto(String nombre, String categoria, int cantidad, double precio) {
        Producto p = new Producto(contadorId++, nombre, categoria, cantidad, precio);
        productos.add(p);
        System.out.println("✔ Producto registrado: " + nombre);
        return p;
    }

    // HU-002: Consultar inventario
    public void mostrarInventario() {
        if (productos.isEmpty()) {
            System.out.println("El inventario está vacío.");
            return;
        }
        System.out.println("\n╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║              INVENTARIO DE PRODUCTOS                        ║");
        System.out.println("╠══════╦══════════════════════╦══════════════╦══════════╦════════════╣");
        System.out.println("║ ID   ║ Nombre               ║ Categoría    ║ Cantidad ║ Precio     ║");
        System.out.println("╠══════╬══════════════════════╬══════════════╬══════════╬════════════╣");
        for (Producto p : productos) {
            System.out.println(p.toString());
        }
        System.out.println("╚══════════════════════════════════════════════════════════════╝");
        System.out.println("Total de productos: " + productos.size());
    }

    // HU-003: Registrar entrada de mercancía
    public void registrarEntrada(int id, int cantidad) {
        Optional<Producto> resultado = buscarPorId(id);
        if (resultado.isPresent()) {
            Producto p = resultado.get();
            p.setCantidad(p.getCantidad() + cantidad);
            System.out.println("✔ Entrada registrada. Nuevo stock de '" + p.getNombre() + "': " + p.getCantidad());
        } else {
            System.out.println("✘ Producto con ID " + id + " no encontrado.");
        }
    }

    // HU-004: Registrar salida de mercancía
    public void registrarSalida(int id, int cantidad) {
        Optional<Producto> resultado = buscarPorId(id);
        if (resultado.isPresent()) {
            Producto p = resultado.get();
            if (p.getCantidad() < cantidad) {
                System.out.println("✘ Stock insuficiente. Disponible: " + p.getCantidad());
                return;
            }
            p.setCantidad(p.getCantidad() - cantidad);
            System.out.println("✔ Salida registrada. Nuevo stock de '" + p.getNombre() + "': " + p.getCantidad());
            verificarAlerta(p);
        } else {
            System.out.println("✘ Producto con ID " + id + " no encontrado.");
        }
    }

    // HU-005: Alertas de reabastecimiento
    public void verificarAlertas() {
        System.out.println("\n⚠ ALERTAS DE REABASTECIMIENTO:");
        boolean hayAlertas = false;
        for (Producto p : productos) {
            if (p.getCantidad() <= STOCK_MINIMO) {
                System.out.println("  → " + p.getNombre() + " | Stock actual: " + p.getCantidad() + " (mínimo: " + STOCK_MINIMO + ")");
                hayAlertas = true;
            }
        }
        if (!hayAlertas) System.out.println("  Todos los productos tienen stock suficiente.");
    }

    private void verificarAlerta(Producto p) {
        if (p.getCantidad() <= STOCK_MINIMO) {
            System.out.println("⚠ ALERTA: Stock bajo en '" + p.getNombre() + "' (" + p.getCantidad() + " unidades)");
        }
    }

    private Optional<Producto> buscarPorId(int id) {
        return productos.stream().filter(p -> p.getId() == id).findFirst();
    }

    public List<Producto> getProductos() { return productos; }
}
