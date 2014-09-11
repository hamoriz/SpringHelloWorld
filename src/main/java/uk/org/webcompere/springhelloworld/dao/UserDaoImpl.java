package uk.org.webcompere.springhelloworld.dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
import com.googlecode.genericdao.search.Filter;
import com.googlecode.genericdao.search.Search;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import uk.org.webcompere.springhelloworld.model.User;

import java.util.List;

/**
 * Implementation of the UserDaoClass
 */
@Repository
@Transactional
public class UserDaoImpl extends BaseDaoImpl<User, Integer> implements UserDao {

    @Override
    public User findByUserName(String username) {
        Search criteria = new Search();
        criteria.addFilterEqual("username", username);

        return singleResultOf(criteria);
    }

    @Override
    public User findByLoginCredentials(String username, String password) {
        Search criteria = new Search();
        criteria.addFilterAnd(
                Filter.equal("username", username),
                Filter.equal("password", password));

        return singleResultOf(criteria);
    }

}