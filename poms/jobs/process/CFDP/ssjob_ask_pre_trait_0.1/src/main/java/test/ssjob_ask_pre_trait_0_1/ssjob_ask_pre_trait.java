
package test.ssjob_ask_pre_trait_0_1;

import routines.DataOperation;
import routines.TalendDataGenerator;
import routines.DataQuality;
import routines.Relational;
import routines.DataQualityDependencies;
import routines.Mathematical;
import routines.SQLike;
import routines.Numeric;
import routines.TalendStringUtil;
import routines.TalendString;
import routines.DQTechnical;
import routines.StringHandling;
import routines.DataMasking;
import routines.TalendDate;
import routines.DqStringHandling;
import routines.system.*;
import routines.system.api.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.Comparator;
 





@SuppressWarnings("unused")

/**
 * Job: ssjob_ask_pre_trait Purpose: <br>
 * Description:  <br>
 * @author user@talend.com
 * @version 7.1.1.20190228_0243-patch
 * @status 
 */
public class ssjob_ask_pre_trait implements TalendJob {
	static {System.setProperty("TalendJob.log", "ssjob_ask_pre_trait.log");}
	private static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(ssjob_ask_pre_trait.class);

protected static void logIgnoredError(String message, Throwable cause) {
       log.error(message, cause);

}


	public final Object obj = new Object();

	// for transmiting parameters purpose
	private Object valueObject = null;

	public Object getValueObject() {
		return this.valueObject;
	}

	public void setValueObject(Object valueObject) {
		this.valueObject = valueObject;
	}
	
	private final static String defaultCharset = java.nio.charset.Charset.defaultCharset().name();

	
	private final static String utf8Charset = "UTF-8";
	//contains type for every context property
	public class PropertiesWithType extends java.util.Properties {
		private static final long serialVersionUID = 1L;
		private java.util.Map<String,String> propertyTypes = new java.util.HashMap<>();
		
		public PropertiesWithType(java.util.Properties properties){
			super(properties);
		}
		public PropertiesWithType(){
			super();
		}
		
		public void setContextType(String key, String type) {
			propertyTypes.put(key,type);
		}
	
		public String getContextType(String key) {
			return propertyTypes.get(key);
		}
	}
	
	// create and load default properties
	private java.util.Properties defaultProps = new java.util.Properties();
	// create application properties with default
	public class ContextProperties extends PropertiesWithType {

		private static final long serialVersionUID = 1L;

		public ContextProperties(java.util.Properties properties){
			super(properties);
		}
		public ContextProperties(){
			super();
		}

		public void synchronizeContext(){
			
			if(archivage_ko != null){
				
					this.setProperty("archivage_ko", archivage_ko.toString());
				
			}
			
			if(codeEDI != null){
				
					this.setProperty("codeEDI", codeEDI.toString());
				
			}
			
			if(codeIA != null){
				
					this.setProperty("codeIA", codeIA.toString());
				
			}
			
			if(date != null){
				
					this.setProperty("date", date.toString());
				
			}
			
			if(file_name != null){
				
					this.setProperty("file_name", file_name.toString());
				
			}
			
			if(nb_lignes != null){
				
					this.setProperty("nb_lignes", nb_lignes.toString());
				
			}
			
			if(non_conforme != null){
				
					this.setProperty("non_conforme", non_conforme.toString());
				
			}
			
			if(rep_ftp != null){
				
					this.setProperty("rep_ftp", rep_ftp.toString());
				
			}
			
			if(statut != null){
				
					this.setProperty("statut", statut.toString());
				
			}
			
			if(str_id != null){
				
					this.setProperty("str_id", str_id.toString());
				
			}
			
			if(type != null){
				
					this.setProperty("type", type.toString());
				
			}
			
			if(ssql_cfdp_AdditionalParams != null){
				
					this.setProperty("ssql_cfdp_AdditionalParams", ssql_cfdp_AdditionalParams.toString());
				
			}
			
			if(ssql_cfdp_Database != null){
				
					this.setProperty("ssql_cfdp_Database", ssql_cfdp_Database.toString());
				
			}
			
			if(ssql_cfdp_Login != null){
				
					this.setProperty("ssql_cfdp_Login", ssql_cfdp_Login.toString());
				
			}
			
			if(ssql_cfdp_Password != null){
				
					this.setProperty("ssql_cfdp_Password", ssql_cfdp_Password.toString());
				
			}
			
			if(ssql_cfdp_Port != null){
				
					this.setProperty("ssql_cfdp_Port", ssql_cfdp_Port.toString());
				
			}
			
			if(ssql_cfdp_Schema != null){
				
					this.setProperty("ssql_cfdp_Schema", ssql_cfdp_Schema.toString());
				
			}
			
			if(ssql_cfdp_Server != null){
				
					this.setProperty("ssql_cfdp_Server", ssql_cfdp_Server.toString());
				
			}
			
		}

public Integer archivage_ko;
public Integer getArchivage_ko(){
	return this.archivage_ko;
}
public String codeEDI;
public String getCodeEDI(){
	return this.codeEDI;
}
public String codeIA;
public String getCodeIA(){
	return this.codeIA;
}
public String date;
public String getDate(){
	return this.date;
}
public String file_name;
public String getFile_name(){
	return this.file_name;
}
public Integer nb_lignes;
public Integer getNb_lignes(){
	return this.nb_lignes;
}
public String non_conforme;
public String getNon_conforme(){
	return this.non_conforme;
}
public String rep_ftp;
public String getRep_ftp(){
	return this.rep_ftp;
}
public String statut;
public String getStatut(){
	return this.statut;
}
public Integer str_id;
public Integer getStr_id(){
	return this.str_id;
}
public String type;
public String getType(){
	return this.type;
}
public String ssql_cfdp_AdditionalParams;
public String getSsql_cfdp_AdditionalParams(){
	return this.ssql_cfdp_AdditionalParams;
}
public String ssql_cfdp_Database;
public String getSsql_cfdp_Database(){
	return this.ssql_cfdp_Database;
}
public String ssql_cfdp_Login;
public String getSsql_cfdp_Login(){
	return this.ssql_cfdp_Login;
}
public java.lang.String ssql_cfdp_Password;
public java.lang.String getSsql_cfdp_Password(){
	return this.ssql_cfdp_Password;
}
public String ssql_cfdp_Port;
public String getSsql_cfdp_Port(){
	return this.ssql_cfdp_Port;
}
public String ssql_cfdp_Schema;
public String getSsql_cfdp_Schema(){
	return this.ssql_cfdp_Schema;
}
public String ssql_cfdp_Server;
public String getSsql_cfdp_Server(){
	return this.ssql_cfdp_Server;
}
	}
	protected ContextProperties context = new ContextProperties(); // will be instanciated by MS.
	public ContextProperties getContext() {
		return this.context;
	}
	private final String jobVersion = "0.1";
	private final String jobName = "ssjob_ask_pre_trait";
	private final String projectName = "TEST";
	public Integer errorCode = null;
	private String currentComponent = "";
	
		private final java.util.Map<String, Object> globalMap = new java.util.HashMap<String, Object>();
        private final static java.util.Map<String, Object> junitGlobalMap = new java.util.HashMap<String, Object>();
	
		private final java.util.Map<String, Long> start_Hash = new java.util.HashMap<String, Long>();
		private final java.util.Map<String, Long> end_Hash = new java.util.HashMap<String, Long>();
		private final java.util.Map<String, Boolean> ok_Hash = new java.util.HashMap<String, Boolean>();
		public  final java.util.List<String[]> globalBuffer = new java.util.ArrayList<String[]>();
	

private RunStat runStat = new RunStat();

	// OSGi DataSource
	private final static String KEY_DB_DATASOURCES = "KEY_DB_DATASOURCES";
	
	private final static String KEY_DB_DATASOURCES_RAW = "KEY_DB_DATASOURCES_RAW";

	public void setDataSources(java.util.Map<String, javax.sql.DataSource> dataSources) {
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		for (java.util.Map.Entry<String, javax.sql.DataSource> dataSourceEntry : dataSources.entrySet()) {
			talendDataSources.put(dataSourceEntry.getKey(), new routines.system.TalendDataSource(dataSourceEntry.getValue()));
		}
		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}


private final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
private final java.io.PrintStream errorMessagePS = new java.io.PrintStream(new java.io.BufferedOutputStream(baos));

public String getExceptionStackTrace() {
	if ("failure".equals(this.getStatus())) {
		errorMessagePS.flush();
		return baos.toString();
	}
	return null;
}

private Exception exception;

public Exception getException() {
	if ("failure".equals(this.getStatus())) {
		return this.exception;
	}
	return null;
}

private class TalendException extends Exception {

	private static final long serialVersionUID = 1L;

	private java.util.Map<String, Object> globalMap = null;
	private Exception e = null;
	private String currentComponent = null;
	private String virtualComponentName = null;
	
	public void setVirtualComponentName (String virtualComponentName){
		this.virtualComponentName = virtualComponentName;
	}

	private TalendException(Exception e, String errorComponent, final java.util.Map<String, Object> globalMap) {
		this.currentComponent= errorComponent;
		this.globalMap = globalMap;
		this.e = e;
	}

	public Exception getException() {
		return this.e;
	}

	public String getCurrentComponent() {
		return this.currentComponent;
	}

	
    public String getExceptionCauseMessage(Exception e){
        Throwable cause = e;
        String message = null;
        int i = 10;
        while (null != cause && 0 < i--) {
            message = cause.getMessage();
            if (null == message) {
                cause = cause.getCause();
            } else {
                break;          
            }
        }
        if (null == message) {
            message = e.getClass().getName();
        }   
        return message;
    }

	@Override
	public void printStackTrace() {
		if (!(e instanceof TalendException || e instanceof TDieException)) {
			if(virtualComponentName!=null && currentComponent.indexOf(virtualComponentName+"_")==0){
				globalMap.put(virtualComponentName+"_ERROR_MESSAGE",getExceptionCauseMessage(e));
			}
			globalMap.put(currentComponent+"_ERROR_MESSAGE",getExceptionCauseMessage(e));
			System.err.println("Exception in component " + currentComponent + " (" + jobName + ")");
		}
		if (!(e instanceof TDieException)) {
			if(e instanceof TalendException){
				e.printStackTrace();
			} else {
				e.printStackTrace();
				e.printStackTrace(errorMessagePS);
				ssjob_ask_pre_trait.this.exception = e;
			}
		}
		if (!(e instanceof TalendException)) {
		try {
			for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
				if (m.getName().compareTo(currentComponent + "_error") == 0) {
					m.invoke(ssjob_ask_pre_trait.this, new Object[] { e , currentComponent, globalMap});
					break;
				}
			}

			if(!(e instanceof TDieException)){
			}
		} catch (Exception e) {
			this.e.printStackTrace();
		}
		}
	}
}

			public void tPrejob_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tPrejob_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBConnection_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
						try {
							
								if(this.execStat){
									runStat.updateStatOnConnection("OnComponentError1", 0, "error");
								}
							
							
								errorCode = null;
								tDie_1Process(globalMap);
								if (!"failure".equals(status)) {
									status = "end";
								}
								

						} catch (Exception e) {
							e.printStackTrace();
						}
						
					tDBConnection_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDie_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDie_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tPostjob_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tPostjob_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBClose_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBClose_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tFixedFlowInput_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFixedFlowInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMap_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFixedFlowInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tRunJob_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFixedFlowInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tRunJob_3_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFixedFlowInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tRunJob_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFixedFlowInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAdvancedHash_row2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tPrejob_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tDBConnection_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tDie_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tPostjob_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tDBClose_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tFixedFlowInput_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tDBInput_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
	




	


public void tPrejob_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tPrejob_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		


	
	/**
	 * [tPrejob_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tPrejob_1", false);
		start_Hash.put("tPrejob_1", System.currentTimeMillis());
		
	
	currentComponent="tPrejob_1";

	
		int tos_count_tPrejob_1 = 0;
		

 



/**
 * [tPrejob_1 begin ] stop
 */
	
	/**
	 * [tPrejob_1 main ] start
	 */

	

	
	
	currentComponent="tPrejob_1";

	

 


	tos_count_tPrejob_1++;

/**
 * [tPrejob_1 main ] stop
 */
	
	/**
	 * [tPrejob_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tPrejob_1";

	

 



/**
 * [tPrejob_1 process_data_begin ] stop
 */
	
	/**
	 * [tPrejob_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tPrejob_1";

	

 



/**
 * [tPrejob_1 process_data_end ] stop
 */
	
	/**
	 * [tPrejob_1 end ] start
	 */

	

	
	
	currentComponent="tPrejob_1";

	

 

ok_Hash.put("tPrejob_1", true);
end_Hash.put("tPrejob_1", System.currentTimeMillis());

				if(execStat){   
   	 				runStat.updateStatOnConnection("OnComponentOk1", 0, "ok");
				}
				tDBConnection_1Process(globalMap);



/**
 * [tPrejob_1 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				    if(!(e instanceof TalendException)){
					   log.fatal(currentComponent + " " + e.getMessage(),e);
					}
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tPrejob_1 finally ] start
	 */

	

	
	
	currentComponent="tPrejob_1";

	

 



/**
 * [tPrejob_1 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tPrejob_1_SUBPROCESS_STATE", 1);
	}
	

public void tDBConnection_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBConnection_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		


	
	/**
	 * [tDBConnection_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBConnection_1", false);
		start_Hash.put("tDBConnection_1", System.currentTimeMillis());
		
	
	currentComponent="tDBConnection_1";

	
		int tos_count_tDBConnection_1 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tDBConnection_1 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tDBConnection_1{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tDBConnection_1 = new StringBuilder();
                    log4jParamters_tDBConnection_1.append("Parameters:");
                            log4jParamters_tDBConnection_1.append("DRIVER" + " = " + "JTDS");
                        log4jParamters_tDBConnection_1.append(" | ");
                            log4jParamters_tDBConnection_1.append("HOST" + " = " + "context.ssql_cfdp_Server");
                        log4jParamters_tDBConnection_1.append(" | ");
                            log4jParamters_tDBConnection_1.append("PORT" + " = " + "context.ssql_cfdp_Port");
                        log4jParamters_tDBConnection_1.append(" | ");
                            log4jParamters_tDBConnection_1.append("SCHEMA_DB" + " = " + "context.ssql_cfdp_Schema");
                        log4jParamters_tDBConnection_1.append(" | ");
                            log4jParamters_tDBConnection_1.append("DBNAME" + " = " + "context.ssql_cfdp_Database");
                        log4jParamters_tDBConnection_1.append(" | ");
                            log4jParamters_tDBConnection_1.append("USER" + " = " + "context.ssql_cfdp_Login");
                        log4jParamters_tDBConnection_1.append(" | ");
                            log4jParamters_tDBConnection_1.append("PASS" + " = " + String.valueOf(routines.system.PasswordEncryptUtil.encryptPassword(context.ssql_cfdp_Password)).substring(0, 4) + "...");     
                        log4jParamters_tDBConnection_1.append(" | ");
                            log4jParamters_tDBConnection_1.append("PROPERTIES" + " = " + "context.ssql_cfdp_AdditionalParams");
                        log4jParamters_tDBConnection_1.append(" | ");
                            log4jParamters_tDBConnection_1.append("USE_SHARED_CONNECTION" + " = " + "false");
                        log4jParamters_tDBConnection_1.append(" | ");
                            log4jParamters_tDBConnection_1.append("SPECIFY_DATASOURCE_ALIAS" + " = " + "false");
                        log4jParamters_tDBConnection_1.append(" | ");
                            log4jParamters_tDBConnection_1.append("AUTO_COMMIT" + " = " + "true");
                        log4jParamters_tDBConnection_1.append(" | ");
                            log4jParamters_tDBConnection_1.append("SHARE_IDENTITY_SETTING" + " = " + "false");
                        log4jParamters_tDBConnection_1.append(" | ");
                            log4jParamters_tDBConnection_1.append("UNIFIED_COMPONENTS" + " = " + "tMSSqlConnection");
                        log4jParamters_tDBConnection_1.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tDBConnection_1 - "  + (log4jParamters_tDBConnection_1) );
                    } 
                } 
            new BytesLimit65535_tDBConnection_1().limitLog4jByte();
            }
	

	
			String url_tDBConnection_1 = "jdbc:jtds:sqlserver://" + context.ssql_cfdp_Server ;
		String port_tDBConnection_1 = context.ssql_cfdp_Port;
		String dbname_tDBConnection_1 = context.ssql_cfdp_Database ;
    	if (!"".equals(port_tDBConnection_1)) {
    		url_tDBConnection_1 += ":" + context.ssql_cfdp_Port;
    	}
    	if (!"".equals(dbname_tDBConnection_1)) {
    		
				url_tDBConnection_1 += "//" + context.ssql_cfdp_Database; 
    	}
		url_tDBConnection_1 += ";appName=" + projectName + ";" + context.ssql_cfdp_AdditionalParams;  
		String dbUser_tDBConnection_1 = context.ssql_cfdp_Login;
		
		
			
	final String decryptedPassword_tDBConnection_1 = context.ssql_cfdp_Password; 
			String dbPwd_tDBConnection_1 = decryptedPassword_tDBConnection_1;
		
	java.sql.Connection conn_tDBConnection_1 = null;
	
		
			String driverClass_tDBConnection_1 = "net.sourceforge.jtds.jdbc.Driver";
			java.lang.Class.forName(driverClass_tDBConnection_1);
		
	    		log.debug("tDBConnection_1 - Driver ClassName: "+driverClass_tDBConnection_1+".");
			
	    		log.debug("tDBConnection_1 - Connection attempt to '" + url_tDBConnection_1 + "' with the username '" + dbUser_tDBConnection_1 + "'.");
			
				conn_tDBConnection_1 = java.sql.DriverManager.getConnection(url_tDBConnection_1,dbUser_tDBConnection_1,dbPwd_tDBConnection_1);
	    		log.debug("tDBConnection_1 - Connection to '" + url_tDBConnection_1 + "' has succeeded.");
			

		globalMap.put("conn_tDBConnection_1", conn_tDBConnection_1);
	if (null != conn_tDBConnection_1) {
		
			log.debug("tDBConnection_1 - Connection is set auto commit to 'true'.");
			conn_tDBConnection_1.setAutoCommit(true);
	}

	globalMap.put("dbschema_tDBConnection_1", context.ssql_cfdp_Schema);

	globalMap.put("db_tDBConnection_1",  context.ssql_cfdp_Database);

	globalMap.put("conn_tDBConnection_1",conn_tDBConnection_1);
	
	globalMap.put("shareIdentitySetting_tDBConnection_1",  false);

 



/**
 * [tDBConnection_1 begin ] stop
 */
	
	/**
	 * [tDBConnection_1 main ] start
	 */

	

	
	
	currentComponent="tDBConnection_1";

	

 


	tos_count_tDBConnection_1++;

