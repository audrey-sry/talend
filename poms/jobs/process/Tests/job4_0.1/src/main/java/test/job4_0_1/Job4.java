package test.job4_0_1;

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
 * Job: Job4 Purpose: <br>
 * Description:  <br>
 * @author user@talend.com
 * @version 7.1.1.20190228_0243-patch
 * @status 
 */
public class Job4 implements TalendJob {
	static {
		System.setProperty("TalendJob.log", "Job4.log");
	}
	private static org.apache.log4j.Logger log = org.apache.log4j.Logger
			.getLogger(Job4.class);

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

			if (name != null) {

				this.setProperty("name", name.toString());

			}

			if (rep != null) {

				this.setProperty("rep", rep.toString());

			}

			if (statut_ji != null) {

				this.setProperty("statut_ji", statut_ji.toString());

			}

			if (ssql_cfdp_AdditionalParams != null) {

				this.setProperty("ssql_cfdp_AdditionalParams",
						ssql_cfdp_AdditionalParams.toString());

			}

			if (ssql_cfdp_Database != null) {

				this.setProperty("ssql_cfdp_Database",
						ssql_cfdp_Database.toString());

			}

			if (ssql_cfdp_Login != null) {

				this.setProperty("ssql_cfdp_Login", ssql_cfdp_Login.toString());

			}

			if (ssql_cfdp_Password != null) {

				this.setProperty("ssql_cfdp_Password",
						ssql_cfdp_Password.toString());

			}

			if (ssql_cfdp_Port != null) {

				this.setProperty("ssql_cfdp_Port", ssql_cfdp_Port.toString());

			}

			if (ssql_cfdp_Schema != null) {

				this.setProperty("ssql_cfdp_Schema",
						ssql_cfdp_Schema.toString());

			}

			if (ssql_cfdp_Server != null) {

				this.setProperty("ssql_cfdp_Server",
						ssql_cfdp_Server.toString());

			}

			if (nb_lignes != null) {

				this.setProperty("nb_lignes", nb_lignes.toString());

			}

			if (ssql_test_cfdp_Database != null) {

				this.setProperty("ssql_test_cfdp_Database",
						ssql_test_cfdp_Database.toString());

			}

			if (ssql_test_cfdp_Password != null) {

				this.setProperty("ssql_test_cfdp_Password",
						ssql_test_cfdp_Password.toString());

			}

			if (ssql_test_cfdp_Port != null) {

				this.setProperty("ssql_test_cfdp_Port",
						ssql_test_cfdp_Port.toString());

			}

			if (ssql_test_cfdp_Schema != null) {

				this.setProperty("ssql_test_cfdp_Schema",
						ssql_test_cfdp_Schema.toString());

			}

			if (ssql_test_cfdp_Server != null) {

				this.setProperty("ssql_test_cfdp_Server",
						ssql_test_cfdp_Server.toString());

			}

			if (ssql_test_cfdp_Login != null) {

				this.setProperty("ssql_test_cfdp_Login",
						ssql_test_cfdp_Login.toString());

			}

