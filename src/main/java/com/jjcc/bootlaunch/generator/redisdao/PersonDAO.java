package com.jjcc.bootlaunch.generator.redisdao;

import com.jjcc.bootlaunch.model.TPerson;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author Jjcc
 * @version 1.0.0
 * @className PersonDAO.java
 * @createTime 2019年11月12日 15:57:00
 */
@Repository
public interface PersonDAO extends CrudRepository<TPerson, Long>, QueryByExampleExecutor<TPerson> {


    TPerson findByName(String name);

}
