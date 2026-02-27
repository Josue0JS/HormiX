# HormiX
Es una aplicación diseñada para detectar, registrar y controlar los llamados *gastos hormiga*: pequeños consumos diarios que, 
sin darnos cuenta, impactan significativamente nuestras finanzas.

Su objetivo es ayudar a los usuarios a tomar el control de su dinero transformando pequeños gastos en grandes oportunidades de ahorro.

---

# Objetivo del Proyecto

Permitir a los usuarios:

* Registrar gastos diarios
* Clasificarlos por categorías
* Asociarlos a comercios
* Analizar patrones de consumo
* Controlar presupuestos
* Detectar gastos recurrentes

---

# Estructura del Proyecto

El sistema está compuesto por las siguientes entidades principales:

# Usuario:

Gestión de información personal y control financiero individual.

# Gastos:

Registro detallado de cada gasto realizado:

* Descripción
* Fecha
* Valor
* Categoría
* Método de pago
* Estado
* Usuario asociado

# Comercio:

Información de los establecimientos donde se realizan los gastos:

* NIT
* Nombre
* Actividad económica
* Contacto
* Ubicación

# Categoría:

Organización de gastos por tipo:

* Nombre
* Presupuesto límite
* Gasto actual
* Responsable
* Tipo (fija o variable)

---

# Tecnologías Utilizadas:

* Java
* Programación Orientada a Objetos (POO)
* java.time.LocalDate
* Arquitectura basada en entidades

---

# Funcionalidades Principales:

* Registro de gastos
* Clasificación por categorías
* Asociación de gastos a comercios
* Control de presupuestos
* Gestión de usuarios
* Organización y análisis básico de datos financieros

---

# Estado del Proyecto:

En desarrollo.

---

 # Visión Futura:

* Panel de análisis con estadísticas
* Reportes mensuales
* Sistema de alertas de presupuesto
* Interfaz gráfica (GUI)
* Conexión con base de datos

---

#Autores

* Victor Betancur
* Andres Ruiz
* Josue Lorenzo

---

# El proyecto utiliza la siguiente estrategia de ramas:

* main → versión estable del proyecto

* develop → rama de integración de nuevas funcionalidades

* feature/nombre-funcionalidad → desarrollo de nuevas características

* hotfix/nombre-fix → correcciones urgentes

# Flujo de trabajo:

* Crear rama desde develop

* Desarrollar funcionalidad

* Hacer commits descriptivos

* Crear Pull Request hacia develop

* Una vez validado, se fusiona

---

# Reglas de Colaboración

No se realizan commits directos a main

Todas las funcionalidades deben pasar por develop

Los commits deben ser descriptivos (ej: feat: registro de gastos)

Cada nueva funcionalidad debe crearse en una rama feature/*

Las fusiones se realizan mediante Pull Request
