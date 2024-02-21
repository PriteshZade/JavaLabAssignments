public class SY2022bit035 {
    // double arr1[5] ;
    // Static double arr2[5] ;
    // Static double arr3[5] ;
    public static void main(String[] args) {
        //String RegistrationNumbers[] = {"2022BIT055", "2026BIT036"};
        // String RegistrationNumbers[] = new String[10000];
         SY2022bit035 obj = new SY2022bit035();
        

        // String RegistrationNumbers[] = new String[10000];
        // obj.generateRandomRegNo(RegistrationNumbers);
        // long startTIme1 = System.nanoTime();
        // int isValid = obj.getValidRegistrationsCountLE50Appr3(RegistrationNumbers);
        // long endTime1 = System.nanoTime();
        // long duration1 = endTime1 - startTIme1;
        //System.out.println("Time taken to run first approach : "+ duration1);
        
        // CALLING FUNCTION CALCULATING TIME FOR EACH FUNCTION FOR ARRAY OF SIZE 10000
        double arr1[] = obj.calculate(1000);
        double arr2[] = obj.calculate(10000);
        double arr3[] = obj.calculate(100000);
        obj.Print(arr1,arr2,arr3);
    }
    public double[] calculate(int size)
    {
        double ar[] = new double[5] ;
        String RegistrationNumbers[] = new String[size];
        SY2022bit035 obj = new SY2022bit035();
        obj.generateRandomRegNo(RegistrationNumbers);
        for(int i = 0 ; i < 5 ; i++)
        {
            long startTIme1 = System.nanoTime();
            if(i==0){
                getValidRegistrationsCount(RegistrationNumbers);
            }
            if(i==1){
                getValidRegistrationsCountLE50Appr1(RegistrationNumbers);
            }
            if(i==2){
                getValidRegistrationsCountLE50Appr2(RegistrationNumbers);
            }
            if(i==3){
                getValidRegistrationsCountLE50Appr3(RegistrationNumbers);            
                
            }
            if(i==4){
                getValidRegistrationsCountLE50Appr4(RegistrationNumbers);        
            }
            //int isValid = obj.getValidRegistrationsCountLE50Appr3(RegistrationNumbers);
            long endTime1 = System.nanoTime();
            long duration1 = endTime1 - startTIme1;
            ar[i] = duration1;
        }
        return ar;
    }
    public  void Print(double ar1[] , double ar2[] , double ar3[])
    {
        System.out.println("SIZE            Appr1               Appr2               Appr3                Appr4                Appr5");
        System.out.println("1000          "+ar1[0]+"          "+ar1[1]+"           "+ar1[2]+"           "+ar1[3]+"           "+ar1[4]);
        System.out.println("10000         "+ar2[0]+"          "+ar2[1]+"           "+ar2[2]+"           "+ar2[3]+"           "+ar2[4]);
        System.out.println("100000        "+ar3[0]+"          "+ar3[1]+"           "+ar3[2]+"           "+ar3[3]+"           "+ar3[4]);
    }
    public  void generateRandomRegNo(String[] RegistrationNumbers) {
    for (int i = 0; i < RegistrationNumbers.length; i++) {
        String regNo = generateRegNo();
        RegistrationNumbers[i] = regNo;
        //System.out.println(RegistrationNumbers[i]);
    }
}

public  String generateRegNo() {
    //long time = System.nanoTime();
    String regNo = generateYear() + generateDept() + generateSeq();
    return regNo;
}
    
    public  String generateYear(){
        long time = System.nanoTime();
        String year = String.format("%04d", (time % 9999) + 1);
        return year;
    }
    
    public  String generateDept(){
        long time ;
        String dept = "";
        for(int i = 0; i < 3; i++){
            time= System.nanoTime();
            dept = dept + String.valueOf((char)((time % 26)+'A'));
            //time += 17;
        }
        return dept;
    }
    
    public  String generateSeq(){
        long time = System.nanoTime();
        String seq = String.format("%03d", (time % 999) + 1);
        return seq;
    }

    public int getValidRegistrationsCount(String[] registrations) {
        int x = registrations.length;
        int count = 0;
	if(registrations == null)
	{
		return 0;
	}
        for (int i = 0; i < x; i++) {
		if(registrations[i] == null)
		{
			continue ;
		}
            String current = registrations[i];
            if (current.length() == 10) {
                String year = current.substring(0, 4);
                int year2 = Integer.parseInt(year);
                
                if(year2>=2000 && year2<=2024){
                    String Branch = current.substring(4, 7);
                    String b1 = "BIT";
                    String b2 = "BCS";
                    String b3 = "BME";
                    String b4 = "BCH";
                    if (Branch.equals(b1) || Branch.equals(b2) || Branch.equals(b3) || Branch.equals(b4)) {
                        
                        String SerialNumber = current.substring(7, 10);
                        if (Character.isDigit(SerialNumber.charAt(0)) && Character.isDigit(SerialNumber.charAt(1)) && Character.isDigit(SerialNumber.charAt(2))) {
                            int sn = Integer.parseInt(SerialNumber);
                            if(sn<=50)
                            {
                            count++;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
    public int getValidRegistrationsCountLE50Appr1(String[] registrations) {
        int x = registrations.length;
        int count = 0;
	if(registrations == null)
	{
		return 0;
	}
        for (int i = 0; i < x; i++) {
		if(registrations[i] == null)
		{
			continue ;
		}
            String current = registrations[i];
            if (current.length() == 10) {
                String year = current.substring(0, 4);
                int a = Character.getNumericValue(year.charAt(0));
                int b = Character.getNumericValue(year.charAt(1));
                int c = Character.getNumericValue(year.charAt(2));
                int d = Character.getNumericValue(year.charAt(3));
                int year2 = (a*1000) + (b*100) + (c*10) + d;
                //System.out.println(year2);
                
                if(year2>=2000 && year2<=2024){
                    String Branch = current.substring(4, 7);
                    String b1 = "BIT";
                    String b2 = "BCS";
                    String b3 = "BME";
                    String b4 = "BCH";
                    if (Branch.equals(b1) || Branch.equals(b2) || Branch.equals(b3) || Branch.equals(b4)) {
                        
                        String SerialNumber = current.substring(7, 10);
                        if (Character.isDigit(SerialNumber.charAt(0)) && Character.isDigit(SerialNumber.charAt(1)) && Character.isDigit(SerialNumber.charAt(2))) {
                            int e = Character.getNumericValue(SerialNumber.charAt(0));
                            int f = Character.getNumericValue(SerialNumber.charAt(1));
                            int g = Character.getNumericValue(SerialNumber.charAt(2));
                            int sn = (e*100) + (f*10) + g;
                            if(sn<=50)
                            {
                            count++;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
    public int getValidRegistrationsCountLE50Appr2(String[] registrations) {
        int x = registrations.length;
        int count = 0;
	if(registrations == null)
	{
		return 0;
	}
        for (int i = 0; i < x; i++) {
		if(registrations[i] == null)
		{
			continue ;
		}
            String current = registrations[i];
            if (current.length() == 10) {
                String year = current.substring(0, 4);
                int a = Character.digit(year.charAt(0),10);
                int b = Character.digit(year.charAt(1),10);
                int c = Character.digit(year.charAt(2),10);
                int d = Character.digit(year.charAt(3),10);
                int year2 =  (a*1000) + (b*100) + (c*10) + d;
                //System.out.println(year2);
                
                if(year2>=2000 && year2<=2024){
                    String Branch = current.substring(4, 7);
                    String b1 = "BIT";
                    String b2 = "BCS";
                    String b3 = "BME";
                    String b4 = "BCH";
                    if (Branch.equals(b1) || Branch.equals(b2) || Branch.equals(b3) || Branch.equals(b4)) {
                        
                        String SerialNumber = current.substring(7, 10);
                        if (Character.isDigit(SerialNumber.charAt(0)) && Character.isDigit(SerialNumber.charAt(1)) && Character.isDigit(SerialNumber.charAt(2))) {
                            //String year = current.substring(0, 4);
                            int e = Character.digit(SerialNumber.charAt(0),10);
                            int f = Character.digit(SerialNumber.charAt(1),10);
                            int g = Character.digit(SerialNumber.charAt(2),10);
                            int sn =  (e*100) + (f*10) + g;
                            if(sn<=50)
                            {
                              count++;  
                            }
                            
                        }
                    }
                }
            }
        }
        return count;
    }
    public int getValidRegistrationsCountLE50Appr3(String[] registrations) {
        int x = registrations.length;
        int count = 0;
	if(registrations == null)
	{
		return 0;
	}
        for (int i = 0; i < x; i++) {
		if(registrations[i] == null)
		{
			continue ;
		}
            String current = registrations[i];
            if (current.length() == 10) {
                String year = current.substring(0, 4);
                int a = year.charAt(0)-48;
                int b = year.charAt(1)-48;
                int c = year.charAt(2)-48;
                int d = year.charAt(3)-48;
                int year2 =  (a*1000) + (b*100) + (c*10) + d;
                //System.out.println(year2);
                
                if(year2>=2000 && year2<=2024){
                    String Branch = current.substring(4, 7);
                    String b1 = "BIT";
                    String b2 = "BCS";
                    String b3 = "BME";
                    String b4 = "BCH";
                    if (Branch.equals(b1) || Branch.equals(b2) || Branch.equals(b3) || Branch.equals(b4)) {
                        
                        String SerialNumber = current.substring(7, 10);
                        if (Character.isDigit(SerialNumber.charAt(0)) && Character.isDigit(SerialNumber.charAt(1)) && Character.isDigit(SerialNumber.charAt(2))) {
                            //String year = current.substring(0, 4);
                            int e = SerialNumber.charAt(0)-48;
                            int f = SerialNumber.charAt(1)-48;
                            int g = SerialNumber.charAt(2)-48;
                            int sn =  (e*100) + (f*10) + g;
                            if(sn<=50)
                            {
                            count++;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
    public int getValidRegistrationsCountLE50Appr4(String[] registrations) {
        int x = registrations.length;
        int count = 0;
	if(registrations == null)
	{
		return 0;
	}
        for (int i = 0; i < x; i++) {
		if(registrations[i] == null)
		{
			continue ;
		}
            String current = registrations[i];
            if (current.length() == 10) {
                String year = current.substring(0, 4);
                int year2 = Integer.parseInt(year);
                
                if(year2>=2000 && year2<=2024){
                    String Branch = current.substring(4, 7);
                    String b1 = "BIT";
                    String b2 = "BCS";
                    String b3 = "BME";
                    String b4 = "BCH";
                    if (Branch.equals(b1) || Branch.equals(b2) || Branch.equals(b3) || Branch.equals(b4)) {
                        
                        String SerialNumber = current.substring(7, 10);
                        if (Character.isDigit(SerialNumber.charAt(0)) && Character.isDigit(SerialNumber.charAt(1)) && Character.isDigit(SerialNumber.charAt(2))) {
                            if(SerialNumber.charAt(0)=='0' && (SerialNumber.charAt(1)=='5'||SerialNumber.charAt(1)=='4'||SerialNumber.charAt(1)=='3'||SerialNumber.charAt(1)=='2'|| SerialNumber.charAt(1)=='1' || SerialNumber.charAt(1)=='0'))
                            {
                                count++;
                                if(SerialNumber.charAt(1)=='5'&& SerialNumber.charAt(2)!='0')
                                {
                                    count--;
                                }
                                
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}