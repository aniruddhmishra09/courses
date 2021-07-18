/**
 * 
 */
package com.courses.microservices.restwebservices.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.courses.microservices.restwebservices.model.User;

/**
 * @author Aniruddh Mishra
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
