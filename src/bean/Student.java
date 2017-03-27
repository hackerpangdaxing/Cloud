package bean;

public class Student {
	private int id;
	private String school;
	private String profession;
	private String studentID;
	private String classID;
	private String name;
	private String sex;
	private String phoneNumber;
	private String QQ;

	public Student(String school,String profession,String studentID,String classID,String name,String sex,String phoneNumber,String QQ) {
		// TODO Auto-generated constructor stub
		this.school= school;
		this.profession = profession;
		this.studentID = studentID;
		this.classID = classID;
		this.name = name;
		this.sex = sex;
		this.phoneNumber = phoneNumber;
		this.QQ = QQ ;
	}

	@Override
	public String toString() {
		return "Student [school=" + school + ", profession=" + profession
				+ ", studentID=" + studentID + ", classID=" + classID
				+ ", name=" + name + ", sex=" + sex + ", phoneNumber="
				+ phoneNumber + ", QQ=" + QQ + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getClassID() {
		return classID;
	}

	public void setClassID(String classID) {
		this.classID = classID;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getQQ() {
		return QQ;
	}

	public void setQQ(String qQ) {
		QQ = qQ;
	}

}
