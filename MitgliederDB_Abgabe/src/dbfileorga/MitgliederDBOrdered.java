package dbfileorga;

import java.util.Iterator;
import static java.lang.Integer.parseInt;

public class MitgliederDBOrdered extends MitgliederDB {
    public MitgliederDBOrdered() {
        super(true);
    }

    /**
     * Inserts the record a the specified spot
     * @param record
     * @return
     */
    @Override
    public int insert(Record record) {
        if(record == null) return -1;
        if (findPos(record.getAttribute(1)) == -1)
            if (db_operation('i', findInsertPos(record), record) != -1)
                return findPos(record.getAttribute(1));

        return -1;

    }

    /**
     * Finds the current position of
     * @param record
     * @return
     */
    private int findInsertPos(Record record) {
        Iterator<Record> dbIterator = iterator();
        int RecNumInt = Integer.parseInt(record.getAttribute(1));
        String currRecNum;
        while(dbIterator.hasNext()) {
            currRecNum = dbIterator.next().getAttribute(1);
            if( parseInt(currRecNum) > RecNumInt )
                return findPos(currRecNum);
        }
        return this.getNumberOfRecords() + 1;
    }
}
