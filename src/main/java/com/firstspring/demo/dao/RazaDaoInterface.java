package com.firstspring.demo.dao;

import com.firstspring.demo.dto.RazaDto;
import com.firstspring.demo.exception.DaoEXception;
import java.util.List;

public interface RazaDaoInterface {
    public RazaDto seledByid(RazaDto R) throws DaoEXception;
    public void Insert(RazaDto R) throws DaoEXception;
    public List<RazaDto> selectall()throws DaoEXception;
    public void update(RazaDto C) throws DaoEXception;
    public void delete(long P) throws DaoEXception;
}
