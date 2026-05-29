# Guía de Comandos Git — Actividad GitHub
**Carlos David Ruiz Lemus | Ingeniería de Software**

---

## PASO 1 — Configurar Git por primera vez

```bash
git config --global user.name "Carlos David Ruiz Lemus"
git config --global user.email "tu-correo@ejemplo.com"
```

---

## PASO 2 — Crear el repositorio local e inicializar

```bash
# Entrar a la carpeta del proyecto
cd inventario-app

# Inicializar repositorio Git
git init

# Ver el estado actual (comando: status)
git status
```

---

## PASO 3 — Agregar archivos y hacer el primer commit

```bash
# Agregar todos los archivos al área de preparación (comando: add)
git add .

# Ver el estado después de agregar (comando: status)
git status

# Hacer el primer commit (comando: commit)
git commit -m "HU-001: Estructura inicial del proyecto - clase Producto y Main"

# Ver historial de commits (comando: log)
git log --oneline
```

---

## PASO 4 — Conectar con GitHub (comando: remote)

```bash
# Crear un repositorio en github.com (hazlo desde la web, sin README)
# Luego conectar el repositorio local con GitHub:
git remote add origin https://github.com/TU-USUARIO/inventario-app.git

# Verificar la conexión remota
git remote -v
```

---

## PASO 5 — Subir el proyecto a GitHub (comando: push)

```bash
# Subir la rama principal
git push -u origin main
```

---

## PASO 6 — Trabajar con ramas (comando: branch)

```bash
# Crear rama para HU-002 (consultar inventario)
git branch feature/HU-002-consultar-inventario

# Cambiar a esa rama
git checkout feature/HU-002-consultar-inventario

# (Hacer cambios en el código...)

# Agregar y commitear los cambios
git add .
git commit -m "HU-002: Implementar consulta de inventario completo"

# Subir la rama a GitHub
git push origin feature/HU-002-consultar-inventario

# Volver a main y fusionar
git checkout main
git merge feature/HU-002-consultar-inventario
git push origin main
```

---

## PASO 7 — Repetir para cada historia de usuario

```bash
# HU-003
git branch feature/HU-003-entrada-mercancia
git checkout feature/HU-003-entrada-mercancia
git add .
git commit -m "HU-003: Implementar registro de entradas de mercancia"
git push origin feature/HU-003-entrada-mercancia
git checkout main
git merge feature/HU-003-entrada-mercancia
git push origin main

# HU-004
git branch feature/HU-004-salida-mercancia
git checkout feature/HU-004-salida-mercancia
git add .
git commit -m "HU-004: Implementar registro de salidas y validacion de stock"
git push origin feature/HU-004-salida-mercancia
git checkout main
git merge feature/HU-004-salida-mercancia
git push origin main

# HU-005
git branch feature/HU-005-alertas-stock
git checkout feature/HU-005-alertas-stock
git add .
git commit -m "HU-005: Implementar alertas de reabastecimiento por stock bajo"
git push origin feature/HU-005-alertas-stock
git checkout main
git merge feature/HU-005-alertas-stock
git push origin main
```

---

## PASO 8 — Clonar el repositorio (comando: clone)

```bash
# Si necesitas descargarlo en otro equipo:
git clone https://github.com/TU-USUARIO/inventario-app.git
```

---

## PASO 9 — Verificar el .gitignore (comando: ignore)

```bash
# El archivo .gitignore ya está creado en el proyecto.
# Para verificar que Git lo reconoce:
git status

# Los archivos .class y carpeta out/ NO deben aparecer en la lista.
# Si ya los agregaste antes, limpia el caché:
git rm -r --cached out/
git add .
git commit -m "fix: aplicar reglas de .gitignore correctamente"
```

---

## PASO 10 — Ver historial final (comando: log)

```bash
git log --oneline --graph --all
```

---

## Resumen de comandos usados

| Comando | Para qué sirve |
|---------|---------------|
| `git add` | Agregar archivos al área de preparación |
| `git commit` | Guardar los cambios con un mensaje |
| `git branch` | Crear y listar ramas |
| `git remote` | Conectar con repositorio remoto |
| `git push` | Subir cambios a GitHub |
| `git status` | Ver el estado actual del repositorio |
| `git log` | Ver historial de commits |
| `git clone` | Descargar un repositorio |
| `.gitignore` | Excluir archivos del control de versiones |
