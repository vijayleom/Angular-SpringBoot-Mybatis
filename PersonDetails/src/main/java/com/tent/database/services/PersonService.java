package com.tent.database.services;

import java.util.logging.Logger;

import org.apache.ibatis.session.SqlSession;
import com.tent.database.modal.Person;
import com.tent.database.factory.MyBatisUtil;
import com.tent.database.mapper.PersonMapper;

public class PersonService
{
	Logger log = Logger.getLogger(this.getClass().getName());
	
	/**
	 * @param person
	 */
	public int insertUser(Person person) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		int personId = -1;
		try{
			PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
			personMapper.insertPerson(person);
			log.info("Person Result main: "+ person);
			sqlSession.commit();
			if(person != null) {
				personId = person.getPersonId();
			}
		}finally{
			sqlSession.close();
		}
		return personId;
	}
	
	/**
	 * @param person
	 */
	public int insertPhone(Person person) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		int personPhoneId = -1;
		try{
			PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
			personMapper.insertPersonPhone(person);
			log.info("Person Result for Phone: "+ person);
			sqlSession.commit();
			if(person != null) {
				personPhoneId = person.getPhoneId();
			}
		}finally{
			sqlSession.close();
		}
		return personPhoneId;
	}
	
	/**
	 * @param person
	 */
	public int insertAddress(Person person) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		int personAddressId = -1;
		try{
			PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
			personMapper.insertPersonAddress(person);
			log.info("Person Result for Address: "+ person);
			sqlSession.commit();
			if(person != null) {
				personAddressId = person.getPersonId();
			}
		}finally{
			sqlSession.close();
		}
		return personAddressId;
	}
	
	/**
	 * @param person
	 */
	public boolean deletePerson(int personId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		boolean isDeleted = Boolean.FALSE;
		try{
			PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
			int value = personMapper.deletePerson(personId);
			log.info("Deletion Operation Status:"+value);
			sqlSession.commit();
			if(value > 0) {
				log.info("Person "+personId+" deleted successfully. status:"+value);
				isDeleted = Boolean.TRUE;
			}
		}finally{
			sqlSession.close();
		}
		return isDeleted;
	}
	
	/**
	 * @param person
	 */
	public Person getPerson(int personId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		Person person = null;
		try{
			PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
			person = personMapper.getUserById(personId);
			log.info("Details of the person:"+person);
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
		return person;
	}
}