/**
 * [tDBConnection_1 main ] stop
 */
	
	/**
	 * [tDBConnection_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBConnection_1";

	

 



/**
 * [tDBConnection_1 process_data_begin ] stop
 */
	
	/**
	 * [tDBConnection_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBConnection_1";

	

 



/**
 * [tDBConnection_1 process_data_end ] stop
 */
	
	/**
	 * [tDBConnection_1 end ] start
	 */

	

	
	
	currentComponent="tDBConnection_1";

	

 
                if(log.isDebugEnabled())
            log.debug("tDBConnection_1 - "  + ("Done.") );

ok_Hash.put("tDBConnection_1", true);
end_Hash.put("tDBConnection_1", System.currentTimeMillis());




/**
 * [tDBConnection_1 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				    if(!(e instanceof TalendException)){
					   log.fatal(currentComponent + " " + e.getMessage(),e);
					}
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tDBConnection_1 finally ] start
	 */

	

	
	
	currentComponent="tDBConnection_1";

	

 



/**
 * [tDBConnection_1 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBConnection_1_SUBPROCESS_STATE", 1);
	}
	

public void tDie_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDie_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;





	
	/**
	 * [tDie_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tDie_1", false);
		start_Hash.put("tDie_1", System.currentTimeMillis());
		
	
	currentComponent="tDie_1";

	
		int tos_count_tDie_1 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tDie_1 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tDie_1{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tDie_1 = new StringBuilder();
                    log4jParamters_tDie_1.append("Parameters:");
                            log4jParamters_tDie_1.append("MESSAGE" + " = " + "\"Can not connect to DB_CFDP\"");
                        log4jParamters_tDie_1.append(" | ");
                            log4jParamters_tDie_1.append("CODE" + " = " + "4");
                        log4jParamters_tDie_1.append(" | ");
                            log4jParamters_tDie_1.append("PRIORITY" + " = " + "5");
                        log4jParamters_tDie_1.append(" | ");
                            log4jParamters_tDie_1.append("EXIT_JVM" + " = " + "false");
                        log4jParamters_tDie_1.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tDie_1 - "  + (log4jParamters_tDie_1) );
                    } 
                } 
            new BytesLimit65535_tDie_1().limitLog4jByte();
            }

 



/**
 * [tDie_1 begin ] stop
 */
	
	/**
	 * [tDie_1 main ] start
	 */

	

	
	
	currentComponent="tDie_1";

	

	try {
	globalMap.put("tDie_1_DIE_PRIORITY", 5);
	System.err.println("Can not connect to DB_CFDP");
	
		log.error("tDie_1 - The die message: "+"Can not connect to DB_CFDP");
	
	globalMap.put("tDie_1_DIE_MESSAGE", "Can not connect to DB_CFDP");
	globalMap.put("tDie_1_DIE_MESSAGES", "Can not connect to DB_CFDP");
	
	} catch (Exception | Error e_tDie_1) {
		logIgnoredError(String.format("tDie_1 - tDie failed to log message due to internal error: %s", e_tDie_1), e_tDie_1);
	}
	
	currentComponent = "tDie_1";
	status = "failure";
        errorCode = new Integer(4);
        globalMap.put("tDie_1_DIE_CODE", errorCode);        
    
	if(true){	
	    throw new TDieException();
	}

 


	tos_count_tDie_1++;

/**
 * [tDie_1 main ] stop
 */
	
	/**
	 * [tDie_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDie_1";

	

 



/**
 * [tDie_1 process_data_begin ] stop
 */
	
	/**
	 * [tDie_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tDie_1";

	

 



/**
 * [tDie_1 process_data_end ] stop
 */
	
	/**
	 * [tDie_1 end ] start
	 */

	

	
	
	currentComponent="tDie_1";

	

 
                if(log.isDebugEnabled())
            log.debug("tDie_1 - "  + ("Done.") );

ok_Hash.put("tDie_1", true);
end_Hash.put("tDie_1", System.currentTimeMillis());




/**
 * [tDie_1 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				    if(!(e instanceof TalendException)){
					   log.fatal(currentComponent + " " + e.getMessage(),e);
					}
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tDie_1 finally ] start
	 */

	

	
	
	currentComponent="tDie_1";

	

 



/**
 * [tDie_1 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDie_1_SUBPROCESS_STATE", 1);
	}
	

public void tPostjob_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tPostjob_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		


	
	/**
	 * [tPostjob_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tPostjob_1", false);
		start_Hash.put("tPostjob_1", System.currentTimeMillis());
		
	
	currentComponent="tPostjob_1";

	
		int tos_count_tPostjob_1 = 0;
		

 



/**
 * [tPostjob_1 begin ] stop
 */
	
	/**
	 * [tPostjob_1 main ] start
	 */

	

	
	
	currentComponent="tPostjob_1";

	

 


	tos_count_tPostjob_1++;

/**
 * [tPostjob_1 main ] stop
 */
	
	/**
	 * [tPostjob_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tPostjob_1";

	

 



/**
 * [tPostjob_1 process_data_begin ] stop
 */
	
	/**
	 * [tPostjob_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tPostjob_1";

	

 



/**
 * [tPostjob_1 process_data_end ] stop
 */
	
	/**
	 * [tPostjob_1 end ] start
	 */

	

	
	
	currentComponent="tPostjob_1";

	

 

ok_Hash.put("tPostjob_1", true);
end_Hash.put("tPostjob_1", System.currentTimeMillis());

				if(execStat){   
   	 				runStat.updateStatOnConnection("OnComponentOk2", 0, "ok");
				}
				tDBClose_1Process(globalMap);



/**
 * [tPostjob_1 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				    if(!(e instanceof TalendException)){
					   log.fatal(currentComponent + " " + e.getMessage(),e);
					}
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tPostjob_1 finally ] start
	 */

	

	
	
	currentComponent="tPostjob_1";

	

 



/**
 * [tPostjob_1 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tPostjob_1_SUBPROCESS_STATE", 1);
	}
	

public void tDBClose_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBClose_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;





	
	/**
	 * [tDBClose_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBClose_1", false);
		start_Hash.put("tDBClose_1", System.currentTimeMillis());
		
	
	currentComponent="tDBClose_1";

	
		int tos_count_tDBClose_1 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tDBClose_1 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tDBClose_1{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tDBClose_1 = new StringBuilder();
                    log4jParamters_tDBClose_1.append("Parameters:");
                            log4jParamters_tDBClose_1.append("CONNECTION" + " = " + "tDBConnection_1");
                        log4jParamters_tDBClose_1.append(" | ");
                            log4jParamters_tDBClose_1.append("UNIFIED_COMPONENTS" + " = " + "tMSSqlClose");
                        log4jParamters_tDBClose_1.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tDBClose_1 - "  + (log4jParamters_tDBClose_1) );
                    } 
                } 
            new BytesLimit65535_tDBClose_1().limitLog4jByte();
            }

 



/**
 * [tDBClose_1 begin ] stop
 */
	
	/**
	 * [tDBClose_1 main ] start
	 */

	

	
	
	currentComponent="tDBClose_1";

	



	java.sql.Connection conn_tDBClose_1 = (java.sql.Connection)globalMap.get("conn_tDBConnection_1");
	if(conn_tDBClose_1 != null && !conn_tDBClose_1.isClosed())
	{
                if(log.isDebugEnabled())
            log.debug("tDBClose_1 - "  + ("Closing the connection ")  + ("conn_tDBConnection_1")  + (" to the database.") );
        conn_tDBClose_1.close();
                if(log.isDebugEnabled())
            log.debug("tDBClose_1 - "  + ("Connection ")  + ("conn_tDBConnection_1")  + (" to the database has closed.") );
	}

 


	tos_count_tDBClose_1++;

/**
 * [tDBClose_1 main ] stop
 */
	
	/**
	 * [tDBClose_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBClose_1";

	

 



/**
 * [tDBClose_1 process_data_begin ] stop
 */
	
	/**
	 * [tDBClose_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBClose_1";

	

 



/**
 * [tDBClose_1 process_data_end ] stop
 */
	
	/**
	 * [tDBClose_1 end ] start
	 */

	

	
	
	currentComponent="tDBClose_1";

	

 
                if(log.isDebugEnabled())
            log.debug("tDBClose_1 - "  + ("Done.") );

ok_Hash.put("tDBClose_1", true);
end_Hash.put("tDBClose_1", System.currentTimeMillis());




/**
 * [tDBClose_1 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				    if(!(e instanceof TalendException)){
					   log.fatal(currentComponent + " " + e.getMessage(),e);
					}
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tDBClose_1 finally ] start
	 */

	

	
	
	currentComponent="tDBClose_1";

	

 



