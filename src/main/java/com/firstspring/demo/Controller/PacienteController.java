package com.firstspring.demo.Controller;

import com.firstspring.demo.dto.PacienteDto;
import com.firstspring.demo.exception.ControllerEXcption;
import com.firstspring.demo.facade.PacienteFacadeInterface;
import com.firstspring.demo.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
public class PacienteController {
    @Autowired
    private PacienteFacadeInterface Cfc;
    @PostMapping("paciente/save")
    public ResponseEntity<Message> save(@RequestBody PacienteDto C)throws ControllerEXcption {
        Message message=new Message("0","Se guardo con exito",null);
        try {
            Cfc.save(C);
        }catch (Exception e){
            throw new ControllerEXcption(e);
        }return ResponseEntity.ok(message);
    }
    @DeleteMapping("paciente/delete/{P}")
    public ResponseEntity<Message> delete(@PathVariable long P)throws ControllerEXcption{
        Message message=new Message("0","Eliminado Exitosamente",null);
        try {
            Cfc.delete(P);
        }catch (Exception e){
            throw new ControllerEXcption();
        }

        return ResponseEntity.ok(message);

    }

    @GetMapping("paciente/all")
    public ResponseEntity<Message> selectall()throws ControllerEXcption{
        Message message=new Message("0","aqui ta todo", null);
        try {
            List<PacienteDto> list= Cfc.selectall();
            message.setData(list);

        }catch (Exception e){
            throw new ControllerEXcption(e);
        }
        return ResponseEntity.ok(message);
    }
}
