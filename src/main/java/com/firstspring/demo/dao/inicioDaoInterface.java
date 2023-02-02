package com.firstspring.demo.dao;

import com.firstspring.demo.dto.inicioDto;
import com.firstspring.demo.exception.DaoEXception;

import java.util.List;

public interface inicioDaoInterface {
    public List<inicioDto> selectall()throws DaoEXception;
}
