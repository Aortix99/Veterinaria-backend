package com.firstspring.demo.dao;

import com.firstspring.demo.conexion.ManagerConexion;

import com.firstspring.demo.dto.EspecieDto;
import com.firstspring.demo.dto.PacienteDto;
import com.firstspring.demo.dto.RazaDto;
import com.firstspring.demo.dto.inicioDto;
import com.firstspring.demo.exception.DaoEXception;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class InicioDao  implements inicioDaoInterface{
    public List<inicioDto> selectall()throws DaoEXception {
        List<inicioDto> list=new ArrayList<>();
        String Select="SELECT d.identificacion,d.Nombre, d.telefono, d.ciudad, d.Direccion,  p.idPaciente , p.nombre, r.raza, p.feRegistro, e.especie FROM dueño as d \n" +
                "INNER JOIN nompaciente as p ON p.idPaciente=d.idPaciente \n" +
                "INNER JOIN raza as r ON r.idRaza=p.idRaza " +
                "INNER JOIN especie as e ON e.idEspecie=p.idEspecie;";
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        inicioDto almacenar=null;

        Connection connection= ManagerConexion.getInstance().getConnection();


        try {
            statement=connection.prepareStatement(Select);
            resultSet=statement.executeQuery();

            while (resultSet.next()){
                almacenar=new inicioDto();
                RazaDto raza= new RazaDto();
                EspecieDto especieDto=new EspecieDto();
                PacienteDto pacienteDto=new PacienteDto();

                almacenar.setIdentificacion(resultSet.getInt("d.identificacion"));
                almacenar.setNombre(resultSet.getString("d.Nombre"));
                almacenar.setTelefono(resultSet.getString("d.telefono"));
                almacenar.setCiudad(resultSet.getString("d.ciudad"));
                almacenar.setDireccion(resultSet.getString("d.Direccion"));
                almacenar.setIdPaciente(resultSet.getInt("p.idPaciente"));
                almacenar.setNombreMascota(resultSet.getString("p.nombre"));
                almacenar.setRaza(resultSet.getString("r.raza"));
                almacenar.setFechaRe(resultSet.getDate("p.feRegistro"));
                almacenar.setEspecie(resultSet.getString("e.especie"));


           //     r.raza, p.feRegistro, e.especie
                list.add(almacenar);
            }

            return list;
        }catch (Exception e){
            throw new DaoEXception(e);
        }


    }
}
