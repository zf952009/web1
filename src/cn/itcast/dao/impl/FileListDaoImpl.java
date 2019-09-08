package cn.itcast.dao.impl;

import cn.itcast.dao.FileListDao;
import cn.itcast.domain.File_List;
import cn.itcast.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/**
 * codening:utf-8
 *
 * @author :FileListDaoImpl
 * @time :2019.07.09,13:43
 * @file :cn.itcast.dao.impl.FileListDaoImpl.jave
 */
public class FileListDaoImpl implements FileListDao {
    @Override
    public List<File_List> getAll() {
        Session session = HibernateUtils.getSession();
        String hql = "from File_List where res=:res order by id asc ";
        Query query = session.createQuery(hql);
        query.setParameter("res",0);
        return query.list();
    }

    @Override
    public List<File_List> find(File_List fileList) {
        Session session = HibernateUtils.getSession();
        String name = fileList.getName();
        Integer id = fileList.getId();
        if (id != null && !"".equals(name) && name != null && !"".equals(id)) {
            Query query = session.createQuery("from File_List where id=:id or name like :name and res=:res order by id asc ");
            query.setParameter("id", id);
            query.setParameter("res",0);
            query.setParameter("name", "%" + name + "%");
            return query.list();
        }
        if (id != null) {
            Query query = session.createQuery("from File_List where  id=:id and res=:res order by id asc ");
            query.setParameter("id", id);
            query.setParameter("res",0);
            return query.list();
        }
        if (name != null || !"".equals(name)) {
            Query query = session.createQuery("from File_List where name like :name and res =:res order by id asc ");
            query.setParameter("name", "%" + name + "%");
            query.setParameter("res",0);
            return query.list();
        }
        return this.getAll();
    }

    @Override
    public int delete(Integer id) {
        Session session = HibernateUtils.getSession();
        String hql="from File_List where id =:id";
        Query query = session.createQuery(hql);
        query.setParameter("id",id);
        File_List fileList = (File_List)query.list().get(0);
        fileList.setRes(1);
        return (int)session.save(fileList);
    }
}