			if (ssql_test_cfdp_AdditionalParams != null) {

				this.setProperty("ssql_test_cfdp_AdditionalParams",
						ssql_test_cfdp_AdditionalParams.toString());

			}

		}

		public String name;

		public String getName() {
			return this.name;
		}

		public String rep;

		public String getRep() {
			return this.rep;
		}

		public String statut_ji;

		public String getStatut_ji() {
			return this.statut_ji;
		}

		public String ssql_cfdp_AdditionalParams;

		public String getSsql_cfdp_AdditionalParams() {
			return this.ssql_cfdp_AdditionalParams;
		}

		public String ssql_cfdp_Database;

		public String getSsql_cfdp_Database() {
			return this.ssql_cfdp_Database;
		}

		public String ssql_cfdp_Login;

		public String getSsql_cfdp_Login() {
			return this.ssql_cfdp_Login;
		}

		public java.lang.String ssql_cfdp_Password;

		public java.lang.String getSsql_cfdp_Password() {
			return this.ssql_cfdp_Password;
		}

		public String ssql_cfdp_Port;

		public String getSsql_cfdp_Port() {
			return this.ssql_cfdp_Port;
		}

		public String ssql_cfdp_Schema;

		public String getSsql_cfdp_Schema() {
			return this.ssql_cfdp_Schema;
		}

		public String ssql_cfdp_Server;

		public String getSsql_cfdp_Server() {
			return this.ssql_cfdp_Server;
		}

		public Integer nb_lignes;

		public Integer getNb_lignes() {
			return this.nb_lignes;
		}

		public String ssql_test_cfdp_Database;

		public String getSsql_test_cfdp_Database() {
			return this.ssql_test_cfdp_Database;
		}

		public java.lang.String ssql_test_cfdp_Password;

		public java.lang.String getSsql_test_cfdp_Password() {
			return this.ssql_test_cfdp_Password;
		}

		public String ssql_test_cfdp_Port;

		public String getSsql_test_cfdp_Port() {
			return this.ssql_test_cfdp_Port;
		}

		public String ssql_test_cfdp_Schema;

		public String getSsql_test_cfdp_Schema() {
			return this.ssql_test_cfdp_Schema;
		}

		public String ssql_test_cfdp_Server;

		public String getSsql_test_cfdp_Server() {
			return this.ssql_test_cfdp_Server;
		}

		public String ssql_test_cfdp_Login;

		public String getSsql_test_cfdp_Login() {
			return this.ssql_test_cfdp_Login;
		}

		public String ssql_test_cfdp_AdditionalParams;

		public String getSsql_test_cfdp_AdditionalParams() {
			return this.ssql_test_cfdp_AdditionalParams;
		}
	}

	protected ContextProperties context = new ContextProperties(); // will be
																	// instanciated
																	// by MS.

	public ContextProperties getContext() {
		return this.context;
	}

	private final String jobVersion = "0.1";
	private final String jobName = "Job4";
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
					Job4.this.exception = e;
				}
			}
			if (!(e instanceof TalendException)) {
				try {
					for (java.lang.reflect.Method m : this.getClass()
							.getEnclosingClass().getMethods()) {
						if (m.getName().compareTo(currentComponent + "_error") == 0) {
							m.invoke(Job4.this, new Object[] { e,
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

	public void tDBCommit_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBCommit_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBConnection_1_error(Exception exception,
			String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		tDBConnection_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDie_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDie_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tLogRow_4_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBRow_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBRow_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tPrejob_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tPrejob_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBCommit_1_onSubJobError(Exception exception,
			String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread
				.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(),
				ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tDBConnection_1_onSubJobError(Exception exception,
			String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread
				.currentThread().getId() + "", "ERROR", "",
				exception.getMessage(),
				ResumeUtil.getExceptionStackTrace(exception), "");

		try {

			if (this.execStat) {
				runStat.updateStatOnConnection("OnSubjobError1", 0, "error");
			}

			errorCode = null;
			tDie_1Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void tDie_1_onSubJobError(Exception exception,
			String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread
				.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(),
				ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tDBInput_2_onSubJobError(Exception exception,
			String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread
				.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(),
				ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tDBRow_1_onSubJobError(Exception exception,
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

	public void tDBCommit_1Process(final java.util.Map<String, Object> globalMap)
			throws TalendException {
		globalMap.put("tDBCommit_1_SUBPROCESS_STATE", 0);

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
				 * [tDBCommit_1 begin ] start
				 */

				ok_Hash.put("tDBCommit_1", false);
				start_Hash.put("tDBCommit_1", System.currentTimeMillis());

				currentComponent = "tDBCommit_1";

				int tos_count_tDBCommit_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tDBCommit_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tDBCommit_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tDBCommit_1 = new StringBuilder();
							log4jParamters_tDBCommit_1.append("Parameters:");
							log4jParamters_tDBCommit_1.append("CONNECTION"
									+ " = " + "tDBConnection_1");
							log4jParamters_tDBCommit_1.append(" | ");
							log4jParamters_tDBCommit_1.append("CLOSE" + " = "
									+ "true");
							log4jParamters_tDBCommit_1.append(" | ");
							log4jParamters_tDBCommit_1
									.append("UNIFIED_COMPONENTS" + " = "
											+ "tMSSqlCommit");
							log4jParamters_tDBCommit_1.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tDBCommit_1 - "
										+ (log4jParamters_tDBCommit_1));
						}
					}
					new BytesLimit65535_tDBCommit_1().limitLog4jByte();
				}

				/**
				 * [tDBCommit_1 begin ] stop
				 */

				/**
				 * [tDBCommit_1 main ] start
				 */

				currentComponent = "tDBCommit_1";

				java.sql.Connection conn_tDBCommit_1 = (java.sql.Connection) globalMap
						.get("conn_tDBConnection_1");
				if (conn_tDBCommit_1 != null && !conn_tDBCommit_1.isClosed()) {

					try {

						log.debug("tDBCommit_1 - Connection 'tDBConnection_1' starting to commit.");

						conn_tDBCommit_1.commit();

						log.debug("tDBCommit_1 - Connection 'tDBConnection_1' commit has succeeded.");

					} finally {

						log.debug("tDBCommit_1 - Closing the connection 'tDBConnection_1' to the database.");

						conn_tDBCommit_1.close();

						log.debug("tDBCommit_1 - Connection 'tDBConnection_1' to the database closed.");

					}

				}

				tos_count_tDBCommit_1++;

				/**
				 * [tDBCommit_1 main ] stop
				 */

				/**
				 * [tDBCommit_1 process_data_begin ] start
				 */

				currentComponent = "tDBCommit_1";

				/**
				 * [tDBCommit_1 process_data_begin ] stop
				 */

				/**
				 * [tDBCommit_1 process_data_end ] start
				 */

				currentComponent = "tDBCommit_1";

				/**
				 * [tDBCommit_1 process_data_end ] stop
				 */

				/**
				 * [tDBCommit_1 end ] start
				 */

				currentComponent = "tDBCommit_1";

				if (log.isDebugEnabled())
					log.debug("tDBCommit_1 - " + ("Done."));

				ok_Hash.put("tDBCommit_1", true);
				end_Hash.put("tDBCommit_1", System.currentTimeMillis());

				/**
				 * [tDBCommit_1 end ] stop
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
				 * [tDBCommit_1 finally ] start
				 */

				currentComponent = "tDBCommit_1";

				/**
				 * [tDBCommit_1 finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBCommit_1_SUBPROCESS_STATE", 1);
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
									+ " = " + "context.ssql_cfdp_Server");
							log4jParamters_tDBConnection_1.append(" | ");
							log4jParamters_tDBConnection_1.append("PORT"
									+ " = " + "context.ssql_cfdp_Port");
							log4jParamters_tDBConnection_1.append(" | ");
							log4jParamters_tDBConnection_1.append("SCHEMA_DB"
									+ " = " + "context.ssql_cfdp_Schema");
							log4jParamters_tDBConnection_1.append(" | ");
							log4jParamters_tDBConnection_1.append("DBNAME"
									+ " = " + "context.ssql_cfdp_Database");
							log4jParamters_tDBConnection_1.append(" | ");
							log4jParamters_tDBConnection_1.append("USER"
									+ " = " + "context.ssql_cfdp_Login");
							log4jParamters_tDBConnection_1.append(" | ");
							log4jParamters_tDBConnection_1
									.append("PASS"
											+ " = "
											+ String.valueOf(
													routines.system.PasswordEncryptUtil
															.encryptPassword(context.ssql_cfdp_Password))
													.substring(0, 4) + "...");
							log4jParamters_tDBConnection_1.append(" | ");
							log4jParamters_tDBConnection_1.append("PROPERTIES"
									+ " = "
									+ "context.ssql_cfdp_AdditionalParams");
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
						+ context.ssql_cfdp_Server;
				String port_tDBConnection_1 = context.ssql_cfdp_Port;
				String dbname_tDBConnection_1 = context.ssql_cfdp_Database;
				if (!"".equals(port_tDBConnection_1)) {
					url_tDBConnection_1 += ":" + context.ssql_cfdp_Port;
				}
				if (!"".equals(dbname_tDBConnection_1)) {

					url_tDBConnection_1 += "//" + context.ssql_cfdp_Database;
				}
				url_tDBConnection_1 += ";appName=" + projectName + ";"
						+ context.ssql_cfdp_AdditionalParams;
				String dbUser_tDBConnection_1 = context.ssql_cfdp_Login;

				final String decryptedPassword_tDBConnection_1 = context.ssql_cfdp_Password;
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

				globalMap.put("dbschema_tDBConnection_1",
						context.ssql_cfdp_Schema);

				globalMap.put("db_tDBConnection_1", context.ssql_cfdp_Database);

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

	public static class row9Struct implements
			routines.system.IPersistableRow<row9Struct> {
		final static byte[] commonByteArrayLock_TEST_Job4 = new byte[0];
		static byte[] commonByteArray_TEST_Job4 = new byte[0];

		public Integer SCOPE_IDENTITY;

		public Integer getSCOPE_IDENTITY() {
			return this.SCOPE_IDENTITY;
		}

		private Integer readInteger(ObjectInputStream dis) throws IOException {
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

		private void writeInteger(Integer intNum, ObjectOutputStream dos)
				throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_TEST_Job4) {

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

				writeInteger(this.SCOPE_IDENTITY, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("SCOPE_IDENTITY=" + String.valueOf(SCOPE_IDENTITY));
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (SCOPE_IDENTITY == null) {
				sb.append("<null>");
			} else {
				sb.append(SCOPE_IDENTITY);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row9Struct other) {

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

	public void tDBInput_2Process(final java.util.Map<String, Object> globalMap)
			throws TalendException {
		globalMap.put("tDBInput_2_SUBPROCESS_STATE", 0);

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

				row9Struct row9 = new row9Struct();

				/**
				 * [tLogRow_4 begin ] start
				 */

				ok_Hash.put("tLogRow_4", false);
				start_Hash.put("tLogRow_4", System.currentTimeMillis());

				currentComponent = "tLogRow_4";

				if (execStat) {
					if (resourceMap.get("inIterateVComp") == null) {

						runStat.updateStatOnConnection("row9" + iterateId, 0, 0);

					}
				}

				int tos_count_tLogRow_4 = 0;

				if (log.isDebugEnabled())
					log.debug("tLogRow_4 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tLogRow_4 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tLogRow_4 = new StringBuilder();
							log4jParamters_tLogRow_4.append("Parameters:");
							log4jParamters_tLogRow_4.append("BASIC_MODE"
									+ " = " + "false");
							log4jParamters_tLogRow_4.append(" | ");
							log4jParamters_tLogRow_4.append("TABLE_PRINT"
									+ " = " + "true");
							log4jParamters_tLogRow_4.append(" | ");
							log4jParamters_tLogRow_4.append("VERTICAL" + " = "
									+ "false");
							log4jParamters_tLogRow_4.append(" | ");
							log4jParamters_tLogRow_4
									.append("PRINT_CONTENT_WITH_LOG4J" + " = "
											+ "true");
							log4jParamters_tLogRow_4.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tLogRow_4 - "
										+ (log4jParamters_tLogRow_4));
						}
					}
					new BytesLimit65535_tLogRow_4().limitLog4jByte();
				}

				// /////////////////////

				class Util_tLogRow_4 {

					String[] des_top = { ".", ".", "-", "+" };

					String[] des_head = { "|=", "=|", "-", "+" };

					String[] des_bottom = { "'", "'", "-", "+" };

					String name = "";

					java.util.List<String[]> list = new java.util.ArrayList<String[]>();

					int[] colLengths = new int[1];

					public void addRow(String[] row) {

						for (int i = 0; i < 1; i++) {
							if (row[i] != null) {
								colLengths[i] = Math.max(colLengths[i],
										row[i].length());
							}
						}
						list.add(row);
					}

					public void setTableName(String name) {

						this.name = name;
					}

					public StringBuilder format() {

						StringBuilder sb = new StringBuilder();

						sb.append(print(des_top));

						int totals = 0;
						for (int i = 0; i < colLengths.length; i++) {
							totals = totals + colLengths[i];
						}

						// name
						sb.append("|");
						int k = 0;
						for (k = 0; k < (totals + 0 - name.length()) / 2; k++) {
							sb.append(' ');
						}
						sb.append(name);
						for (int i = 0; i < totals + 0 - name.length() - k; i++) {
							sb.append(' ');
						}
						sb.append("|\n");

						// head and rows
						sb.append(print(des_head));
						for (int i = 0; i < list.size(); i++) {

							String[] row = list.get(i);

							java.util.Formatter formatter = new java.util.Formatter(
									new StringBuilder());

							StringBuilder sbformat = new StringBuilder();
							sbformat.append("|%1$-");
							sbformat.append(colLengths[0]);
							sbformat.append("s");

							sbformat.append("|\n");

							formatter.format(sbformat.toString(),
									(Object[]) row);

							sb.append(formatter.toString());
							if (i == 0)
								sb.append(print(des_head)); // print the head
						}

						// end
						sb.append(print(des_bottom));
						return sb;
					}

					private StringBuilder print(String[] fillChars) {
						StringBuilder sb = new StringBuilder();
						// first column
						sb.append(fillChars[0]);

						// last column
						for (int i = 0; i < colLengths[0]
								- fillChars[0].length() - fillChars[1].length()
								+ 2; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[1]);
						sb.append("\n");
						return sb;
					}

					public boolean isTableEmpty() {
						if (list.size() > 1)
							return false;
						return true;
					}
				}
				Util_tLogRow_4 util_tLogRow_4 = new Util_tLogRow_4();
				util_tLogRow_4.setTableName("tLogRow_4");
				util_tLogRow_4.addRow(new String[] { "SCOPE_IDENTITY", });
				StringBuilder strBuffer_tLogRow_4 = null;
				int nb_line_tLogRow_4 = 0;
				// /////////////////////

				/**
				 * [tLogRow_4 begin ] stop
				 */

				/**
				 * [tDBInput_2 begin ] start
				 */

				ok_Hash.put("tDBInput_2", false);
				start_Hash.put("tDBInput_2", System.currentTimeMillis());

				currentComponent = "tDBInput_2";

				int tos_count_tDBInput_2 = 0;

				if (log.isDebugEnabled())
					log.debug("tDBInput_2 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tDBInput_2 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tDBInput_2 = new StringBuilder();
							log4jParamters_tDBInput_2.append("Parameters:");
							log4jParamters_tDBInput_2
									.append("USE_EXISTING_CONNECTION" + " = "
											+ "true");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("CONNECTION"
									+ " = " + "tDBConnection_1");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("TABLE" + " = "
									+ "\"\"");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("QUERYSTORE"
									+ " = " + "\"\"");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2
									.append("QUERY"
											+ " = "
											+ "\"SELECT SCOPE_IDENTITY() AS [SCOPE_IDENTITY]\"");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("TRIM_ALL_COLUMN"
									+ " = " + "false");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("TRIM_COLUMN"
									+ " = " + "[{TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("SCOPE_IDENTITY")
									+ "}]");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2
									.append("UNIFIED_COMPONENTS" + " = "
											+ "tMSSqlInput");
							log4jParamters_tDBInput_2.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tDBInput_2 - "
										+ (log4jParamters_tDBInput_2));
						}
					}
					new BytesLimit65535_tDBInput_2().limitLog4jByte();
				}

				org.talend.designer.components.util.mssql.MSSqlGenerateTimestampUtil mssqlGTU_tDBInput_2 = org.talend.designer.components.util.mssql.MSSqlUtilFactory
						.getMSSqlGenerateTimestampUtil();

				java.util.List<String> talendToDBList_tDBInput_2 = new java.util.ArrayList();
				String[] talendToDBArray_tDBInput_2 = new String[] { "FLOAT",
						"NUMERIC", "NUMERIC IDENTITY", "DECIMAL",
						"DECIMAL IDENTITY", "REAL" };
				java.util.Collections.addAll(talendToDBList_tDBInput_2,
						talendToDBArray_tDBInput_2);
				int nb_line_tDBInput_2 = 0;
				java.sql.Connection conn_tDBInput_2 = null;
				conn_tDBInput_2 = (java.sql.Connection) globalMap
						.get("conn_tDBConnection_1");
				if (conn_tDBInput_2 != null) {
					if (conn_tDBInput_2.getMetaData() != null) {

						log.debug("tDBInput_2 - Uses an existing connection with username '"
								+ conn_tDBInput_2.getMetaData().getUserName()
								+ "'. Connection URL: "
								+ conn_tDBInput_2.getMetaData().getURL() + ".");

					}
				}

				String dbschema_tDBInput_2 = (String) globalMap
						.get("dbschema_tDBConnection_1");

				java.sql.Statement stmt_tDBInput_2 = conn_tDBInput_2
						.createStatement();

				String dbquery_tDBInput_2 = "SELECT SCOPE_IDENTITY() AS [SCOPE_IDENTITY]";

				log.debug("tDBInput_2 - Executing the query: '"
						+ dbquery_tDBInput_2 + "'.");

				globalMap.put("tDBInput_2_QUERY", dbquery_tDBInput_2);
				java.sql.ResultSet rs_tDBInput_2 = null;

				try {
					rs_tDBInput_2 = stmt_tDBInput_2
							.executeQuery(dbquery_tDBInput_2);
					java.sql.ResultSetMetaData rsmd_tDBInput_2 = rs_tDBInput_2
							.getMetaData();
					int colQtyInRs_tDBInput_2 = rsmd_tDBInput_2
							.getColumnCount();

					String tmpContent_tDBInput_2 = null;

					log.debug("tDBInput_2 - Retrieving records from the database.");

					while (rs_tDBInput_2.next()) {
						nb_line_tDBInput_2++;

						if (colQtyInRs_tDBInput_2 < 1) {
							row9.SCOPE_IDENTITY = null;
						} else {

							if (rs_tDBInput_2.getObject(1) != null) {
								row9.SCOPE_IDENTITY = rs_tDBInput_2.getInt(1);
							} else {
								row9.SCOPE_IDENTITY = null;
							}
						}

						log.debug("tDBInput_2 - Retrieving the record "
								+ nb_line_tDBInput_2 + ".");

						/**
						 * [tDBInput_2 begin ] stop
						 */

						/**
						 * [tDBInput_2 main ] start
						 */

						currentComponent = "tDBInput_2";

						tos_count_tDBInput_2++;

						/**
						 * [tDBInput_2 main ] stop
						 */

						/**
						 * [tDBInput_2 process_data_begin ] start
						 */

						currentComponent = "tDBInput_2";

						/**
						 * [tDBInput_2 process_data_begin ] stop
						 */

						/**
						 * [tLogRow_4 main ] start
						 */

						currentComponent = "tLogRow_4";

						// row9
						// row9

						if (execStat) {
							runStat.updateStatOnConnection("row9" + iterateId,
									1, 1);
						}

						if (log.isTraceEnabled()) {
							log.trace("row9 - "
									+ (row9 == null ? "" : row9.toLogString()));
						}

						// /////////////////////

						String[] row_tLogRow_4 = new String[1];

						if (row9.SCOPE_IDENTITY != null) { //
							row_tLogRow_4[0] = String
									.valueOf(row9.SCOPE_IDENTITY);

						} //

						util_tLogRow_4.addRow(row_tLogRow_4);
						nb_line_tLogRow_4++;
						log.info("tLogRow_4 - Content of row "
								+ nb_line_tLogRow_4 + ": "
								+ TalendString.unionString("|", row_tLogRow_4));
						// ////

						// ////

						// /////////////////////

						tos_count_tLogRow_4++;

						/**
						 * [tLogRow_4 main ] stop
						 */

						/**
						 * [tLogRow_4 process_data_begin ] start
						 */

						currentComponent = "tLogRow_4";

						/**
						 * [tLogRow_4 process_data_begin ] stop
						 */

						/**
						 * [tLogRow_4 process_data_end ] start
						 */

						currentComponent = "tLogRow_4";

						/**
						 * [tLogRow_4 process_data_end ] stop
						 */

						/**
						 * [tDBInput_2 process_data_end ] start
						 */

						currentComponent = "tDBInput_2";

						/**
						 * [tDBInput_2 process_data_end ] stop
						 */

						/**
						 * [tDBInput_2 end ] start
						 */

						currentComponent = "tDBInput_2";

					}
				} finally {
					if (rs_tDBInput_2 != null) {
						rs_tDBInput_2.close();
					}
					if (stmt_tDBInput_2 != null) {
						stmt_tDBInput_2.close();
					}
				}
				globalMap.put("tDBInput_2_NB_LINE", nb_line_tDBInput_2);
				log.debug("tDBInput_2 - Retrieved records count: "
						+ nb_line_tDBInput_2 + " .");

				if (log.isDebugEnabled())
					log.debug("tDBInput_2 - " + ("Done."));

				ok_Hash.put("tDBInput_2", true);
				end_Hash.put("tDBInput_2", System.currentTimeMillis());

				/**
				 * [tDBInput_2 end ] stop
				 */

				/**
				 * [tLogRow_4 end ] start
				 */

				currentComponent = "tLogRow_4";

				// ////

				java.io.PrintStream consoleOut_tLogRow_4 = null;
				if (globalMap.get("tLogRow_CONSOLE") != null) {
					consoleOut_tLogRow_4 = (java.io.PrintStream) globalMap
							.get("tLogRow_CONSOLE");
				} else {
					consoleOut_tLogRow_4 = new java.io.PrintStream(
							new java.io.BufferedOutputStream(System.out));
					globalMap.put("tLogRow_CONSOLE", consoleOut_tLogRow_4);
				}

				consoleOut_tLogRow_4
						.println(util_tLogRow_4.format().toString());
				consoleOut_tLogRow_4.flush();
				// ////
				globalMap.put("tLogRow_4_NB_LINE", nb_line_tLogRow_4);
				if (log.isInfoEnabled())
					log.info("tLogRow_4 - " + ("Printed row count: ")
							+ (nb_line_tLogRow_4) + ("."));

				// /////////////////////

				if (execStat) {
					if (resourceMap.get("inIterateVComp") == null
							|| !((Boolean) resourceMap.get("inIterateVComp"))) {
						runStat.updateStatOnConnection("row9" + iterateId, 2, 0);
					}
				}

				if (log.isDebugEnabled())
					log.debug("tLogRow_4 - " + ("Done."));

				ok_Hash.put("tLogRow_4", true);
				end_Hash.put("tLogRow_4", System.currentTimeMillis());

				/**
				 * [tLogRow_4 end ] stop
				 */

			}// end the resume

			if (resumeEntryMethodName == null || globalResumeTicket) {
				resumeUtil
						.addLog("CHECKPOINT",
								"CONNECTION:SUBJOB_OK:tDBInput_2:OnSubjobOk",
								"", Thread.currentThread().getId() + "", "",
								"", "", "", "");
			}

			if (execStat) {
				runStat.updateStatOnConnection("OnSubjobOk3", 0, "ok");
			}

			tDBCommit_1Process(globalMap);

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
				 * [tDBInput_2 finally ] start
				 */

				currentComponent = "tDBInput_2";

				/**
				 * [tDBInput_2 finally ] stop
				 */

				/**
				 * [tLogRow_4 finally ] start
				 */

				currentComponent = "tLogRow_4";

				/**
				 * [tLogRow_4 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBInput_2_SUBPROCESS_STATE", 1);
	}

	public void tDBRow_1Process(final java.util.Map<String, Object> globalMap)
			throws TalendException {
		globalMap.put("tDBRow_1_SUBPROCESS_STATE", 0);

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
				 * [tDBRow_1 begin ] start
				 */

				ok_Hash.put("tDBRow_1", false);
				start_Hash.put("tDBRow_1", System.currentTimeMillis());

				currentComponent = "tDBRow_1";

				int tos_count_tDBRow_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tDBRow_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tDBRow_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tDBRow_1 = new StringBuilder();
							log4jParamters_tDBRow_1.append("Parameters:");
							log4jParamters_tDBRow_1
									.append("USE_EXISTING_CONNECTION" + " = "
											+ "true");
							log4jParamters_tDBRow_1.append(" | ");
							log4jParamters_tDBRow_1.append("CONNECTION" + " = "
									+ "tDBConnection_1");
							log4jParamters_tDBRow_1.append(" | ");
							log4jParamters_tDBRow_1.append("IDENTITY_INSERT"
									+ " = " + "false");
							log4jParamters_tDBRow_1.append(" | ");
							log4jParamters_tDBRow_1.append("QUERYSTORE" + " = "
									+ "\"\"");
							log4jParamters_tDBRow_1.append(" | ");
							log4jParamters_tDBRow_1
									.append("QUERY"
											+ " = "
											+ "\"insert into SUIVITRAITEMENT (nom_fichier) VALUES ('Rosalie1');  insert into PARTENAIRE (code) values ('PART05');\"");
							log4jParamters_tDBRow_1.append(" | ");
							log4jParamters_tDBRow_1.append("DIE_ON_ERROR"
									+ " = " + "false");
							log4jParamters_tDBRow_1.append(" | ");
							log4jParamters_tDBRow_1
									.append("PROPAGATE_RECORD_SET" + " = "
											+ "false");
							log4jParamters_tDBRow_1.append(" | ");
							log4jParamters_tDBRow_1
									.append("USE_PREPAREDSTATEMENT" + " = "
											+ "false");
							log4jParamters_tDBRow_1.append(" | ");
							log4jParamters_tDBRow_1.append("UNIFIED_COMPONENTS"
									+ " = " + "tMSSqlRow");
							log4jParamters_tDBRow_1.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tDBRow_1 - "
										+ (log4jParamters_tDBRow_1));
						}
					}
					new BytesLimit65535_tDBRow_1().limitLog4jByte();
				}

				java.sql.Connection conn_tDBRow_1 = null;
				String query_tDBRow_1 = "";
				boolean whetherReject_tDBRow_1 = false;
				conn_tDBRow_1 = (java.sql.Connection) globalMap
						.get("conn_tDBConnection_1");

				if (conn_tDBRow_1 != null) {
					if (conn_tDBRow_1.getMetaData() != null) {

						log.debug("tDBRow_1 - Uses an existing connection with username '"
								+ conn_tDBRow_1.getMetaData().getUserName()
								+ "'. Connection URL: "
								+ conn_tDBRow_1.getMetaData().getURL() + ".");

					}
				}

				resourceMap.put("conn_tDBRow_1", conn_tDBRow_1);
				java.sql.Statement stmt_tDBRow_1 = conn_tDBRow_1
						.createStatement();
				resourceMap.put("stmt_tDBRow_1", stmt_tDBRow_1);

				/**
				 * [tDBRow_1 begin ] stop
				 */

				/**
				 * [tDBRow_1 main ] start
				 */

				currentComponent = "tDBRow_1";

				log.debug("tDBRow_1 - Executing the query: '"
						+ "insert into SUIVITRAITEMENT (nom_fichier) VALUES ('Rosalie1');\ninsert into PARTENAIRE (code) values ('PART05');"
						+ "'.");

				query_tDBRow_1 = "insert into SUIVITRAITEMENT (nom_fichier) VALUES ('Rosalie1');\ninsert into PARTENAIRE (code) values ('PART05');";
				whetherReject_tDBRow_1 = false;
				globalMap.put("tDBRow_1_QUERY", query_tDBRow_1);
				try {
					stmt_tDBRow_1.execute(query_tDBRow_1);

					log.debug("tDBRow_1 - Execute the query: '"
							+ "insert into SUIVITRAITEMENT (nom_fichier) VALUES ('Rosalie1');\ninsert into PARTENAIRE (code) values ('PART05');"
							+ "' has finished.");

				} catch (java.lang.Exception e) {
					whetherReject_tDBRow_1 = true;

					log.error("tDBRow_1 - " + e.getMessage());

					System.err.print(e.getMessage());

				}

				if (!whetherReject_tDBRow_1) {

				}

				tos_count_tDBRow_1++;

				/**
				 * [tDBRow_1 main ] stop
				 */

				/**
				 * [tDBRow_1 process_data_begin ] start
				 */

				currentComponent = "tDBRow_1";

				/**
				 * [tDBRow_1 process_data_begin ] stop
				 */

				/**
				 * [tDBRow_1 process_data_end ] start
				 */

				currentComponent = "tDBRow_1";

				/**
				 * [tDBRow_1 process_data_end ] stop
				 */

				/**
				 * [tDBRow_1 end ] start
				 */

				currentComponent = "tDBRow_1";

				stmt_tDBRow_1.close();
				resourceMap.remove("stmt_tDBRow_1");
				resourceMap.put("statementClosed_tDBRow_1", true);
				resourceMap.put("finish_tDBRow_1", true);

				if (log.isDebugEnabled())
					log.debug("tDBRow_1 - " + ("Done."));

				ok_Hash.put("tDBRow_1", true);
				end_Hash.put("tDBRow_1", System.currentTimeMillis());

				/**
				 * [tDBRow_1 end ] stop
				 */
			}// end the resume

			if (resumeEntryMethodName == null || globalResumeTicket) {
				resumeUtil.addLog("CHECKPOINT",
						"CONNECTION:SUBJOB_OK:tDBRow_1:OnSubjobOk", "", Thread
								.currentThread().getId() + "", "", "", "", "",
						"");
			}

			if (execStat) {
				runStat.updateStatOnConnection("OnSubjobOk1", 0, "ok");
			}

			tDBInput_2Process(globalMap);

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
				 * [tDBRow_1 finally ] start
				 */

				currentComponent = "tDBRow_1";

				if (resourceMap.get("statementClosed_tDBRow_1") == null) {
					java.sql.Statement stmtToClose_tDBRow_1 = null;
					if ((stmtToClose_tDBRow_1 = (java.sql.Statement) resourceMap
							.remove("stmt_tDBRow_1")) != null) {
						stmtToClose_tDBRow_1.close();
					}
				}

				/**
				 * [tDBRow_1 finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBRow_1_SUBPROCESS_STATE", 1);
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
		final Job4 Job4Class = new Job4();

		int exitCode = Job4Class.runJobInTOS(args);
		if (exitCode == 0) {
			log.info("TalendJob: 'Job4' - Done.");
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
		log.info("TalendJob: 'Job4' - Start.");

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
			java.io.InputStream inContext = Job4.class.getClassLoader()
					.getResourceAsStream(
							"test/job4_0_1/contexts/" + contextStr
									+ ".properties");
			if (inContext == null) {
				inContext = Job4.class.getClassLoader().getResourceAsStream(
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
			context.setContextType("name", "id_String");

			context.name = (String) context.getProperty("name");
			context.setContextType("rep", "id_String");

			context.rep = (String) context.getProperty("rep");
			context.setContextType("statut_ji", "id_String");

			context.statut_ji = (String) context.getProperty("statut_ji");
			context.setContextType("ssql_cfdp_AdditionalParams", "id_String");

			context.ssql_cfdp_AdditionalParams = (String) context
					.getProperty("ssql_cfdp_AdditionalParams");
			context.setContextType("ssql_cfdp_Database", "id_String");

			context.ssql_cfdp_Database = (String) context
					.getProperty("ssql_cfdp_Database");
			context.setContextType("ssql_cfdp_Login", "id_String");

			context.ssql_cfdp_Login = (String) context
					.getProperty("ssql_cfdp_Login");
			context.setContextType("ssql_cfdp_Password", "id_Password");

			String pwd_ssql_cfdp_Password_value = context
					.getProperty("ssql_cfdp_Password");
			context.ssql_cfdp_Password = null;
			if (pwd_ssql_cfdp_Password_value != null) {
				if (context_param.containsKey("ssql_cfdp_Password")) {// no need
																		// to
																		// decrypt
																		// if it
																		// come
																		// from
																		// program
																		// argument
																		// or
																		// parent
																		// job
																		// runtime
					context.ssql_cfdp_Password = pwd_ssql_cfdp_Password_value;
				} else if (!pwd_ssql_cfdp_Password_value.isEmpty()) {
					try {
						context.ssql_cfdp_Password = routines.system.PasswordEncryptUtil
								.decryptPassword(pwd_ssql_cfdp_Password_value);
						context.put("ssql_cfdp_Password",
								context.ssql_cfdp_Password);
					} catch (java.lang.RuntimeException e) {
						// do nothing
					}
				}
			}
			context.setContextType("ssql_cfdp_Port", "id_String");

			context.ssql_cfdp_Port = (String) context
					.getProperty("ssql_cfdp_Port");
			context.setContextType("ssql_cfdp_Schema", "id_String");

			context.ssql_cfdp_Schema = (String) context
					.getProperty("ssql_cfdp_Schema");
			context.setContextType("ssql_cfdp_Server", "id_String");

			context.ssql_cfdp_Server = (String) context
					.getProperty("ssql_cfdp_Server");
			context.setContextType("nb_lignes", "id_Integer");

			try {
				context.nb_lignes = routines.system.ParserUtils
						.parseTo_Integer(context.getProperty("nb_lignes"));
			} catch (NumberFormatException e) {
				log.warn(String.format(
						"Null value will be used for context parameter %s: %s",
						"nb_lignes", e.getMessage()));
				context.nb_lignes = null;
			}
			context.setContextType("ssql_test_cfdp_Database", "id_String");

			context.ssql_test_cfdp_Database = (String) context
					.getProperty("ssql_test_cfdp_Database");
			context.setContextType("ssql_test_cfdp_Password", "id_Password");

			String pwd_ssql_test_cfdp_Password_value = context
					.getProperty("ssql_test_cfdp_Password");
			context.ssql_test_cfdp_Password = null;
			if (pwd_ssql_test_cfdp_Password_value != null) {
				if (context_param.containsKey("ssql_test_cfdp_Password")) {// no
																			// need
																			// to
																			// decrypt
																			// if
																			// it
																			// come
																			// from
																			// program
																			// argument
																			// or
																			// parent
																			// job
																			// runtime
					context.ssql_test_cfdp_Password = pwd_ssql_test_cfdp_Password_value;
				} else if (!pwd_ssql_test_cfdp_Password_value.isEmpty()) {
					try {
						context.ssql_test_cfdp_Password = routines.system.PasswordEncryptUtil
								.decryptPassword(pwd_ssql_test_cfdp_Password_value);
						context.put("ssql_test_cfdp_Password",
								context.ssql_test_cfdp_Password);
					} catch (java.lang.RuntimeException e) {
						// do nothing
					}
				}
			}
			context.setContextType("ssql_test_cfdp_Port", "id_String");

			context.ssql_test_cfdp_Port = (String) context
					.getProperty("ssql_test_cfdp_Port");
			context.setContextType("ssql_test_cfdp_Schema", "id_String");

			context.ssql_test_cfdp_Schema = (String) context
					.getProperty("ssql_test_cfdp_Schema");
			context.setContextType("ssql_test_cfdp_Server", "id_String");

			context.ssql_test_cfdp_Server = (String) context
					.getProperty("ssql_test_cfdp_Server");
			context.setContextType("ssql_test_cfdp_Login", "id_String");

			context.ssql_test_cfdp_Login = (String) context
					.getProperty("ssql_test_cfdp_Login");
			context.setContextType("ssql_test_cfdp_AdditionalParams",
					"id_String");

			context.ssql_test_cfdp_AdditionalParams = (String) context
					.getProperty("ssql_test_cfdp_AdditionalParams");
		} catch (java.io.IOException ie) {
			System.err.println("Could not load context " + contextStr);
			ie.printStackTrace();
		}

		// get context value from parent directly
		if (parentContextMap != null && !parentContextMap.isEmpty()) {
			if (parentContextMap.containsKey("name")) {
				context.name = (String) parentContextMap.get("name");
			}
			if (parentContextMap.containsKey("rep")) {
				context.rep = (String) parentContextMap.get("rep");
			}
			if (parentContextMap.containsKey("statut_ji")) {
				context.statut_ji = (String) parentContextMap.get("statut_ji");
			}
			if (parentContextMap.containsKey("ssql_cfdp_AdditionalParams")) {
				context.ssql_cfdp_AdditionalParams = (String) parentContextMap
						.get("ssql_cfdp_AdditionalParams");
			}
			if (parentContextMap.containsKey("ssql_cfdp_Database")) {
				context.ssql_cfdp_Database = (String) parentContextMap
						.get("ssql_cfdp_Database");
			}
			if (parentContextMap.containsKey("ssql_cfdp_Login")) {
				context.ssql_cfdp_Login = (String) parentContextMap
						.get("ssql_cfdp_Login");
			}
			if (parentContextMap.containsKey("ssql_cfdp_Password")) {
				context.ssql_cfdp_Password = (java.lang.String) parentContextMap
						.get("ssql_cfdp_Password");
			}
			if (parentContextMap.containsKey("ssql_cfdp_Port")) {
				context.ssql_cfdp_Port = (String) parentContextMap
						.get("ssql_cfdp_Port");
			}
			if (parentContextMap.containsKey("ssql_cfdp_Schema")) {
				context.ssql_cfdp_Schema = (String) parentContextMap
						.get("ssql_cfdp_Schema");
			}
			if (parentContextMap.containsKey("ssql_cfdp_Server")) {
				context.ssql_cfdp_Server = (String) parentContextMap
						.get("ssql_cfdp_Server");
			}
			if (parentContextMap.containsKey("nb_lignes")) {
				context.nb_lignes = (Integer) parentContextMap.get("nb_lignes");
			}
			if (parentContextMap.containsKey("ssql_test_cfdp_Database")) {
				context.ssql_test_cfdp_Database = (String) parentContextMap
						.get("ssql_test_cfdp_Database");
			}
			if (parentContextMap.containsKey("ssql_test_cfdp_Password")) {
				context.ssql_test_cfdp_Password = (java.lang.String) parentContextMap
						.get("ssql_test_cfdp_Password");
			}
			if (parentContextMap.containsKey("ssql_test_cfdp_Port")) {
				context.ssql_test_cfdp_Port = (String) parentContextMap
						.get("ssql_test_cfdp_Port");
			}
			if (parentContextMap.containsKey("ssql_test_cfdp_Schema")) {
				context.ssql_test_cfdp_Schema = (String) parentContextMap
						.get("ssql_test_cfdp_Schema");
			}
			if (parentContextMap.containsKey("ssql_test_cfdp_Server")) {
				context.ssql_test_cfdp_Server = (String) parentContextMap
						.get("ssql_test_cfdp_Server");
			}
			if (parentContextMap.containsKey("ssql_test_cfdp_Login")) {
				context.ssql_test_cfdp_Login = (String) parentContextMap
						.get("ssql_test_cfdp_Login");
			}
			if (parentContextMap.containsKey("ssql_test_cfdp_AdditionalParams")) {
				context.ssql_test_cfdp_AdditionalParams = (String) parentContextMap
						.get("ssql_test_cfdp_AdditionalParams");
			}
		}

		// Resume: init the resumeUtil
		resumeEntryMethodName = ResumeUtil
				.getResumeEntryMethodName(resuming_checkpoint_path);
		resumeUtil = new ResumeUtil(resuming_logs_dir_path, isChildJob, rootPid);
		resumeUtil.initCommonInfo(pid, rootPid, fatherPid, projectName,
				jobName, contextStr, jobVersion);

		List<String> parametersToEncrypt = new java.util.ArrayList<String>();
		parametersToEncrypt.add("ssql_cfdp_Password");
		parametersToEncrypt.add("ssql_test_cfdp_Password");
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
			tDBRow_1Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tDBRow_1) {
			globalMap.put("tDBRow_1_SUBPROCESS_STATE", -1);

			e_tDBRow_1.printStackTrace();

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
					+ " bytes memory increase when running : Job4");
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
 * 85708 characters generated by Talend Cloud Data Management Platform on the
 * September 11, 2019 4:32:03 PM CEST
 ************************************************************************************************/