/**
 * [tDBClose_1 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBClose_1_SUBPROCESS_STATE", 1);
	}
	


public static class row3Struct implements routines.system.IPersistableRow<row3Struct> {
    final static byte[] commonByteArrayLock_TEST_ssjob_ask_pre_trait = new byte[0];
    static byte[] commonByteArray_TEST_ssjob_ask_pre_trait = new byte[0];

	
			    public Integer job_spe;

				public Integer getJob_spe () {
					return this.job_spe;
				}
				
			    public String nom_ssjob;

				public String getNom_ssjob () {
					return this.nom_ssjob;
				}
				
			    public String code_ia;

				public String getCode_ia () {
					return this.code_ia;
				}
				
			    public String code_edi;

				public String getCode_edi () {
					return this.code_edi;
				}
				


	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}

	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_TEST_ssjob_ask_pre_trait.length) {
				if(length < 1024 && commonByteArray_TEST_ssjob_ask_pre_trait.length == 0) {
   					commonByteArray_TEST_ssjob_ask_pre_trait = new byte[1024];
				} else {
   					commonByteArray_TEST_ssjob_ask_pre_trait = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_TEST_ssjob_ask_pre_trait, 0, length);
			strReturn = new String(commonByteArray_TEST_ssjob_ask_pre_trait, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_TEST_ssjob_ask_pre_trait) {

        	try {

        		int length = 0;
		
						this.job_spe = readInteger(dis);
					
					this.nom_ssjob = readString(dis);
					
					this.code_ia = readString(dis);
					
					this.code_edi = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// Integer
				
						writeInteger(this.job_spe,dos);
					
					// String
				
						writeString(this.nom_ssjob,dos);
					
					// String
				
						writeString(this.code_ia,dos);
					
					// String
				
						writeString(this.code_edi,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("job_spe="+String.valueOf(job_spe));
		sb.append(",nom_ssjob="+nom_ssjob);
		sb.append(",code_ia="+code_ia);
		sb.append(",code_edi="+code_edi);
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				if(job_spe == null){
        					sb.append("<null>");
        				}else{
            				sb.append(job_spe);
            			}
            		
        			sb.append("|");
        		
        				if(nom_ssjob == null){
        					sb.append("<null>");
        				}else{
            				sb.append(nom_ssjob);
            			}
            		
        			sb.append("|");
        		
        				if(code_ia == null){
        					sb.append("<null>");
        				}else{
            				sb.append(code_ia);
            			}
            		
        			sb.append("|");
        		
        				if(code_edi == null){
        					sb.append("<null>");
        				}else{
            				sb.append(code_edi);
            			}
            		
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(row3Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class okStruct implements routines.system.IPersistableRow<okStruct> {
    final static byte[] commonByteArrayLock_TEST_ssjob_ask_pre_trait = new byte[0];
    static byte[] commonByteArray_TEST_ssjob_ask_pre_trait = new byte[0];

	
			    public Integer job_spe;

				public Integer getJob_spe () {
					return this.job_spe;
				}
				
			    public String nom_ssjob;

				public String getNom_ssjob () {
					return this.nom_ssjob;
				}
				
			    public String code_ia;

				public String getCode_ia () {
					return this.code_ia;
				}
				
			    public String code_edi;

				public String getCode_edi () {
					return this.code_edi;
				}
				


	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}

	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_TEST_ssjob_ask_pre_trait.length) {
				if(length < 1024 && commonByteArray_TEST_ssjob_ask_pre_trait.length == 0) {
   					commonByteArray_TEST_ssjob_ask_pre_trait = new byte[1024];
				} else {
   					commonByteArray_TEST_ssjob_ask_pre_trait = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_TEST_ssjob_ask_pre_trait, 0, length);
			strReturn = new String(commonByteArray_TEST_ssjob_ask_pre_trait, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_TEST_ssjob_ask_pre_trait) {

        	try {

        		int length = 0;
		
						this.job_spe = readInteger(dis);
					
					this.nom_ssjob = readString(dis);
					
					this.code_ia = readString(dis);
					
					this.code_edi = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// Integer
				
						writeInteger(this.job_spe,dos);
					
					// String
				
						writeString(this.nom_ssjob,dos);
					
					// String
				
						writeString(this.code_ia,dos);
					
					// String
				
						writeString(this.code_edi,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("job_spe="+String.valueOf(job_spe));
		sb.append(",nom_ssjob="+nom_ssjob);
		sb.append(",code_ia="+code_ia);
		sb.append(",code_edi="+code_edi);
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				if(job_spe == null){
        					sb.append("<null>");
        				}else{
            				sb.append(job_spe);
            			}
            		
        			sb.append("|");
        		
        				if(nom_ssjob == null){
        					sb.append("<null>");
        				}else{
            				sb.append(nom_ssjob);
            			}
            		
        			sb.append("|");
        		
        				if(code_ia == null){
        					sb.append("<null>");
        				}else{
            				sb.append(code_ia);
            			}
            		
        			sb.append("|");
        		
        				if(code_edi == null){
        					sb.append("<null>");
        				}else{
            				sb.append(code_edi);
            			}
            		
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(okStruct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class koStruct implements routines.system.IPersistableRow<koStruct> {
    final static byte[] commonByteArrayLock_TEST_ssjob_ask_pre_trait = new byte[0];
    static byte[] commonByteArray_TEST_ssjob_ask_pre_trait = new byte[0];

	
			    public String code_ia;

				public String getCode_ia () {
					return this.code_ia;
				}
				
			    public String code_edi;

				public String getCode_edi () {
					return this.code_edi;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_TEST_ssjob_ask_pre_trait.length) {
				if(length < 1024 && commonByteArray_TEST_ssjob_ask_pre_trait.length == 0) {
   					commonByteArray_TEST_ssjob_ask_pre_trait = new byte[1024];
				} else {
   					commonByteArray_TEST_ssjob_ask_pre_trait = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_TEST_ssjob_ask_pre_trait, 0, length);
			strReturn = new String(commonByteArray_TEST_ssjob_ask_pre_trait, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_TEST_ssjob_ask_pre_trait) {

        	try {

        		int length = 0;
		
					this.code_ia = readString(dis);
					
					this.code_edi = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.code_ia,dos);
					
					// String
				
						writeString(this.code_edi,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("code_ia="+code_ia);
		sb.append(",code_edi="+code_edi);
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				if(code_ia == null){
        					sb.append("<null>");
        				}else{
            				sb.append(code_ia);
            			}
            		
        			sb.append("|");
        		
        				if(code_edi == null){
        					sb.append("<null>");
        				}else{
            				sb.append(code_edi);
            			}
            		
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(koStruct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class row1Struct implements routines.system.IPersistableRow<row1Struct> {
    final static byte[] commonByteArrayLock_TEST_ssjob_ask_pre_trait = new byte[0];
    static byte[] commonByteArray_TEST_ssjob_ask_pre_trait = new byte[0];

	
			    public String code_ia;

				public String getCode_ia () {
					return this.code_ia;
				}
				
			    public String code_edi;

				public String getCode_edi () {
					return this.code_edi;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_TEST_ssjob_ask_pre_trait.length) {
				if(length < 1024 && commonByteArray_TEST_ssjob_ask_pre_trait.length == 0) {
   					commonByteArray_TEST_ssjob_ask_pre_trait = new byte[1024];
				} else {
   					commonByteArray_TEST_ssjob_ask_pre_trait = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_TEST_ssjob_ask_pre_trait, 0, length);
			strReturn = new String(commonByteArray_TEST_ssjob_ask_pre_trait, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_TEST_ssjob_ask_pre_trait) {

        	try {

        		int length = 0;
		
					this.code_ia = readString(dis);
					
					this.code_edi = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.code_ia,dos);
					
					// String
				
						writeString(this.code_edi,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("code_ia="+code_ia);
		sb.append(",code_edi="+code_edi);
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				if(code_ia == null){
        					sb.append("<null>");
        				}else{
            				sb.append(code_ia);
            			}
            		
        			sb.append("|");
        		
        				if(code_edi == null){
        					sb.append("<null>");
        				}else{
            				sb.append(code_edi);
            			}
            		
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(row1Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class after_tFixedFlowInput_1Struct implements routines.system.IPersistableRow<after_tFixedFlowInput_1Struct> {
    final static byte[] commonByteArrayLock_TEST_ssjob_ask_pre_trait = new byte[0];
    static byte[] commonByteArray_TEST_ssjob_ask_pre_trait = new byte[0];

	
			    public String code_ia;

				public String getCode_ia () {
					return this.code_ia;
				}
				
			    public String code_edi;

				public String getCode_edi () {
					return this.code_edi;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_TEST_ssjob_ask_pre_trait.length) {
				if(length < 1024 && commonByteArray_TEST_ssjob_ask_pre_trait.length == 0) {
   					commonByteArray_TEST_ssjob_ask_pre_trait = new byte[1024];
				} else {
   					commonByteArray_TEST_ssjob_ask_pre_trait = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_TEST_ssjob_ask_pre_trait, 0, length);
			strReturn = new String(commonByteArray_TEST_ssjob_ask_pre_trait, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_TEST_ssjob_ask_pre_trait) {

        	try {

        		int length = 0;
		
					this.code_ia = readString(dis);
					
					this.code_edi = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.code_ia,dos);
					
					// String
				
						writeString(this.code_edi,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("code_ia="+code_ia);
		sb.append(",code_edi="+code_edi);
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				if(code_ia == null){
        					sb.append("<null>");
        				}else{
            				sb.append(code_ia);
            			}
            		
        			sb.append("|");
        		
        				if(code_edi == null){
        					sb.append("<null>");
        				}else{
            				sb.append(code_edi);
            			}
            		
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(after_tFixedFlowInput_1Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void tFixedFlowInput_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tFixedFlowInput_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;


		tDBInput_1Process(globalMap);

		row1Struct row1 = new row1Struct();
okStruct ok = new okStruct();
row3Struct row3 = new row3Struct();
koStruct ko = new koStruct();






	
	/**
	 * [tRunJob_3 begin ] start
	 */

	

	
		
		ok_Hash.put("tRunJob_3", false);
		start_Hash.put("tRunJob_3", System.currentTimeMillis());
		
	
	currentComponent="tRunJob_3";

	
			if (execStat) {
				if(resourceMap.get("inIterateVComp") == null){
					
						runStat.updateStatOnConnection("row3" + iterateId, 0, 0);
					
				}
			} 

		
		int tos_count_tRunJob_3 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tRunJob_3 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tRunJob_3{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tRunJob_3 = new StringBuilder();
                    log4jParamters_tRunJob_3.append("Parameters:");
                            log4jParamters_tRunJob_3.append("USE_DYNAMIC_JOB" + " = " + "false");
                        log4jParamters_tRunJob_3.append(" | ");
                            log4jParamters_tRunJob_3.append("PROCESS" + " = " + "ssjob_controleN2");
                        log4jParamters_tRunJob_3.append(" | ");
                            log4jParamters_tRunJob_3.append("USE_INDEPENDENT_PROCESS" + " = " + "false");
                        log4jParamters_tRunJob_3.append(" | ");
                            log4jParamters_tRunJob_3.append("DIE_ON_CHILD_ERROR" + " = " + "false");
                        log4jParamters_tRunJob_3.append(" | ");
                            log4jParamters_tRunJob_3.append("TRANSMIT_WHOLE_CONTEXT" + " = " + "true");
                        log4jParamters_tRunJob_3.append(" | ");
                            log4jParamters_tRunJob_3.append("CONTEXTPARAMS" + " = " + "[]");
                        log4jParamters_tRunJob_3.append(" | ");
                            log4jParamters_tRunJob_3.append("PROPAGATE_CHILD_RESULT" + " = " + "false");
                        log4jParamters_tRunJob_3.append(" | ");
                            log4jParamters_tRunJob_3.append("PRINT_PARAMETER" + " = " + "false");
                        log4jParamters_tRunJob_3.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tRunJob_3 - "  + (log4jParamters_tRunJob_3) );
                    } 
                } 
            new BytesLimit65535_tRunJob_3().limitLog4jByte();
            }


 



