import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.opendaylight.messenger.impl.CSVDeserializer;
import org.opendaylight.messenger.impl.Element;
import org.supercsv.io.CsvBeanReader;

@RunWith (MockitoJUnitRunner.class)
public class CSVDeserializerTest 
{
	@Spy
	@InjectMocks
	CSVDeserializer deserializer;
	
	@Mock
	JAXBContext jaxbContext;
	
	@Mock
	CsvBeanReader reader;
	
	@Test
	public void execute_performTask_shouldReturnMapElement() throws IOException 
	{
		//when
		deserializer.perform();
		
		//then
		Map<String, Element> mapOfStringAndElement = deserializer.getElements();
		
		verify(deserializer, times(1)).perform();
		verify(deserializer, times(1)).getElements();
		assertThat(mapOfStringAndElement, notNullValue());
	}
	
	@Test
	public void execute_performTask_shouldThrowException() throws JAXBException, IOException
	{	
		Marshaller marshaller = Mockito.mock(Marshaller.class);
		Mockito.doThrow(new JAXBException("Error"))
	       .when(marshaller)
	       .marshal(Mockito.any(Object.class), Mockito.any(File.class));
		
		//when
		deserializer.perform();
	}
}
