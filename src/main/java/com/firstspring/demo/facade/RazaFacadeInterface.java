package com.firstspring.demo.facade;

import com.firstspring.demo.dto.RazaDto;
import com.firstspring.demo.exception.FacadeEXception;

import java.util.List;

public interface RazaFacadeInterface {
    public void save(RazaDto C) throws FacadeEXception;
    public void delete(long P)throws FacadeEXception;
    public List<RazaDto> selectall()throws FacadeEXception;

}

