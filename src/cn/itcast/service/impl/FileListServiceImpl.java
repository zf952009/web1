package cn.itcast.service.impl;

import cn.itcast.dao.FileListDao;
import cn.itcast.dao.impl.FileListDaoImpl;
import cn.itcast.domain.File_List;
import cn.itcast.service.FileListService;
import cn.itcast.utils.HibernateUtils;
import org.hibernate.Transaction;

import java.util.List;

/**
 * codening:utf-8
 *
 * @author :FileListServiceImpl
 * @time :2019.07.09,13:54
 * @file :cn.itcast.service.impl.FileListServiceImpl.jave
 */
public class FileListServiceImpl implements FileListService {
    FileListDao fileListDao = new FileListDaoImpl();

    @Override
    public List<File_List> getAll() {
        Transaction transaction = HibernateUtils.getSession().beginTransaction();
        List<File_List> all = fileListDao.getAll();
        transaction.commit();
        return all;
    }

    @Override
    public List<File_List> find(File_List fileList) {
        Transaction transaction = HibernateUtils.getSession().beginTransaction();
        List<File_List> find = fileListDao.find(fileList);
        transaction.commit();
        return find;
    }

    @Override
    public String delete(Integer id) {
        Transaction transaction = HibernateUtils.getSession().beginTransaction();
        int i = fileListDao.delete(id);
        transaction.commit();
        return i+"";
    }
}
