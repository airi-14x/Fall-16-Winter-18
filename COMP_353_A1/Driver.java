
/*
 * [ COMP-353 A1 ]
 * Date: 2018/01/28 @ 20h47
 * Name: Airi Chow (#40003396)
 * 
 */
import java.io.*;
import java.util.ArrayList;

public class Driver {

	public static void main(String[] args) {

		// Store Data in ArrayList to reference when picking out the data //
		ArrayList<Students> Students = new ArrayList<Students>();
		ArrayList<Course> Courses = new ArrayList<Course>();
		ArrayList<Registered> Registered = new ArrayList<Registered>();

		// OPEN the files stored and Read the Data //
		int sid;
		String student_name;
		String program;
		String address;

		FileReader inputStream = null;
		try {
			inputStream = new FileReader("Student_info.txt");
		} catch (FileNotFoundException e) {
			System.out.println("Well, we have a problem. File is not in the directory... Or something?");
		}

		BufferedReader reader = new BufferedReader(inputStream);
		String file_input_string = null;

		// *** ------- Create Students Objects ---------- //
		// Stop when reaching end-of-line //
		try {
			while ((file_input_string = reader.readLine()) != null) {
				String[] parseLine = file_input_string.split(" ");
				String sid_string = parseLine[0].trim();
				student_name = parseLine[1].trim();
				program = parseLine[2].trim();
				address = parseLine[3].trim();
				sid = Integer.parseInt(sid_string);

				Students s1 = new Students(sid, student_name, program, address);

				Students.add(s1);
				for (int i = 0; i < Students.size(); i++) {
					System.out.println("Sid: " + Students.get(i).getSID());
					System.out.println("Name: " + Students.get(i).getSName());
					System.out.println("Program: " + Students.get(i).getProgram());
					System.out.println("Address: " + Students.get(i).getAddress());
					System.out.println("");
				}
				System.out.println("-----------------------------");
			}
		} catch (IOException e1) {
			System.out.println("Problem with the reader");
		}

		// *** ------ Create Course Objects ------- *** //
		try {
			inputStream = new FileReader("Course.txt");
			reader = new BufferedReader(inputStream);
		} catch (FileNotFoundException e) {
			System.out.println("Well, we have a problem. File is not in the directory... Or something?");
		}

		try {
			while ((file_input_string = reader.readLine()) != null) {
				String[] parseLine = file_input_string.split(" ");
				String cid_string = parseLine[0].trim();
				String c_name = parseLine[1].trim();
				String c_credits_string = parseLine[2].trim();

				int cid = Integer.parseInt(cid_string);
				double c_credits = Double.parseDouble(c_credits_string);

				Course c1 = new Course(cid, c_name, c_credits);
				Courses.add(c1);

				for (int i = 0; i < Courses.size(); i++) {
					System.out.println("CID: " + Courses.get(i).getCID());
					System.out.println("Course Name: " + Courses.get(i).getCName());
					System.out.println("Credits: " + Courses.get(i).getNoOfCredits());
					System.out.println("");
				}
				System.out.println("-----------------------------");

			}

		} catch (IOException e1) {
			System.out.println("Problem with the reader II");
		}

		// *** ------ Create Registered Objects ------ ***//
		try {
			inputStream = new FileReader("Registered.txt");
			reader = new BufferedReader(inputStream);
		} catch (FileNotFoundException e) {
			System.out.println("Well, we have a problem. File is not in the directory... Or something?");
		}

		try {
			while ((file_input_string = reader.readLine()) != null) {
				String[] parseLine = file_input_string.split(" ");
				String sid_string = parseLine[0].trim();
				String cid_string = parseLine[1].trim();
				String grade_string = parseLine[2].trim();

				sid = Integer.parseInt(sid_string);
				int cid = Integer.parseInt(cid_string);
				int grade = Integer.parseInt(grade_string);

				Registered r1 = new Registered(sid, cid, grade);
				Registered.add(r1);

				for (int i = 0; i < Registered.size(); i++) {
					System.out.println("SID: " + Registered.get(i).getSID());
					System.out.println("CID: " + Registered.get(i).getCID());
					System.out.println("Grades: " + Registered.get(i).getGrade());
					System.out.println("");
				}
				System.out.println("-----------------------------");

			}

		} catch (IOException e1) {
			System.out.println("Problem with the reader II");
		}

		// ***** ---- Create Output file ------ ***** //
		FileOutputStream fs = null;
		PrintWriter output = null;
		try {
			fs = new FileOutputStream("out.txt");
			output = new PrintWriter(fs);

			// Iterate through the Registered's Array List to find IDs who are
			// in Databases //
			for (int i = 0; i < Registered.size(); i++) {
				if (Registered.get(i).getCID() == 353) {
					output.print(Registered.get(i).getSID());

					// Get the Student's name that matches the SID in the
					// Registered //
					// Check if the Student name has been selected already so we
					// don't get duplicates //
					for (int j = 0; j < Students.size(); j++) {
						if (Registered.get(i).getSID() == Students.get(j).getSID()
								&& Students.get(j).getSelected() == false) {
							output.print(" " + Students.get(j).getSName() + " ");
							Students.get(j).setSelected();
						}
					}
					output.print(Registered.get(i).getGrade());
					output.println("");
				}

			}

		} catch (FileNotFoundException e) {
			System.out.println("Cannot create Output Files");
		}

		// Close File after reading //
		try {
			inputStream.close();
			reader.close();
			output.close();
		} catch (IOException e) {
			System.out.println("Problem closing the file or reader!");
		}

	}

}
