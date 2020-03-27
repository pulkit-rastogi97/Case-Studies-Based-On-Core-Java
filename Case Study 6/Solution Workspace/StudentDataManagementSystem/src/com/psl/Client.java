package com.psl;

import java.util.List;

import com.psl.beans.Student;
import com.psl.exceptions.InsufficientDataException;
import com.psl.util.StudentDataManager;


	
	public class Client {
        
        public static void main(String[] args) {
                        
                        //Create instance of StudentDataManager Class here and  test your functionality from here
        StudentDataManager service= new StudentDataManager();
        List<Student> list = service.populateData("StudentDetails.txt");
        System.out.println(list);
        System.out.println();
        System.out.println();
        try {        
                        service.validateData(list);
        } catch (InsufficientDataException e) {
                        System.out.println(e.getMessage());
        }
        service.sortData(list);
        System.out.println(list);
        }
}


