# Mission pour Mars !

Il s'agit d'un petit exercice issue du site https://kata-log.rocks/mars-rover-kata.
Le projet a été réalisé en Kotlin et est assez basique.

L'idée est de pouvoir déplacer un rover sur une planete sur les axes X et Y.
Les points cardinaux nous permetront de nous situer sur le plan.
Il est possible que le rover rencontre des obstacles durant ses déplacements. Il s'arretera alors et mettra fin
à son itineraire.

                ^                  North
             Y  |
                |
                |
                | West                                  East
                |
                |
    ------------------------------------------------------->
                |                                       X
                |
                |
                |
                |                   South

## Prérequis

Afin de pouvoir exécuter l'application sur votre poste, vous devez d'aborder installer les dépendances suivantes :

* Java 17

## Lancer le projet

Pour tester le projet, plusieurs options s'offrent à vous :

* Lancer les tests presents sous src/main/test
* Lancer manuellement la fonction main du Navigator.kt
