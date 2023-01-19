SET search_path TO projet;


-- Supprime toutes les données

DELETE FROM Role;
DELETE FROM salle;
DELETE FROM mode_paiement;
DELETE FROM utilisateur;
DELETE FROM mouvement;
DELETE FROM enfant;
DELETE FROM cours;


INSERT INTO utilisateur (idutilisateur, idenfant, identifiant, motdepasse, nom, prenom, email, paiement)VALUES 
(1, null, 'admin', 'admin', 'admin', 'admin', 'admin@3il.fr', 0),
(2, null, 'billy', '123', 'smith', 'billy', 'billy@3il.fr', 500);

INSERT INTO role (idutilisateur, role) VALUES 
( 1, 'ADMINISTRATEUR' ),
( 1, 'UTILISATEUR' ),
( 2, 'UTILISATEUR' );