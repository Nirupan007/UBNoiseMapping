//Main Activity code for Multiple Intents for
1- Amplitude
2- Loc
3- Json


// At Amplitude Activity

double amp;

Intent intent = new Intent();
            intent.putExtra("amp", amp);
            setResult(2, intent);

// At GPSLocApp Activity

double lat;
double longt;


Intent intent = new Intent();
            intent.putExtra("lat", lat);
			intent.putExtra("longt", longt);
			setResult(2, intent);

			

			
			//Main Activity
public class MainActivityNoise extends Activity implements OnClickListener {


Button amp, gpsval, json;
	TextView area;

double lat;
double longt;
double amp;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		amp = (Button) findViewById(R.id.button1);
		gpsval = (Button) findViewById(R.id.button2);
		json = (Button) findViewById(R.id.button3);
		//area = (TextView) findViewById(R.id.textView1);

		amp.setOnClickListener(this);
		gpsval.setOnClickListener(this);
		json.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent i = new Intent(this, Numbers.class);
		switch (v.getId()) {
		case R.id.button1:
			//i.putExtra("numbers", "amp");

			startActivityAmp;
			break;
		case R.id.button2:
			//i.putExtra("numbers", "height");
			startActivityForResultGPSLocApp;
			break;
		case R.id.button3:
			// calc
			/* int a = Integer.valueOf(width.getText().toString());
			int b = Integer.valueOf(height.getText().toString());
			area.setText(a*b+" sq ft");
			 */
			Intent igps = new Intent();
			intent.putExtra("amp", amp);
			intent.putExtra("lat", lat);
			intent.putExtra("longt", longt);
			//setResult(2, intent);

			startActivityForResultGPSLocApp(igps);
		    break;

		default:
			break;
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(data.getExtras().containsKey("ampInfo")){
			Bundle extras = getIntent().getExtras();
			amp = extras.getDouble("amp");
		}
		if(data.getExtras().containsKey("gpsInfo")){
			Bundle extras = getIntent().getExtras();
			lat = extras.getDouble("lat");
			longt = extras.getDouble("longt");

			}
	}

}




//On JSON Activity upon receiving the intent
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(data.getExtras().containsKey("jsonInfo")){
			Bundle extras = getIntent().getExtras();
			amp = extras.getDouble("amp");
	
			lat = extras.getDouble("lat");
			longt = extras.getDouble("longt");

			}
	}




