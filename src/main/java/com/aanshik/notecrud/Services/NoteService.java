package com.aanshik.notecrud.Services;

import com.aanshik.notecrud.Dto.NoteDto;
import com.aanshik.notecrud.Entity.Note;

import java.util.List;

public interface NoteService {

    //create note
    public NoteDto createNote(NoteDto noteDto);

    //update note
    public NoteDto updateNote(NoteDto noteDto,int id);

    //read note by id
    public NoteDto getNoteById(int id);

    //get all notes
    public List<NoteDto> getAllNotes();


    //delete note by id
    public Boolean deleteNote(Integer id);
}
