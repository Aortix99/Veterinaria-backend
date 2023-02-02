package com.firstspring.demo.mrg;

import com.firstspring.demo.dao.InicioDao;
import com.firstspring.demo.dao.inicioDaoInterface;
import com.firstspring.demo.dto.EspecieDto;
import com.firstspring.demo.exception.ManagerEXception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.firstspring.demo.dto.inicioDto;

import java.util.List;

@Component
public class inicioMrg implements inicioMrgInterface{
    @Autowired
    private inicioDaoInterface Dao;

    public List<inicioDto> selectall()throws ManagerEXception {
        try {

            return Dao.selectall();
        }catch (Exception Ex){
            throw new ManagerEXception(Ex);
        }
    }
}
