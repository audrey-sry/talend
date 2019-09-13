package test.verif_statut_edi_0_1;

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
 * Job: verif_statut_edi Purpose: <br>
 * Description:  <br>
 * @author user@talend.com
 * @version 7.1.1.20190228_0243-patch
 * @status 
 */
public class verif_statut_edi implements TalendJob {
	static {
		System.setProperty("TalendJob.log", "verif_statut_edi.log");
	}
	private static org.apache.log4j.Logger log = org.apache.log4j.Logger
			.getLogger(verif_statut_edi.class);

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

			if (ssql_cfdp_Server != null) {

				this.setProperty("ssql_cfdp_Server",
						ssql_cfdp_Server.toString());

			}

			if (ssql_cfdp_Database != null) {

				this.setProperty("ssql_cfdp_Database",
						ssql_cfdp_Database.toString());

			}

			if (ssql_cfdp_AdditionalParams != null) {

				this.setProperty("ssql_cfdp_AdditionalParams",
						ssql_cfdp_AdditionalParams.toString());

			}

			if (ssql_cfdp_Port != null) {

				this.setProperty("ssql_cfdp_Port", ssql_cfdp_Port.toString());

			}

			if (ssql_cfdp_Password != null) {

				this.setProperty("ssql_cfdp_Password",
						ssql_cfdp_Password.toString());

			}

			if (ssql_cfdp_Schema != null) {

				this.setProperty("ssql_cfdp_Schema",
						ssql_cfdp_Schema.toString());

			}

