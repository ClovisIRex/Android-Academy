package dev.tal.exercise6tal.db;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tal on 12/8/17.
 */

public class NoteUtil {

    public static List getNoteList() {

        List<Note> noteList = new ArrayList<>();
        noteList.add(createNote("Title1", "Body1"));
        noteList.add(createNote("Title2", "Body2"));
        noteList.add(createNote("Title3", "Body3"));

        return noteList;
    }

    public static Note createNote(String title, String body) {

        Note note = new Note();
        note.setTitle(title);
        note.setBody(body);

        return note;
    }
}
