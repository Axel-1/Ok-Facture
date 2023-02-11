CREATE TABLE Client
(
    code_client INT AUTO_INCREMENT,
    entreprise  VARCHAR(50),
    rue         VARCHAR(50),
    cp          VARCHAR(50),
    ville       VARCHAR(50),
    PRIMARY KEY (code_client)
);

CREATE TABLE Parametre
(
    id             INT AUTO_INCREMENT,
    nom_entreprise VARCHAR(50),
    rue            VARCHAR(50),
    cp             VARCHAR(50),
    ville          VARCHAR(50),
    tel            VARCHAR(50),
    site_web       VARCHAR(50),
    domiciliation  VARCHAR(50),
    proprio_compte VARCHAR(50),
    iban           VARCHAR(50),
    bic            VARCHAR(50),
    PRIMARY KEY (id)
);

CREATE TABLE Type_TVA
(
    code_tva INT AUTO_INCREMENT,
    libelle  VARCHAR(50),
    PRIMARY KEY (code_tva)
);

CREATE TABLE TVA
(
    id_tva     INT AUTO_INCREMENT,
    date_debut DATE,
    date_fin   DATE NOT NULL,
    valeur     DOUBLE,
    code_tva   INT NOT NULL,
    PRIMARY KEY (id_tva),
    FOREIGN KEY (code_tva) REFERENCES Type_TVA (code_tva)
);

CREATE TABLE Facture
(
    id_fac           INT AUTO_INCREMENT,
    date_facturation DATE,
    date_echeance    VARCHAR(50),
    conditions_reg   VARCHAR(50),
    code_client      INT NOT NULL,
    PRIMARY KEY (id_fac),
    FOREIGN KEY (code_client) REFERENCES Client (code_client)
);

CREATE TABLE Produit
(
    id_prod     INT AUTO_INCREMENT,
    designation VARCHAR(50),
    tarif_ht    DOUBLE,
    code_tva    INT NOT NULL,
    PRIMARY KEY (id_prod),
    FOREIGN KEY (code_tva) REFERENCES Type_TVA (code_tva)
);

CREATE TABLE Ligne_Facture
(
    id_fac          INT,
    qte             INT,
    prix_facture_ht DOUBLE,
    id_prod         INT NOT NULL,
    PRIMARY KEY (id_fac, id_prod),
    FOREIGN KEY (id_fac) REFERENCES Facture (id_fac),
    FOREIGN KEY (id_prod) REFERENCES Produit (id_prod)
);