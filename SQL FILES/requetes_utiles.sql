/******************************************************** VERIFICATION  ********************************************************/

select S.str_id, S.NOM_FICHIER, S.REPERTOIRE_FTP, H.RST_CODE, RE.DESCRIPTION, S.MNC_CODE, S.PAR_ID, S.TED_ID
from REFSTATUTTRAITEMENT AS RE, HISTORISATIONSTATUTTRAITEMENT AS H, SUIVITRAITEMENT AS S
where RE.RST_CODE = H.RST_CODE AND H.STR_ID = S.STR_ID 

/******************************************************************************************************************************/

/****** Vérification statut prod  ******/

select AE.PAR_ID, AE.TED_ID
from TYPEAUTORISATION AS TA, AUTORISATIONEDI AS AE, TYPEEDI AS TE
where TA.TAU_CODE = AE.TAU_CODE AND TE.TED_ID = AE.TED_ID AND TE.CODE = 'MSG002' AND TA.DESCRIPTION = 'Prod' AND AE.PAR_ID = 1;

/****** Insertion pour tester les doublons  ******/

insert into HISTORISATIONSTATUTTRAITEMENT (RST_CODE, str_id) values ('TEE', 7);
insert into HISTORISATIONSTATUTTRAITEMENT (RST_CODE, str_id) values ('TET', 3);
insert into HISTORISATIONSTATUTTRAITEMENT (RST_CODE, str_id) values ('PTR', 4);
insert into HISTORISATIONSTATUTTRAITEMENT (RST_CODE, str_id) values ('CN2', 5);

/****** MAJ pour tester les doublons  ******/

update HISTORISATIONSTATUTTRAITEMENT
set RST_CODE = 'PEC'
where STR_ID = 7;

/****** Vérification doublon  ******/

select S.str_id, S.NOM_FICHIER, H.RST_CODE, RE.DESCRIPTION 
from REFSTATUTTRAITEMENT AS RE, HISTORISATIONSTATUTTRAITEMENT AS H, SUIVITRAITEMENT AS S
where RE.RST_CODE = H.RST_CODE AND H.STR_ID = S.STR_ID AND RE.DESCRIPTION not in ('TERMINE_ECHOUE', 'TERMINE_TECHNIQUE') and S.NOM_FICHIER = 'MSG002.PART04.20110326.0216.csv';

/****** Nettoyage pour les tests  ******/

truncate table suivitraitement
truncate table HISTORISATIONSTATUTTRAITEMENT

/****** Autre  ******/

delete from SUIVITRAITEMENT
where NOM_FICHIER = 'MSG002.PART04.20110326.0216.csv'

insert into SUIVITRAITEMENT(cree_le) values ('2019-02-12');

insert into SUIVITRAITEMENT (NOM_FICHIER) values ('MSG002.PART04.20110326.0216.csv')