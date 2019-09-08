package cn.itcast.service;

import cn.itcast.domain.File_List;

import java.util.List;

/**
 * codening:utf-8
 *
 * @author :FileListService
 * @time :2019.07.09,13:53
 * @file :cn.itcast.service.FileListService.jave
 */
public interface FileListService {
    List<File_List> getAll();
    List<File_List> find(File_List fileList);
    String delete(Integer id);
}