/**
 * [tRunJob_3 begin ] stop
 */



	
	/**
	 * [tRunJob_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tRunJob_1", false);
		start_Hash.put("tRunJob_1", System.currentTimeMillis());
		
	
	currentComponent="tRunJob_1";

	
			if (execStat) {
				if(resourceMap.get("inIterateVComp") == null){
					
						runStat.updateStatOnConnection("ok" + iterateId, 0, 0);
					
				}
			} 

		
		int tos_count_tRunJob_1 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tRunJob_1 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tRunJob_1{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tRunJob_1 = new StringBuilder();
                    log4jParamters_tRunJob_1.append("Parameters:");
                            log4jParamters_tRunJob_1.append("USE_DYNAMIC_JOB" + " = " + "true");
                        log4jParamters_tRunJob_1.append(" | ");
                            log4jParamters_tRunJob_1.append("CONTEXT_JOB" + " = " + "ok.nom_ssjob");
                        log4jParamters_tRunJob_1.append(" | ");
                            log4jParamters_tRunJob_1.append("PROCESS" + " = " + "ssjob_spe_1;ssjob_spe_2;ssjob_spe_3;ssjob_spe_4;ssjob_spe_5");
                        log4jParamters_tRunJob_1.append(" | ");
                            log4jParamters_tRunJob_1.append("CONTEXT_NAME" + " = " + "Default");
                        log4jParamters_tRunJob_1.append(" | ");
                            log4jParamters_tRunJob_1.append("DIE_ON_CHILD_ERROR" + " = " + "false");
                        log4jParamters_tRunJob_1.append(" | ");
                            log4jParamters_tRunJob_1.append("TRANSMIT_WHOLE_CONTEXT" + " = " + "true");
                        log4jParamters_tRunJob_1.append(" | ");
                            log4jParamters_tRunJob_1.append("CONTEXTPARAMS" + " = " + "[]");
                        log4jParamters_tRunJob_1.append(" | ");
                            log4jParamters_tRunJob_1.append("PRINT_PARAMETER" + " = " + "false");
                        log4jParamters_tRunJob_1.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tRunJob_1 - "  + (log4jParamters_tRunJob_1) );
                    } 
                } 
            new BytesLimit65535_tRunJob_1().limitLog4jByte();
            }
class DealChildJobLibrary_tRunJob_1 {

	public String replaceJarPathsFromCrcMap(String originalClassPathLine) throws java.lang.Exception {
		String classPathLine = "";
		String crcMapPath = new java.io.File("../crcMap").getCanonicalPath();
		if (isNeedAddLibsPath( crcMapPath)) {
			java.util.Map<String, String> crcMap = null;
			java.io.ObjectInputStream ois = new ObjectInputStream(new java.io.FileInputStream(crcMapPath));
			crcMap = (java.util.Map<String, String>) ois.readObject();
			ois.close();
			classPathLine = addLibsPath(originalClassPathLine, crcMap);
		} else {
			classPathLine = originalClassPathLine;
		}
		return classPathLine;
	}
	
	private boolean isNeedAddLibsPath(String crcMapPath) {
		if (!(new java.io.File(crcMapPath).exists())) {// when not use cache
			return false;
		}
		return true;
	}
	
	
	private String addLibsPath(String line, java.util.Map<String, String> crcMap) {
		for (java.util.Map.Entry<String, String> entry : crcMap.entrySet()) {
			line = adaptLibPaths(line, entry);
		}
		return line;
	}
	
	private String adaptLibPaths(String line, java.util.Map.Entry<String, String> entry) {
		String jarName = entry.getValue();
		String crc = entry.getKey();
		String libStringFinder = "../lib/" + jarName;
		if (line.contains(libStringFinder)) {
			line = line.replace(libStringFinder, "../../../cache/lib/" + crc + "/" + jarName);
		} else if (line.contains(":$ROOT_PATH/" + jarName + ":")) {
			line = line.replace(":$ROOT_PATH/" + jarName + ":", ":$ROOT_PATH/../../../cache/lib/" + crc + "/" + jarName + ":");
		} else if (line.contains(";" + jarName + ";")) {
			line = line.replace(";" + jarName + ";", ";../../../cache/lib/" + crc + "/" + jarName + ";");
		}
		return line;
	}
	
}
	DealChildJobLibrary_tRunJob_1 dealChildJobLibrary_tRunJob_1 = new DealChildJobLibrary_tRunJob_1();

		//For different jobs, job name must be different, but classpath and JVM arguments are possbilely different
		java.util.Map<String,List<String>> childJob_commandLine_Mapper_tRunJob_1 = new java.util.HashMap<String,List<String>>();
		java.util.List<String> childJob_commandLine_tRunJob_1 = null;
		String classpathSeparator_tRunJob_1 = System.getProperty("path.separator");
		
				childJob_commandLine_tRunJob_1 = new java.util.ArrayList<String>();
				
				    childJob_commandLine_tRunJob_1.add("java");
				    
				    		childJob_commandLine_tRunJob_1.add("-Xms256M".replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		childJob_commandLine_tRunJob_1.add("-Xmx1024M".replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		childJob_commandLine_tRunJob_1.add("-cp".replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		childJob_commandLine_tRunJob_1.add(dealChildJobLibrary_tRunJob_1.replaceJarPathsFromCrcMap(".;../lib/routines.jar;../lib/antlr-runtime-3.5.2.jar;../lib/dom4j-1.6.1.jar;../lib/log4j-1.2.17.jar;../lib/org.talend.dataquality.parser.jar;../lib/talend_file_enhanced_20070724.jar;ssjob_spe_1_0_1.jar;").replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		childJob_commandLine_tRunJob_1.add("test.ssjob_spe_1_0_1.ssjob_spe_1".replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		childJob_commandLine_tRunJob_1.add("--father_pid="+pid.replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		childJob_commandLine_tRunJob_1.add("--root_pid="+rootPid.replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		childJob_commandLine_tRunJob_1.add("--father_node=tRunJob_1".replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		childJob_commandLine_tRunJob_1.add("--log4jLevel="+ log4jLevel.replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		childJob_commandLine_tRunJob_1.add("--context=Default".replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		childJob_commandLine_tRunJob_1.add("%*".replaceAll(";",classpathSeparator_tRunJob_1));
				    
				childJob_commandLine_Mapper_tRunJob_1.put("ssjob_spe_1",childJob_commandLine_tRunJob_1);	
			
				childJob_commandLine_tRunJob_1 = new java.util.ArrayList<String>();
				
				    childJob_commandLine_tRunJob_1.add("java");
				    
				    		childJob_commandLine_tRunJob_1.add("-Xms256M".replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		childJob_commandLine_tRunJob_1.add("-Xmx1024M".replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		childJob_commandLine_tRunJob_1.add("-cp".replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		childJob_commandLine_tRunJob_1.add(dealChildJobLibrary_tRunJob_1.replaceJarPathsFromCrcMap(".;../lib/routines.jar;../lib/antlr-runtime-3.5.2.jar;../lib/dom4j-1.6.1.jar;../lib/log4j-1.2.17.jar;../lib/org.talend.dataquality.parser.jar;../lib/talend_file_enhanced_20070724.jar;ssjob_spe_2_0_1.jar;").replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		childJob_commandLine_tRunJob_1.add("test.ssjob_spe_2_0_1.ssjob_spe_2".replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		childJob_commandLine_tRunJob_1.add("--father_pid="+pid.replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		childJob_commandLine_tRunJob_1.add("--root_pid="+rootPid.replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		childJob_commandLine_tRunJob_1.add("--father_node=tRunJob_1".replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		childJob_commandLine_tRunJob_1.add("--log4jLevel="+ log4jLevel.replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		childJob_commandLine_tRunJob_1.add("--context=Default".replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		childJob_commandLine_tRunJob_1.add("%*".replaceAll(";",classpathSeparator_tRunJob_1));
				    
				childJob_commandLine_Mapper_tRunJob_1.put("ssjob_spe_2",childJob_commandLine_tRunJob_1);	
			
				childJob_commandLine_tRunJob_1 = new java.util.ArrayList<String>();
				
				    childJob_commandLine_tRunJob_1.add("java");
				    
				    		childJob_commandLine_tRunJob_1.add("-Xms256M".replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		childJob_commandLine_tRunJob_1.add("-Xmx1024M".replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		childJob_commandLine_tRunJob_1.add("-cp".replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		childJob_commandLine_tRunJob_1.add(dealChildJobLibrary_tRunJob_1.replaceJarPathsFromCrcMap(".;../lib/routines.jar;../lib/antlr-runtime-3.5.2.jar;../lib/dom4j-1.6.1.jar;../lib/log4j-1.2.17.jar;../lib/org.talend.dataquality.parser.jar;../lib/talend_file_enhanced_20070724.jar;ssjob_spe_3_0_1.jar;").replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		childJob_commandLine_tRunJob_1.add("test.ssjob_spe_3_0_1.ssjob_spe_3".replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		childJob_commandLine_tRunJob_1.add("--father_pid="+pid.replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		childJob_commandLine_tRunJob_1.add("--root_pid="+rootPid.replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		childJob_commandLine_tRunJob_1.add("--father_node=tRunJob_1".replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		childJob_commandLine_tRunJob_1.add("--log4jLevel="+ log4jLevel.replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		childJob_commandLine_tRunJob_1.add("--context=Default".replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		childJob_commandLine_tRunJob_1.add("%*".replaceAll(";",classpathSeparator_tRunJob_1));
				    
				childJob_commandLine_Mapper_tRunJob_1.put("ssjob_spe_3",childJob_commandLine_tRunJob_1);	
			
				childJob_commandLine_tRunJob_1 = new java.util.ArrayList<String>();
				
				    childJob_commandLine_tRunJob_1.add("java");
				    
				    		childJob_commandLine_tRunJob_1.add("-Xms256M".replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		childJob_commandLine_tRunJob_1.add("-Xmx1024M".replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		childJob_commandLine_tRunJob_1.add("-cp".replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		childJob_commandLine_tRunJob_1.add(dealChildJobLibrary_tRunJob_1.replaceJarPathsFromCrcMap(".;../lib/routines.jar;../lib/antlr-runtime-3.5.2.jar;../lib/dom4j-1.6.1.jar;../lib/log4j-1.2.17.jar;../lib/org.talend.dataquality.parser.jar;../lib/talend_file_enhanced_20070724.jar;ssjob_spe_4_0_1.jar;").replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		childJob_commandLine_tRunJob_1.add("test.ssjob_spe_4_0_1.ssjob_spe_4".replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		childJob_commandLine_tRunJob_1.add("--father_pid="+pid.replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		childJob_commandLine_tRunJob_1.add("--root_pid="+rootPid.replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		childJob_commandLine_tRunJob_1.add("--father_node=tRunJob_1".replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		childJob_commandLine_tRunJob_1.add("--log4jLevel="+ log4jLevel.replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		childJob_commandLine_tRunJob_1.add("--context=Default".replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		childJob_commandLine_tRunJob_1.add("%*".replaceAll(";",classpathSeparator_tRunJob_1));
				    
				childJob_commandLine_Mapper_tRunJob_1.put("ssjob_spe_4",childJob_commandLine_tRunJob_1);	
			
				childJob_commandLine_tRunJob_1 = new java.util.ArrayList<String>();
				
				    childJob_commandLine_tRunJob_1.add("java");
				    
				    		childJob_commandLine_tRunJob_1.add("-Xms256M".replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		childJob_commandLine_tRunJob_1.add("-Xmx1024M".replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		childJob_commandLine_tRunJob_1.add("-cp".replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		childJob_commandLine_tRunJob_1.add(dealChildJobLibrary_tRunJob_1.replaceJarPathsFromCrcMap(".;../lib/routines.jar;../lib/antlr-runtime-3.5.2.jar;../lib/dom4j-1.6.1.jar;../lib/log4j-1.2.17.jar;../lib/org.talend.dataquality.parser.jar;../lib/talend_file_enhanced_20070724.jar;ssjob_spe_5_0_1.jar;").replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		childJob_commandLine_tRunJob_1.add("test.ssjob_spe_5_0_1.ssjob_spe_5".replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		childJob_commandLine_tRunJob_1.add("--father_pid="+pid.replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		childJob_commandLine_tRunJob_1.add("--root_pid="+rootPid.replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		childJob_commandLine_tRunJob_1.add("--father_node=tRunJob_1".replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		childJob_commandLine_tRunJob_1.add("--log4jLevel="+ log4jLevel.replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		childJob_commandLine_tRunJob_1.add("--context=Default".replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		childJob_commandLine_tRunJob_1.add("%*".replaceAll(";",classpathSeparator_tRunJob_1));
				    
				childJob_commandLine_Mapper_tRunJob_1.put("ssjob_spe_5",childJob_commandLine_tRunJob_1);	
			

 



/**
 * [tRunJob_1 begin ] stop
 */




	
	/**
	 * [tRunJob_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tRunJob_2", false);
		start_Hash.put("tRunJob_2", System.currentTimeMillis());
		
	
	currentComponent="tRunJob_2";

	
			if (execStat) {
				if(resourceMap.get("inIterateVComp") == null){
					
						runStat.updateStatOnConnection("ko" + iterateId, 0, 0);
					
				}
			} 

		
		int tos_count_tRunJob_2 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tRunJob_2 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tRunJob_2{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tRunJob_2 = new StringBuilder();
                    log4jParamters_tRunJob_2.append("Parameters:");
                            log4jParamters_tRunJob_2.append("USE_DYNAMIC_JOB" + " = " + "false");
                        log4jParamters_tRunJob_2.append(" | ");
                            log4jParamters_tRunJob_2.append("PROCESS" + " = " + "ssjob_controleN2");
                        log4jParamters_tRunJob_2.append(" | ");
                            log4jParamters_tRunJob_2.append("USE_INDEPENDENT_PROCESS" + " = " + "false");
                        log4jParamters_tRunJob_2.append(" | ");
                            log4jParamters_tRunJob_2.append("DIE_ON_CHILD_ERROR" + " = " + "false");
                        log4jParamters_tRunJob_2.append(" | ");
                            log4jParamters_tRunJob_2.append("TRANSMIT_WHOLE_CONTEXT" + " = " + "true");
                        log4jParamters_tRunJob_2.append(" | ");
                            log4jParamters_tRunJob_2.append("CONTEXTPARAMS" + " = " + "[]");
                        log4jParamters_tRunJob_2.append(" | ");
                            log4jParamters_tRunJob_2.append("PROPAGATE_CHILD_RESULT" + " = " + "false");
                        log4jParamters_tRunJob_2.append(" | ");
                            log4jParamters_tRunJob_2.append("PRINT_PARAMETER" + " = " + "false");
                        log4jParamters_tRunJob_2.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tRunJob_2 - "  + (log4jParamters_tRunJob_2) );
                    } 
                } 
            new BytesLimit65535_tRunJob_2().limitLog4jByte();
            }


 



/**
 * [tRunJob_2 begin ] stop
 */



	
	/**
	 * [tMap_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tMap_2", false);
		start_Hash.put("tMap_2", System.currentTimeMillis());
		
	
	currentComponent="tMap_2";

	
			if (execStat) {
				if(resourceMap.get("inIterateVComp") == null){
					
						runStat.updateStatOnConnection("row1" + iterateId, 0, 0);
					
				}
			} 

		
		int tos_count_tMap_2 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tMap_2 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tMap_2{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tMap_2 = new StringBuilder();
                    log4jParamters_tMap_2.append("Parameters:");
                            log4jParamters_tMap_2.append("LINK_STYLE" + " = " + "AUTO");
                        log4jParamters_tMap_2.append(" | ");
                            log4jParamters_tMap_2.append("TEMPORARY_DATA_DIRECTORY" + " = " + "");
                        log4jParamters_tMap_2.append(" | ");
                            log4jParamters_tMap_2.append("ROWS_BUFFER_SIZE" + " = " + "2000000");
                        log4jParamters_tMap_2.append(" | ");
                            log4jParamters_tMap_2.append("CHANGE_HASH_AND_EQUALS_FOR_BIGDECIMAL" + " = " + "true");
                        log4jParamters_tMap_2.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tMap_2 - "  + (log4jParamters_tMap_2) );
                    } 
                } 
            new BytesLimit65535_tMap_2().limitLog4jByte();
            }




// ###############################
// # Lookup's keys initialization
		int count_row1_tMap_2 = 0;
		
		int count_row2_tMap_2 = 0;
		
	
		org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct> tHash_Lookup_row2 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct>) 
				((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct>) 
					globalMap.get( "tHash_Lookup_row2" ))
					;					
					
	

row2Struct row2HashKey = new row2Struct();
row2Struct row2Default = new row2Struct();
// ###############################        

// ###############################
// # Vars initialization
class  Var__tMap_2__Struct  {
}
Var__tMap_2__Struct Var__tMap_2 = new Var__tMap_2__Struct();
// ###############################

// ###############################
// # Outputs initialization
				int count_ok_tMap_2 = 0;
				
okStruct ok_tmp = new okStruct();
				int count_ko_tMap_2 = 0;
				
koStruct ko_tmp = new koStruct();
// ###############################

        
        



        









 



/**
 * [tMap_2 begin ] stop
 */



	
	/**
	 * [tFixedFlowInput_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tFixedFlowInput_1", false);
		start_Hash.put("tFixedFlowInput_1", System.currentTimeMillis());
		
	
	currentComponent="tFixedFlowInput_1";

	
		int tos_count_tFixedFlowInput_1 = 0;
		

	    for (int i_tFixedFlowInput_1 = 0 ; i_tFixedFlowInput_1 < 1 ; i_tFixedFlowInput_1++) {
	                	            	
    	            		row1.code_ia = context.codeIA;
    	            	        	            	
    	            		row1.code_edi = context.codeEDI;
    	            	
 



/**
 * [tFixedFlowInput_1 begin ] stop
 */
	
	/**
	 * [tFixedFlowInput_1 main ] start
	 */

	

	
	
	currentComponent="tFixedFlowInput_1";

	

 


	tos_count_tFixedFlowInput_1++;

