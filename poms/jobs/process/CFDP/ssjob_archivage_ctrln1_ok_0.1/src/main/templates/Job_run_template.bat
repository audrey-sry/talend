%~d0
cd %~dp0
java -Dtalend.component.manager.m2.repository=%cd%/../lib -Xms256M -Xmx1024M -cp .;../lib/routines.jar;../lib/advancedPersistentLookupLib-1.2.jar;../lib/antlr-runtime-3.5.2.jar;../lib/commons-collections-3.2.2.jar;../lib/dom4j-1.6.1.jar;../lib/filecopy.jar;../lib/jboss-serialization.jar;../lib/jtds-1.3.1-patch.jar;../lib/log4j-1.2.17.jar;../lib/org.talend.dataquality.parser.jar;../lib/talend_DB_mssqlUtil-1.2-20171017.jar;../lib/talend_file_enhanced_20070724.jar;../lib/trove.jar;ssjob_archivage_ctrln1_ok_0_1.jar;ssjob_update_statut_0_1.jar; test.ssjob_archivage_ctrln1_ok_0_1.ssjob_archivage_ctrlN1_ok  %*