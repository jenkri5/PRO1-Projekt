package enumdemo;

public class TestSeason {

	public static void main(String[] args) {
		Season s1 = Season.Autumn;
		System.out.println(s1);
		System.out.println();

		for (Season season : Season.values()) {
			if (season == Season.Spring || season == Season.Summer)
				System.out.println(season + ": Nice time of year");
			else
				System.out.println(season + ": Not so nice time of year");
		}
		System.out.println();

		Season s2 = Season.valueOf("Winter");
		System.out.println("s2: " + s2);
		String str = Season.Spring.toString();
		System.out.println("str: " + str);
		System.out.println();
	}
}
