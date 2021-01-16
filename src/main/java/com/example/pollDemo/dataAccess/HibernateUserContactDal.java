package com.example.pollDemo.dataAccess;

import com.example.pollDemo.entity.User;
import com.example.pollDemo.entity.UserContact;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class HibernateUserContactDal implements IUserContactDal {
    private EntityManager entityManager;

    @Autowired
    public HibernateUserContactDal(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public String userContactFindByValue(String value) {

        Session session=entityManager.unwrap(Session.class);
        try {
            List<UserContact> contact=session.createNamedQuery("UserContact.findByValue", UserContact.class).setParameter("value",value).getResultList();

            if (contact.isEmpty())
            {
                return "You can use this value";
            }else {

                return "Its already taken";
            }
        }catch (Exception e)
        {
            return e.getMessage();
        }


    }
}
