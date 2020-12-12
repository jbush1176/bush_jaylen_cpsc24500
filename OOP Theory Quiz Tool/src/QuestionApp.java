import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;
public class QuestionApp {
	public static ArrayList<Question> trivias = new ArrayList<Question>();

	
		public static int showMenuAndGetChoise(Scanner sc)  {
			  System.out.println("	What could possibly be more fun than this?");
		         System.out.println("*********************************************");
		         System.out.println("*   	 OOP Theory and Concept Questions    *");
		         System.out.println("*********************************************");
		         System.out.println("  Nothing. Nothing at all. Nope. Nada. Nunca.");
		         System.out.println("Enter a File Name: ");
		         Scanner scf = new Scanner(System.in);
		         String fname = scf.nextLine();
			       questionReader qr = new questionReader();

		         trivias = qr.readFromJSON1(fname);
		   ArrayList<Question> questions = new ArrayList<Question>();
		         try {
		        	
				Scanner fsc = new Scanner(new File(fname));
			} catch (FileNotFoundException e) {
					
					e.printStackTrace();
				}
		         
		         // enter scanner info to read the file
		         // file name of what user enters, put in in trivia reader QR
		         // scanner... call the 
		         //scan it using my trivia reader, use exact json file name
		         // so do qr.readFromJSON1(what you used for what the user enters)
		         System.out.println("Here are your choices.");
			        System.out.println("1. Take a quiz");
			        System.out.println("2. See trivias and answers");
			        System.out.println("3. Exit");
			        int result = sc.nextInt();
			        sc.nextLine();
			        return result;
		}
		public static void printQuestion(ArrayList<Question> questions) {
			for (Question question: questions) {
				System.out.println(question);
			}
			}
			public static void main(String[] args) {
				ArrayList<Question> questions = new ArrayList<Question>();
				Scanner sc = new Scanner(System.in);
				String trivia, answer, a, b, c, d;
				int option;
				int toRemove;
			
				String path;
				String userAnswer;
				Question question;
				Random random = new Random();
				questionReader qr = new questionReader();
				objectWriter<Question> writer = new objectWriter<Question>();
				
				do {//something is needed 
					option = showMenuAndGetChoise(sc);
					if (option == 1) {  // change below to match homework
						System.out.print("How many trivias would you like?: ");
						int numQuestion = sc.nextInt();
						questions = qr.readFromJSON1("Questions.json");
						int countCorrect = 0;
						//we can get the first question
						for (int i = 0; i < numQuestion; i++){	// we need to get random questions here and 
							// answer them, then we have to write it to the json file
							// we are trying to get. then we have to loop this for the number
							// of times the user says to imput: the number of trivias the user would like. 
							// need a random generator in quesions.get
							// then, json writer will take care of the rest.
							question = questions.get(random.nextInt(18));
							System.out.println(question.getQuestion());
						
							System.out.println(question.getA());
							
							System.out.println(question.getB());
					
							System.out.println(question.getC());
						
							System.out.println(question.getD());

							System.out.print("type your letter here:");
							userAnswer = sc.next();
							if (userAnswer == question.getAnswer()) {
								
								System.out.println("That is the correct answer");
								countCorrect =+1;
								
							} 
							else {
								System.out.println("Sorry, that is incorrect");

					}
						}
						System.out.print("Your score is "+ countCorrect + "out of" +numQuestion);
					}else if (option == 2)  { 
					
						for (int i = 0; i < 18; i++) {
						question = trivias.get(i);
						System.out.println(" " +question.getAnswer() + " " + question.getQuestion());
						}
					} 
				} while (option != 3);
				System.out.println("Thank you.");
			}

}
