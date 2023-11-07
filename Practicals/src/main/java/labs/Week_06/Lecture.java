package main.java.labs.Week_06;

import java.util.ArrayList;
import java.util.List;

public class Lecture {

    /**
     * - seats: Seat[] - students: List<Student>
     */

	private Seat[] seats;
	private List<Student> students;

    public Lecture(int capacity) {
		super();
		/*
		 * when the seats array is declared, the capacity is used to set its size. Each
		 * Seat object gets created with the value null for the student name
		 */
		this.seats = new Seat[capacity];
		for (int i = 0; i < this.seats.length; i++) {
			this.seats[i] = new Seat(new Student(null));
		}
		this.students = new ArrayList<Student>();
    }

    /**
     * +getCapacity(): int
     * 
     * @return number of seats in lecture theatre
     */

	public int getCapacity() {
		return this.seats.length;
	}

    /**
     * +howManyOccupied(): int
     * 
     * @return how many seats used by a student
     */
    public int howManyOccupied() {
		int sum = 0;
        for (Seat seat : this.seats) {
            if (seat.getName() != null) {
                sum++;
            }
        }
		return sum;
    }

    /**
     * +studentEnter(in index: int, in name: String)
     * allocate a seat to the student using the index parameter as the index in the
     * seats array
     */
    public void studentEnter(int index, String name) {
		this.students.add(new Student(name));
		this.seats[index] = new Seat(new Student(name));
    }

    public void displayAllSeats() {
		for (int i = 0; i < this.seats.length; i++) {
			if (this.seats[i].getName() != null) {
				System.out.println("S" + i + ":" + this.seats[i]);
			}
		}
    }

    /**
     * +displayAllStudents()
     * 
     * display all students on the console (names)
     */
    public void displayAllStudents() {
        for (Student student : this.students) {
            System.out.println(student.toString());
        }
    }

    public static void main(String[] args) {
		Lecture l = new Lecture(2);
		l.studentEnter(0, "Alice");
		l.studentEnter(1, "Bob");

		l.displayAllSeats();
		l.displayAllStudents();
		System.out.println(l.getCapacity());
		System.out.println(l.howManyOccupied());

		Lecture l2 = new Lecture(5);
		l2.studentEnter(0, "Alice");
		l2.studentEnter(1, "Bob");

		l2.displayAllSeats();
		l2.displayAllStudents();
		System.out.println(l2.getCapacity());
		System.out.println(l2.howManyOccupied());
    }
}
