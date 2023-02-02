package com.firstspring.demo.dao;

import com.firstspring.demo.conexion.ManagerConexion;
import com.firstspring.demo.dto.DuenoDto;
import com.firstspring.demo.exception.DaoEXception;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
@Component

public class DuenoDao implements DuenoDaoInterface{

    public DuenoDto seledByid(DuenoDto D) throws DaoEXception {
        DuenoDto Alamacena=null;
        String SELECT = "SELECT identificacion, tipoIdDueño, telefono, ciudad, Direccion, Nombre, idPaciente FROM dueño WHERE identificacion=? ";
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        Connection connection = ManagerConexion.getInstance().getConnection();

        try{
            statement=connection.prepareStatement(SELECT);
            statement.setInt(1, D.getIdentificacion());
            resultSet=statement.executeQuery();
            while (resultSet.next()){
                Alamacena=new DuenoDto();
                Alamacena.setTipoIdDueno(resultSet.getString("tipoIdDueño"));
                Alamacena.setTelefono(resultSet.getString("telefono"));
                Alamacena.setCiudad(resultSet.getString("ciudad"));
                Alamacena.setDireccion(resultSet.getString("Direccion"));
                Alamacena.setNombre(resultSet.getString("Nombre"));
                Alamacena.setIdPaciente(resultSet.getInt("idPaciente"));
                Alamacena.setIdentificacion(resultSet.getInt("identificacion"));

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


    public void Insert(DuenoDto D) throws DaoEXception {
        String Insert = "INSERT INTO dueño(identificacion, tipoIdDueño, telefono, ciudad, Direccion, Nombre, idPaciente) VALUES (?,?,?,?,?,?,?)";

        PreparedStatement statement = null;

        Connection connection = ManagerConexion.getInstance().getConnection();
        try {
            statement=connection.prepareStatement(Insert);
            statement.setInt(1, D.getIdentificacion());
            statement.setString(2, D.getTipoIdDueno());
            statement.setString(3,D.getTelefono());
            statement.setString(4,D.getCiudad());
            statement.setString(5, D.getDireccion());
            statement.setString(6,D.getNombre());
            statement.setInt(7,D.getIdPaciente());
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

    public List<DuenoDto> selectall()throws DaoEXception{
        List<DuenoDto> list=new ArrayList<>();
        String Select="SELECT identificacion, tipoIdDueño, telefono, ciudad, Direccion, Nombre, idPaciente FROM dueño";
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        DuenoDto almacenar=null;

        Connection connection=ManagerConexion.getInstance().getConnection();


        try {
            statement=connection.prepareStatement(Select);
            resultSet=statement.executeQuery();

            while (resultSet.next()){
                almacenar=new DuenoDto();
                almacenar.setIdentificacion(resultSet.getInt("identificacion"));
                almacenar.setTipoIdDueno(resultSet.getString("tipoIdDueño"));
                almacenar.setTelefono(resultSet.getString("telefono"));
                almacenar.setCiudad(resultSet.getString("ciudad"));
                almacenar.setDireccion(resultSet.getString("Direccion"));
                almacenar.setNombre(resultSet.getString("Nombre"));
                almacenar.setIdPaciente(resultSet.getInt("idPaciente"));

                list.add(almacenar);
            }

            return list;
        }catch (Exception e){
            throw new DaoEXception(e);
        }


    }
    public void update(DuenoDto D) throws DaoEXception {

        String UPDATE="UPDATE dueño SET tipoIdDueño=?,telefono=?,ciudad=?,Direccion=?,Nombre=?,idPaciente=? WHERE identificacion=?";
        PreparedStatement statement=null;
        Connection connection= ManagerConexion.getInstance().getConnection();

        try {

            statement=connection.prepareStatement(UPDATE);

            statement.setString(1, D.getTipoIdDueno());
            statement.setString(2, D.getTelefono());
            statement.setString(3,D.getCiudad());
            statement.setString(4, D.getDireccion());
            statement.setString(5, D.getNombre());
            statement.setInt(6, D.getIdPaciente());
            statement.setInt(7, D.getIdentificacion());

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
        String DELETE="DELETE FROM `dueño` WHERE identificacion = ?";
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