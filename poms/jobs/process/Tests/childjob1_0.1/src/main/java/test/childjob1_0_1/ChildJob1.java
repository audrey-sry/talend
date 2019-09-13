
package test.childjob1_0_1;

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
 * Job: ChildJob1 Purpose: <br>
 * Description:  <br>
 * @author user@talend.com
 * @version 7.1.1.20190228_0243-patch
 * @status 
 */
public class ChildJob1 implements TalendJob {
	static {System.setProperty("TalendJob.log", "ChildJob1.log");}
	private static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(ChildJob1.class);

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
			
			if(nom != null){
				
					this.setProperty("nom", nom.toString());
				
			}
			
			if(ssql_AdditionalParams != null){
				
					this.setProperty("ssql_AdditionalParams", ssql_AdditionalParams.toString());
				
			}
			
			if(ssql_Database != null){
				
					this.setProperty("ssql_Database", ssql_Database.toString());
				
			}
			
			if(ssql_Login != null){
				
					this.setProperty("ssql_Login", ssql_Login.toString());
				
			}
			
			if(ssql_Password != null){
				
					this.setProperty("ssql_Password", ssql_Password.toString());
				
			}
			
			if(ssql_Port != null){
				
					this.setProperty("ssql_Port", ssql_Port.toString());
				
			}
			
			if(ssql_Schema != null){
				
					this.setProperty("ssql_Schema", ssql_Schema.toString());
				
			}
			
			if(ssql_Server != null){
				
					this.setProperty("ssql_Server", ssql_Server.toString());
				
			}
			
			if(bonjour != null){
				
					this.setProperty("bonjour", bonjour.toString());
				
			}
			
		}

