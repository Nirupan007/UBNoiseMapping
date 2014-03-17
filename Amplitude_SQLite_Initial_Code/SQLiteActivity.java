
 
public class SQLiteActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
         
        DatabaseHandler db = new DatabaseHandler(this);
         
        /**
         * CRUD Operations
         * */
        // Inserting Contacts
        Log.d("Insert: ", "Inserting .."); 
        db.addAmplitude(new Contact("100", "40.33232","-78.55324"));        
        db.addAmplitude(new Contact("110", "40.33232","-78.65324"));
        db.addAmplitude(new Contact("90", "40.73232","-78.55324"));
        db.addAmplitude(new Contact("120", "41.23232","-78.55324"));
         
        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts.."); 
        List<Amplitude> amps = db.getAllAmplitudes();       
         
        for (Amplitude amp : amps) {
            String log = "Id: "+amp.getID()+" ,Amp: " + amp.getAmplitude() + " ,Lat: " + amp.getLat()+ " ,Longt: " + amp.getLongt();
                // Writing Contacts to log
        Log.d("Name: ", log);
    }
    }
}