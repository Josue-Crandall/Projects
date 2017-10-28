package jc.writeIntoPic;

public class MessageCompating {
	public static void main(String...args){
		String key="01110100011001010111001101110100011010010110111001100111001000000111001101110100011101010110011001100110001000000010000101000000001000110010000100100110010111100010010000100000011111010111110101111011";
		
		
	}
	public static String encrypt(String utf_8String,String binaryStringKey){
		return binaryStringtoHexString(pad(utf_8StringToBinaryString(utf_8String),binaryStringKey));
	}
	public static String decrypt(String encryptedHexString,String binaryStringKey){
		return binaryStringToUtf_8String(pad(hexStringToBinaryString(encryptedHexString),binaryStringKey));
	}
	public static String utf_8StringToBinaryString(String utf_8String){
		StringBuilder result=new StringBuilder();
		for(int i=0,len=utf_8String.length();i<len;i++)
			result.append(intToBinaryString(utf_8String.charAt(i)));
		return result.toString();
	}
	public static String binaryStringToUtf_8String(String binaryString){
		StringBuilder result=new StringBuilder();
		for(int i=0,len=binaryString.length();i<len;i+=8)
			result.append((char)binaryStringtoInt(binaryString.substring(i,i+8)));
		return result.toString();
	}
	private static String intToBinaryString(int input){
		StringBuilder result=new StringBuilder();
		while(input>0){
			result.insert(0,input%2);
			input/=2;
		}
		while(result.length()<8)result.insert(0,'0');
		if(result.length()>8)result.setLength(8);
		return result.toString();
	}
	private static String intToBinaryString(int input,int chunkSize){
		StringBuilder result=new StringBuilder();
		while(input>0){
			result.insert(0,input%2);
			input/=2;
		}
		while(result.length()<chunkSize)result.insert(0,'0');
		if(result.length()>chunkSize)result.setLength(chunkSize);
		return result.toString();
	}
	private static String binaryStringtoHexString(String binaryString){
		StringBuilder result=new StringBuilder();
		for(int i=0,len=binaryString.length();i<len;i+=4)
			result.append(intTohexString(binaryStringtoInt(binaryString.substring(i,i+4))));
		return result.toString();
	}
	private static String hexStringToBinaryString(String hexString){
		StringBuilder result=new StringBuilder();
		for(int i=0,len=hexString.length();i<len;i++){
			char hold=hexString.charAt(i);
			switch(hold){
				case 'A':
					result.append(intToBinaryString(10,4));
					break;
				case 'B':
					result.append(intToBinaryString(11,4));
					break;
				case 'C':
					result.append(intToBinaryString(12,4));
					break;
				case 'D':
					result.append(intToBinaryString(13,4));
					break;
				case 'E':
					result.append(intToBinaryString(14,4));
					break;
				case 'F':
					result.append(intToBinaryString(15,4));
					break;
				case '0':
					result.append(intToBinaryString(0,4));
					break;
				case '1':
					result.append(intToBinaryString(1,4));
					break;
				case '2':
					result.append(intToBinaryString(2,4));
					break;
				case '3':
					result.append(intToBinaryString(3,4));
					break;
				case '4':
					result.append(intToBinaryString(4,4));
					break;
				case '5':
					result.append(intToBinaryString(5,4));
					break;
				case '6':
					result.append(intToBinaryString(6,4));
					break;
				case '7':
					result.append(intToBinaryString(7,4));
					break;
				case '8':
					result.append(intToBinaryString(8,4));
					break;
				case '9':
					result.append(intToBinaryString(9,4));
					break;
			}
		}
		return result.toString();
	}
	
	private static String intTohexString(int n){
		StringBuilder result=new StringBuilder();
		while(n>0){
			int hold=n%16;
			n/=16;
			if(hold<10)result.insert(0,hold);
			else switch(hold){
				case 10:
					result.append("A");
					break;
				case 11:
					result.append("B");
					break;
				case 12:
					result.append("C");
					break;
				case 13:
					result.append("D");
					break;
				case 14:
					result.append("E");
					break;
				case 15:
					result.append("F");
					break;
			}
		}
		return result.toString();
	}
	
	private static int binaryStringtoInt(String binaryString){
		int result=0;
		for(int i=0,len=binaryString.length();0<len;len--,i++){
			result+=Integer.valueOf(binaryString.substring(len-1,len))*Math.pow(2,i);
		}
		return result;
	}
	
	private static String pad(String ptBinary,String keyBinary){
		StringBuilder result=new StringBuilder();
		for(int i=0,len=ptBinary.length();i<len;i++){
			if(keyBinary.charAt(i)==ptBinary.charAt(i))result.append('0');
			else result.append('1');
		}
		return result.toString();
	}
}
