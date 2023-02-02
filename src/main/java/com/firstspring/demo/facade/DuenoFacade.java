package com.firstspring.demo.facade;

import com.firstspring.demo.conexion.ManagerConexion;
import com.firstspring.demo.dto.DuenoDto;
import com.firstspring.demo.exception.FacadeEXception;
import com.firstspring.demo.mrg.DuenoMrgInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DuenoFacade implements DuenoFacadeInterface{
    @Autowired
    private DuenoMrgInterface Mgr;


    public void save(DuenoDto C) throws FacadeEXception {
        try{
            ManagerConexion.getInstance().open();
            Mgr.save(C);
            ManagerConexion.getInstance().commit();
        }catch (Exception Ex){
            ManagerConexion.getInstance().rollback();
            throw new FacadeEXception(Ex);
        }finally {
            ManagerConexion.getInstance().close();
        }
    }
    public void delete(long P)throws FacadeEXception{
        try {
            ManagerConexion.getInstance().open();
            Mgr.delete(P);
            ManagerConexion.getInstance().commit();
        }catch (Exception e){
            throw new FacadeEXception();
        }
        finally {
            ManagerConexion.getInstance().close();
        }
    }
    public List<DuenoDto> selectall()throws FacadeEXception{
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
