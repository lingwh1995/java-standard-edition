package org.bluebridge.ioc.anno_one.entity;

/**
 * @ClassName: Teacher
 * @author ronin
 * @date 2019年3月15日
 * 
 */
public class Teacher {
	private Student student;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	/**
	 * <p>Title: toString</p>  
	 * <p>Description: </p>  
	 * @return  
	 * @see Object#toString()
	 */  
	
	@Override
	public String toString() {
		return "Teacher [student=" + student + "]";
	}
	
}
