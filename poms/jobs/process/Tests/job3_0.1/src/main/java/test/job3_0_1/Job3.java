package test.job3_0_1;

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
 * Job: Job3 Purpose: <br>
 * Description:  <br>
 * @author user@talend.com
 * @version 7.1.1.20190228_0243-patch
 * @status 
 */
public class Job3 implements TalendJob {
	static {
		System.setProperty("TalendJob.log", "Job3.log");
	}
	private static org.apache.log4j.Logger log = org.apache.log4j.Logger
			.getLogger(Job3.class);

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

	private final static String defaultCharset = java.nio.charset.Charset
			.defaultCharset().name();

	private final static String utf8Charset = "UTF-8";

	// contains type for every context property
	public class PropertiesWithType extends java.util.Properties {
		private static final long serialVersionUID = 1L;
		private java.util.Map<String, String> propertyTypes = new java.util.HashMap<>();

		public PropertiesWithType(java.util.Properties properties) {
			super(properties);
		}

		public PropertiesWithType() {
			super();
		}

		public void setContextType(String key, String type) {
			propertyTypes.put(key, type);
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

		public ContextProperties(java.util.Properties properties) {
			super(properties);
		}

		public ContextProperties() {
			super();
		}

		public void synchronizeContext() {

			if (ssql_Password != null) {

				this.setProperty("ssql_Password", ssql_Password.toString());

			}

			if (ssql_Port != null) {

				this.setProperty("ssql_Port", ssql_Port.toString());

			}

			if (ssql_Server != null) {

				this.setProperty("ssql_Server", ssql_Server.toString());

			}

			if (ssql_AdditionalParams != null) {

				this.setProperty("ssql_AdditionalParams",
						ssql_AdditionalParams.toString());

			}

			if (ssql_Database != null) {

				this.setProperty("ssql_Database", ssql_Database.toString());

			}

			if (ssql_Schema != null) {

				this.setProperty("ssql_Schema", ssql_Schema.toString());

			}

			if (ssql_Login != null) {

				this.setProperty("ssql_Login", ssql_Login.toString());

			}

		}

		public java.lang.String ssql_Password;

		public java.lang.String getSsql_Password() {
			return this.ssql_Password;
		}

		public String ssql_Port;

		public String getSsql_Port() {
			return this.ssql_Port;
		}

		public String ssql_Server;

		public String getSsql_Server() {
			return this.ssql_Server;
		}

		public String ssql_AdditionalParams;

		public String getSsql_AdditionalParams() {
			return this.ssql_AdditionalParams;
		}

		public String ssql_Database;

		public String getSsql_Database() {
			return this.ssql_Database;
		}

		public String ssql_Schema;

		public String getSsql_Schema() {
			return this.ssql_Schema;
		}

		public String ssql_Login;

		public String getSsql_Login() {
			return this.ssql_Login;
		}
	}

	protected ContextProperties context = new ContextProperties(); // will be
																	// instanciated
																	// by MS.

	public ContextProperties getContext() {
		return this.context;
	}

	private final String jobVersion = "0.1";
	private final String jobName = "Job3";
	private final String projectName = "TEST";
	public Integer errorCode = null;
	private String currentComponent = "";

	private final java.util.Map<String, Object> globalMap = new java.util.HashMap<String, Object>();
	private final static java.util.Map<String, Object> junitGlobalMap = new java.util.HashMap<String, Object>();

	private final java.util.Map<String, Long> start_Hash = new java.util.HashMap<String, Long>();
	private final java.util.Map<String, Long> end_Hash = new java.util.HashMap<String, Long>();
	private final java.util.Map<String, Boolean> ok_Hash = new java.util.HashMap<String, Boolean>();
	public final java.util.List<String[]> globalBuffer = new java.util.ArrayList<String[]>();

	private RunStat runStat = new RunStat();

	// OSGi DataSource
	private final static String KEY_DB_DATASOURCES = "KEY_DB_DATASOURCES";

	private final static String KEY_DB_DATASOURCES_RAW = "KEY_DB_DATASOURCES_RAW";

	public void setDataSources(
			java.util.Map<String, javax.sql.DataSource> dataSources) {
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		for (java.util.Map.Entry<String, javax.sql.DataSource> dataSourceEntry : dataSources
				.entrySet()) {
			talendDataSources.put(
					dataSourceEntry.getKey(),
					new routines.system.TalendDataSource(dataSourceEntry
							.getValue()));
		}
		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap
				.put(KEY_DB_DATASOURCES_RAW,
						new java.util.HashMap<String, javax.sql.DataSource>(
								dataSources));
	}

	private final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
	private final java.io.PrintStream errorMessagePS = new java.io.PrintStream(
			new java.io.BufferedOutputStream(baos));

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

		public void setVirtualComponentName(String virtualComponentName) {
			this.virtualComponentName = virtualComponentName;
		}

		private TalendException(Exception e, String errorComponent,
				final java.util.Map<String, Object> globalMap) {
			this.currentComponent = errorComponent;
			this.globalMap = globalMap;
			this.e = e;
		}

		public Exception getException() {
			return this.e;
		}

		public String getCurrentComponent() {
			return this.currentComponent;
		}

