package com.firstspring.demo.Controller;

import com.firstspring.demo.dto.EspecieDto;
import com.firstspring.demo.exception.ControllerEXcption;
import com.firstspring.demo.facade.EspecieFacadeInterface;
import com.firstspring.demo.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EspecieController {

    @Autowired
    private EspecieFacadeInterface Cfc;
    @PostMapping("especie/save")
    public ResponseEntity<Message> save(@RequestBody EspecieDto C)throws ControllerEXcption {
        Message message=new Message("0","Se guardo con exito",null);
        try {
            Cfc.save(C);
        }catch (Exception e){
            throw new ControllerEXcption(e);
        }return ResponseEntity.ok(message);
    }
    @DeleteMapping("especie/delete/{P}")
    public ResponseEntity<Message> delete(@PathVariable long P)throws ControllerEXcption{
        Message message=new Message("0","Eliminado Exitosamente",null);
        try {
            Cfc.delete(P);
        }catch (Exception e){
            throw new ControllerEXcption();
        }

        return ResponseEntity.ok(message);

    }

    @GetMapping("especie/all")
    public ResponseEntity<Message> selectall()throws ControllerEXcption{
        Message message=new Message("0","aqui ta todo", null);
        try {
            List<EspecieDto> list= Cfc.selectall();
            message.setData(list);

        }catch (Exception e){
            throw new ControllerEXcption(e);
        }
        return ResponseEntity.ok(message);
    }

}