/**
 * [tFixedFlowInput_1 main ] stop
 */
	
	/**
	 * [tFixedFlowInput_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tFixedFlowInput_1";

	

 



/**
 * [tFixedFlowInput_1 process_data_begin ] stop
 */

	
	/**
	 * [tMap_2 main ] start
	 */

	

	
	
	currentComponent="tMap_2";

	

			//row1
			//row1


			
				if(execStat){
					runStat.updateStatOnConnection("row1"+iterateId,1, 1);
				} 
			

		
    			if(log.isTraceEnabled()){
    				log.trace("row1 - " + (row1==null? "": row1.toLogString()));
    			}
    		

		
		
		boolean hasCasePrimitiveKeyWithNull_tMap_2 = false;
		
        // ###############################
        // # Input tables (lookups)
		  boolean rejectedInnerJoin_tMap_2 = false;
		  boolean mainRowRejected_tMap_2 = false;
            				    								  
		

				///////////////////////////////////////////////
				// Starting Lookup Table "row2" 
				///////////////////////////////////////////////


				
				
                            
 					    boolean forceLooprow2 = false;
       		  	    	
       		  	    	
 							row2Struct row2ObjectFromLookup = null;
                          
		           		  	if(!rejectedInnerJoin_tMap_2) { // G_TM_M_020

								
								hasCasePrimitiveKeyWithNull_tMap_2 = false;
								
                        		    		row2HashKey.code_ia = row1.code_ia ;
                        		    		
                        		    		row2HashKey.code_edi = row1.code_edi ;
                        		    		

								
		                        	row2HashKey.hashCodeDirty = true;
                        		
	  					
	  							
			  					
			  					
	  					
		  							tHash_Lookup_row2.lookup( row2HashKey );

	  							

	  							

 								
								  
								  if(!tHash_Lookup_row2.hasNext()) { // G_TM_M_090

  								
		  				
	  								
			  							rejectedInnerJoin_tMap_2 = true;
	  								
						
									
	
		  								forceLooprow2 = true;
	  					
  									
  									  		
 								
								  
								  } // G_TM_M_090

  								



							} // G_TM_M_020
			           		  	  
							
								
								else { // G 20 - G 21
   									forceLooprow2 = true;
			           		  	} // G 21
                    		  	
                    		

							row2Struct row2 = null;
                    		  	 
							

								while ((tHash_Lookup_row2 != null && tHash_Lookup_row2.hasNext()) || forceLooprow2) { // G_TM_M_043

								
									 // CALL close loop of lookup 'row2'
									
                    		  	 
							   
                    		  	 
	       		  	    	row2Struct fromLookup_row2 = null;
							row2 = row2Default;
										 
							
								
								if(!forceLooprow2) { // G 46
								
							
								 
							
								
								fromLookup_row2 = tHash_Lookup_row2.next();

							

							if(fromLookup_row2 != null) {
								row2 = fromLookup_row2;
							}
							
							
							
			  							
								
	                    		  	
		                    
	                    	
	                    		} // G 46
	                    		  	
								forceLooprow2 = false;
									 	
							
	            	
	            	
	            // ###############################
        { // start of Var scope
        
	        // ###############################
        	// # Vars tables
        
Var__tMap_2__Struct Var = Var__tMap_2;// ###############################
        // ###############################
        // # Output tables

ok = null;
ko = null;

if(!rejectedInnerJoin_tMap_2 ) {

// # Output table : 'ok'
count_ok_tMap_2++;

ok_tmp.job_spe = row2.ssjob_spe ;
ok_tmp.nom_ssjob = row2.nom_ssjob ;
ok_tmp.code_ia = row1.code_ia ;
ok_tmp.code_edi = row1.code_edi ;
ok = ok_tmp;
log.debug("tMap_2 - Outputting the record " + count_ok_tMap_2 + " of the output table 'ok'.");

} // closing inner join bracket (1)
// ###### START REJECTS ##### 

// # Output reject table : 'ko'
// # Filter conditions 
if( rejectedInnerJoin_tMap_2 ) {
count_ko_tMap_2++;

ko_tmp.code_ia = row1.code_ia ;
ko_tmp.code_edi = row1.code_edi ;
ko = ko_tmp;
log.debug("tMap_2 - Outputting the record " + count_ko_tMap_2 + " of the output table 'ko'.");

} // closing filter/reject
// ###############################

} // end of Var scope

rejectedInnerJoin_tMap_2 = false;










 


	tos_count_tMap_2++;

/**
 * [tMap_2 main ] stop
 */
	
	/**
	 * [tMap_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMap_2";

	

 



/**
 * [tMap_2 process_data_begin ] stop
 */
// Start of branch "ok"
if(ok != null) { 



	
	/**
	 * [tRunJob_1 main ] start
	 */

	

	
	
	currentComponent="tRunJob_1";

	

			//ok
			//ok


			
				if(execStat){
					runStat.updateStatOnConnection("ok"+iterateId,1, 1);
				} 
			

		
    			if(log.isTraceEnabled()){
    				log.trace("ok - " + (ok==null? "": ok.toLogString()));
    			}
    		
	java.util.List<String> paraList_tRunJob_1 = new java.util.ArrayList<String>();
	
								row3.job_spe = ok.job_spe;
							
								row3.nom_ssjob = ok.nom_ssjob;
							
								row3.code_ia = ok.code_ia;
							
								row3.code_edi = ok.code_edi;
							
		if(childJob_commandLine_Mapper_tRunJob_1.get(ok.nom_ssjob)==null){
			throw new RuntimeException("The child job named "+ok.nom_ssjob+" is not in the job list.");
		}
		paraList_tRunJob_1.addAll(childJob_commandLine_Mapper_tRunJob_1.get(ok.nom_ssjob));
	
	//for feature:10589
	
		paraList_tRunJob_1.add("--stat_port=" + null);
	

	if(resuming_logs_dir_path != null){
		paraList_tRunJob_1.add("--resuming_logs_dir_path=" + resuming_logs_dir_path);
	}
	String childResumePath_tRunJob_1 = ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path);
	String tRunJobName_tRunJob_1 = ResumeUtil.getRighttRunJob(resuming_checkpoint_path);
	if("tRunJob_1".equals(tRunJobName_tRunJob_1) && childResumePath_tRunJob_1 != null){
		paraList_tRunJob_1.add("--resuming_checkpoint_path=" + ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path));
	}
	paraList_tRunJob_1.add("--parent_part_launcher=JOB:" + jobName + "/NODE:tRunJob_1");
	
	java.util.Map<String, Object> parentContextMap_tRunJob_1 = new java.util.HashMap<String, Object>();

	
		
		context.synchronizeContext();
		
			parentContextMap_tRunJob_1.put("archivage_ko", context.archivage_ko);
			paraList_tRunJob_1.add("--context_type " + "archivage_ko" + "=" + "id_Integer");
		
			parentContextMap_tRunJob_1.put("codeEDI", context.codeEDI);
			paraList_tRunJob_1.add("--context_type " + "codeEDI" + "=" + "id_String");
		
			parentContextMap_tRunJob_1.put("codeIA", context.codeIA);
			paraList_tRunJob_1.add("--context_type " + "codeIA" + "=" + "id_String");
		
			parentContextMap_tRunJob_1.put("date", context.date);
			paraList_tRunJob_1.add("--context_type " + "date" + "=" + "id_String");
		
			parentContextMap_tRunJob_1.put("file_name", context.file_name);
			paraList_tRunJob_1.add("--context_type " + "file_name" + "=" + "id_String");
		
			parentContextMap_tRunJob_1.put("nb_lignes", context.nb_lignes);
			paraList_tRunJob_1.add("--context_type " + "nb_lignes" + "=" + "id_Integer");
		
			parentContextMap_tRunJob_1.put("non_conforme", context.non_conforme);
			paraList_tRunJob_1.add("--context_type " + "non_conforme" + "=" + "id_String");
		
			parentContextMap_tRunJob_1.put("rep_ftp", context.rep_ftp);
			paraList_tRunJob_1.add("--context_type " + "rep_ftp" + "=" + "id_String");
		
			parentContextMap_tRunJob_1.put("statut", context.statut);
			paraList_tRunJob_1.add("--context_type " + "statut" + "=" + "id_String");
		
			parentContextMap_tRunJob_1.put("str_id", context.str_id);
			paraList_tRunJob_1.add("--context_type " + "str_id" + "=" + "id_Integer");
		
			parentContextMap_tRunJob_1.put("type", context.type);
			paraList_tRunJob_1.add("--context_type " + "type" + "=" + "id_String");
		
			parentContextMap_tRunJob_1.put("ssql_cfdp_AdditionalParams", context.ssql_cfdp_AdditionalParams);
			paraList_tRunJob_1.add("--context_type " + "ssql_cfdp_AdditionalParams" + "=" + "id_String");
		
			parentContextMap_tRunJob_1.put("ssql_cfdp_Database", context.ssql_cfdp_Database);
			paraList_tRunJob_1.add("--context_type " + "ssql_cfdp_Database" + "=" + "id_String");
		
			parentContextMap_tRunJob_1.put("ssql_cfdp_Login", context.ssql_cfdp_Login);
			paraList_tRunJob_1.add("--context_type " + "ssql_cfdp_Login" + "=" + "id_String");
		
			parentContextMap_tRunJob_1.put("ssql_cfdp_Password", context.ssql_cfdp_Password);
			paraList_tRunJob_1.add("--context_type " + "ssql_cfdp_Password" + "=" + "id_Password");
		
			parentContextMap_tRunJob_1.put("ssql_cfdp_Port", context.ssql_cfdp_Port);
			paraList_tRunJob_1.add("--context_type " + "ssql_cfdp_Port" + "=" + "id_String");
		
			parentContextMap_tRunJob_1.put("ssql_cfdp_Schema", context.ssql_cfdp_Schema);
			paraList_tRunJob_1.add("--context_type " + "ssql_cfdp_Schema" + "=" + "id_String");
		
			parentContextMap_tRunJob_1.put("ssql_cfdp_Server", context.ssql_cfdp_Server);
			paraList_tRunJob_1.add("--context_type " + "ssql_cfdp_Server" + "=" + "id_String");
		 
		java.util.Enumeration<?> propertyNames_tRunJob_1 = context.propertyNames();
		while (propertyNames_tRunJob_1.hasMoreElements()) {
			String key_tRunJob_1 = (String) propertyNames_tRunJob_1.nextElement();
			Object value_tRunJob_1 = (Object) context.get(key_tRunJob_1);
			if(value_tRunJob_1!=null) {  
				paraList_tRunJob_1.add("--context_param " + key_tRunJob_1 + "=" + value_tRunJob_1);
			} else {
				paraList_tRunJob_1.add("--context_param " + key_tRunJob_1 + "=" + NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY);
			}
			
		}
		

	Object obj_tRunJob_1 = null;

	
	
		Runtime runtime_tRunJob_1 = Runtime.getRuntime();
		final Process ps_tRunJob_1;
		ps_tRunJob_1 = runtime_tRunJob_1.exec((String[])paraList_tRunJob_1.toArray(new String[paraList_tRunJob_1.size()]));

		Thread normal_tRunJob_1 = new Thread() {
			public void run() {
				try {
					java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(ps_tRunJob_1.getInputStream()));
					String line = "";
					try {
						while((line = reader.readLine()) != null) {
						System.out.println(line);
						}
					} finally {
					reader.close();
					}
				} catch(java.io.IOException ioe) {
					
						log.error("tRunJob_1 - " + ioe.getMessage());
					
					ioe.printStackTrace();
				}
	    	}
  		};
		
			log.info("tRunJob_1 - The child job '"+ok.nom_ssjob+"' starts on the version '' with the context ''.");
		
		normal_tRunJob_1.start();
		
			log.info("tRunJob_1 - The child job '"+ok.nom_ssjob+"' is done.");
		

		final StringBuffer errorMsg_tRunJob_1 = new StringBuffer();
		Thread error_tRunJob_1 = new Thread() {
			public void run() {
				try {
					java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(ps_tRunJob_1.getErrorStream()));
					String line = "";
        			try {
          				while((line = reader.readLine()) != null) {
            				errorMsg_tRunJob_1.append(line).append("\n");
          				}
        			} finally {
          				reader.close();
        			}
      			} catch(java.io.IOException ioe) {
					
						log.error("tRunJob_1 - " + ioe.getMessage());
					
			        ioe.printStackTrace();
      			}
    		}
		};
		error_tRunJob_1.start();

		//0 indicates normal termination	
		int result_tRunJob_1 = ps_tRunJob_1.waitFor();
		normal_tRunJob_1.join(10000);
		error_tRunJob_1.join(10000);
  
		globalMap.put("tRunJob_1_CHILD_RETURN_CODE",result_tRunJob_1);
		if(result_tRunJob_1 != 0){
   			globalMap.put("tRunJob_1_CHILD_EXCEPTION_STACKTRACE",errorMsg_tRunJob_1.toString());
			
				
					log.error("tRunJob_1 - Child job returns " + result_tRunJob_1 + ". It doesn't terminate normally.\n" + errorMsg_tRunJob_1.toString());
				
				System.err.println("Child job returns " + result_tRunJob_1 + ". It doesn't terminate normally.\n" + errorMsg_tRunJob_1.toString());
			
  		}

		

 


	tos_count_tRunJob_1++;

/**
 * [tRunJob_1 main ] stop
 */
	
	/**
	 * [tRunJob_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tRunJob_1";

	

 



/**
 * [tRunJob_1 process_data_begin ] stop
 */

	
	/**
	 * [tRunJob_3 main ] start
	 */

	

	
	
	currentComponent="tRunJob_3";

	

			//row3
			//row3


			
				if(execStat){
					runStat.updateStatOnConnection("row3"+iterateId,1, 1);
				} 
			

		
    			if(log.isTraceEnabled()){
    				log.trace("row3 - " + (row3==null? "": row3.toLogString()));
    			}
    		
	java.util.List<String> paraList_tRunJob_3 = new java.util.ArrayList<String>();
	
	        			paraList_tRunJob_3.add("--father_pid="+pid);
	      			
	        			paraList_tRunJob_3.add("--root_pid="+rootPid);
	      			
	        			paraList_tRunJob_3.add("--father_node=tRunJob_3");
	      			
	        			paraList_tRunJob_3.add("--context=Default");
	      			
			if(!"".equals(log4jLevel)){
				paraList_tRunJob_3.add("--log4jLevel="+log4jLevel);
			}
		
	//for feature:10589
	
		paraList_tRunJob_3.add("--stat_port=" + portStats);
	

	if(resuming_logs_dir_path != null){
		paraList_tRunJob_3.add("--resuming_logs_dir_path=" + resuming_logs_dir_path);
	}
	String childResumePath_tRunJob_3 = ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path);
	String tRunJobName_tRunJob_3 = ResumeUtil.getRighttRunJob(resuming_checkpoint_path);
	if("tRunJob_3".equals(tRunJobName_tRunJob_3) && childResumePath_tRunJob_3 != null){
		paraList_tRunJob_3.add("--resuming_checkpoint_path=" + ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path));
	}
	paraList_tRunJob_3.add("--parent_part_launcher=JOB:" + jobName + "/NODE:tRunJob_3");
	
	java.util.Map<String, Object> parentContextMap_tRunJob_3 = new java.util.HashMap<String, Object>();

	
		
		context.synchronizeContext();
		
			parentContextMap_tRunJob_3.put("archivage_ko", context.archivage_ko);
			paraList_tRunJob_3.add("--context_type " + "archivage_ko" + "=" + "id_Integer");
		
			parentContextMap_tRunJob_3.put("codeEDI", context.codeEDI);
			paraList_tRunJob_3.add("--context_type " + "codeEDI" + "=" + "id_String");
		
			parentContextMap_tRunJob_3.put("codeIA", context.codeIA);
			paraList_tRunJob_3.add("--context_type " + "codeIA" + "=" + "id_String");
		
			parentContextMap_tRunJob_3.put("date", context.date);
			paraList_tRunJob_3.add("--context_type " + "date" + "=" + "id_String");
		
			parentContextMap_tRunJob_3.put("file_name", context.file_name);
			paraList_tRunJob_3.add("--context_type " + "file_name" + "=" + "id_String");
		
			parentContextMap_tRunJob_3.put("nb_lignes", context.nb_lignes);
			paraList_tRunJob_3.add("--context_type " + "nb_lignes" + "=" + "id_Integer");
		
			parentContextMap_tRunJob_3.put("non_conforme", context.non_conforme);
			paraList_tRunJob_3.add("--context_type " + "non_conforme" + "=" + "id_String");
		
			parentContextMap_tRunJob_3.put("rep_ftp", context.rep_ftp);
			paraList_tRunJob_3.add("--context_type " + "rep_ftp" + "=" + "id_String");
		
			parentContextMap_tRunJob_3.put("statut", context.statut);
			paraList_tRunJob_3.add("--context_type " + "statut" + "=" + "id_String");
		
			parentContextMap_tRunJob_3.put("str_id", context.str_id);
			paraList_tRunJob_3.add("--context_type " + "str_id" + "=" + "id_Integer");
		
			parentContextMap_tRunJob_3.put("type", context.type);
			paraList_tRunJob_3.add("--context_type " + "type" + "=" + "id_String");
		
			parentContextMap_tRunJob_3.put("ssql_cfdp_AdditionalParams", context.ssql_cfdp_AdditionalParams);
			paraList_tRunJob_3.add("--context_type " + "ssql_cfdp_AdditionalParams" + "=" + "id_String");
		
			parentContextMap_tRunJob_3.put("ssql_cfdp_Database", context.ssql_cfdp_Database);
			paraList_tRunJob_3.add("--context_type " + "ssql_cfdp_Database" + "=" + "id_String");
		
			parentContextMap_tRunJob_3.put("ssql_cfdp_Login", context.ssql_cfdp_Login);
			paraList_tRunJob_3.add("--context_type " + "ssql_cfdp_Login" + "=" + "id_String");
		
			parentContextMap_tRunJob_3.put("ssql_cfdp_Password", context.ssql_cfdp_Password);
			paraList_tRunJob_3.add("--context_type " + "ssql_cfdp_Password" + "=" + "id_Password");
		
			parentContextMap_tRunJob_3.put("ssql_cfdp_Port", context.ssql_cfdp_Port);
			paraList_tRunJob_3.add("--context_type " + "ssql_cfdp_Port" + "=" + "id_String");
		
			parentContextMap_tRunJob_3.put("ssql_cfdp_Schema", context.ssql_cfdp_Schema);
			paraList_tRunJob_3.add("--context_type " + "ssql_cfdp_Schema" + "=" + "id_String");
		
			parentContextMap_tRunJob_3.put("ssql_cfdp_Server", context.ssql_cfdp_Server);
			paraList_tRunJob_3.add("--context_type " + "ssql_cfdp_Server" + "=" + "id_String");
		 
		java.util.Enumeration<?> propertyNames_tRunJob_3 = context.propertyNames();
		while (propertyNames_tRunJob_3.hasMoreElements()) {
			String key_tRunJob_3 = (String) propertyNames_tRunJob_3.nextElement();
			Object value_tRunJob_3 = (Object) context.get(key_tRunJob_3);
			if(value_tRunJob_3!=null) {  
				paraList_tRunJob_3.add("--context_param " + key_tRunJob_3 + "=" + value_tRunJob_3);
			} else {
				paraList_tRunJob_3.add("--context_param " + key_tRunJob_3 + "=" + NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY);
			}
			
		}
		

	Object obj_tRunJob_3 = null;

	
	
		test.ssjob_controlen2_0_1.ssjob_controleN2 childJob_tRunJob_3 = new test.ssjob_controlen2_0_1.ssjob_controleN2();
	    // pass DataSources
	    java.util.Map<String, routines.system.TalendDataSource> talendDataSources_tRunJob_3 = (java.util.Map<String, routines.system.TalendDataSource>) globalMap
	            .get(KEY_DB_DATASOURCES);
	    if (null != talendDataSources_tRunJob_3) {
	        java.util.Map<String, javax.sql.DataSource> dataSources_tRunJob_3 = new java.util.HashMap<String, javax.sql.DataSource>();
	        for (java.util.Map.Entry<String, routines.system.TalendDataSource> talendDataSourceEntry_tRunJob_3 : talendDataSources_tRunJob_3
			        .entrySet()) {
	            dataSources_tRunJob_3.put(talendDataSourceEntry_tRunJob_3.getKey(),
	                    talendDataSourceEntry_tRunJob_3.getValue().getRawDataSource());
	        }
	        childJob_tRunJob_3.setDataSources(dataSources_tRunJob_3);
	    }
		  
			childJob_tRunJob_3.parentContextMap = parentContextMap_tRunJob_3;
		  
		
			log.info("tRunJob_3 - The child job 'test.ssjob_controlen2_0_1.ssjob_controleN2' starts on the version '0.1' with the context 'Default'.");
		
		String[][] childReturn_tRunJob_3 = childJob_tRunJob_3.runJob((String[]) paraList_tRunJob_3.toArray(new String[paraList_tRunJob_3.size()]));
		
			log.info("tRunJob_3 - The child job 'test.ssjob_controlen2_0_1.ssjob_controleN2' is done.");
		
	  	
				errorCode = childJob_tRunJob_3.getErrorCode();
		    
	            
	    	if(childJob_tRunJob_3.getErrorCode() == null){
				globalMap.put("tRunJob_3_CHILD_RETURN_CODE", childJob_tRunJob_3.getStatus() != null && ("failure").equals(childJob_tRunJob_3.getStatus()) ? 1 : 0);
	    	}else{
				globalMap.put("tRunJob_3_CHILD_RETURN_CODE", childJob_tRunJob_3.getErrorCode());
		    }
		    if (childJob_tRunJob_3.getExceptionStackTrace() != null) { 
		    	globalMap.put("tRunJob_3_CHILD_EXCEPTION_STACKTRACE", childJob_tRunJob_3.getExceptionStackTrace());
		    }
	  
			
	  	

 


	tos_count_tRunJob_3++;

/**
 * [tRunJob_3 main ] stop
 */
	
	/**
	 * [tRunJob_3 process_data_begin ] start
	 */

	

	
	
	currentComponent="tRunJob_3";

	

 



/**
 * [tRunJob_3 process_data_begin ] stop
 */
	
	/**
	 * [tRunJob_3 process_data_end ] start
	 */

	

	
	
	currentComponent="tRunJob_3";

	

 



