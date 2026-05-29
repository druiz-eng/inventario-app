package com.inventario;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        Scanner scanner = new Scanner(System.in);

        // Datos de ejemplo precargados
        inventario.agregarProducto("Laptop Dell XPS", "Electrónica", 15, 1200.00);
        inventario.agregarProducto("Mouse Inalámbrico", "Accesorios", 30, 25.99);
        inventario.agregarProducto("Teclado Mecánico", "Accesorios", 4, 89.99);
        inventario.agregarProducto("Monitor 24\"", "Electrónica", 8, 320.00);
        inventario.agregarProducto("Silla Ergonómica", "Mobiliario", 2, 450.00);

        int opcion;
        do {
            System.out.println("\n╔══════════════════════════════════╗");
            System.out.println("║   SISTEMA DE GESTIÓN INVENTARIO  ║");
            System.out.println("╠══════════════════════════════════╣");
            System.out.println("║  1. Ver inventario               ║");
            System.out.println("║  2. Agregar producto             ║");
            System.out.println("║  3. Registrar entrada            ║");
            System.out.println("║  4. Registrar salida             ║");
            System.out.println("║  5. Ver alertas de stock         ║");
            System.out.println("║  0. Salir                        ║");
            System.out.println("╚══════════════════════════════════╝");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    inventario.mostrarInventario();
                    break;
                case 2:
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Categoría: ");
                    String categoria = scanner.nextLine();
                    System.out.print("Cantidad: ");
                    int cantidad = scanner.nextInt();
                    System.out.print("Precio: ");
                    double precio = scanner.nextDouble();
                    inventario.agregarProducto(nombre, categoria, cantidad, precio);
                    break;
                case 3:
                    System.out.print("ID del producto: ");
                    int idEntrada = scanner.nextInt();
                    System.out.print("Cantidad a ingresar: ");
                    int cantEntrada = scanner.nextInt();
                    inventario.registrarEntrada(idEntrada, cantEntrada);
                    break;
                case 4:
                    System.out.print("ID del producto: ");
                    int idSalida = scanner.nextInt();
                    System.out.print("Cantidad a retirar: ");
                    int cantSalida = scanner.nextInt();
                    inventario.registrarSalida(idSalida, cantSalida);
                    break;
                case 5:
                    inventario.verificarAlertas();
                    break;
                case 0:
                    System.out.println("Cerrando sistema. ¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}
