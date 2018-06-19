package codecheck;

public class App {
	public static void main(String[] args) {

		// コマンド
		String com = args[0];

		// 結果初期化
		String output = "";

		if (com.equals("decode")) {
			// アルファベット数字を10進数に変換
			output = decode(args[1]);
		} else if (com.equals("encode")) {
			// 10進数をアルファベット数字に変換
			output = encode(args[1]);
		} else {
			// 全てHとなる数式を算出
			output = align(args[0]);
		}
		// 結果を出力
		System.out.println(output);
	}

	private static String decode(String target) {

		// 変換結果初期化
		String result = "";

		// 1桁ずつ配列に格納
		String[] strArray = new String[target.length()];
		for (int i = 0; i < target.length(); i++) {
			strArray[i] = String.valueOf(target.charAt(target.length() - 1 - i));
		}

		// 算出結果初期化
		int resultNum = 0;

		// 1桁ずつ10進数に変換
		for (int i = 0; i < strArray.length; i++) {

			int base = 1;

			for (int j = 0; j < i; j++) {
				base = base * 9;
			}

			int t = changeInt(strArray[i]);
			resultNum += base * t;
		}

		// int型からString型に変換
		result = String.valueOf(resultNum);

		return result;
	}

	private static String encode(String target) {

		// 変換結果初期化
		String result = "";

		return result;
	}

	private static String align(String target) {

		// 変換結果初期化
		String result = "";

		return result;
	}

	private static int changeInt(String s) {

		if (s.equals("A")) {
			return 0;
		} else if (s.equals("B")) {
			return 1;
		} else if (s.equals("C")) {
			return 2;
		} else if (s.equals("D")) {
			return 3;
		} else if (s.equals("E")) {
			return 4;
		} else if (s.equals("F")) {
			return 5;
		} else if (s.equals("G")) {
			return 6;
		} else if (s.equals("H")) {
			return 7;
		} else if (s.equals("I")) {
			return 8;
		} else {
			return -1;
		}
	}

	private static int changeString(String s) {

		if (s.equals("A")) {
			return 0;
		} else if (s.equals("B")) {
			return 1;
		} else if (s.equals("C")) {
			return 2;
		} else if (s.equals("D")) {
			return 3;
		} else if (s.equals("E")) {
			return 4;
		} else if (s.equals("F")) {
			return 5;
		} else if (s.equals("G")) {
			return 6;
		} else if (s.equals("H")) {
			return 7;
		} else if (s.equals("I")) {
			return 8;
		} else {
			return -1;
		}
	}
}
