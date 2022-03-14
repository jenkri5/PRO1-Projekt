package yahtzee;

import org.apache.commons.lang3.RandomUtils;

public class Die {

    private final RandomUtils m_randomUtils = new RandomUtils();
    private final int m_faceCount = 6;
    private int m_faceValue;
    private boolean m_isLocked = false;

    public int getFaceValue() {
        return m_faceValue;
    }

    public void setLocked() {
        m_isLocked = !m_isLocked;
    }

    public boolean isLocked() {
        return m_isLocked;
    }

    public void roll() {
        this.m_faceValue = m_randomUtils.nextInt(0, m_faceCount)+1;
    }

}
