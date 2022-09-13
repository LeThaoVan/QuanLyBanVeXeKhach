/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uav.repository.impl;

import com.uav.pojo.Comment;
import com.uav.pojo.Users;
import com.uav.repository.CommentRepository;
import com.uav.repository.RouteBusesRepository;
import com.uav.service.UserService;
import java.util.Date;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author HP
 */
@Repository
@Transactional
@PropertySource("classpath:messages.properties")
public class CommentRepositoryImpl implements CommentRepository{
    
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Autowired
    private RouteBusesRepository routeBusesRepository;
    
    @Autowired
    private Environment env;
    
    @Override
    public Comment addComment(String content, int routeBusesId, int userId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Comment c = new Comment();
        c.setBid(this.routeBusesRepository.getRoutebusesById(routeBusesId));
        c.setUserid(session.get(Users.class,userId));
        c.setContext(content);
        c.setCreatdatetime(new Date());
        try {
            session.save(c);
            return c;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Comment> getCommentsByRouteBusesId(int routeBusesId, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Comment> q = b.createQuery(Comment.class);
        Root root = q.from(Comment.class);
        
        Predicate predicate = b.equal(root.get("bid"), routeBusesId);
        q.where(predicate);
        
        q.orderBy(b.desc(root.get("creatdatetime")));
        
        Query query = session.createQuery(q);
        
        if (page > 0) {
            int size = Integer.parseInt(env.getProperty("page.comment").toString());
            int start = (page - 1) * size;
            query.setFirstResult(start);
            query.setMaxResults(size);
        }
        return query.getResultList();
    }

    @Override
    public long countComment(int routeBusId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("Select Count(*) From Comment Where bid.rbid=:id");
        q.setParameter("id", routeBusId);

        return Long.parseLong(q.getSingleResult().toString());
    }

   
    
}
