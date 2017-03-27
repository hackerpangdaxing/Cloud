package check;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatches {
	
	public static void main(String args[]) {
		String str = "13047907769";
		String pattern = "0?(13|14|15|18)[0-9]{9}";

		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(str);
		System.out.println(m.matches());
	}

}