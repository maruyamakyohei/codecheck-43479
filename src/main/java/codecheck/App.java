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

		// 対象の10進数をint型に変換
		int targetInt = Integer.parseInt(target);

		// アルファベット数字の桁数を初期化
		int count = 1;

		// アルファベット数字の桁数を算出
		for (int t = 9; targetInt >= t;) {

			// 桁数追加
			count++;

			// tを9倍して再度比較
			t = t * 9;
		}

		// アルファベット数字格納用の配列を初期化
		String[] resultArray = new String[count];

		// アルファベット数字を1桁ずつ配列に格納
		for (int i = count - 1 ; i >= 0; i--) {

			int a = 1;

			for (int j = i; 0 < j; j--) {
				// aを9倍
				a = a * 9;
			}
			// 10進数の値を算出
			int b = targetInt / a;

			// 10進数の値をアルファベット数字に変換
			resultArray[i] = changeString(b);

			// 余りをtargetIntに代入して次の桁を算出
			targetInt = targetInt % a;
		}

		// 配列に格納したアルファベット数字を文字列に変換
		for (int i = count; i > 0; i--) {
			// 1桁ずつ結合
			result = result + resultArray[i-1];
		}

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

	private static String changeString(int i) {

		if (i == 0) {
			return "A";
		} else if (i == 1) {
			return "B";
		} else if (i == 2) {
			return "C";
		} else if (i == 3) {
			return "D";
		} else if (i == 4) {
			return "E";
		} else if (i == 5) {
			return "F";
		} else if (i == 6) {
			return "G";
		} else if (i == 7) {
			return "H";
		} else if (i == 8) {
			return "I";
		} else {
			return "Z";
		}
	}
}
