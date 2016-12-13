## Compte rendu

	- 1. L'idée du design pattern Visitor : 
		Ajouter des fonctionnalités à une classe, sans devoir la toucher. L'avantage, c'est qu'on peut le faire, meme sans avoir accés à la classe.
	- 2. L'inconvénient : 
		On casse l'encapsulation => avoir accés au contenu exterieur de la classe.
		on devra fermer la classe => ne pas pouvoir ajouter de sous classes, figer la hiérarchie
	- 3. Element Visitor : on voit un programme java comme une série d'objets, et on peut visiter des morceaux de code
	
	* Quand on a un stream on n'appelle iterator dessus
	* l'ancien nom du visitor est double dispatch
		
	*On ne fait pas de plus dans les appends, a chaque + il recrée un builder