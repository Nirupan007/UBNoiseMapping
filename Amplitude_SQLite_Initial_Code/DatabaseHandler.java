
 
public class DatabaseHandler extends SQLiteOpenHelper {
 
    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;
 
    // Database Name
    private static final String DATABASE_NAME = "amplitudeManager";
 
    private static final String TABLE_AMPS = "amps";
 
    private static final String KEY_ID = "id";
    private static final String KEY_AMPVAL = "ampval";
    private static final String KEY_LAT = "lat";
	private static final String KEY_LONGT = "longt";
 
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
 
    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_AMPS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_AMPVAL + " TEXT,"
                + KEY_LAT + " TEXT," +  KEY_LONGT + "TEXT" + ")";
        db.execSQL(CREATE_AMPS_TABLE);
    }
 
    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_AMPS);
 
        // Create tables again
        onCreate(db);
    }
 
    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */
 
    void addContact(Amplitude amplitude) {
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
        values.put(KEY_AMPVAL, amplitude.getAmpval()); 
        values.put(KEY_LAT, amplitude.getLat()); 
		values.put(KEY_LONGT, amplitude.getLongt()); 
 
        // Inserting Row
        db.insert(TABLE_CONTACTS, null, values);
        db.close(); // Closing database connection
    }
 
    Contact getContact(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
 
        Cursor cursor = db.query(TABLE_AMPS, new String[] { KEY_ID,
                KEY_AMPVAL, KEY_LAT, KEY_LONGT }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
 
        Amplitde Amplitude = new Amplitude(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));
        return amplitude;
    }
     
	 
    public List<Amplitude> getAllContacts() {
        List<Amplitude> amplitudeList = new ArrayList<Amplitude>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_AMPS;
 
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
 
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Amplitude amplitude = new Amplitude();
                amplitude.setID(Integer.parseInt(cursor.getString(0)));
                amplitude.setAmpval(cursor.getString(1));
                amplitude.setLat(cursor.getString(2));
                amplitude.setLongt(cursor.getString(2));
                amplitudeList.add(amplitude);
            } while (cursor.moveToNext());
        }
 
        return amplitudeList;
    }
 
    public int updateAmplitude(Amplitude amplitude) {
        SQLiteDatabase db = this.getWritableDatabase();
 
        AmplitudeValues values = new AmplitudeValues();
        values.put(KEY_NAME, amplitude.getName());
        values.put(KEY_AMPVAL, amplitude.getAmpval());
        values.put(KEY_LAT, amplitude.getLat());
        values.put(KEY_LONGT, amplitude.getLongt());
        // updating row
        return db.update(TABLE_AMPLITUDE, values, KEY_ID + " = ?",
                new String[] { String.valueOf(amplitude.getID()) });
    }
 
    public void deleteAmplitude(Amplitude amplitude) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_AMPLITUDE, KEY_ID + " = ?",
                new String[] { String.valueOf(amplitude.getID()) });
        db.close();
    }
 
 
    public int getAmplitudesCount() {
        String countQuery = "SELECT  * FROM " + TABLE_AMPLITUDE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
 
        // return count
        return cursor.getCount();
    }
 
}