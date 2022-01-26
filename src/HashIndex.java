import java.util.HashMap;

public class HashIndex {
    private HashMap<Integer, String> hm;

    protected HashIndex(){
        hm = new HashMap<Integer, String>();
    }

    // Stores record ID and file ID
    // Format: fileID:recordID
    protected void add(int randomV, String fileAndRecordID){
        // If already in hashmap, insert record
        if(hm.containsKey(randomV)){
            // Check for presence of ":"
            if(hm.get(randomV).contains(fileAndRecordID.substring(0, 3))){
                String record = hm.get(randomV);
                int index = record.indexOf(fileAndRecordID.substring(0, 3));
                record = record.substring(0, index + 3) + fileAndRecordID.substring(3) + "," + record.substring(index + 3);

                // Insert updated record
                hm.replace(randomV, record);
            } else hm.replace(randomV, hm.get(randomV) + ";" + fileAndRecordID);
        } else hm.put(randomV, fileAndRecordID);
    }

    // Print records given a randomV value
    public void read(int randomV){
        // If hashmap does not contain key, say so
        if(!hm.containsKey(randomV)) System.out.println("No records found for randomV of " + randomV + "\nNo I/Os performed");
        else DBReader.printRecord(hm.get(randomV));
    }
}
