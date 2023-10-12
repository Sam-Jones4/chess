package chess;

import java.util.Objects;

public class ChessPositionImpl implements ChessPosition
{
    private int rowNum;
    private int columnNum;

    public ChessPositionImpl(int rowNum, int columnNum)
    {
        this.rowNum = rowNum;
        this.columnNum = columnNum;
    }


    @Override
    public int getRow()
    {
        return rowNum;
    }

    @Override
    public int getColumn()
    {
        return columnNum;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChessPositionImpl that = (ChessPositionImpl) o;
        return rowNum == that.rowNum && columnNum == that.columnNum;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(rowNum, columnNum);
    }

    @Override
    public String toString() {
        return "ChessPositionImpl{" +
                "rowNum=" + rowNum +
                ", columnNum=" + columnNum +
                '}';
    }
}
