package com.firstspring.demo.facade;

import com.firstspring.demo.dto.DuenoDto;
import com.firstspring.demo.exception.FacadeEXception;
import java.util.List;

public interface DuenoFacadeInterface {
    public void save(DuenoDto C) throws FacadeEXception;
    public void delete(long P)throws FacadeEXception;
    public List<DuenoDto> selectall()throws FacadeEXception;
}
