#Remarques :
	- //On n'appelle jamais de methode qu'on peut redefinir (methode public) dans le constructeur
	- // Les sous on les represente en long, pas en double. les double font perdre les sous xD
	- Pas de design DIEU = Une classe pleine de méthode qui fait tout, par la quelle on est obligé de passer
	- Si on veut juste partager du code, entre deux trucs qui ont la meme interface, on utilise les méthodes default de l'interface
	- On ne met pas de classe abstraite en public, car a un moment, quelqu'un pourrait l'utiliser, et au moment ou on voudra l'enlever ce sera un bordel,
		c'est pareil que de mettre les champs public
	- jamais de switch ou de if sur un type, on délégue!
#1. UML Diagram
#2. 
#3.
	- Parcequ'ils ne changent pas
	- On crée une fonction dans employee => requirePositive
	- Pour éviter d'envoyer NULL : on ne veut pas tester si sa vaut null.
	- Pour ne pas violer le principe d'encapsulation de employees
	- Parcequ'on en a pas besoin
#4.	Rendre la construction de Employee non publique : la seule façon de créer un employé c'est de l'ajouter au payement
#5. - Resp. bonus : gérer les bonus
	- Resp. payment : gérer les employés
	- Resp. employee : gérer le payement des employés
	- Le calcul de la paye total est la resp. de payment. Le calcul du salair est la resp de Employee. 
#6. On crée une interface entre les deux : Employee et Student
#7. implementation de l'interface
#8. créer une classe abstraite et modifier l'implémentation, par contre le design, et le diagrame reste le meme
	
#9. Si les employés peuvent etre des etudiants, alors tout ce qu'on a fait est a jeter. donc etudiant c'est simplement un champ de employé, pour dire si c'est un
etudiant ou pas. si etudiant peut etre ou ne pas etre un employé, alors ce n'est qu'un champ.
On fait une structure ? Employé, etudiant
	- Status : sa resp. est de savoir si on est étudiant ou employé, elle calcule le salaire.
	- Salaried : stocke les salaires et bonus
	- Payment : stocke les employés
	