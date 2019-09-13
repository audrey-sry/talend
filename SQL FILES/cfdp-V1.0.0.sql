/*==============================================================*/
/* Nom de SGBD :  Microsoft SQL Server 2012                     */
/* Date de création :  26/08/2019 16:55:12                      */
/*==============================================================*/


IF EXISTS (SELECT 1
            FROM  SYSINDEXES
           WHERE  ID    = OBJECT_ID('AUTORISATIONEDI')
            AND   NAME  = 'ASSOCIATION_5_FK'
            AND   INDID > 0
            AND   INDID < 255)
   DROP INDEX AUTORISATIONEDI.ASSOCIATION_5_FK
go

IF EXISTS (SELECT 1
            FROM  SYSINDEXES
           WHERE  ID    = OBJECT_ID('AUTORISATIONEDI')
            AND   NAME  = 'ASSOCIATION_4_FK'
            AND   INDID > 0
            AND   INDID < 255)
   DROP INDEX AUTORISATIONEDI.ASSOCIATION_4_FK
go

IF EXISTS (SELECT 1
            FROM  SYSINDEXES
           WHERE  ID    = OBJECT_ID('AUTORISATIONEDI')
            AND   NAME  = 'ASSOCIATION_3_FK'
            AND   INDID > 0
            AND   INDID < 255)
   DROP INDEX AUTORISATIONEDI.ASSOCIATION_3_FK
go

IF EXISTS (SELECT 1
            FROM  SYSINDEXES
           WHERE  ID    = OBJECT_ID('AUTORISATIONEDI')
            AND   NAME  = 'ASSOCIATION_2_FK'
            AND   INDID > 0
            AND   INDID < 255)
   DROP INDEX AUTORISATIONEDI.ASSOCIATION_2_FK
go

IF EXISTS (SELECT 1
            FROM  SYSOBJECTS
           WHERE  ID = OBJECT_ID('AUTORISATIONEDI')
            AND   TYPE = 'U')
   DROP TABLE AUTORISATIONEDI
go

IF EXISTS (SELECT 1
            FROM  SYSINDEXES
           WHERE  ID    = OBJECT_ID('EMAIL')
            AND   NAME  = 'ASSOCIATION_1_FK'
            AND   INDID > 0
            AND   INDID < 255)
   DROP INDEX EMAIL.ASSOCIATION_1_FK
go

IF EXISTS (SELECT 1
            FROM  SYSOBJECTS
           WHERE  ID = OBJECT_ID('EMAIL')
            AND   TYPE = 'U')
   DROP TABLE EMAIL
go

IF EXISTS (SELECT 1
            FROM  SYSINDEXES
           WHERE  ID    = OBJECT_ID('HISTORISATIONSTATUTTRAITEMENT')
            AND   NAME  = 'ASSOCIATION_8_FK'
            AND   INDID > 0
            AND   INDID < 255)
   DROP INDEX HISTORISATIONSTATUTTRAITEMENT.ASSOCIATION_8_FK
go

IF EXISTS (SELECT 1
            FROM  SYSINDEXES
           WHERE  ID    = OBJECT_ID('HISTORISATIONSTATUTTRAITEMENT')
            AND   NAME  = 'ASSOCIATION_7_FK'
            AND   INDID > 0
            AND   INDID < 255)
   DROP INDEX HISTORISATIONSTATUTTRAITEMENT.ASSOCIATION_7_FK
go

IF EXISTS (SELECT 1
            FROM  SYSOBJECTS
           WHERE  ID = OBJECT_ID('HISTORISATIONSTATUTTRAITEMENT')
            AND   TYPE = 'U')
   DROP TABLE HISTORISATIONSTATUTTRAITEMENT
go

IF EXISTS (SELECT 1
            FROM  SYSOBJECTS
           WHERE  ID = OBJECT_ID('MOTIFNONCONFORMITE')
            AND   TYPE = 'U')
   DROP TABLE MOTIFNONCONFORMITE
go

