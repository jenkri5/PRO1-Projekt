package yahtzee;

import org.apache.commons.lang3.RandomUtils;

public class Die {

    private final int m_FaceCount;
    private int m_FaceValue;
    private boolean m_IsLocked = false;
    
    public Die() {
    	m_FaceCount = 6;
    }
    
    public Die(int faceCount) {
    	m_FaceCount = faceCount;
    }

    public int getFaceValue() {
        return m_FaceValue;
    }

    public void setLocked() {
        m_IsLocked = !m_IsLocked;
    }

    public boolean isLocked() {
        return m_IsLocked;
    }

    public void roll() {
        this.m_FaceValue = RandomUtils.nextInt(0, m_FaceCount)+1;
    }
    
}
