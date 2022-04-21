//package ma.enset.annuaireprofessionnel;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//
//public class DbContect extends SQLiteOpenHelper {
//    public DbContect(Context context) {
//        super(context, "contect.db", null, 1);
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase sqLiteDatabase) {
//        // Script to create table.
//        String script = "CREATE TABLE " + "contact" + "("
//                + "id" + " INTEGER PRIMARY KEY,"
//                + "first_name" + " TEXT,"
//                + "last_name" + " TEXT,"
//                + "job" + " TEXT,"
//                + "email" + " TEXT,"
//                + "phone" + " VARCHAR"+")";
//        // Execute script.
//        sqLiteDatabase.execSQL(script);
//
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
//
//        // Drop table
//        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + "contact");
//
//
//        // Recreate
//        onCreate(sqLiteDatabase);
//
//    }
//
//    public boolean insertData(String first_name, String last_name,String job, String email, String phone)
//    {
//        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("first_name", first_name);
//        contentValues.put("last_name", last_name);
//        contentValues.put("job", job);
//        contentValues.put("email", email);
//        contentValues.put("phone", phone);
//        long result = sqLiteDatabase.insert("contact", null , contentValues);
//        if(result == -1){
//            return false;
//        }else {
//            return true;
//        }
//    }
//
//    public boolean updateData(String first_name, String last_name,String job, String email, String phone)
//    {
//        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("last_name", last_name);
//        contentValues.put("job", job);
//        contentValues.put("email", email);
//        contentValues.put("phone", phone);
//
//        Cursor cursor = sqLiteDatabase.rawQuery("Select * from content where first_name = ?",new String[]{first_name});
//        if (cursor.getCount()>0) {
//
//            long result = sqLiteDatabase.update("contact", contentValues, "first_name=?", new String[]{first_name});
//            if (result == -1) {
//                return false;
//            } else {
//                return true;
//            }
//        }else {
//            return false;
//        }
//    }
//
//    public boolean deleteData(String first_name)
//    {
//        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
//
//        Cursor cursor = sqLiteDatabase.rawQuery("Select * from content where first_name = ?",new String[]{first_name});
//        if (cursor.getCount()>0) {
//
//            long result = sqLiteDatabase.delete("contact", "first_name=?", new String[]{first_name});
//            if (result == -1) {
//                return false;
//            } else {
//                return true;
//            }
//        }else {
//            return false;
//        }
//    }
//
//    public Cursor getData(String first_name)
//    {
//        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
//
//        Cursor cursor = sqLiteDatabase.rawQuery("Select * from content where first_name = ?",new String[]{first_name});
//        return cursor;
//    }
//}
