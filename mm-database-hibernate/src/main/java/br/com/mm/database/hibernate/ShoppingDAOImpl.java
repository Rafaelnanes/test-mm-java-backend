package br.com.mm.database.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.mm.dao.ShoppingDAO;
import br.com.mm.model.entities.Shopping;

@Repository
@Transactional
public class ShoppingDAOImpl extends GenericDAOImpl<Shopping> implements ShoppingDAO {

    @Override
    @SuppressWarnings("unchecked")
    public Shopping get() {
	Criteria criteria = getSession().createCriteria(getPersistenceClass());
	List<Shopping> list = criteria.list();
	return list.size() == 0 ? null : (Shopping) criteria.list().get(0);
    }

    @Override
    protected Class<Shopping> getPersistenceClass() {
	return Shopping.class;
    }

}
