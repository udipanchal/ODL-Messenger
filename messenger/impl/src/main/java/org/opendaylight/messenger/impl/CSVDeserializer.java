package org.opendaylight.messenger.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.HashMap;

import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ParseDouble;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.constraint.StrMinMax;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.prefs.CsvPreference;

import com.google.gson.Gson;

public class CSVDeserializer
{

    private String[] header;
    private CellProcessor[] processors;
    private CsvBeanReader reader;
    private Map<String, Element> mapOfNameAndElement;

    private static final String JSONFILEPATH = System.getProperty("user.dir") + "/src/main/resources/Elements.json";
    private static final String XMLFILEPATH = System.getProperty("user.dir") + "/src/main/resources/Elements.xml";
    private static final String CSVFILEPATH = System.getProperty("user.dir") + "/src/main/resources/PeriodicTableofElements.csv";
    private static final int BUFFERSIZE = 8096;

    private static final Logger LOG = LoggerFactory.getLogger(CSVDeserializer.class);

    public void perform() throws IOException
    {

        Element element;
        mapOfNameAndElement = new HashMap<>();
        
        initializeCsvDeserializer();
        while ((element = reader.read(Element.class, header, processors)) != null)
        {
            LOG.info(element.getElement());
            mapOfNameAndElement.put(element.getElement(), element);
        }

        deserializeToJson(new Elements().setElements((Element[]) mapOfNameAndElement.values().toArray(new Element[0])), JSONFILEPATH);
        deserializeToXML(new Elements().setElements((Element[]) mapOfNameAndElement.values().toArray(new Element[0])), XMLFILEPATH);
        
        reader.close();
    }
    
    public Map<String, Element> getElements()
    {
    	return this.mapOfNameAndElement;
    }

    private void deserializeToJson(Elements elements, String filePath)
    {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath), BUFFERSIZE))
        {
            new Gson().toJson(elements, bw);
        }
        catch (IOException e)
        {
            LOG.debug("Error while deserializing Object to JSON file", e);
        }
    }

    private void deserializeToXML(Elements elements, String filePath)
    {
        try
        {
            File file = new File(filePath);
            JAXBContext jaxbContext = JAXBContext.newInstance(Elements.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(elements, file);
        }
        catch (JAXBException e)
        {
            LOG.debug("Error while deserializing Object to XML file", e);
        }
    }

    private void initializeCsvDeserializer() throws IOException
    {
    	reader = new CsvBeanReader(new FileReader(CSVFILEPATH), CsvPreference.STANDARD_PREFERENCE);
        header = reader.getHeader(true);
        processors = new CellProcessor[]
        { new Optional(new ParseInt()), new Optional(new StrMinMax(0, 100)), new Optional(new StrMinMax(0, 100)), new Optional(new ParseDouble()), new Optional(new ParseInt()), new Optional(new ParseInt()), new Optional(new StrMinMax(0, 100)), new Optional(new StrMinMax(0, 100)), new Optional(new StrMinMax(0, 100)), new Optional(new ParseDouble()), new Optional(new ParseDouble()), new Optional(new ParseDouble()), new Optional(new ParseDouble()), new Optional(new ParseDouble()), new Optional(new ParseDouble()), new Optional(new ParseDouble()), new Optional(new ParseInt()), new Optional(new StrMinMax(0, 100)), new Optional(new ParseInt()), new Optional(new ParseDouble()), new Optional(new StrMinMax(0, 100)), new Optional(new ParseInt()), new Optional(new ParseInt()) };
    }
}
