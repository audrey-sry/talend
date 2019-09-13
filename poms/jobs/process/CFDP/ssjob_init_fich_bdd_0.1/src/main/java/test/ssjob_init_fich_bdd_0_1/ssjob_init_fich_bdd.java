
package test.ssjob_init_fich_bdd_0_1;

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
 




	//the import part of tJavaFlex_1
	//import java.util.List;

	//the import part of tJava_2
	//import java.util.List;

	//the import part of tJavaFlex_2
	//import java.util.List;


@SuppressWarnings("unused")

/**
 * Job: ssjob_init_fich_bdd Purpose: <br>
 * Description:  <br>
 * @author user@talend.com
 * @version 7.1.1.20190228_0243-patch
 * @status 
 */
public class ssjob_init_fich_bdd implements TalendJob {
	static {System.setProperty("TalendJob.log", "ssjob_init_fich_bdd.log");}
	private static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(ssjob_init_fich_bdd.class);

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
	private final String jobName = "ssjob_init_fich_bdd";
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
				ssjob_init_fich_bdd.this.exception = e;
			}
		}
		if (!(e instanceof TalendException)) {
		try {
			for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
				if (m.getName().compareTo(currentComponent + "_error") == 0) {
					m.invoke(ssjob_init_fich_bdd.this, new Object[] { e , currentComponent, globalMap});
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
			
			public void tJavaFlex_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tJavaFlex_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBRow_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
						try {
							
								if(this.execStat){
									runStat.updateStatOnConnection("OnComponentError2", 0, "error");
								}
							
							
								errorCode = null;
								tJava_2Process(globalMap);
								if (!"failure".equals(status)) {
									status = "end";
								}
								

						} catch (Exception e) {
							e.printStackTrace();
						}
						
					tJavaFlex_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tJava_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tJava_2_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tJavaFlex_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tRunJob_3_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tRunJob_3_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tRunJob_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tRunJob_1_onSubJobError(exception, errorComponent, globalMap);
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
			public void tJavaFlex_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tJava_2_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tDBInput_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tRunJob_3_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tRunJob_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

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
    final static byte[] commonByteArrayLock_TEST_ssjob_init_fich_bdd = new byte[0];
    static byte[] commonByteArray_TEST_ssjob_init_fich_bdd = new byte[0];

	
			    public String name;

				public String getName () {
					return this.name;
				}
				
			    public String rep_ftp;

				public String getRep_ftp () {
					return this.rep_ftp;
				}
				
			    public String date;

				public String getDate () {
					return this.date;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_TEST_ssjob_init_fich_bdd.length) {
				if(length < 1024 && commonByteArray_TEST_ssjob_init_fich_bdd.length == 0) {
   					commonByteArray_TEST_ssjob_init_fich_bdd = new byte[1024];
				} else {
   					commonByteArray_TEST_ssjob_init_fich_bdd = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_TEST_ssjob_init_fich_bdd, 0, length);
			strReturn = new String(commonByteArray_TEST_ssjob_init_fich_bdd, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_TEST_ssjob_init_fich_bdd) {

        	try {

        		int length = 0;
		
					this.name = readString(dis);
					
					this.rep_ftp = readString(dis);
					
					this.date = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.name,dos);
					
					// String
				
						writeString(this.rep_ftp,dos);
					
					// String
				
						writeString(this.date,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("name="+name);
		sb.append(",rep_ftp="+rep_ftp);
		sb.append(",date="+date);
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				if(name == null){
        					sb.append("<null>");
        				}else{
            				sb.append(name);
            			}
            		
        			sb.append("|");
        		
        				if(rep_ftp == null){
        					sb.append("<null>");
        				}else{
            				sb.append(rep_ftp);
            			}
            		
        			sb.append("|");
        		
        				if(date == null){
        					sb.append("<null>");
        				}else{
            				sb.append(date);
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
public void tJavaFlex_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tJavaFlex_1_SUBPROCESS_STATE", 0);

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



		row1Struct row1 = new row1Struct();




	
	/**
	 * [tDBRow_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBRow_1", false);
		start_Hash.put("tDBRow_1", System.currentTimeMillis());
		
	
	currentComponent="tDBRow_1";

	
			if (execStat) {
				if(resourceMap.get("inIterateVComp") == null){
					
						runStat.updateStatOnConnection("row1" + iterateId, 0, 0);
					
				}
			} 

		
		int tos_count_tDBRow_1 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tDBRow_1 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tDBRow_1{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tDBRow_1 = new StringBuilder();
                    log4jParamters_tDBRow_1.append("Parameters:");
                            log4jParamters_tDBRow_1.append("USE_EXISTING_CONNECTION" + " = " + "true");
                        log4jParamters_tDBRow_1.append(" | ");
                            log4jParamters_tDBRow_1.append("CONNECTION" + " = " + "tDBConnection_1");
                        log4jParamters_tDBRow_1.append(" | ");
                            log4jParamters_tDBRow_1.append("IDENTITY_INSERT" + " = " + "false");
                        log4jParamters_tDBRow_1.append(" | ");
                            log4jParamters_tDBRow_1.append("QUERYSTORE" + " = " + "\"\"");
                        log4jParamters_tDBRow_1.append(" | ");
                            log4jParamters_tDBRow_1.append("QUERY" + " = " + "\"insert into SUIVITRAITEMENT (nom_fichier, repertoire_ftp, cree_le) VALUES ('\"+ row1.name + \"', '\" + row1.rep_ftp + \"', '\" + row1.date +\"');\"");
                        log4jParamters_tDBRow_1.append(" | ");
                            log4jParamters_tDBRow_1.append("DIE_ON_ERROR" + " = " + "true");
                        log4jParamters_tDBRow_1.append(" | ");
                            log4jParamters_tDBRow_1.append("PROPAGATE_RECORD_SET" + " = " + "false");
                        log4jParamters_tDBRow_1.append(" | ");
                            log4jParamters_tDBRow_1.append("USE_PREPAREDSTATEMENT" + " = " + "false");
                        log4jParamters_tDBRow_1.append(" | ");
                            log4jParamters_tDBRow_1.append("UNIFIED_COMPONENTS" + " = " + "tMSSqlRow");
                        log4jParamters_tDBRow_1.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tDBRow_1 - "  + (log4jParamters_tDBRow_1) );
                    } 
                } 
            new BytesLimit65535_tDBRow_1().limitLog4jByte();
            }

	java.sql.Connection conn_tDBRow_1 = null;
	String query_tDBRow_1 = "";
	boolean whetherReject_tDBRow_1 = false;
				conn_tDBRow_1 = (java.sql.Connection)globalMap.get("conn_tDBConnection_1");
			
				if(conn_tDBRow_1 != null) {
					if(conn_tDBRow_1.getMetaData() != null) {
						
							log.debug("tDBRow_1 - Uses an existing connection with username '" + conn_tDBRow_1.getMetaData().getUserName() + "'. Connection URL: " + conn_tDBRow_1.getMetaData().getURL() + ".");
						
					}
				}
			
    resourceMap.put("conn_tDBRow_1", conn_tDBRow_1);
        java.sql.Statement stmt_tDBRow_1 = conn_tDBRow_1.createStatement();
        resourceMap.put("stmt_tDBRow_1", stmt_tDBRow_1);

 



/**
 * [tDBRow_1 begin ] stop
 */



	
	/**
	 * [tJavaFlex_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tJavaFlex_1", false);
		start_Hash.put("tJavaFlex_1", System.currentTimeMillis());
		
	
	currentComponent="tJavaFlex_1";

	
		int tos_count_tJavaFlex_1 = 0;
		


// start part of your Java code
System.out.println("Initialisation BDD");


 



/**
 * [tJavaFlex_1 begin ] stop
 */
	
	/**
	 * [tJavaFlex_1 main ] start
	 */

	

	
	
	currentComponent="tJavaFlex_1";

	



// here is the main part of the component,
// a piece of code executed in the row
// loop
//context.file_name = "MSG002.PART04.20110326.0216.csv";
//context.rep_ftp = "rep_ftp";

row1.name = context.file_name;
//System.out.println("pour le fichier " + context.file_name);
row1.rep_ftp = context.rep_ftp;

context.date = TalendDate.formatDate("yyyy-dd-MM HH:mm:ss", TalendDate.getCurrentDate());
row1.date = context.date;

 


	tos_count_tJavaFlex_1++;

/**
 * [tJavaFlex_1 main ] stop
 */
	
	/**
	 * [tJavaFlex_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tJavaFlex_1";

	

 



/**
 * [tJavaFlex_1 process_data_begin ] stop
 */

	
	/**
	 * [tDBRow_1 main ] start
	 */

	

	
	
	currentComponent="tDBRow_1";

	

			//row1
			//row1


			
				if(execStat){
					runStat.updateStatOnConnection("row1"+iterateId,1, 1);
				} 
			

		
    			if(log.isTraceEnabled()){
    				log.trace("row1 - " + (row1==null? "": row1.toLogString()));
    			}
    		

	    		log.debug("tDBRow_1 - Executing the query: '" + "insert into SUIVITRAITEMENT (nom_fichier, repertoire_ftp, cree_le) VALUES ('"+ row1.name + "', '" + row1.rep_ftp + "', '" + row1.date +"');" + "'.");
			
query_tDBRow_1 = "insert into SUIVITRAITEMENT (nom_fichier, repertoire_ftp, cree_le) VALUES ('"+ row1.name + "', '" + row1.rep_ftp + "', '" + row1.date +"');";
whetherReject_tDBRow_1 = false;
globalMap.put("tDBRow_1_QUERY",query_tDBRow_1);
try {
		stmt_tDBRow_1.execute(query_tDBRow_1);
		
	    		log.debug("tDBRow_1 - Execute the query: '" + "insert into SUIVITRAITEMENT (nom_fichier, repertoire_ftp, cree_le) VALUES ('"+ row1.name + "', '" + row1.rep_ftp + "', '" + row1.date +"');" + "' has finished.");
			
	} catch (java.lang.Exception e) {
		whetherReject_tDBRow_1 = true;
		
			throw(e);
			
	}
	
	if(!whetherReject_tDBRow_1) {
		
	}
	

 


	tos_count_tDBRow_1++;

/**
 * [tDBRow_1 main ] stop
 */
	
	/**
	 * [tDBRow_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBRow_1";

	

 



/**
 * [tDBRow_1 process_data_begin ] stop
 */
	
	/**
	 * [tDBRow_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBRow_1";

	

 



/**
 * [tDBRow_1 process_data_end ] stop
 */



	
	/**
	 * [tJavaFlex_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tJavaFlex_1";

	

 



/**
 * [tJavaFlex_1 process_data_end ] stop
 */
	
	/**
	 * [tJavaFlex_1 end ] start
	 */

	

	
	
	currentComponent="tJavaFlex_1";

	


// end of the component, outside/closing the loop
      

 

ok_Hash.put("tJavaFlex_1", true);
end_Hash.put("tJavaFlex_1", System.currentTimeMillis());




/**
 * [tJavaFlex_1 end ] stop
 */

	
	/**
	 * [tDBRow_1 end ] start
	 */

	

	
	
	currentComponent="tDBRow_1";

	

	
        stmt_tDBRow_1.close();
        resourceMap.remove("stmt_tDBRow_1");
    resourceMap.put("statementClosed_tDBRow_1", true);
    resourceMap.put("finish_tDBRow_1", true);
			if(execStat){
				if(resourceMap.get("inIterateVComp") == null || !((Boolean)resourceMap.get("inIterateVComp"))){
			 		runStat.updateStatOnConnection("row1"+iterateId,2, 0); 
			 	}
			}
		
 
                if(log.isDebugEnabled())
            log.debug("tDBRow_1 - "  + ("Done.") );

ok_Hash.put("tDBRow_1", true);
end_Hash.put("tDBRow_1", System.currentTimeMillis());




/**
 * [tDBRow_1 end ] stop
 */



				}//end the resume

				
				    			if(resumeEntryMethodName == null || globalResumeTicket){
				    				resumeUtil.addLog("CHECKPOINT", "CONNECTION:SUBJOB_OK:tJavaFlex_1:OnSubjobOk", "", Thread.currentThread().getId() + "", "", "", "", "", "");
								}	    				    			
					    	
								if(execStat){    	
									runStat.updateStatOnConnection("OnSubjobOk3", 0, "ok");
								} 
							
							tDBInput_1Process(globalMap); 
						



	
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
	 * [tJavaFlex_1 finally ] start
	 */

	

	
	
	currentComponent="tJavaFlex_1";

	

 



/**
 * [tJavaFlex_1 finally ] stop
 */

	
	/**
	 * [tDBRow_1 finally ] start
	 */

	

	
	
	currentComponent="tDBRow_1";

	

    if (resourceMap.get("statementClosed_tDBRow_1") == null) {
            java.sql.Statement stmtToClose_tDBRow_1 = null;
            if ((stmtToClose_tDBRow_1 = (java.sql.Statement) resourceMap.remove("stmt_tDBRow_1")) != null) {
                stmtToClose_tDBRow_1.close();
            }
    }
 



/**
 * [tDBRow_1 finally ] stop
 */



				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tJavaFlex_1_SUBPROCESS_STATE", 1);
	}
	

public void tJava_2Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tJava_2_SUBPROCESS_STATE", 0);

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
	 * [tJava_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tJava_2", false);
		start_Hash.put("tJava_2", System.currentTimeMillis());
		
	
	currentComponent="tJava_2";

	
		int tos_count_tJava_2 = 0;
		


System.out.println("ERROR INIT BDD");
 



/**
 * [tJava_2 begin ] stop
 */
	
	/**
	 * [tJava_2 main ] start
	 */

	

	
	
	currentComponent="tJava_2";

	

 


	tos_count_tJava_2++;

/**
 * [tJava_2 main ] stop
 */
	
	/**
	 * [tJava_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tJava_2";

	

 



/**
 * [tJava_2 process_data_begin ] stop
 */
	
	/**
	 * [tJava_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tJava_2";

	

 



/**
 * [tJava_2 process_data_end ] stop
 */
	
	/**
	 * [tJava_2 end ] start
	 */

	

	
	
	currentComponent="tJava_2";

	

 

ok_Hash.put("tJava_2", true);
end_Hash.put("tJava_2", System.currentTimeMillis());




/**
 * [tJava_2 end ] stop
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
	 * [tJava_2 finally ] start
	 */

	

	
	
	currentComponent="tJava_2";

	

 



/**
 * [tJava_2 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tJava_2_SUBPROCESS_STATE", 1);
	}
	


public static class row2Struct implements routines.system.IPersistableRow<row2Struct> {
    final static byte[] commonByteArrayLock_TEST_ssjob_init_fich_bdd = new byte[0];
    static byte[] commonByteArray_TEST_ssjob_init_fich_bdd = new byte[0];

	
			    public Integer SCOPE_IDENTITY;

				public Integer getSCOPE_IDENTITY () {
					return this.SCOPE_IDENTITY;
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

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_TEST_ssjob_init_fich_bdd) {

        	try {

        		int length = 0;
		
						this.SCOPE_IDENTITY = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// Integer
				
						writeInteger(this.SCOPE_IDENTITY,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("SCOPE_IDENTITY="+String.valueOf(SCOPE_IDENTITY));
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				if(SCOPE_IDENTITY == null){
        					sb.append("<null>");
        				}else{
            				sb.append(SCOPE_IDENTITY);
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
	 * [tJavaFlex_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tJavaFlex_2", false);
		start_Hash.put("tJavaFlex_2", System.currentTimeMillis());
		
	
	currentComponent="tJavaFlex_2";

	
			if (execStat) {
				if(resourceMap.get("inIterateVComp") == null){
					
						runStat.updateStatOnConnection("row2" + iterateId, 0, 0);
					
				}
			} 

		
		int tos_count_tJavaFlex_2 = 0;
		


// start part of your Java code
      


 



/**
 * [tJavaFlex_2 begin ] stop
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
                            log4jParamters_tDBInput_1.append("TABLE" + " = " + "\"SUIVITRAITEMENT\"");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("QUERYSTORE" + " = " + "\"\"");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("QUERY" + " = " + "\"SELECT SCOPE_IDENTITY() AS [SCOPE_IDENTITY]\"");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("TRIM_ALL_COLUMN" + " = " + "false");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("TRIM_COLUMN" + " = " + "[{TRIM="+("false")+", SCHEMA_COLUMN="+("SCOPE_IDENTITY")+"}]");
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

		    String dbquery_tDBInput_1 = "SELECT SCOPE_IDENTITY() AS [SCOPE_IDENTITY]";
			
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
								row2.SCOPE_IDENTITY = null;
							} else {
		                          
            if(rs_tDBInput_1.getObject(1) != null) {
                row2.SCOPE_IDENTITY = rs_tDBInput_1.getInt(1);
            } else {
                    row2.SCOPE_IDENTITY = null;
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
	 * [tJavaFlex_2 main ] start
	 */

	

	
	
	currentComponent="tJavaFlex_2";

	

			//row2
			//row2


			
				if(execStat){
					runStat.updateStatOnConnection("row2"+iterateId,1, 1);
				} 
			

		
    			if(log.isTraceEnabled()){
    				log.trace("row2 - " + (row2==null? "": row2.toLogString()));
    			}
    		



// here is the main part of the component,
// a piece of code executed in the row
// loop
context.str_id = row2.SCOPE_IDENTITY;


 


	tos_count_tJavaFlex_2++;

/**
 * [tJavaFlex_2 main ] stop
 */
	
	/**
	 * [tJavaFlex_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tJavaFlex_2";

	

 



/**
 * [tJavaFlex_2 process_data_begin ] stop
 */
	
	/**
	 * [tJavaFlex_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tJavaFlex_2";

	

 



/**
 * [tJavaFlex_2 process_data_end ] stop
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
	 * [tJavaFlex_2 end ] start
	 */

	

	
	
	currentComponent="tJavaFlex_2";

	


// end of the component, outside/closing the loop
      

			if(execStat){
				if(resourceMap.get("inIterateVComp") == null || !((Boolean)resourceMap.get("inIterateVComp"))){
			 		runStat.updateStatOnConnection("row2"+iterateId,2, 0); 
			 	}
			}
		
 

ok_Hash.put("tJavaFlex_2", true);
end_Hash.put("tJavaFlex_2", System.currentTimeMillis());




/**
 * [tJavaFlex_2 end ] stop
 */



				}//end the resume

				
				    			if(resumeEntryMethodName == null || globalResumeTicket){
				    				resumeUtil.addLog("CHECKPOINT", "CONNECTION:SUBJOB_OK:tDBInput_1:OnSubjobOk", "", Thread.currentThread().getId() + "", "", "", "", "", "");
								}	    				    			
					    	
								if(execStat){    	
									runStat.updateStatOnConnection("OnSubjobOk2", 0, "ok");
								} 
							
							tRunJob_3Process(globalMap); 
						



	
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
	 * [tJavaFlex_2 finally ] start
	 */

	

	
	
	currentComponent="tJavaFlex_2";

	

 



/**
 * [tJavaFlex_2 finally ] stop
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
	

public void tRunJob_3Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tRunJob_3_SUBPROCESS_STATE", 0);

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
	 * [tRunJob_3 begin ] start
	 */

	

	
		
		ok_Hash.put("tRunJob_3", false);
		start_Hash.put("tRunJob_3", System.currentTimeMillis());
		
	
	currentComponent="tRunJob_3";

	
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
                            log4jParamters_tRunJob_3.append("PROCESS" + " = " + "ssjob_init_fich_statut");
                        log4jParamters_tRunJob_3.append(" | ");
                            log4jParamters_tRunJob_3.append("USE_INDEPENDENT_PROCESS" + " = " + "false");
                        log4jParamters_tRunJob_3.append(" | ");
                            log4jParamters_tRunJob_3.append("DIE_ON_CHILD_ERROR" + " = " + "false");
                        log4jParamters_tRunJob_3.append(" | ");
                            log4jParamters_tRunJob_3.append("TRANSMIT_WHOLE_CONTEXT" + " = " + "true");
                        log4jParamters_tRunJob_3.append(" | ");
                            log4jParamters_tRunJob_3.append("CONTEXTPARAMS" + " = " + "[{PARAM_NAME_COLUMN="+("statut")+", PARAM_VALUE_COLUMN="+("\"PRIS_EN_CHARGE\"")+"}]");
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
	 * [tRunJob_3 main ] start
	 */

	

	
	
	currentComponent="tRunJob_3";

	
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
		
			parentContextMap_tRunJob_3.put("FILES", context.FILES);
			paraList_tRunJob_3.add("--context_type " + "FILES" + "=" + "id_String");
		
			parentContextMap_tRunJob_3.put("rep_archivage", context.rep_archivage);
			paraList_tRunJob_3.add("--context_type " + "rep_archivage" + "=" + "id_String");
		
			parentContextMap_tRunJob_3.put("rep_rejet_N1", context.rep_rejet_N1);
			paraList_tRunJob_3.add("--context_type " + "rep_rejet_N1" + "=" + "id_String");
		
			parentContextMap_tRunJob_3.put("rep_travail", context.rep_travail);
			paraList_tRunJob_3.add("--context_type " + "rep_travail" + "=" + "id_String");
		
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

	
		obj_tRunJob_3 = "PRIS_EN_CHARGE";
		if(obj_tRunJob_3!=null) {
			paraList_tRunJob_3.add("--context_param statut=" + RuntimeUtils.tRunJobConvertContext(obj_tRunJob_3));
		} else {
			paraList_tRunJob_3.add("--context_param statut=" + NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY);
		}
		
		parentContextMap_tRunJob_3.put("statut", obj_tRunJob_3);
	
	
		test.ssjob_init_fich_statut_0_1.ssjob_init_fich_statut childJob_tRunJob_3 = new test.ssjob_init_fich_statut_0_1.ssjob_init_fich_statut();
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
		  
		
			log.info("tRunJob_3 - The child job 'test.ssjob_init_fich_statut_0_1.ssjob_init_fich_statut' starts on the version '0.1' with the context 'Default'.");
		
		String[][] childReturn_tRunJob_3 = childJob_tRunJob_3.runJob((String[]) paraList_tRunJob_3.toArray(new String[paraList_tRunJob_3.size()]));
		
			log.info("tRunJob_3 - The child job 'test.ssjob_init_fich_statut_0_1.ssjob_init_fich_statut' is done.");
		
	  	
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
	 * [tRunJob_3 end ] start
	 */

	

	
	
	currentComponent="tRunJob_3";

	

 
                if(log.isDebugEnabled())
            log.debug("tRunJob_3 - "  + ("Done.") );

ok_Hash.put("tRunJob_3", true);
end_Hash.put("tRunJob_3", System.currentTimeMillis());




/**
 * [tRunJob_3 end ] stop
 */
				}//end the resume

				
				    			if(resumeEntryMethodName == null || globalResumeTicket){
				    				resumeUtil.addLog("CHECKPOINT", "CONNECTION:SUBJOB_OK:tRunJob_3:OnSubjobOk", "", Thread.currentThread().getId() + "", "", "", "", "", "");
								}	    				    			
					    	
								if(execStat){    	
									runStat.updateStatOnConnection("OnSubjobOk1", 0, "ok");
								} 
							
							tRunJob_1Process(globalMap); 
						



	
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
	 * [tRunJob_3 finally ] start
	 */

	

	
	
	currentComponent="tRunJob_3";

	

 



/**
 * [tRunJob_3 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tRunJob_3_SUBPROCESS_STATE", 1);
	}
	

public void tRunJob_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tRunJob_1_SUBPROCESS_STATE", 0);

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
	 * [tRunJob_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tRunJob_1", false);
		start_Hash.put("tRunJob_1", System.currentTimeMillis());
		
	
	currentComponent="tRunJob_1";

	
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
                            log4jParamters_tRunJob_1.append("PROCESS" + " = " + "ssjob_controleN1");
                        log4jParamters_tRunJob_1.append(" | ");
                            log4jParamters_tRunJob_1.append("USE_INDEPENDENT_PROCESS" + " = " + "false");
                        log4jParamters_tRunJob_1.append(" | ");
                            log4jParamters_tRunJob_1.append("DIE_ON_CHILD_ERROR" + " = " + "false");
                        log4jParamters_tRunJob_1.append(" | ");
                            log4jParamters_tRunJob_1.append("TRANSMIT_WHOLE_CONTEXT" + " = " + "true");
                        log4jParamters_tRunJob_1.append(" | ");
                            log4jParamters_tRunJob_1.append("CONTEXTPARAMS" + " = " + "[]");
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
	 * [tRunJob_1 main ] start
	 */

	

	
	
	currentComponent="tRunJob_1";

	
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

	
	
		test.ssjob_controlen1_0_1.ssjob_controleN1 childJob_tRunJob_1 = new test.ssjob_controlen1_0_1.ssjob_controleN1();
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
		  
		
			log.info("tRunJob_1 - The child job 'test.ssjob_controlen1_0_1.ssjob_controleN1' starts on the version '0.1' with the context 'Default'.");
		
		String[][] childReturn_tRunJob_1 = childJob_tRunJob_1.runJob((String[]) paraList_tRunJob_1.toArray(new String[paraList_tRunJob_1.size()]));
		
			log.info("tRunJob_1 - The child job 'test.ssjob_controlen1_0_1.ssjob_controleN1' is done.");
		
	  	
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
	 * [tRunJob_1 end ] start
	 */

	

	
	
	currentComponent="tRunJob_1";

	

 
                if(log.isDebugEnabled())
            log.debug("tRunJob_1 - "  + ("Done.") );

ok_Hash.put("tRunJob_1", true);
end_Hash.put("tRunJob_1", System.currentTimeMillis());




/**
 * [tRunJob_1 end ] stop
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
		

		globalMap.put("tRunJob_1_SUBPROCESS_STATE", 1);
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
        final ssjob_init_fich_bdd ssjob_init_fich_bddClass = new ssjob_init_fich_bdd();

        int exitCode = ssjob_init_fich_bddClass.runJobInTOS(args);
	        if(exitCode==0){
		        log.info("TalendJob: 'ssjob_init_fich_bdd' - Done.");
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
        	log.info("TalendJob: 'ssjob_init_fich_bdd' - Start.");
    	

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
            java.io.InputStream inContext = ssjob_init_fich_bdd.class.getClassLoader().getResourceAsStream("test/ssjob_init_fich_bdd_0_1/contexts/" + contextStr + ".properties");
            if (inContext == null) {
                inContext = ssjob_init_fich_bdd.class.getClassLoader().getResourceAsStream("config/contexts/" + contextStr + ".properties");
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
        if (parentContextMap != null && !parentContextMap.isEmpty()) {if (parentContextMap.containsKey("codeEDI")) {
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
            }if (parentContextMap.containsKey("FILES")) {
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
errorCode = null;tJavaFlex_1Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tJavaFlex_1) {
globalMap.put("tJavaFlex_1_SUBPROCESS_STATE", -1);

e_tJavaFlex_1.printStackTrace();

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
            System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : ssjob_init_fich_bdd");
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
 *     119900 characters generated by Talend Cloud Data Management Platform 
 *     on the September 13, 2019 3:25:26 PM CEST
 ************************************************************************************************/