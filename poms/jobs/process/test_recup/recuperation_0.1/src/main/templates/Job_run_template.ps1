$fileDir = Split-Path -Parent $MyInvocation.MyCommand.Path
cd $fileDir
java '-Dtalend.component.manager.m2.repository=%cd%/../lib' '-Xms256M' '-Xmx1024M' '-Dfile.encoding=UTF-8' -cp '.;../lib/routines.jar;../lib/antlr-runtime-3.5.2.jar;../lib/dom4j-1.6.1.jar;../lib/jakarta-oro-2.0.8.jar;../lib/jtds-1.3.1-patch.jar;../lib/log4j-1.2.17.jar;../lib/org.talend.dataquality.parser.jar;../lib/talend_DB_mssqlUtil-1.2-20171017.jar;../lib/talend_file_enhanced_20070724.jar;../lib/talendcsv.jar;recuperation_0_1.jar;' test.recuperation_0_1.recuperation  %*