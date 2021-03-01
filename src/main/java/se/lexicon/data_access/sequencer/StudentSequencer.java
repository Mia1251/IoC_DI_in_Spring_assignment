package se.lexicon.data_access.sequencer;

public class StudentSequencer {

    private static int studentSequencer = 0;

    public static int nextStudentId() {
        return ++studentSequencer;
    }
}
