package com.firstspring.demo.mrg;

import com.firstspring.demo.dto.inicioDto;
import com.firstspring.demo.exception.ManagerEXception;

import java.util.List;

public interface inicioMrgInterface {
    public List<inicioDto> selectall()throws ManagerEXception;
}
