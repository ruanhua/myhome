package cn.com.ulic.op.id;

public interface EntityIdGenerator {
    public long generateLongId() throws InvalidSystemClockException, GetHardwareIdFailedException;

    public String generateLongIdString() throws InvalidSystemClockException, GetHardwareIdFailedException;
}