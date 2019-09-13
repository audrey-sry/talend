package routines;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.Date;

/*
 * user specification: the function's comment should contain keys as follows: 1. write about the function's comment.but
 * it must be before the "{talendTypes}" key.
 * 
 * 2. {talendTypes} 's value must be talend Type, it is required . its value should be one of: String, char | Character,
 * long | Long, int | Integer, boolean | Boolean, byte | Byte, Date, double | Double, float | Float, Object, short |
 * Short
 * 
 * 3. {Category} define a category for the Function. it is required. its value is user-defined .
 * 
 * 4. {param} 's format is: {param} <type>[(<default value or closed list values>)] <name>[ : <comment>]
 * 
 * <type> 's value should be one of: string, int, list, double, object, boolean, long, char, date. <name>'s value is the
 * Function's parameter name. the {param} is optional. so if you the Function without the parameters. the {param} don't
 * added. you can have many parameters for the Function.
 * 
 * 5. {example} gives a example for the Function. it is optional.
 */
public class fich_EDI {
	
	private String codeTypeEDI = "";
	private String codeIA = "";
	private String date = "";
	private String heure = "";
	private String type = "";
	
	public fich_EDI(){
		
	}
	
	public fich_EDI(String nomFich) {
		String[] output = nomFich.split("\\.");
			this.codeTypeEDI = output[0];
			this.codeIA = output[1];
			this.date = output[2];
			this.heure = output[3];
			this.type = output[4];
	}
	
    public String getCodeTypeEDI() {
		return codeTypeEDI;
	}


	public void setCodeTypeEDI(String codeTypeEDI) {
		this.codeTypeEDI = codeTypeEDI;
	}


	public String getCodeIA() {
		return codeIA;
	}


	public void setCodeIA(String codeIA) {
		this.codeIA = codeIA;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getHeure() {
		return heure;
	}


	public void setHeure(String heure) {
		this.heure = heure;
	}


	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * Decoupe le chemin du fichier
	 * @param dir: chemin du fichier
	 * @return type du fichier
	 */
	public static String parseDir(String dir) {
    	String[] out = dir.split("\\/");
    	
    	return out[out.length-1];
    }
    
    /**
     * Verifie le format de la date
     * @return
     */
    public boolean verifDate(){
    	boolean res = false;
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date d = new Date();
        try {
            d = sdf.parse(this.date);
            String t = sdf.format(d);
            if(t.compareTo(this.date) ==  0)
            	res = true;
        } catch (Exception e) {
                System.out.println("Exception Date");
        }
        return res;
    }
    
    /**
     * Verifie le format de l'heure
     * @return boolean
     */
    public boolean verifHeure() {
    	boolean res = false;
    	DateTimeFormatter strictTimeFormatter = DateTimeFormatter.ofPattern("HHmm").withResolverStyle(ResolverStyle.STRICT);
    	try {
    		LocalTime.parse(this.heure, strictTimeFormatter);
    		res = true;
    	} catch (Exception e) {
    		System.out.println("Exception Heure");
    	}
    	return res;
    }
     /**
      * Verifie la nomenclature du fichier
      * @param nomFich: nom du fichier
      * @param tempEDI: code EDI valide
      * @param tempIA: code IA valide
      * @return boolean
      */
    public boolean comp(String nomFich, String tempEDI, String tempIA) {

        //System.out.println("edi " + tempEDI +" et code " + codeTypeEDI);
        //System.out.println("ia " + tempIA +" et code " + codeIA);
        
        return this.codeTypeEDI.equals(tempEDI) && this.codeIA.equals(tempIA) && verifDate() && verifHeure();
    }
    
    /**
     * helloExample: not return value, only print "hello" + message.
     * 
     * 
     * {talendTypes} String
     * 
     * {Category} User Defined
     * 
     * {param} string("world") input: The string need to be printed.
     * 
     * {example} helloExemple("world") # hello world !.
     */
    public static void helloExample(String message) {
        if (message == null) {
            message = "World"; //$NON-NLS-1$
        }
        System.out.println("Hello " + message + " !"); //$NON-NLS-1$ //$NON-NLS-2$
    }
}
