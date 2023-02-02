package com.firstspring.demo.dao;

import com.firstspring.demo.dto.DuenoDto;
import com.firstspring.demo.exception.DaoEXception;


import java.util.List;

public interface DuenoDaoInterface {
    public DuenoDto seledByid(DuenoDto D) throws DaoEXception;
    public void Insert(DuenoDto D) throws DaoEXception;
    public List<DuenoDto> selectall()throws DaoEXception;
    public void update(DuenoDto D) throws DaoEXception;
    public void delete(long P) throws DaoEXception;

}
