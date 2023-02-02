package com.firstspring.demo.dao;

import com.firstspring.demo.dto.PacienteDto;
import com.firstspring.demo.exception.DaoEXception;
import java.util.List;

public interface PacienteDaoInterface {
    public PacienteDto seledByid(PacienteDto P) throws DaoEXception;
    public void Insert(PacienteDto P) throws DaoEXception;
    public List<PacienteDto> selectall()throws DaoEXception;
    public void update(PacienteDto P) throws DaoEXception;
    public void delete(long P) throws DaoEXception;
}
