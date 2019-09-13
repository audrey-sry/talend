/****** INITIALISATION  MOTIF_NON_CONFORMITE ******/

INSERT INTO [CFDP].[dbo].[MOTIFNONCONFORMITE] VALUES ('NOM_FICHIER', 'Le nommage du fichier ne respecte pas la nomenclature attendue.');
INSERT INTO [CFDP].[dbo].[MOTIFNONCONFORMITE] VALUES ('CODE_IA', 'Le code d’identification du distributeur présent dans le nom du fichier ne correspond pas à l’attendu.');
INSERT INTO [CFDP].[dbo].[MOTIFNONCONFORMITE] VALUES ('DOUBLON', 'Un fichier avec exactement le même nom est déjà en cours de traitement ou a déjà été intégré.');
INSERT INTO [CFDP].[dbo].[MOTIFNONCONFORMITE] VALUES ('EDI_NON_AUTORISE', 'Ce type de fichier EDI n’est pas autorisé pour votre code distributeur.');
INSERT INTO [CFDP].[dbo].[MOTIFNONCONFORMITE] VALUES ('FORMAT_FICHIER', 'Le format du fichier ne correspond pas au format autorisé.');

/****** INITIALISATION  TYPE_EDI ******/

INSERT INTO [CFDP].[dbo].[TYPEEDI] (CODE, LIBELLE_COURT, LIBELLE_LONG) VALUES ('MSG001', 'AL Stock', 'Aliments - STOCK');
INSERT INTO [CFDP].[dbo].[TYPEEDI] (CODE, LIBELLE_COURT, LIBELLE_LONG) VALUES ('MSG002', 'PI Stock', 'Polices individuelles - STOCK');
INSERT INTO [CFDP].[dbo].[TYPEEDI] (CODE, LIBELLE_COURT, LIBELLE_LONG) VALUES ('MSG003', 'AL Mvt', 'Aliments - MOUVEMENT');
INSERT INTO [CFDP].[dbo].[TYPEEDI] (CODE, LIBELLE_COURT, LIBELLE_LONG) VALUES ('MSG004', 'PI Mvt', 'Polices individuelles - MOUVEMENT');

/****** INITIALISATION  PARTENAIRE ******/

INSERT INTO [CFDP].[dbo].[PARTENAIRE] ([CODE], [REPERTOIRE_FTP], [NOM], [EST_ACTIF], [CREE_LE], [CREE_PAR]) VALUES ('PART01', 'D:\Projets\CFDP\FICHIERS SOURCE\Partenaire1', 'Partenaire 1', 1, GETDATE(), 0);
INSERT INTO [CFDP].[dbo].[PARTENAIRE] ([CODE], [REPERTOIRE_FTP], [NOM], [EST_ACTIF], [CREE_LE], [CREE_PAR]) VALUES ('PART02', 'D:\Projets\CFDP\FICHIERS SOURCE\Partenaire2', 'Partenaire 2', 1, GETDATE(), 0);
INSERT INTO [CFDP].[dbo].[PARTENAIRE] ([CODE], [REPERTOIRE_FTP], [NOM], [EST_ACTIF], [CREE_LE], [CREE_PAR]) VALUES ('PART03', 'D:\Projets\CFDP\FICHIERS SOURCE\Partenaire3', 'Partenaire 3', 1, GETDATE(), 0);
INSERT INTO [CFDP].[dbo].[PARTENAIRE] ([CODE], [REPERTOIRE_FTP], [NOM], [EST_ACTIF], [CREE_LE], [CREE_PAR]) VALUES ('PART04', 'D:\Projets\CFDP\FICHIERS SOURCE\Partenaire4', 'Partenaire 4', 1, GETDATE(), 0);

/****** INITIALISATION  TYPE_AUTORISATION ******/

INSERT INTO [CFDP].[dbo].[TYPEAUTORISATION] (TAU_CODE, DESCRIPTION) VALUES ('NA', 'Non autorisé');
INSERT INTO [CFDP].[dbo].[TYPEAUTORISATION] (TAU_CODE, DESCRIPTION) VALUES ('A', 'En cours de mise en place');
INSERT INTO [CFDP].[dbo].[TYPEAUTORISATION] (TAU_CODE, DESCRIPTION) VALUES ('P', 'Prod');

/****** INITIALISATION  AUTORISATION_EDI ******/

