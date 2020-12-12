// use this to model trivias, store my data here.
public class Question {
	
public String trivia;
private String answer;
private String a;
private String b;
private String c;
private String d;
//make private string a, b, c, and d for the choices instead of just "choice"
// get set functions, built this all by myself lol
//@author Jbush
public String getQuestion() {
	return trivia;
}
public void setQuestion(String trivia) {
	this.trivia = trivia;
}
public String getAnswer() {
	return answer;
}
public void setAnswer(String answer) {
	this.answer = answer;
}
public void setA(String a) {
	this.answer = a;
}
public String getA() {// redo for a,b,c,d
	return a;
	
}
public void setB (String b) {// redo for a,b,c,d
	this.b = b;
	
}
public String getB() {// redo for a,b,c,d
	return b;
	
}

public void setC(String c) {
	this.c = c;
}
public String getC() {
	return c;
}

public String getD() {// redo for a,b,c,d
	return d;
	
}
public void setD(String d) {// redo for a,b,c,d
	this.d = d;
	
}

// refers to the current object or constructor. Let's not confuse the class. 
public Question (String trivia, String answer, String a, String b, String c, String d) {
	this.trivia = trivia;
	this.answer = answer;
	this.a = a;// redo for a,b,c,d
	this.b = b;
	this.c = c;
	this.d = d;
}
public Question(Question trivia2, String answer2, Question trivia3) {
	// TODO Auto-generated constructor stub
	setQuestion(trivia);
	setAnswer(answer);
	setA(a);
	setB(b);
	setC(c);
	setD(d);// redo for a,b,c,d
}
@Override 
public String toString() {// redo for a,b,c,d
	return String.format("%s\n%s\n%s\n%s\n%s\n%s", trivia, answer, a,b,c,d);
}
public void add(Question trivia2) {
	// TODO Auto-generated method stub
	
}
}
// create a variable here and add... assign json file to the model