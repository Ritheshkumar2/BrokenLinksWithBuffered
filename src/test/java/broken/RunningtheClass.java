package broken;

import java.io.IOException;

import org.testng.annotations.Test;

@Test
public class RunningtheClass {
	
	public void test() throws IOException {
		BROKENLinks object=new BROKENLinks();
		object.validation();
	}

}
