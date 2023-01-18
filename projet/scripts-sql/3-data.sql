SET search_path TO projet;


-- Supprime toutes les données

DELETE FROM Role;
DELETE FROM salle;
DELETE FROM mode_paiement;
DELETE FROM utilisateur;
DELETE FROM mouvement;
DELETE FROM enfant;
DELETE FROM cours;


INSERT INTO utilisateur (idutilisateur, idenfant, role, identifiant, motdepasse, nom, prenom, email, paiement)
VALUES (1, null, true, 'admin', 'admin', 'admin', 'admin', 'admin@3il.fr', 0),
(2, null, false, 'billy', '123', 'smith', 'billy', 'billy@3il.fr', 500)

