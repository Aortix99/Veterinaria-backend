package com.firstspring.demo.dao;

import com.firstspring.demo.dto.EspecieDto;
import com.firstspring.demo.exception.DaoEXception;
import java.util.List;

public interface EspecieDaoInterface {
    public EspecieDto seledByid(EspecieDto E) throws DaoEXception;
    public void Insert(EspecieDto E) throws DaoEXception;
    public List<EspecieDto> selectall()throws DaoEXception;
    public void update(EspecieDto E) throws DaoEXception;
    public void delete(long P) throws DaoEXception;
}
