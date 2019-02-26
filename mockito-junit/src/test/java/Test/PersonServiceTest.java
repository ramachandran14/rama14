package Test;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import model.PojoServicePerson;

public class PersonServiceTest {

    @InjectMocks
    private PojoServicePerson pojoperson;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

@Test
public void read() {

    int id = 1;
    assertequals(id, pojoperson.getId());
}

private void assertequals(int id, long l) {

}
}