INSERT INTO [CFDP].[dbo].[AUTORISATIONEDI] (par_id, ted_id, tau_code, sjs_id) values (1, 1, 'P', 1);
INSERT INTO [CFDP].[dbo].[AUTORISATIONEDI] (par_id, ted_id, tau_code, sjs_id) values (1, 2, 'P', 2);
INSERT INTO [CFDP].[dbo].[AUTORISATIONEDI] (par_id, ted_id, tau_code, sjs_id) values (1, 3, 'P', 3);
INSERT INTO [CFDP].[dbo].[AUTORISATIONEDI] (par_id, ted_id, tau_code, sjs_id) values (2, 1, 'P', 4);
INSERT INTO [CFDP].[dbo].[AUTORISATIONEDI] (par_id, ted_id, tau_code, sjs_id) values (2, 2, 'P', 5);
INSERT INTO [CFDP].[dbo].[AUTORISATIONEDI] (par_id, ted_id, tau_code) values (2, 3, 'P');
INSERT INTO [CFDP].[dbo].[AUTORISATIONEDI] (par_id, ted_id, tau_code) values (3, 1, 'P');
INSERT INTO [CFDP].[dbo].[AUTORISATIONEDI] (par_id, ted_id, tau_code) values (3, 2, 'P');
INSERT INTO [CFDP].[dbo].[AUTORISATIONEDI] (par_id, ted_id, tau_code) values (3, 3, 'P');
INSERT INTO [CFDP].[dbo].[AUTORISATIONEDI] (par_id, ted_id, tau_code) values (4, 1, 'P');
INSERT INTO [CFDP].[dbo].[AUTORISATIONEDI] (par_id, ted_id, tau_code) values (4, 2, 'P');
INSERT INTO [CFDP].[dbo].[AUTORISATIONEDI] (par_id, ted_id, tau_code) values (4, 3, 'P');

/****** INITIALISATION  REF_STATUT_TRAITEMENT ******/

INSERT INTO [CFDP].[dbo].[REFSTATUTTRAITEMENT] (RST_CODE, DESCRIPTION, EST_STATUT_FINAL) values ('PEC', 'PRIS_EN_CHARGE', 0);
INSERT INTO [CFDP].[dbo].[REFSTATUTTRAITEMENT] (RST_CODE, DESCRIPTION, EST_STATUT_FINAL) values ('CN1', 'CONTROLE_NIV1', 0);
INSERT INTO [CFDP].[dbo].[REFSTATUTTRAITEMENT] (RST_CODE, DESCRIPTION, EST_STATUT_FINAL) values ('ARC', 'ARCHIVAGE', 0);
INSERT INTO [CFDP].[dbo].[REFSTATUTTRAITEMENT] (RST_CODE, DESCRIPTION, EST_STATUT_FINAL) values ('PTR', 'PRE_TRAITEMENT', 0);
INSERT INTO [CFDP].[dbo].[REFSTATUTTRAITEMENT] (RST_CODE, DESCRIPTION, EST_STATUT_FINAL) values ('CN2', 'CONTROLE_NIV2', 0);
INSERT INTO [CFDP].[dbo].[REFSTATUTTRAITEMENT] (RST_CODE, DESCRIPTION, EST_STATUT_FINAL) values ('NOV', 'TRANSMIS_NOVANET', 0);
INSERT INTO [CFDP].[dbo].[REFSTATUTTRAITEMENT] (RST_CODE, DESCRIPTION, EST_STATUT_FINAL) values ('TER', 'TERMINE_REUSSI', 1);
INSERT INTO [CFDP].[dbo].[REFSTATUTTRAITEMENT] (RST_CODE, DESCRIPTION, EST_STATUT_FINAL) values ('TEE', 'TERMINE_ECHOUE', 1);
INSERT INTO [CFDP].[dbo].[REFSTATUTTRAITEMENT] (RST_CODE, DESCRIPTION, EST_STATUT_FINAL) values ('TET', 'TERMINE_TECHNIQUE', 1);

/****** INITIALISATION  SOUS_JOB_SPECIFIQUE ******/

INSERT INTO [CFDP].[dbo].[SOUSJOBSPECIFIQUE] (NOM_TECHNIQUE, DESCRIPTION) values ('ssjob_spe_1', 'Je suis le pre traitement 1');
INSERT INTO [CFDP].[dbo].[SOUSJOBSPECIFIQUE] (NOM_TECHNIQUE, DESCRIPTION) values ('ssjob_spe_2', 'Je suis le pre traitement 2');
INSERT INTO [CFDP].[dbo].[SOUSJOBSPECIFIQUE] (NOM_TECHNIQUE, DESCRIPTION) values ('ssjob_spe_3', 'Je suis le pre traitement 3');
INSERT INTO [CFDP].[dbo].[SOUSJOBSPECIFIQUE] (NOM_TECHNIQUE, DESCRIPTION) values ('ssjob_spe_4', 'Je suis le pre traitement 4');
INSERT INTO [CFDP].[dbo].[SOUSJOBSPECIFIQUE] (NOM_TECHNIQUE, DESCRIPTION) values ('ssjob_spe_5', 'Je suis le pre traitement 5');

