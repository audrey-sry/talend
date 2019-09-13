%~d0
cd %~dp0
java -Dtalend.component.manager.m2.repository=%cd%/../lib -Xms256M -Xmx1024M -Dfile.encoding=UTF-8 -cp .;../lib/routines.jar;../lib/antlr-runtime-3.5.2.jar;../lib/dom4j-1.6.1.jar;../lib/jtds-1.3.1-patch.jar;../lib/log4j-1.2.17.jar;../lib/org.talend.dataquality.parser.jar;../lib/talend_file_enhanced_20070724.jar;test_ctln1_0_2.jar; test.test_ctln1_0_2.Test_CTLN1  %*