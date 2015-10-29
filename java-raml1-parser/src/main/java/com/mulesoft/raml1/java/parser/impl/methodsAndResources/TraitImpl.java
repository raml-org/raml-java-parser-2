package com.mulesoft.raml1.java.parser.impl.methodsAndResources;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import com.mulesoft.raml1.java.parser.core.JavaNodeFactory;
import com.mulesoft.raml1.java.parser.model.methodsAndResources.Trait;
import com.mulesoft.raml1.java.parser.model.api.Library;
import com.mulesoft.raml1.java.parser.impl.api.LibraryImpl;



public class TraitImpl extends MethodBaseImpl implements Trait {

    public TraitImpl(Object jsNode, JavaNodeFactory factory){
        super(jsNode,factory);
    }

    protected TraitImpl(){
        super();
    }


    @XmlElement(name="name")
    public String name(){
        return super.getAttribute("name", String.class);
    }


    @XmlElement(name="usage")
    public String usage(){
        return super.getAttribute("usage", String.class);
    }


    @XmlElement(name="uses")
    public List<Library> uses(){
        return super.getElements("uses", LibraryImpl.class);
    }
}