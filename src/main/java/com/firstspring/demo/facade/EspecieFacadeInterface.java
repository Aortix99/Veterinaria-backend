package com.firstspring.demo.facade;

import com.firstspring.demo.dto.EspecieDto;
import com.firstspring.demo.exception.FacadeEXception;

import java.util.List;

public interface EspecieFacadeInterface {
    public void save(EspecieDto C) throws FacadeEXception;
    public void delete(long P)throws FacadeEXception;
    public List<EspecieDto> selectall()throws FacadeEXception;

}
