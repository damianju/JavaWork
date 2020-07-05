package com.lec.sts19_rest.board.beans;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="emloyees") // <emloyees>~<emloyees>
public class EmployeeListVO {
	
	// List 멤버 --> <emp>~<emp> 들로 만들어진다
	@XmlElement
	private List<EmployeeVO> emp = new ArrayList<EmployeeVO>();

	public List<EmployeeVO> getEmployees() {
		return emp;
	}
	
	
}