IF EXISTS (SELECT 1
            FROM  SYSOBJECTS
           WHERE  ID = OBJECT_ID('PARAMETRAGE')
            AND   TYPE = 'U')
   DROP TABLE PARAMETRAGE
go

IF EXISTS (SELECT 1
            FROM  SYSOBJECTS
           WHERE  ID = OBJECT_ID('PARTENAIRE')
            AND   TYPE = 'U')
   DROP TABLE PARTENAIRE
go

IF EXISTS (SELECT 1
            FROM  SYSOBJECTS
           WHERE  ID = OBJECT_ID('REFSTATUTTRAITEMENT')
            AND   TYPE = 'U')
   DROP TABLE REFSTATUTTRAITEMENT
go

IF EXISTS (SELECT 1
            FROM  SYSOBJECTS
           WHERE  ID = OBJECT_ID('SOUSJOBSPECIFIQUE')
            AND   TYPE = 'U')
   DROP TABLE SOUSJOBSPECIFIQUE
go

IF EXISTS (SELECT 1
            FROM  SYSINDEXES
           WHERE  ID    = OBJECT_ID('SUIVITRAITEMENT')
            AND   NAME  = 'ASSOCIATION_9_FK'
            AND   INDID > 0
            AND   INDID < 255)
   DROP INDEX SUIVITRAITEMENT.ASSOCIATION_9_FK
go

IF EXISTS (SELECT 1
            FROM  SYSINDEXES
           WHERE  ID    = OBJECT_ID('SUIVITRAITEMENT')
            AND   NAME  = 'ASSOCIATION_6_FK'
            AND   INDID > 0
            AND   INDID < 255)
   DROP INDEX SUIVITRAITEMENT.ASSOCIATION_6_FK
go

IF EXISTS (SELECT 1
            FROM  SYSOBJECTS
           WHERE  ID = OBJECT_ID('SUIVITRAITEMENT')
            AND   TYPE = 'U')
   DROP TABLE SUIVITRAITEMENT
go

IF EXISTS (SELECT 1
            FROM  SYSOBJECTS
           WHERE  ID = OBJECT_ID('TYPEAUTORISATION')
            AND   TYPE = 'U')
   DROP TABLE TYPEAUTORISATION
go

IF EXISTS (SELECT 1
            FROM  SYSOBJECTS
           WHERE  ID = OBJECT_ID('TYPEEDI')
            AND   TYPE = 'U')
   DROP TABLE TYPEEDI
go

IF EXISTS (SELECT 1
            FROM  SYSOBJECTS
           WHERE  ID = OBJECT_ID('UTILISATEUR')
            AND   TYPE = 'U')
   DROP TABLE UTILISATEUR
go

/*==============================================================*/
/* Table : AUTORISATIONEDI                                      */
/*==============================================================*/
CREATE TABLE AUTORISATIONEDI (
   PAR_ID               INT                  NOT NULL,
   TED_ID               INT                  NOT NULL,
   TAU_CODE             CHAR(3)              NOT NULL,
   SJS_ID               INT                  NULL,
   CONSTRAINT PK_AUTORISATIONEDI PRIMARY KEY (PAR_ID, TED_ID)
)
go

/*==============================================================*/
/* Index : ASSOCIATION_2_FK                                     */
/*==============================================================*/
CREATE INDEX ASSOCIATION_2_FK ON AUTORISATIONEDI (
PAR_ID ASC
)
go

/*==============================================================*/
/* Index : ASSOCIATION_3_FK                                     */
/*==============================================================*/
CREATE INDEX ASSOCIATION_3_FK ON AUTORISATIONEDI (
SJS_ID ASC
)
go

/*==============================================================*/
/* Index : ASSOCIATION_4_FK                                     */
/*==============================================================*/
CREATE INDEX ASSOCIATION_4_FK ON AUTORISATIONEDI (
TAU_CODE ASC
)
go

