package com.firstspring.demo.dao;

import com.firstspring.demo.conexion.ManagerConexion;
import com.firstspring.demo.dto.PacienteDto;
import com.firstspring.demo.exception.DaoEXception;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
@Component
public class PacienteDao implements PacienteDaoInterface {

    public PacienteDto seledByid(PacienteDto P) throws DaoEXception {
        PacienteDto Alamacena=null;
        String SELECT = "SELECT idPaciente, nombre, feNaMascota, feRegistro, idEspecie, idRaza FROM nompaciente WHERE idPaciente=?";
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        Connection connection = ManagerConexion.getInstance().getConnection();

        try{
            statement=connection.prepareStatement(SELECT);
            statement.setInt(1, P.getIdPaciente());
            resultSet=statement.executeQuery();
            while (resultSet.next()){
                Alamacena=new PacienteDto();

                Alamacena.setNombre(resultSet.getString("nombre"));
                Alamacena.setFeNaMascota(resultSet.getDate("feNaMascota"));
                Alamacena.setFeRegistro(resultSet.getDate("feRegistro"));
                Alamacena.setIdEspecie(resultSet.getInt("idEspecie"));
                Alamacena.setIdRaza(resultSet.getInt("idRaza"));
                Alamacena.setIdPaciente(resultSet.getInt("idPaciente"));
            }
            return Alamacena;

        }catch (Exception e){
            throw new DaoEXception(e);
        }finally {
            try {
                resultSet.close();
                statement.close();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }


    public void Insert(PacienteDto P) throws DaoEXception {
        String Insert = "INSERT INTO nompaciente(idPaciente, nombre,feNaMascota, feRegistro, idEspecie, idRaza) VALUES (?,?,?,?,?,?)";

        PreparedStatement statement = null;

        Connection connection = ManagerConexion.getInstance().getConnection();
        try {
            statement=connection.prepareStatement(Insert);
            statement.setInt(1, P.getIdPaciente());
            statement.setString(2,P.getNombre());
            statement.setDate(3,P.getFeNaMascota());
            statement.setDate(4, P.getFeRegistro());
            statement.setInt(5,P.getIdEspecie());
            statement.setInt(6, P.getIdRaza());


            statement.executeUpdate();
        }catch (Exception e){
            throw new DaoEXception();
        }finally {
            try {
                statement.close();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }

    public List<PacienteDto> selectall()throws DaoEXception{
        List<PacienteDto> list=new ArrayList<>();
        String Select="SELECT idPaciente, nombre, feNaMascota, feRegistro, idEspecie, idRaza FROM nompaciente";
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        PacienteDto almacenar=null;

        Connection connection=ManagerConexion.getInstance().getConnection();


        try {
            statement=connection.prepareStatement(Select);
            resultSet=statement.executeQuery();

            while (resultSet.next()){

                almacenar=new PacienteDto();

                almacenar.setIdPaciente(resultSet.getInt("idPaciente"));
                almacenar.setNombre(resultSet.getString("nombre"));
                almacenar.setFeNaMascota(resultSet.getDate("feNaMascota"));
                almacenar.setFeRegistro(resultSet.getDate("feRegistro"));
                almacenar.setIdEspecie(resultSet.getInt("idEspecie"));
                almacenar.setIdRaza(resultSet.getInt("idRaza"));


                list.add(almacenar);
            }

            return list;
        }catch (Exception e){
            throw new DaoEXception(e);
        }


    }
    public void update(PacienteDto P) throws DaoEXception {

        String UPDATE="UPDATE nompaciente SET nombre=?,feNaMascota=?,feRegistro=?,idEspecie=?,`idRaza=? WHERE idPaciente=?";
        PreparedStatement statement=null;
        Connection connection= ManagerConexion.getInstance().getConnection();

        try {

            statement=connection.prepareStatement(UPDATE);


            statement.setString(1,P.getNombre());
            statement.setDate(2,P.getFeNaMascota());
            statement.setDate(3, P.getFeRegistro());
            statement.setInt(4,P.getIdEspecie());
            statement.setInt(5, P.getIdRaza());
            statement.setInt(6, P.getIdPaciente());


            statement.executeUpdate();
            System.out.println(statement);

        }catch (Exception ex){
            throw new DaoEXception(ex);

        }finally {
            try {
                statement.close();
            }catch (Exception e){
                throw new DaoEXception(e);
            }
        }



    }
    public void delete(long P) throws DaoEXception {
        String DELETE="DELETE FROM `nompaciente` WHERE idPaciente=?";
        PreparedStatement statement=null;
        Connection connection=ManagerConexion.getInstance().getConnection();
        try {
            statement=connection.prepareStatement(DELETE);
            statement.setLong(1, P);
            statement.executeUpdate();

        }catch (Exception ex){
            throw new DaoEXception(ex);
        }finally {
            try {
                statement.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}