package dbfileorga;

public class MitgliederDBUnsorted extends MitgliederDB{

    public MitgliederDBUnsorted(){
        super(false);
    }

    /**
     * Inserts a Record at the first free space.
     * @param record
     * @return
     */
    @Override
    public int insert(Record record) {
        if (findPos(record.getAttribute(1)) == -1)
            for (DBBlock dbBlock : db)
                if (dbBlock.insertRecordAtTheEnd(record) != -1)
                    return findPos(record.getAttribute(1));

        return -1;
    }
}
