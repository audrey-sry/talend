/******************************************************** VERIFICATION  ********************************************************/

select S.str_id, S.NOM_FICHIER, S.REPERTOIRE_FTP, H.RST_CODE, RE.DESCRIPTION, S.MNC_CODE, S.PAR_ID, S.TED_ID
from REFSTATUTTRAITEMENT AS RE, HISTORISATIONSTATUTTRAITEMENT AS H, SUIVITRAITEMENT AS S
where RE.RST_CODE = H.RST_CODE AND H.STR_ID = S.STR_ID 

/******************************************************************************************************************************/