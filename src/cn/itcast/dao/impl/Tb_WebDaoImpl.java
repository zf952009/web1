package cn.itcast.dao.impl;

import cn.itcast.dao.Tb_WebDao;
import cn.itcast.domain.Tb_web;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Tb_WebDaoImpl implements Tb_WebDao {
    @Override
    public List<Tb_web> getAll() {
        Session session = new Configuration().buildSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        transaction.begin();

        String hql="from Tb_web ";
        Query query = session.createQuery(hql);
        List<Tb_web> list = query.list();
        transaction.commit();

        return list;
    }
}
