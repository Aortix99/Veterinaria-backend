package com.firstspring.demo.mrg;

import com.firstspring.demo.dto.PacienteDto;
import com.firstspring.demo.exception.ManagerEXception;

import java.util.List;


public interface PacienteMrgInterface {

    public void delete(long P)throws ManagerEXception;
    public List<PacienteDto> selectall()throws  ManagerEXception;
    public void save(PacienteDto C) throws ManagerEXception;
}
