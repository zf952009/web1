package cn.itcast.dao;

import cn.itcast.domain.File_List;

import java.util.List;

/**
 * codening:utf-8
 *
 * @author :FileListDao
 * @time :2019.07.09,13:43
 * @file :cn.itcast.dao.FileListDao.jave
 */
public interface FileListDao {
    List<File_List> getAll();
    List<File_List> find(File_List fileList);
    int delete(Integer id);
}
