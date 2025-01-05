
create database JO;

drop table if exists Matchs;
drop table if exists Athlete;
drop table if exists Pays;
drop table if exists Equipe;
drop table if exists Epreuve;
drop table if exists JeuxOlympique;
drop table if exists Sport;

drop table if exists ContenirEQ_ATH;
drop table if exists ContenirJO_SP;
drop table if exists ContenirJO_EP;
drop table if exists ContenirPAYS_EQ;
drop table if exists ContenirJO_PAYS;
drop table if exists ContenirEP_SP;

drop table if exists UTILISATEUR;


create table Sport(
    nom_sport varchar(32),
     PRIMARY KEY (nom_sport)
);

create table JeuxOlympique(
    nomJO varchar(100),
    lieu varchar(64),
    annee INT,
    PRIMARY KEY (nomJO)
);

create table Epreuve(
    id_Epreuve INT,
    nomEpreuve varchar(64),
    categorieEpreuve varchar(100),
    typeEpreuve varchar(10),
    sexEpreuve char(1),
    coefForce float(3,1),
    coefEndurance float(3,1),
    coefAgilite float(3,1),
    PRIMARY KEY (id_Epreuve)
);

create table Matchs( 
    id_Match INT,
    id_Epreuve INT,
    scoreE1 float(10,3),
    scoreE2 float(10,3),
    equipe1 INT,
    equipe2 INT,
    PRIMARY KEY (id_Match)
);

create table Pays(
    nom_pays varchar(100),
    medpays_or INT,
    medpays_argent INT,
    medpay_bronze INT,
    PRIMARY KEY (nom_pays)
);

create table Athlete(
    id_Athlete INT,
    NomAt varchar(50),
    PrenomAT varchar(50),
    SexeAT char(1),
    stats_Force INT,
    stats_Endurance INT,
    stats_agilite INT,
    PRIMARY KEY (id_Athlete)
);

create table Equipe(
    id_Equipe INT,
    taille_Equipe INT,
    medEquipe_or INT,
    medEquipe_argent INT,
    medEquipe_bronze INT,
    sexeEquipe char(1),
    PRIMARY KEY (id_Equipe)
);

create table ContenirEQ_ATH(
    id_Athlete INT,
    id_Equipe INT,
    PRIMARY KEY (id_Athlete, id_Equipe)
);

create table ContenirJO_SP(
    nomJO varchar(100),
    nom_sport varchar(32),
    PRIMARY KEY (nomJO, nom_sport)
);

create table ContenirJO_EP(
    nomJO varchar(100),
    id_Epreuve INT,
    PRIMARY KEY (nomJO, id_Epreuve)
);

create table ContenirJO_PAYS(
    nomJO varchar(100),
    nom_pays varchar(100),
    PRIMARY KEY (nomJO, nom_pays)
);


create table ContenirPAYS_EQ(
    id_Equipe varchar(100),
    nom_pays varchar(100),
    PRIMARY KEY (id_Equipe, nom_pays)
);

create table ContenirEP_SP(
    id_Epreuve INT,
    nom_sport varchar(32),
    PRIMARY KEY (id_Epreuve, nom_sport)
);





ALTER TABLE JeuxOlympique ADD FOREIGN KEY (nom_sport) REFERENCES Sport(nom_sport);
ALTER TABLE Athlete ADD FOREIGN KEY (id_Equipe) REFERENCES Equipe(id_Equipe);
ALTER TABLE Pays ADD FOREIGN KEY (nomJO) REFERENCES JeuxOlympique(nomJO);
ALTER TABLE Epreuve ADD FOREIGN KEY (nom_sport) REFERENCES Sport(nom_sport);
ALTER TABLE Matchs ADD FOREIGN KEY (id_Epreuve) REFERENCES Epreuve(id_Epreuve);
ALTER TABLE Matchs ADD FOREIGN KEY (equipe1) REFERENCES Equipe(id_Equipe);
ALTER TABLE Matchs ADD FOREIGN KEY (equipe2) REFERENCES Equipe(id_Equipe);

alter table ContenirEQ_ATH add foreign key (id_Athlete) references Athlete (id_Athlete);
alter table ContenirEQ_ATH add foreign key (id_Equipe) references Equipe (id_Equipe);
alter table ContenirJO_SP add foreign key (nomJO) references JeuxOlympique (nomJO);
alter table ContenirJO_SP add foreign key (nom_sport) references Sport (nom_sport);
alter table ContenirJO_EP add foreign key (nomJO) references JeuxOlympique (nomJO);
alter table ContenirJO_EP add foreign key (id_Epreuve) references Epreuve (id_Epreuve);
alter table ContenirJO_PAYS add foreign key (nomJO) references JeuxOlympique (nomJO);
alter table ContenirJO_PAYS add foreign key (nom_pays) references Pays (nom_pays);
alter table ContenirPAYS_EQ add foreign key (nom_pays) references Pays (nom_pays);
alter table ContenirPAYS_EQ add foreign key (id_Equipe) references Equipe (id_Equipe);
alter table ContenirEP_SP add foreign key (id_Epreuve) references Epreuve (id_Epreuve);
alter table ContenirEP_SP add foreign key (nom_sport) references Sport (nom_sport);


create TABLE UTILISATEUR(
    identifiantu varchar(20),
    motdepasse VARCHAR(20),
    role_utilidsa VARCHAR(20),
    PRIMARY KEY (identifiantu,role_utilidsa)

);

create table ACTIVATION(
    roleuse CHAR(1),
    cleact VARCHAR(20),
    PRIMARY KEY (roleuse)
);

insert into activation (roleuse, cleact) VALUES 
    ('O', "clefeur"),
    ('O', "act123"),
    ('A', "obamaBattleroyale69")
;

/*  

insert INTo Sport values ();
insert INTo JeuxOlympique values ();
insert INTo Epreuve values ();
insert INTo Matchs values ();
insert INTo Pays values ();
insert INTo Athlete values ();
insert INTo equipe values ();

*/

/*  partie administration a 50%

create role administrateur;
create role organisateur;
create role journaliste;

create user toto IDENTIFIED BY motPasse1;
create user heinz IDENTIFIED BY motPasse2;
create user ben IDENTIFIED BY motPasse3;


REVOKE ALL PRIVILEGES, GRANT OPTION FROM administrateur;
FLUSH PRIVILEGES;

REVOKE ALL PRIVILEGES, GRANT OPTION FROM organisateur;
FLUSH PRIVILEGES;

REVOKE ALL PRIVILEGES, GRANT OPTION FROM journaliste;
FLUSH PRIVILEGES;


grant all on JO.* to administrateur;
FLUSH PRIVILEGES;


GRANT SELECT, INSERT, UPDATE, DELETE ON JO.Sport TO organisateur';
FLUSH PRIVILEGES;

GRANT SELECT, INSERT, UPDATE, DELETE ON JO.Athlete TO organisateur';
FLUSH PRIVILEGES;

GRANT SELECT, INSERT, UPDATE, DELETE ON JO.Equipe TO organisateur';
FLUSH PRIVILEGES;

grant insert,update,delete on JO.Epreuve to organisateur;
FLUSH PRIVILEGES;


GRANT SELECT ON `JO`.* TO journaliste';
FLUSH PRIVILEGES;



grant administrateur to toto;
grant organisateur to heinz;
grant journaliste to ben;


show grants for toto;
show grants for heinz;
show grants for ben;

*/