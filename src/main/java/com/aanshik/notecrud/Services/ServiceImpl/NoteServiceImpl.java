package com.aanshik.notecrud.Services.ServiceImpl;

import com.aanshik.notecrud.Dto.NoteDto;
import com.aanshik.notecrud.Entity.Note;
import com.aanshik.notecrud.Exceptions.ResourceNotFoundException;
import com.aanshik.notecrud.Repository.NoteRepo;
import com.aanshik.notecrud.Services.NoteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepo noteRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public NoteDto createNote(NoteDto noteDto) {
        Note note=modelMapper.map(noteDto,Note.class);

        Note savedNote=noteRepo.save(note);

        return (NoteDto) modelMapper.map(savedNote,NoteDto.class);
    }

    @Override
    public NoteDto updateNote(NoteDto noteDto,int id) {
        Note noteToBeSaved=modelMapper.map(noteDto,Note.class);

        Note note=noteRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Note",id));
        note.setNoteMessage(noteToBeSaved.getNoteMessage());

        return (NoteDto) modelMapper.map(note,NoteDto.class);

    }

    @Override
    public NoteDto getNoteById(int id) {
        Note note=noteRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Note",id));

        return (NoteDto) modelMapper.map(note,NoteDto.class);
    }

    @Override
    public List<NoteDto> getAllNotes() {
        List<Note> noteList=noteRepo.findAll();
        return noteList.stream().map((note)->modelMapper.map(note, NoteDto.class)).collect(Collectors.toList());
    }

    public Boolean deleteNote(Integer id){
        try {
            Note note = noteRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Note", id));
            noteRepo.delete(note);
            return true;
        }catch (ResourceNotFoundException e){
            return false;
        }
    }
}
