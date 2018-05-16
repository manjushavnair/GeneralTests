package com.test;


import com.db.Db;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.mockito.Mockito.*;

public class DbTest {
    Db n;
    Map<String, ?> params;

    @Before
    public void setup() {
	/*Store mk= mock(Store.class);
	when(mk.remove(params)).thenReturn(true);
	n=new Db();
	n.setRs(mk);
	*/

    }

    @Test
    public void testRemove() {
        Assert.assertEquals(true, n.remove(params));
    }
}