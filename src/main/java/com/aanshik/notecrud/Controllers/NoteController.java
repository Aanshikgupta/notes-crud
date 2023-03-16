package com.aanshik.notecrud.Controllers;

import com.aanshik.notecrud.Dto.NoteDto;
import com.aanshik.notecrud.Services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class NoteController {

    @Autowired
    NoteService noteService;


    //create
    @PostMapping("/create")
    public ResponseEntity<NoteDto> createNote(@RequestBody NoteDto noteDto){
        return new ResponseEntity<NoteDto>(noteService.createNote(noteDto),HttpStatus.OK);
    }

    //get by id
    @GetMapping("/get/{id}")
    public ResponseEntity<NoteDto> getNoteById(@PathVariable Integer id){
        return new ResponseEntity<NoteDto>(noteService.getNoteById(id), HttpStatus.OK);
    }

    //get all
    @GetMapping("/notes")
    public ResponseEntity<List<NoteDto>> getAllNotes(){
        return new ResponseEntity<List<NoteDto>>(noteService.getAllNotes(), HttpStatus.OK);
    }

    //delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteNote(@PathVariable Integer id){
        return new ResponseEntity<Boolean>(noteService.deleteNote(id), HttpStatus.GONE);
    }

    //update
    @PutMapping("/update/{id}")
    public ResponseEntity<NoteDto> updateNote(@RequestBody NoteDto noteDto,@PathVariable Integer id){
        return new ResponseEntity<NoteDto>(noteService.updateNote(noteDto,id),HttpStatus.ACCEPTED);
    }

}
