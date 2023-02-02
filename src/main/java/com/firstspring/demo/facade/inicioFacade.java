package com.firstspring.demo.facade;

import com.firstspring.demo.conexion.ManagerConexion;
import com.firstspring.demo.dto.inicioDto;
import com.firstspring.demo.mrg.inicioMrgInterface;
import com.firstspring.demo.exception.FacadeEXception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class inicioFacade implements inicioFacadeInterface{
    @Autowired
    private inicioMrgInterface Mgr;

    public List<inicioDto> selectall()throws FacadeEXception {
        ManagerConexion.getInstance().open();
        try {
            return Mgr.selectall();

        }catch (Exception e){
            throw new FacadeEXception(e);
        }finally {
            ManagerConexion.getInstance().close();
        }
    }
}