/*==============================================================*/
/* Index : ASSOCIATION_5_FK                                     */
/*==============================================================*/
CREATE INDEX ASSOCIATION_5_FK ON AUTORISATIONEDI (
TED_ID ASC
)
go

/*==============================================================*/
/* Table : EMAIL                                                */
/*==============================================================*/
CREATE TABLE EMAIL (
   EMA_ID               INT                  IDENTITY,
   PAR_ID               INT                  NOT NULL,
   EMAIL_DEST           VARCHAR(2048)        NULL,
   CREE_LE              DATETIME             NULL,
   CREE_PAR             INT                  NULL,
   CONSTRAINT PK_EMAIL PRIMARY KEY NONCLUSTERED (EMA_ID)
)
go

/*==============================================================*/
/* Index : ASSOCIATION_1_FK                                     */
/*==============================================================*/
CREATE INDEX ASSOCIATION_1_FK ON EMAIL (
PAR_ID ASC
)
go

/*==============================================================*/
/* Table : HISTORISATIONSTATUTTRAITEMENT                        */
/*==============================================================*/
CREATE TABLE HISTORISATIONSTATUTTRAITEMENT (
   HST_ID               INT                  IDENTITY,
   RST_CODE             CHAR(3)              NOT NULL,
   STR_ID               INT                  NOT NULL,
   CREE_LE              DATETIME             NULL,
   CONSTRAINT PK_HISTORISATIONSTATUTTRAITEME PRIMARY KEY NONCLUSTERED (HST_ID)
)
go

/*==============================================================*/
/* Index : ASSOCIATION_7_FK                                     */
/*==============================================================*/
CREATE INDEX ASSOCIATION_7_FK ON HISTORISATIONSTATUTTRAITEMENT (
RST_CODE ASC
)
go

/*==============================================================*/
/* Index : ASSOCIATION_8_FK                                     */
/*==============================================================*/
CREATE INDEX ASSOCIATION_8_FK ON HISTORISATIONSTATUTTRAITEMENT (
STR_ID ASC
)
go

/*==============================================================*/
/* Table : MOTIFNONCONFORMITE                                   */
/*==============================================================*/
CREATE TABLE MOTIFNONCONFORMITE (
   MNC_CODE             VARCHAR(255)         NOT NULL,
   DESCRIPTION          VARCHAR(2048)        NULL,
   CONSTRAINT PK_MOTIFNONCONFORMITE PRIMARY KEY NONCLUSTERED (MNC_CODE)
)
go

/*==============================================================*/
/* Table : PARAMETRAGE                                          */
/*==============================================================*/
CREATE TABLE PARAMETRAGE (
   PAR_CODE             VARCHAR(10)          NOT NULL,
   VALEUR               VARCHAR(255)         NULL,
   CONSTRAINT PK_PARAMETRAGE PRIMARY KEY NONCLUSTERED (PAR_CODE)
)
go

/*==============================================================*/
/* Table : PARTENAIRE                                           */
/*==============================================================*/
CREATE TABLE PARTENAIRE (
   PAR_ID               INT                  IDENTITY,
   CODE                 VARCHAR(50)          NOT NULL,
   REPERTOIRE_FTP       VARCHAR(255)         NULL,
   NOM                  VARCHAR(255)         NULL,
   EST_ACTIF            BIT                  NULL,
   CREE_LE              DATETIME             NULL,
   CREE_PAR             INT                  NULL,
   MODIFIE_LE           DATETIME             NULL,
   MODIFIER_PAR         INT                  NULL,
   CONSTRAINT PK_PARTENAIRE PRIMARY KEY NONCLUSTERED (PAR_ID)
)
go

/*==============================================================*/
/* Table : REFSTATUTTRAITEMENT                                  */
/*==============================================================*/
CREATE TABLE REFSTATUTTRAITEMENT (
   RST_CODE             CHAR(3)              NOT NULL,
   DESCRIPTION          VARCHAR(2048)        NULL,
   EST_STATUT_FINAL     BIT                  NULL,
   ORDRE                INT                  NULL,
   CONSTRAINT PK_REFSTATUTTRAITEMENT PRIMARY KEY NONCLUSTERED (RST_CODE)
)
go

