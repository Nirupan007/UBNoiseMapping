

  // [{
   // {
     // "id": 912345678901,
     // "amplitude": "100",
     // "lat": 42.24314,
	//  "longt": -78.414135
     //},
   // {
     // "id": 912345678902,
     // "amplitude": 90,
     // "lat": 42.22314,
	//  "longt": -78.714135
     // }
 // ]}
 
 
public List readJsonStream(InputStream in) throws IOException {
     JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
     try {
       return readMessagesArray(reader);
      finally {
       reader.close();
     }
   }

   public List readMessagesArray(JsonReader reader) throws IOException {
     List messages = new ArrayList();

     reader.beginArray();
     while (reader.hasNext()) {
       messages.add(readMessage(reader));
     }
     reader.endArray();
     return messages;
   }

   public Message readMessage(JsonReader reader) throws IOException {
     long id = -1;
	 long amplitude = -1;
	 float lat = -1.0;
	 float longt = -1.0;
	 
     reader.beginObject();
     while (reader.hasNext()) {
       String name = reader.nextName();
       if (name.equals("id")) {
         id = reader.nextLong();
       } else if (name.equals("amplitude")) {
         text = reader.nextLong();
       } else if (name.equals("lat")) {
         text = reader.nextFloat();
		 else if (name.equals("longt")) {
         text = reader.nextFloat();
       } else {
         reader.skipValue();
       }
     }
     reader.endObject();
     return new Message(id, amplitude, lat, longt);
   }

   public List readDoublesArray(JsonReader reader) throws IOException {
     List doubles = new ArrayList();

     reader.beginArray();
     while (reader.hasNext()) {
       doubles.add(reader.nextDouble());
     }
     reader.endArray();
     return doubles;
   }

   }