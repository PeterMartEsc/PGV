Ejercicio 1: "La Carrera de las Tortugas Ninja"
Descripción: Las Tortugas Ninja (Leonardo, Donatello, Rafael, y Miguel Ángel) han decidido competir en una carrera para determinar quién es la más rápida. Cada tortuga correrá en su propio hilo, avanzando en intervalos de tiempo aleatorios. La carrera termina cuando una de las tortugas cruza la línea de meta (llegando a una distancia definida, por ejemplo, 100 metros).

Objetivo: Crea un programa que simule esta carrera utilizando hilos en Java. Cada tortuga debe informar su progreso cada 10 metros. El primer hilo en llegar a 100 metros debe ganar y detener a los demás.

***

Ejercicio 2: "Control de Asistencia Jedi"
Descripción: Los Jedi necesitan un sistema de control de asistencia para su entrenamiento en el Templo Jedi. Crea un programa en el que varios Jedi (anidados en un ExecutorService) puedan registrar su asistencia concurrentemente. Cada Jedi tarda entre 1 y 3 segundos en registrarse. La base de datos de asistencia (una lista sincronizada) debe mantener un registro exacto de quién ha asistido.

Objetivo: Implementa este registro utilizando un ExecutorService con un número fijo de hilos. Simula que cada Jedi es un hilo que intenta registrar su asistencia.
***

Ejercicio 3: "El Chat del Consejo de Magos"
Descripción: Los magos de distintos reinos usan un sistema de chat basado en sockets para comunicarse y compartir sus hechizos. Crea un programa cliente-servidor usando sockets. El servidor debe permitir que múltiples magos (clientes) se conecten y envíen mensajes. El servidor debe retransmitir cada mensaje a todos los magos conectados.

Objetivo: Implementa el servidor utilizando ServerSocket para aceptar múltiples conexiones y retransmitir los mensajes entrantes a todos los clientes. Cada cliente debe tener su propio hilo.
***
Ejercicio 4: "El Banquete de Odín"
Descripción: Odín organiza un banquete en Valhalla y necesita controlar el acceso de los guerreros al gran salón. Solo pueden entrar un número limitado de guerreros a la vez, y cada guerrero tarda entre 500 ms y 1 segundo en ingresar y acomodarse en la mesa.

Objetivo: Implementa el control de acceso usando un Semaphore con un límite de guerreros (por ejemplo, 3 guerreros a la vez). Cada guerrero debe ejecutarse en su propio hilo y esperar a que haya un asiento disponible.

***

Ejercicio 5: "El Juego de Rol de los Hechiceros"
Descripción: Diseña un pequeño juego de rol en el que cada hechicero (un hilo) tiene puntos de vida y energía. Los hechiceros pueden lanzar hechizos para atacar a otros hechiceros. Cada ataque reduce los puntos de vida de otro hechicero. Un hechicero que pierde todos sus puntos de vida queda fuera del juego.

Objetivo: Crea un programa que permita que varios hechiceros (hilos) se ataquen entre sí de manera

***