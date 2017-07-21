package edu.stu.tool;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import javax.xml.bind.*;

public class XmlUtil {
	
    public static String convert2XML(Object object) {
      Writer w = new StringWriter();
      try {
    	JAXBContext context = JAXBContext.newInstance(object.getClass());
    	Marshaller marshaller = context.createMarshaller();
    	marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
    	marshaller.marshal(context, w);
      } catch(JAXBException e) {
    	  e.printStackTrace();
      } finally {
    	  if ( w != null ) {
    		  try {
    			  w.close();
    		  } catch(IOException e) {
    			  e.printStackTrace();
    		  }
    	  }
      }
      
      return w.toString();
    }
    
}
