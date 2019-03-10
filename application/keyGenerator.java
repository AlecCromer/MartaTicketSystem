package application;
import java.util.Random;

//this key generator uses 0-9 (10) as well as a-z (26) to generate a very strong key
public class keyGenerator {
	Random rand = new Random();
	String StringKey = "";

	public String StringKey() {
		// Generates random integer between 0 and 35 (36 options)
		int randomInt = 0;
		for (int i = 0; i < 10; i++) {
			randomInt = rand.nextInt(36) + 0;

			switch (String.valueOf(randomInt)) {
			case "0":
				StringKey += "0";
				break;
			case "1":
				StringKey += "1";
				break;
			case "2":
				StringKey += "2";
				break;
			case "3":
				StringKey += "3";
				break;
			case "4":
				StringKey += "4";
				break;
			case "5":
				StringKey += "5";
				break;
			case "6":
				StringKey += "6";
				break;
			case "7":
				StringKey += "7";
				break;
			case "8":
				StringKey += "8";
				break;
			case "9":
				StringKey += "9";
				break;
			case "10":
				StringKey += "a";
				break;
			case "11":
				StringKey += "b";
				break;
			case "12":
				StringKey += "c";
				break;
			case "13":
				StringKey += "d";
				break;
			case "14":
				StringKey += "e";
				break;
			case "15":
				StringKey += "f";
				break;
			case "16":
				StringKey += "g";
				break;
			case "17":
				StringKey += "h";
				break;
			case "18":
				StringKey += "i";
				break;
			case "19":
				StringKey += "j";
				break;
			case "20":
				StringKey += "k";
				break;
			case "21":
				StringKey += "l";
				break;
			case "22":
				StringKey += "m";
				break;
			case "23":
				StringKey += "n";
				break;
			case "24":
				StringKey += "o";
				break;
			case "25":
				StringKey += "p";
				break;
			case "26":
				StringKey += "q";
				break;
			case "27":
				StringKey += "r";
				break;
			case "28":
				StringKey += "s";
				break;
			case "29":
				StringKey += "t";
				break;
			case "30":
				StringKey += "u";
				break;
			case "31":
				StringKey += "v";
				break;
			case "32":
				StringKey += "w";
				break;
			case "33":
				StringKey += "x";
				break;
			case "34":
				StringKey += "y";
				break;
			case "35":
				StringKey += "z";
				break;
			default:
				System.out.println("0");
				break;

			}
		}
		return StringKey;
	}
}
