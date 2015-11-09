package com.mulesoft.raml1.java.patser.test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.model.api.Api;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * TODO: write tests
 */
public class XKCDTest
{

    private static Api api;

    @BeforeClass
    public static void beforeClass() throws URISyntaxException, IOException
    {
        final File file = Paths.get(Raml1Test.class.getResource("/XKCD/api.raml").toURI()).toFile();
        api = new JavaNodeFactory().createApi(file.getCanonicalPath());

        System.out.println(api.toJSON());
    }

    @Test
    public void properties()
    {
        assertThat(api.version(), nullValue());
        assertThat(api.baseUri().value(), is("http://xkcd.com"));
        assertThat(api.title(), is("XKCD"));
    }

}
