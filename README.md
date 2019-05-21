# GladiatorServer
Servidor Del juego Genetico Gladiator

Carpeta Gladiators2
Servidor Web en Libery, que permite crear una comunicacion entre el server de juego un Un clienteG.

Carpeta ClienteG
Se conecta a un URL, y es capas de hacer las siguientes operaciones:

* Get con extencion "/population": retorna una poblacion de Gladiadores y de Torretas en formato JSON
* Get con extension "/population/Gladiators": retorna los stats de la generacion actual de gladiadores
* Get con extension "/population/towers": retorna los stats de la generacion actual de Torreatas
* Post con extension "/population/Gladiators": se postea con la generacion de los galdiadores modificada 
para que retorne la lista pero con objetos modificados y con los x y y en 0.
* Post con extension "/population/towers": se postea con la generacion de las Torretas modificada 
para que retorne la lista pero con objetos modificados y con los x y y en 0.
