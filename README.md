# Proyecto: Juego de Colores

## Introducción

Este proyecto consiste en el desarrollo de una aplicación interactiva para Android utilizando **Kotlin** y **Android Studio**.  

El objetivo del juego es que el usuario identifique correctamente el color mostrado en pantalla, presionando el botón correspondiente, dentro de un tiempo límite de 30 segundos. La aplicación pone a prueba habilidades de diseño de interfaces, navegación entre fragments, gestión de estados del ciclo de vida, y la integración de elementos visuales y sonoros.

---

## Descripción de la Aplicación

La aplicación se compone de tres fragments principales:

### 1. Fragmento de Bienvenida

- Presenta el **título del juego** y un mensaje de bienvenida.  
- Explica las **reglas del juego** mediante un cuadro de diálogo (**AlertDialog**).  
- Incluye un botón **“Iniciar juego”** que lleva al usuario al fragmento de juego.  
- La interfaz puede incluir imágenes o elementos decorativos que mejoran la experiencia visual.

### 2. Fragmento del Juego

- Muestra un **cuadro de color aleatorio** que el usuario debe adivinar.  
- Incluye **botones de colores** como opciones de respuesta.  
- Cada acierto suma un punto y cambia el color a adivinar.  
- Temporizador de **30 segundos**, con visualización del puntaje y tiempo restante.  
- Cuando se agota el tiempo, el juego termina automáticamente y se dirige al fragmento de resultados.

### 3. Fragmento de Resultados

- Muestra el **puntaje final** de la partida.  
- Presenta el **puntaje más alto histórico** de la sesión, almacenado mediante **SharedPreferences**.  
- Incluye un **historial de puntajes** de la sesión en un **RecyclerView**.  
- Botón para **volver a jugar**, reiniciando el juego.

---

## Funcionalidades Adicionales

Durante el desarrollo se implementaron opciones para mejorar la experiencia del usuario, incluyendo:

- Sonidos para aciertos y errores.  
- Animaciones en los botones y cambios de color.  
---

## Conceptos Aplicados

Este proyecto demuestra la aplicación de diversos conceptos de desarrollo Android:

- Navegación entre fragments y paso de datos.  
- Uso de temporizador con **CountDownTimer**.  
- Interacción con botones y retroalimentación visual y sonora.  
- Gestión de estados del ciclo de vida de los fragments.  
- Diseño de interfaz con **ConstraintLayout** adaptada a distintos tamaños de pantalla.  
- Uso de recursos de Android (**strings**, **colors**, imágenes, sonidos).  
- Almacenamiento temporal de datos mediante **SharedPreferences**.  
- Implementación de diálogos interactivos con **AlertDialog**.  

---

## Conclusión

El **Juego de Colores** combina entretenimiento con una demostración práctica de desarrollo Android, integrando lógica de programación, diseño de interfaz, interacción del usuario y almacenamiento de datos de manera eficiente.  

El proyecto cumple con los objetivos del examen parcial, ofreciendo una experiencia de usuario atractiva y funcional, y sirviendo como ejemplo de buenas prácticas en **Kotlin** y desarrollo de aplicaciones móviles.
