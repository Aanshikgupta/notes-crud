package com.aanshik.notecrud.Repository;

import com.aanshik.notecrud.Entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepo extends JpaRepository<Note,Integer> {
}
