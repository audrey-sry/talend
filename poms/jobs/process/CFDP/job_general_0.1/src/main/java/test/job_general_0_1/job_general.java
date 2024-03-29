
package test.job_general_0_1;

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
 * Job: job_general Purpose: <br>
 * Description:  <br>
 * @author user@talend.com
 * @version 7.1.1.20190228_0243-patch
 * @status 
 */
public class job_general implements TalendJob {
	static {System.setProperty("TalendJob.log", "job_general.log");}
	private static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(job_general.class);

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
			
			if(FILES != null){
				
					this.setProperty("FILES", FILES.toString());
				
			}
			
			if(rep_archivage != null){
				
					this.setProperty("rep_archivage", rep_archivage.toString());
				
			}
			
			if(rep_rejet_N1 != null){
				
					this.setProperty("rep_rejet_N1", rep_rejet_N1.toString());
				
			}
			
			if(rep_travail != null){
				
					this.setProperty("rep_travail", rep_travail.toString());
				
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

public String FILES;
public String getFILES(){
	return this.FILES;
}
public String rep_archivage;
public String getRep_archivage(){
	return this.rep_archivage;
}
public String rep_rejet_N1;
public String getRep_rejet_N1(){
	return this.rep_rejet_N1;
}
public String rep_travail;
public String getRep_travail(){
	return this.rep_travail;
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
	private final String jobName = "job_general";
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
				job_general.this.exception = e;
			}
		}
		if (!(e instanceof TalendException)) {
		try {
			for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
				if (m.getName().compareTo(currentComponent + "_error") == 0) {
					m.invoke(job_general.this, new Object[] { e , currentComponent, globalMap});
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
			
			public void tDBInput_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_2_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tFlowToIterate_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_2_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tFileList_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_2_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tFileRowCount_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_2_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tFileProperties_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_2_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tFileCopy_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_2_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tRunJob_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_2_onSubJobError(exception, errorComponent, globalMap);
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
			
			public void tPrejob_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tDBConnection_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tDie_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tDBInput_2_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tPostjob_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tDBClose_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

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
	


public static class row1Struct implements routines.system.IPersistableRow<row1Struct> {
    final static byte[] commonByteArrayLock_TEST_job_general = new byte[0];
    static byte[] commonByteArray_TEST_job_general = new byte[0];

	
			    public String abs_path;

				public String getAbs_path () {
					return this.abs_path;
				}
				
			    public String dirname;

				public String getDirname () {
					return this.dirname;
				}
				
			    public String basename;

				public String getBasename () {
					return this.basename;
				}
				
			    public String mode_string;

				public String getMode_string () {
					return this.mode_string;
				}
				
			    public Long size;

				public Long getSize () {
					return this.size;
				}
				
			    public Long mtime;

				public Long getMtime () {
					return this.mtime;
				}
				
			    public String mtime_string;

				public String getMtime_string () {
					return this.mtime_string;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_TEST_job_general.length) {
				if(length < 1024 && commonByteArray_TEST_job_general.length == 0) {
   					commonByteArray_TEST_job_general = new byte[1024];
				} else {
   					commonByteArray_TEST_job_general = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_TEST_job_general, 0, length);
			strReturn = new String(commonByteArray_TEST_job_general, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_TEST_job_general) {

        	try {

        		int length = 0;
		
					this.abs_path = readString(dis);
					
					this.dirname = readString(dis);
					
					this.basename = readString(dis);
					
					this.mode_string = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.size = null;
           				} else {
           			    	this.size = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.mtime = null;
           				} else {
           			    	this.mtime = dis.readLong();
           				}
					
					this.mtime_string = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.abs_path,dos);
					
					// String
				
						writeString(this.dirname,dos);
					
					// String
				
						writeString(this.basename,dos);
					
					// String
				
						writeString(this.mode_string,dos);
					
					// Long
				
						if(this.size == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.size);
		            	}
					
					// Long
				
						if(this.mtime == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.mtime);
		            	}
					
					// String
				
						writeString(this.mtime_string,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("abs_path="+abs_path);
		sb.append(",dirname="+dirname);
		sb.append(",basename="+basename);
		sb.append(",mode_string="+mode_string);
		sb.append(",size="+String.valueOf(size));
		sb.append(",mtime="+String.valueOf(mtime));
		sb.append(",mtime_string="+mtime_string);
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				if(abs_path == null){
        					sb.append("<null>");
        				}else{
            				sb.append(abs_path);
            			}
            		
        			sb.append("|");
        		
        				if(dirname == null){
        					sb.append("<null>");
        				}else{
            				sb.append(dirname);
            			}
            		
        			sb.append("|");
        		
        				if(basename == null){
        					sb.append("<null>");
        				}else{
            				sb.append(basename);
            			}
            		
        			sb.append("|");
        		
        				if(mode_string == null){
        					sb.append("<null>");
        				}else{
            				sb.append(mode_string);
            			}
            		
        			sb.append("|");
        		
        				if(size == null){
        					sb.append("<null>");
        				}else{
            				sb.append(size);
            			}
            		
        			sb.append("|");
        		
        				if(mtime == null){
        					sb.append("<null>");
        				}else{
            				sb.append(mtime);
            			}
            		
        			sb.append("|");
        		
        				if(mtime_string == null){
        					sb.append("<null>");
        				}else{
            				sb.append(mtime_string);
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

public static class row2Struct implements routines.system.IPersistableRow<row2Struct> {
    final static byte[] commonByteArrayLock_TEST_job_general = new byte[0];
    static byte[] commonByteArray_TEST_job_general = new byte[0];

	
			    public String abs_path;

				public String getAbs_path () {
					return this.abs_path;
				}
				
			    public String dirname;

				public String getDirname () {
					return this.dirname;
				}
				
			    public String basename;

				public String getBasename () {
					return this.basename;
				}
				
			    public String mode_string;

				public String getMode_string () {
					return this.mode_string;
				}
				
			    public Long size;

				public Long getSize () {
					return this.size;
				}
				
			    public Long mtime;

				public Long getMtime () {
					return this.mtime;
				}
				
			    public String mtime_string;

				public String getMtime_string () {
					return this.mtime_string;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_TEST_job_general.length) {
				if(length < 1024 && commonByteArray_TEST_job_general.length == 0) {
   					commonByteArray_TEST_job_general = new byte[1024];
				} else {
   					commonByteArray_TEST_job_general = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_TEST_job_general, 0, length);
			strReturn = new String(commonByteArray_TEST_job_general, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_TEST_job_general) {

        	try {

        		int length = 0;
		
					this.abs_path = readString(dis);
					
					this.dirname = readString(dis);
					
					this.basename = readString(dis);
					
					this.mode_string = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.size = null;
           				} else {
           			    	this.size = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.mtime = null;
           				} else {
           			    	this.mtime = dis.readLong();
           				}
					
					this.mtime_string = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.abs_path,dos);
					
					// String
				
						writeString(this.dirname,dos);
					
					// String
				
						writeString(this.basename,dos);
					
					// String
				
						writeString(this.mode_string,dos);
					
					// Long
				
						if(this.size == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.size);
		            	}
					
					// Long
				
						if(this.mtime == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.mtime);
		            	}
					
					// String
				
						writeString(this.mtime_string,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("abs_path="+abs_path);
		sb.append(",dirname="+dirname);
		sb.append(",basename="+basename);
		sb.append(",mode_string="+mode_string);
		sb.append(",size="+String.valueOf(size));
		sb.append(",mtime="+String.valueOf(mtime));
		sb.append(",mtime_string="+mtime_string);
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				if(abs_path == null){
        					sb.append("<null>");
        				}else{
            				sb.append(abs_path);
            			}
            		
        			sb.append("|");
        		
        				if(dirname == null){
        					sb.append("<null>");
        				}else{
            				sb.append(dirname);
            			}
            		
        			sb.append("|");
        		
        				if(basename == null){
        					sb.append("<null>");
        				}else{
            				sb.append(basename);
            			}
            		
        			sb.append("|");
        		
        				if(mode_string == null){
        					sb.append("<null>");
        				}else{
            				sb.append(mode_string);
            			}
            		
        			sb.append("|");
        		
        				if(size == null){
        					sb.append("<null>");
        				}else{
            				sb.append(size);
            			}
            		
        			sb.append("|");
        		
        				if(mtime == null){
        					sb.append("<null>");
        				}else{
            				sb.append(mtime);
            			}
            		
        			sb.append("|");
        		
        				if(mtime_string == null){
        					sb.append("<null>");
        				}else{
            				sb.append(mtime_string);
            			}
            		
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(row2Struct other) {

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

public static class row5Struct implements routines.system.IPersistableRow<row5Struct> {
    final static byte[] commonByteArrayLock_TEST_job_general = new byte[0];
    static byte[] commonByteArray_TEST_job_general = new byte[0];

	
			    public String repertoire_ftp;

				public String getRepertoire_ftp () {
					return this.repertoire_ftp;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_TEST_job_general.length) {
				if(length < 1024 && commonByteArray_TEST_job_general.length == 0) {
   					commonByteArray_TEST_job_general = new byte[1024];
				} else {
   					commonByteArray_TEST_job_general = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_TEST_job_general, 0, length);
			strReturn = new String(commonByteArray_TEST_job_general, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_TEST_job_general) {

        	try {

        		int length = 0;
		
					this.repertoire_ftp = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.repertoire_ftp,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("repertoire_ftp="+repertoire_ftp);
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				if(repertoire_ftp == null){
        					sb.append("<null>");
        				}else{
            				sb.append(repertoire_ftp);
            			}
            		
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(row5Struct other) {

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
public void tDBInput_2Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBInput_2_SUBPROCESS_STATE", 0);

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



		row5Struct row5 = new row5Struct();
row2Struct row2 = new row2Struct();
row2Struct row1 = row2;




	
	/**
	 * [tFlowToIterate_1 begin ] start
	 */

				
			int NB_ITERATE_tFileList_2 = 0; //for statistics
			

	
		
		ok_Hash.put("tFlowToIterate_1", false);
		start_Hash.put("tFlowToIterate_1", System.currentTimeMillis());
		
	
	currentComponent="tFlowToIterate_1";

	
			if (execStat) {
				if(resourceMap.get("inIterateVComp") == null){
					
						runStat.updateStatOnConnection("row5" + iterateId, 0, 0);
					
				}
			} 

		
		int tos_count_tFlowToIterate_1 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tFlowToIterate_1 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tFlowToIterate_1{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tFlowToIterate_1 = new StringBuilder();
                    log4jParamters_tFlowToIterate_1.append("Parameters:");
                            log4jParamters_tFlowToIterate_1.append("DEFAULT_MAP" + " = " + "true");
                        log4jParamters_tFlowToIterate_1.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tFlowToIterate_1 - "  + (log4jParamters_tFlowToIterate_1) );
                    } 
                } 
            new BytesLimit65535_tFlowToIterate_1().limitLog4jByte();
            }

int nb_line_tFlowToIterate_1 = 0;
int counter_tFlowToIterate_1 = 0;

 



/**
 * [tFlowToIterate_1 begin ] stop
 */



	
	/**
	 * [tDBInput_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBInput_2", false);
		start_Hash.put("tDBInput_2", System.currentTimeMillis());
		
	
	currentComponent="tDBInput_2";

	
		int tos_count_tDBInput_2 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tDBInput_2 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tDBInput_2{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tDBInput_2 = new StringBuilder();
                    log4jParamters_tDBInput_2.append("Parameters:");
                            log4jParamters_tDBInput_2.append("USE_EXISTING_CONNECTION" + " = " + "true");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("CONNECTION" + " = " + "tDBConnection_1");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("TABLE" + " = " + "\"PARTENAIRE\"");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("QUERYSTORE" + " = " + "\"\"");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("QUERY" + " = " + "\"select repertoire_ftp from partenaire;\"");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("TRIM_ALL_COLUMN" + " = " + "false");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("TRIM_COLUMN" + " = " + "[{TRIM="+("false")+", SCHEMA_COLUMN="+("repertoire_ftp")+"}]");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("UNIFIED_COMPONENTS" + " = " + "tMSSqlInput");
                        log4jParamters_tDBInput_2.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tDBInput_2 - "  + (log4jParamters_tDBInput_2) );
                    } 
                } 
            new BytesLimit65535_tDBInput_2().limitLog4jByte();
            }
	
    
	
			org.talend.designer.components.util.mssql.MSSqlGenerateTimestampUtil mssqlGTU_tDBInput_2 = org.talend.designer.components.util.mssql.MSSqlUtilFactory.getMSSqlGenerateTimestampUtil();
			
			java.util.List<String> talendToDBList_tDBInput_2 = new java.util.ArrayList();
			String[] talendToDBArray_tDBInput_2  = new String[]{"FLOAT","NUMERIC","NUMERIC IDENTITY","DECIMAL","DECIMAL IDENTITY","REAL"}; 
			java.util.Collections.addAll(talendToDBList_tDBInput_2, talendToDBArray_tDBInput_2); 
		    int nb_line_tDBInput_2 = 0;
		    java.sql.Connection conn_tDBInput_2 = null;
		        conn_tDBInput_2 = (java.sql.Connection)globalMap.get("conn_tDBConnection_1");
				if(conn_tDBInput_2 != null) {
					if(conn_tDBInput_2.getMetaData() != null) {
						
							log.debug("tDBInput_2 - Uses an existing connection with username '" + conn_tDBInput_2.getMetaData().getUserName() + "'. Connection URL: " + conn_tDBInput_2.getMetaData().getURL() + ".");
						
					}
				}
			
			String dbschema_tDBInput_2 = (String)globalMap.get("dbschema_tDBConnection_1");
		    
			java.sql.Statement stmt_tDBInput_2 = conn_tDBInput_2.createStatement();

		    String dbquery_tDBInput_2 = "select repertoire_ftp from partenaire;";
			
                log.debug("tDBInput_2 - Executing the query: '"+dbquery_tDBInput_2+"'.");
			

            	globalMap.put("tDBInput_2_QUERY",dbquery_tDBInput_2);
		    java.sql.ResultSet rs_tDBInput_2 = null;

		    try {
		    	rs_tDBInput_2 = stmt_tDBInput_2.executeQuery(dbquery_tDBInput_2);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_2 = rs_tDBInput_2.getMetaData();
		    	int colQtyInRs_tDBInput_2 = rsmd_tDBInput_2.getColumnCount();

		    String tmpContent_tDBInput_2 = null;
		    
		    
		    	log.debug("tDBInput_2 - Retrieving records from the database.");
		    
		    while (rs_tDBInput_2.next()) {
		        nb_line_tDBInput_2++;
		        
							if(colQtyInRs_tDBInput_2 < 1) {
								row5.repertoire_ftp = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(1);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(1).toUpperCase(java.util.Locale.ENGLISH))) {
            		row5.repertoire_ftp = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row5.repertoire_ftp = tmpContent_tDBInput_2;
                }
            } else {
                row5.repertoire_ftp = null;
            }
		                    }
					
						log.debug("tDBInput_2 - Retrieving the record " + nb_line_tDBInput_2 + ".");
					





 



/**
 * [tDBInput_2 begin ] stop
 */
	
	/**
	 * [tDBInput_2 main ] start
	 */

	

	
	
	currentComponent="tDBInput_2";

	

 


	tos_count_tDBInput_2++;

/**
 * [tDBInput_2 main ] stop
 */
	
	/**
	 * [tDBInput_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_2";

	

 



/**
 * [tDBInput_2 process_data_begin ] stop
 */

	
	/**
	 * [tFlowToIterate_1 main ] start
	 */

	

	
	
	currentComponent="tFlowToIterate_1";

	

			//row5
			//row5


			
				if(execStat){
					runStat.updateStatOnConnection("row5"+iterateId,1, 1);
				} 
			

		
    			if(log.isTraceEnabled()){
    				log.trace("row5 - " + (row5==null? "": row5.toLogString()));
    			}
    		


    	
                if(log.isTraceEnabled())
            log.trace("tFlowToIterate_1 - "  + ("Set global var, key=row5.repertoire_ftp, value=")  + (row5.repertoire_ftp)  + (".") );            
            globalMap.put("row5.repertoire_ftp", row5.repertoire_ftp);
    	
 
	   nb_line_tFlowToIterate_1++;  
       counter_tFlowToIterate_1++;
                if(log.isDebugEnabled())
            log.debug("tFlowToIterate_1 - "  + ("Current iteration is: ")  + (counter_tFlowToIterate_1)  + (".") );
       globalMap.put("tFlowToIterate_1_CURRENT_ITERATION", counter_tFlowToIterate_1);
 


	tos_count_tFlowToIterate_1++;

/**
 * [tFlowToIterate_1 main ] stop
 */
	
	/**
	 * [tFlowToIterate_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tFlowToIterate_1";

	

 



/**
 * [tFlowToIterate_1 process_data_begin ] stop
 */
	NB_ITERATE_tFileList_2++;
	
	
					if(execStat){				
	       				runStat.updateStatOnConnection("row2", 3, 0);
					}           			
				
					if(execStat){				
	       				runStat.updateStatOnConnection("row1", 3, 0);
					}           			
				
					if(execStat){				
	       				runStat.updateStatOnConnection("iterate4", 3, 0);
					}           			
				
					if(execStat){				
	       				runStat.updateStatOnConnection("iterate5", 3, 0);
					}           			
				
				if(execStat){
					runStat.updateStatOnConnection("iterate3", 1, "exec" + NB_ITERATE_tFileList_2);
					//Thread.sleep(1000);
				}				
			

	
	/**
	 * [tFileList_2 begin ] start
	 */

				
			int NB_ITERATE_tFileProperties_2 = 0; //for statistics
						
			int NB_ITERATE_tFileRowCount_1 = 0; //for statistics
			

	
		
		ok_Hash.put("tFileList_2", false);
		start_Hash.put("tFileList_2", System.currentTimeMillis());
		
	
	currentComponent="tFileList_2";

	
		int tos_count_tFileList_2 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tFileList_2 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tFileList_2{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tFileList_2 = new StringBuilder();
                    log4jParamters_tFileList_2.append("Parameters:");
                            log4jParamters_tFileList_2.append("DIRECTORY" + " = " + "((String)globalMap.get(\"row5.repertoire_ftp\"))");
                        log4jParamters_tFileList_2.append(" | ");
                            log4jParamters_tFileList_2.append("LIST_MODE" + " = " + "FILES");
                        log4jParamters_tFileList_2.append(" | ");
                            log4jParamters_tFileList_2.append("INCLUDSUBDIR" + " = " + "false");
                        log4jParamters_tFileList_2.append(" | ");
                            log4jParamters_tFileList_2.append("CASE_SENSITIVE" + " = " + "YES");
                        log4jParamters_tFileList_2.append(" | ");
                            log4jParamters_tFileList_2.append("ERROR" + " = " + "false");
                        log4jParamters_tFileList_2.append(" | ");
                            log4jParamters_tFileList_2.append("GLOBEXPRESSIONS" + " = " + "true");
                        log4jParamters_tFileList_2.append(" | ");
                            log4jParamters_tFileList_2.append("FILES" + " = " + "[]");
                        log4jParamters_tFileList_2.append(" | ");
                            log4jParamters_tFileList_2.append("ORDER_BY_NOTHING" + " = " + "true");
                        log4jParamters_tFileList_2.append(" | ");
                            log4jParamters_tFileList_2.append("ORDER_BY_FILENAME" + " = " + "false");
                        log4jParamters_tFileList_2.append(" | ");
                            log4jParamters_tFileList_2.append("ORDER_BY_FILESIZE" + " = " + "false");
                        log4jParamters_tFileList_2.append(" | ");
                            log4jParamters_tFileList_2.append("ORDER_BY_MODIFIEDDATE" + " = " + "false");
                        log4jParamters_tFileList_2.append(" | ");
                            log4jParamters_tFileList_2.append("ORDER_ACTION_ASC" + " = " + "true");
                        log4jParamters_tFileList_2.append(" | ");
                            log4jParamters_tFileList_2.append("ORDER_ACTION_DESC" + " = " + "false");
                        log4jParamters_tFileList_2.append(" | ");
                            log4jParamters_tFileList_2.append("IFEXCLUDE" + " = " + "false");
                        log4jParamters_tFileList_2.append(" | ");
                            log4jParamters_tFileList_2.append("FORMAT_FILEPATH_TO_SLASH" + " = " + "false");
                        log4jParamters_tFileList_2.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tFileList_2 - "  + (log4jParamters_tFileList_2) );
                    } 
                } 
            new BytesLimit65535_tFileList_2().limitLog4jByte();
            }
	
 
  
				final StringBuffer log4jSb_tFileList_2 = new StringBuffer();
			   
    
  String directory_tFileList_2 = ((String)globalMap.get("row5.repertoire_ftp"));
  final java.util.List<String> maskList_tFileList_2 = new java.util.ArrayList<String>();
  final java.util.List<java.util.regex.Pattern> patternList_tFileList_2 = new java.util.ArrayList<java.util.regex.Pattern>();
      maskList_tFileList_2.add("*");  
  for (final String filemask_tFileList_2 : maskList_tFileList_2) {
	String filemask_compile_tFileList_2 = filemask_tFileList_2;
	
		filemask_compile_tFileList_2 = org.apache.oro.text.GlobCompiler.globToPerl5(filemask_tFileList_2.toCharArray(), org.apache.oro.text.GlobCompiler.DEFAULT_MASK);
	
		java.util.regex.Pattern fileNamePattern_tFileList_2 = java.util.regex.Pattern.compile(filemask_compile_tFileList_2);
	patternList_tFileList_2.add(fileNamePattern_tFileList_2);
  }
  int NB_FILEtFileList_2 = 0;

  final boolean case_sensitive_tFileList_2 = true;
    final java.util.List<java.io.File> list_tFileList_2 = new java.util.ArrayList<java.io.File>();
    final java.util.Set<String> filePath_tFileList_2 = new java.util.HashSet<String>();
	java.io.File file_tFileList_2 = new java.io.File(directory_tFileList_2);
     
		file_tFileList_2.listFiles(new java.io.FilenameFilter() {
			public boolean accept(java.io.File dir, String name) {
				java.io.File file = new java.io.File(dir, name);
                if (!file.isDirectory()) {
                	
    	String fileName_tFileList_2 = file.getName();
		for (final java.util.regex.Pattern fileNamePattern_tFileList_2 : patternList_tFileList_2) {
          	if (fileNamePattern_tFileList_2.matcher(fileName_tFileList_2).matches()){
					if(!filePath_tFileList_2.contains(file.getAbsolutePath())) {
			          list_tFileList_2.add(file);
			          filePath_tFileList_2.add(file.getAbsolutePath());
			        }
			}
		}
                }
              return true;
            }
          }
      ); 
      java.util.Collections.sort(list_tFileList_2);
    
		log.info("tFileList_2 - Start to list files");
	
    for (int i_tFileList_2 = 0; i_tFileList_2 < list_tFileList_2.size(); i_tFileList_2++){
      java.io.File files_tFileList_2 = list_tFileList_2.get(i_tFileList_2);
      String fileName_tFileList_2 = files_tFileList_2.getName();
      
      String currentFileName_tFileList_2 = files_tFileList_2.getName(); 
      String currentFilePath_tFileList_2 = files_tFileList_2.getAbsolutePath();
      String currentFileDirectory_tFileList_2 = files_tFileList_2.getParent();
      String currentFileExtension_tFileList_2 = null;
      
      if (files_tFileList_2.getName().contains(".") && files_tFileList_2.isFile()){
        currentFileExtension_tFileList_2 = files_tFileList_2.getName().substring(files_tFileList_2.getName().lastIndexOf(".") + 1);
      } else{
        currentFileExtension_tFileList_2 = "";
      }
      
      NB_FILEtFileList_2 ++;
      globalMap.put("tFileList_2_CURRENT_FILE", currentFileName_tFileList_2);
      globalMap.put("tFileList_2_CURRENT_FILEPATH", currentFilePath_tFileList_2);
      globalMap.put("tFileList_2_CURRENT_FILEDIRECTORY", currentFileDirectory_tFileList_2);
      globalMap.put("tFileList_2_CURRENT_FILEEXTENSION", currentFileExtension_tFileList_2);
      globalMap.put("tFileList_2_NB_FILE", NB_FILEtFileList_2);
      
		log.info("tFileList_2 - Current file or directory path : " + currentFilePath_tFileList_2);
	  
 



/**
 * [tFileList_2 begin ] stop
 */
	
	/**
	 * [tFileList_2 main ] start
	 */

	

	
	
	currentComponent="tFileList_2";

	

 


	tos_count_tFileList_2++;

/**
 * [tFileList_2 main ] stop
 */
	
	/**
	 * [tFileList_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tFileList_2";

	

 



/**
 * [tFileList_2 process_data_begin ] stop
 */
	NB_ITERATE_tFileRowCount_1++;
	
	
				if(execStat){
					runStat.updateStatOnConnection("iterate5", 1, "exec" + NB_ITERATE_tFileRowCount_1);
					//Thread.sleep(1000);
				}				
			

	
	/**
	 * [tFileRowCount_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tFileRowCount_1", false);
		start_Hash.put("tFileRowCount_1", System.currentTimeMillis());
		
	
	currentComponent="tFileRowCount_1";

	
		int tos_count_tFileRowCount_1 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tFileRowCount_1 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tFileRowCount_1{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tFileRowCount_1 = new StringBuilder();
                    log4jParamters_tFileRowCount_1.append("Parameters:");
                            log4jParamters_tFileRowCount_1.append("FILENAME" + " = " + "((String)globalMap.get(\"tFileList_2_CURRENT_FILEPATH\"))");
                        log4jParamters_tFileRowCount_1.append(" | ");
                            log4jParamters_tFileRowCount_1.append("ROWSEPARATOR" + " = " + "\"\\r\\n\"");
                        log4jParamters_tFileRowCount_1.append(" | ");
                            log4jParamters_tFileRowCount_1.append("IGNORE_EMPTY_ROW" + " = " + "true");
                        log4jParamters_tFileRowCount_1.append(" | ");
                            log4jParamters_tFileRowCount_1.append("ENCODING" + " = " + "\"ISO-8859-15\"");
                        log4jParamters_tFileRowCount_1.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tFileRowCount_1 - "  + (log4jParamters_tFileRowCount_1) );
                    } 
                } 
            new BytesLimit65535_tFileRowCount_1().limitLog4jByte();
            }

 



/**
 * [tFileRowCount_1 begin ] stop
 */
	
	/**
	 * [tFileRowCount_1 main ] start
	 */

	

	
	
	currentComponent="tFileRowCount_1";

	


				final StringBuffer log4jSb_tFileRowCount_1 = new StringBuffer();
			
String tmp_tFileRowCount_1 = ((String)globalMap.get("tFileList_2_CURRENT_FILEPATH"));
int emptyLineCount_tFileRowCount_1 = 0;
if (tmp_tFileRowCount_1.toLowerCase().endsWith(".xlsx")) throw new RuntimeException("not support excel 2007");  
int lineCount_tFileRowCount_1 = 0;
if (tmp_tFileRowCount_1.toLowerCase().endsWith(".xls")){
  final jxl.WorkbookSettings wbs_tFileRowCount_1 = new jxl.WorkbookSettings();
  wbs_tFileRowCount_1.setEncoding("ISO-8859-15");
  final jxl.Workbook wb_tFileRowCount_1 = jxl.Workbook.getWorkbook(
      new java.io.BufferedInputStream(
          new java.io.FileInputStream(((String)globalMap.get("tFileList_2_CURRENT_FILEPATH")))), wbs_tFileRowCount_1);

  java.util.List<jxl.Sheet> sheets_tFileRowCount_1 = new java.util.ArrayList<jxl.Sheet>();;
  sheets_tFileRowCount_1 = java.util.Arrays.<jxl.Sheet> asList(wb_tFileRowCount_1.getSheets());
  
  if (sheets_tFileRowCount_1.size() <= 0){
    wb_tFileRowCount_1.close();
    throw new RuntimeException("Special sheets not exist!");
  } 
 
  for (jxl.Sheet sheet_tFileRowCount_1 : sheets_tFileRowCount_1) {
    int one_sheet_rows = sheet_tFileRowCount_1.getRows();
    lineCount_tFileRowCount_1 += one_sheet_rows;
  
    for (int i_tFileRowCount_1 = 0; i_tFileRowCount_1 < one_sheet_rows; i_tFileRowCount_1++){
      jxl.Cell[] sheet_row = sheet_tFileRowCount_1.getRow(i_tFileRowCount_1);
    
      boolean bIsEmptyRow = true;
      for (jxl.Cell cell: sheet_row){
        if (cell.getContents() != null){
          bIsEmptyRow = false;
          break;
        }
      }
      emptyLineCount_tFileRowCount_1 += bIsEmptyRow ? 1 : 0;
    }
  }  
  wb_tFileRowCount_1.close();
  
} else{        					
  java.io.BufferedReader br_tFileRowCount_1 = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(((String)globalMap.get("tFileList_2_CURRENT_FILEPATH"))), "ISO-8859-15"));			
  String rowSeparator_tFileRowCount_1 = "\r\n";
  byte[] bytes_tFileRowCount_1 = rowSeparator_tFileRowCount_1.getBytes();
  int index_tFileRowCount_1 = 0, oneChar_tFileRowCount_1 = 0, tipEmptyLineCount_tFileRowCount_1 = 0; 
  boolean bTipEmptyFlagOpen_tFileRowCount_1 = true, bReadyEOF_tFileRowCount_1 = false;
		
  if(bytes_tFileRowCount_1.length > 0) {
    while ((oneChar_tFileRowCount_1 = br_tFileRowCount_1.read()) != -1) {
      if (oneChar_tFileRowCount_1 == bytes_tFileRowCount_1[index_tFileRowCount_1]) {
      
        if (index_tFileRowCount_1 < bytes_tFileRowCount_1.length - 1){
          index_tFileRowCount_1 ++ ;
          continue; // match next char
        }
        
        if (index_tFileRowCount_1 == bytes_tFileRowCount_1.length - 1) {                  
          lineCount_tFileRowCount_1++;
          if(bTipEmptyFlagOpen_tFileRowCount_1) {
            tipEmptyLineCount_tFileRowCount_1 ++;
            emptyLineCount_tFileRowCount_1 ++;
          }
          bReadyEOF_tFileRowCount_1 = false; // next row must be have char(or EOF flag)
          bTipEmptyFlagOpen_tFileRowCount_1 = true; 
          index_tFileRowCount_1 = 0;
        }
        
      }else{      
        bReadyEOF_tFileRowCount_1 = true;
        bTipEmptyFlagOpen_tFileRowCount_1 = false;
        tipEmptyLineCount_tFileRowCount_1 = 0;
        index_tFileRowCount_1 = 0;        
      }
    }
    
    if (bReadyEOF_tFileRowCount_1) lineCount_tFileRowCount_1 ++ ; // add last row if not end by row separator
    
    if (bTipEmptyFlagOpen_tFileRowCount_1) {
      lineCount_tFileRowCount_1 -= tipEmptyLineCount_tFileRowCount_1;
      emptyLineCount_tFileRowCount_1 -= tipEmptyLineCount_tFileRowCount_1;
    }          
  }
  br_tFileRowCount_1.close();
} 
  lineCount_tFileRowCount_1 -= emptyLineCount_tFileRowCount_1;   

  globalMap.put("tFileRowCount_1_COUNT",lineCount_tFileRowCount_1);
  
    log.info("tFileRowCount_1 - File : " + ((String)globalMap.get("tFileList_2_CURRENT_FILEPATH")) + " row count is " + lineCount_tFileRowCount_1); 


 


	tos_count_tFileRowCount_1++;

/**
 * [tFileRowCount_1 main ] stop
 */
	
	/**
	 * [tFileRowCount_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tFileRowCount_1";

	

 



/**
 * [tFileRowCount_1 process_data_begin ] stop
 */
	
	/**
	 * [tFileRowCount_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tFileRowCount_1";

	

 



/**
 * [tFileRowCount_1 process_data_end ] stop
 */
	
	/**
	 * [tFileRowCount_1 end ] start
	 */

	

	
	
	currentComponent="tFileRowCount_1";

	

 
                if(log.isDebugEnabled())
            log.debug("tFileRowCount_1 - "  + ("Done.") );

ok_Hash.put("tFileRowCount_1", true);
end_Hash.put("tFileRowCount_1", System.currentTimeMillis());




/**
 * [tFileRowCount_1 end ] stop
 */
						if(execStat){
							runStat.updateStatOnConnection("iterate5", 2, "exec" + NB_ITERATE_tFileRowCount_1);
						}				
					




	NB_ITERATE_tFileProperties_2++;
	
	
					if(execStat){				
	       				runStat.updateStatOnConnection("row2", 3, 0);
					}           			
				
					if(execStat){				
	       				runStat.updateStatOnConnection("row1", 3, 0);
					}           			
				
				if(execStat){
					runStat.updateStatOnConnection("iterate4", 1, "exec" + NB_ITERATE_tFileProperties_2);
					//Thread.sleep(1000);
				}				
			



	
	/**
	 * [tRunJob_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tRunJob_1", false);
		start_Hash.put("tRunJob_1", System.currentTimeMillis());
		
	
	currentComponent="tRunJob_1";

	
			if (execStat) {
				if(resourceMap.get("inIterateVComp") == null){
					
						runStat.updateStatOnConnection("row1" + iterateId, 0, 0);
					
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
                            log4jParamters_tRunJob_1.append("USE_DYNAMIC_JOB" + " = " + "false");
                        log4jParamters_tRunJob_1.append(" | ");
                            log4jParamters_tRunJob_1.append("PROCESS" + " = " + "ssjob_init_fich_bdd");
                        log4jParamters_tRunJob_1.append(" | ");
                            log4jParamters_tRunJob_1.append("USE_INDEPENDENT_PROCESS" + " = " + "false");
                        log4jParamters_tRunJob_1.append(" | ");
                            log4jParamters_tRunJob_1.append("DIE_ON_CHILD_ERROR" + " = " + "false");
                        log4jParamters_tRunJob_1.append(" | ");
                            log4jParamters_tRunJob_1.append("TRANSMIT_WHOLE_CONTEXT" + " = " + "true");
                        log4jParamters_tRunJob_1.append(" | ");
                            log4jParamters_tRunJob_1.append("CONTEXTPARAMS" + " = " + "[{PARAM_NAME_COLUMN="+("file_name")+", PARAM_VALUE_COLUMN="+("row2.basename")+"}, {PARAM_NAME_COLUMN="+("rep_ftp")+", PARAM_VALUE_COLUMN="+("row2.dirname")+"}, {PARAM_NAME_COLUMN="+("nb_lignes")+", PARAM_VALUE_COLUMN="+("((Integer)globalMap.get(\"tFileRowCount_1_COUNT\"))")+"}]");
                        log4jParamters_tRunJob_1.append(" | ");
                            log4jParamters_tRunJob_1.append("PROPAGATE_CHILD_RESULT" + " = " + "false");
                        log4jParamters_tRunJob_1.append(" | ");
                            log4jParamters_tRunJob_1.append("PRINT_PARAMETER" + " = " + "false");
                        log4jParamters_tRunJob_1.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tRunJob_1 - "  + (log4jParamters_tRunJob_1) );
                    } 
                } 
            new BytesLimit65535_tRunJob_1().limitLog4jByte();
            }


 



/**
 * [tRunJob_1 begin ] stop
 */



	
	/**
	 * [tFileCopy_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tFileCopy_2", false);
		start_Hash.put("tFileCopy_2", System.currentTimeMillis());
		
	
	currentComponent="tFileCopy_2";

	
			if (execStat) {
				if(resourceMap.get("inIterateVComp") == null){
					
						runStat.updateStatOnConnection("row2" + iterateId, 0, 0);
					
				}
			} 

		
		int tos_count_tFileCopy_2 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tFileCopy_2 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tFileCopy_2{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tFileCopy_2 = new StringBuilder();
                    log4jParamters_tFileCopy_2.append("Parameters:");
                            log4jParamters_tFileCopy_2.append("FILENAME" + " = " + "((String)globalMap.get(\"tFileList_2_CURRENT_FILEPATH\"))");
                        log4jParamters_tFileCopy_2.append(" | ");
                            log4jParamters_tFileCopy_2.append("ENABLE_COPY_DIRECTORY" + " = " + "false");
                        log4jParamters_tFileCopy_2.append(" | ");
                            log4jParamters_tFileCopy_2.append("DESTINATION" + " = " + "context.rep_travail");
                        log4jParamters_tFileCopy_2.append(" | ");
                            log4jParamters_tFileCopy_2.append("RENAME" + " = " + "false");
                        log4jParamters_tFileCopy_2.append(" | ");
                            log4jParamters_tFileCopy_2.append("REMOVE_FILE" + " = " + "true");
                        log4jParamters_tFileCopy_2.append(" | ");
                            log4jParamters_tFileCopy_2.append("REPLACE_FILE" + " = " + "true");
                        log4jParamters_tFileCopy_2.append(" | ");
                            log4jParamters_tFileCopy_2.append("CREATE_DIRECTORY" + " = " + "true");
                        log4jParamters_tFileCopy_2.append(" | ");
                            log4jParamters_tFileCopy_2.append("FAILON" + " = " + "false");
                        log4jParamters_tFileCopy_2.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tFileCopy_2 - "  + (log4jParamters_tFileCopy_2) );
                    } 
                } 
            new BytesLimit65535_tFileCopy_2().limitLog4jByte();
            }

 



/**
 * [tFileCopy_2 begin ] stop
 */



	
	/**
	 * [tFileProperties_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tFileProperties_2", false);
		start_Hash.put("tFileProperties_2", System.currentTimeMillis());
		
	
	currentComponent="tFileProperties_2";

	
		int tos_count_tFileProperties_2 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tFileProperties_2 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tFileProperties_2{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tFileProperties_2 = new StringBuilder();
                    log4jParamters_tFileProperties_2.append("Parameters:");
                            log4jParamters_tFileProperties_2.append("FILENAME" + " = " + "((String)globalMap.get(\"tFileList_2_CURRENT_FILEPATH\"))");
                        log4jParamters_tFileProperties_2.append(" | ");
                            log4jParamters_tFileProperties_2.append("MD5" + " = " + "false");
                        log4jParamters_tFileProperties_2.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tFileProperties_2 - "  + (log4jParamters_tFileProperties_2) );
                    } 
                } 
            new BytesLimit65535_tFileProperties_2().limitLog4jByte();
            }


				final StringBuffer log4jSb_tFileProperties_2 = new StringBuffer();
			

java.io.File file_tFileProperties_2 = new java.io.File(((String)globalMap.get("tFileList_2_CURRENT_FILEPATH")));
row2 = new row2Struct();

if(file_tFileProperties_2.exists()) {
    row2.abs_path = file_tFileProperties_2.getAbsolutePath();
    row2.dirname = file_tFileProperties_2.getParent();
    row2.basename = file_tFileProperties_2.getName();
    String r_tFileProperties_2 = (file_tFileProperties_2.canRead())?"r":"-";
	String w_tFileProperties_2 = (file_tFileProperties_2.canWrite())?"w":"-";
	//String x_ = (file_.canExecute())?"x":"-"; /*since JDK1.6*/
    row2.mode_string = r_tFileProperties_2 + w_tFileProperties_2;
    row2.size = file_tFileProperties_2.length();
    row2.mtime = file_tFileProperties_2.lastModified();
    row2.mtime_string =(new java.util.Date(file_tFileProperties_2.lastModified())).toString();
	
	
}
	else {
		log.info("tFileProperties_2 - File : " + file_tFileProperties_2.getAbsolutePath() + " doesn't exist.");
	}
 



/**
 * [tFileProperties_2 begin ] stop
 */
	
	/**
	 * [tFileProperties_2 main ] start
	 */

	

	
	
	currentComponent="tFileProperties_2";

	

 


	tos_count_tFileProperties_2++;

/**
 * [tFileProperties_2 main ] stop
 */
	
	/**
	 * [tFileProperties_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tFileProperties_2";

	

 



/**
 * [tFileProperties_2 process_data_begin ] stop
 */

	
	/**
	 * [tFileCopy_2 main ] start
	 */

	

	
	
	currentComponent="tFileCopy_2";

	

			//row2
			//row2


			
				if(execStat){
					runStat.updateStatOnConnection("row2"+iterateId,1, 1);
				} 
			

		
    			if(log.isTraceEnabled()){
    				log.trace("row2 - " + (row2==null? "": row2.toLogString()));
    			}
    		

 

				final StringBuffer log4jSb_tFileCopy_2 = new StringBuffer();
			

        String srcFileName_tFileCopy_2 = ((String)globalMap.get("tFileList_2_CURRENT_FILEPATH"));

		java.io.File srcFile_tFileCopy_2 = new java.io.File(srcFileName_tFileCopy_2);

		// here need check first, before mkdirs().
		if (!srcFile_tFileCopy_2.exists() || !srcFile_tFileCopy_2.isFile()) {
			String errorMessageFileDoesnotExistsOrIsNotAFile_tFileCopy_2 = String.format("The source File \"%s\" does not exist or is not a file.", srcFileName_tFileCopy_2);
				log.error(errorMessageFileDoesnotExistsOrIsNotAFile_tFileCopy_2);
		}
        String desDirName_tFileCopy_2 = context.rep_travail;

		String desFileName_tFileCopy_2 =  srcFile_tFileCopy_2.getName() ;

		if (desFileName_tFileCopy_2 != null && ("").equals(desFileName_tFileCopy_2.trim())){
			desFileName_tFileCopy_2 = "NewName.temp";
		}

		java.io.File desFile_tFileCopy_2 = new java.io.File(desDirName_tFileCopy_2, desFileName_tFileCopy_2);

		if (!srcFile_tFileCopy_2.getPath().equals(desFile_tFileCopy_2.getPath())  ) {
				java.io.File parentFile_tFileCopy_2 = desFile_tFileCopy_2.getParentFile();

				if (parentFile_tFileCopy_2 != null && !parentFile_tFileCopy_2.exists()) {
					parentFile_tFileCopy_2.mkdirs();
				}           
				try {
					org.talend.FileCopy.copyFile(srcFile_tFileCopy_2.getPath(), desFile_tFileCopy_2.getPath(), true);
				} catch (Exception e) {
						log.error("tFileCopy_2 " + e.getMessage());
				}
				java.io.File isRemoved_tFileCopy_2 = new java.io.File(((String)globalMap.get("tFileList_2_CURRENT_FILEPATH")));
				if(isRemoved_tFileCopy_2.exists()) {
					String errorMessageCouldNotRemoveFile_tFileCopy_2 = String.format("tFileCopy_2 - The source file \"%s\" could not be removed from the folder because it is open or you only have read-only rights.", srcFileName_tFileCopy_2);
						log.error(errorMessageCouldNotRemoveFile_tFileCopy_2);
				} 
				else {
					log.info("tFileCopy_2 - The source file \"" + srcFileName_tFileCopy_2 + "\" is deleted.");
				}

		}
		globalMap.put("tFileCopy_2_DESTINATION_FILEPATH",desFile_tFileCopy_2.getPath()); 
		globalMap.put("tFileCopy_2_DESTINATION_FILENAME",desFile_tFileCopy_2.getName()); 

		globalMap.put("tFileCopy_2_SOURCE_DIRECTORY", srcFile_tFileCopy_2.getParent());
		globalMap.put("tFileCopy_2_DESTINATION_DIRECTORY", desFile_tFileCopy_2.getParent());        
        

 
     row1 = row2;


	tos_count_tFileCopy_2++;

/**
 * [tFileCopy_2 main ] stop
 */
	
	/**
	 * [tFileCopy_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tFileCopy_2";

	

 



/**
 * [tFileCopy_2 process_data_begin ] stop
 */

	
	/**
	 * [tRunJob_1 main ] start
	 */

	

	
	
	currentComponent="tRunJob_1";

	

			//row1
			//row1


			
				if(execStat){
					runStat.updateStatOnConnection("row1"+iterateId,1, 1);
				} 
			

		
    			if(log.isTraceEnabled()){
    				log.trace("row1 - " + (row1==null? "": row1.toLogString()));
    			}
    		
	java.util.List<String> paraList_tRunJob_1 = new java.util.ArrayList<String>();
	
	        			paraList_tRunJob_1.add("--father_pid="+pid);
	      			
	        			paraList_tRunJob_1.add("--root_pid="+rootPid);
	      			
	        			paraList_tRunJob_1.add("--father_node=tRunJob_1");
	      			
	        			paraList_tRunJob_1.add("--context=Default");
	      			
			if(!"".equals(log4jLevel)){
				paraList_tRunJob_1.add("--log4jLevel="+log4jLevel);
			}
		
	//for feature:10589
	
		paraList_tRunJob_1.add("--stat_port=" + portStats);
	

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
		
			parentContextMap_tRunJob_1.put("FILES", context.FILES);
			paraList_tRunJob_1.add("--context_type " + "FILES" + "=" + "id_String");
		
			parentContextMap_tRunJob_1.put("rep_archivage", context.rep_archivage);
			paraList_tRunJob_1.add("--context_type " + "rep_archivage" + "=" + "id_String");
		
			parentContextMap_tRunJob_1.put("rep_rejet_N1", context.rep_rejet_N1);
			paraList_tRunJob_1.add("--context_type " + "rep_rejet_N1" + "=" + "id_String");
		
			parentContextMap_tRunJob_1.put("rep_travail", context.rep_travail);
			paraList_tRunJob_1.add("--context_type " + "rep_travail" + "=" + "id_String");
		
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

	
		obj_tRunJob_1 = row2.basename;
		if(obj_tRunJob_1!=null) {
			paraList_tRunJob_1.add("--context_param file_name=" + RuntimeUtils.tRunJobConvertContext(obj_tRunJob_1));
		} else {
			paraList_tRunJob_1.add("--context_param file_name=" + NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY);
		}
		
		parentContextMap_tRunJob_1.put("file_name", obj_tRunJob_1);
	
		obj_tRunJob_1 = row2.dirname;
		if(obj_tRunJob_1!=null) {
			paraList_tRunJob_1.add("--context_param rep_ftp=" + RuntimeUtils.tRunJobConvertContext(obj_tRunJob_1));
		} else {
			paraList_tRunJob_1.add("--context_param rep_ftp=" + NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY);
		}
		
		parentContextMap_tRunJob_1.put("rep_ftp", obj_tRunJob_1);
	
		obj_tRunJob_1 = ((Integer)globalMap.get("tFileRowCount_1_COUNT"));
		if(obj_tRunJob_1!=null) {
			paraList_tRunJob_1.add("--context_param nb_lignes=" + RuntimeUtils.tRunJobConvertContext(obj_tRunJob_1));
		} else {
			paraList_tRunJob_1.add("--context_param nb_lignes=" + NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY);
		}
		
		parentContextMap_tRunJob_1.put("nb_lignes", obj_tRunJob_1);
	
	
		test.ssjob_init_fich_bdd_0_1.ssjob_init_fich_bdd childJob_tRunJob_1 = new test.ssjob_init_fich_bdd_0_1.ssjob_init_fich_bdd();
	    // pass DataSources
	    java.util.Map<String, routines.system.TalendDataSource> talendDataSources_tRunJob_1 = (java.util.Map<String, routines.system.TalendDataSource>) globalMap
	            .get(KEY_DB_DATASOURCES);
	    if (null != talendDataSources_tRunJob_1) {
	        java.util.Map<String, javax.sql.DataSource> dataSources_tRunJob_1 = new java.util.HashMap<String, javax.sql.DataSource>();
	        for (java.util.Map.Entry<String, routines.system.TalendDataSource> talendDataSourceEntry_tRunJob_1 : talendDataSources_tRunJob_1
			        .entrySet()) {
	            dataSources_tRunJob_1.put(talendDataSourceEntry_tRunJob_1.getKey(),
	                    talendDataSourceEntry_tRunJob_1.getValue().getRawDataSource());
	        }
	        childJob_tRunJob_1.setDataSources(dataSources_tRunJob_1);
	    }
		  
			childJob_tRunJob_1.parentContextMap = parentContextMap_tRunJob_1;
		  
		
			log.info("tRunJob_1 - The child job 'test.ssjob_init_fich_bdd_0_1.ssjob_init_fich_bdd' starts on the version '0.1' with the context 'Default'.");
		
		String[][] childReturn_tRunJob_1 = childJob_tRunJob_1.runJob((String[]) paraList_tRunJob_1.toArray(new String[paraList_tRunJob_1.size()]));
		
			log.info("tRunJob_1 - The child job 'test.ssjob_init_fich_bdd_0_1.ssjob_init_fich_bdd' is done.");
		
	  	
				errorCode = childJob_tRunJob_1.getErrorCode();
		    
	            
	    	if(childJob_tRunJob_1.getErrorCode() == null){
				globalMap.put("tRunJob_1_CHILD_RETURN_CODE", childJob_tRunJob_1.getStatus() != null && ("failure").equals(childJob_tRunJob_1.getStatus()) ? 1 : 0);
	    	}else{
				globalMap.put("tRunJob_1_CHILD_RETURN_CODE", childJob_tRunJob_1.getErrorCode());
		    }
		    if (childJob_tRunJob_1.getExceptionStackTrace() != null) { 
		    	globalMap.put("tRunJob_1_CHILD_EXCEPTION_STACKTRACE", childJob_tRunJob_1.getExceptionStackTrace());
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
	 * [tRunJob_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tRunJob_1";

	

 



/**
 * [tRunJob_1 process_data_end ] stop
 */



	
	/**
	 * [tFileCopy_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tFileCopy_2";

	

 



/**
 * [tFileCopy_2 process_data_end ] stop
 */



	
	/**
	 * [tFileProperties_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tFileProperties_2";

	

 



/**
 * [tFileProperties_2 process_data_end ] stop
 */
	
	/**
	 * [tFileProperties_2 end ] start
	 */

	

	
	
	currentComponent="tFileProperties_2";

	

 
                if(log.isDebugEnabled())
            log.debug("tFileProperties_2 - "  + ("Done.") );

ok_Hash.put("tFileProperties_2", true);
end_Hash.put("tFileProperties_2", System.currentTimeMillis());




/**
 * [tFileProperties_2 end ] stop
 */

	
	/**
	 * [tFileCopy_2 end ] start
	 */

	

	
	
	currentComponent="tFileCopy_2";

	

			if(execStat){
				if(resourceMap.get("inIterateVComp") == null || !((Boolean)resourceMap.get("inIterateVComp"))){
			 		runStat.updateStatOnConnection("row2"+iterateId,2, 0); 
			 	}
			}
		
 
                if(log.isDebugEnabled())
            log.debug("tFileCopy_2 - "  + ("Done.") );

ok_Hash.put("tFileCopy_2", true);
end_Hash.put("tFileCopy_2", System.currentTimeMillis());




/**
 * [tFileCopy_2 end ] stop
 */

	
	/**
	 * [tRunJob_1 end ] start
	 */

	

	
	
	currentComponent="tRunJob_1";

	

			if(execStat){
				if(resourceMap.get("inIterateVComp") == null || !((Boolean)resourceMap.get("inIterateVComp"))){
			 		runStat.updateStatOnConnection("row1"+iterateId,2, 0); 
			 	}
			}
		
 
                if(log.isDebugEnabled())
            log.debug("tRunJob_1 - "  + ("Done.") );

ok_Hash.put("tRunJob_1", true);
end_Hash.put("tRunJob_1", System.currentTimeMillis());




/**
 * [tRunJob_1 end ] stop
 */






						if(execStat){
							runStat.updateStatOnConnection("iterate4", 2, "exec" + NB_ITERATE_tFileProperties_2);
						}				
					




	
	/**
	 * [tFileList_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tFileList_2";

	

 



/**
 * [tFileList_2 process_data_end ] stop
 */
	
	/**
	 * [tFileList_2 end ] start
	 */

	

	
	
	currentComponent="tFileList_2";

	

  
    }
  globalMap.put("tFileList_2_NB_FILE", NB_FILEtFileList_2);
  
    log.info("tFileList_2 - File or directory count : " + NB_FILEtFileList_2);

  
 

 
                if(log.isDebugEnabled())
            log.debug("tFileList_2 - "  + ("Done.") );

ok_Hash.put("tFileList_2", true);
end_Hash.put("tFileList_2", System.currentTimeMillis());




/**
 * [tFileList_2 end ] stop
 */
						if(execStat){
							runStat.updateStatOnConnection("iterate3", 2, "exec" + NB_ITERATE_tFileList_2);
						}				
					




	
	/**
	 * [tFlowToIterate_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tFlowToIterate_1";

	

 



/**
 * [tFlowToIterate_1 process_data_end ] stop
 */



	
	/**
	 * [tDBInput_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBInput_2";

	

 



/**
 * [tDBInput_2 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_2 end ] start
	 */

	

	
	
	currentComponent="tDBInput_2";

	

	}
}finally{
	if (rs_tDBInput_2 != null) {
		rs_tDBInput_2.close();
	}
	if (stmt_tDBInput_2 != null) {
		stmt_tDBInput_2.close();
	}
}
globalMap.put("tDBInput_2_NB_LINE",nb_line_tDBInput_2);
	    		log.debug("tDBInput_2 - Retrieved records count: "+nb_line_tDBInput_2 + " .");
			

 
                if(log.isDebugEnabled())
            log.debug("tDBInput_2 - "  + ("Done.") );

ok_Hash.put("tDBInput_2", true);
end_Hash.put("tDBInput_2", System.currentTimeMillis());




/**
 * [tDBInput_2 end ] stop
 */

	
	/**
	 * [tFlowToIterate_1 end ] start
	 */

	

	
	
	currentComponent="tFlowToIterate_1";

	

globalMap.put("tFlowToIterate_1_NB_LINE",nb_line_tFlowToIterate_1);
			if(execStat){
				if(resourceMap.get("inIterateVComp") == null || !((Boolean)resourceMap.get("inIterateVComp"))){
			 		runStat.updateStatOnConnection("row5"+iterateId,2, 0); 
			 	}
			}
		
 
                if(log.isDebugEnabled())
            log.debug("tFlowToIterate_1 - "  + ("Done.") );

ok_Hash.put("tFlowToIterate_1", true);
end_Hash.put("tFlowToIterate_1", System.currentTimeMillis());




/**
 * [tFlowToIterate_1 end ] stop
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
	 * [tDBInput_2 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_2";

	

 



/**
 * [tDBInput_2 finally ] stop
 */

	
	/**
	 * [tFlowToIterate_1 finally ] start
	 */

	

	
	
	currentComponent="tFlowToIterate_1";

	

 



/**
 * [tFlowToIterate_1 finally ] stop
 */

	
	/**
	 * [tFileList_2 finally ] start
	 */

	

	
	
	currentComponent="tFileList_2";

	

 



/**
 * [tFileList_2 finally ] stop
 */

	
	/**
	 * [tFileRowCount_1 finally ] start
	 */

	

	
	
	currentComponent="tFileRowCount_1";

	

 



/**
 * [tFileRowCount_1 finally ] stop
 */




	
	/**
	 * [tFileProperties_2 finally ] start
	 */

	

	
	
	currentComponent="tFileProperties_2";

	

 



/**
 * [tFileProperties_2 finally ] stop
 */

	
	/**
	 * [tFileCopy_2 finally ] start
	 */

	

	
	
	currentComponent="tFileCopy_2";

	

 



/**
 * [tFileCopy_2 finally ] stop
 */

	
	/**
	 * [tRunJob_1 finally ] start
	 */

	

	
	
	currentComponent="tRunJob_1";

	

 



/**
 * [tRunJob_1 finally ] stop
 */















				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBInput_2_SUBPROCESS_STATE", 1);
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
        final job_general job_generalClass = new job_general();

        int exitCode = job_generalClass.runJobInTOS(args);
	        if(exitCode==0){
		        log.info("TalendJob: 'job_general' - Done.");
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
        	log.info("TalendJob: 'job_general' - Start.");
    	

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
            java.io.InputStream inContext = job_general.class.getClassLoader().getResourceAsStream("test/job_general_0_1/contexts/" + contextStr + ".properties");
            if (inContext == null) {
                inContext = job_general.class.getClassLoader().getResourceAsStream("config/contexts/" + contextStr + ".properties");
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
				    context.setContextType("FILES", "id_String");
				
                context.FILES=(String) context.getProperty("FILES");
				    context.setContextType("rep_archivage", "id_String");
				
                context.rep_archivage=(String) context.getProperty("rep_archivage");
				    context.setContextType("rep_rejet_N1", "id_String");
				
                context.rep_rejet_N1=(String) context.getProperty("rep_rejet_N1");
				    context.setContextType("rep_travail", "id_String");
				
                context.rep_travail=(String) context.getProperty("rep_travail");
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
        if (parentContextMap != null && !parentContextMap.isEmpty()) {if (parentContextMap.containsKey("FILES")) {
                context.FILES = (String) parentContextMap.get("FILES");
            }if (parentContextMap.containsKey("rep_archivage")) {
                context.rep_archivage = (String) parentContextMap.get("rep_archivage");
            }if (parentContextMap.containsKey("rep_rejet_N1")) {
                context.rep_rejet_N1 = (String) parentContextMap.get("rep_rejet_N1");
            }if (parentContextMap.containsKey("rep_travail")) {
                context.rep_travail = (String) parentContextMap.get("rep_travail");
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
errorCode = null;tDBInput_2Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tDBInput_2) {
globalMap.put("tDBInput_2_SUBPROCESS_STATE", -1);

e_tDBInput_2.printStackTrace();

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
            System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : job_general");
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
 *     125000 characters generated by Talend Cloud Data Management Platform 
 *     on the September 13, 2019 3:22:44 PM CEST
 ************************************************************************************************/