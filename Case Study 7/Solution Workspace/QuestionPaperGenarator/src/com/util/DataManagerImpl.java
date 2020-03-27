package com.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.bean.Category;
import com.bean.Complexity;
import com.bean.Criteria;
import com.bean.Question;
import com.bean.SortByCategory;
import com.bean.SortByComplexity;

// Override and implement all the methods of DataManager Interface here
public class DataManagerImpl implements DataManager {

	String sql;
	PreparedStatement pstmt;
	Statement stmt;
	Connection connection;
	DatabaseConnectionManager databaseConnectionManager;
	ResultSet resultSet;
	Question question;
	Category category;
	List<Question> questions;
	
	public DataManagerImpl() {
	     databaseConnectionManager = new DatabaseConnectionManager();
	     try {
			connection = databaseConnectionManager.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}	
	}
	
	@Override
	public List<Question> populateData() {
		questions = new ArrayList<Question>();
		sql = "Select * from questionBank";
		try {
			stmt = connection.createStatement();
			resultSet = stmt.executeQuery(sql);	
			
			while(resultSet.next())
			{
				question = new Question();
				question.setSrno(resultSet.getInt(1));
				question.setQuestion(resultSet.getString(2));
				question.setOption1(resultSet.getString(3));
				question.setOption2(resultSet.getString(4));
				question.setOption3(resultSet.getString(5));
				question.setOption4(resultSet.getString(6));
				question.setCorrectAns(resultSet.getString(7));
				question.setType(Category.valueOf(resultSet.getString(8)));
				question.setComplexity(Complexity.valueOf(resultSet.getString(9)));
			
				questions.add(question);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return questions;
	}

	@Override
	public List<Question> getQuestionByCategory(Category category, List<Question> questionsList) {
		questions = new ArrayList<Question>();
		if(questionsList==null || questionsList.isEmpty())
			return questions;
		for(Question question : questionsList)
		{
			if(question.getCategory().equals(category))
			{
				questions.add(question);
			}
		}
		return questions;
	}

	@Override
	public List<Question> getQuestionByComplexity(Complexity complexity, List<Question> questionsList) {
		questions = new ArrayList<Question>();
		if(questionsList==null || questionsList.isEmpty())
			return questions;
		for(Question question : questionsList)
		{
			if(question.getComplexity().equals(complexity))
			{
				questions.add(question);
			}
		}
		return questions;
	}

	@Override
	public Set<Question> generateQuestionPaper(List<Question> list, List<Criteria> template) {
		question = new Question();
		questions = new ArrayList<Question>();
		Set<Question> sQuestions = new HashSet<Question>();
		if(list==null || list.isEmpty())
			return sQuestions;
		double randomDouble = Math.random();
		int randomInt;
		for(Criteria criteria : template)
		{
			questions = getQuestionByCategory(criteria.getCategory(),list);
			questions = getQuestionByComplexity(criteria.getComplexity(), questions);
			randomDouble = randomDouble*questions.size()+1;
			for(int i = 0; i<criteria.getNoOfQuestion(); i++)
			{
				randomInt = (int) randomDouble;
				sQuestions.add(questions.get(randomInt));				
			}
		}
		return sQuestions;
	}

	@Override
	public void sortByCategory(List<Question> questionList) {
		Collections.sort(questionList,new SortByCategory());	
	}

	@Override
	public void sortByComplexity(List<Question> questionList) {
		Collections.sort(questionList, new SortByComplexity());
	}


}