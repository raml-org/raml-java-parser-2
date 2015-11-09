package com.mulesoft.raml1.java.patser.test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.model.api.Api;
import com.mulesoft.raml1.java.parser.model.datamodel.DataElement;
import com.mulesoft.raml1.java.parser.model.datamodel.ObjectField;
import com.mulesoft.raml1.java.parser.model.datamodel.RAMLPointerElement;
import com.mulesoft.raml1.java.parser.model.declarations.AnnotationType;
import com.mulesoft.raml1.java.parser.model.methodsAndResources.Method;
import com.mulesoft.raml1.java.parser.model.methodsAndResources.Resource;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class Raml1Test
{

    private static Api api;

    @BeforeClass
    public static void beforeClass() throws URISyntaxException, IOException
    {
        final File file = Paths.get(Raml1Test.class.getResource("/raml1.raml").toURI()).toFile();
        api = new JavaNodeFactory().createApi(file.getCanonicalPath());

        System.out.println(api.toJSON());
    }

    @Test
    public void properties()
    {
        assertThat(api.version(), is("v1.0"));
        assertThat(api.baseUri().value(), is("https://www.example.com/{version}"));
        assertThat(api.title(), is("Samle API"));
    }

    @Test
    public void exmapleResource() throws IOException, URISyntaxException
    {
        final Resource resource = api.resources().get(0);
        assertThat(resource.relativeUri().value(), is("/exmaple-collection"));
        assertThat(resource.methods().size(), is(1));

        final Method get = resource.methods().get(0);
        assertThat(get.method(), is("get"));

        assertBody(get);

        // TODO: How do I get annotation properties?
        assertThat(get.annotations().size(), is(1));
    }

    private void assertBody(Method get)
    {
        final DataElement body = get.body().get(0);
        assertThat(body.name(), is("application/x-www-form-urlencoded"));
        assertThat(body instanceof ObjectField, is(true));
        final List<DataElement> bodyProperties = ((ObjectField) body).properties();
        assertThat(bodyProperties.size(), is(2));

        assertThat(bodyProperties.get(0).name(), is("limit"));
        assertThat(bodyProperties.get(0).description().value(), is("Pagination parameter. Maximal size of the results array."));
        assertThat(bodyProperties.get(0).type().get(0), is("integer"));

        assertThat(bodyProperties.get(1).name(), is("skip"));
        assertThat(bodyProperties.get(1).description().value(), is("Pagination parameter. Offset used to form the results array."));
        assertThat(bodyProperties.get(1).type().get(0), is("integer"));
    }

    @Test
    public void annotationTypes()
    {
        assertThat(api.annotationTypes().size(), is(1));
        final AnnotationType typePaging = api.annotationTypes().get(0);
        assertThat(typePaging.allowedTargets().size(), is(1));
        assertThat(typePaging.allowedTargets().get(0).value(), is("method"));
        assertThat(typePaging.parameters().size(), is(2));

        annotationType((RAMLPointerElement) typePaging.parameters().get(0), "page-size",
                       Collections.singletonList("pointer"),
                       "*.DataElement");
        annotationType((RAMLPointerElement) typePaging.parameters().get(1), "offset",
                       Collections.singletonList("pointer"),
                       "*.DataElement");
    }

    private void annotationType(final RAMLPointerElement annotationType, String name, List<String> expectedTypes, String target)
    {
        assertThat(annotationType.name(), is(name));
        assertThat(annotationType.type().size(), is(expectedTypes.size()));
        assertThat(annotationType.type(), is(expectedTypes));

        // TODO (https://github.com/raml-org/raml-java-parser-2/issues/3): target attribute returns empty
        //assertThat(annotationType.target().value(), is(target));
    }


}
