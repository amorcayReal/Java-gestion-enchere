# Java-gestion-enchere

Cours de soutien : gestion des inscriptions et d’affectations
des salles

Le but de ce projet est de développer une application web permettant à une
association d’inscrire des enfants à des cours de soutien selon la capacité des salles
disponibles.

L’association occupe un bâtiment contenant un nombre limité de salles, ce qui limite
le nombre d’inscrits. 
Aussi, l’association propose des créneaux fixes dans la semaine où
l’enfant doit en choisir un seul. L’enfant sera affecté donc à un créneau selon son niveau
d’étude. 
Les classes sont formées selon les niveaux des élèves (6ème, 5ème,....jusqu’au
Terminal).

Les cours de soutien sont payants, et un montant est associé à un niveau d’étude.
Plusieurs modes de paiements sont proposés aux parents : comptant ou en plusieurs
versements (6 maxi).
Exemple :

Association nommé Soutien++ utilise un bâtiment ayant 7 classes (chacune des classes a
une capacité). 
Cela coïncide bien, puisque chaque niveau d’élève est affecté à une classe.
Elle propose 4 créneaux : samedi et dimanche de 10h00 à 12h00 et de 14h00 à 16h00.

Dans ces conditions, et lors des inscriptions, un parent va choisir un créneau disponible et
un mode de paiement.

Utilisateur

Chaque utilisateur de l'application doit pouvoir se connecter avec un compte et un mot de
passe.
Les informations gérées pour un parent sont :
1. Nom
2. Prénom
3. Adresse e-mail (aussi identifiant d’authentification)
4. Mot de passe
5. Rôle
6. Paiement : donne le montant restant à payer
Les rôles possibles sont :
 Parent : peut inscrire un enfant
 Gestionnaire : employé qui effectue certaines opérations de gestion et
d’administration de l’application.
Gestion de paiement
Le parent doit être en mesure de visualiser le montant qui lui reste à payer. Il pourra à
chaque fois faire un versement.
Chaque opération (versement) sera enregistrée dans la base de données sous la forme
d'un mouvement.
12/12/2022 Projet JEE 2
3iL I3 Projet Gestion d'enchères F.Belabdelli
L'usager pourra donc consulter la liste de ses mouvements ainsi que le montant restant à
payer.
Inscription des enfants
Chaque parent a la possibilité d’inscrire ses enfants selon leurs niveaux.
Pour chaque enfant, on gère les données suivantes :
1. Nom
2. Prénom
3. Date de naissance
4. Etablissement fréquenté
5. Niveau d’étude
6. Créneau choisi
7. Mode de paiement (chèque, espèces, versement)
Les contraintes à respecter :
- Un seul créneau par enfant.
- Si un créneau n’est plus disponible, il ne doit pas apparaitre lors des inscriptions.
Un créneau devient indisponible si la capacité de places de la classe affectée est
saturée.
Rôle du Gestionnaire
Le gestionnaire peut effectuer les opérations suivantes :
1. Créer des comptes utilisateurs, les modifier et les supprimer.
2. Afficher la liste des mouvements concernant un compte utilisateur.
Contraintes techniques :
Les technologies suivantes devront être employées :
1. JSF
2. JPA
3. EJB
4. MapStruct
5. Maven
L’application devra suivre une architecture multicouches, incluant notamment une couche
Service et une couche DAO.
Les classes représentant les données devront être distinctes selon qu’on est dans la couche
UI ou dans la couche Logique Métier. Ces 2 couches communiqueront en utilisant des
classes DTO. La correspondance entre les différentes classes sera faite en utilisant un objet
mapper basé sur MapStruct.
L’implémentation devra être faite sous la forme de plusieurs modules, notamment un
module web et un module EJB distincts