			if (ssql_cfdp_Login != null) {

				this.setProperty("ssql_cfdp_Login", ssql_cfdp_Login.toString());

			}

		}

		public String ssql_cfdp_Server;

		public String getSsql_cfdp_Server() {
			return this.ssql_cfdp_Server;
		}

		public String ssql_cfdp_Database;

		public String getSsql_cfdp_Database() {
			return this.ssql_cfdp_Database;
		}

		public String ssql_cfdp_AdditionalParams;

		public String getSsql_cfdp_AdditionalParams() {
			return this.ssql_cfdp_AdditionalParams;
		}

		public String ssql_cfdp_Port;

		public String getSsql_cfdp_Port() {
			return this.ssql_cfdp_Port;
		}

		public java.lang.String ssql_cfdp_Password;

		public java.lang.String getSsql_cfdp_Password() {
			return this.ssql_cfdp_Password;
		}

		public String ssql_cfdp_Schema;

		public String getSsql_cfdp_Schema() {
			return this.ssql_cfdp_Schema;
		}

		public String ssql_cfdp_Login;

		public String getSsql_cfdp_Login() {
			return this.ssql_cfdp_Login;
		}
	}

	protected ContextProperties context = new ContextProperties(); // will be
																	// instanciated
																	// by MS.

	public ContextProperties getContext() {
		return this.context;
	}

	private final String jobVersion = "0.1";
	private final String jobName = "verif_statut_edi";
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
					verif_statut_edi.this.exception = e;
				}
			}
			if (!(e instanceof TalendException)) {
				try {
					for (java.lang.reflect.Method m : this.getClass()
							.getEnclosingClass().getMethods()) {
						if (m.getName().compareTo(currentComponent + "_error") == 0) {
							m.invoke(verif_statut_edi.this, new Object[] { e,
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

	public void tFixedFlowInput_1_error(Exception exception,
			String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFixedFlowInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tMap_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFixedFlowInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tLogRow_3_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFixedFlowInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tMap_2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFixedFlowInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tLogRow_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFixedFlowInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tLogRow_2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFixedFlowInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_3_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_3_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_4_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_4_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tPrejob_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tPrejob_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBConnection_2_error(Exception exception,
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

		tDBConnection_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDie_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDie_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tAdvancedHash_partenaire_error(Exception exception,
			String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tAdvancedHash_type_autorisation_error(Exception exception,
			String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tAdvancedHash_type_edi_error(Exception exception,
			String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_3_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tAdvancedHash_row2_error(Exception exception,
			String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_4_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFixedFlowInput_1_onSubJobError(Exception exception,
			String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread
				.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(),
				ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tDBInput_1_onSubJobError(Exception exception,
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

	public void tDBInput_3_onSubJobError(Exception exception,
			String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread
				.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(),
				ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tDBInput_4_onSubJobError(Exception exception,
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

	public void tDBConnection_2_onSubJobError(Exception exception,
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

	public static class okStruct implements
			routines.system.IPersistableRow<okStruct> {
		final static byte[] commonByteArrayLock_TEST_verif_statut_edi = new byte[0];
		static byte[] commonByteArray_TEST_verif_statut_edi = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public int PAR_ID;

		public int getPAR_ID() {
			return this.PAR_ID;
		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + (int) this.PAR_ID;

				this.hashCode = result;
				this.hashCodeDirty = false;
			}
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final okStruct other = (okStruct) obj;

			if (this.PAR_ID != other.PAR_ID)
				return false;

			return true;
		}

		public void copyDataTo(okStruct other) {

			other.PAR_ID = this.PAR_ID;

		}

		public void copyKeysDataTo(okStruct other) {

			other.PAR_ID = this.PAR_ID;

		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_TEST_verif_statut_edi) {

				try {

					int length = 0;

					this.PAR_ID = dis.readInt();

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// int

				dos.writeInt(this.PAR_ID);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("PAR_ID=" + String.valueOf(PAR_ID));
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			sb.append(PAR_ID);

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(okStruct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.PAR_ID, other.PAR_ID);
			if (returnValue != 0) {
				return returnValue;
			}

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

	public static class koStruct implements
			routines.system.IPersistableRow<koStruct> {
		final static byte[] commonByteArrayLock_TEST_verif_statut_edi = new byte[0];
		static byte[] commonByteArray_TEST_verif_statut_edi = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public int TED_ID;

		public int getTED_ID() {
			return this.TED_ID;
		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + (int) this.TED_ID;

				this.hashCode = result;
				this.hashCodeDirty = false;
			}
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final koStruct other = (koStruct) obj;

			if (this.TED_ID != other.TED_ID)
				return false;

			return true;
		}

		public void copyDataTo(koStruct other) {

			other.TED_ID = this.TED_ID;

		}

		public void copyKeysDataTo(koStruct other) {

			other.TED_ID = this.TED_ID;

		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_TEST_verif_statut_edi) {

				try {

					int length = 0;

					this.TED_ID = dis.readInt();

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// int

				dos.writeInt(this.TED_ID);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("TED_ID=" + String.valueOf(TED_ID));
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			sb.append(TED_ID);

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(koStruct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.TED_ID, other.TED_ID);
			if (returnValue != 0) {
				return returnValue;
			}

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

	public static class row3Struct implements
			routines.system.IPersistableRow<row3Struct> {
		final static byte[] commonByteArrayLock_TEST_verif_statut_edi = new byte[0];
		static byte[] commonByteArray_TEST_verif_statut_edi = new byte[0];

		public int PAR_ID;

		public int getPAR_ID() {
			return this.PAR_ID;
		}

		public int TED_ID;

		public int getTED_ID() {
			return this.TED_ID;
		}

		public String TAU_CODE;

		public String getTAU_CODE() {
			return this.TAU_CODE;
		}

		public String isOK;

		public String getIsOK() {
			return this.isOK;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_TEST_verif_statut_edi.length) {
					if (length < 1024
							&& commonByteArray_TEST_verif_statut_edi.length == 0) {
						commonByteArray_TEST_verif_statut_edi = new byte[1024];
					} else {
						commonByteArray_TEST_verif_statut_edi = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_TEST_verif_statut_edi, 0, length);
				strReturn = new String(commonByteArray_TEST_verif_statut_edi,
						0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_TEST_verif_statut_edi) {

				try {

					int length = 0;

					this.PAR_ID = dis.readInt();

					this.TED_ID = dis.readInt();

					this.TAU_CODE = readString(dis);

					this.isOK = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// int

				dos.writeInt(this.PAR_ID);

				// int

				dos.writeInt(this.TED_ID);

				// String

				writeString(this.TAU_CODE, dos);

				// String

				writeString(this.isOK, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("PAR_ID=" + String.valueOf(PAR_ID));
			sb.append(",TED_ID=" + String.valueOf(TED_ID));
			sb.append(",TAU_CODE=" + TAU_CODE);
			sb.append(",isOK=" + isOK);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			sb.append(PAR_ID);

			sb.append("|");

			sb.append(TED_ID);

			sb.append("|");

			if (TAU_CODE == null) {
				sb.append("<null>");
			} else {
				sb.append(TAU_CODE);
			}

			sb.append("|");

			if (isOK == null) {
				sb.append("<null>");
			} else {
				sb.append(isOK);
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

	public static class out1Struct implements
			routines.system.IPersistableRow<out1Struct> {
		final static byte[] commonByteArrayLock_TEST_verif_statut_edi = new byte[0];
		static byte[] commonByteArray_TEST_verif_statut_edi = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public int PAR_ID;

		public int getPAR_ID() {
			return this.PAR_ID;
		}

		public int TED_ID;

		public int getTED_ID() {
			return this.TED_ID;
		}

		public String TAU_CODE;

		public String getTAU_CODE() {
			return this.TAU_CODE;
		}

		public String isOK;

		public String getIsOK() {
			return this.isOK;
		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + (int) this.PAR_ID;

				result = prime * result + (int) this.TED_ID;

				result = prime
						* result
						+ ((this.TAU_CODE == null) ? 0 : this.TAU_CODE
								.hashCode());

				this.hashCode = result;
				this.hashCodeDirty = false;
			}
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final out1Struct other = (out1Struct) obj;

			if (this.PAR_ID != other.PAR_ID)
				return false;

			if (this.TED_ID != other.TED_ID)
				return false;

			if (this.TAU_CODE == null) {
				if (other.TAU_CODE != null)
					return false;

			} else if (!this.TAU_CODE.equals(other.TAU_CODE))

				return false;

			return true;
		}

		public void copyDataTo(out1Struct other) {

			other.PAR_ID = this.PAR_ID;
			other.TED_ID = this.TED_ID;
			other.TAU_CODE = this.TAU_CODE;
			other.isOK = this.isOK;

		}

		public void copyKeysDataTo(out1Struct other) {

			other.PAR_ID = this.PAR_ID;
			other.TED_ID = this.TED_ID;
			other.TAU_CODE = this.TAU_CODE;

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_TEST_verif_statut_edi.length) {
					if (length < 1024
							&& commonByteArray_TEST_verif_statut_edi.length == 0) {
						commonByteArray_TEST_verif_statut_edi = new byte[1024];
					} else {
						commonByteArray_TEST_verif_statut_edi = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_TEST_verif_statut_edi, 0, length);
				strReturn = new String(commonByteArray_TEST_verif_statut_edi,
						0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_TEST_verif_statut_edi) {

				try {

					int length = 0;

					this.PAR_ID = dis.readInt();

					this.TED_ID = dis.readInt();

					this.TAU_CODE = readString(dis);

					this.isOK = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// int

				dos.writeInt(this.PAR_ID);

				// int

				dos.writeInt(this.TED_ID);

				// String

				writeString(this.TAU_CODE, dos);

				// String

				writeString(this.isOK, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("PAR_ID=" + String.valueOf(PAR_ID));
			sb.append(",TED_ID=" + String.valueOf(TED_ID));
			sb.append(",TAU_CODE=" + TAU_CODE);
			sb.append(",isOK=" + isOK);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			sb.append(PAR_ID);

			sb.append("|");

			sb.append(TED_ID);

			sb.append("|");

			if (TAU_CODE == null) {
				sb.append("<null>");
			} else {
				sb.append(TAU_CODE);
			}

			sb.append("|");

			if (isOK == null) {
				sb.append("<null>");
			} else {
				sb.append(isOK);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(out1Struct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.PAR_ID, other.PAR_ID);
			if (returnValue != 0) {
				return returnValue;
			}

			returnValue = checkNullsAndCompare(this.TED_ID, other.TED_ID);
			if (returnValue != 0) {
				return returnValue;
			}

			returnValue = checkNullsAndCompare(this.TAU_CODE, other.TAU_CODE);
			if (returnValue != 0) {
				return returnValue;
			}

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

	public static class row1Struct implements
			routines.system.IPersistableRow<row1Struct> {
		final static byte[] commonByteArrayLock_TEST_verif_statut_edi = new byte[0];
		static byte[] commonByteArray_TEST_verif_statut_edi = new byte[0];

		public String code_EDI;

		public String getCode_EDI() {
			return this.code_EDI;
		}

		public String code_IA;

		public String getCode_IA() {
			return this.code_IA;
		}

		public String isOK;

		public String getIsOK() {
			return this.isOK;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_TEST_verif_statut_edi.length) {
					if (length < 1024
							&& commonByteArray_TEST_verif_statut_edi.length == 0) {
						commonByteArray_TEST_verif_statut_edi = new byte[1024];
					} else {
						commonByteArray_TEST_verif_statut_edi = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_TEST_verif_statut_edi, 0, length);
				strReturn = new String(commonByteArray_TEST_verif_statut_edi,
						0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_TEST_verif_statut_edi) {

				try {

					int length = 0;

					this.code_EDI = readString(dis);

					this.code_IA = readString(dis);

					this.isOK = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.code_EDI, dos);

				// String

				writeString(this.code_IA, dos);

				// String

				writeString(this.isOK, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("code_EDI=" + code_EDI);
			sb.append(",code_IA=" + code_IA);
			sb.append(",isOK=" + isOK);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (code_EDI == null) {
				sb.append("<null>");
			} else {
				sb.append(code_EDI);
			}

			sb.append("|");

			if (code_IA == null) {
				sb.append("<null>");
			} else {
				sb.append(code_IA);
			}

			sb.append("|");

			if (isOK == null) {
				sb.append("<null>");
			} else {
				sb.append(isOK);
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

	public static class after_tFixedFlowInput_1Struct implements
			routines.system.IPersistableRow<after_tFixedFlowInput_1Struct> {
		final static byte[] commonByteArrayLock_TEST_verif_statut_edi = new byte[0];
		static byte[] commonByteArray_TEST_verif_statut_edi = new byte[0];

		public String code_EDI;

		public String getCode_EDI() {
			return this.code_EDI;
		}

		public String code_IA;

		public String getCode_IA() {
			return this.code_IA;
		}

		public String isOK;

		public String getIsOK() {
			return this.isOK;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_TEST_verif_statut_edi.length) {
					if (length < 1024
							&& commonByteArray_TEST_verif_statut_edi.length == 0) {
						commonByteArray_TEST_verif_statut_edi = new byte[1024];
					} else {
						commonByteArray_TEST_verif_statut_edi = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_TEST_verif_statut_edi, 0, length);
				strReturn = new String(commonByteArray_TEST_verif_statut_edi,
						0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_TEST_verif_statut_edi) {

				try {

					int length = 0;

					this.code_EDI = readString(dis);

					this.code_IA = readString(dis);

					this.isOK = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.code_EDI, dos);

				// String

				writeString(this.code_IA, dos);

				// String

				writeString(this.isOK, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("code_EDI=" + code_EDI);
			sb.append(",code_IA=" + code_IA);
			sb.append(",isOK=" + isOK);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (code_EDI == null) {
				sb.append("<null>");
			} else {
				sb.append(code_EDI);
			}

			sb.append("|");

			if (code_IA == null) {
				sb.append("<null>");
			} else {
				sb.append(code_IA);
			}

			sb.append("|");

			if (isOK == null) {
				sb.append("<null>");
			} else {
				sb.append(isOK);
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

				tDBInput_1Process(globalMap);
				tDBInput_2Process(globalMap);
				tDBInput_3Process(globalMap);
				tDBInput_4Process(globalMap);

				row1Struct row1 = new row1Struct();
				out1Struct out1 = new out1Struct();
				out1Struct row3 = out1;
				okStruct ok = new okStruct();
				koStruct ko = new koStruct();

				/**
				 * [tLogRow_1 begin ] start
				 */

				ok_Hash.put("tLogRow_1", false);
				start_Hash.put("tLogRow_1", System.currentTimeMillis());

				currentComponent = "tLogRow_1";

				if (execStat) {
					if (resourceMap.get("inIterateVComp") == null) {

						runStat.updateStatOnConnection("ok" + iterateId, 0, 0);

					}
				}

				int tos_count_tLogRow_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tLogRow_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tLogRow_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tLogRow_1 = new StringBuilder();
							log4jParamters_tLogRow_1.append("Parameters:");
							log4jParamters_tLogRow_1.append("BASIC_MODE"
									+ " = " + "false");
							log4jParamters_tLogRow_1.append(" | ");
							log4jParamters_tLogRow_1.append("TABLE_PRINT"
									+ " = " + "true");
							log4jParamters_tLogRow_1.append(" | ");
							log4jParamters_tLogRow_1.append("VERTICAL" + " = "
									+ "false");
							log4jParamters_tLogRow_1.append(" | ");
							log4jParamters_tLogRow_1
									.append("PRINT_CONTENT_WITH_LOG4J" + " = "
											+ "true");
							log4jParamters_tLogRow_1.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tLogRow_1 - "
										+ (log4jParamters_tLogRow_1));
						}
					}
					new BytesLimit65535_tLogRow_1().limitLog4jByte();
				}

				// /////////////////////

				class Util_tLogRow_1 {

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
				Util_tLogRow_1 util_tLogRow_1 = new Util_tLogRow_1();
				util_tLogRow_1.setTableName("ok");
				util_tLogRow_1.addRow(new String[] { "PAR_ID", });
				StringBuilder strBuffer_tLogRow_1 = null;
				int nb_line_tLogRow_1 = 0;
				// /////////////////////

				/**
				 * [tLogRow_1 begin ] stop
				 */

				/**
				 * [tLogRow_2 begin ] start
				 */

				ok_Hash.put("tLogRow_2", false);
				start_Hash.put("tLogRow_2", System.currentTimeMillis());

				currentComponent = "tLogRow_2";

				if (execStat) {
					if (resourceMap.get("inIterateVComp") == null) {

						runStat.updateStatOnConnection("ko" + iterateId, 0, 0);

					}
				}

				int tos_count_tLogRow_2 = 0;

				if (log.isDebugEnabled())
					log.debug("tLogRow_2 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tLogRow_2 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tLogRow_2 = new StringBuilder();
							log4jParamters_tLogRow_2.append("Parameters:");
							log4jParamters_tLogRow_2.append("BASIC_MODE"
									+ " = " + "false");
							log4jParamters_tLogRow_2.append(" | ");
							log4jParamters_tLogRow_2.append("TABLE_PRINT"
									+ " = " + "true");
							log4jParamters_tLogRow_2.append(" | ");
							log4jParamters_tLogRow_2.append("VERTICAL" + " = "
									+ "false");
							log4jParamters_tLogRow_2.append(" | ");
							log4jParamters_tLogRow_2
									.append("PRINT_CONTENT_WITH_LOG4J" + " = "
											+ "true");
							log4jParamters_tLogRow_2.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tLogRow_2 - "
										+ (log4jParamters_tLogRow_2));
						}
					}
					new BytesLimit65535_tLogRow_2().limitLog4jByte();
				}

				// /////////////////////

				class Util_tLogRow_2 {

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
				Util_tLogRow_2 util_tLogRow_2 = new Util_tLogRow_2();
				util_tLogRow_2.setTableName("ko");
				util_tLogRow_2.addRow(new String[] { "TED_ID", });
				StringBuilder strBuffer_tLogRow_2 = null;
				int nb_line_tLogRow_2 = 0;
				// /////////////////////

				/**
				 * [tLogRow_2 begin ] stop
				 */

				/**
				 * [tMap_2 begin ] start
				 */

				ok_Hash.put("tMap_2", false);
				start_Hash.put("tMap_2", System.currentTimeMillis());

				currentComponent = "tMap_2";

				if (execStat) {
					if (resourceMap.get("inIterateVComp") == null) {

						runStat.updateStatOnConnection("row3" + iterateId, 0, 0);

					}
				}

				int tos_count_tMap_2 = 0;

				if (log.isDebugEnabled())
					log.debug("tMap_2 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tMap_2 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tMap_2 = new StringBuilder();
							log4jParamters_tMap_2.append("Parameters:");
							log4jParamters_tMap_2.append("LINK_STYLE" + " = "
									+ "AUTO");
							log4jParamters_tMap_2.append(" | ");
							log4jParamters_tMap_2
									.append("TEMPORARY_DATA_DIRECTORY" + " = "
											+ "");
							log4jParamters_tMap_2.append(" | ");
							log4jParamters_tMap_2.append("ROWS_BUFFER_SIZE"
									+ " = " + "2000000");
							log4jParamters_tMap_2.append(" | ");
							log4jParamters_tMap_2
									.append("CHANGE_HASH_AND_EQUALS_FOR_BIGDECIMAL"
											+ " = " + "true");
							log4jParamters_tMap_2.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tMap_2 - " + (log4jParamters_tMap_2));
						}
					}
					new BytesLimit65535_tMap_2().limitLog4jByte();
				}

				// ###############################
				// # Lookup's keys initialization
				int count_row3_tMap_2 = 0;

				int count_row2_tMap_2 = 0;

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct> tHash_Lookup_row2 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct>) ((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct>) globalMap
						.get("tHash_Lookup_row2"));

				row2Struct row2HashKey = new row2Struct();
				row2Struct row2Default = new row2Struct();
				// ###############################

				// ###############################
				// # Vars initialization
				class Var__tMap_2__Struct {
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
				 * [tLogRow_3 begin ] start
				 */

				ok_Hash.put("tLogRow_3", false);
				start_Hash.put("tLogRow_3", System.currentTimeMillis());

				currentComponent = "tLogRow_3";

				if (execStat) {
					if (resourceMap.get("inIterateVComp") == null) {

						runStat.updateStatOnConnection("out1" + iterateId, 0, 0);

					}
				}

				int tos_count_tLogRow_3 = 0;

				if (log.isDebugEnabled())
					log.debug("tLogRow_3 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tLogRow_3 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tLogRow_3 = new StringBuilder();
							log4jParamters_tLogRow_3.append("Parameters:");
							log4jParamters_tLogRow_3.append("BASIC_MODE"
									+ " = " + "false");
							log4jParamters_tLogRow_3.append(" | ");
							log4jParamters_tLogRow_3.append("TABLE_PRINT"
									+ " = " + "true");
							log4jParamters_tLogRow_3.append(" | ");
							log4jParamters_tLogRow_3.append("VERTICAL" + " = "
									+ "false");
							log4jParamters_tLogRow_3.append(" | ");
							log4jParamters_tLogRow_3
									.append("PRINT_CONTENT_WITH_LOG4J" + " = "
											+ "true");
							log4jParamters_tLogRow_3.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tLogRow_3 - "
										+ (log4jParamters_tLogRow_3));
						}
					}
					new BytesLimit65535_tLogRow_3().limitLog4jByte();
				}

				// /////////////////////

				class Util_tLogRow_3 {

					String[] des_top = { ".", ".", "-", "+" };

					String[] des_head = { "|=", "=|", "-", "+" };

					String[] des_bottom = { "'", "'", "-", "+" };

					String name = "";

					java.util.List<String[]> list = new java.util.ArrayList<String[]>();

					int[] colLengths = new int[4];

					public void addRow(String[] row) {

						for (int i = 0; i < 4; i++) {
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
						for (k = 0; k < (totals + 3 - name.length()) / 2; k++) {
							sb.append(' ');
						}
						sb.append(name);
						for (int i = 0; i < totals + 3 - name.length() - k; i++) {
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

							sbformat.append("|%2$-");
							sbformat.append(colLengths[1]);
							sbformat.append("s");

							sbformat.append("|%3$-");
							sbformat.append(colLengths[2]);
							sbformat.append("s");

							sbformat.append("|%4$-");
							sbformat.append(colLengths[3]);
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
						for (int i = 0; i < colLengths[0]
								- fillChars[0].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[3]);

						for (int i = 0; i < colLengths[1]
								- fillChars[3].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[3]);
						for (int i = 0; i < colLengths[2]
								- fillChars[3].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[3]);

						// last column
						for (int i = 0; i < colLengths[3]
								- fillChars[1].length() + 1; i++) {
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
				Util_tLogRow_3 util_tLogRow_3 = new Util_tLogRow_3();
				util_tLogRow_3.setTableName("inter");
				util_tLogRow_3.addRow(new String[] { "PAR_ID", "TED_ID",
						"TAU_CODE", "isOK", });
				StringBuilder strBuffer_tLogRow_3 = null;
				int nb_line_tLogRow_3 = 0;
				// /////////////////////

				/**
				 * [tLogRow_3 begin ] stop
				 */

				/**
				 * [tMap_1 begin ] start
				 */

				ok_Hash.put("tMap_1", false);
				start_Hash.put("tMap_1", System.currentTimeMillis());

				currentComponent = "tMap_1";

				if (execStat) {
					if (resourceMap.get("inIterateVComp") == null) {

						runStat.updateStatOnConnection("row1" + iterateId, 0, 0);

					}
				}

				int tos_count_tMap_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tMap_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tMap_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tMap_1 = new StringBuilder();
							log4jParamters_tMap_1.append("Parameters:");
							log4jParamters_tMap_1.append("LINK_STYLE" + " = "
									+ "AUTO");
							log4jParamters_tMap_1.append(" | ");
							log4jParamters_tMap_1
									.append("TEMPORARY_DATA_DIRECTORY" + " = "
											+ "");
							log4jParamters_tMap_1.append(" | ");
							log4jParamters_tMap_1.append("ROWS_BUFFER_SIZE"
									+ " = " + "2000000");
							log4jParamters_tMap_1.append(" | ");
							log4jParamters_tMap_1
									.append("CHANGE_HASH_AND_EQUALS_FOR_BIGDECIMAL"
											+ " = " + "true");
							log4jParamters_tMap_1.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tMap_1 - " + (log4jParamters_tMap_1));
						}
					}
					new BytesLimit65535_tMap_1().limitLog4jByte();
				}

				// ###############################
				// # Lookup's keys initialization
				int count_row1_tMap_1 = 0;

				int count_partenaire_tMap_1 = 0;

				int count_type_autorisation_tMap_1 = 0;

				int count_type_edi_tMap_1 = 0;

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<partenaireStruct> tHash_Lookup_partenaire = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<partenaireStruct>) ((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<partenaireStruct>) globalMap
						.get("tHash_Lookup_partenaire"));

				partenaireStruct partenaireHashKey = new partenaireStruct();
				partenaireStruct partenaireDefault = new partenaireStruct();

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<type_autorisationStruct> tHash_Lookup_type_autorisation = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<type_autorisationStruct>) ((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<type_autorisationStruct>) globalMap
						.get("tHash_Lookup_type_autorisation"));

				tHash_Lookup_type_autorisation.initGet();

				type_autorisationStruct type_autorisationHashKey = new type_autorisationStruct();
				type_autorisationStruct type_autorisationDefault = new type_autorisationStruct();

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<type_ediStruct> tHash_Lookup_type_edi = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<type_ediStruct>) ((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<type_ediStruct>) globalMap
						.get("tHash_Lookup_type_edi"));

				type_ediStruct type_ediHashKey = new type_ediStruct();
				type_ediStruct type_ediDefault = new type_ediStruct();
				// ###############################

				// ###############################
				// # Vars initialization
				class Var__tMap_1__Struct {
				}
				Var__tMap_1__Struct Var__tMap_1 = new Var__tMap_1__Struct();
				// ###############################

				// ###############################
				// # Outputs initialization
				int count_out1_tMap_1 = 0;

				out1Struct out1_tmp = new out1Struct();
				// ###############################

				/**
				 * [tMap_1 begin ] stop
				 */

				/**
				 * [tFixedFlowInput_1 begin ] start
				 */

				ok_Hash.put("tFixedFlowInput_1", false);
				start_Hash.put("tFixedFlowInput_1", System.currentTimeMillis());

				currentComponent = "tFixedFlowInput_1";

				int tos_count_tFixedFlowInput_1 = 0;

				for (int i_tFixedFlowInput_1 = 0; i_tFixedFlowInput_1 < 1; i_tFixedFlowInput_1++) {

					row1.code_EDI = "MSG004";

					row1.code_IA = "PART01";

					row1.isOK = "ok";

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
					 * [tMap_1 main ] start
					 */

					currentComponent = "tMap_1";

					// row1
					// row1

					if (execStat) {
						runStat.updateStatOnConnection("row1" + iterateId, 1, 1);
					}

					if (log.isTraceEnabled()) {
						log.trace("row1 - "
								+ (row1 == null ? "" : row1.toLogString()));
					}

					boolean hasCasePrimitiveKeyWithNull_tMap_1 = false;

					// ###############################
					// # Input tables (lookups)
					boolean rejectedInnerJoin_tMap_1 = false;
					boolean mainRowRejected_tMap_1 = false;

					// /////////////////////////////////////////////
					// Starting Lookup Table "partenaire"
					// /////////////////////////////////////////////

					boolean forceLooppartenaire = false;

					partenaireStruct partenaireObjectFromLookup = null;

					if (!rejectedInnerJoin_tMap_1) { // G_TM_M_020

						hasCasePrimitiveKeyWithNull_tMap_1 = false;

						partenaireHashKey.CODE = row1.code_IA;

						partenaireHashKey.hashCodeDirty = true;

						tHash_Lookup_partenaire.lookup(partenaireHashKey);

					} // G_TM_M_020

					if (tHash_Lookup_partenaire != null
							&& tHash_Lookup_partenaire
									.getCount(partenaireHashKey) > 1) { // G 071

						// System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'partenaire' and it contains more one result from keys :  partenaire.CODE = '"
						// + partenaireHashKey.CODE + "'");
					} // G 071

					partenaireStruct partenaire = null;

					partenaireStruct fromLookup_partenaire = null;
					partenaire = partenaireDefault;

					if (tHash_Lookup_partenaire != null
							&& tHash_Lookup_partenaire.hasNext()) { // G 099

						fromLookup_partenaire = tHash_Lookup_partenaire.next();

					} // G 099

					if (fromLookup_partenaire != null) {
						partenaire = fromLookup_partenaire;
					}

					// /////////////////////////////////////////////
					// Starting Lookup Table "type_autorisation"
					// /////////////////////////////////////////////

					boolean forceLooptype_autorisation = false;

					type_autorisationStruct type_autorisationObjectFromLookup = null;

					if (!rejectedInnerJoin_tMap_1) { // G_TM_M_020

						tHash_Lookup_type_autorisation
								.lookup(type_autorisationHashKey);

						if (!tHash_Lookup_type_autorisation.hasNext()) { // G_TM_M_090

							forceLooptype_autorisation = true;

						} // G_TM_M_090

					} // G_TM_M_020

					else { // G 20 - G 21
						forceLooptype_autorisation = true;
					} // G 21

					type_autorisationStruct type_autorisation = null;

					while ((tHash_Lookup_type_autorisation != null && tHash_Lookup_type_autorisation
							.hasNext()) || forceLooptype_autorisation) { // G_TM_M_043

						// CALL close loop of lookup 'type_autorisation'

						type_autorisationStruct fromLookup_type_autorisation = null;
						type_autorisation = type_autorisationDefault;

						if (!forceLooptype_autorisation) { // G 46

							fromLookup_type_autorisation = tHash_Lookup_type_autorisation
									.next();

							if (fromLookup_type_autorisation != null) {
								type_autorisation = fromLookup_type_autorisation;
							}

						} // G 46

						forceLooptype_autorisation = false;

						// /////////////////////////////////////////////
						// Starting Lookup Table "type_edi"
						// /////////////////////////////////////////////

						boolean forceLooptype_edi = false;

						type_ediStruct type_ediObjectFromLookup = null;

						if (!rejectedInnerJoin_tMap_1) { // G_TM_M_020

							hasCasePrimitiveKeyWithNull_tMap_1 = false;

							type_ediHashKey.CODE = row1.code_EDI;

							type_ediHashKey.hashCodeDirty = true;

							tHash_Lookup_type_edi.lookup(type_ediHashKey);

						} // G_TM_M_020

						if (tHash_Lookup_type_edi != null
								&& tHash_Lookup_type_edi
										.getCount(type_ediHashKey) > 1) { // G
																			// 071

							// System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'type_edi' and it contains more one result from keys :  type_edi.CODE = '"
							// + type_ediHashKey.CODE + "'");
						} // G 071

						type_ediStruct type_edi = null;

						type_ediStruct fromLookup_type_edi = null;
						type_edi = type_ediDefault;

						if (tHash_Lookup_type_edi != null
								&& tHash_Lookup_type_edi.hasNext()) { // G 099

							fromLookup_type_edi = tHash_Lookup_type_edi.next();

						} // G 099

						if (fromLookup_type_edi != null) {
							type_edi = fromLookup_type_edi;
						}

						// ###############################
						{ // start of Var scope

							// ###############################
							// # Vars tables

							Var__tMap_1__Struct Var = Var__tMap_1;// ###############################
							// ###############################
							// # Output tables

							out1 = null;

							// # Output table : 'out1'
							count_out1_tMap_1++;

							out1_tmp.PAR_ID = partenaire.PAR_ID;
							out1_tmp.TED_ID = type_edi.TED_ID;
							out1_tmp.TAU_CODE = type_autorisation.TAU_CODE;
							out1_tmp.isOK = row1.isOK;
							out1 = out1_tmp;
							log.debug("tMap_1 - Outputting the record "
									+ count_out1_tMap_1
									+ " of the output table 'out1'.");

							// ###############################

						} // end of Var scope

						rejectedInnerJoin_tMap_1 = false;

						tos_count_tMap_1++;

						/**
						 * [tMap_1 main ] stop
						 */

						/**
						 * [tMap_1 process_data_begin ] start
						 */

						currentComponent = "tMap_1";

						/**
						 * [tMap_1 process_data_begin ] stop
						 */
						// Start of branch "out1"
						if (out1 != null) {

							/**
							 * [tLogRow_3 main ] start
							 */

							currentComponent = "tLogRow_3";

							// out1
							// out1

							if (execStat) {
								runStat.updateStatOnConnection("out1"
										+ iterateId, 1, 1);
							}

							if (log.isTraceEnabled()) {
								log.trace("out1 - "
										+ (out1 == null ? "" : out1
												.toLogString()));
							}

							// /////////////////////

							String[] row_tLogRow_3 = new String[4];

							row_tLogRow_3[0] = String.valueOf(out1.PAR_ID);

							row_tLogRow_3[1] = String.valueOf(out1.TED_ID);

							if (out1.TAU_CODE != null) { //
								row_tLogRow_3[2] = String
										.valueOf(out1.TAU_CODE);

							} //

							if (out1.isOK != null) { //
								row_tLogRow_3[3] = String.valueOf(out1.isOK);

							} //

							util_tLogRow_3.addRow(row_tLogRow_3);
							nb_line_tLogRow_3++;
							log.info("tLogRow_3 - Content of row "
									+ nb_line_tLogRow_3
									+ ": "
									+ TalendString.unionString("|",
											row_tLogRow_3));
							// ////

							// ////

							// /////////////////////

							row3 = out1;

							tos_count_tLogRow_3++;

							/**
							 * [tLogRow_3 main ] stop
							 */

							/**
							 * [tLogRow_3 process_data_begin ] start
							 */

							currentComponent = "tLogRow_3";

							/**
							 * [tLogRow_3 process_data_begin ] stop
							 */

							/**
							 * [tMap_2 main ] start
							 */

							currentComponent = "tMap_2";

							// row3
							// row3

							if (execStat) {
								runStat.updateStatOnConnection("row3"
										+ iterateId, 1, 1);
							}

							if (log.isTraceEnabled()) {
								log.trace("row3 - "
										+ (row3 == null ? "" : row3
												.toLogString()));
							}

							boolean hasCasePrimitiveKeyWithNull_tMap_2 = false;

							// ###############################
							// # Input tables (lookups)
							boolean rejectedInnerJoin_tMap_2 = false;
							boolean mainRowRejected_tMap_2 = false;

							// /////////////////////////////////////////////
							// Starting Lookup Table "row2"
							// /////////////////////////////////////////////

							boolean forceLooprow2 = false;

							row2Struct row2ObjectFromLookup = null;

							if (!rejectedInnerJoin_tMap_2) { // G_TM_M_020

								hasCasePrimitiveKeyWithNull_tMap_2 = false;

								Object exprKeyValue_row2__PAR_ID = out1.PAR_ID;
								if (exprKeyValue_row2__PAR_ID == null) {
									hasCasePrimitiveKeyWithNull_tMap_2 = true;
								} else {
									row2HashKey.PAR_ID = (int) (Integer) exprKeyValue_row2__PAR_ID;
								}

								Object exprKeyValue_row2__TED_ID = out1.TED_ID;
								if (exprKeyValue_row2__TED_ID == null) {
									hasCasePrimitiveKeyWithNull_tMap_2 = true;
								} else {
									row2HashKey.TED_ID = (int) (Integer) exprKeyValue_row2__TED_ID;
								}

								row2HashKey.TAU_CODE = out1.TAU_CODE;

								row2HashKey.hashCodeDirty = true;

								if (!hasCasePrimitiveKeyWithNull_tMap_2) { // G_TM_M_091

									tHash_Lookup_row2.lookup(row2HashKey);

								} // G_TM_M_091

								if (hasCasePrimitiveKeyWithNull_tMap_2
										|| !tHash_Lookup_row2.hasNext()) { // G_TM_M_090

									rejectedInnerJoin_tMap_2 = true;

									forceLooprow2 = true;

								} // G_TM_M_090

							} // G_TM_M_020

							else { // G 20 - G 21
								forceLooprow2 = true;
							} // G 21

							row2Struct row2 = null;

							while ((tHash_Lookup_row2 != null && tHash_Lookup_row2
									.hasNext()) || forceLooprow2) { // G_TM_M_043

								// CALL close loop of lookup 'row2'

								row2Struct fromLookup_row2 = null;
								row2 = row2Default;

								if (!forceLooprow2) { // G 46

									fromLookup_row2 = tHash_Lookup_row2.next();

									if (fromLookup_row2 != null) {
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

									if (!rejectedInnerJoin_tMap_2) {

										// # Output table : 'ok'
										count_ok_tMap_2++;

										ok_tmp.PAR_ID = row3.PAR_ID;
										ok = ok_tmp;
										log.debug("tMap_2 - Outputting the record "
												+ count_ok_tMap_2
												+ " of the output table 'ok'.");

									} // closing inner join bracket (1)
										// ###### START REJECTS #####

									// # Output reject table : 'ko'
									// # Filter conditions
									if (rejectedInnerJoin_tMap_2) {
										count_ko_tMap_2++;

										ko_tmp.TED_ID = row3.TED_ID;
										ko = ko_tmp;
										log.debug("tMap_2 - Outputting the record "
												+ count_ko_tMap_2
												+ " of the output table 'ko'.");

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

								currentComponent = "tMap_2";

								/**
								 * [tMap_2 process_data_begin ] stop
								 */
								// Start of branch "ok"
								if (ok != null) {

									/**
									 * [tLogRow_1 main ] start
									 */

									currentComponent = "tLogRow_1";

									// ok
									// ok

									if (execStat) {
										runStat.updateStatOnConnection("ok"
												+ iterateId, 1, 1);
									}

									if (log.isTraceEnabled()) {
										log.trace("ok - "
												+ (ok == null ? "" : ok
														.toLogString()));
									}

									// /////////////////////

									String[] row_tLogRow_1 = new String[1];

									row_tLogRow_1[0] = String
											.valueOf(ok.PAR_ID);

									util_tLogRow_1.addRow(row_tLogRow_1);
									nb_line_tLogRow_1++;
									log.info("tLogRow_1 - Content of row "
											+ nb_line_tLogRow_1
											+ ": "
											+ TalendString.unionString("|",
													row_tLogRow_1));
									// ////

									// ////

									// /////////////////////

									tos_count_tLogRow_1++;

									/**
									 * [tLogRow_1 main ] stop
									 */

									/**
									 * [tLogRow_1 process_data_begin ] start
									 */

									currentComponent = "tLogRow_1";

									/**
									 * [tLogRow_1 process_data_begin ] stop
									 */

									/**
									 * [tLogRow_1 process_data_end ] start
									 */

									currentComponent = "tLogRow_1";

									/**
									 * [tLogRow_1 process_data_end ] stop
									 */

								} // End of branch "ok"

								// Start of branch "ko"
								if (ko != null) {

									/**
									 * [tLogRow_2 main ] start
									 */

									currentComponent = "tLogRow_2";

									// ko
									// ko

									if (execStat) {
										runStat.updateStatOnConnection("ko"
												+ iterateId, 1, 1);
									}

									if (log.isTraceEnabled()) {
										log.trace("ko - "
												+ (ko == null ? "" : ko
														.toLogString()));
									}

									// /////////////////////

									String[] row_tLogRow_2 = new String[1];

									row_tLogRow_2[0] = String
											.valueOf(ko.TED_ID);

									util_tLogRow_2.addRow(row_tLogRow_2);
									nb_line_tLogRow_2++;
									log.info("tLogRow_2 - Content of row "
											+ nb_line_tLogRow_2
											+ ": "
											+ TalendString.unionString("|",
													row_tLogRow_2));
									// ////

									// ////

									// /////////////////////

									tos_count_tLogRow_2++;

									/**
									 * [tLogRow_2 main ] stop
									 */

									/**
									 * [tLogRow_2 process_data_begin ] start
									 */

									currentComponent = "tLogRow_2";

									/**
									 * [tLogRow_2 process_data_begin ] stop
									 */

									/**
									 * [tLogRow_2 process_data_end ] start
									 */

									currentComponent = "tLogRow_2";

									/**
									 * [tLogRow_2 process_data_end ] stop
									 */

								} // End of branch "ko"

							} // close loop of lookup 'row2' // G_TM_M_043

							/**
							 * [tMap_2 process_data_end ] start
							 */

							currentComponent = "tMap_2";

							/**
							 * [tMap_2 process_data_end ] stop
							 */

							/**
							 * [tLogRow_3 process_data_end ] start
							 */

							currentComponent = "tLogRow_3";

							/**
							 * [tLogRow_3 process_data_end ] stop
							 */

						} // End of branch "out1"

					} // close loop of lookup 'type_autorisation' // G_TM_M_043

					/**
					 * [tMap_1 process_data_end ] start
					 */

					currentComponent = "tMap_1";

					/**
					 * [tMap_1 process_data_end ] stop
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
				globalMap.put("tFixedFlowInput_1_NB_LINE", 1);

				ok_Hash.put("tFixedFlowInput_1", true);
				end_Hash.put("tFixedFlowInput_1", System.currentTimeMillis());

				/**
				 * [tFixedFlowInput_1 end ] stop
				 */

				/**
				 * [tMap_1 end ] start
				 */

				currentComponent = "tMap_1";

				// ###############################
				// # Lookup hashes releasing
				if (tHash_Lookup_partenaire != null) {
					tHash_Lookup_partenaire.endGet();
				}
				globalMap.remove("tHash_Lookup_partenaire");

				if (tHash_Lookup_type_autorisation != null) {
					tHash_Lookup_type_autorisation.endGet();
				}
				globalMap.remove("tHash_Lookup_type_autorisation");

				if (tHash_Lookup_type_edi != null) {
					tHash_Lookup_type_edi.endGet();
				}
				globalMap.remove("tHash_Lookup_type_edi");

				// ###############################
				log.debug("tMap_1 - Written records count in the table 'out1': "
						+ count_out1_tMap_1 + ".");

				if (execStat) {
					if (resourceMap.get("inIterateVComp") == null
							|| !((Boolean) resourceMap.get("inIterateVComp"))) {
						runStat.updateStatOnConnection("row1" + iterateId, 2, 0);
					}
				}

				if (log.isDebugEnabled())
					log.debug("tMap_1 - " + ("Done."));

				ok_Hash.put("tMap_1", true);
				end_Hash.put("tMap_1", System.currentTimeMillis());

				/**
				 * [tMap_1 end ] stop
				 */

				/**
				 * [tLogRow_3 end ] start
				 */

				currentComponent = "tLogRow_3";

				// ////

				java.io.PrintStream consoleOut_tLogRow_3 = null;
				if (globalMap.get("tLogRow_CONSOLE") != null) {
					consoleOut_tLogRow_3 = (java.io.PrintStream) globalMap
							.get("tLogRow_CONSOLE");
				} else {
					consoleOut_tLogRow_3 = new java.io.PrintStream(
							new java.io.BufferedOutputStream(System.out));
					globalMap.put("tLogRow_CONSOLE", consoleOut_tLogRow_3);
				}

				consoleOut_tLogRow_3
						.println(util_tLogRow_3.format().toString());
				consoleOut_tLogRow_3.flush();
				// ////
				globalMap.put("tLogRow_3_NB_LINE", nb_line_tLogRow_3);
				if (log.isInfoEnabled())
					log.info("tLogRow_3 - " + ("Printed row count: ")
							+ (nb_line_tLogRow_3) + ("."));

				// /////////////////////

				if (execStat) {
					if (resourceMap.get("inIterateVComp") == null
							|| !((Boolean) resourceMap.get("inIterateVComp"))) {
						runStat.updateStatOnConnection("out1" + iterateId, 2, 0);
					}
				}

				if (log.isDebugEnabled())
					log.debug("tLogRow_3 - " + ("Done."));

				ok_Hash.put("tLogRow_3", true);
				end_Hash.put("tLogRow_3", System.currentTimeMillis());

				/**
				 * [tLogRow_3 end ] stop
				 */

				/**
				 * [tMap_2 end ] start
				 */

				currentComponent = "tMap_2";

				// ###############################
				// # Lookup hashes releasing
				if (tHash_Lookup_row2 != null) {
					tHash_Lookup_row2.endGet();
				}
				globalMap.remove("tHash_Lookup_row2");

				// ###############################
				log.debug("tMap_2 - Written records count in the table 'ok': "
						+ count_ok_tMap_2 + ".");
				log.debug("tMap_2 - Written records count in the table 'ko': "
						+ count_ko_tMap_2 + ".");

				if (execStat) {
					if (resourceMap.get("inIterateVComp") == null
							|| !((Boolean) resourceMap.get("inIterateVComp"))) {
						runStat.updateStatOnConnection("row3" + iterateId, 2, 0);
					}
				}

				if (log.isDebugEnabled())
					log.debug("tMap_2 - " + ("Done."));

				ok_Hash.put("tMap_2", true);
				end_Hash.put("tMap_2", System.currentTimeMillis());

				/**
				 * [tMap_2 end ] stop
				 */

				/**
				 * [tLogRow_1 end ] start
				 */

				currentComponent = "tLogRow_1";

				// ////

				java.io.PrintStream consoleOut_tLogRow_1 = null;
				if (globalMap.get("tLogRow_CONSOLE") != null) {
					consoleOut_tLogRow_1 = (java.io.PrintStream) globalMap
							.get("tLogRow_CONSOLE");
				} else {
					consoleOut_tLogRow_1 = new java.io.PrintStream(
							new java.io.BufferedOutputStream(System.out));
					globalMap.put("tLogRow_CONSOLE", consoleOut_tLogRow_1);
				}

				consoleOut_tLogRow_1
						.println(util_tLogRow_1.format().toString());
				consoleOut_tLogRow_1.flush();
				// ////
				globalMap.put("tLogRow_1_NB_LINE", nb_line_tLogRow_1);
				if (log.isInfoEnabled())
					log.info("tLogRow_1 - " + ("Printed row count: ")
							+ (nb_line_tLogRow_1) + ("."));

				// /////////////////////

				if (execStat) {
					if (resourceMap.get("inIterateVComp") == null
							|| !((Boolean) resourceMap.get("inIterateVComp"))) {
						runStat.updateStatOnConnection("ok" + iterateId, 2, 0);
					}
				}

				if (log.isDebugEnabled())
					log.debug("tLogRow_1 - " + ("Done."));

				ok_Hash.put("tLogRow_1", true);
				end_Hash.put("tLogRow_1", System.currentTimeMillis());

				/**
				 * [tLogRow_1 end ] stop
				 */

				/**
				 * [tLogRow_2 end ] start
				 */

				currentComponent = "tLogRow_2";

				// ////

				java.io.PrintStream consoleOut_tLogRow_2 = null;
				if (globalMap.get("tLogRow_CONSOLE") != null) {
					consoleOut_tLogRow_2 = (java.io.PrintStream) globalMap
							.get("tLogRow_CONSOLE");
				} else {
					consoleOut_tLogRow_2 = new java.io.PrintStream(
							new java.io.BufferedOutputStream(System.out));
					globalMap.put("tLogRow_CONSOLE", consoleOut_tLogRow_2);
				}

				consoleOut_tLogRow_2
						.println(util_tLogRow_2.format().toString());
				consoleOut_tLogRow_2.flush();
				// ////
				globalMap.put("tLogRow_2_NB_LINE", nb_line_tLogRow_2);
				if (log.isInfoEnabled())
					log.info("tLogRow_2 - " + ("Printed row count: ")
							+ (nb_line_tLogRow_2) + ("."));

				// /////////////////////

				if (execStat) {
					if (resourceMap.get("inIterateVComp") == null
							|| !((Boolean) resourceMap.get("inIterateVComp"))) {
						runStat.updateStatOnConnection("ko" + iterateId, 2, 0);
					}
				}

				if (log.isDebugEnabled())
					log.debug("tLogRow_2 - " + ("Done."));

				ok_Hash.put("tLogRow_2", true);
				end_Hash.put("tLogRow_2", System.currentTimeMillis());

				/**
				 * [tLogRow_2 end ] stop
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

			// free memory for "tMap_2"
			globalMap.remove("tHash_Lookup_row2");

			// free memory for "tMap_1"
			globalMap.remove("tHash_Lookup_partenaire");

			// free memory for "tMap_1"
			globalMap.remove("tHash_Lookup_type_autorisation");

			// free memory for "tMap_1"
			globalMap.remove("tHash_Lookup_type_edi");

			try {

				/**
				 * [tFixedFlowInput_1 finally ] start
				 */

				currentComponent = "tFixedFlowInput_1";

				/**
				 * [tFixedFlowInput_1 finally ] stop
				 */

				/**
				 * [tMap_1 finally ] start
				 */

				currentComponent = "tMap_1";

				/**
				 * [tMap_1 finally ] stop
				 */

				/**
				 * [tLogRow_3 finally ] start
				 */

				currentComponent = "tLogRow_3";

				/**
				 * [tLogRow_3 finally ] stop
				 */

				/**
				 * [tMap_2 finally ] start
				 */

				currentComponent = "tMap_2";

				/**
				 * [tMap_2 finally ] stop
				 */

				/**
				 * [tLogRow_1 finally ] start
				 */

				currentComponent = "tLogRow_1";

				/**
				 * [tLogRow_1 finally ] stop
				 */

				/**
				 * [tLogRow_2 finally ] start
				 */

				currentComponent = "tLogRow_2";

				/**
				 * [tLogRow_2 finally ] stop
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

	public static class partenaireStruct implements
			routines.system.IPersistableComparableLookupRow<partenaireStruct> {
		final static byte[] commonByteArrayLock_TEST_verif_statut_edi = new byte[0];
		static byte[] commonByteArray_TEST_verif_statut_edi = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public int PAR_ID;

		public int getPAR_ID() {
			return this.PAR_ID;
		}

		public String CODE;

		public String getCODE() {
			return this.CODE;
		}

		public String REPERTOIRE_FTP;

		public String getREPERTOIRE_FTP() {
			return this.REPERTOIRE_FTP;
		}

		public String NOM;

		public String getNOM() {
			return this.NOM;
		}

		public Boolean EST_ACTIF;

		public Boolean getEST_ACTIF() {
			return this.EST_ACTIF;
		}

		public java.util.Date CREE_LE;

		public java.util.Date getCREE_LE() {
			return this.CREE_LE;
		}

		public Integer CREE_PAR;

		public Integer getCREE_PAR() {
			return this.CREE_PAR;
		}

		public java.util.Date MODIFIE_LE;

		public java.util.Date getMODIFIE_LE() {
			return this.MODIFIE_LE;
		}

		public Integer MODIFIER_PAR;

		public Integer getMODIFIER_PAR() {
			return this.MODIFIER_PAR;
		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result
						+ ((this.CODE == null) ? 0 : this.CODE.hashCode());

				this.hashCode = result;
				this.hashCodeDirty = false;
			}
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final partenaireStruct other = (partenaireStruct) obj;

			if (this.CODE == null) {
				if (other.CODE != null)
					return false;

			} else if (!this.CODE.equals(other.CODE))

				return false;

			return true;
		}

		public void copyDataTo(partenaireStruct other) {

			other.PAR_ID = this.PAR_ID;
			other.CODE = this.CODE;
			other.REPERTOIRE_FTP = this.REPERTOIRE_FTP;
			other.NOM = this.NOM;
			other.EST_ACTIF = this.EST_ACTIF;
			other.CREE_LE = this.CREE_LE;
			other.CREE_PAR = this.CREE_PAR;
			other.MODIFIE_LE = this.MODIFIE_LE;
			other.MODIFIER_PAR = this.MODIFIER_PAR;

		}

		public void copyKeysDataTo(partenaireStruct other) {

			other.CODE = this.CODE;

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_TEST_verif_statut_edi.length) {
					if (length < 1024
							&& commonByteArray_TEST_verif_statut_edi.length == 0) {
						commonByteArray_TEST_verif_statut_edi = new byte[1024];
					} else {
						commonByteArray_TEST_verif_statut_edi = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_TEST_verif_statut_edi, 0, length);
				strReturn = new String(commonByteArray_TEST_verif_statut_edi,
						0, length, utf8Charset);
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

		private String readString(DataInputStream dis, ObjectInputStream ois)
				throws IOException {
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

		private void writeString(String str, DataOutputStream dos,
				ObjectOutputStream oos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private java.util.Date readDate(DataInputStream dis,
				ObjectInputStream ois) throws IOException {
			java.util.Date dateReturn = null;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				dateReturn = null;
			} else {
				dateReturn = new Date(dis.readLong());
			}
			return dateReturn;
		}

		private void writeDate(java.util.Date date1, DataOutputStream dos,
				ObjectOutputStream oos) throws IOException {
			if (date1 == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeLong(date1.getTime());
			}
		}

		private Integer readInteger(DataInputStream dis, ObjectInputStream ois)
				throws IOException {
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

		private void writeInteger(Integer intNum, DataOutputStream dos,
				ObjectOutputStream oos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		public void readKeysData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_TEST_verif_statut_edi) {

				try {

					int length = 0;

					this.CODE = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeKeysData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.CODE, dos);

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

				this.PAR_ID = dis.readInt();

				this.REPERTOIRE_FTP = readString(dis, ois);

				this.NOM = readString(dis, ois);

				length = dis.readByte();
				if (length == -1) {
					this.EST_ACTIF = null;
				} else {
					this.EST_ACTIF = dis.readBoolean();
				}

				this.CREE_LE = readDate(dis, ois);

				this.CREE_PAR = readInteger(dis, ois);

				this.MODIFIE_LE = readDate(dis, ois);

				this.MODIFIER_PAR = readInteger(dis, ois);

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		/**
		 * Return a byte array which represents Values data.
		 */
		public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
			try {

				dos.writeInt(this.PAR_ID);

				writeString(this.REPERTOIRE_FTP, dos, oos);

				writeString(this.NOM, dos, oos);

				if (this.EST_ACTIF == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeBoolean(this.EST_ACTIF);
				}

				writeDate(this.CREE_LE, dos, oos);

				writeInteger(this.CREE_PAR, dos, oos);

				writeDate(this.MODIFIE_LE, dos, oos);

				writeInteger(this.MODIFIER_PAR, dos, oos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("PAR_ID=" + String.valueOf(PAR_ID));
			sb.append(",CODE=" + CODE);
			sb.append(",REPERTOIRE_FTP=" + REPERTOIRE_FTP);
			sb.append(",NOM=" + NOM);
			sb.append(",EST_ACTIF=" + String.valueOf(EST_ACTIF));
			sb.append(",CREE_LE=" + String.valueOf(CREE_LE));
			sb.append(",CREE_PAR=" + String.valueOf(CREE_PAR));
			sb.append(",MODIFIE_LE=" + String.valueOf(MODIFIE_LE));
			sb.append(",MODIFIER_PAR=" + String.valueOf(MODIFIER_PAR));
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			sb.append(PAR_ID);

			sb.append("|");

			if (CODE == null) {
				sb.append("<null>");
			} else {
				sb.append(CODE);
			}

			sb.append("|");

			if (REPERTOIRE_FTP == null) {
				sb.append("<null>");
			} else {
				sb.append(REPERTOIRE_FTP);
			}

			sb.append("|");

			if (NOM == null) {
				sb.append("<null>");
			} else {
				sb.append(NOM);
			}

			sb.append("|");

			if (EST_ACTIF == null) {
				sb.append("<null>");
			} else {
				sb.append(EST_ACTIF);
			}

			sb.append("|");

			if (CREE_LE == null) {
				sb.append("<null>");
			} else {
				sb.append(CREE_LE);
			}

			sb.append("|");

			if (CREE_PAR == null) {
				sb.append("<null>");
			} else {
				sb.append(CREE_PAR);
			}

			sb.append("|");

			if (MODIFIE_LE == null) {
				sb.append("<null>");
			} else {
				sb.append(MODIFIE_LE);
			}

			sb.append("|");

			if (MODIFIER_PAR == null) {
				sb.append("<null>");
			} else {
				sb.append(MODIFIER_PAR);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(partenaireStruct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.CODE, other.CODE);
			if (returnValue != 0) {
				return returnValue;
			}

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

	public void tDBInput_1Process(final java.util.Map<String, Object> globalMap)
			throws TalendException {
		globalMap.put("tDBInput_1_SUBPROCESS_STATE", 0);

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

				partenaireStruct partenaire = new partenaireStruct();

				/**
				 * [tAdvancedHash_partenaire begin ] start
				 */

				ok_Hash.put("tAdvancedHash_partenaire", false);
				start_Hash.put("tAdvancedHash_partenaire",
						System.currentTimeMillis());

				currentComponent = "tAdvancedHash_partenaire";

				if (execStat) {
					if (resourceMap.get("inIterateVComp") == null) {

						runStat.updateStatOnConnection(
								"partenaire" + iterateId, 0, 0);

					}
				}

				int tos_count_tAdvancedHash_partenaire = 0;

				// connection name:partenaire
				// source node:tDBInput_1 - inputs:(after_tFixedFlowInput_1)
				// outputs:(partenaire,partenaire) | target
				// node:tAdvancedHash_partenaire - inputs:(partenaire)
				// outputs:()
				// linked node: tMap_1 -
				// inputs:(row1,partenaire,type_autorisation,type_edi)
				// outputs:(out1)

				org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_partenaire = org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<partenaireStruct> tHash_Lookup_partenaire = org.talend.designer.components.lookup.memory.AdvancedMemoryLookup
						.<partenaireStruct> getLookup(matchingModeEnum_partenaire);

				globalMap.put("tHash_Lookup_partenaire",
						tHash_Lookup_partenaire);

				/**
				 * [tAdvancedHash_partenaire begin ] stop
				 */

				/**
				 * [tDBInput_1 begin ] start
				 */

				ok_Hash.put("tDBInput_1", false);
				start_Hash.put("tDBInput_1", System.currentTimeMillis());

				currentComponent = "tDBInput_1";

				int tos_count_tDBInput_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tDBInput_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tDBInput_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tDBInput_1 = new StringBuilder();
							log4jParamters_tDBInput_1.append("Parameters:");
							log4jParamters_tDBInput_1
									.append("USE_EXISTING_CONNECTION" + " = "
											+ "true");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("CONNECTION"
									+ " = " + "tDBConnection_2");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("TABLE" + " = "
									+ "\"PARTENAIRE\"");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("QUERYSTORE"
									+ " = " + "\"\"");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("QUERY" + " = "
									+ "\"select * from partenaire;\"");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("TRIM_ALL_COLUMN"
									+ " = " + "false");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("TRIM_COLUMN"
									+ " = " + "[{TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("PAR_ID")
									+ "}, {TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("CODE")
									+ "}, {TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("REPERTOIRE_FTP")
									+ "}, {TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("NOM")
									+ "}, {TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("EST_ACTIF")
									+ "}, {TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("CREE_LE")
									+ "}, {TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("CREE_PAR")
									+ "}, {TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("MODIFIE_LE")
									+ "}, {TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("MODIFIER_PAR")
									+ "}]");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1
									.append("UNIFIED_COMPONENTS" + " = "
											+ "tMSSqlInput");
							log4jParamters_tDBInput_1.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tDBInput_1 - "
										+ (log4jParamters_tDBInput_1));
						}
					}
					new BytesLimit65535_tDBInput_1().limitLog4jByte();
				}

				org.talend.designer.components.util.mssql.MSSqlGenerateTimestampUtil mssqlGTU_tDBInput_1 = org.talend.designer.components.util.mssql.MSSqlUtilFactory
						.getMSSqlGenerateTimestampUtil();

				java.util.List<String> talendToDBList_tDBInput_1 = new java.util.ArrayList();
				String[] talendToDBArray_tDBInput_1 = new String[] { "FLOAT",
						"NUMERIC", "NUMERIC IDENTITY", "DECIMAL",
						"DECIMAL IDENTITY", "REAL" };
				java.util.Collections.addAll(talendToDBList_tDBInput_1,
						talendToDBArray_tDBInput_1);
				int nb_line_tDBInput_1 = 0;
				java.sql.Connection conn_tDBInput_1 = null;
				conn_tDBInput_1 = (java.sql.Connection) globalMap
						.get("conn_tDBConnection_2");
				if (conn_tDBInput_1 != null) {
					if (conn_tDBInput_1.getMetaData() != null) {

						log.debug("tDBInput_1 - Uses an existing connection with username '"
								+ conn_tDBInput_1.getMetaData().getUserName()
								+ "'. Connection URL: "
								+ conn_tDBInput_1.getMetaData().getURL() + ".");

					}
				}

				String dbschema_tDBInput_1 = (String) globalMap
						.get("dbschema_tDBConnection_2");

				java.sql.Statement stmt_tDBInput_1 = conn_tDBInput_1
						.createStatement();

				String dbquery_tDBInput_1 = "select * from partenaire;";

				log.debug("tDBInput_1 - Executing the query: '"
						+ dbquery_tDBInput_1 + "'.");

				globalMap.put("tDBInput_1_QUERY", dbquery_tDBInput_1);
				java.sql.ResultSet rs_tDBInput_1 = null;

				try {
					rs_tDBInput_1 = stmt_tDBInput_1
							.executeQuery(dbquery_tDBInput_1);
					java.sql.ResultSetMetaData rsmd_tDBInput_1 = rs_tDBInput_1
							.getMetaData();
					int colQtyInRs_tDBInput_1 = rsmd_tDBInput_1
							.getColumnCount();

					String tmpContent_tDBInput_1 = null;

					log.debug("tDBInput_1 - Retrieving records from the database.");

					while (rs_tDBInput_1.next()) {
						nb_line_tDBInput_1++;

						if (colQtyInRs_tDBInput_1 < 1) {
							partenaire.PAR_ID = 0;
						} else {

							if (rs_tDBInput_1.getObject(1) != null) {
								partenaire.PAR_ID = rs_tDBInput_1.getInt(1);
							} else {
								throw new RuntimeException(
										"Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_1 < 2) {
							partenaire.CODE = null;
						} else {

							tmpContent_tDBInput_1 = rs_tDBInput_1.getString(2);
							if (tmpContent_tDBInput_1 != null) {
								if (talendToDBList_tDBInput_1
										.contains(rsmd_tDBInput_1
												.getColumnTypeName(2)
												.toUpperCase(
														java.util.Locale.ENGLISH))) {
									partenaire.CODE = FormatterUtils
											.formatUnwithE(tmpContent_tDBInput_1);
								} else {
									partenaire.CODE = tmpContent_tDBInput_1;
								}
							} else {
								partenaire.CODE = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 3) {
							partenaire.REPERTOIRE_FTP = null;
						} else {

							tmpContent_tDBInput_1 = rs_tDBInput_1.getString(3);
							if (tmpContent_tDBInput_1 != null) {
								if (talendToDBList_tDBInput_1
										.contains(rsmd_tDBInput_1
												.getColumnTypeName(3)
												.toUpperCase(
														java.util.Locale.ENGLISH))) {
									partenaire.REPERTOIRE_FTP = FormatterUtils
											.formatUnwithE(tmpContent_tDBInput_1);
								} else {
									partenaire.REPERTOIRE_FTP = tmpContent_tDBInput_1;
								}
							} else {
								partenaire.REPERTOIRE_FTP = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 4) {
							partenaire.NOM = null;
						} else {

							tmpContent_tDBInput_1 = rs_tDBInput_1.getString(4);
							if (tmpContent_tDBInput_1 != null) {
								if (talendToDBList_tDBInput_1
										.contains(rsmd_tDBInput_1
												.getColumnTypeName(4)
												.toUpperCase(
														java.util.Locale.ENGLISH))) {
									partenaire.NOM = FormatterUtils
											.formatUnwithE(tmpContent_tDBInput_1);
								} else {
									partenaire.NOM = tmpContent_tDBInput_1;
								}
							} else {
								partenaire.NOM = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 5) {
							partenaire.EST_ACTIF = null;
						} else {

							if (rs_tDBInput_1.getObject(5) != null) {
								partenaire.EST_ACTIF = rs_tDBInput_1
										.getBoolean(5);
							} else {
								partenaire.EST_ACTIF = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 6) {
							partenaire.CREE_LE = null;
						} else {

							partenaire.CREE_LE = mssqlGTU_tDBInput_1.getDate(
									rsmd_tDBInput_1, rs_tDBInput_1, 6);

						}
						if (colQtyInRs_tDBInput_1 < 7) {
							partenaire.CREE_PAR = null;
						} else {

							if (rs_tDBInput_1.getObject(7) != null) {
								partenaire.CREE_PAR = rs_tDBInput_1.getInt(7);
							} else {
								partenaire.CREE_PAR = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 8) {
							partenaire.MODIFIE_LE = null;
						} else {

							partenaire.MODIFIE_LE = mssqlGTU_tDBInput_1
									.getDate(rsmd_tDBInput_1, rs_tDBInput_1, 8);

						}
						if (colQtyInRs_tDBInput_1 < 9) {
							partenaire.MODIFIER_PAR = null;
						} else {

							if (rs_tDBInput_1.getObject(9) != null) {
								partenaire.MODIFIER_PAR = rs_tDBInput_1
										.getInt(9);
							} else {
								partenaire.MODIFIER_PAR = null;
							}
						}

						log.debug("tDBInput_1 - Retrieving the record "
								+ nb_line_tDBInput_1 + ".");

						/**
						 * [tDBInput_1 begin ] stop
						 */

						/**
						 * [tDBInput_1 main ] start
						 */

						currentComponent = "tDBInput_1";

						tos_count_tDBInput_1++;

						/**
						 * [tDBInput_1 main ] stop
						 */

						/**
						 * [tDBInput_1 process_data_begin ] start
						 */

						currentComponent = "tDBInput_1";

						/**
						 * [tDBInput_1 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_partenaire main ] start
						 */

						currentComponent = "tAdvancedHash_partenaire";

						// partenaire
						// partenaire

						if (execStat) {
							runStat.updateStatOnConnection("partenaire"
									+ iterateId, 1, 1);
						}

						if (log.isTraceEnabled()) {
							log.trace("partenaire - "
									+ (partenaire == null ? "" : partenaire
											.toLogString()));
						}

						partenaireStruct partenaire_HashRow = new partenaireStruct();

						partenaire_HashRow.PAR_ID = partenaire.PAR_ID;

						partenaire_HashRow.CODE = partenaire.CODE;

						partenaire_HashRow.REPERTOIRE_FTP = partenaire.REPERTOIRE_FTP;

						partenaire_HashRow.NOM = partenaire.NOM;

						partenaire_HashRow.EST_ACTIF = partenaire.EST_ACTIF;

						partenaire_HashRow.CREE_LE = partenaire.CREE_LE;

						partenaire_HashRow.CREE_PAR = partenaire.CREE_PAR;

						partenaire_HashRow.MODIFIE_LE = partenaire.MODIFIE_LE;

						partenaire_HashRow.MODIFIER_PAR = partenaire.MODIFIER_PAR;

						tHash_Lookup_partenaire.put(partenaire_HashRow);

						tos_count_tAdvancedHash_partenaire++;

						/**
						 * [tAdvancedHash_partenaire main ] stop
						 */

						/**
						 * [tAdvancedHash_partenaire process_data_begin ] start
						 */

						currentComponent = "tAdvancedHash_partenaire";

						/**
						 * [tAdvancedHash_partenaire process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_partenaire process_data_end ] start
						 */

						currentComponent = "tAdvancedHash_partenaire";

						/**
						 * [tAdvancedHash_partenaire process_data_end ] stop
						 */

						/**
						 * [tDBInput_1 process_data_end ] start
						 */

						currentComponent = "tDBInput_1";

						/**
						 * [tDBInput_1 process_data_end ] stop
						 */

						/**
						 * [tDBInput_1 end ] start
						 */

						currentComponent = "tDBInput_1";

					}
				} finally {
					if (rs_tDBInput_1 != null) {
						rs_tDBInput_1.close();
					}
					if (stmt_tDBInput_1 != null) {
						stmt_tDBInput_1.close();
					}
				}
				globalMap.put("tDBInput_1_NB_LINE", nb_line_tDBInput_1);
				log.debug("tDBInput_1 - Retrieved records count: "
						+ nb_line_tDBInput_1 + " .");

				if (log.isDebugEnabled())
					log.debug("tDBInput_1 - " + ("Done."));

				ok_Hash.put("tDBInput_1", true);
				end_Hash.put("tDBInput_1", System.currentTimeMillis());

				/**
				 * [tDBInput_1 end ] stop
				 */

				/**
				 * [tAdvancedHash_partenaire end ] start
				 */

				currentComponent = "tAdvancedHash_partenaire";

				tHash_Lookup_partenaire.endPut();

				if (execStat) {
					if (resourceMap.get("inIterateVComp") == null
							|| !((Boolean) resourceMap.get("inIterateVComp"))) {
						runStat.updateStatOnConnection(
								"partenaire" + iterateId, 2, 0);
					}
				}

				ok_Hash.put("tAdvancedHash_partenaire", true);
				end_Hash.put("tAdvancedHash_partenaire",
						System.currentTimeMillis());

				/**
				 * [tAdvancedHash_partenaire end ] stop
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
				 * [tDBInput_1 finally ] start
				 */

				currentComponent = "tDBInput_1";

				/**
				 * [tDBInput_1 finally ] stop
				 */

				/**
				 * [tAdvancedHash_partenaire finally ] start
				 */

				currentComponent = "tAdvancedHash_partenaire";

				/**
				 * [tAdvancedHash_partenaire finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBInput_1_SUBPROCESS_STATE", 1);
	}

	public static class type_autorisationStruct implements
			routines.system.IPersistableRow<type_autorisationStruct> {
		final static byte[] commonByteArrayLock_TEST_verif_statut_edi = new byte[0];
		static byte[] commonByteArray_TEST_verif_statut_edi = new byte[0];

		public String TAU_CODE;

		public String getTAU_CODE() {
			return this.TAU_CODE;
		}

		public String DESCRIPTION;

		public String getDESCRIPTION() {
			return this.DESCRIPTION;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_TEST_verif_statut_edi.length) {
					if (length < 1024
							&& commonByteArray_TEST_verif_statut_edi.length == 0) {
						commonByteArray_TEST_verif_statut_edi = new byte[1024];
					} else {
						commonByteArray_TEST_verif_statut_edi = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_TEST_verif_statut_edi, 0, length);
				strReturn = new String(commonByteArray_TEST_verif_statut_edi,
						0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_TEST_verif_statut_edi) {

				try {

					int length = 0;

					this.TAU_CODE = readString(dis);

					this.DESCRIPTION = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.TAU_CODE, dos);

				// String

				writeString(this.DESCRIPTION, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("TAU_CODE=" + TAU_CODE);
			sb.append(",DESCRIPTION=" + DESCRIPTION);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (TAU_CODE == null) {
				sb.append("<null>");
			} else {
				sb.append(TAU_CODE);
			}

			sb.append("|");

			if (DESCRIPTION == null) {
				sb.append("<null>");
			} else {
				sb.append(DESCRIPTION);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(type_autorisationStruct other) {

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

				type_autorisationStruct type_autorisation = new type_autorisationStruct();

				/**
				 * [tAdvancedHash_type_autorisation begin ] start
				 */

				ok_Hash.put("tAdvancedHash_type_autorisation", false);
				start_Hash.put("tAdvancedHash_type_autorisation",
						System.currentTimeMillis());

				currentComponent = "tAdvancedHash_type_autorisation";

				if (execStat) {
					if (resourceMap.get("inIterateVComp") == null) {

						runStat.updateStatOnConnection("type_autorisation"
								+ iterateId, 0, 0);

					}
				}

				int tos_count_tAdvancedHash_type_autorisation = 0;

				// connection name:type_autorisation
				// source node:tDBInput_2 - inputs:(after_tFixedFlowInput_1)
				// outputs:(type_autorisation,type_autorisation) | target
				// node:tAdvancedHash_type_autorisation -
				// inputs:(type_autorisation) outputs:()
				// linked node: tMap_1 -
				// inputs:(row1,partenaire,type_autorisation,type_edi)
				// outputs:(out1)

				org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_type_autorisation = org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.ALL_ROWS;

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<type_autorisationStruct> tHash_Lookup_type_autorisation = org.talend.designer.components.lookup.memory.AdvancedMemoryLookup
						.<type_autorisationStruct> getLookup(matchingModeEnum_type_autorisation);

				globalMap.put("tHash_Lookup_type_autorisation",
						tHash_Lookup_type_autorisation);

				/**
				 * [tAdvancedHash_type_autorisation begin ] stop
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
									+ " = " + "tDBConnection_2");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("TABLE" + " = "
									+ "\"TYPEAUTORISATION\"");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("QUERYSTORE"
									+ " = " + "\"\"");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2
									.append("QUERY"
											+ " = "
											+ "\"select * from typeautorisation where description = 'Prod';\"");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("TRIM_ALL_COLUMN"
									+ " = " + "false");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("TRIM_COLUMN"
									+ " = " + "[{TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("TAU_CODE")
									+ "}, {TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("DESCRIPTION")
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
						.get("conn_tDBConnection_2");
				if (conn_tDBInput_2 != null) {
					if (conn_tDBInput_2.getMetaData() != null) {

						log.debug("tDBInput_2 - Uses an existing connection with username '"
								+ conn_tDBInput_2.getMetaData().getUserName()
								+ "'. Connection URL: "
								+ conn_tDBInput_2.getMetaData().getURL() + ".");

					}
				}

				String dbschema_tDBInput_2 = (String) globalMap
						.get("dbschema_tDBConnection_2");

				java.sql.Statement stmt_tDBInput_2 = conn_tDBInput_2
						.createStatement();

				String dbquery_tDBInput_2 = "select * from typeautorisation where description = 'Prod';";

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
							type_autorisation.TAU_CODE = null;
						} else {

							tmpContent_tDBInput_2 = rs_tDBInput_2.getString(1);
							if (tmpContent_tDBInput_2 != null) {
								if (talendToDBList_tDBInput_2
										.contains(rsmd_tDBInput_2
												.getColumnTypeName(1)
												.toUpperCase(
														java.util.Locale.ENGLISH))) {
									type_autorisation.TAU_CODE = FormatterUtils
											.formatUnwithE(tmpContent_tDBInput_2);
								} else {
									type_autorisation.TAU_CODE = tmpContent_tDBInput_2;
								}
							} else {
								type_autorisation.TAU_CODE = null;
							}
						}
						if (colQtyInRs_tDBInput_2 < 2) {
							type_autorisation.DESCRIPTION = null;
						} else {

							tmpContent_tDBInput_2 = rs_tDBInput_2.getString(2);
							if (tmpContent_tDBInput_2 != null) {
								if (talendToDBList_tDBInput_2
										.contains(rsmd_tDBInput_2
												.getColumnTypeName(2)
												.toUpperCase(
														java.util.Locale.ENGLISH))) {
									type_autorisation.DESCRIPTION = FormatterUtils
											.formatUnwithE(tmpContent_tDBInput_2);
								} else {
									type_autorisation.DESCRIPTION = tmpContent_tDBInput_2;
								}
							} else {
								type_autorisation.DESCRIPTION = null;
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
						 * [tAdvancedHash_type_autorisation main ] start
						 */

						currentComponent = "tAdvancedHash_type_autorisation";

						// type_autorisation
						// type_autorisation

						if (execStat) {
							runStat.updateStatOnConnection("type_autorisation"
									+ iterateId, 1, 1);
						}

						if (log.isTraceEnabled()) {
							log.trace("type_autorisation - "
									+ (type_autorisation == null ? ""
											: type_autorisation.toLogString()));
						}

						type_autorisationStruct type_autorisation_HashRow = new type_autorisationStruct();

						type_autorisation_HashRow.TAU_CODE = type_autorisation.TAU_CODE;

						type_autorisation_HashRow.DESCRIPTION = type_autorisation.DESCRIPTION;

						tHash_Lookup_type_autorisation
								.put(type_autorisation_HashRow);

						tos_count_tAdvancedHash_type_autorisation++;

						/**
						 * [tAdvancedHash_type_autorisation main ] stop
						 */

						/**
						 * [tAdvancedHash_type_autorisation process_data_begin ]
						 * start
						 */

						currentComponent = "tAdvancedHash_type_autorisation";

						/**
						 * [tAdvancedHash_type_autorisation process_data_begin ]
						 * stop
						 */

						/**
						 * [tAdvancedHash_type_autorisation process_data_end ]
						 * start
						 */

						currentComponent = "tAdvancedHash_type_autorisation";

						/**
						 * [tAdvancedHash_type_autorisation process_data_end ]
						 * stop
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
				 * [tAdvancedHash_type_autorisation end ] start
				 */

				currentComponent = "tAdvancedHash_type_autorisation";

				tHash_Lookup_type_autorisation.endPut();

				if (execStat) {
					if (resourceMap.get("inIterateVComp") == null
							|| !((Boolean) resourceMap.get("inIterateVComp"))) {
						runStat.updateStatOnConnection("type_autorisation"
								+ iterateId, 2, 0);
					}
				}

				ok_Hash.put("tAdvancedHash_type_autorisation", true);
				end_Hash.put("tAdvancedHash_type_autorisation",
						System.currentTimeMillis());

				/**
				 * [tAdvancedHash_type_autorisation end ] stop
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
				 * [tDBInput_2 finally ] start
				 */

				currentComponent = "tDBInput_2";

				/**
				 * [tDBInput_2 finally ] stop
				 */

				/**
				 * [tAdvancedHash_type_autorisation finally ] start
				 */

				currentComponent = "tAdvancedHash_type_autorisation";

				/**
				 * [tAdvancedHash_type_autorisation finally ] stop
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

	public static class type_ediStruct implements
			routines.system.IPersistableComparableLookupRow<type_ediStruct> {
		final static byte[] commonByteArrayLock_TEST_verif_statut_edi = new byte[0];
		static byte[] commonByteArray_TEST_verif_statut_edi = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public int TED_ID;

		public int getTED_ID() {
			return this.TED_ID;
		}

		public String CODE;

		public String getCODE() {
			return this.CODE;
		}

		public String LIBELLE_COURT;

		public String getLIBELLE_COURT() {
			return this.LIBELLE_COURT;
		}

		public String LIBELLE_LONG;

		public String getLIBELLE_LONG() {
			return this.LIBELLE_LONG;
		}

		public Integer ORDER;

		public Integer getORDER() {
			return this.ORDER;
		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result
						+ ((this.CODE == null) ? 0 : this.CODE.hashCode());

				this.hashCode = result;
				this.hashCodeDirty = false;
			}
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final type_ediStruct other = (type_ediStruct) obj;

			if (this.CODE == null) {
				if (other.CODE != null)
					return false;

			} else if (!this.CODE.equals(other.CODE))

				return false;

			return true;
		}

		public void copyDataTo(type_ediStruct other) {

			other.TED_ID = this.TED_ID;
			other.CODE = this.CODE;
			other.LIBELLE_COURT = this.LIBELLE_COURT;
			other.LIBELLE_LONG = this.LIBELLE_LONG;
			other.ORDER = this.ORDER;

		}

		public void copyKeysDataTo(type_ediStruct other) {

			other.CODE = this.CODE;

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_TEST_verif_statut_edi.length) {
					if (length < 1024
							&& commonByteArray_TEST_verif_statut_edi.length == 0) {
						commonByteArray_TEST_verif_statut_edi = new byte[1024];
					} else {
						commonByteArray_TEST_verif_statut_edi = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_TEST_verif_statut_edi, 0, length);
				strReturn = new String(commonByteArray_TEST_verif_statut_edi,
						0, length, utf8Charset);
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

		private String readString(DataInputStream dis, ObjectInputStream ois)
				throws IOException {
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

		private void writeString(String str, DataOutputStream dos,
				ObjectOutputStream oos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private Integer readInteger(DataInputStream dis, ObjectInputStream ois)
				throws IOException {
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

		private void writeInteger(Integer intNum, DataOutputStream dos,
				ObjectOutputStream oos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		public void readKeysData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_TEST_verif_statut_edi) {

				try {

					int length = 0;

					this.CODE = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeKeysData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.CODE, dos);

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

				this.TED_ID = dis.readInt();

				this.LIBELLE_COURT = readString(dis, ois);

				this.LIBELLE_LONG = readString(dis, ois);

				this.ORDER = readInteger(dis, ois);

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		/**
		 * Return a byte array which represents Values data.
		 */
		public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
			try {

				dos.writeInt(this.TED_ID);

				writeString(this.LIBELLE_COURT, dos, oos);

				writeString(this.LIBELLE_LONG, dos, oos);

				writeInteger(this.ORDER, dos, oos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("TED_ID=" + String.valueOf(TED_ID));
			sb.append(",CODE=" + CODE);
			sb.append(",LIBELLE_COURT=" + LIBELLE_COURT);
			sb.append(",LIBELLE_LONG=" + LIBELLE_LONG);
			sb.append(",ORDER=" + String.valueOf(ORDER));
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			sb.append(TED_ID);

			sb.append("|");

			if (CODE == null) {
				sb.append("<null>");
			} else {
				sb.append(CODE);
			}

			sb.append("|");

			if (LIBELLE_COURT == null) {
				sb.append("<null>");
			} else {
				sb.append(LIBELLE_COURT);
			}

			sb.append("|");

			if (LIBELLE_LONG == null) {
				sb.append("<null>");
			} else {
				sb.append(LIBELLE_LONG);
			}

			sb.append("|");

			if (ORDER == null) {
				sb.append("<null>");
			} else {
				sb.append(ORDER);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(type_ediStruct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.CODE, other.CODE);
			if (returnValue != 0) {
				return returnValue;
			}

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

	public void tDBInput_3Process(final java.util.Map<String, Object> globalMap)
			throws TalendException {
		globalMap.put("tDBInput_3_SUBPROCESS_STATE", 0);

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

				type_ediStruct type_edi = new type_ediStruct();

				/**
				 * [tAdvancedHash_type_edi begin ] start
				 */

				ok_Hash.put("tAdvancedHash_type_edi", false);
				start_Hash.put("tAdvancedHash_type_edi",
						System.currentTimeMillis());

				currentComponent = "tAdvancedHash_type_edi";

				if (execStat) {
					if (resourceMap.get("inIterateVComp") == null) {

						runStat.updateStatOnConnection("type_edi" + iterateId,
								0, 0);

					}
				}

				int tos_count_tAdvancedHash_type_edi = 0;

				// connection name:type_edi
				// source node:tDBInput_3 - inputs:(after_tFixedFlowInput_1)
				// outputs:(type_edi,type_edi) | target
				// node:tAdvancedHash_type_edi - inputs:(type_edi) outputs:()
				// linked node: tMap_1 -
				// inputs:(row1,partenaire,type_autorisation,type_edi)
				// outputs:(out1)

				org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_type_edi = org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<type_ediStruct> tHash_Lookup_type_edi = org.talend.designer.components.lookup.memory.AdvancedMemoryLookup
						.<type_ediStruct> getLookup(matchingModeEnum_type_edi);

				globalMap.put("tHash_Lookup_type_edi", tHash_Lookup_type_edi);

				/**
				 * [tAdvancedHash_type_edi begin ] stop
				 */

				/**
				 * [tDBInput_3 begin ] start
				 */

				ok_Hash.put("tDBInput_3", false);
				start_Hash.put("tDBInput_3", System.currentTimeMillis());

				currentComponent = "tDBInput_3";

				int tos_count_tDBInput_3 = 0;

				if (log.isDebugEnabled())
					log.debug("tDBInput_3 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tDBInput_3 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tDBInput_3 = new StringBuilder();
							log4jParamters_tDBInput_3.append("Parameters:");
							log4jParamters_tDBInput_3
									.append("USE_EXISTING_CONNECTION" + " = "
											+ "true");
							log4jParamters_tDBInput_3.append(" | ");
							log4jParamters_tDBInput_3.append("CONNECTION"
									+ " = " + "tDBConnection_2");
							log4jParamters_tDBInput_3.append(" | ");
							log4jParamters_tDBInput_3.append("TABLE" + " = "
									+ "\"TYPEEDI\"");
							log4jParamters_tDBInput_3.append(" | ");
							log4jParamters_tDBInput_3.append("QUERYSTORE"
									+ " = " + "\"\"");
							log4jParamters_tDBInput_3.append(" | ");
							log4jParamters_tDBInput_3.append("QUERY" + " = "
									+ "\"select * from typeedi;\"");
							log4jParamters_tDBInput_3.append(" | ");
							log4jParamters_tDBInput_3.append("TRIM_ALL_COLUMN"
									+ " = " + "false");
							log4jParamters_tDBInput_3.append(" | ");
							log4jParamters_tDBInput_3.append("TRIM_COLUMN"
									+ " = " + "[{TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("TED_ID")
									+ "}, {TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("CODE")
									+ "}, {TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("LIBELLE_COURT")
									+ "}, {TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("LIBELLE_LONG")
									+ "}, {TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("ORDER") + "}]");
							log4jParamters_tDBInput_3.append(" | ");
							log4jParamters_tDBInput_3
									.append("UNIFIED_COMPONENTS" + " = "
											+ "tMSSqlInput");
							log4jParamters_tDBInput_3.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tDBInput_3 - "
										+ (log4jParamters_tDBInput_3));
						}
					}
					new BytesLimit65535_tDBInput_3().limitLog4jByte();
				}

				org.talend.designer.components.util.mssql.MSSqlGenerateTimestampUtil mssqlGTU_tDBInput_3 = org.talend.designer.components.util.mssql.MSSqlUtilFactory
						.getMSSqlGenerateTimestampUtil();

				java.util.List<String> talendToDBList_tDBInput_3 = new java.util.ArrayList();
				String[] talendToDBArray_tDBInput_3 = new String[] { "FLOAT",
						"NUMERIC", "NUMERIC IDENTITY", "DECIMAL",
						"DECIMAL IDENTITY", "REAL" };
				java.util.Collections.addAll(talendToDBList_tDBInput_3,
						talendToDBArray_tDBInput_3);
				int nb_line_tDBInput_3 = 0;
				java.sql.Connection conn_tDBInput_3 = null;
				conn_tDBInput_3 = (java.sql.Connection) globalMap
						.get("conn_tDBConnection_2");
				if (conn_tDBInput_3 != null) {
					if (conn_tDBInput_3.getMetaData() != null) {

						log.debug("tDBInput_3 - Uses an existing connection with username '"
								+ conn_tDBInput_3.getMetaData().getUserName()
								+ "'. Connection URL: "
								+ conn_tDBInput_3.getMetaData().getURL() + ".");

					}
				}

				String dbschema_tDBInput_3 = (String) globalMap
						.get("dbschema_tDBConnection_2");

				java.sql.Statement stmt_tDBInput_3 = conn_tDBInput_3
						.createStatement();

				String dbquery_tDBInput_3 = "select * from typeedi;";

				log.debug("tDBInput_3 - Executing the query: '"
						+ dbquery_tDBInput_3 + "'.");

				globalMap.put("tDBInput_3_QUERY", dbquery_tDBInput_3);
				java.sql.ResultSet rs_tDBInput_3 = null;

				try {
					rs_tDBInput_3 = stmt_tDBInput_3
							.executeQuery(dbquery_tDBInput_3);
					java.sql.ResultSetMetaData rsmd_tDBInput_3 = rs_tDBInput_3
							.getMetaData();
					int colQtyInRs_tDBInput_3 = rsmd_tDBInput_3
							.getColumnCount();

					String tmpContent_tDBInput_3 = null;

					log.debug("tDBInput_3 - Retrieving records from the database.");

					while (rs_tDBInput_3.next()) {
						nb_line_tDBInput_3++;

						if (colQtyInRs_tDBInput_3 < 1) {
							type_edi.TED_ID = 0;
						} else {

							if (rs_tDBInput_3.getObject(1) != null) {
								type_edi.TED_ID = rs_tDBInput_3.getInt(1);
							} else {
								throw new RuntimeException(
										"Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_3 < 2) {
							type_edi.CODE = null;
						} else {

							tmpContent_tDBInput_3 = rs_tDBInput_3.getString(2);
							if (tmpContent_tDBInput_3 != null) {
								if (talendToDBList_tDBInput_3
										.contains(rsmd_tDBInput_3
												.getColumnTypeName(2)
												.toUpperCase(
														java.util.Locale.ENGLISH))) {
									type_edi.CODE = FormatterUtils
											.formatUnwithE(tmpContent_tDBInput_3);
								} else {
									type_edi.CODE = tmpContent_tDBInput_3;
								}
							} else {
								type_edi.CODE = null;
							}
						}
						if (colQtyInRs_tDBInput_3 < 3) {
							type_edi.LIBELLE_COURT = null;
						} else {

							tmpContent_tDBInput_3 = rs_tDBInput_3.getString(3);
							if (tmpContent_tDBInput_3 != null) {
								if (talendToDBList_tDBInput_3
										.contains(rsmd_tDBInput_3
												.getColumnTypeName(3)
												.toUpperCase(
														java.util.Locale.ENGLISH))) {
									type_edi.LIBELLE_COURT = FormatterUtils
											.formatUnwithE(tmpContent_tDBInput_3);
								} else {
									type_edi.LIBELLE_COURT = tmpContent_tDBInput_3;
								}
							} else {
								type_edi.LIBELLE_COURT = null;
							}
						}
						if (colQtyInRs_tDBInput_3 < 4) {
							type_edi.LIBELLE_LONG = null;
						} else {

							tmpContent_tDBInput_3 = rs_tDBInput_3.getString(4);
							if (tmpContent_tDBInput_3 != null) {
								if (talendToDBList_tDBInput_3
										.contains(rsmd_tDBInput_3
												.getColumnTypeName(4)
												.toUpperCase(
														java.util.Locale.ENGLISH))) {
									type_edi.LIBELLE_LONG = FormatterUtils
											.formatUnwithE(tmpContent_tDBInput_3);
								} else {
									type_edi.LIBELLE_LONG = tmpContent_tDBInput_3;
								}
							} else {
								type_edi.LIBELLE_LONG = null;
							}
						}
						if (colQtyInRs_tDBInput_3 < 5) {
							type_edi.ORDER = null;
						} else {

							if (rs_tDBInput_3.getObject(5) != null) {
								type_edi.ORDER = rs_tDBInput_3.getInt(5);
							} else {
								type_edi.ORDER = null;
							}
						}

						log.debug("tDBInput_3 - Retrieving the record "
								+ nb_line_tDBInput_3 + ".");

						/**
						 * [tDBInput_3 begin ] stop
						 */

						/**
						 * [tDBInput_3 main ] start
						 */

						currentComponent = "tDBInput_3";

						tos_count_tDBInput_3++;

						/**
						 * [tDBInput_3 main ] stop
						 */

						/**
						 * [tDBInput_3 process_data_begin ] start
						 */

						currentComponent = "tDBInput_3";

						/**
						 * [tDBInput_3 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_type_edi main ] start
						 */

						currentComponent = "tAdvancedHash_type_edi";

						// type_edi
						// type_edi

						if (execStat) {
							runStat.updateStatOnConnection("type_edi"
									+ iterateId, 1, 1);
						}

						if (log.isTraceEnabled()) {
							log.trace("type_edi - "
									+ (type_edi == null ? "" : type_edi
											.toLogString()));
						}

						type_ediStruct type_edi_HashRow = new type_ediStruct();

						type_edi_HashRow.TED_ID = type_edi.TED_ID;

						type_edi_HashRow.CODE = type_edi.CODE;

						type_edi_HashRow.LIBELLE_COURT = type_edi.LIBELLE_COURT;

						type_edi_HashRow.LIBELLE_LONG = type_edi.LIBELLE_LONG;

						type_edi_HashRow.ORDER = type_edi.ORDER;

						tHash_Lookup_type_edi.put(type_edi_HashRow);

						tos_count_tAdvancedHash_type_edi++;

						/**
						 * [tAdvancedHash_type_edi main ] stop
						 */

						/**
						 * [tAdvancedHash_type_edi process_data_begin ] start
						 */

						currentComponent = "tAdvancedHash_type_edi";

						/**
						 * [tAdvancedHash_type_edi process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_type_edi process_data_end ] start
						 */

						currentComponent = "tAdvancedHash_type_edi";

						/**
						 * [tAdvancedHash_type_edi process_data_end ] stop
						 */

						/**
						 * [tDBInput_3 process_data_end ] start
						 */

						currentComponent = "tDBInput_3";

						/**
						 * [tDBInput_3 process_data_end ] stop
						 */

						/**
						 * [tDBInput_3 end ] start
						 */

						currentComponent = "tDBInput_3";

					}
				} finally {
					if (rs_tDBInput_3 != null) {
						rs_tDBInput_3.close();
					}
					if (stmt_tDBInput_3 != null) {
						stmt_tDBInput_3.close();
					}
				}
				globalMap.put("tDBInput_3_NB_LINE", nb_line_tDBInput_3);
				log.debug("tDBInput_3 - Retrieved records count: "
						+ nb_line_tDBInput_3 + " .");

				if (log.isDebugEnabled())
					log.debug("tDBInput_3 - " + ("Done."));

				ok_Hash.put("tDBInput_3", true);
				end_Hash.put("tDBInput_3", System.currentTimeMillis());

				/**
				 * [tDBInput_3 end ] stop
				 */

				/**
				 * [tAdvancedHash_type_edi end ] start
				 */

				currentComponent = "tAdvancedHash_type_edi";

				tHash_Lookup_type_edi.endPut();

				if (execStat) {
					if (resourceMap.get("inIterateVComp") == null
							|| !((Boolean) resourceMap.get("inIterateVComp"))) {
						runStat.updateStatOnConnection("type_edi" + iterateId,
								2, 0);
					}
				}

				ok_Hash.put("tAdvancedHash_type_edi", true);
				end_Hash.put("tAdvancedHash_type_edi",
						System.currentTimeMillis());

				/**
				 * [tAdvancedHash_type_edi end ] stop
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
				 * [tDBInput_3 finally ] start
				 */

				currentComponent = "tDBInput_3";

				/**
				 * [tDBInput_3 finally ] stop
				 */

				/**
				 * [tAdvancedHash_type_edi finally ] start
				 */

				currentComponent = "tAdvancedHash_type_edi";

				/**
				 * [tAdvancedHash_type_edi finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBInput_3_SUBPROCESS_STATE", 1);
	}

	public static class row2Struct implements
			routines.system.IPersistableComparableLookupRow<row2Struct> {
		final static byte[] commonByteArrayLock_TEST_verif_statut_edi = new byte[0];
		static byte[] commonByteArray_TEST_verif_statut_edi = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public int PAR_ID;

		public int getPAR_ID() {
			return this.PAR_ID;
		}

		public int TED_ID;

		public int getTED_ID() {
			return this.TED_ID;
		}

		public String TAU_CODE;

		public String getTAU_CODE() {
			return this.TAU_CODE;
		}

		public Integer SJS_ID;

		public Integer getSJS_ID() {
			return this.SJS_ID;
		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + (int) this.PAR_ID;

				result = prime * result + (int) this.TED_ID;

				result = prime
						* result
						+ ((this.TAU_CODE == null) ? 0 : this.TAU_CODE
								.hashCode());

				this.hashCode = result;
				this.hashCodeDirty = false;
			}
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final row2Struct other = (row2Struct) obj;

			if (this.PAR_ID != other.PAR_ID)
				return false;

			if (this.TED_ID != other.TED_ID)
				return false;

			if (this.TAU_CODE == null) {
				if (other.TAU_CODE != null)
					return false;

			} else if (!this.TAU_CODE.equals(other.TAU_CODE))

				return false;

			return true;
		}

		public void copyDataTo(row2Struct other) {

			other.PAR_ID = this.PAR_ID;
			other.TED_ID = this.TED_ID;
			other.TAU_CODE = this.TAU_CODE;
			other.SJS_ID = this.SJS_ID;

		}

		public void copyKeysDataTo(row2Struct other) {

			other.PAR_ID = this.PAR_ID;
			other.TED_ID = this.TED_ID;
			other.TAU_CODE = this.TAU_CODE;

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_TEST_verif_statut_edi.length) {
					if (length < 1024
							&& commonByteArray_TEST_verif_statut_edi.length == 0) {
						commonByteArray_TEST_verif_statut_edi = new byte[1024];
					} else {
						commonByteArray_TEST_verif_statut_edi = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_TEST_verif_statut_edi, 0, length);
				strReturn = new String(commonByteArray_TEST_verif_statut_edi,
						0, length, utf8Charset);
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

		private Integer readInteger(DataInputStream dis, ObjectInputStream ois)
				throws IOException {
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

		private void writeInteger(Integer intNum, DataOutputStream dos,
				ObjectOutputStream oos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		public void readKeysData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_TEST_verif_statut_edi) {

				try {

					int length = 0;

					this.PAR_ID = dis.readInt();

					this.TED_ID = dis.readInt();

					this.TAU_CODE = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeKeysData(ObjectOutputStream dos) {
			try {

				// int

				dos.writeInt(this.PAR_ID);

				// int

				dos.writeInt(this.TED_ID);

				// String

				writeString(this.TAU_CODE, dos);

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

				this.SJS_ID = readInteger(dis, ois);

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		/**
		 * Return a byte array which represents Values data.
		 */
		public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
			try {

				writeInteger(this.SJS_ID, dos, oos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("PAR_ID=" + String.valueOf(PAR_ID));
			sb.append(",TED_ID=" + String.valueOf(TED_ID));
			sb.append(",TAU_CODE=" + TAU_CODE);
			sb.append(",SJS_ID=" + String.valueOf(SJS_ID));
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			sb.append(PAR_ID);

			sb.append("|");

			sb.append(TED_ID);

			sb.append("|");

			if (TAU_CODE == null) {
				sb.append("<null>");
			} else {
				sb.append(TAU_CODE);
			}

			sb.append("|");

			if (SJS_ID == null) {
				sb.append("<null>");
			} else {
				sb.append(SJS_ID);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row2Struct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.PAR_ID, other.PAR_ID);
			if (returnValue != 0) {
				return returnValue;
			}

			returnValue = checkNullsAndCompare(this.TED_ID, other.TED_ID);
			if (returnValue != 0) {
				return returnValue;
			}

			returnValue = checkNullsAndCompare(this.TAU_CODE, other.TAU_CODE);
			if (returnValue != 0) {
				return returnValue;
			}

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

	public void tDBInput_4Process(final java.util.Map<String, Object> globalMap)
			throws TalendException {
		globalMap.put("tDBInput_4_SUBPROCESS_STATE", 0);

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

				row2Struct row2 = new row2Struct();

				/**
				 * [tAdvancedHash_row2 begin ] start
				 */

				ok_Hash.put("tAdvancedHash_row2", false);
				start_Hash
						.put("tAdvancedHash_row2", System.currentTimeMillis());

				currentComponent = "tAdvancedHash_row2";

				if (execStat) {
					if (resourceMap.get("inIterateVComp") == null) {

						runStat.updateStatOnConnection("row2" + iterateId, 0, 0);

					}
				}

				int tos_count_tAdvancedHash_row2 = 0;

				// connection name:row2
				// source node:tDBInput_4 - inputs:(after_tFixedFlowInput_1)
				// outputs:(row2,row2) | target node:tAdvancedHash_row2 -
				// inputs:(row2) outputs:()
				// linked node: tMap_2 - inputs:(row3,row2) outputs:(ok,ko)

				org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row2 = org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.ALL_MATCHES;

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct> tHash_Lookup_row2 = org.talend.designer.components.lookup.memory.AdvancedMemoryLookup
						.<row2Struct> getLookup(matchingModeEnum_row2);

				globalMap.put("tHash_Lookup_row2", tHash_Lookup_row2);

				/**
				 * [tAdvancedHash_row2 begin ] stop
				 */

				/**
				 * [tDBInput_4 begin ] start
				 */

				ok_Hash.put("tDBInput_4", false);
				start_Hash.put("tDBInput_4", System.currentTimeMillis());

				currentComponent = "tDBInput_4";

				int tos_count_tDBInput_4 = 0;

				if (log.isDebugEnabled())
					log.debug("tDBInput_4 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tDBInput_4 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tDBInput_4 = new StringBuilder();
							log4jParamters_tDBInput_4.append("Parameters:");
							log4jParamters_tDBInput_4
									.append("USE_EXISTING_CONNECTION" + " = "
											+ "true");
							log4jParamters_tDBInput_4.append(" | ");
							log4jParamters_tDBInput_4.append("CONNECTION"
									+ " = " + "tDBConnection_2");
							log4jParamters_tDBInput_4.append(" | ");
							log4jParamters_tDBInput_4.append("TABLE" + " = "
									+ "\"AUTORISATIONEDI\"");
							log4jParamters_tDBInput_4.append(" | ");
							log4jParamters_tDBInput_4.append("QUERYSTORE"
									+ " = " + "\"\"");
							log4jParamters_tDBInput_4.append(" | ");
							log4jParamters_tDBInput_4.append("QUERY" + " = "
									+ "\"select * from autorisationedi;\"");
							log4jParamters_tDBInput_4.append(" | ");
							log4jParamters_tDBInput_4.append("TRIM_ALL_COLUMN"
									+ " = " + "false");
							log4jParamters_tDBInput_4.append(" | ");
							log4jParamters_tDBInput_4.append("TRIM_COLUMN"
									+ " = " + "[{TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("PAR_ID")
									+ "}, {TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("TED_ID")
									+ "}, {TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("TAU_CODE")
									+ "}, {TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("SJS_ID") + "}]");
							log4jParamters_tDBInput_4.append(" | ");
							log4jParamters_tDBInput_4
									.append("UNIFIED_COMPONENTS" + " = "
											+ "tMSSqlInput");
							log4jParamters_tDBInput_4.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tDBInput_4 - "
										+ (log4jParamters_tDBInput_4));
						}
					}
					new BytesLimit65535_tDBInput_4().limitLog4jByte();
				}

				org.talend.designer.components.util.mssql.MSSqlGenerateTimestampUtil mssqlGTU_tDBInput_4 = org.talend.designer.components.util.mssql.MSSqlUtilFactory
						.getMSSqlGenerateTimestampUtil();

				java.util.List<String> talendToDBList_tDBInput_4 = new java.util.ArrayList();
				String[] talendToDBArray_tDBInput_4 = new String[] { "FLOAT",
						"NUMERIC", "NUMERIC IDENTITY", "DECIMAL",
						"DECIMAL IDENTITY", "REAL" };
				java.util.Collections.addAll(talendToDBList_tDBInput_4,
						talendToDBArray_tDBInput_4);
				int nb_line_tDBInput_4 = 0;
				java.sql.Connection conn_tDBInput_4 = null;
				conn_tDBInput_4 = (java.sql.Connection) globalMap
						.get("conn_tDBConnection_2");
				if (conn_tDBInput_4 != null) {
					if (conn_tDBInput_4.getMetaData() != null) {

						log.debug("tDBInput_4 - Uses an existing connection with username '"
								+ conn_tDBInput_4.getMetaData().getUserName()
								+ "'. Connection URL: "
								+ conn_tDBInput_4.getMetaData().getURL() + ".");

					}
				}

				String dbschema_tDBInput_4 = (String) globalMap
						.get("dbschema_tDBConnection_2");

				java.sql.Statement stmt_tDBInput_4 = conn_tDBInput_4
						.createStatement();

				String dbquery_tDBInput_4 = "select * from autorisationedi;";

				log.debug("tDBInput_4 - Executing the query: '"
						+ dbquery_tDBInput_4 + "'.");

				globalMap.put("tDBInput_4_QUERY", dbquery_tDBInput_4);
				java.sql.ResultSet rs_tDBInput_4 = null;

				try {
					rs_tDBInput_4 = stmt_tDBInput_4
							.executeQuery(dbquery_tDBInput_4);
					java.sql.ResultSetMetaData rsmd_tDBInput_4 = rs_tDBInput_4
							.getMetaData();
					int colQtyInRs_tDBInput_4 = rsmd_tDBInput_4
							.getColumnCount();

					String tmpContent_tDBInput_4 = null;

					log.debug("tDBInput_4 - Retrieving records from the database.");

					while (rs_tDBInput_4.next()) {
						nb_line_tDBInput_4++;

						if (colQtyInRs_tDBInput_4 < 1) {
							row2.PAR_ID = 0;
						} else {

							if (rs_tDBInput_4.getObject(1) != null) {
								row2.PAR_ID = rs_tDBInput_4.getInt(1);
							} else {
								throw new RuntimeException(
										"Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_4 < 2) {
							row2.TED_ID = 0;
						} else {

							if (rs_tDBInput_4.getObject(2) != null) {
								row2.TED_ID = rs_tDBInput_4.getInt(2);
							} else {
								throw new RuntimeException(
										"Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_4 < 3) {
							row2.TAU_CODE = null;
						} else {

							tmpContent_tDBInput_4 = rs_tDBInput_4.getString(3);
							if (tmpContent_tDBInput_4 != null) {
								if (talendToDBList_tDBInput_4
										.contains(rsmd_tDBInput_4
												.getColumnTypeName(3)
												.toUpperCase(
														java.util.Locale.ENGLISH))) {
									row2.TAU_CODE = FormatterUtils
											.formatUnwithE(tmpContent_tDBInput_4);
								} else {
									row2.TAU_CODE = tmpContent_tDBInput_4;
								}
							} else {
								row2.TAU_CODE = null;
							}
						}
						if (colQtyInRs_tDBInput_4 < 4) {
							row2.SJS_ID = null;
						} else {

							if (rs_tDBInput_4.getObject(4) != null) {
								row2.SJS_ID = rs_tDBInput_4.getInt(4);
							} else {
								row2.SJS_ID = null;
							}
						}

						log.debug("tDBInput_4 - Retrieving the record "
								+ nb_line_tDBInput_4 + ".");

						/**
						 * [tDBInput_4 begin ] stop
						 */

						/**
						 * [tDBInput_4 main ] start
						 */

						currentComponent = "tDBInput_4";

						tos_count_tDBInput_4++;

						/**
						 * [tDBInput_4 main ] stop
						 */

						/**
						 * [tDBInput_4 process_data_begin ] start
						 */

						currentComponent = "tDBInput_4";

						/**
						 * [tDBInput_4 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row2 main ] start
						 */

						currentComponent = "tAdvancedHash_row2";

						// row2
						// row2

						if (execStat) {
							runStat.updateStatOnConnection("row2" + iterateId,
									1, 1);
						}

						if (log.isTraceEnabled()) {
							log.trace("row2 - "
									+ (row2 == null ? "" : row2.toLogString()));
						}

						row2Struct row2_HashRow = new row2Struct();

						row2_HashRow.PAR_ID = row2.PAR_ID;

						row2_HashRow.TED_ID = row2.TED_ID;

						row2_HashRow.TAU_CODE = row2.TAU_CODE;

						row2_HashRow.SJS_ID = row2.SJS_ID;

						tHash_Lookup_row2.put(row2_HashRow);

						tos_count_tAdvancedHash_row2++;

						/**
						 * [tAdvancedHash_row2 main ] stop
						 */

						/**
						 * [tAdvancedHash_row2 process_data_begin ] start
						 */

						currentComponent = "tAdvancedHash_row2";

						/**
						 * [tAdvancedHash_row2 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row2 process_data_end ] start
						 */

						currentComponent = "tAdvancedHash_row2";

						/**
						 * [tAdvancedHash_row2 process_data_end ] stop
						 */

						/**
						 * [tDBInput_4 process_data_end ] start
						 */

						currentComponent = "tDBInput_4";

						/**
						 * [tDBInput_4 process_data_end ] stop
						 */

						/**
						 * [tDBInput_4 end ] start
						 */

						currentComponent = "tDBInput_4";

					}
				} finally {
					if (rs_tDBInput_4 != null) {
						rs_tDBInput_4.close();
					}
					if (stmt_tDBInput_4 != null) {
						stmt_tDBInput_4.close();
					}
				}
				globalMap.put("tDBInput_4_NB_LINE", nb_line_tDBInput_4);
				log.debug("tDBInput_4 - Retrieved records count: "
						+ nb_line_tDBInput_4 + " .");

				if (log.isDebugEnabled())
					log.debug("tDBInput_4 - " + ("Done."));

				ok_Hash.put("tDBInput_4", true);
				end_Hash.put("tDBInput_4", System.currentTimeMillis());

				/**
				 * [tDBInput_4 end ] stop
				 */

				/**
				 * [tAdvancedHash_row2 end ] start
				 */

				currentComponent = "tAdvancedHash_row2";

				tHash_Lookup_row2.endPut();

				if (execStat) {
					if (resourceMap.get("inIterateVComp") == null
							|| !((Boolean) resourceMap.get("inIterateVComp"))) {
						runStat.updateStatOnConnection("row2" + iterateId, 2, 0);
					}
				}

				ok_Hash.put("tAdvancedHash_row2", true);
				end_Hash.put("tAdvancedHash_row2", System.currentTimeMillis());

				/**
				 * [tAdvancedHash_row2 end ] stop
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
				 * [tDBInput_4 finally ] start
				 */

				currentComponent = "tDBInput_4";

				/**
				 * [tDBInput_4 finally ] stop
				 */

				/**
				 * [tAdvancedHash_row2 finally ] start
				 */

				currentComponent = "tAdvancedHash_row2";

				/**
				 * [tAdvancedHash_row2 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBInput_4_SUBPROCESS_STATE", 1);
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
				tDBConnection_2Process(globalMap);

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

	public void tDBConnection_2Process(
			final java.util.Map<String, Object> globalMap)
			throws TalendException {
		globalMap.put("tDBConnection_2_SUBPROCESS_STATE", 0);

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
				 * [tDBConnection_2 begin ] start
				 */

				ok_Hash.put("tDBConnection_2", false);
				start_Hash.put("tDBConnection_2", System.currentTimeMillis());

				currentComponent = "tDBConnection_2";

				int tos_count_tDBConnection_2 = 0;

				if (log.isDebugEnabled())
					log.debug("tDBConnection_2 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tDBConnection_2 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tDBConnection_2 = new StringBuilder();
							log4jParamters_tDBConnection_2
									.append("Parameters:");
							log4jParamters_tDBConnection_2.append("DRIVER"
									+ " = " + "JTDS");
							log4jParamters_tDBConnection_2.append(" | ");
							log4jParamters_tDBConnection_2.append("HOST"
									+ " = " + "context.ssql_cfdp_Server");
							log4jParamters_tDBConnection_2.append(" | ");
							log4jParamters_tDBConnection_2.append("PORT"
									+ " = " + "context.ssql_cfdp_Port");
							log4jParamters_tDBConnection_2.append(" | ");
							log4jParamters_tDBConnection_2.append("SCHEMA_DB"
									+ " = " + "context.ssql_cfdp_Schema");
							log4jParamters_tDBConnection_2.append(" | ");
							log4jParamters_tDBConnection_2.append("DBNAME"
									+ " = " + "context.ssql_cfdp_Database");
							log4jParamters_tDBConnection_2.append(" | ");
							log4jParamters_tDBConnection_2.append("USER"
									+ " = " + "context.ssql_cfdp_Login");
							log4jParamters_tDBConnection_2.append(" | ");
							log4jParamters_tDBConnection_2
									.append("PASS"
											+ " = "
											+ String.valueOf(
													routines.system.PasswordEncryptUtil
															.encryptPassword(context.ssql_cfdp_Password))
													.substring(0, 4) + "...");
							log4jParamters_tDBConnection_2.append(" | ");
							log4jParamters_tDBConnection_2.append("PROPERTIES"
									+ " = "
									+ "context.ssql_cfdp_AdditionalParams");
							log4jParamters_tDBConnection_2.append(" | ");
							log4jParamters_tDBConnection_2
									.append("USE_SHARED_CONNECTION" + " = "
											+ "false");
							log4jParamters_tDBConnection_2.append(" | ");
							log4jParamters_tDBConnection_2
									.append("SPECIFY_DATASOURCE_ALIAS" + " = "
											+ "false");
							log4jParamters_tDBConnection_2.append(" | ");
							log4jParamters_tDBConnection_2.append("AUTO_COMMIT"
									+ " = " + "false");
							log4jParamters_tDBConnection_2.append(" | ");
							log4jParamters_tDBConnection_2
									.append("SHARE_IDENTITY_SETTING" + " = "
											+ "false");
							log4jParamters_tDBConnection_2.append(" | ");
							log4jParamters_tDBConnection_2
									.append("UNIFIED_COMPONENTS" + " = "
											+ "tMSSqlConnection");
							log4jParamters_tDBConnection_2.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tDBConnection_2 - "
										+ (log4jParamters_tDBConnection_2));
						}
					}
					new BytesLimit65535_tDBConnection_2().limitLog4jByte();
				}

				String url_tDBConnection_2 = "jdbc:jtds:sqlserver://"
						+ context.ssql_cfdp_Server;
				String port_tDBConnection_2 = context.ssql_cfdp_Port;
				String dbname_tDBConnection_2 = context.ssql_cfdp_Database;
				if (!"".equals(port_tDBConnection_2)) {
					url_tDBConnection_2 += ":" + context.ssql_cfdp_Port;
				}
				if (!"".equals(dbname_tDBConnection_2)) {

					url_tDBConnection_2 += "//" + context.ssql_cfdp_Database;
				}
				url_tDBConnection_2 += ";appName=" + projectName + ";"
						+ context.ssql_cfdp_AdditionalParams;
				String dbUser_tDBConnection_2 = context.ssql_cfdp_Login;

				final String decryptedPassword_tDBConnection_2 = context.ssql_cfdp_Password;
				String dbPwd_tDBConnection_2 = decryptedPassword_tDBConnection_2;

				java.sql.Connection conn_tDBConnection_2 = null;

				String driverClass_tDBConnection_2 = "net.sourceforge.jtds.jdbc.Driver";
				java.lang.Class.forName(driverClass_tDBConnection_2);

				log.debug("tDBConnection_2 - Driver ClassName: "
						+ driverClass_tDBConnection_2 + ".");

				log.debug("tDBConnection_2 - Connection attempt to '"
						+ url_tDBConnection_2 + "' with the username '"
						+ dbUser_tDBConnection_2 + "'.");

				conn_tDBConnection_2 = java.sql.DriverManager.getConnection(
						url_tDBConnection_2, dbUser_tDBConnection_2,
						dbPwd_tDBConnection_2);
				log.debug("tDBConnection_2 - Connection to '"
						+ url_tDBConnection_2 + "' has succeeded.");

				globalMap.put("conn_tDBConnection_2", conn_tDBConnection_2);
				if (null != conn_tDBConnection_2) {

					log.debug("tDBConnection_2 - Connection is set auto commit to 'false'.");
					conn_tDBConnection_2.setAutoCommit(false);
				}

				globalMap.put("dbschema_tDBConnection_2",
						context.ssql_cfdp_Schema);

				globalMap.put("db_tDBConnection_2", context.ssql_cfdp_Database);

				globalMap.put("conn_tDBConnection_2", conn_tDBConnection_2);

				globalMap.put("shareIdentitySetting_tDBConnection_2", false);

				/**
				 * [tDBConnection_2 begin ] stop
				 */

				/**
				 * [tDBConnection_2 main ] start
				 */

				currentComponent = "tDBConnection_2";

				tos_count_tDBConnection_2++;

				/**
				 * [tDBConnection_2 main ] stop
				 */

				/**
				 * [tDBConnection_2 process_data_begin ] start
				 */

				currentComponent = "tDBConnection_2";

				/**
				 * [tDBConnection_2 process_data_begin ] stop
				 */

				/**
				 * [tDBConnection_2 process_data_end ] start
				 */

				currentComponent = "tDBConnection_2";

				/**
				 * [tDBConnection_2 process_data_end ] stop
				 */

				/**
				 * [tDBConnection_2 end ] start
				 */

				currentComponent = "tDBConnection_2";

				if (log.isDebugEnabled())
					log.debug("tDBConnection_2 - " + ("Done."));

				ok_Hash.put("tDBConnection_2", true);
				end_Hash.put("tDBConnection_2", System.currentTimeMillis());

				/**
				 * [tDBConnection_2 end ] stop
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
				 * [tDBConnection_2 finally ] start
				 */

				currentComponent = "tDBConnection_2";

				/**
				 * [tDBConnection_2 finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBConnection_2_SUBPROCESS_STATE", 1);
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
		final verif_statut_edi verif_statut_ediClass = new verif_statut_edi();

		int exitCode = verif_statut_ediClass.runJobInTOS(args);
		if (exitCode == 0) {
			log.info("TalendJob: 'verif_statut_edi' - Done.");
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
		log.info("TalendJob: 'verif_statut_edi' - Start.");

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
			java.io.InputStream inContext = verif_statut_edi.class
					.getClassLoader().getResourceAsStream(
							"test/verif_statut_edi_0_1/contexts/" + contextStr
									+ ".properties");
			if (inContext == null) {
				inContext = verif_statut_edi.class
						.getClassLoader()
						.getResourceAsStream(
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
			context.setContextType("ssql_cfdp_Server", "id_String");

			context.ssql_cfdp_Server = (String) context
					.getProperty("ssql_cfdp_Server");
			context.setContextType("ssql_cfdp_Database", "id_String");

			context.ssql_cfdp_Database = (String) context
					.getProperty("ssql_cfdp_Database");
			context.setContextType("ssql_cfdp_AdditionalParams", "id_String");

			context.ssql_cfdp_AdditionalParams = (String) context
					.getProperty("ssql_cfdp_AdditionalParams");
			context.setContextType("ssql_cfdp_Port", "id_String");

			context.ssql_cfdp_Port = (String) context
					.getProperty("ssql_cfdp_Port");
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
			context.setContextType("ssql_cfdp_Schema", "id_String");

			context.ssql_cfdp_Schema = (String) context
					.getProperty("ssql_cfdp_Schema");
			context.setContextType("ssql_cfdp_Login", "id_String");

			context.ssql_cfdp_Login = (String) context
					.getProperty("ssql_cfdp_Login");
		} catch (java.io.IOException ie) {
			System.err.println("Could not load context " + contextStr);
			ie.printStackTrace();
		}

		// get context value from parent directly
		if (parentContextMap != null && !parentContextMap.isEmpty()) {
			if (parentContextMap.containsKey("ssql_cfdp_Server")) {
				context.ssql_cfdp_Server = (String) parentContextMap
						.get("ssql_cfdp_Server");
			}
			if (parentContextMap.containsKey("ssql_cfdp_Database")) {
				context.ssql_cfdp_Database = (String) parentContextMap
						.get("ssql_cfdp_Database");
			}
			if (parentContextMap.containsKey("ssql_cfdp_AdditionalParams")) {
				context.ssql_cfdp_AdditionalParams = (String) parentContextMap
						.get("ssql_cfdp_AdditionalParams");
			}
			if (parentContextMap.containsKey("ssql_cfdp_Port")) {
				context.ssql_cfdp_Port = (String) parentContextMap
						.get("ssql_cfdp_Port");
			}
			if (parentContextMap.containsKey("ssql_cfdp_Password")) {
				context.ssql_cfdp_Password = (java.lang.String) parentContextMap
						.get("ssql_cfdp_Password");
			}
			if (parentContextMap.containsKey("ssql_cfdp_Schema")) {
				context.ssql_cfdp_Schema = (String) parentContextMap
						.get("ssql_cfdp_Schema");
			}
			if (parentContextMap.containsKey("ssql_cfdp_Login")) {
				context.ssql_cfdp_Login = (String) parentContextMap
						.get("ssql_cfdp_Login");
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
					+ " bytes memory increase when running : verif_statut_edi");
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
			obj_conn = globalMap.remove("conn_tDBConnection_2");
			if (null != obj_conn) {
				((java.sql.Connection) obj_conn).close();
			}
		} catch (java.lang.Exception e) {
		}
	}

	private java.util.Map<String, Object> getSharedConnections4REST() {
		java.util.Map<String, Object> connections = new java.util.HashMap<String, Object>();
		connections.put("conn_tDBConnection_2",
				globalMap.get("conn_tDBConnection_2"));

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
 * 219416 characters generated by Talend Cloud Data Management Platform on the
 * September 11, 2019 3:33:51 PM CEST
 ************************************************************************************************/
