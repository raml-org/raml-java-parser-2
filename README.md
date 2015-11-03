# Java RAML 1.0 Parser <sup>(beta)</sup>

See http://raml.org for more information about RAML.

This parser is at a beta state of development, as part of the API Workbench development cycle (http://apiworkbench.com).

## About
The parser makes use of Webpack bundled Javascript RAML parser via the Nashorn scripting engine (thus, you must USE JDK1.8).

## Using the parser
First you have to create an `Api` instance:
``` java
import java.io.File;

import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.model.api.Api;

public class Launcher {
	
	public static void main(String[] args) {
		JavaNodeFactory factory = new JavaNodeFactory();
		Api api = factory.createApi(/*Location of the APIs main .raml file*/);
	}
}
```
After the `Api` instance is created, you may reach any part of the RAML document.

There are two operations related to data reading used by the parser:

* read file content
* list files of particular directory
 
By default these operations are delegated to the file system. You can force the parser to use your custom class by passing its instance to `JavaNodeFactory.setPathResolver()` as argument:
``` java
JavaNodeFactory f = new JavaNodeFactory();
f.setPathResolver(new IJavaPathResolver() {

	public List<String> list(String path) {
		// TODO Implement your method here
	}
			
	public String content(String path) {
		// TODO Implement your method here
	}
});
Api api = f.createApi(/*Location of the APIs main .raml file*/);
```

## Dealing with user types in RAML 1.0
Some parts of RAML 1.0 API are described by user types and, thus, can not be implemented as Java classes of the parser project. These are Resource Type, Trait and Annotation references.

Consider an example of annotation usecase:
``` yaml
#%RAML 1.0
title: Samle API
version: v1.0
baseUri: https://www.example.com/{version}
annotationTypes:
  - paging:
      allowedTargets: method
      parameters:
        pageSize:
          type: pointer
          target: *.DataElement
        offset:
          type: pointer
          target: *.DataElement
/example-collection:
  get:
    annotations:
      - paging:
          pageSize: application/x-www-form-urlencoded.limit
          offset: application/x-www-form-urlencoded.skip
    body:
      application/x-www-form-urlencoded:
        properties:
          limit:
            description: Pagination parameter. Maximal size of the results array.
            type: integer
          skip:
            description: Pagination parameter. Offset used to form the results array.
            type: integer
```
When the parser meets the annotation reference
```yaml
paging:
  pageSize: application/x-www-form-urlencoded.limit
  offset: application/x-www-form-urlencoded.skip
```
it generates the following class:
``` java
import avax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.CustomType;

public class paging extends CustomType{

    @XmlElement(name="pageSize")
    public String pageSize;


    @XmlElement(name="offset")
    public String offset;

}
```
Then it creates the class instance, populates it by means of JAXB unmarshaller and returns it as the result.
The key of the reference (which is `paging` in our example) is stored in the `valueName` private field of the `CustomType` class. The field is provided with public getter.


### Creating libraries for user types
The parser is capable of detecting user type implementations. There are several requirements for implementation classes and projects which provide them:

* Implementation class must be a JAXB bean and extend `CustomType`.

* Each package with implementation classes must contain and expose on classpath two files: `jaxb.index` (see [format for jaxb.index](https://jaxb.java.net/nonav/2.2.1/docs/api/javax/xml/bind/JAXBContext.html#newInstance(java.lang.String, java.lang.ClassLoader))) enumerating all the implementation classes and `jaxb.properties` with the following content:
```
javax.xml.bind.context.factory=org.eclipse.persistence.jaxb.JAXBContextFactory
```

* The project on its classpath must provide a `customClassesPackages.txt` file containing a list of implementation classes packages separated by new line.