		public String getExceptionCauseMessage(Exception e) {
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
				if (virtualComponentName != null
						&& currentComponent.indexOf(virtualComponentName + "_") == 0) {
					globalMap.put(virtualComponentName + "_ERROR_MESSAGE",
							getExceptionCauseMessage(e));
				}
				globalMap.put(currentComponent + "_ERROR_MESSAGE",
						getExceptionCauseMessage(e));
				System.err.println("Exception in component " + currentComponent
						+ " (" + jobName + ")");
			}
			if (!(e instanceof TDieException)) {
				if (e instanceof TalendException) {
					e.printStackTrace();
				} else {
					e.printStackTrace();
					e.printStackTrace(errorMessagePS);
					Job3.this.exception = e;
				}
			}
			if (!(e instanceof TalendException)) {
				try {
					for (java.lang.reflect.Method m : this.getClass()
							.getEnclosingClass().getMethods()) {
						if (m.getName().compareTo(currentComponent + "_error") == 0) {
							m.invoke(Job3.this, new Object[] { e,
									currentComponent, globalMap });
							break;
						}
					}

					if (!(e instanceof TDieException)) {
					}
				} catch (Exception e) {
					this.e.printStackTrace();
				}
			}
		}
	}

	public void tDBConnection_1_error(Exception exception,
			String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		try {

			if (this.execStat) {
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

	public void tDie_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDie_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFixedFlowInput_1_error(Exception exception,
			String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFixedFlowInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBOutput_2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFixedFlowInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tPrejob_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tPrejob_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBConnection_1_onSubJobError(Exception exception,
			String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread
				.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(),
				ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tDie_1_onSubJobError(Exception exception,
			String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread
				.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(),
				ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tFixedFlowInput_1_onSubJobError(Exception exception,
			String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread
				.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(),
				ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tPrejob_1_onSubJobError(Exception exception,
			String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread
				.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(),
				ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tDBConnection_1Process(
			final java.util.Map<String, Object> globalMap)
			throws TalendException {
		globalMap.put("tDBConnection_1_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception()
						.getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				/**
				 * [tDBConnection_1 begin ] start
				 */

				ok_Hash.put("tDBConnection_1", false);
				start_Hash.put("tDBConnection_1", System.currentTimeMillis());

				currentComponent = "tDBConnection_1";

				int tos_count_tDBConnection_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tDBConnection_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tDBConnection_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tDBConnection_1 = new StringBuilder();
							log4jParamters_tDBConnection_1
									.append("Parameters:");
							log4jParamters_tDBConnection_1.append("DRIVER"
									+ " = " + "JTDS");
							log4jParamters_tDBConnection_1.append(" | ");
							log4jParamters_tDBConnection_1.append("HOST"
									+ " = " + "context.ssql_Server");
							log4jParamters_tDBConnection_1.append(" | ");
							log4jParamters_tDBConnection_1.append("PORT"
									+ " = " + "context.ssql_Port");
							log4jParamters_tDBConnection_1.append(" | ");
							log4jParamters_tDBConnection_1.append("SCHEMA_DB"
									+ " = " + "context.ssql_Schema");
							log4jParamters_tDBConnection_1.append(" | ");
							log4jParamters_tDBConnection_1.append("DBNAME"
									+ " = " + "context.ssql_Database");
							log4jParamters_tDBConnection_1.append(" | ");
							log4jParamters_tDBConnection_1.append("USER"
									+ " = " + "context.ssql_Login");
							log4jParamters_tDBConnection_1.append(" | ");
							log4jParamters_tDBConnection_1
									.append("PASS"
											+ " = "
											+ String.valueOf(
													routines.system.PasswordEncryptUtil
															.encryptPassword(context.ssql_Password))
													.substring(0, 4) + "...");
							log4jParamters_tDBConnection_1.append(" | ");
							log4jParamters_tDBConnection_1.append("PROPERTIES"
									+ " = " + "context.ssql_AdditionalParams");
							log4jParamters_tDBConnection_1.append(" | ");
							log4jParamters_tDBConnection_1
									.append("USE_SHARED_CONNECTION" + " = "
											+ "false");
							log4jParamters_tDBConnection_1.append(" | ");
							log4jParamters_tDBConnection_1
									.append("SPECIFY_DATASOURCE_ALIAS" + " = "
											+ "false");
							log4jParamters_tDBConnection_1.append(" | ");
							log4jParamters_tDBConnection_1.append("AUTO_COMMIT"
									+ " = " + "false");
							log4jParamters_tDBConnection_1.append(" | ");
							log4jParamters_tDBConnection_1
									.append("SHARE_IDENTITY_SETTING" + " = "
											+ "false");
							log4jParamters_tDBConnection_1.append(" | ");
							log4jParamters_tDBConnection_1
									.append("UNIFIED_COMPONENTS" + " = "
											+ "tMSSqlConnection");
							log4jParamters_tDBConnection_1.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tDBConnection_1 - "
										+ (log4jParamters_tDBConnection_1));
						}
					}
					new BytesLimit65535_tDBConnection_1().limitLog4jByte();
				}

				String url_tDBConnection_1 = "jdbc:jtds:sqlserver://"
						+ context.ssql_Server;
				String port_tDBConnection_1 = context.ssql_Port;
				String dbname_tDBConnection_1 = context.ssql_Database;
				if (!"".equals(port_tDBConnection_1)) {
					url_tDBConnection_1 += ":" + context.ssql_Port;
				}
				if (!"".equals(dbname_tDBConnection_1)) {

					url_tDBConnection_1 += "//" + context.ssql_Database;
				}
				url_tDBConnection_1 += ";appName=" + projectName + ";"
						+ context.ssql_AdditionalParams;
				String dbUser_tDBConnection_1 = context.ssql_Login;

				final String decryptedPassword_tDBConnection_1 = context.ssql_Password;
				String dbPwd_tDBConnection_1 = decryptedPassword_tDBConnection_1;

				java.sql.Connection conn_tDBConnection_1 = null;

				String driverClass_tDBConnection_1 = "net.sourceforge.jtds.jdbc.Driver";
				java.lang.Class.forName(driverClass_tDBConnection_1);

				log.debug("tDBConnection_1 - Driver ClassName: "
						+ driverClass_tDBConnection_1 + ".");

				log.debug("tDBConnection_1 - Connection attempt to '"
						+ url_tDBConnection_1 + "' with the username '"
						+ dbUser_tDBConnection_1 + "'.");

				conn_tDBConnection_1 = java.sql.DriverManager.getConnection(
						url_tDBConnection_1, dbUser_tDBConnection_1,
						dbPwd_tDBConnection_1);
				log.debug("tDBConnection_1 - Connection to '"
						+ url_tDBConnection_1 + "' has succeeded.");

				globalMap.put("conn_tDBConnection_1", conn_tDBConnection_1);
				if (null != conn_tDBConnection_1) {

					log.debug("tDBConnection_1 - Connection is set auto commit to 'false'.");
					conn_tDBConnection_1.setAutoCommit(false);
				}

				globalMap.put("dbschema_tDBConnection_1", context.ssql_Schema);

				globalMap.put("db_tDBConnection_1", context.ssql_Database);

				globalMap.put("conn_tDBConnection_1", conn_tDBConnection_1);

				globalMap.put("shareIdentitySetting_tDBConnection_1", false);

				/**
				 * [tDBConnection_1 begin ] stop
				 */

				/**
				 * [tDBConnection_1 main ] start
				 */

				currentComponent = "tDBConnection_1";

				tos_count_tDBConnection_1++;

				/**
				 * [tDBConnection_1 main ] stop
				 */

				/**
				 * [tDBConnection_1 process_data_begin ] start
				 */

				currentComponent = "tDBConnection_1";

				/**
				 * [tDBConnection_1 process_data_begin ] stop
				 */

				/**
				 * [tDBConnection_1 process_data_end ] start
				 */

				currentComponent = "tDBConnection_1";

				/**
				 * [tDBConnection_1 process_data_end ] stop
				 */

				/**
				 * [tDBConnection_1 end ] start
				 */

				currentComponent = "tDBConnection_1";

				if (log.isDebugEnabled())
					log.debug("tDBConnection_1 - " + ("Done."));

				ok_Hash.put("tDBConnection_1", true);
				end_Hash.put("tDBConnection_1", System.currentTimeMillis());

				/**
				 * [tDBConnection_1 end ] stop
				 */
			}// end the resume

		} catch (java.lang.Exception e) {

			if (!(e instanceof TalendException)) {
				log.fatal(currentComponent + " " + e.getMessage(), e);
			}

			TalendException te = new TalendException(e, currentComponent,
					globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tDBConnection_1 finally ] start
				 */

				currentComponent = "tDBConnection_1";

				/**
				 * [tDBConnection_1 finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBConnection_1_SUBPROCESS_STATE", 1);
	}

	public void tDie_1Process(final java.util.Map<String, Object> globalMap)
			throws TalendException {
		globalMap.put("tDie_1_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception()
						.getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				/**
				 * [tDie_1 begin ] start
				 */

				ok_Hash.put("tDie_1", false);
				start_Hash.put("tDie_1", System.currentTimeMillis());

				currentComponent = "tDie_1";

				int tos_count_tDie_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tDie_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tDie_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tDie_1 = new StringBuilder();
							log4jParamters_tDie_1.append("Parameters:");
							log4jParamters_tDie_1.append("MESSAGE" + " = "
									+ "\"the end is near\"");
							log4jParamters_tDie_1.append(" | ");
							log4jParamters_tDie_1.append("CODE" + " = " + "4");
							log4jParamters_tDie_1.append(" | ");
							log4jParamters_tDie_1.append("PRIORITY" + " = "
									+ "5");
							log4jParamters_tDie_1.append(" | ");
							log4jParamters_tDie_1.append("EXIT_JVM" + " = "
									+ "false");
							log4jParamters_tDie_1.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tDie_1 - " + (log4jParamters_tDie_1));
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

				currentComponent = "tDie_1";

				try {
					globalMap.put("tDie_1_DIE_PRIORITY", 5);
					System.err.println("the end is near");

					log.error("tDie_1 - The die message: " + "the end is near");

					globalMap.put("tDie_1_DIE_MESSAGE", "the end is near");
					globalMap.put("tDie_1_DIE_MESSAGES", "the end is near");

				} catch (Exception | Error e_tDie_1) {
					logIgnoredError(
							String.format(
									"tDie_1 - tDie failed to log message due to internal error: %s",
									e_tDie_1), e_tDie_1);
				}

				currentComponent = "tDie_1";
				status = "failure";
				errorCode = new Integer(4);
				globalMap.put("tDie_1_DIE_CODE", errorCode);

				if (true) {
					throw new TDieException();
				}

				tos_count_tDie_1++;

				/**
				 * [tDie_1 main ] stop
				 */

				/**
				 * [tDie_1 process_data_begin ] start
				 */

				currentComponent = "tDie_1";

				/**
				 * [tDie_1 process_data_begin ] stop
				 */

				/**
				 * [tDie_1 process_data_end ] start
				 */

				currentComponent = "tDie_1";

				/**
				 * [tDie_1 process_data_end ] stop
				 */

				/**
				 * [tDie_1 end ] start
				 */

				currentComponent = "tDie_1";

				if (log.isDebugEnabled())
					log.debug("tDie_1 - " + ("Done."));

				ok_Hash.put("tDie_1", true);
				end_Hash.put("tDie_1", System.currentTimeMillis());

				/**
				 * [tDie_1 end ] stop
				 */
			}// end the resume

		} catch (java.lang.Exception e) {

			if (!(e instanceof TalendException)) {
				log.fatal(currentComponent + " " + e.getMessage(), e);
			}

			TalendException te = new TalendException(e, currentComponent,
					globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tDie_1 finally ] start
				 */

				currentComponent = "tDie_1";

				/**
				 * [tDie_1 finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDie_1_SUBPROCESS_STATE", 1);
	}

	public static class row6Struct implements
			routines.system.IPersistableRow<row6Struct> {
		final static byte[] commonByteArrayLock_TEST_Job3 = new byte[0];
		static byte[] commonByteArray_TEST_Job3 = new byte[0];

		public String Prenom;

		public String getPrenom() {
			return this.Prenom;
		}

		public String Nom;

		public String getNom() {
			return this.Nom;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_TEST_Job3.length) {
					if (length < 1024 && commonByteArray_TEST_Job3.length == 0) {
						commonByteArray_TEST_Job3 = new byte[1024];
					} else {
						commonByteArray_TEST_Job3 = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_TEST_Job3, 0, length);
				strReturn = new String(commonByteArray_TEST_Job3, 0, length,
						utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos)
				throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_TEST_Job3) {

				try {

					int length = 0;

					this.Prenom = readString(dis);

					this.Nom = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.Prenom, dos);

				// String

				writeString(this.Nom, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("Prenom=" + Prenom);
			sb.append(",Nom=" + Nom);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (Prenom == null) {
				sb.append("<null>");
			} else {
				sb.append(Prenom);
			}

			sb.append("|");

			if (Nom == null) {
				sb.append("<null>");
			} else {
				sb.append(Nom);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row6Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(),
						object2.toString());
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

	public void tFixedFlowInput_1Process(
			final java.util.Map<String, Object> globalMap)
			throws TalendException {
		globalMap.put("tFixedFlowInput_1_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception()
						.getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				row6Struct row6 = new row6Struct();

				/**
				 * [tDBOutput_2 begin ] start
				 */

				ok_Hash.put("tDBOutput_2", false);
				start_Hash.put("tDBOutput_2", System.currentTimeMillis());

				currentComponent = "tDBOutput_2";

				if (execStat) {
					if (resourceMap.get("inIterateVComp") == null) {

						runStat.updateStatOnConnection("row6" + iterateId, 0, 0);

					}
				}

				int tos_count_tDBOutput_2 = 0;

				if (log.isDebugEnabled())
					log.debug("tDBOutput_2 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tDBOutput_2 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tDBOutput_2 = new StringBuilder();
							log4jParamters_tDBOutput_2.append("Parameters:");
							log4jParamters_tDBOutput_2
									.append("USE_EXISTING_CONNECTION" + " = "
											+ "false");
							log4jParamters_tDBOutput_2.append(" | ");
							log4jParamters_tDBOutput_2.append("DRIVER" + " = "
									+ "JTDS");
							log4jParamters_tDBOutput_2.append(" | ");
							log4jParamters_tDBOutput_2.append("HOST" + " = "
									+ "context.ssql_Server");
							log4jParamters_tDBOutput_2.append(" | ");
							log4jParamters_tDBOutput_2.append("PORT" + " = "
									+ "context.ssql_Port");
							log4jParamters_tDBOutput_2.append(" | ");
							log4jParamters_tDBOutput_2.append("DB_SCHEMA"
									+ " = " + "context.ssql_Schema");
							log4jParamters_tDBOutput_2.append(" | ");
							log4jParamters_tDBOutput_2.append("DBNAME" + " = "
									+ "context.ssql_Database");
							log4jParamters_tDBOutput_2.append(" | ");
							log4jParamters_tDBOutput_2.append("USER" + " = "
									+ "context.ssql_Login");
							log4jParamters_tDBOutput_2.append(" | ");
							log4jParamters_tDBOutput_2
									.append("PASS"
											+ " = "
											+ String.valueOf(
													routines.system.PasswordEncryptUtil
															.encryptPassword(context.ssql_Password))
													.substring(0, 4) + "...");
							log4jParamters_tDBOutput_2.append(" | ");
							log4jParamters_tDBOutput_2.append("TABLE" + " = "
									+ "\"Table_4\"");
							log4jParamters_tDBOutput_2.append(" | ");
							log4jParamters_tDBOutput_2.append("TABLE_ACTION"
									+ " = " + "NONE");
							log4jParamters_tDBOutput_2.append(" | ");
							log4jParamters_tDBOutput_2.append("IDENTITY_INSERT"
									+ " = " + "false");
							log4jParamters_tDBOutput_2.append(" | ");
							log4jParamters_tDBOutput_2.append("DATA_ACTION"
									+ " = " + "INSERT");
							log4jParamters_tDBOutput_2.append(" | ");
							log4jParamters_tDBOutput_2
									.append("SPECIFY_DATASOURCE_ALIAS" + " = "
											+ "false");
							log4jParamters_tDBOutput_2.append(" | ");
							log4jParamters_tDBOutput_2.append("DIE_ON_ERROR"
									+ " = " + "false");
							log4jParamters_tDBOutput_2.append(" | ");
							log4jParamters_tDBOutput_2.append("PROPERTIES"
									+ " = " + "context.ssql_AdditionalParams");
							log4jParamters_tDBOutput_2.append(" | ");
							log4jParamters_tDBOutput_2.append("COMMIT_EVERY"
									+ " = " + "10000");
							log4jParamters_tDBOutput_2.append(" | ");
							log4jParamters_tDBOutput_2.append("ADD_COLS"
									+ " = " + "[]");
							log4jParamters_tDBOutput_2.append(" | ");
							log4jParamters_tDBOutput_2
									.append("USE_FIELD_OPTIONS" + " = "
											+ "false");
							log4jParamters_tDBOutput_2.append(" | ");
							log4jParamters_tDBOutput_2
									.append("IGNORE_DATE_OUTOF_RANGE" + " = "
											+ "false");
							log4jParamters_tDBOutput_2.append(" | ");
							log4jParamters_tDBOutput_2
									.append("ENABLE_DEBUG_MODE" + " = "
											+ "false");
							log4jParamters_tDBOutput_2.append(" | ");
							log4jParamters_tDBOutput_2
									.append("SUPPORT_NULL_WHERE" + " = "
											+ "false");
							log4jParamters_tDBOutput_2.append(" | ");
							log4jParamters_tDBOutput_2.append("USE_BATCH_SIZE"
									+ " = " + "true");
							log4jParamters_tDBOutput_2.append(" | ");
							log4jParamters_tDBOutput_2.append("BATCH_SIZE"
									+ " = " + "10000");
							log4jParamters_tDBOutput_2.append(" | ");
							log4jParamters_tDBOutput_2
									.append("UNIFIED_COMPONENTS" + " = "
											+ "tMSSqlOutput");
							log4jParamters_tDBOutput_2.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tDBOutput_2 - "
										+ (log4jParamters_tDBOutput_2));
						}
					}
					new BytesLimit65535_tDBOutput_2().limitLog4jByte();
				}

				int nb_line_tDBOutput_2 = 0;
				int nb_line_update_tDBOutput_2 = 0;
				int nb_line_inserted_tDBOutput_2 = 0;
				int nb_line_deleted_tDBOutput_2 = 0;
				int nb_line_rejected_tDBOutput_2 = 0;

				int deletedCount_tDBOutput_2 = 0;
				int updatedCount_tDBOutput_2 = 0;
				int insertedCount_tDBOutput_2 = 0;
				int rejectedCount_tDBOutput_2 = 0;
				String dbschema_tDBOutput_2 = null;
				String tableName_tDBOutput_2 = null;
				boolean whetherReject_tDBOutput_2 = false;

				java.util.Calendar calendar_tDBOutput_2 = java.util.Calendar
						.getInstance();
				long year1_tDBOutput_2 = TalendDate.parseDate("yyyy-MM-dd",
						"0001-01-01").getTime();
				long year2_tDBOutput_2 = TalendDate.parseDate("yyyy-MM-dd",
						"1753-01-01").getTime();
				long year10000_tDBOutput_2 = TalendDate.parseDate(
						"yyyy-MM-dd HH:mm:ss", "9999-12-31 24:00:00").getTime();
				long date_tDBOutput_2;

				java.util.Calendar calendar_datetimeoffset_tDBOutput_2 = java.util.Calendar
						.getInstance(java.util.TimeZone.getTimeZone("UTC"));

				java.sql.Connection conn_tDBOutput_2 = null;
				String dbUser_tDBOutput_2 = null;
				dbschema_tDBOutput_2 = context.ssql_Schema;
				String driverClass_tDBOutput_2 = "net.sourceforge.jtds.jdbc.Driver";

				if (log.isDebugEnabled())
					log.debug("tDBOutput_2 - " + ("Driver ClassName: ")
							+ (driverClass_tDBOutput_2) + ("."));
				java.lang.Class.forName(driverClass_tDBOutput_2);
				String port_tDBOutput_2 = context.ssql_Port;
				String dbname_tDBOutput_2 = context.ssql_Database;
				String url_tDBOutput_2 = "jdbc:jtds:sqlserver://"
						+ context.ssql_Server;
				if (!"".equals(port_tDBOutput_2)) {
					url_tDBOutput_2 += ":" + context.ssql_Port;
				}
				if (!"".equals(dbname_tDBOutput_2)) {
					url_tDBOutput_2 += "//" + context.ssql_Database;

				}
				url_tDBOutput_2 += ";appName=" + projectName + ";"
						+ context.ssql_AdditionalParams;
				dbUser_tDBOutput_2 = context.ssql_Login;

				final String decryptedPassword_tDBOutput_2 = context.ssql_Password;

				String dbPwd_tDBOutput_2 = decryptedPassword_tDBOutput_2;
				if (log.isDebugEnabled())
					log.debug("tDBOutput_2 - " + ("Connection attempts to '")
							+ (url_tDBOutput_2) + ("' with the username '")
							+ (dbUser_tDBOutput_2) + ("'."));
				conn_tDBOutput_2 = java.sql.DriverManager.getConnection(
						url_tDBOutput_2, dbUser_tDBOutput_2, dbPwd_tDBOutput_2);
				if (log.isDebugEnabled())
					log.debug("tDBOutput_2 - " + ("Connection to '")
							+ (url_tDBOutput_2) + ("' has succeeded."));

				resourceMap.put("conn_tDBOutput_2", conn_tDBOutput_2);

				conn_tDBOutput_2.setAutoCommit(false);
				int commitEvery_tDBOutput_2 = 10000;
				int commitCounter_tDBOutput_2 = 0;

				if (log.isDebugEnabled())
					log.debug("tDBOutput_2 - "
							+ ("Connection is set auto commit to '")
							+ (conn_tDBOutput_2.getAutoCommit()) + ("'."));
				int batchSize_tDBOutput_2 = 10000;
				int batchSizeCounter_tDBOutput_2 = 0;

				if (dbschema_tDBOutput_2 == null
						|| dbschema_tDBOutput_2.trim().length() == 0) {
					tableName_tDBOutput_2 = "Table_4";
				} else {
					tableName_tDBOutput_2 = dbschema_tDBOutput_2 + "].["
							+ "Table_4";
				}
				int count_tDBOutput_2 = 0;

				String insert_tDBOutput_2 = "INSERT INTO ["
						+ tableName_tDBOutput_2
						+ "] ([Prenom],[Nom]) VALUES (?,?)";
				java.sql.PreparedStatement pstmt_tDBOutput_2 = conn_tDBOutput_2
						.prepareStatement(insert_tDBOutput_2);
				resourceMap.put("pstmt_tDBOutput_2", pstmt_tDBOutput_2);

				/**
				 * [tDBOutput_2 begin ] stop
				 */

				/**
				 * [tFixedFlowInput_1 begin ] start
				 */

				ok_Hash.put("tFixedFlowInput_1", false);
				start_Hash.put("tFixedFlowInput_1", System.currentTimeMillis());

				currentComponent = "tFixedFlowInput_1";

				int tos_count_tFixedFlowInput_1 = 0;

				StringBuilder result_tFixedFlowInput_1 = new StringBuilder();
				result_tFixedFlowInput_1
						.append("Ym9uam91cjthdXJldm9pcg0KaGVsbG87Z29kZGJ5ZQ==");
				String originalFileContent_tFixedFlowInput_1 = "";
				try {
					originalFileContent_tFixedFlowInput_1 = new String(
							(new sun.misc.BASE64Decoder()).decodeBuffer(result_tFixedFlowInput_1
									.toString()), utf8Charset);
				} catch (java.lang.Exception e) {
					e.printStackTrace();
				}

				int nb_line_tFixedFlowInput_1 = 0;

				for (int i_tFixedFlowInput_1 = 0; i_tFixedFlowInput_1 < 1; i_tFixedFlowInput_1++) {

					java.io.InputStream ins_tFixedFlowInput_1 = new java.io.ByteArrayInputStream(
							originalFileContent_tFixedFlowInput_1
									.getBytes(utf8Charset));
					org.talend.fileprocess.FileInputDelimited fid_tFixedFlowInput_1 = new org.talend.fileprocess.FileInputDelimited(
							ins_tFixedFlowInput_1, utf8Charset, ";", "\n",
							true, 0, 0, -1, -1, false);

					while (fid_tFixedFlowInput_1.nextRecord()) {
						nb_line_tFixedFlowInput_1++;
						row6 = new row6Struct();

						if (0 < fid_tFixedFlowInput_1
								.getColumnsCountOfCurrentRow()) {
							String colContent = fid_tFixedFlowInput_1.get(0);
							row6.Prenom = (colContent == null || colContent
									.length() == 0) ? null : colContent;
						} else {

							row6.Prenom = null;

						}

						if (1 < fid_tFixedFlowInput_1
								.getColumnsCountOfCurrentRow()) {
							String colContent = fid_tFixedFlowInput_1.get(1);
							row6.Nom = (colContent == null || colContent
									.length() == 0) ? null : colContent;
						} else {

							row6.Nom = null;

						}

						/**
						 * [tFixedFlowInput_1 begin ] stop
						 */

						/**
						 * [tFixedFlowInput_1 main ] start
						 */

						currentComponent = "tFixedFlowInput_1";

						tos_count_tFixedFlowInput_1++;

						/**
						 * [tFixedFlowInput_1 main ] stop
						 */

						/**
						 * [tFixedFlowInput_1 process_data_begin ] start
						 */

						currentComponent = "tFixedFlowInput_1";

						/**
						 * [tFixedFlowInput_1 process_data_begin ] stop
						 */

						/**
						 * [tDBOutput_2 main ] start
						 */

						currentComponent = "tDBOutput_2";

						// row6
						// row6

						if (execStat) {
							runStat.updateStatOnConnection("row6" + iterateId,
									1, 1);
						}

						if (log.isTraceEnabled()) {
							log.trace("row6 - "
									+ (row6 == null ? "" : row6.toLogString()));
						}

						whetherReject_tDBOutput_2 = false;
						if (row6.Prenom == null) {
							pstmt_tDBOutput_2
									.setNull(1, java.sql.Types.VARCHAR);
						} else {
							pstmt_tDBOutput_2.setString(1, row6.Prenom);
						}

						if (row6.Nom == null) {
							pstmt_tDBOutput_2
									.setNull(2, java.sql.Types.VARCHAR);
						} else {
							pstmt_tDBOutput_2.setString(2, row6.Nom);
						}

						pstmt_tDBOutput_2.addBatch();
						nb_line_tDBOutput_2++;

						if (log.isDebugEnabled())
							log.debug("tDBOutput_2 - " + ("Adding the record ")
									+ (nb_line_tDBOutput_2) + (" to the ")
									+ ("INSERT") + (" batch."));
						batchSizeCounter_tDBOutput_2++;

						// ////////batch execute by batch size///////
						class LimitBytesHelper_tDBOutput_2 {
							public int limitBytePart1(int counter,
									java.sql.PreparedStatement pstmt_tDBOutput_2)
									throws Exception {
								try {

									if (log.isDebugEnabled())
										log.debug("tDBOutput_2 - "
												+ ("Executing the ")
												+ ("INSERT") + (" batch."));
									for (int countEach_tDBOutput_2 : pstmt_tDBOutput_2
											.executeBatch()) {
										if (countEach_tDBOutput_2 == -2
												|| countEach_tDBOutput_2 == -3) {
											break;
										}
										counter += countEach_tDBOutput_2;
									}

									if (log.isDebugEnabled())
										log.debug("tDBOutput_2 - "
												+ ("The ")
												+ ("INSERT")
												+ (" batch execution has succeeded."));
								} catch (java.sql.BatchUpdateException e) {

									int countSum_tDBOutput_2 = 0;
									for (int countEach_tDBOutput_2 : e
											.getUpdateCounts()) {
										counter += (countEach_tDBOutput_2 < 0 ? 0
												: countEach_tDBOutput_2);
									}

									log.error("tDBOutput_2 - "
											+ (e.getMessage()));
									System.err.println(e.getMessage());

								}
								return counter;
							}

							public int limitBytePart2(int counter,
									java.sql.PreparedStatement pstmt_tDBOutput_2)
									throws Exception {
								try {

									if (log.isDebugEnabled())
										log.debug("tDBOutput_2 - "
												+ ("Executing the ")
												+ ("INSERT") + (" batch."));
									for (int countEach_tDBOutput_2 : pstmt_tDBOutput_2
											.executeBatch()) {
										if (countEach_tDBOutput_2 == -2
												|| countEach_tDBOutput_2 == -3) {
											break;
										}
										counter += countEach_tDBOutput_2;
									}

									if (log.isDebugEnabled())
										log.debug("tDBOutput_2 - "
												+ ("The ")
												+ ("INSERT")
												+ (" batch execution has succeeded."));
								} catch (java.sql.BatchUpdateException e) {

									for (int countEach_tDBOutput_2 : e
											.getUpdateCounts()) {
										counter += (countEach_tDBOutput_2 < 0 ? 0
												: countEach_tDBOutput_2);
									}

									log.error("tDBOutput_2 - "
											+ (e.getMessage()));
									System.err.println(e.getMessage());

								}
								return counter;
							}
						}
						if ((batchSize_tDBOutput_2 > 0)
								&& (batchSize_tDBOutput_2 <= batchSizeCounter_tDBOutput_2)) {

							insertedCount_tDBOutput_2 = new LimitBytesHelper_tDBOutput_2()
									.limitBytePart1(insertedCount_tDBOutput_2,
											pstmt_tDBOutput_2);

							batchSizeCounter_tDBOutput_2 = 0;
						}

						// //////////commit every////////////

						commitCounter_tDBOutput_2++;
						if (commitEvery_tDBOutput_2 <= commitCounter_tDBOutput_2) {
							if ((batchSize_tDBOutput_2 > 0)
									&& (batchSizeCounter_tDBOutput_2 > 0)) {

								insertedCount_tDBOutput_2 = new LimitBytesHelper_tDBOutput_2()
										.limitBytePart1(
												insertedCount_tDBOutput_2,
												pstmt_tDBOutput_2);

								batchSizeCounter_tDBOutput_2 = 0;
							}

							if (log.isDebugEnabled())
								log.debug("tDBOutput_2 - "
										+ ("Connection starting to commit ")
										+ (commitCounter_tDBOutput_2)
										+ (" record(s)."));
							conn_tDBOutput_2.commit();

							if (log.isDebugEnabled())
								log.debug("tDBOutput_2 - "
										+ ("Connection commit has succeeded."));
							commitCounter_tDBOutput_2 = 0;
						}

						tos_count_tDBOutput_2++;

						/**
						 * [tDBOutput_2 main ] stop
						 */

						/**
						 * [tDBOutput_2 process_data_begin ] start
						 */

						currentComponent = "tDBOutput_2";

						/**
						 * [tDBOutput_2 process_data_begin ] stop
						 */

						/**
						 * [tDBOutput_2 process_data_end ] start
						 */

						currentComponent = "tDBOutput_2";

						/**
						 * [tDBOutput_2 process_data_end ] stop
						 */

						/**
						 * [tFixedFlowInput_1 process_data_end ] start
						 */

						currentComponent = "tFixedFlowInput_1";

						/**
						 * [tFixedFlowInput_1 process_data_end ] stop
						 */

						/**
						 * [tFixedFlowInput_1 end ] start
						 */

						currentComponent = "tFixedFlowInput_1";

					}
					fid_tFixedFlowInput_1.close();
				}

				globalMap.put("tFixedFlowInput_1_NB_LINE",
						nb_line_tFixedFlowInput_1);

				ok_Hash.put("tFixedFlowInput_1", true);
				end_Hash.put("tFixedFlowInput_1", System.currentTimeMillis());

				/**
				 * [tFixedFlowInput_1 end ] stop
				 */

				/**
				 * [tDBOutput_2 end ] start
				 */

				currentComponent = "tDBOutput_2";

				try {
					int countSum_tDBOutput_2 = 0;
					if (pstmt_tDBOutput_2 != null
							&& batchSizeCounter_tDBOutput_2 > 0) {

						if (log.isDebugEnabled())
							log.debug("tDBOutput_2 - " + ("Executing the ")
									+ ("INSERT") + (" batch."));
						for (int countEach_tDBOutput_2 : pstmt_tDBOutput_2
								.executeBatch()) {
							if (countEach_tDBOutput_2 == -2
									|| countEach_tDBOutput_2 == -3) {
								break;
							}
							countSum_tDBOutput_2 += countEach_tDBOutput_2;
						}

						if (log.isDebugEnabled())
							log.debug("tDBOutput_2 - " + ("The ") + ("INSERT")
									+ (" batch execution has succeeded."));
					}

					insertedCount_tDBOutput_2 += countSum_tDBOutput_2;

				} catch (java.sql.BatchUpdateException e) {

					int countSum_tDBOutput_2 = 0;
					for (int countEach_tDBOutput_2 : e.getUpdateCounts()) {
						countSum_tDBOutput_2 += (countEach_tDBOutput_2 < 0 ? 0
								: countEach_tDBOutput_2);
					}

					insertedCount_tDBOutput_2 += countSum_tDBOutput_2;

					log.error("tDBOutput_2 - " + (e.getMessage()));
					System.err.println(e.getMessage());

				}
				if (pstmt_tDBOutput_2 != null) {

					pstmt_tDBOutput_2.close();
					resourceMap.remove("pstmt_tDBOutput_2");

				}
				resourceMap.put("statementClosed_tDBOutput_2", true);
				if (log.isDebugEnabled())
					log.debug("tDBOutput_2 - "
							+ ("Connection starting to commit ")
							+ (commitCounter_tDBOutput_2) + (" record(s)."));
				conn_tDBOutput_2.commit();

				if (log.isDebugEnabled())
					log.debug("tDBOutput_2 - "
							+ ("Connection commit has succeeded."));
				if (log.isDebugEnabled())
					log.debug("tDBOutput_2 - "
							+ ("Closing the connection to the database."));
				conn_tDBOutput_2.close();
				if (log.isDebugEnabled())
					log.debug("tDBOutput_2 - "
							+ ("Connection to the database has closed."));
				resourceMap.put("finish_tDBOutput_2", true);

				nb_line_deleted_tDBOutput_2 = nb_line_deleted_tDBOutput_2
						+ deletedCount_tDBOutput_2;
				nb_line_update_tDBOutput_2 = nb_line_update_tDBOutput_2
						+ updatedCount_tDBOutput_2;
				nb_line_inserted_tDBOutput_2 = nb_line_inserted_tDBOutput_2
						+ insertedCount_tDBOutput_2;
				nb_line_rejected_tDBOutput_2 = nb_line_rejected_tDBOutput_2
						+ rejectedCount_tDBOutput_2;

				globalMap.put("tDBOutput_2_NB_LINE", nb_line_tDBOutput_2);
				globalMap.put("tDBOutput_2_NB_LINE_UPDATED",
						nb_line_update_tDBOutput_2);
				globalMap.put("tDBOutput_2_NB_LINE_INSERTED",
						nb_line_inserted_tDBOutput_2);
				globalMap.put("tDBOutput_2_NB_LINE_DELETED",
						nb_line_deleted_tDBOutput_2);
				globalMap.put("tDBOutput_2_NB_LINE_REJECTED",
						nb_line_rejected_tDBOutput_2);

				if (log.isDebugEnabled())
					log.debug("tDBOutput_2 - " + ("Has ") + ("inserted")
							+ (" ") + (nb_line_inserted_tDBOutput_2)
							+ (" record(s)."));

				if (execStat) {
					if (resourceMap.get("inIterateVComp") == null
							|| !((Boolean) resourceMap.get("inIterateVComp"))) {
						runStat.updateStatOnConnection("row6" + iterateId, 2, 0);
					}
				}

				if (log.isDebugEnabled())
					log.debug("tDBOutput_2 - " + ("Done."));

				ok_Hash.put("tDBOutput_2", true);
				end_Hash.put("tDBOutput_2", System.currentTimeMillis());

				/**
				 * [tDBOutput_2 end ] stop
				 */

			}// end the resume

		} catch (java.lang.Exception e) {

			if (!(e instanceof TalendException)) {
				log.fatal(currentComponent + " " + e.getMessage(), e);
			}

			TalendException te = new TalendException(e, currentComponent,
					globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tFixedFlowInput_1 finally ] start
				 */

				currentComponent = "tFixedFlowInput_1";

				/**
				 * [tFixedFlowInput_1 finally ] stop
				 */

				/**
				 * [tDBOutput_2 finally ] start
				 */

				currentComponent = "tDBOutput_2";

				try {
					if (resourceMap.get("statementClosed_tDBOutput_2") == null) {
						java.sql.PreparedStatement pstmtToClose_tDBOutput_2 = null;
						if ((pstmtToClose_tDBOutput_2 = (java.sql.PreparedStatement) resourceMap
								.remove("pstmt_tDBOutput_2")) != null) {
							pstmtToClose_tDBOutput_2.close();
						}
					}
				} finally {
					if (resourceMap.get("finish_tDBOutput_2") == null) {
						java.sql.Connection ctn_tDBOutput_2 = null;
						if ((ctn_tDBOutput_2 = (java.sql.Connection) resourceMap
								.get("conn_tDBOutput_2")) != null) {
							try {
								if (log.isDebugEnabled())
									log.debug("tDBOutput_2 - "
											+ ("Closing the connection to the database."));
								ctn_tDBOutput_2.close();
								if (log.isDebugEnabled())
									log.debug("tDBOutput_2 - "
											+ ("Connection to the database has closed."));
							} catch (java.sql.SQLException sqlEx_tDBOutput_2) {
								String errorMessage_tDBOutput_2 = "failed to close the connection in tDBOutput_2 :"
										+ sqlEx_tDBOutput_2.getMessage();
								log.error("tDBOutput_2 - "
										+ (errorMessage_tDBOutput_2));
								System.err.println(errorMessage_tDBOutput_2);
							}
						}
					}
				}

				/**
				 * [tDBOutput_2 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tFixedFlowInput_1_SUBPROCESS_STATE", 1);
	}

	public void tPrejob_1Process(final java.util.Map<String, Object> globalMap)
			throws TalendException {
		globalMap.put("tPrejob_1_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception()
						.getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				/**
				 * [tPrejob_1 begin ] start
				 */

				ok_Hash.put("tPrejob_1", false);
				start_Hash.put("tPrejob_1", System.currentTimeMillis());

				currentComponent = "tPrejob_1";

				int tos_count_tPrejob_1 = 0;

				/**
				 * [tPrejob_1 begin ] stop
				 */

				/**
				 * [tPrejob_1 main ] start
				 */

				currentComponent = "tPrejob_1";

				tos_count_tPrejob_1++;

				/**
				 * [tPrejob_1 main ] stop
				 */

				/**
				 * [tPrejob_1 process_data_begin ] start
				 */

				currentComponent = "tPrejob_1";

				/**
				 * [tPrejob_1 process_data_begin ] stop
				 */

				/**
				 * [tPrejob_1 process_data_end ] start
				 */

				currentComponent = "tPrejob_1";

				/**
				 * [tPrejob_1 process_data_end ] stop
				 */

				/**
				 * [tPrejob_1 end ] start
				 */

				currentComponent = "tPrejob_1";

				ok_Hash.put("tPrejob_1", true);
				end_Hash.put("tPrejob_1", System.currentTimeMillis());

				if (execStat) {
					runStat.updateStatOnConnection("OnComponentOk1", 0, "ok");
				}
				tDBConnection_1Process(globalMap);

				/**
				 * [tPrejob_1 end ] stop
				 */
			}// end the resume

		} catch (java.lang.Exception e) {

			if (!(e instanceof TalendException)) {
				log.fatal(currentComponent + " " + e.getMessage(), e);
			}

			TalendException te = new TalendException(e, currentComponent,
					globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tPrejob_1 finally ] start
				 */

				currentComponent = "tPrejob_1";

				/**
				 * [tPrejob_1 finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tPrejob_1_SUBPROCESS_STATE", 1);
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
			java.util.Map<String, String> threadRunResultMap = new java.util.HashMap<String, String>();
			threadRunResultMap.put("errorCode", null);
			threadRunResultMap.put("status", "");
			return threadRunResultMap;
		};
	};

	private PropertiesWithType context_param = new PropertiesWithType();
	public java.util.Map<String, Object> parentContextMap = new java.util.HashMap<String, Object>();

	public String status = "";

	public static void main(String[] args) {
		final Job3 Job3Class = new Job3();

		int exitCode = Job3Class.runJobInTOS(args);
		if (exitCode == 0) {
			log.info("TalendJob: 'Job3' - Done.");
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

		if (!"".equals(log4jLevel)) {
			if ("trace".equalsIgnoreCase(log4jLevel)) {
				log.setLevel(org.apache.log4j.Level.TRACE);
			} else if ("debug".equalsIgnoreCase(log4jLevel)) {
				log.setLevel(org.apache.log4j.Level.DEBUG);
			} else if ("info".equalsIgnoreCase(log4jLevel)) {
				log.setLevel(org.apache.log4j.Level.INFO);
			} else if ("warn".equalsIgnoreCase(log4jLevel)) {
				log.setLevel(org.apache.log4j.Level.WARN);
			} else if ("error".equalsIgnoreCase(log4jLevel)) {
				log.setLevel(org.apache.log4j.Level.ERROR);
			} else if ("fatal".equalsIgnoreCase(log4jLevel)) {
				log.setLevel(org.apache.log4j.Level.FATAL);
			} else if ("off".equalsIgnoreCase(log4jLevel)) {
				log.setLevel(org.apache.log4j.Level.OFF);
			}
			org.apache.log4j.Logger.getRootLogger().setLevel(log.getLevel());
		}
		log.info("TalendJob: 'Job3' - Start.");

		if (clientHost == null) {
			clientHost = defaultClientHost;
		}

		if (pid == null || "0".equals(pid)) {
			pid = TalendString.getAsciiRandomString(6);
		}

		if (rootPid == null) {
			rootPid = pid;
		}
		if (fatherPid == null) {
			fatherPid = pid;
		} else {
			isChildJob = true;
		}

		if (portStats != null) {
			// portStats = -1; //for testing
			if (portStats < 0 || portStats > 65535) {
				// issue:10869, the portStats is invalid, so this client socket
				// can't open
				System.err.println("The statistics socket port " + portStats
						+ " is invalid.");
				execStat = false;
			}
		} else {
			execStat = false;
		}

		try {
			// call job/subjob with an existing context, like:
			// --context=production. if without this parameter, there will use
			// the default context instead.
			java.io.InputStream inContext = Job3.class.getClassLoader()
					.getResourceAsStream(
							"test/job3_0_1/contexts/" + contextStr
									+ ".properties");
			if (inContext == null) {
				inContext = Job3.class.getClassLoader().getResourceAsStream(
						"config/contexts/" + contextStr + ".properties");
			}
			if (inContext != null && context != null && context.isEmpty()) {
				// defaultProps is in order to keep the original context value
				defaultProps.load(inContext);
				inContext.close();
				context = new ContextProperties(defaultProps);
			} else if (!isDefaultContext) {
				// print info and job continue to run, for case: context_param
				// is not empty.
				System.err.println("Could not find the context " + contextStr);
			}

			if (!context_param.isEmpty()) {
				context.putAll(context_param);
				// set types for params from parentJobs
				for (Object key : context_param.keySet()) {
					String context_key = key.toString();
					String context_type = context_param
							.getContextType(context_key);
					context.setContextType(context_key, context_type);

				}
			}
			context.setContextType("ssql_Password", "id_Password");

			String pwd_ssql_Password_value = context
					.getProperty("ssql_Password");
			context.ssql_Password = null;
			if (pwd_ssql_Password_value != null) {
				if (context_param.containsKey("ssql_Password")) {// no need to
																	// decrypt
																	// if it
																	// come from
																	// program
																	// argument
																	// or parent
																	// job
																	// runtime
					context.ssql_Password = pwd_ssql_Password_value;
				} else if (!pwd_ssql_Password_value.isEmpty()) {
					try {
						context.ssql_Password = routines.system.PasswordEncryptUtil
								.decryptPassword(pwd_ssql_Password_value);
						context.put("ssql_Password", context.ssql_Password);
					} catch (java.lang.RuntimeException e) {
						// do nothing
					}
				}
			}
			context.setContextType("ssql_Port", "id_String");

			context.ssql_Port = (String) context.getProperty("ssql_Port");
			context.setContextType("ssql_Server", "id_String");

			context.ssql_Server = (String) context.getProperty("ssql_Server");
			context.setContextType("ssql_AdditionalParams", "id_String");

			context.ssql_AdditionalParams = (String) context
					.getProperty("ssql_AdditionalParams");
			context.setContextType("ssql_Database", "id_String");

			context.ssql_Database = (String) context
					.getProperty("ssql_Database");
			context.setContextType("ssql_Schema", "id_String");

			context.ssql_Schema = (String) context.getProperty("ssql_Schema");
			context.setContextType("ssql_Login", "id_String");

			context.ssql_Login = (String) context.getProperty("ssql_Login");
		} catch (java.io.IOException ie) {
			System.err.println("Could not load context " + contextStr);
			ie.printStackTrace();
		}

		// get context value from parent directly
		if (parentContextMap != null && !parentContextMap.isEmpty()) {
			if (parentContextMap.containsKey("ssql_Password")) {
				context.ssql_Password = (java.lang.String) parentContextMap
						.get("ssql_Password");
			}
			if (parentContextMap.containsKey("ssql_Port")) {
				context.ssql_Port = (String) parentContextMap.get("ssql_Port");
			}
			if (parentContextMap.containsKey("ssql_Server")) {
				context.ssql_Server = (String) parentContextMap
						.get("ssql_Server");
			}
			if (parentContextMap.containsKey("ssql_AdditionalParams")) {
				context.ssql_AdditionalParams = (String) parentContextMap
						.get("ssql_AdditionalParams");
			}
			if (parentContextMap.containsKey("ssql_Database")) {
				context.ssql_Database = (String) parentContextMap
						.get("ssql_Database");
			}
			if (parentContextMap.containsKey("ssql_Schema")) {
				context.ssql_Schema = (String) parentContextMap
						.get("ssql_Schema");
			}
			if (parentContextMap.containsKey("ssql_Login")) {
				context.ssql_Login = (String) parentContextMap
						.get("ssql_Login");
			}
		}

		// Resume: init the resumeUtil
		resumeEntryMethodName = ResumeUtil
				.getResumeEntryMethodName(resuming_checkpoint_path);
		resumeUtil = new ResumeUtil(resuming_logs_dir_path, isChildJob, rootPid);
		resumeUtil.initCommonInfo(pid, rootPid, fatherPid, projectName,
				jobName, contextStr, jobVersion);

		List<String> parametersToEncrypt = new java.util.ArrayList<String>();
		parametersToEncrypt.add("ssql_Password");
		// Resume: jobStart
		resumeUtil.addLog("JOB_STARTED", "JOB:" + jobName,
				parent_part_launcher, Thread.currentThread().getId() + "", "",
				"", "", "",
				resumeUtil.convertToJsonText(context, parametersToEncrypt));

		if (execStat) {
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

		long startUsedMemory = Runtime.getRuntime().totalMemory()
				- Runtime.getRuntime().freeMemory();
		long endUsedMemory = 0;
		long end = 0;

		startTime = System.currentTimeMillis();

		this.globalResumeTicket = true;// to run tPreJob

		try {
			errorCode = null;
			tPrejob_1Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tPrejob_1) {
			globalMap.put("tPrejob_1_SUBPROCESS_STATE", -1);

			e_tPrejob_1.printStackTrace();

		}

		this.globalResumeTicket = false;// to run others jobs

		try {
			errorCode = null;
			tFixedFlowInput_1Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tFixedFlowInput_1) {
			globalMap.put("tFixedFlowInput_1_SUBPROCESS_STATE", -1);

			e_tFixedFlowInput_1.printStackTrace();

		}

		this.globalResumeTicket = true;// to run tPostJob

		end = System.currentTimeMillis();

		if (watch) {
			System.out.println((end - startTime) + " milliseconds");
		}

		endUsedMemory = Runtime.getRuntime().totalMemory()
				- Runtime.getRuntime().freeMemory();
		if (false) {
			System.out.println((endUsedMemory - startUsedMemory)
					+ " bytes memory increase when running : Job3");
		}

		if (execStat) {
			runStat.updateStatOnJob(RunStat.JOBEND, fatherNode);
			runStat.stopThreadStat();
		}
		int returnCode = 0;
		if (errorCode == null) {
			returnCode = status != null && status.equals("failure") ? 1 : 0;
		} else {
			returnCode = errorCode.intValue();
		}
		resumeUtil.addLog("JOB_ENDED", "JOB:" + jobName, parent_part_launcher,
				Thread.currentThread().getId() + "", "", "" + returnCode, "",
				"", "");

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
		connections.put("conn_tDBConnection_1",
				globalMap.get("conn_tDBConnection_1"));

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
				if (fatherPid == null) {
					context_param.setContextType(keyValue.substring(0, index),
							replaceEscapeChars(keyValue.substring(index + 1)));
				} else { // the subjob won't escape the especial chars
					context_param.setContextType(keyValue.substring(0, index),
							keyValue.substring(index + 1));
				}

			}

		} else if (arg.startsWith("--context_param")) {
			String keyValue = arg.substring(16);
			int index = -1;
			if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
				if (fatherPid == null) {
					context_param.put(keyValue.substring(0, index),
							replaceEscapeChars(keyValue.substring(index + 1)));
				} else { // the subjob won't escape the especial chars
					context_param.put(keyValue.substring(0, index),
							keyValue.substring(index + 1));
				}
			}
		} else if (arg.startsWith("--log4jLevel=")) {
			log4jLevel = arg.substring(13);
		}

	}

	private static final String NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY = "<TALEND_NULL>";

	private final String[][] escapeChars = { { "\\\\", "\\" }, { "\\n", "\n" },
			{ "\\'", "\'" }, { "\\r", "\r" }, { "\\f", "\f" }, { "\\b", "\b" },
			{ "\\t", "\t" } };

	private String replaceEscapeChars(String keyValue) {

		if (keyValue == null || ("").equals(keyValue.trim())) {
			return keyValue;
		}

		StringBuilder result = new StringBuilder();
		int currIndex = 0;
		while (currIndex < keyValue.length()) {
			int index = -1;
			// judege if the left string includes escape chars
			for (String[] strArray : escapeChars) {
				index = keyValue.indexOf(strArray[0], currIndex);
				if (index >= 0) {

					result.append(keyValue.substring(currIndex,
							index + strArray[0].length()).replace(strArray[0],
							strArray[1]));
					currIndex = index + strArray[0].length();
					break;
				}
			}
			// if the left string doesn't include escape chars, append the left
			// into the result
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
 * 72438 characters generated by Talend Cloud Data Management Platform on the
 * September 9, 2019 5:09:22 PM CEST
 ************************************************************************************************/