/*==============================================================*/
/* Table : SOUSJOBSPECIFIQUE                                    */
/*==============================================================*/
CREATE TABLE SOUSJOBSPECIFIQUE (
   SJS_ID               INT                  IDENTITY,
   NOM_TECHNIQUE        VARCHAR(255)         NOT NULL,
   DESCRIPTION          VARCHAR(2048)        NULL,
   ORDRE                INT                  NULL,
   CONSTRAINT PK_SOUSJOBSPECIFIQUE PRIMARY KEY NONCLUSTERED (SJS_ID)
)
go

/*==============================================================*/
/* Table : SUIVITRAITEMENT                                      */
/*==============================================================*/
CREATE TABLE SUIVITRAITEMENT (
   STR_ID               INT                  IDENTITY,
   MNC_CODE             VARCHAR(255)         NULL,
   PAR_ID               INT                  NULL,
   TED_ID               INT                  NULL,
   CREE_LE              DATETIME             NULL,
   REPERTOIRE_FTP       VARCHAR(255)         NULL,
   NOM_FICHIER          VARCHAR(255)         NULL,
   TYPE_FICHIER         VARCHAR(10)          NULL,
   CHEMIN_ARCHIVAGE     VARCHAR(2048)        NULL,
   NB_LIGNES            INT                  NULL,
   ERREUR_DESCRIPTION   VARCHAR(2048)        NULL,
   CHEMIN_FICHIER_REJET VARCHAR(2048)        NULL,
   NOM_FICHIER_REJET    VARCHAR(255)         NULL,
   CONSTRAINT PK_SUIVITRAITEMENT PRIMARY KEY NONCLUSTERED (STR_ID)
)
go

/*==============================================================*/
/* Index : ASSOCIATION_6_FK                                     */
/*==============================================================*/
CREATE INDEX ASSOCIATION_6_FK ON SUIVITRAITEMENT (
PAR_ID ASC,
TED_ID ASC
)
go

/*==============================================================*/
/* Index : ASSOCIATION_9_FK                                     */
/*==============================================================*/
CREATE INDEX ASSOCIATION_9_FK ON SUIVITRAITEMENT (
MNC_CODE ASC
)
go

/*==============================================================*/
/* Table : TYPEAUTORISATION                                     */
/*==============================================================*/
CREATE TABLE TYPEAUTORISATION (
   TAU_CODE             CHAR(3)              NOT NULL,
   DESCRIPTION          VARCHAR(2048)        NULL,
   CONSTRAINT PK_TYPEAUTORISATION PRIMARY KEY NONCLUSTERED (TAU_CODE)
)
go

/*==============================================================*/
/* Table : TYPEEDI                                              */
/*==============================================================*/
CREATE TABLE TYPEEDI (
   TED_ID               INT                  IDENTITY,
   CODE                 VARCHAR(50)          NULL,
   LIBELLE_COURT        VARCHAR(255)         NULL,
   LIBELLE_LONG         VARCHAR(255)         NULL,
   "ORDER"              INT                  NULL,
   CONSTRAINT PK_TYPEEDI PRIMARY KEY NONCLUSTERED (TED_ID)
)
go

/*==============================================================*/
/* Table : UTILISATEUR                                          */
/*==============================================================*/
CREATE TABLE UTILISATEUR (
   UTI_ID               INT                  IDENTITY,
   NOM                  VARCHAR(255)         NULL,
   PRENOM               VARCHAR(255)         NULL,
   LOGIN                VARCHAR(255)         NULL,
   PASSWORD             VARCHAR(2048)        NULL,
   EST_ACTIF            BIT                  NULL,
   EMAIL                VARCHAR(255)         NULL,
   CONSTRAINT PK_UTILISATEUR PRIMARY KEY NONCLUSTERED (UTI_ID)
)
go

