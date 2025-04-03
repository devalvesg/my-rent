package com.devalvesg.my_rent.Infrastructure.Repositories;

import com.devalvesg.my_rent.Domain.Entities.UserEntity;
import com.devalvesg.my_rent.Infrastructure.Repositories.Contract.IUserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

public class UserRepository implements IUserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public UserEntity findByEmail(String email) {
        String sql = "SELECT u FROM Lessors u WHERE u.email = :email " +
                "UNION " +
                "SELECT u FROM Lessees u WHERE u.email = :email";
        Query query = entityManager.createQuery(sql);
        query.setParameter("email", email);
        return (UserEntity) query.getSingleResult();
    }
}
