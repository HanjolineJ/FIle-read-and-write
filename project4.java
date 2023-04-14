package project4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class project4 {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(new File("student.txt"));
		PrintWriter pw = new PrintWriter(new FileWriter("students_grades.txt"));

		int lines = 0;

		while (input.hasNextLine()) {
			String line = input.nextLine();
			System.out.println(line);

			String[] values = line.split("\\s+");
			String id = "";
			String mid = "";
			String fin = "";

			if(values.length==5) {
				id = values[0];
				mid = values[3];
				fin = values[4];
			}else if (values.length >= 6) {
				id = values[0];
				mid = values[4];
				fin = values[5];
			} else if (values.length == 4) {
				id = values[0];
				mid = values[2];
				fin = values[3];
			}
			
				if (mid.equals("-")) {
					mid = "0";
				}
				if (fin.equals("-")) {
					fin = "0";
				}
				if (mid.isEmpty()) {
					mid = "0";
				}
				if (fin.isEmpty()) {
					fin = "0";
				}
			

				double mids = Double.parseDouble(mid) * 0.40;
				double fins = Double.parseDouble(fin) * 0.60;
				double grade = mids + fins;
				String grades = String.format("%.1f", grade);
				
				String gradeLetter = "";
				if (grade >= 96.67) {
					gradeLetter = "A+";
				} else if (grade >= 93.34) {
					gradeLetter = "A";
				}else if (grade >= 90) {
					gradeLetter = "A-";
				} else if (grade >= 86.67) {
					gradeLetter = "B+";
				} else if (grade >= 83.34) {
					gradeLetter = "B";
				} else if (grade >= 80) {
					gradeLetter = "B-";
				} else if (grade >= 76.67) {
					gradeLetter = "C+";
				} else if (grade >= 73.34) {
					gradeLetter = "C";
				} else if (grade >= 70) {
					gradeLetter = "C-";
				} else if (grade >= 66.67) {
					gradeLetter = "D+";
				} else if (grade >= 63.34) {
					gradeLetter = "D";
				} else if (grade >= 60) {
					gradeLetter = "D-";
				}else if (grade <= 59.99) {
					gradeLetter = "F";
				}
				
				line = id + " " + grades + " " + gradeLetter;
				if (lines > 0) {

					pw.println(line);
				}

				lines++;
			}
			pw.close();
			input.close();
		}
	}
	