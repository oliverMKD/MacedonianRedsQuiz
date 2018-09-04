package com.oli.macedonianredsquiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class TriviaQuizHelper extends SQLiteOpenHelper {
    private Context context;
    private static final String DB_NAME = "TQuiz.db";

    //If you want to add more questions or wanna update table values
    //or any kind of modification in db just increment version no.
    private static final int DB_VERSION = 12;
    //Table name
    private static final String TABLE_NAME = "TQ";
    //Id of question
    private static final String UID = "_UID";
    //Question
    private static final String QUESTION = "QUESTION";
    //Option A
    private static final String OPTA = "OPTA";
    //Option B
    private static final String OPTB = "OPTB";
    //Option C
    private static final String OPTC = "OPTC";
    //Option D
    private static final String OPTD = "OPTD";
    //Answer
    private static final String ANSWER = "ANSWER";
    //So basically we are now creating table with first column-id , sec column-question , third column -option A, fourth column -option B , Fifth column -option C , sixth column -option D , seventh column - answer(i.e ans of  question)
    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ( " + UID + " INTEGER PRIMARY KEY AUTOINCREMENT , " + QUESTION + " VARCHAR(255), " + OPTA + " VARCHAR(255), " + OPTB + " VARCHAR(255), " + OPTC + " VARCHAR(255), " + OPTD + " VARCHAR(255), " + ANSWER + " VARCHAR(255));";
    //Drop table query
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    TriviaQuizHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //OnCreate is called only once
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //OnUpgrade is called when ever we upgrade or increment our database version no
        sqLiteDatabase.execSQL(DROP_TABLE);
        onCreate(sqLiteDatabase);
    }

    void allQuestion() {
        ArrayList<TriviaQuestion> arraylist = new ArrayList<>();

        arraylist.add(new TriviaQuestion("How many times have Liverpool won the European Cup (including the Champions League)?", "Three", "Five", "Six", "Four", "Five"));

        arraylist.add(new TriviaQuestion("Whom did Kenny Dalglish replace when he began his first stint as Liverpool manager ?", "Bill Shankly", "Bob Paisley", "Graeme Souness", "Joe Fagan", "Joe Fagan"));

        arraylist.add(new TriviaQuestion("Which team did Liverpool beat to lift their first European Cup in 1977 ?", "Borussia Mönchengladbach", "FC Zürich", "Saint-Étienne", "Club Brugge", "Borussia Mönchengladbach"));

        arraylist.add(new TriviaQuestion("Who is liverpool all time leading goalscorer ?", "Ian Rush", "Roger Hunt", "Robbie Fowler", "Billy Liddell", "Ian Rush"));

        arraylist.add(new TriviaQuestion("Who is liverpool youngest goalscorer ?", "Ian Rush", "Michael Owen", "Robbie Fowler", "Ben Woodburn", "Ben Woodburn"));

        arraylist.add(new TriviaQuestion("Who scored the fastest hat-trick in Liverpool history ?", "Luis Suárez", "Michael Owen", "Robbie Fowler", "Sadio Mané", "Robbie Fowler"));

        arraylist.add(new TriviaQuestion("Who scored most penalties in Liverpool history ?", "Ian Rush", "Kenny Dalglish", "Steven Gerrard", "Kevin Keegan", "Steven Gerrard"));

        arraylist.add(new TriviaQuestion("Liverpool was the first English professional club to have a sponsor’s logo on their jerseys when they made a deal with which Japanese firm in 1979 ?", "Sony", "Casio", "Hitachi", "Sanyo", "Hitachi"));

        arraylist.add(new TriviaQuestion("What year is Liverpool FC found ?", "1982", "1892", "1893", "1891", "1892"));

        arraylist.add(new TriviaQuestion("Who was Liverpool's manager when they won 2001 UEFA Cup ?", "Rafa Benitez", "Gérard Houllier", "Roy Evans", "Graeme Souness", "Gérard Houllier"));

        arraylist.add(new TriviaQuestion("Who is liverpool oldest goalscorer ?", "Billy Liddell", "Gary McAllister", "Ian St John", "Karl-Heinz Riedle", "Billy Liddell"));

        arraylist.add(new TriviaQuestion("Who has most goals in a debut season ?", "Kenny Dalglish", "Fernando Torres", "John Barnes", "Mohamed Salah", "Mohamed Salah"));

        this.addAllQuestions(arraylist);

    }


    private void addAllQuestions(ArrayList<TriviaQuestion> allQuestions) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            for (TriviaQuestion question : allQuestions) {
                values.put(QUESTION, question.getQuestion());
                values.put(OPTA, question.getOptA());
                values.put(OPTB, question.getOptB());
                values.put(OPTC, question.getOptC());
                values.put(OPTD, question.getOptD());
                values.put(ANSWER, question.getAnswer());
                db.insert(TABLE_NAME, null, values);
            }
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
            db.close();
        }
    }


    List<TriviaQuestion> getAllOfTheQuestions() {

        List<TriviaQuestion> questionsList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        String coloumn[] = {UID, QUESTION, OPTA, OPTB, OPTC, OPTD, ANSWER};
        Cursor cursor = db.query(TABLE_NAME, coloumn, null, null, null, null, null);


        while (cursor.moveToNext()) {
            TriviaQuestion question = new TriviaQuestion();
            question.setId(cursor.getInt(0));
            question.setQuestion(cursor.getString(1));
            question.setOptA(cursor.getString(2));
            question.setOptB(cursor.getString(3));
            question.setOptC(cursor.getString(4));
            question.setOptD(cursor.getString(5));
            question.setAnswer(cursor.getString(6));
            questionsList.add(question);
        }

        db.setTransactionSuccessful();
        db.endTransaction();
        cursor.close();
        db.close();
        return questionsList;
    }
}
