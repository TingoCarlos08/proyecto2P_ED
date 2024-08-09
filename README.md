# Proyecto de Estructuras de Datos: Juego de 20 Preguntas

## Descripción

Este proyecto es parte de la segunda evaluación del curso de Estructuras de Datos en ESPOL (2024). El objetivo principal es implementar un juego de "20 Preguntas" en el que la computadora intenta adivinar un animal pensado por el usuario, utilizando un árbol binario de decisión. La aplicación fue desarrollada en Java utilizando JavaFX para la interfaz gráfica, y no se han utilizado librerías externas para la implementación del árbol binario.

## Integrantes

- Carlos Tingo
- Nahin Cevallos
- Abraham 

## Funcionalidades

### Funcionalidades Mínimas
- **Carga de Archivos**: La aplicación permite cargar archivos de texto con preguntas y respuestas al iniciar.
- **Configuración de Partida**: Permite establecer el número máximo de preguntas que la computadora puede hacer.
- **Interfaz Interactiva**: Interfaz sencilla para que el usuario pueda responder a las preguntas de la computadora con opciones de "Sí" o "No".
- **Resultados del Juego**:
  - Adivinanza Correcta: La computadora muestra el animal adivinado.
  - Sin Coincidencias: Si las respuestas no coinciden con ningún animal en los archivos de respuestas, se notifica al usuario.
  - Múltiples Posibles Respuestas: Si después de N preguntas la computadora no puede determinar un animal específico, se muestra un conjunto de posibles respuestas.

### Funcionalidades Opcionales
- **Persistencia de Datos**: La aplicación guarda el progreso y los datos de la partida para su uso en futuras sesiones.
- **Mejoras en la Interfaz**: Adición de características adicionales en la interfaz para mejorar la experiencia del usuario.

## Requerimientos Técnicos

- **Lenguaje**: Java
- **Interfaz Gráfica**: JavaFX
- **Estructura de Datos**: Implementación de un árbol binario de decisión sin uso de librerías externas.

## Instrucciones de Uso

1. **Cargar Archivos**: Al iniciar la aplicación, cargue los archivos `preguntas.txt` y `respuestas.txt`.
2. **Configurar el Juego**: Establezca el número máximo de preguntas que la computadora puede hacer.
3. **Iniciar Partida**: Piense en un animal y responda las preguntas que la computadora le haga.
4. **Ver Resultados**: Al finalizar las preguntas, vea si la computadora adivinó correctamente o si presenta posibles opciones.

## Ejecución

1. **NetBeans**: Abra el proyecto en NetBeans.
2. **Compilar y Ejecutar**: Compile y ejecute el proyecto para iniciar la aplicación.

## Capturas de Pantalla

### Pantalla Principal
![Pantalla Principal](images/pantalla_principal.png)

### Ejemplo de Juego
![Ejemplo de Juego](images/ejemplo_juego.png)

## Contribuciones

Este proyecto fue desarrollado de manera colaborativa por los integrantes del grupo. Cada miembro contribuyó en las distintas fases del desarrollo, desde la implementación del árbol binario hasta la creación de la interfaz gráfica.
