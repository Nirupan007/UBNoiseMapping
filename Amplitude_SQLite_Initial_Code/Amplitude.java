 
public class Amplitude {
     
    //private variables
    int _id;
	int _ampval;
    float _lat;
    float _longt;
     
    // Empty constructor
    public Amplitude(){
         
    }
    // constructor
    public Amplitude(int id, int ampval, float lat, float longt){
        this._id = id;
		this._ampval = ampval;
        this._lat = lat;
        this._longt = longt;
    }
     
    // constructor
    public Amplitude(int id, int ampval, float lat, float longt){
        this._ampval = ampval;
		this._lat = lat;
        this._longt = longt;
    }
    // getting ID
    public int getID(){
        return this._id;
    }
     
    // setting id
    public void setID(int id){
        this._id = id;
    }
     
    // getting ampval
    public int getAmpval(){
        return this._ampval;
    }
     
    // setting ampval
    public void setAmpval(int ampval){
        this._ampval = ampval;
    }
     
    // getting lat
    public float getLat(){
        return this._lat;
    }
     
    // setting phone number
    public void setLat(int lat){
        this._lat = lat;
    }
	
	
    // getting long
    public float getLongt(){
        return this._longt;
    }
     
    // setting phone number
    public void setLongt(int longt){
        this._longt = longt;
    }
}