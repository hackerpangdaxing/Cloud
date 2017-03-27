package bean;

import java.io.File;
import java.sql.Blob;


/**
 *Problem.java
 *bean
 * @author 胖大星
 *@date 2016年11月6日上午9:21:37
 */
public class Problem {
	private int id;
	private String problem;
	private String problem1;
	private String choose_1;
	private String choose_2;
	private String choose_3;
	private String choose_4;	
	private Blob pic;
	private int sore;
	private String answer;
	
	public Problem(int id, String problem, int sore, Blob pic,String chooseA,
			String chooseB, String chooseB2, String chooseC, String chooseD,String answer) {
		   this.id = id;
		   this.problem = problem;
		   this.sore = sore;
		   this.pic = pic;
		   this.choose_1 = chooseA;
		   this.choose_2 = chooseB;
		   this.choose_3 = chooseC;
		   this.choose_4 = chooseD;
		   this.answer = answer;
	}
	public Problem(String string) {
		// TODO Auto-generated constructor stub
		this.problem1 = string;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProblem() {
		return problem;
	}
	public void setProblem(String problem) {
		this.problem = problem;
	}
	public String getProblem1() {
		return problem1;
	}
	public void setProblem1(String problem1) {
		this.problem1 = problem1;
	}
	public String getChoose_1() {
		return choose_1;
	}
	public void setChoose_1(String choose_1) {
		this.choose_1 = choose_1;
	}
	public String getChoose_2() {
		return choose_2;
	}
	public void setChoose_2(String choose_2) {
		this.choose_2 = choose_2;
	}
	public String getChoose_3() {
		return choose_3;
	}
	public void setChoose_3(String choose_3) {
		this.choose_3 = choose_3;
	}
	public String getChoose_4() {
		return choose_4;
	}
	public void setChoose_4(String choose_4) {
		this.choose_4 = choose_4;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Blob getPic() {
		return pic;
	}
	public void setPic(Blob pic) {
		this.pic = pic;
	}
	public int getSore() {
		return sore;
	}
	public void setSore(int sore) {
		this.sore = sore;
	}


	



}
