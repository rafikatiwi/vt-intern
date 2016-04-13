/** Author: Rafikatiwi Nur Pujiarti
** Veritrans Intern Selection Day 13 April 2016
**/
import java.io.*;
import java.util.*;

public class Game {
	public static void main(String[] args) throws FileNotFoundException {
		int coba = 0;
		int score = 0;
		boolean exit = false;
		Scanner jawaban = new Scanner(new File("Jawab.txt"));
		ArrayList<String> ans = new ArrayList<String>();
		String input;
		String jawab;
		//memasukan daftar kata dari file ke ArrayList
		while (jawaban.hasNextLine() && !jawaban.equals(null)) {
			input = jawaban.nextLine();
			ans.add(input);
		}
		//permainan ini hanya bisa diattempt sebanyak tiga kali, jika pemain salah menebak >= 3 kali maka langsung keluar dari program
		while (coba < 3 && exit == false) {
		Scanner in = new Scanner(System.in);
		Random rand_soal = new Random();
		String kata_soal = ans.get(rand_soal.nextInt(ans.size()));
		Random rand_kata = new Random();
		String kata_acak = acak(rand_kata, kata_soal);
		System.out.println("Tebak kata: " + kata_acak );
		jawab = in.nextLine();
		//flag exit menjadi true ketika user ingin keluar dari permainan dengan mengetik 
		//"exit" atau "keluar"
		if (jawab.equals("exit") || jawab.equals("keluar")) {
			exit = true;
		}
		else if (ans.contains(jawab)) {
				System.out.println("BENAR!");
				score++;
				System.out.println("Nilai anda saat ini: " + score);
			}
			else {
				System.out.println("SALAH! Silakan coba lagi");
				score--;
				System.out.println("Nilai anda saat ini: " + score);
				coba++;
			}
		}
	//ketika sudah keluar dari permainan, program akan menampilkan score akhir pemain
	if(coba >= 3 && exit == false) {
	System.out.println("Anda gugur");
	System.out.println("Nilai akhir anda: " + score);
	}
	else if (exit == true) {
	System.out.println("Anda sudah keluar");
	System.out.println("Nilai akhir anda: " + score);
	}		

	}

	//fungsi untuk mengacak kata yang terpilih untuk dijadikan soal
	public static String acak(Random r, String input) {
		//setiap huruf dalam kata dimasukan ke array bertipe char
		char huruf[] = input.toCharArray();
		//shuffling huruf
		for (int i = 0; i < huruf.length-1; i++) {
			int j = r.nextInt(huruf.length-1);
			char tukar = huruf[i];
			huruf[i] = huruf[j];
			huruf[j] = tukar;
		}

		return new String(huruf);
	}
}