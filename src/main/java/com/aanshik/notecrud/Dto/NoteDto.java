package com.aanshik.notecrud.Dto;

public class NoteDto {

    private Integer noteId;

    private String noteMessage;

    public NoteDto() {
    }

    public NoteDto(String noteMessage) {
        this.noteMessage = noteMessage;
    }

    public Integer getNoteId() {
        return noteId;
    }

    public void setNoteId(Integer noteId) {
        this.noteId = noteId;
    }

    public String getNoteMessage() {
        return noteMessage;
    }

    public void setNoteMessage(String noteMessage) {
        this.noteMessage = noteMessage;
    }
}
