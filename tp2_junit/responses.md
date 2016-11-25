## Questions

- 1. - test unitaire : test comportement d'un module.
	 - test integration : test de plusieurs module, la technique utilisé lors de ces tests : mocking => creer des classes qui ont le meme comportement, ces classes là on les voit a travers des interfaces, tester : la bdd, utiliser des bdd qui stockent sur les ram, bdd embarqués.
	 - comme il ya plusieurs trucs a tester, quand sa plante on sait pas d'ou sa vient
     - les tests d'integration et unitaire ne se situent pas au meme endroit.

- 2. - ecrire les tests dabord et considerer que cest la spécification du code qu'on doit ecrire. le tdd sadresse principalement aux developpeurs, les tdd generalement donnent des librairies qui ne seront pas pour le client
	 - son but : essayer d'ecrire au moins une seule fois les specification

- 3. - covering test * fuzz test change les constantes, les if statements..
	 - le probleme du fuzzing : faire un changement, ensuite un test unitaire, ainsi de suite
	 