/**
 * [tRunJob_3 process_data_end ] stop
 */



	
	/**
	 * [tRunJob_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tRunJob_1";

	

 



/**
 * [tRunJob_1 process_data_end ] stop
 */

} // End of branch "ok"




// Start of branch "ko"
if(ko != null) { 



	
	/**
	 * [tRunJob_2 main ] start
	 */

	

	
	
	currentComponent="tRunJob_2";

	

			//ko
			//ko


			
				if(execStat){
					runStat.updateStatOnConnection("ko"+iterateId,1, 1);
				} 
			

		
    			if(log.isTraceEnabled()){
    				log.trace("ko - " + (ko==null? "": ko.toLogString()));
    			}
    		
	java.util.List<String> paraList_tRunJob_2 = new java.util.ArrayList<String>();
	
	        			paraList_tRunJob_2.add("--father_pid="+pid);
	      			
	        			paraList_tRunJob_2.add("--root_pid="+rootPid);
	      			
	        			paraList_tRunJob_2.add("--father_node=tRunJob_2");
	      			
	        			paraList_tRunJob_2.add("--context=Default");
	      			
			if(!"".equals(log4jLevel)){
				paraList_tRunJob_2.add("--log4jLevel="+log4jLevel);
			}
		
	//for feature:10589
	
		paraList_tRunJob_2.add("--stat_port=" + portStats);
	

	if(resuming_logs_dir_path != null){
		paraList_tRunJob_2.add("--resuming_logs_dir_path=" + resuming_logs_dir_path);
	}
	String childResumePath_tRunJob_2 = ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path);
	String tRunJobName_tRunJob_2 = ResumeUtil.getRighttRunJob(resuming_checkpoint_path);
	if("tRunJob_2".equals(tRunJobName_tRunJob_2) && childResumePath_tRunJob_2 != null){
		paraList_tRunJob_2.add("--resuming_checkpoint_path=" + ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path));
	}
	paraList_tRunJob_2.add("--parent_part_launcher=JOB:" + jobName + "/NODE:tRunJob_2");
	
	java.util.Map<String, Object> parentContextMap_tRunJob_2 = new java.util.HashMap<String, Object>();

	
		
		context.synchronizeContext();
		
			parentContextMap_tRunJob_2.put("archivage_ko", context.archivage_ko);
			paraList_tRunJob_2.add("--context_type " + "archivage_ko" + "=" + "id_Integer");
		
			parentContextMap_tRunJob_2.put("codeEDI", context.codeEDI);
			paraList_tRunJob_2.add("--context_type " + "codeEDI" + "=" + "id_String");
		
			parentContextMap_tRunJob_2.put("codeIA", context.codeIA);
			paraList_tRunJob_2.add("--context_type " + "codeIA" + "=" + "id_String");
		
			parentContextMap_tRunJob_2.put("date", context.date);
			paraList_tRunJob_2.add("--context_type " + "date" + "=" + "id_String");
		
			parentContextMap_tRunJob_2.put("file_name", context.file_name);
			paraList_tRunJob_2.add("--context_type " + "file_name" + "=" + "id_String");
		
			parentContextMap_tRunJob_2.put("nb_lignes", context.nb_lignes);
			paraList_tRunJob_2.add("--context_type " + "nb_lignes" + "=" + "id_Integer");
		
			parentContextMap_tRunJob_2.put("non_conforme", context.non_conforme);
			paraList_tRunJob_2.add("--context_type " + "non_conforme" + "=" + "id_String");
		
			parentContextMap_tRunJob_2.put("rep_ftp", context.rep_ftp);
			paraList_tRunJob_2.add("--context_type " + "rep_ftp" + "=" + "id_String");
		
			parentContextMap_tRunJob_2.put("statut", context.statut);
			paraList_tRunJob_2.add("--context_type " + "statut" + "=" + "id_String");
		
			parentContextMap_tRunJob_2.put("str_id", context.str_id);
			paraList_tRunJob_2.add("--context_type " + "str_id" + "=" + "id_Integer");
		
			parentContextMap_tRunJob_2.put("type", context.type);
			paraList_tRunJob_2.add("--context_type " + "type" + "=" + "id_String");
		
			parentContextMap_tRunJob_2.put("ssql_cfdp_AdditionalParams", context.ssql_cfdp_AdditionalParams);
			paraList_tRunJob_2.add("--context_type " + "ssql_cfdp_AdditionalParams" + "=" + "id_String");
		
			parentContextMap_tRunJob_2.put("ssql_cfdp_Database", context.ssql_cfdp_Database);
			paraList_tRunJob_2.add("--context_type " + "ssql_cfdp_Database" + "=" + "id_String");
		
			parentContextMap_tRunJob_2.put("ssql_cfdp_Login", context.ssql_cfdp_Login);
			paraList_tRunJob_2.add("--context_type " + "ssql_cfdp_Login" + "=" + "id_String");
		
			parentContextMap_tRunJob_2.put("ssql_cfdp_Password", context.ssql_cfdp_Password);
			paraList_tRunJob_2.add("--context_type " + "ssql_cfdp_Password" + "=" + "id_Password");
		
			parentContextMap_tRunJob_2.put("ssql_cfdp_Port", context.ssql_cfdp_Port);
			paraList_tRunJob_2.add("--context_type " + "ssql_cfdp_Port" + "=" + "id_String");
		
			parentContextMap_tRunJob_2.put("ssql_cfdp_Schema", context.ssql_cfdp_Schema);
			paraList_tRunJob_2.add("--context_type " + "ssql_cfdp_Schema" + "=" + "id_String");
		
			parentContextMap_tRunJob_2.put("ssql_cfdp_Server", context.ssql_cfdp_Server);
			paraList_tRunJob_2.add("--context_type " + "ssql_cfdp_Server" + "=" + "id_String");
		 
		java.util.Enumeration<?> propertyNames_tRunJob_2 = context.propertyNames();
		while (propertyNames_tRunJob_2.hasMoreElements()) {
			String key_tRunJob_2 = (String) propertyNames_tRunJob_2.nextElement();
			Object value_tRunJob_2 = (Object) context.get(key_tRunJob_2);
			if(value_tRunJob_2!=null) {  
				paraList_tRunJob_2.add("--context_param " + key_tRunJob_2 + "=" + value_tRunJob_2);
			} else {
				paraList_tRunJob_2.add("--context_param " + key_tRunJob_2 + "=" + NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY);
			}
			
		}
		

	Object obj_tRunJob_2 = null;

	
	
		test.ssjob_controlen2_0_1.ssjob_controleN2 childJob_tRunJob_2 = new test.ssjob_controlen2_0_1.ssjob_controleN2();
	    // pass DataSources
	    java.util.Map<String, routines.system.TalendDataSource> talendDataSources_tRunJob_2 = (java.util.Map<String, routines.system.TalendDataSource>) globalMap
	            .get(KEY_DB_DATASOURCES);
	    if (null != talendDataSources_tRunJob_2) {
	        java.util.Map<String, javax.sql.DataSource> dataSources_tRunJob_2 = new java.util.HashMap<String, javax.sql.DataSource>();
	        for (java.util.Map.Entry<String, routines.system.TalendDataSource> talendDataSourceEntry_tRunJob_2 : talendDataSources_tRunJob_2
			        .entrySet()) {
	            dataSources_tRunJob_2.put(talendDataSourceEntry_tRunJob_2.getKey(),
	                    talendDataSourceEntry_tRunJob_2.getValue().getRawDataSource());
	        }
	        childJob_tRunJob_2.setDataSources(dataSources_tRunJob_2);
	    }
		  
			childJob_tRunJob_2.parentContextMap = parentContextMap_tRunJob_2;
		  
		
			log.info("tRunJob_2 - The child job 'test.ssjob_controlen2_0_1.ssjob_controleN2' starts on the version '0.1' with the context 'Default'.");
		
		String[][] childReturn_tRunJob_2 = childJob_tRunJob_2.runJob((String[]) paraList_tRunJob_2.toArray(new String[paraList_tRunJob_2.size()]));
		
			log.info("tRunJob_2 - The child job 'test.ssjob_controlen2_0_1.ssjob_controleN2' is done.");
		
	  	
				errorCode = childJob_tRunJob_2.getErrorCode();
		    
	            
	    	if(childJob_tRunJob_2.getErrorCode() == null){
				globalMap.put("tRunJob_2_CHILD_RETURN_CODE", childJob_tRunJob_2.getStatus() != null && ("failure").equals(childJob_tRunJob_2.getStatus()) ? 1 : 0);
	    	}else{
				globalMap.put("tRunJob_2_CHILD_RETURN_CODE", childJob_tRunJob_2.getErrorCode());
		    }
		    if (childJob_tRunJob_2.getExceptionStackTrace() != null) { 
		    	globalMap.put("tRunJob_2_CHILD_EXCEPTION_STACKTRACE", childJob_tRunJob_2.getExceptionStackTrace());
		    }
	  
			
	  	

 


	tos_count_tRunJob_2++;

/**
 * [tRunJob_2 main ] stop
 */
	
	/**
	 * [tRunJob_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tRunJob_2";

	

 



/**
 * [tRunJob_2 process_data_begin ] stop
 */
	
	/**
	 * [tRunJob_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tRunJob_2";

	

 



/**
 * [tRunJob_2 process_data_end ] stop
 */

} // End of branch "ko"



	
		} // close loop of lookup 'row2' // G_TM_M_043
	
	
	/**
	 * [tMap_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tMap_2";

	

 



/**
 * [tMap_2 process_data_end ] stop
 */



	
	/**
	 * [tFixedFlowInput_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tFixedFlowInput_1";

	

 



/**
 * [tFixedFlowInput_1 process_data_end ] stop
 */
	
	/**
	 * [tFixedFlowInput_1 end ] start
	 */

	

	
	
	currentComponent="tFixedFlowInput_1";

	

        }
        globalMap.put("tFixedFlowInput_1_NB_LINE", 1);        

 

ok_Hash.put("tFixedFlowInput_1", true);
end_Hash.put("tFixedFlowInput_1", System.currentTimeMillis());




/**
 * [tFixedFlowInput_1 end ] stop
 */

	
	/**
	 * [tMap_2 end ] start
	 */

	

	
	
	currentComponent="tMap_2";

	


// ###############################
// # Lookup hashes releasing
					if(tHash_Lookup_row2 != null) {
						tHash_Lookup_row2.endGet();
					}
					globalMap.remove( "tHash_Lookup_row2" );

					
					
				
// ###############################      
				log.debug("tMap_2 - Written records count in the table 'ok': " + count_ok_tMap_2 + ".");
				log.debug("tMap_2 - Written records count in the table 'ko': " + count_ko_tMap_2 + ".");





			if(execStat){
				if(resourceMap.get("inIterateVComp") == null || !((Boolean)resourceMap.get("inIterateVComp"))){
			 		runStat.updateStatOnConnection("row1"+iterateId,2, 0); 
			 	}
			}
		
 
                if(log.isDebugEnabled())
            log.debug("tMap_2 - "  + ("Done.") );

ok_Hash.put("tMap_2", true);
end_Hash.put("tMap_2", System.currentTimeMillis());




/**
 * [tMap_2 end ] stop
 */

	
	/**
	 * [tRunJob_1 end ] start
	 */

	

	
	
	currentComponent="tRunJob_1";

	

			if(execStat){
				if(resourceMap.get("inIterateVComp") == null || !((Boolean)resourceMap.get("inIterateVComp"))){
			 		runStat.updateStatOnConnection("ok"+iterateId,2, 0); 
			 	}
			}
		
 
                if(log.isDebugEnabled())
            log.debug("tRunJob_1 - "  + ("Done.") );

ok_Hash.put("tRunJob_1", true);
end_Hash.put("tRunJob_1", System.currentTimeMillis());




/**
 * [tRunJob_1 end ] stop
 */

	
	/**
	 * [tRunJob_3 end ] start
	 */

	

	
	
	currentComponent="tRunJob_3";

	

			if(execStat){
				if(resourceMap.get("inIterateVComp") == null || !((Boolean)resourceMap.get("inIterateVComp"))){
			 		runStat.updateStatOnConnection("row3"+iterateId,2, 0); 
			 	}
			}
		
 
                if(log.isDebugEnabled())
            log.debug("tRunJob_3 - "  + ("Done.") );

ok_Hash.put("tRunJob_3", true);
end_Hash.put("tRunJob_3", System.currentTimeMillis());




/**
 * [tRunJob_3 end ] stop
 */







	
	/**
	 * [tRunJob_2 end ] start
	 */

	

	
	
	currentComponent="tRunJob_2";

	

			if(execStat){
				if(resourceMap.get("inIterateVComp") == null || !((Boolean)resourceMap.get("inIterateVComp"))){
			 		runStat.updateStatOnConnection("ko"+iterateId,2, 0); 
			 	}
			}
		
 
                if(log.isDebugEnabled())
            log.debug("tRunJob_2 - "  + ("Done.") );

ok_Hash.put("tRunJob_2", true);
end_Hash.put("tRunJob_2", System.currentTimeMillis());




/**
 * [tRunJob_2 end ] stop
 */






				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				    if(!(e instanceof TalendException)){
					   log.fatal(currentComponent + " " + e.getMessage(),e);
					}
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
					     			//free memory for "tMap_2"
					     			globalMap.remove("tHash_Lookup_row2"); 
				     			
				try{
					
	
	/**
	 * [tFixedFlowInput_1 finally ] start
	 */

	

	
	
	currentComponent="tFixedFlowInput_1";

	

 



/**
 * [tFixedFlowInput_1 finally ] stop
 */

	
	/**
	 * [tMap_2 finally ] start
	 */

	

	
	
	currentComponent="tMap_2";

	

 



/**
 * [tMap_2 finally ] stop
 */

	
	/**
	 * [tRunJob_1 finally ] start
	 */

	

	
	
	currentComponent="tRunJob_1";

	

 



/**
 * [tRunJob_1 finally ] stop
 */

	
	/**
	 * [tRunJob_3 finally ] start
	 */

	

	
	
	currentComponent="tRunJob_3";

	

 



/**
 * [tRunJob_3 finally ] stop
 */







	
	/**
	 * [tRunJob_2 finally ] start
	 */

	

	
	
	currentComponent="tRunJob_2";

	

 



/**
 * [tRunJob_2 finally ] stop
 */






				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tFixedFlowInput_1_SUBPROCESS_STATE", 1);
	}
	


public static class row2Struct implements routines.system.IPersistableComparableLookupRow<row2Struct> {
    final static byte[] commonByteArrayLock_TEST_ssjob_ask_pre_trait = new byte[0];
    static byte[] commonByteArray_TEST_ssjob_ask_pre_trait = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public Integer ssjob_spe;

				public Integer getSsjob_spe () {
					return this.ssjob_spe;
				}
				
			    public String nom_ssjob;

				public String getNom_ssjob () {
					return this.nom_ssjob;
				}
				
			    public String code_ia;

				public String getCode_ia () {
					return this.code_ia;
				}
				
			    public String code_edi;

