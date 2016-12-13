## Compte_rendu

- 1. on a des classes differentes si on a des comportements differents
	si on a seulement des valeurs differentes, on ne fait pas de hierarchie, on delegue
	si on n'a pas des comportements differents on ne crée pas de hierarchies
	hierarchie = pas les meme methodes
- 2. certaines structures d'arbres. => structure fractale, structure recursive
	* transparent : on ne fournit rien de supplémentaire, le groupe ne doit pas avoir plus de méthodes que l'interface
		le composant n'a pas plus de méthodes que le composite
		* on peut implementer des methodes qui font planter
	* sûr : pour toute les methodes on fait quelque chose, elles ne plantent pas
	
	
un final s'applique aux variables et non pas aux objets

ArmyTruck n'est pas un design pattern, elle a une méthode en trop par rapport à l'interface Unit
Faudrait que l'armyTruck puisse contenir des Unit, or ArmyTruck ne contient que des Soldiers
Ce n'est pas grave, cest ce qu('on veut

on crée une classe abstraite pour partager un comportement seulement. pas de champ!!!

	