public String nom;
public String getNom(){
	return this.nom;
}
public String ssql_AdditionalParams;
public String getSsql_AdditionalParams(){
	return this.ssql_AdditionalParams;
}
public String ssql_Database;
public String getSsql_Database(){
	return this.ssql_Database;
}
public String ssql_Login;
public String getSsql_Login(){
	return this.ssql_Login;
}
public java.lang.String ssql_Password;
public java.lang.String getSsql_Password(){
	return this.ssql_Password;
}
public String ssql_Port;
public String getSsql_Port(){
	return this.ssql_Port;
}
public String ssql_Schema;
public String getSsql_Schema(){
	return this.ssql_Schema;
}
public String ssql_Server;
public String getSsql_Server(){
	return this.ssql_Server;
}
public String bonjour;
public String getBonjour(){
	return this.bonjour;
}
	}
	protected ContextProperties context = new ContextProperties(); // will be instanciated by MS.
	public ContextProperties getContext() {
		return this.context;
	}
	private final String jobVersion = "0.1";
	private final String jobName = "ChildJob1";
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
				ChildJob1.this.exception = e;
			}
		}
		if (!(e instanceof TalendException)) {
		try {
			for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
				if (m.getName().compareTo(currentComponent + "_error") == 0) {
					m.invoke(ChildJob1.this, new Object[] { e , currentComponent, globalMap});
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

			public void tRunJob_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tRunJob_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tFixedFlowInput_3_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFixedFlowInput_3_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tBufferOutput_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFixedFlowInput_3_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tRunJob_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tFixedFlowInput_3_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

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
                            log4jParamters_tRunJob_1.append("PROCESS" + " = " + "ChildJob2");
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
		
			parentContextMap_tRunJob_1.put("nom", context.nom);
			paraList_tRunJob_1.add("--context_type " + "nom" + "=" + "id_String");
		
			parentContextMap_tRunJob_1.put("ssql_AdditionalParams", context.ssql_AdditionalParams);
			paraList_tRunJob_1.add("--context_type " + "ssql_AdditionalParams" + "=" + "id_String");
		
			parentContextMap_tRunJob_1.put("ssql_Database", context.ssql_Database);
			paraList_tRunJob_1.add("--context_type " + "ssql_Database" + "=" + "id_String");
		
			parentContextMap_tRunJob_1.put("ssql_Login", context.ssql_Login);
			paraList_tRunJob_1.add("--context_type " + "ssql_Login" + "=" + "id_String");
		
			parentContextMap_tRunJob_1.put("ssql_Password", context.ssql_Password);
			paraList_tRunJob_1.add("--context_type " + "ssql_Password" + "=" + "id_Password");
		
			parentContextMap_tRunJob_1.put("ssql_Port", context.ssql_Port);
			paraList_tRunJob_1.add("--context_type " + "ssql_Port" + "=" + "id_String");
		
			parentContextMap_tRunJob_1.put("ssql_Schema", context.ssql_Schema);
			paraList_tRunJob_1.add("--context_type " + "ssql_Schema" + "=" + "id_String");
		
			parentContextMap_tRunJob_1.put("ssql_Server", context.ssql_Server);
			paraList_tRunJob_1.add("--context_type " + "ssql_Server" + "=" + "id_String");
		
			parentContextMap_tRunJob_1.put("bonjour", context.bonjour);
			paraList_tRunJob_1.add("--context_type " + "bonjour" + "=" + "id_String");
		 
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

	
	
		test.childjob2_0_1.ChildJob2 childJob_tRunJob_1 = new test.childjob2_0_1.ChildJob2();
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
		  
		
			log.info("tRunJob_1 - The child job 'test.childjob2_0_1.ChildJob2' starts on the version '0.1' with the context 'Default'.");
		
		String[][] childReturn_tRunJob_1 = childJob_tRunJob_1.runJob((String[]) paraList_tRunJob_1.toArray(new String[paraList_tRunJob_1.size()]));
		
			log.info("tRunJob_1 - The child job 'test.childjob2_0_1.ChildJob2' is done.");
		
	  	
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
	


public static class row3Struct implements routines.system.IPersistableRow<row3Struct> {
    final static byte[] commonByteArrayLock_TEST_ChildJob1 = new byte[0];
    static byte[] commonByteArray_TEST_ChildJob1 = new byte[0];

	
			    public String nom;

				public String getNom () {
					return this.nom;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_TEST_ChildJob1.length) {
				if(length < 1024 && commonByteArray_TEST_ChildJob1.length == 0) {
   					commonByteArray_TEST_ChildJob1 = new byte[1024];
				} else {
   					commonByteArray_TEST_ChildJob1 = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_TEST_ChildJob1, 0, length);
			strReturn = new String(commonByteArray_TEST_ChildJob1, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_TEST_ChildJob1) {

        	try {

        		int length = 0;
		
					this.nom = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.nom,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("nom="+nom);
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				if(nom == null){
        					sb.append("<null>");
        				}else{
            				sb.append(nom);
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
public void tFixedFlowInput_3Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tFixedFlowInput_3_SUBPROCESS_STATE", 0);

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



		row3Struct row3 = new row3Struct();




	
	/**
	 * [tBufferOutput_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tBufferOutput_2", false);
		start_Hash.put("tBufferOutput_2", System.currentTimeMillis());
		
	
	currentComponent="tBufferOutput_2";

	
			if (execStat) {
				if(resourceMap.get("inIterateVComp") == null){
					
						runStat.updateStatOnConnection("row3" + iterateId, 0, 0);
					
				}
			} 

		
		int tos_count_tBufferOutput_2 = 0;
		

 



/**
 * [tBufferOutput_2 begin ] stop
 */



	
	/**
	 * [tFixedFlowInput_3 begin ] start
	 */

	

	
		
		ok_Hash.put("tFixedFlowInput_3", false);
		start_Hash.put("tFixedFlowInput_3", System.currentTimeMillis());
		
	
	currentComponent="tFixedFlowInput_3";

	
		int tos_count_tFixedFlowInput_3 = 0;
		

	    for (int i_tFixedFlowInput_3 = 0 ; i_tFixedFlowInput_3 < 1 ; i_tFixedFlowInput_3++) {
	                	            	
    	            		row3.nom = "jonh";
    	            	
 



/**
 * [tFixedFlowInput_3 begin ] stop
 */
	
	/**
	 * [tFixedFlowInput_3 main ] start
	 */

	

	
	
	currentComponent="tFixedFlowInput_3";

	

 


	tos_count_tFixedFlowInput_3++;

/**
 * [tFixedFlowInput_3 main ] stop
 */
	
	/**
	 * [tFixedFlowInput_3 process_data_begin ] start
	 */

	

	
	
	currentComponent="tFixedFlowInput_3";

	

 



/**
 * [tFixedFlowInput_3 process_data_begin ] stop
 */

	
	/**
	 * [tBufferOutput_2 main ] start
	 */

	

	
	
	currentComponent="tBufferOutput_2";

	

			//row3
			//row3


			
				if(execStat){
					runStat.updateStatOnConnection("row3"+iterateId,1, 1);
				} 
			

		
    			if(log.isTraceEnabled()){
    				log.trace("row3 - " + (row3==null? "": row3.toLogString()));
    			}
    		



String[] row_tBufferOutput_2=new String[]{"",};		
	    if(row3.nom != null){
	        
	            row_tBufferOutput_2[0] = row3.nom;
	                        			    
	    }else{
	    	row_tBufferOutput_2[0] = null;
	    }
	globalBuffer.add(row_tBufferOutput_2);	
	
 


	tos_count_tBufferOutput_2++;

/**
 * [tBufferOutput_2 main ] stop
 */
	
	/**
	 * [tBufferOutput_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tBufferOutput_2";

	

 



/**
 * [tBufferOutput_2 process_data_begin ] stop
 */
	
	/**
	 * [tBufferOutput_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tBufferOutput_2";

	

 



/**
 * [tBufferOutput_2 process_data_end ] stop
 */



	
	/**
	 * [tFixedFlowInput_3 process_data_end ] start
	 */

	

	
	
	currentComponent="tFixedFlowInput_3";

	

 



/**
 * [tFixedFlowInput_3 process_data_end ] stop
 */
	
	/**
	 * [tFixedFlowInput_3 end ] start
	 */

	

	
	
	currentComponent="tFixedFlowInput_3";

	

        }
        globalMap.put("tFixedFlowInput_3_NB_LINE", 1);        

 

ok_Hash.put("tFixedFlowInput_3", true);
end_Hash.put("tFixedFlowInput_3", System.currentTimeMillis());




/**
 * [tFixedFlowInput_3 end ] stop
 */

	
	/**
	 * [tBufferOutput_2 end ] start
	 */

	

	
	
	currentComponent="tBufferOutput_2";

	

			if(execStat){
				if(resourceMap.get("inIterateVComp") == null || !((Boolean)resourceMap.get("inIterateVComp"))){
			 		runStat.updateStatOnConnection("row3"+iterateId,2, 0); 
			 	}
			}
		
 

ok_Hash.put("tBufferOutput_2", true);
end_Hash.put("tBufferOutput_2", System.currentTimeMillis());




/**
 * [tBufferOutput_2 end ] stop
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
	 * [tFixedFlowInput_3 finally ] start
	 */

	

	
	
	currentComponent="tFixedFlowInput_3";

	

 



/**
 * [tFixedFlowInput_3 finally ] stop
 */

	
	/**
	 * [tBufferOutput_2 finally ] start
	 */

	

	
	
	currentComponent="tBufferOutput_2";

	

 



/**
 * [tBufferOutput_2 finally ] stop
 */



				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tFixedFlowInput_3_SUBPROCESS_STATE", 1);
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
        final ChildJob1 ChildJob1Class = new ChildJob1();

        int exitCode = ChildJob1Class.runJobInTOS(args);
	        if(exitCode==0){
		        log.info("TalendJob: 'ChildJob1' - Done.");
	        }

        System.exit(exitCode);
    }


    public String[][] runJob(String[] args) {

        int exitCode = runJobInTOS(args);
        String[][] bufferValue = (String[][])globalBuffer.toArray(new String[globalBuffer.size()][]);

        return bufferValue;
    }

    public boolean hastBufferOutputComponent() {
		boolean hastBufferOutput = false;
    	
        		hastBufferOutput = true;
    	
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
        	log.info("TalendJob: 'ChildJob1' - Start.");
    	

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
            java.io.InputStream inContext = ChildJob1.class.getClassLoader().getResourceAsStream("test/childjob1_0_1/contexts/" + contextStr + ".properties");
            if (inContext == null) {
                inContext = ChildJob1.class.getClassLoader().getResourceAsStream("config/contexts/" + contextStr + ".properties");
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
				    context.setContextType("nom", "id_String");
				
                context.nom=(String) context.getProperty("nom");
				    context.setContextType("ssql_AdditionalParams", "id_String");
				
                context.ssql_AdditionalParams=(String) context.getProperty("ssql_AdditionalParams");
				    context.setContextType("ssql_Database", "id_String");
				
                context.ssql_Database=(String) context.getProperty("ssql_Database");
				    context.setContextType("ssql_Login", "id_String");
				
                context.ssql_Login=(String) context.getProperty("ssql_Login");
				    context.setContextType("ssql_Password", "id_Password");
				
            		String pwd_ssql_Password_value = context.getProperty("ssql_Password");
            		context.ssql_Password = null;
            		if(pwd_ssql_Password_value!=null) {
            			if(context_param.containsKey("ssql_Password")) {//no need to decrypt if it come from program argument or parent job runtime
            				context.ssql_Password = pwd_ssql_Password_value;
            			} else if (!pwd_ssql_Password_value.isEmpty()) {
            				try {
            					context.ssql_Password = routines.system.PasswordEncryptUtil.decryptPassword(pwd_ssql_Password_value);
            					context.put("ssql_Password",context.ssql_Password);
            				} catch (java.lang.RuntimeException e) {
            					//do nothing
            				}
            			}
            		}
				    context.setContextType("ssql_Port", "id_String");
				
                context.ssql_Port=(String) context.getProperty("ssql_Port");
				    context.setContextType("ssql_Schema", "id_String");
				
                context.ssql_Schema=(String) context.getProperty("ssql_Schema");
				    context.setContextType("ssql_Server", "id_String");
				
                context.ssql_Server=(String) context.getProperty("ssql_Server");
				    context.setContextType("bonjour", "id_String");
				
                context.bonjour=(String) context.getProperty("bonjour");
        } catch (java.io.IOException ie) {
            System.err.println("Could not load context "+contextStr);
            ie.printStackTrace();
        }


        // get context value from parent directly
        if (parentContextMap != null && !parentContextMap.isEmpty()) {if (parentContextMap.containsKey("nom")) {
                context.nom = (String) parentContextMap.get("nom");
            }if (parentContextMap.containsKey("ssql_AdditionalParams")) {
                context.ssql_AdditionalParams = (String) parentContextMap.get("ssql_AdditionalParams");
            }if (parentContextMap.containsKey("ssql_Database")) {
                context.ssql_Database = (String) parentContextMap.get("ssql_Database");
            }if (parentContextMap.containsKey("ssql_Login")) {
                context.ssql_Login = (String) parentContextMap.get("ssql_Login");
            }if (parentContextMap.containsKey("ssql_Password")) {
                context.ssql_Password = (java.lang.String) parentContextMap.get("ssql_Password");
            }if (parentContextMap.containsKey("ssql_Port")) {
                context.ssql_Port = (String) parentContextMap.get("ssql_Port");
            }if (parentContextMap.containsKey("ssql_Schema")) {
                context.ssql_Schema = (String) parentContextMap.get("ssql_Schema");
            }if (parentContextMap.containsKey("ssql_Server")) {
                context.ssql_Server = (String) parentContextMap.get("ssql_Server");
            }if (parentContextMap.containsKey("bonjour")) {
                context.bonjour = (String) parentContextMap.get("bonjour");
            }
        }

        //Resume: init the resumeUtil
        resumeEntryMethodName = ResumeUtil.getResumeEntryMethodName(resuming_checkpoint_path);
        resumeUtil = new ResumeUtil(resuming_logs_dir_path, isChildJob, rootPid);
        resumeUtil.initCommonInfo(pid, rootPid, fatherPid, projectName, jobName, contextStr, jobVersion);

		List<String> parametersToEncrypt = new java.util.ArrayList<String>();
			parametersToEncrypt.add("ssql_Password");
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




this.globalResumeTicket = false;//to run others jobs

try {
errorCode = null;tRunJob_1Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tRunJob_1) {
globalMap.put("tRunJob_1_SUBPROCESS_STATE", -1);

e_tRunJob_1.printStackTrace();

}
try {
errorCode = null;tFixedFlowInput_3Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tFixedFlowInput_3) {
globalMap.put("tFixedFlowInput_3_SUBPROCESS_STATE", -1);

e_tFixedFlowInput_3.printStackTrace();

}

this.globalResumeTicket = true;//to run tPostJob




        end = System.currentTimeMillis();

        if (watch) {
            System.out.println((end-startTime)+" milliseconds");
        }

        endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        if (false) {
            System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : ChildJob1");
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


    }














    private java.util.Map<String, Object> getSharedConnections4REST() {
        java.util.Map<String, Object> connections = new java.util.HashMap<String, Object>();







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
 *     47210 characters generated by Talend Cloud Data Management Platform 
 *     on the September 13, 2019 4:30:14 PM CEST
 ************************************************************************************************/