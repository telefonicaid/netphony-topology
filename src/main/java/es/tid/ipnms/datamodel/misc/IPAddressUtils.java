package es.tid.ipnms.datamodel.misc;

public class IPAddressUtils {

	/**Parses input subnet and returns the longest prefix format*/
	public static String parseSubnet(String input){
		input=input.trim();
		String temp = "";
		if (input.length()<3){
			int temp2 = Integer.parseInt(input);
			if ((temp2<=32) && (temp2 >=0))
				temp=Integer.toString(temp2);
		}
		else {
			//input subnet is of type 255.255.255.0
			//Get binary String represenation of the individual blocks in the subnet and concatenate to get single represenation
			String finalString = "";
			String[] temp1 = input.split("\\.");
			for (int i=0;i<temp1.length;i++){
				finalString+= getBinaryString (Integer.parseInt(temp1[i]));
			}
			//Count consequtive ones in the string represenation
			int i;
			for (i=0;i<finalString.length();i++){
				if (finalString.charAt(i) == '0')
					break;
			}
			temp = Integer.toString(i);
		}
		return temp;
	}
	
	private static String getBinaryString(int x){
		if ((x>255) || (x<0))
		{
			System.out.println("Error");
		}
		String binaryString = "";
		for (int i=0;i<8;i++){
			int y= x%2;
			x=x/2;
			binaryString = y + binaryString;
		}
		
		return binaryString;
		
	}
	
	public static void main (String[] args){
		System.out.println(parseSubnetDotFormat("16"));
	}

	public static String parseSubnetDotFormat(String input) {
		input=input.trim();
		String temp = "";
		if (input.length()<3){
			int temp2 = Integer.parseInt(input);
			if ((temp2<=32) && (temp2 >=0)){
				for (int i=0;i<4;i++){
					if (temp2>=8){
						temp+="255.";
						temp2=temp2-8;
					}
					else if (temp2==0){
						temp+="0.";
					}
					else {
						int temp3 = 0;
						for (int j=0;j<temp2;j++){
							temp3 += Math.pow(2, 7-j);
						}
						temp+=Integer.toString(temp3) + ".";
						temp2=0;
					}
				}
				temp=temp.substring(0, temp.length()-1);
			}
		}
		else {
			temp = input;
		}
		return temp;

	}
}
