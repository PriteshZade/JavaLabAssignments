class SY2022bit035 {
    public static void main(String[] args) {
        String RegistrationNumbers[] = {"2022BIT048", "2026BIT036"};
        SY2022bit035 obj = new SY2022bit035();
        int x = obj.getValidRegistrationsCount(RegistrationNumbers);
        System.out.println(x);
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
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}
