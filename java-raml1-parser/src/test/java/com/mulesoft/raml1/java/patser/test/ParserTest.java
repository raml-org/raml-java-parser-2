package com.mulesoft.raml1.java.patser.test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.model.api.Api;
import com.mulesoft.raml1.java.parser.model.datamodel.DataElement;
import com.mulesoft.raml1.java.parser.model.datamodel.ObjectField;
import com.mulesoft.raml1.java.parser.model.declarations.AnnotationType;
import com.mulesoft.raml1.java.parser.model.methodsAndResources.Method;
import com.mulesoft.raml1.java.parser.model.methodsAndResources.Resource;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

import org.junit.Test;

public class ParserTest
{

    @Test
    public void exampleRamlTest() throws IOException, URISyntaxException
    {
        final JavaNodeFactory factory = new JavaNodeFactory();

        final URL raml = Launcher.class.getResource("/raml1.raml");
        final File file = Paths.get(raml.toURI()).toFile();

        final Api api = factory.createApi(file.getCanonicalPath());

        System.out.println(api.toJSON());

        assertThat(api.version(), is("v1.0"));
        assertThat(api.baseUri().value(), is("https://www.example.com/{version}"));
        assertThat(api.title(), is("Samle API"));

        /////////// annotation types /////////
        assertThat(api.annotationTypes().size(), is(1));
        final AnnotationType typePaging = api.annotationTypes().get(0);
        assertThat(typePaging.allowedTargets().size(), is(1));
        assertThat(typePaging.allowedTargets().get(0).value(), is("method"));
        assertThat(typePaging.parameters().size(), is(2));

        final DataElement pageSize = typePaging.parameters().get(0);
        assertThat(pageSize.name(), is("pageSize"));
        assertThat(pageSize.type().size(), is(1));
        assertThat(pageSize.type().get(0), is("pointer"));

        // TODO: MISSING target attribute

        final DataElement offset = typePaging.parameters().get(1);
        assertThat(offset.name(), is("offset"));
        assertThat(offset.type().size(), is(1));
        assertThat(offset.type().get(0), is("pointer"));

        /////// RESOURCES ////////
        final Resource resource = api.resources().get(0);
        assertThat(resource.methods().size(), is(1));

        // GET method
        final Method get = resource.methods().get(0);
        assertThat(get.method(), is("get"));

        // Body
        DataElement body = get.body().get(0);
		assertThat(body.name(), is("application/x-www-form-urlencoded"));
		assertThat(body instanceof ObjectField, is(true));		
		assertThat(((ObjectField)body).properties().size(),is(2));

        assertThat(get.annotations().size(), is(1));
    }
}
