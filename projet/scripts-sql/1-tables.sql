SET search_path TO projet;


-- Schéma

DROP SCHEMA IF EXISTS projet CASCADE;
CREATE SCHEMA projet AUTHORIZATION projet;
GRANT ALL PRIVILEGES ON SCHEMA projet TO projet;


-- Tables

CREATE TABLE Role (
	idrole INT NOT NULL,
	admin BOOLEAN NOT NULL,
	niveau INT NOT NULL,
	PRIMARY KEY (idrole)
);

CREATE TABLE salle (
	idniveau INT NOT NULL,
	niveau INT NOT NULL,
	detail varchar(50) NOT NULL,
	PRIMARY KEY (idniveau)
);

CREATE TABLE mode_paiement (
	idmode_paiement INT NOT NULL,
	mode_paiement varchar(50) NOT NULL,
	PRIMARY KEY (idmode_paiement)
);

CREATE TABLE cours (
	idcours INT NOT NULL,
	niveau INT NOT NULL,
	salle INT NOT NULL,
	nbr_max_eleve INT NOT NULL,
	nbr_eleve INT,
	jour_samedi BOOLEAN NOT NULL,
	creneau_debut time NOT NULL,
	creneau_fin time NOT NULL,
	idsalle INT NOT NULL,
	idniveau INT NOT NULL,
	PRIMARY KEY (idcours),
	FOREIGN KEY (idniveau) REFERENCES salle(idniveau)
);

CREATE TABLE enfant (
	idenfant INT NOT NULL,
	niveau INT NOT NULL,
	mode_paiement varchar(50) NOT NULL,
	jour_samedi BOOLEAN NOT NULL,
	creneau time NOT NULL,
	nom varchar(50) NOT NULL,
	prenom varchar(50) NOT NULL,
	date_naissance date NOT NULL,
	etablissement varchar(50) NOT NULL,
	idmode_paiement INT NOT NULL,
	idcours INT NOT NULL,
	detail varchar(50) NOT NULL,
	PRIMARY KEY (idenfant),
	FOREIGN KEY (idmode_paiement) REFERENCES mode_paiement(idmode_paiement),
	FOREIGN KEY (idcours) REFERENCES cours(idcours)
);

CREATE TABLE utilisateur (
	idutilisateur INT NOT NULL,
	idenfant INT NOT NULL,
	role BOOLEAN NOT NULL,
	identifiant varchar(50) NOT NULL,
	motdepasse varchar(50) NOT NULL,
	nom varchar(50) NOT NULL,
	prenom varchar(50) NOT NULL,
	email varchar(50) NOT NULL,
	paiement FLOAT,
	idrole INT NOT NULL,
	PRIMARY KEY (idutilisateur),
	FOREIGN KEY (idrole) REFERENCES Role(idrole),
	FOREIGN KEY (idenfant) REFERENCES enfant(idenfant)
);

CREATE TABLE mouvement (
	idmouvement INT NOT NULL,
	montant FLOAT NOT NULL,
	dateh date NOT NULL,
	idutilisateur INT NOT NULL,
	PRIMARY KEY (idmouvement),
	FOREIGN KEY (idutilisateur) REFERENCES utilisateur(idutilisateur)
);

