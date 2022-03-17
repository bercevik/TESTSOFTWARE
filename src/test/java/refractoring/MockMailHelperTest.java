package refractoring;

import cz.cvut.fel.ts1.refractoring.DBManager;
import cz.cvut.fel.ts1.refractoring.MailHelper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MockMailHelperTest {
    DBManager mockDBManager = Mockito.mock(DBManager.class);
    MailHelper mailHelper = new MailHelper(mockDBManager);

    @Test
    public void mockTest() {
        mailHelper.sendMail(1);
        Mockito.verify(mockDBManager).findMail(1);
    }

    @Test
    public void negativeMockTest() {
        mailHelper.sendMail(1);
        Mockito.verify(mockDBManager, Mockito.times(2)).findMail(1);
    }
}
