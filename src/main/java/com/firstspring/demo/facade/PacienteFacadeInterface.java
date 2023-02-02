package com.firstspring.demo.facade;

import com.firstspring.demo.dto.PacienteDto;
import com.firstspring.demo.exception.FacadeEXception;


import java.util.List;

public interface PacienteFacadeInterface {
    public void save(PacienteDto C) throws FacadeEXception;
    public void delete(long P)throws FacadeEXception;
    public List<PacienteDto> selectall()throws FacadeEXception;
}
