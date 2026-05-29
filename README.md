# Sistema de Gestión de Inventario

Proyecto desarrollado en Java para el control de inventario de una empresa.  
Permite registrar productos, controlar entradas y salidas de mercancía, y generar alertas de reabastecimiento.

## Funcionalidades

- Ver inventario completo de productos
- Agregar nuevos productos al sistema
- Registrar entradas de mercancía (compras)
- Registrar salidas de mercancía (ventas/despachos)
- Alertas automáticas de stock bajo

## Historias de Usuario

| ID | Historia |
|----|----------|
| HU-001 | Como administrador, quiero registrar nuevos productos con nombre, categoría, cantidad y precio. |
| HU-002 | Como bodeguero, quiero consultar el inventario completo con todos sus atributos. |
| HU-003 | Como bodeguero, quiero registrar entradas de mercancía para actualizar el stock disponible. |
| HU-004 | Como bodeguero, quiero registrar salidas de mercancía y recibir aviso si el stock queda bajo. |
| HU-005 | Como gerente, quiero ver un reporte de alertas de productos con stock por debajo del mínimo. |

## Estructura del proyecto

```
inventario-app/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── inventario/
│                   ├── Main.java
│                   ├── Inventario.java
│                   └── Producto.java
├── .gitignore
└── README.md
```

## Cómo ejecutar

```bash
# Compilar
javac -d out src/main/java/com/inventario/*.java

# Ejecutar
java -cp out com.inventario.Main
```

## Tecnologías

- Java 11+
- Git / GitHub para control de versiones

## Autor

Carlos David Ruiz Lemus  
Ingeniería de Software — Universidad Iberoamericana
