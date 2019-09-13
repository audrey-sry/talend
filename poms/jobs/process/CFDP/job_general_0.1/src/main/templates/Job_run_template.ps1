$fileDir = Split-Path -Parent $MyInvocation.MyCommand.Path
cd $fileDir
java '-Dtalend.component.manager.m2.repository=%cd%/../lib' '-Xms256M' '-Xmx1024M' -cp '.;../lib/routines.jar;../lib/advancedPersistentLookupLib-1.2.jar;../lib/antlr-runtime-3.5.2.jar;../lib/commons-collections-3.2.2.jar;../lib/dom4j-1.6.1.jar;../lib/filecopy.jar;../lib/jakarta-oro-2.0.8.jar;../lib/jboss-serialization.jar;../lib/jtds-1.3.1-patch.jar;../lib/jxl.jar;../lib/log4j-1.2.17.jar;../lib/org.talend.dataquality.parser.jar;../lib/talend_DB_mssqlUtil-1.2-20171017.jar;../lib/talend_file_enhanced_20070724.jar;../lib/trove.jar;job_general_0_1.jar;ssjob_controlen1_0_1.jar;ssjob_spe_5_0_1.jar;ssjob_spe_2_0_1.jar;ssjob_init_fich_statut_0_1.jar;ssjob_init_fich_bdd_0_1.jar;ssjob_ask_pre_trait_0_1.jar;ssjob_archivage_ctrln1_ok_0_1.jar;ssjob_spe_1_0_1.jar;ssjob_spe_3_0_1.jar;ssjob_update_statut_0_1.jar;ssjob_archivage_ctrln1_ko_0_1.jar;ssjob_spe_4_0_1.jar;ssjob_controlen2_0_1.jar;' test.job_general_0_1.job_general  --context=Default %*