				public String getCode_edi () {
					return this.code_edi;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.code_ia == null) ? 0 : this.code_ia.hashCode());
					
						result = prime * result + ((this.code_edi == null) ? 0 : this.code_edi.hashCode());
					
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final row2Struct other = (row2Struct) obj;
		
						if (this.code_ia == null) {
							if (other.code_ia != null)
								return false;
						
						} else if (!this.code_ia.equals(other.code_ia))
						
							return false;
					
						if (this.code_edi == null) {
							if (other.code_edi != null)
								return false;
						
						} else if (!this.code_edi.equals(other.code_edi))
						
							return false;
					

		return true;
    }

	public void copyDataTo(row2Struct other) {

		other.ssjob_spe = this.ssjob_spe;
	            other.nom_ssjob = this.nom_ssjob;
	            other.code_ia = this.code_ia;
	            other.code_edi = this.code_edi;
	            
	}

	public void copyKeysDataTo(row2Struct other) {

		other.code_ia = this.code_ia;
	            	other.code_edi = this.code_edi;
	            	
	}



	private Integer readInteger(DataInputStream dis, ObjectInputStream ois) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
			intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, DataOutputStream dos, ObjectOutputStream oos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}

	private String readString(DataInputStream dis, ObjectInputStream ois) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			byte[] byteArray = new byte[length];
			dis.read(byteArray);
			strReturn = new String(byteArray, utf8Charset);
		}
		return strReturn;
	}

	private void writeString(String str, DataOutputStream dos, ObjectOutputStream oos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
	}

	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_TEST_ssjob_ask_pre_trait.length) {
				if(length < 1024 && commonByteArray_TEST_ssjob_ask_pre_trait.length == 0) {
   					commonByteArray_TEST_ssjob_ask_pre_trait = new byte[1024];
				} else {
   					commonByteArray_TEST_ssjob_ask_pre_trait = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_TEST_ssjob_ask_pre_trait, 0, length);
			strReturn = new String(commonByteArray_TEST_ssjob_ask_pre_trait, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }

    public void readKeysData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_TEST_ssjob_ask_pre_trait) {

        	try {

        		int length = 0;
		
					this.code_ia = readString(dis);
					
					this.code_edi = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.code_ia,dos);
					
					// String
				
						writeString(this.code_edi,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }



    /**
     * Fill Values data by reading ObjectInputStream.
     */
    public void readValuesData(DataInputStream dis, ObjectInputStream ois) {
        try {

			int length = 0;
		
						this.ssjob_spe = readInteger(dis,ois);
					
						this.nom_ssjob = readString(dis,ois);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }

    /**
     * Return a byte array which represents Values data.
     */
    public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
        try {

		
					writeInteger(this.ssjob_spe, dos, oos);
					
						writeString(this.nom_ssjob, dos, oos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("ssjob_spe="+String.valueOf(ssjob_spe));
		sb.append(",nom_ssjob="+nom_ssjob);
		sb.append(",code_ia="+code_ia);
		sb.append(",code_edi="+code_edi);
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				if(ssjob_spe == null){
        					sb.append("<null>");
        				}else{
            				sb.append(ssjob_spe);
            			}
            		
        			sb.append("|");
        		
        				if(nom_ssjob == null){
        					sb.append("<null>");
        				}else{
            				sb.append(nom_ssjob);
            			}
            		
        			sb.append("|");
        		
        				if(code_ia == null){
        					sb.append("<null>");
        				}else{
            				sb.append(code_ia);
            			}
            		
        			sb.append("|");
        		
        				if(code_edi == null){
        					sb.append("<null>");
        				}else{
            				sb.append(code_edi);
            			}
            		
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(row2Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.code_ia, other.code_ia);
						if(returnValue != 0) {
							return returnValue;
						}

					
						returnValue = checkNullsAndCompare(this.code_edi, other.code_edi);
						if(returnValue != 0) {
							return returnValue;
						}

					
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void tDBInput_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBInput_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		row2Struct row2 = new row2Struct();




	
	/**
	 * [tAdvancedHash_row2 begin ] start
	 */

	

	
		
		ok_Hash.put("tAdvancedHash_row2", false);
		start_Hash.put("tAdvancedHash_row2", System.currentTimeMillis());
		
	
	currentComponent="tAdvancedHash_row2";

	
			if (execStat) {
				if(resourceMap.get("inIterateVComp") == null){
					
						runStat.updateStatOnConnection("row2" + iterateId, 0, 0);
					
				}
			} 

		
		int tos_count_tAdvancedHash_row2 = 0;
		

			   		// connection name:row2
			   		// source node:tDBInput_1 - inputs:(after_tFixedFlowInput_1) outputs:(row2,row2) | target node:tAdvancedHash_row2 - inputs:(row2) outputs:()
			   		// linked node: tMap_2 - inputs:(row1,row2) outputs:(ok,ko)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row2 = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.ALL_MATCHES;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct> tHash_Lookup_row2 =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<row2Struct>getLookup(matchingModeEnum_row2);
	   						   
		   	   	   globalMap.put("tHash_Lookup_row2", tHash_Lookup_row2);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_row2 begin ] stop
 */



	
	/**
	 * [tDBInput_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBInput_1", false);
		start_Hash.put("tDBInput_1", System.currentTimeMillis());
		
	
	currentComponent="tDBInput_1";

	
		int tos_count_tDBInput_1 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tDBInput_1 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tDBInput_1{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tDBInput_1 = new StringBuilder();
                    log4jParamters_tDBInput_1.append("Parameters:");
                            log4jParamters_tDBInput_1.append("USE_EXISTING_CONNECTION" + " = " + "true");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("CONNECTION" + " = " + "tDBConnection_1");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("TABLE" + " = " + "\"\"");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("QUERYSTORE" + " = " + "\"\"");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("QUERY" + " = " + "\"select AE.sjs_id, SSJ.nom_technique, P.code, T.code  from partenaire as P, autorisationedi as AE, typeedi as T, sousjobspecifique as SSJ  where P.par_id = AE.par_id and T.ted_id = AE.ted_id and SSJ.sjs_id = AE.sjs_id ;\"");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("TRIM_ALL_COLUMN" + " = " + "false");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("TRIM_COLUMN" + " = " + "[{TRIM="+("false")+", SCHEMA_COLUMN="+("ssjob_spe")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("nom_ssjob")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("code_ia")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("code_edi")+"}]");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("UNIFIED_COMPONENTS" + " = " + "tMSSqlInput");
                        log4jParamters_tDBInput_1.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tDBInput_1 - "  + (log4jParamters_tDBInput_1) );
                    } 
                } 
            new BytesLimit65535_tDBInput_1().limitLog4jByte();
            }
	
    
	
			org.talend.designer.components.util.mssql.MSSqlGenerateTimestampUtil mssqlGTU_tDBInput_1 = org.talend.designer.components.util.mssql.MSSqlUtilFactory.getMSSqlGenerateTimestampUtil();
			
			java.util.List<String> talendToDBList_tDBInput_1 = new java.util.ArrayList();
			String[] talendToDBArray_tDBInput_1  = new String[]{"FLOAT","NUMERIC","NUMERIC IDENTITY","DECIMAL","DECIMAL IDENTITY","REAL"}; 
			java.util.Collections.addAll(talendToDBList_tDBInput_1, talendToDBArray_tDBInput_1); 
		    int nb_line_tDBInput_1 = 0;
		    java.sql.Connection conn_tDBInput_1 = null;
		        conn_tDBInput_1 = (java.sql.Connection)globalMap.get("conn_tDBConnection_1");
				if(conn_tDBInput_1 != null) {
					if(conn_tDBInput_1.getMetaData() != null) {
						
							log.debug("tDBInput_1 - Uses an existing connection with username '" + conn_tDBInput_1.getMetaData().getUserName() + "'. Connection URL: " + conn_tDBInput_1.getMetaData().getURL() + ".");
						
					}
				}
			
			String dbschema_tDBInput_1 = (String)globalMap.get("dbschema_tDBConnection_1");
		    
			java.sql.Statement stmt_tDBInput_1 = conn_tDBInput_1.createStatement();

		    String dbquery_tDBInput_1 = "select AE.sjs_id, SSJ.nom_technique, P.code, T.code\nfrom partenaire as P, autorisationedi as AE, typeedi as T, sousjob"
+"specifique as SSJ\nwhere P.par_id = AE.par_id and T.ted_id = AE.ted_id and SSJ.sjs_id = AE.sjs_id ;";
			
                log.debug("tDBInput_1 - Executing the query: '"+dbquery_tDBInput_1+"'.");
			

            	globalMap.put("tDBInput_1_QUERY",dbquery_tDBInput_1);
		    java.sql.ResultSet rs_tDBInput_1 = null;

		    try {
		    	rs_tDBInput_1 = stmt_tDBInput_1.executeQuery(dbquery_tDBInput_1);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_1 = rs_tDBInput_1.getMetaData();
		    	int colQtyInRs_tDBInput_1 = rsmd_tDBInput_1.getColumnCount();

		    String tmpContent_tDBInput_1 = null;
		    
		    
		    	log.debug("tDBInput_1 - Retrieving records from the database.");
		    
		    while (rs_tDBInput_1.next()) {
		        nb_line_tDBInput_1++;
		        
							if(colQtyInRs_tDBInput_1 < 1) {
								row2.ssjob_spe = null;
							} else {
		                          
            if(rs_tDBInput_1.getObject(1) != null) {
                row2.ssjob_spe = rs_tDBInput_1.getInt(1);
            } else {
                    row2.ssjob_spe = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 2) {
								row2.nom_ssjob = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(2);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(2).toUpperCase(java.util.Locale.ENGLISH))) {
            		row2.nom_ssjob = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row2.nom_ssjob = tmpContent_tDBInput_1;
                }
            } else {
                row2.nom_ssjob = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 3) {
								row2.code_ia = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(3);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(3).toUpperCase(java.util.Locale.ENGLISH))) {
            		row2.code_ia = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row2.code_ia = tmpContent_tDBInput_1;
                }
            } else {
                row2.code_ia = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 4) {
								row2.code_edi = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(4);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(4).toUpperCase(java.util.Locale.ENGLISH))) {
            		row2.code_edi = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row2.code_edi = tmpContent_tDBInput_1;
                }
            } else {
                row2.code_edi = null;
            }
		                    }
					
						log.debug("tDBInput_1 - Retrieving the record " + nb_line_tDBInput_1 + ".");
					





 



/**
 * [tDBInput_1 begin ] stop
 */
	
	/**
	 * [tDBInput_1 main ] start
	 */

	

	
	
	currentComponent="tDBInput_1";

	

 


	tos_count_tDBInput_1++;

/**
 * [tDBInput_1 main ] stop
 */
	
	/**
	 * [tDBInput_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_1";

	

 



/**
 * [tDBInput_1 process_data_begin ] stop
 */

	
	/**
	 * [tAdvancedHash_row2 main ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row2";

	

			//row2
			//row2


			
				if(execStat){
					runStat.updateStatOnConnection("row2"+iterateId,1, 1);
				} 
			

		
    			if(log.isTraceEnabled()){
    				log.trace("row2 - " + (row2==null? "": row2.toLogString()));
    			}
    		


			   
			   

					row2Struct row2_HashRow = new row2Struct();
		   	   	   
				
				row2_HashRow.ssjob_spe = row2.ssjob_spe;
				
				row2_HashRow.nom_ssjob = row2.nom_ssjob;
				
				row2_HashRow.code_ia = row2.code_ia;
				
				row2_HashRow.code_edi = row2.code_edi;
				
			tHash_Lookup_row2.put(row2_HashRow);
			
            




 


	tos_count_tAdvancedHash_row2++;

/**
 * [tAdvancedHash_row2 main ] stop
 */
	
	/**
	 * [tAdvancedHash_row2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row2";

	

 



/**
 * [tAdvancedHash_row2 process_data_begin ] stop
 */
	
	/**
	 * [tAdvancedHash_row2 process_data_end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row2";

	

 



/**
 * [tAdvancedHash_row2 process_data_end ] stop
 */



	
	/**
	 * [tDBInput_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBInput_1";

	

 



/**
 * [tDBInput_1 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_1 end ] start
	 */

	

	
	
	currentComponent="tDBInput_1";

	

	}
}finally{
	if (rs_tDBInput_1 != null) {
		rs_tDBInput_1.close();
	}
	if (stmt_tDBInput_1 != null) {
		stmt_tDBInput_1.close();
	}
}
globalMap.put("tDBInput_1_NB_LINE",nb_line_tDBInput_1);
	    		log.debug("tDBInput_1 - Retrieved records count: "+nb_line_tDBInput_1 + " .");
			

 
                if(log.isDebugEnabled())
            log.debug("tDBInput_1 - "  + ("Done.") );

ok_Hash.put("tDBInput_1", true);
end_Hash.put("tDBInput_1", System.currentTimeMillis());




/**
 * [tDBInput_1 end ] stop
 */

	
	/**
	 * [tAdvancedHash_row2 end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row2";

	

tHash_Lookup_row2.endPut();

			if(execStat){
				if(resourceMap.get("inIterateVComp") == null || !((Boolean)resourceMap.get("inIterateVComp"))){
			 		runStat.updateStatOnConnection("row2"+iterateId,2, 0); 
			 	}
			}
		
 

ok_Hash.put("tAdvancedHash_row2", true);
end_Hash.put("tAdvancedHash_row2", System.currentTimeMillis());




/**
 * [tAdvancedHash_row2 end ] stop
 */



				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				    if(!(e instanceof TalendException)){
					   log.fatal(currentComponent + " " + e.getMessage(),e);
					}
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tDBInput_1 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_1";

	

 



/**
 * [tDBInput_1 finally ] stop
 */

	
	/**
	 * [tAdvancedHash_row2 finally ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row2";

	

 



/**
 * [tAdvancedHash_row2 finally ] stop
 */



				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBInput_1_SUBPROCESS_STATE", 1);
	}
	
    public String resuming_logs_dir_path = null;
    public String resuming_checkpoint_path = null;
    public String parent_part_launcher = null;
    private String resumeEntryMethodName = null;
    private boolean globalResumeTicket = false;

    public boolean watch = false;
    // portStats is null, it means don't execute the statistics
    public Integer portStats = null;
    public int portTraces = 4334;
    public String clientHost;
    public String defaultClientHost = "localhost";
    public String contextStr = "Default";
    public boolean isDefaultContext = true;
    public String pid = "0";
    public String rootPid = null;
    public String fatherPid = null;
    public String fatherNode = null;
    public long startTime = 0;
    public boolean isChildJob = false;
    public String log4jLevel = "";

    private boolean execStat = true;

    private ThreadLocal<java.util.Map<String, String>> threadLocal = new ThreadLocal<java.util.Map<String, String>>() {
        protected java.util.Map<String, String> initialValue() {
            java.util.Map<String,String> threadRunResultMap = new java.util.HashMap<String, String>();
            threadRunResultMap.put("errorCode", null);
            threadRunResultMap.put("status", "");
            return threadRunResultMap;
        };
    };


    private PropertiesWithType context_param = new PropertiesWithType();
    public java.util.Map<String, Object> parentContextMap = new java.util.HashMap<String, Object>();

    public String status= "";
    

    public static void main(String[] args){
        final ssjob_ask_pre_trait ssjob_ask_pre_traitClass = new ssjob_ask_pre_trait();

        int exitCode = ssjob_ask_pre_traitClass.runJobInTOS(args);
	        if(exitCode==0){
		        log.info("TalendJob: 'ssjob_ask_pre_trait' - Done.");
	        }

        System.exit(exitCode);
    }


    public String[][] runJob(String[] args) {

        int exitCode = runJobInTOS(args);
        String[][] bufferValue = new String[][] { { Integer.toString(exitCode) } };

        return bufferValue;
    }

    public boolean hastBufferOutputComponent() {
		boolean hastBufferOutput = false;
    	
        return hastBufferOutput;
    }

    public int runJobInTOS(String[] args) {
	   	// reset status
	   	status = "";

        String lastStr = "";
        for (String arg : args) {
            if (arg.equalsIgnoreCase("--context_param")) {
                lastStr = arg;
            } else if (lastStr.equals("")) {
                evalParam(arg);
            } else {
                evalParam(lastStr + " " + arg);
                lastStr = "";
            }
        }

	        if(!"".equals(log4jLevel)){
				if("trace".equalsIgnoreCase(log4jLevel)){
					log.setLevel(org.apache.log4j.Level.TRACE);
				}else if("debug".equalsIgnoreCase(log4jLevel)){
					log.setLevel(org.apache.log4j.Level.DEBUG);
				}else if("info".equalsIgnoreCase(log4jLevel)){
					log.setLevel(org.apache.log4j.Level.INFO);
				}else if("warn".equalsIgnoreCase(log4jLevel)){
					log.setLevel(org.apache.log4j.Level.WARN);
				}else if("error".equalsIgnoreCase(log4jLevel)){
					log.setLevel(org.apache.log4j.Level.ERROR);
				}else if("fatal".equalsIgnoreCase(log4jLevel)){
					log.setLevel(org.apache.log4j.Level.FATAL);
				}else if ("off".equalsIgnoreCase(log4jLevel)){
					log.setLevel(org.apache.log4j.Level.OFF);
				}
				org.apache.log4j.Logger.getRootLogger().setLevel(log.getLevel());
    	    }
        	log.info("TalendJob: 'ssjob_ask_pre_trait' - Start.");
    	

        if(clientHost == null) {
            clientHost = defaultClientHost;
        }

        if(pid == null || "0".equals(pid)) {
            pid = TalendString.getAsciiRandomString(6);
        }

        if (rootPid==null) {
            rootPid = pid;
        }
        if (fatherPid==null) {
            fatherPid = pid;
        }else{
            isChildJob = true;
        }

        if (portStats != null) {
            // portStats = -1; //for testing
            if (portStats < 0 || portStats > 65535) {
                // issue:10869, the portStats is invalid, so this client socket can't open
                System.err.println("The statistics socket port " + portStats + " is invalid.");
                execStat = false;
            }
        } else {
            execStat = false;
        }

        try {
            //call job/subjob with an existing context, like: --context=production. if without this parameter, there will use the default context instead.
            java.io.InputStream inContext = ssjob_ask_pre_trait.class.getClassLoader().getResourceAsStream("test/ssjob_ask_pre_trait_0_1/contexts/" + contextStr + ".properties");
            if (inContext == null) {
                inContext = ssjob_ask_pre_trait.class.getClassLoader().getResourceAsStream("config/contexts/" + contextStr + ".properties");
            }
            if (inContext != null && context != null && context.isEmpty()) {
                //defaultProps is in order to keep the original context value
                defaultProps.load(inContext);
                inContext.close();
                context = new ContextProperties(defaultProps);
            } else if (!isDefaultContext) {
                //print info and job continue to run, for case: context_param is not empty.
                System.err.println("Could not find the context " + contextStr);
            }

            if(!context_param.isEmpty()) {
                context.putAll(context_param);
				//set types for params from parentJobs
				for (Object key: context_param.keySet()){
					String context_key = key.toString();
					String context_type = context_param.getContextType(context_key);
					context.setContextType(context_key, context_type);

				}
            }
				    context.setContextType("archivage_ko", "id_Integer");
				
             try{
                 context.archivage_ko=routines.system.ParserUtils.parseTo_Integer (context.getProperty("archivage_ko"));
             }catch(NumberFormatException e){
                    log.warn(String.format("Null value will be used for context parameter %s: %s", "archivage_ko", e.getMessage()));
                 context.archivage_ko=null;
              }
				    context.setContextType("codeEDI", "id_String");
				
                context.codeEDI=(String) context.getProperty("codeEDI");
				    context.setContextType("codeIA", "id_String");
				
                context.codeIA=(String) context.getProperty("codeIA");
				    context.setContextType("date", "id_String");
				
                context.date=(String) context.getProperty("date");
				    context.setContextType("file_name", "id_String");
				
                context.file_name=(String) context.getProperty("file_name");
				    context.setContextType("nb_lignes", "id_Integer");
				
             try{
                 context.nb_lignes=routines.system.ParserUtils.parseTo_Integer (context.getProperty("nb_lignes"));
             }catch(NumberFormatException e){
                    log.warn(String.format("Null value will be used for context parameter %s: %s", "nb_lignes", e.getMessage()));
                 context.nb_lignes=null;
              }
				    context.setContextType("non_conforme", "id_String");
				
                context.non_conforme=(String) context.getProperty("non_conforme");
				    context.setContextType("rep_ftp", "id_String");
				
                context.rep_ftp=(String) context.getProperty("rep_ftp");
				    context.setContextType("statut", "id_String");
				
                context.statut=(String) context.getProperty("statut");
				    context.setContextType("str_id", "id_Integer");
				
             try{
                 context.str_id=routines.system.ParserUtils.parseTo_Integer (context.getProperty("str_id"));
             }catch(NumberFormatException e){
                    log.warn(String.format("Null value will be used for context parameter %s: %s", "str_id", e.getMessage()));
                 context.str_id=null;
              }
				    context.setContextType("type", "id_String");
				
                context.type=(String) context.getProperty("type");
				    context.setContextType("ssql_cfdp_AdditionalParams", "id_String");
				
                context.ssql_cfdp_AdditionalParams=(String) context.getProperty("ssql_cfdp_AdditionalParams");
				    context.setContextType("ssql_cfdp_Database", "id_String");
				
                context.ssql_cfdp_Database=(String) context.getProperty("ssql_cfdp_Database");
				    context.setContextType("ssql_cfdp_Login", "id_String");
				
                context.ssql_cfdp_Login=(String) context.getProperty("ssql_cfdp_Login");
				    context.setContextType("ssql_cfdp_Password", "id_Password");
				
            		String pwd_ssql_cfdp_Password_value = context.getProperty("ssql_cfdp_Password");
            		context.ssql_cfdp_Password = null;
            		if(pwd_ssql_cfdp_Password_value!=null) {
            			if(context_param.containsKey("ssql_cfdp_Password")) {//no need to decrypt if it come from program argument or parent job runtime
            				context.ssql_cfdp_Password = pwd_ssql_cfdp_Password_value;
            			} else if (!pwd_ssql_cfdp_Password_value.isEmpty()) {
            				try {
            					context.ssql_cfdp_Password = routines.system.PasswordEncryptUtil.decryptPassword(pwd_ssql_cfdp_Password_value);
            					context.put("ssql_cfdp_Password",context.ssql_cfdp_Password);
            				} catch (java.lang.RuntimeException e) {
            					//do nothing
            				}
            			}
            		}
				    context.setContextType("ssql_cfdp_Port", "id_String");
				
                context.ssql_cfdp_Port=(String) context.getProperty("ssql_cfdp_Port");
				    context.setContextType("ssql_cfdp_Schema", "id_String");
				
                context.ssql_cfdp_Schema=(String) context.getProperty("ssql_cfdp_Schema");
				    context.setContextType("ssql_cfdp_Server", "id_String");
				
                context.ssql_cfdp_Server=(String) context.getProperty("ssql_cfdp_Server");
        } catch (java.io.IOException ie) {
            System.err.println("Could not load context "+contextStr);
            ie.printStackTrace();
        }


        // get context value from parent directly
        if (parentContextMap != null && !parentContextMap.isEmpty()) {if (parentContextMap.containsKey("archivage_ko")) {
                context.archivage_ko = (Integer) parentContextMap.get("archivage_ko");
            }if (parentContextMap.containsKey("codeEDI")) {
                context.codeEDI = (String) parentContextMap.get("codeEDI");
            }if (parentContextMap.containsKey("codeIA")) {
                context.codeIA = (String) parentContextMap.get("codeIA");
            }if (parentContextMap.containsKey("date")) {
                context.date = (String) parentContextMap.get("date");
            }if (parentContextMap.containsKey("file_name")) {
                context.file_name = (String) parentContextMap.get("file_name");
            }if (parentContextMap.containsKey("nb_lignes")) {
                context.nb_lignes = (Integer) parentContextMap.get("nb_lignes");
            }if (parentContextMap.containsKey("non_conforme")) {
                context.non_conforme = (String) parentContextMap.get("non_conforme");
            }if (parentContextMap.containsKey("rep_ftp")) {
                context.rep_ftp = (String) parentContextMap.get("rep_ftp");
            }if (parentContextMap.containsKey("statut")) {
                context.statut = (String) parentContextMap.get("statut");
            }if (parentContextMap.containsKey("str_id")) {
                context.str_id = (Integer) parentContextMap.get("str_id");
            }if (parentContextMap.containsKey("type")) {
                context.type = (String) parentContextMap.get("type");
            }if (parentContextMap.containsKey("ssql_cfdp_AdditionalParams")) {
                context.ssql_cfdp_AdditionalParams = (String) parentContextMap.get("ssql_cfdp_AdditionalParams");
            }if (parentContextMap.containsKey("ssql_cfdp_Database")) {
                context.ssql_cfdp_Database = (String) parentContextMap.get("ssql_cfdp_Database");
            }if (parentContextMap.containsKey("ssql_cfdp_Login")) {
                context.ssql_cfdp_Login = (String) parentContextMap.get("ssql_cfdp_Login");
            }if (parentContextMap.containsKey("ssql_cfdp_Password")) {
                context.ssql_cfdp_Password = (java.lang.String) parentContextMap.get("ssql_cfdp_Password");
            }if (parentContextMap.containsKey("ssql_cfdp_Port")) {
                context.ssql_cfdp_Port = (String) parentContextMap.get("ssql_cfdp_Port");
            }if (parentContextMap.containsKey("ssql_cfdp_Schema")) {
                context.ssql_cfdp_Schema = (String) parentContextMap.get("ssql_cfdp_Schema");
            }if (parentContextMap.containsKey("ssql_cfdp_Server")) {
                context.ssql_cfdp_Server = (String) parentContextMap.get("ssql_cfdp_Server");
            }
        }

        //Resume: init the resumeUtil
        resumeEntryMethodName = ResumeUtil.getResumeEntryMethodName(resuming_checkpoint_path);
        resumeUtil = new ResumeUtil(resuming_logs_dir_path, isChildJob, rootPid);
        resumeUtil.initCommonInfo(pid, rootPid, fatherPid, projectName, jobName, contextStr, jobVersion);

		List<String> parametersToEncrypt = new java.util.ArrayList<String>();
			parametersToEncrypt.add("ssql_cfdp_Password");
        //Resume: jobStart
        resumeUtil.addLog("JOB_STARTED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "","","","",resumeUtil.convertToJsonText(context,parametersToEncrypt));

if(execStat) {
    try {
        runStat.openSocket(!isChildJob);
        runStat.setAllPID(rootPid, fatherPid, pid, jobName);
        runStat.startThreadStat(clientHost, portStats);
        runStat.updateStatOnJob(RunStat.JOBSTART, fatherNode);
    } catch (java.io.IOException ioException) {
        ioException.printStackTrace();
    }
}



	
	    java.util.concurrent.ConcurrentHashMap<Object, Object> concurrentHashMap = new java.util.concurrent.ConcurrentHashMap<Object, Object>();
	    globalMap.put("concurrentHashMap", concurrentHashMap);
	

    long startUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    long endUsedMemory = 0;
    long end = 0;

    startTime = System.currentTimeMillis();




this.globalResumeTicket = true;//to run tPreJob

try {
errorCode = null;tPrejob_1Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tPrejob_1) {
globalMap.put("tPrejob_1_SUBPROCESS_STATE", -1);

e_tPrejob_1.printStackTrace();

}



this.globalResumeTicket = false;//to run others jobs

try {
errorCode = null;tFixedFlowInput_1Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tFixedFlowInput_1) {
globalMap.put("tFixedFlowInput_1_SUBPROCESS_STATE", -1);

e_tFixedFlowInput_1.printStackTrace();

}

this.globalResumeTicket = true;//to run tPostJob

try {
errorCode = null;tPostjob_1Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tPostjob_1) {
globalMap.put("tPostjob_1_SUBPROCESS_STATE", -1);

e_tPostjob_1.printStackTrace();

}



        end = System.currentTimeMillis();

        if (watch) {
            System.out.println((end-startTime)+" milliseconds");
        }

        endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        if (false) {
            System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : ssjob_ask_pre_trait");
        }



if (execStat) {
    runStat.updateStatOnJob(RunStat.JOBEND, fatherNode);
    runStat.stopThreadStat();
}
    int returnCode = 0;
    if(errorCode == null) {
         returnCode = status != null && status.equals("failure") ? 1 : 0;
    } else {
         returnCode = errorCode.intValue();
    }
    resumeUtil.addLog("JOB_ENDED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "","" + returnCode,"","","");

    return returnCode;

  }

    // only for OSGi env
    public void destroy() {
    closeSqlDbConnections();


    }



    private void closeSqlDbConnections() {
        try {
            Object obj_conn;
            obj_conn = globalMap.remove("conn_tDBConnection_1");
            if (null != obj_conn) {
                ((java.sql.Connection) obj_conn).close();
            }
        } catch (java.lang.Exception e) {
        }
    }











    private java.util.Map<String, Object> getSharedConnections4REST() {
        java.util.Map<String, Object> connections = new java.util.HashMap<String, Object>();
            connections.put("conn_tDBConnection_1", globalMap.get("conn_tDBConnection_1"));







        return connections;
    }

    private void evalParam(String arg) {
        if (arg.startsWith("--resuming_logs_dir_path")) {
            resuming_logs_dir_path = arg.substring(25);
        } else if (arg.startsWith("--resuming_checkpoint_path")) {
            resuming_checkpoint_path = arg.substring(27);
        } else if (arg.startsWith("--parent_part_launcher")) {
            parent_part_launcher = arg.substring(23);
        } else if (arg.startsWith("--watch")) {
            watch = true;
        } else if (arg.startsWith("--stat_port=")) {
            String portStatsStr = arg.substring(12);
            if (portStatsStr != null && !portStatsStr.equals("null")) {
                portStats = Integer.parseInt(portStatsStr);
            }
        } else if (arg.startsWith("--trace_port=")) {
            portTraces = Integer.parseInt(arg.substring(13));
        } else if (arg.startsWith("--client_host=")) {
            clientHost = arg.substring(14);
        } else if (arg.startsWith("--context=")) {
            contextStr = arg.substring(10);
            isDefaultContext = false;
        } else if (arg.startsWith("--father_pid=")) {
            fatherPid = arg.substring(13);
        } else if (arg.startsWith("--root_pid=")) {
            rootPid = arg.substring(11);
        } else if (arg.startsWith("--father_node=")) {
            fatherNode = arg.substring(14);
        } else if (arg.startsWith("--pid=")) {
            pid = arg.substring(6);
        } else if (arg.startsWith("--context_type")) {
            String keyValue = arg.substring(15);
			int index = -1;
            if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
                if (fatherPid==null) {
                    context_param.setContextType(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
                } else { // the subjob won't escape the especial chars
                    context_param.setContextType(keyValue.substring(0, index), keyValue.substring(index + 1) );
                }

            }

		} else if (arg.startsWith("--context_param")) {
            String keyValue = arg.substring(16);
            int index = -1;
            if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
                if (fatherPid==null) {
                    context_param.put(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
                } else { // the subjob won't escape the especial chars
                    context_param.put(keyValue.substring(0, index), keyValue.substring(index + 1) );
                }
            }
        }else if (arg.startsWith("--log4jLevel=")) {
            log4jLevel = arg.substring(13);
		}

    }
    
    private static final String NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY = "<TALEND_NULL>";

    private final String[][] escapeChars = {
        {"\\\\","\\"},{"\\n","\n"},{"\\'","\'"},{"\\r","\r"},
        {"\\f","\f"},{"\\b","\b"},{"\\t","\t"}
        };
    private String replaceEscapeChars (String keyValue) {

		if (keyValue == null || ("").equals(keyValue.trim())) {
			return keyValue;
		}

		StringBuilder result = new StringBuilder();
		int currIndex = 0;
		while (currIndex < keyValue.length()) {
			int index = -1;
			// judege if the left string includes escape chars
			for (String[] strArray : escapeChars) {
				index = keyValue.indexOf(strArray[0],currIndex);
				if (index>=0) {

					result.append(keyValue.substring(currIndex, index + strArray[0].length()).replace(strArray[0], strArray[1]));
					currIndex = index + strArray[0].length();
					break;
				}
			}
			// if the left string doesn't include escape chars, append the left into the result
			if (index < 0) {
				result.append(keyValue.substring(currIndex));
				currIndex = currIndex + keyValue.length();
			}
		}

		return result.toString();
    }

    public Integer getErrorCode() {
        return errorCode;
    }


    public String getStatus() {
        return status;
    }

    ResumeUtil resumeUtil = null;
}
/************************************************************************************************
 *     163222 characters generated by Talend Cloud Data Management Platform 
 *     on the September 13, 2019 3:25:25 PM CEST
 ************************************************************************************************/