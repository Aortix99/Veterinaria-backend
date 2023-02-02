package com.firstspring.demo.facade;

import com.firstspring.demo.dto.inicioDto;
import com.firstspring.demo.exception.FacadeEXception;

import java.util.List;

public interface inicioFacadeInterface {
    public List<inicioDto> selectall()throws FacadeEXception;
}
