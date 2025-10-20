# Examen Parcial: Juego de Colores



Desarrolla una aplicación usando Kotlin y Android Studio. El juego pondrá a prueba tu capacidad de crear una app interactiva con múltiples fragments, navegación, gestión de estados del ciclo de vida, interacción avanzada con RecyclerView, manejo de diálogos, lógica condicional y elementos visuales.



---



## Objetivo



Crear un juego donde el usuario debe presionar el botón que coincida con el color que aparece en pantalla.  

El objetivo es obtener la mayor cantidad de aciertos en **30 segundos** y mostrar el historial de puntajes en la sesión (sin usar base de datos).



---



## Componentes de la Aplicación



### 1. Fragmento de Bienvenida (WelcomeFragment)

- Mostrar el título del juego.

- Mensaje de bienvenida y reglas del juego mediante un **AlertDialog**.

- Botón “Iniciar juego” para comenzar.

- Interfaz libre que puede incluir imágenes o elementos decorativos.



### 2. Fragmento del Juego (GameFragment)

- Cuadro que muestra un color aleatorio a adivinar (rojo, verde, azul, amarillo, etc.).

- Botones de colores para responder.

- Cada acierto suma un punto y cambia el color.

- Temporizador de 30 segundos.

- Mostrar puntaje actual y tiempo restante.

- El juego finaliza al agotarse el tiempo.



### 3. Fragmento de Resultados (ResultFragment)

- Mostrar el puntaje final de la partida actual.

- Mostrar el puntaje más alto histórico (usando **SharedPreferences**).

- RecyclerView para mostrar el historial de puntajes de la sesión (sin persistencia).

- Botón para volver a jugar.



---



## Funcionalidades Adicionales (obligatorio elegir al menos una)



* Sonidos al juego (aciertos, errores, música de fondo).  
* Guardar el historial de puntajes usando **Room**, recuperar el puntaje más alto con consultas.  
* Animaciones para botones o colores que aparecen.  
* Niveles de dificultad (por ejemplo, efecto Stroop, aumento de colores, etc.).



---





