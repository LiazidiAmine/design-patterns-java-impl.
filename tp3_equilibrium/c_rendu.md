## Equilibrium
	
	##1. Remarques avant de commencer :
	
	- Player : 
			    - Champs public, pas d'encapsulation.
				- Le path est un string, probléme d'abstraction
				- Pas de code dans le constructeur ! Le constructeur doit initialiser des valeurs, non pas parser des fichiers
	- Monster : - Champs public
	- Game : - Accés aux champs public directement..
	
	##_
	
	- Player : Séparer l'initialisation et le parsing de fichier. Pour tester Player, il faut créer un fichier, faut donc séparer les deux opérations.
	* Un code doit avoir une seule resp.
	* Le design pattern qu'il nous faut : Static method factory. Sa nous permet de séparer notre code de parsing et de création.
	* pas de foreach sur les stream
	* Fermer un code : veut dire on ne peut plus le modifier, ça veut dire que ce code là je ne vais plus le modifier. Un module peut etre ouvert (on peut se permettre de le changer) ou fermer(quand on ferme on écrit la doc).
		On ne ferme pas au niveau d'une classe ou une fonction, mais au niveau d'un module. 
		Fermer du code, permet de réduire la compléxité.
		On va sortir le parsing, le fermer, et pouvoir le réutiliser.
		On crée un parser avec une méthode statique, quand on a des entrée sorties seulement à gerer
		La méthode de parsing est public, on ne renvois donc pas de arraylist
	* Les diagram UML décrivent la conception, donc ils ne conaissent pas les lambda.
	* On ne fait pas de getters, sa revient au meme que d'avoir des champs publics
	* Iterator contient une méthode remove, sa casse l'encapsulation. il faut donc un iterator non mutable, on transforme donc la liste de l'iterator en unmodifiable
	* utiliser une map qui associe un nom a une action
	* on veut abstraire " comment parser quelque chose " donc on crée une map dans la quelle on associe une action a un nom