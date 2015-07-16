import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PeacesOfLine {
	/*
	 * ƒано N отрезков провода длиной L1, L2, ..., LN сантиметров. “ребуетс€ с
	 * помощью разрезани€ получить из них K равных отрезков как можно большей
	 * длины, выражающейс€ целым числом сантиметров. ≈сли нельз€ получить K
	 * отрезков длиной даже 1 см, вывести 0.
	 * 
	 * ќграничени€: 1 <= N <= 10 000, 1 <= K <= 10 000, 100 <= Li <= 10 000 000,
	 * все числа целые
	 */

	public static void main(String[] args) throws IOException, NumberFormatException {
		String[] input = read();
		int[] arr;
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		// int[] arr;
		arr = new int[n];
		// fill massive random
		for (int i = 0; i < n; i++) {
			arr[i] = (int) (100 + (Math.random() * (100)));
		}
		int minimalSize = arr[1];
		// search minimal

		for (int i = 0; i < n; i++) {
			if ((arr[i] < minimalSize) & (arr[i] > 1)) {
				minimalSize = arr[i];
			}
		}
		// maximal quantity of maximal peaces
		int max = 0;
		while (minimalSize >= 1) {
			max = 0;
			for (int i = 0; i < n; i++) {
				int tmp;
				tmp = arr[i] / minimalSize;
				if (tmp > 1) {
					max += tmp;
				}
			}
			if (max >= k) {
				break;
			}
			minimalSize--;
			
		}

		// show massive
		for (int i : arr) {
			System.out.println(i + " ");
		}
		System.out.println("minimal wire " + minimalSize);
		System.out.println("max of max " + max);

		// write(Double.parseDouble(input[0]) + Double.parseDouble(input[1]));
	}

	private static String[] read() throws IOException {
		BufferedReader reader = null;
		String line;

		try {
			reader = new BufferedReader(new FileReader("input.txt"));
			line = reader.readLine();
		} finally {
			if (reader != null) {
				reader.close();
			}
		}

		return line.split(" ");
	}

	private static void write(Object obj) throws IOException {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter("output.txt"));
			writer.write(String.valueOf(obj));
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
	}
}
