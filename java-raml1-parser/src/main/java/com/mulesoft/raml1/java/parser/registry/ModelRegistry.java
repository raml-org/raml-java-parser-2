package com.mulesoft.raml1.java.parser.registry;

import java.util.HashMap;

public class ModelRegistry {

    protected static ModelRegistry instance;

    public static ModelRegistry getInstance(){
        if(instance==null){
            instance = new ModelRegistry();
        }
        return instance;
    }


    protected ModelRegistry(){
        this.init();
    }

    public String rootPackage(){
        return "com.mulesoft.raml1.java.parser";
    }

    protected HashMap<String,String> packageMap;

    @SuppressWarnings("unchecked")
	public <S> Class<? extends S> getModelClass(String simpleName, Class<S> clazz){
        String pkg = this.packageMap.get(simpleName);
        if(pkg==null){
            return null;
        }
        String qualifiedName = pkg + "." + simpleName;
        try {
            Class<?> result = this.getClass().getClassLoader().loadClass(qualifiedName);
            if(result!=null && clazz.isAssignableFrom(result)){
            	return (Class<? extends S>) result;
            }
        }
        catch(Exception e){}

        return null;
    }

    protected void init(){

        this.packageMap = new HashMap<String,String>();

        this.packageMap.put( "RAMLLanguageElement", "com.mulesoft.raml1.java.parser.model.common" );

        this.packageMap.put( "RAMLLanguageElementImpl", "com.mulesoft.raml1.java.parser.impl.common" );

        this.packageMap.put( "ValueType", "com.mulesoft.raml1.java.parser.model.systemTypes" );

        this.packageMap.put( "ValueTypeImpl", "com.mulesoft.raml1.java.parser.impl.systemTypes" );

        this.packageMap.put( "NumberType", "com.mulesoft.raml1.java.parser.model.systemTypes" );

        this.packageMap.put( "NumberTypeImpl", "com.mulesoft.raml1.java.parser.impl.systemTypes" );

        this.packageMap.put( "BooleanType", "com.mulesoft.raml1.java.parser.model.systemTypes" );

        this.packageMap.put( "BooleanTypeImpl", "com.mulesoft.raml1.java.parser.impl.systemTypes" );

        this.packageMap.put( "Reference", "com.mulesoft.raml1.java.parser.model.systemTypes" );

        this.packageMap.put( "ReferenceImpl", "com.mulesoft.raml1.java.parser.impl.systemTypes" );

        this.packageMap.put( "ResourceTypeRef", "com.mulesoft.raml1.java.parser.model.methodsAndResources" );

        this.packageMap.put( "ResourceTypeRefImpl", "com.mulesoft.raml1.java.parser.impl.methodsAndResources" );

        this.packageMap.put( "TraitRef", "com.mulesoft.raml1.java.parser.model.methodsAndResources" );

        this.packageMap.put( "TraitRefImpl", "com.mulesoft.raml1.java.parser.impl.methodsAndResources" );

        this.packageMap.put( "SecuritySchemaRef", "com.mulesoft.raml1.java.parser.model.methodsAndResources" );

        this.packageMap.put( "SecuritySchemaRefImpl", "com.mulesoft.raml1.java.parser.impl.methodsAndResources" );

        this.packageMap.put( "AnnotationRef", "com.mulesoft.raml1.java.parser.model.declarations" );

        this.packageMap.put( "AnnotationRefImpl", "com.mulesoft.raml1.java.parser.impl.declarations" );

        this.packageMap.put( "DataElementRef", "com.mulesoft.raml1.java.parser.model.datamodel" );

        this.packageMap.put( "DataElementRefImpl", "com.mulesoft.raml1.java.parser.impl.datamodel" );

        this.packageMap.put( "ramlexpression", "com.mulesoft.raml1.java.parser.model.systemTypes" );

        this.packageMap.put( "ramlexpressionImpl", "com.mulesoft.raml1.java.parser.impl.systemTypes" );

        this.packageMap.put( "AnnotationTarget", "com.mulesoft.raml1.java.parser.model.declarations" );

        this.packageMap.put( "AnnotationTargetImpl", "com.mulesoft.raml1.java.parser.impl.declarations" );

        this.packageMap.put( "pointer", "com.mulesoft.raml1.java.parser.model.datamodel" );

        this.packageMap.put( "pointerImpl", "com.mulesoft.raml1.java.parser.impl.datamodel" );

        this.packageMap.put( "StringType", "com.mulesoft.raml1.java.parser.model.systemTypes" );

        this.packageMap.put( "StringTypeImpl", "com.mulesoft.raml1.java.parser.impl.systemTypes" );

        this.packageMap.put( "UriTemplate", "com.mulesoft.raml1.java.parser.model.systemTypes" );

        this.packageMap.put( "UriTemplateImpl", "com.mulesoft.raml1.java.parser.impl.systemTypes" );

        this.packageMap.put( "RelativeUri", "com.mulesoft.raml1.java.parser.model.systemTypes" );

        this.packageMap.put( "RelativeUriImpl", "com.mulesoft.raml1.java.parser.impl.systemTypes" );

        this.packageMap.put( "FullUriTemplate", "com.mulesoft.raml1.java.parser.model.systemTypes" );

        this.packageMap.put( "FullUriTemplateImpl", "com.mulesoft.raml1.java.parser.impl.systemTypes" );

        this.packageMap.put( "StatusCode", "com.mulesoft.raml1.java.parser.model.systemTypes" );

        this.packageMap.put( "StatusCodeImpl", "com.mulesoft.raml1.java.parser.impl.systemTypes" );

        this.packageMap.put( "FixedUri", "com.mulesoft.raml1.java.parser.model.systemTypes" );

        this.packageMap.put( "FixedUriImpl", "com.mulesoft.raml1.java.parser.impl.systemTypes" );

        this.packageMap.put( "ContentType", "com.mulesoft.raml1.java.parser.model.systemTypes" );

        this.packageMap.put( "ContentTypeImpl", "com.mulesoft.raml1.java.parser.impl.systemTypes" );

        this.packageMap.put( "ValidityExpression", "com.mulesoft.raml1.java.parser.model.systemTypes" );

        this.packageMap.put( "ValidityExpressionImpl", "com.mulesoft.raml1.java.parser.impl.systemTypes" );

        this.packageMap.put( "DateFormatSpec", "com.mulesoft.raml1.java.parser.model.systemTypes" );

        this.packageMap.put( "DateFormatSpecImpl", "com.mulesoft.raml1.java.parser.impl.systemTypes" );

        this.packageMap.put( "FunctionalInterface", "com.mulesoft.raml1.java.parser.model.systemTypes" );

        this.packageMap.put( "FunctionalInterfaceImpl", "com.mulesoft.raml1.java.parser.impl.systemTypes" );

        this.packageMap.put( "SchemaString", "com.mulesoft.raml1.java.parser.model.systemTypes" );

        this.packageMap.put( "SchemaStringImpl", "com.mulesoft.raml1.java.parser.impl.systemTypes" );

        this.packageMap.put( "JSonSchemaString", "com.mulesoft.raml1.java.parser.model.systemTypes" );

        this.packageMap.put( "JSonSchemaStringImpl", "com.mulesoft.raml1.java.parser.impl.systemTypes" );

        this.packageMap.put( "XMLSchemaString", "com.mulesoft.raml1.java.parser.model.systemTypes" );

        this.packageMap.put( "XMLSchemaStringImpl", "com.mulesoft.raml1.java.parser.impl.systemTypes" );

        this.packageMap.put( "ExampleString", "com.mulesoft.raml1.java.parser.model.systemTypes" );

        this.packageMap.put( "ExampleStringImpl", "com.mulesoft.raml1.java.parser.impl.systemTypes" );

        this.packageMap.put( "ScriptingHook", "com.mulesoft.raml1.java.parser.model.systemTypes" );

        this.packageMap.put( "ScriptingHookImpl", "com.mulesoft.raml1.java.parser.impl.systemTypes" );

        this.packageMap.put( "SecuritySchemaHookScript", "com.mulesoft.raml1.java.parser.model.methodsAndResources" );

        this.packageMap.put( "SecuritySchemaHookScriptImpl", "com.mulesoft.raml1.java.parser.impl.methodsAndResources" );

        this.packageMap.put( "RAMLPointer", "com.mulesoft.raml1.java.parser.model.systemTypes" );

        this.packageMap.put( "RAMLPointerImpl", "com.mulesoft.raml1.java.parser.impl.systemTypes" );

        this.packageMap.put( "RAMLSelector", "com.mulesoft.raml1.java.parser.model.systemTypes" );

        this.packageMap.put( "RAMLSelectorImpl", "com.mulesoft.raml1.java.parser.impl.systemTypes" );

        this.packageMap.put( "MimeType", "com.mulesoft.raml1.java.parser.model.bodies" );

        this.packageMap.put( "MimeTypeImpl", "com.mulesoft.raml1.java.parser.impl.bodies" );

        this.packageMap.put( "MarkdownString", "com.mulesoft.raml1.java.parser.model.systemTypes" );

        this.packageMap.put( "MarkdownStringImpl", "com.mulesoft.raml1.java.parser.impl.systemTypes" );

        this.packageMap.put( "DocumentationItem", "com.mulesoft.raml1.java.parser.model.api" );

        this.packageMap.put( "DocumentationItemImpl", "com.mulesoft.raml1.java.parser.impl.api" );

        this.packageMap.put( "ScriptSpec", "com.mulesoft.raml1.java.parser.model.api" );

        this.packageMap.put( "ScriptSpecImpl", "com.mulesoft.raml1.java.parser.impl.api" );

        this.packageMap.put( "ApiDescription", "com.mulesoft.raml1.java.parser.model.api" );

        this.packageMap.put( "ApiDescriptionImpl", "com.mulesoft.raml1.java.parser.impl.api" );

        this.packageMap.put( "CallbackAPIDescription", "com.mulesoft.raml1.java.parser.model.api" );

        this.packageMap.put( "CallbackAPIDescriptionImpl", "com.mulesoft.raml1.java.parser.impl.api" );

        this.packageMap.put( "RAMLProject", "com.mulesoft.raml1.java.parser.model.api" );

        this.packageMap.put( "RAMLProjectImpl", "com.mulesoft.raml1.java.parser.impl.api" );

        this.packageMap.put( "SecuritySchemaType", "com.mulesoft.raml1.java.parser.model.methodsAndResources" );

        this.packageMap.put( "SecuritySchemaTypeImpl", "com.mulesoft.raml1.java.parser.impl.methodsAndResources" );

        this.packageMap.put( "DataElement", "com.mulesoft.raml1.java.parser.model.datamodel" );

        this.packageMap.put( "DataElementImpl", "com.mulesoft.raml1.java.parser.impl.datamodel" );

        this.packageMap.put( "ModelLocation", "com.mulesoft.raml1.java.parser.model.datamodel" );

        this.packageMap.put( "LocationKind", "com.mulesoft.raml1.java.parser.model.datamodel" );

        this.packageMap.put( "ExampleSpec", "com.mulesoft.raml1.java.parser.model.datamodel" );

        this.packageMap.put( "ExampleSpecImpl", "com.mulesoft.raml1.java.parser.impl.datamodel" );

        this.packageMap.put( "FileParameter", "com.mulesoft.raml1.java.parser.model.parameters" );

        this.packageMap.put( "FileParameterImpl", "com.mulesoft.raml1.java.parser.impl.parameters" );

        this.packageMap.put( "ArrayField", "com.mulesoft.raml1.java.parser.model.datamodel" );

        this.packageMap.put( "ArrayFieldImpl", "com.mulesoft.raml1.java.parser.impl.datamodel" );

        this.packageMap.put( "UnionField", "com.mulesoft.raml1.java.parser.model.datamodel" );

        this.packageMap.put( "UnionFieldImpl", "com.mulesoft.raml1.java.parser.impl.datamodel" );

        this.packageMap.put( "ObjectField", "com.mulesoft.raml1.java.parser.model.datamodel" );

        this.packageMap.put( "ObjectFieldImpl", "com.mulesoft.raml1.java.parser.impl.datamodel" );

        this.packageMap.put( "StrElement", "com.mulesoft.raml1.java.parser.model.datamodel" );

        this.packageMap.put( "StrElementImpl", "com.mulesoft.raml1.java.parser.impl.datamodel" );

        this.packageMap.put( "BooleanElement", "com.mulesoft.raml1.java.parser.model.datamodel" );

        this.packageMap.put( "BooleanElementImpl", "com.mulesoft.raml1.java.parser.impl.datamodel" );

        this.packageMap.put( "ValueElement", "com.mulesoft.raml1.java.parser.model.datamodel" );

        this.packageMap.put( "ValueElementImpl", "com.mulesoft.raml1.java.parser.impl.datamodel" );

        this.packageMap.put( "NumberElement", "com.mulesoft.raml1.java.parser.model.datamodel" );

        this.packageMap.put( "NumberElementImpl", "com.mulesoft.raml1.java.parser.impl.datamodel" );

        this.packageMap.put( "IntegerElement", "com.mulesoft.raml1.java.parser.model.datamodel" );

        this.packageMap.put( "IntegerElementImpl", "com.mulesoft.raml1.java.parser.impl.datamodel" );

        this.packageMap.put( "RAMLPointerElement", "com.mulesoft.raml1.java.parser.model.datamodel" );

        this.packageMap.put( "RAMLPointerElementImpl", "com.mulesoft.raml1.java.parser.impl.datamodel" );

        this.packageMap.put( "RAMLExpression", "com.mulesoft.raml1.java.parser.model.datamodel" );

        this.packageMap.put( "RAMLExpressionImpl", "com.mulesoft.raml1.java.parser.impl.datamodel" );

        this.packageMap.put( "ScriptHookElement", "com.mulesoft.raml1.java.parser.model.datamodel" );

        this.packageMap.put( "ScriptHookElementImpl", "com.mulesoft.raml1.java.parser.impl.datamodel" );

        this.packageMap.put( "SchemaElement", "com.mulesoft.raml1.java.parser.model.datamodel" );

        this.packageMap.put( "SchemaElementImpl", "com.mulesoft.raml1.java.parser.impl.datamodel" );

        this.packageMap.put( "DateElement", "com.mulesoft.raml1.java.parser.model.datamodel" );

        this.packageMap.put( "DateElementImpl", "com.mulesoft.raml1.java.parser.impl.datamodel" );

        this.packageMap.put( "HasNormalParameters", "com.mulesoft.raml1.java.parser.model.parameters" );

        this.packageMap.put( "HasNormalParametersImpl", "com.mulesoft.raml1.java.parser.impl.parameters" );

        this.packageMap.put( "MethodBase", "com.mulesoft.raml1.java.parser.model.methodsAndResources" );

        this.packageMap.put( "MethodBaseImpl", "com.mulesoft.raml1.java.parser.impl.methodsAndResources" );

        this.packageMap.put( "Response", "com.mulesoft.raml1.java.parser.model.bodies" );

        this.packageMap.put( "ResponseImpl", "com.mulesoft.raml1.java.parser.impl.bodies" );

        this.packageMap.put( "Trait", "com.mulesoft.raml1.java.parser.model.methodsAndResources" );

        this.packageMap.put( "TraitImpl", "com.mulesoft.raml1.java.parser.impl.methodsAndResources" );

        this.packageMap.put( "Method", "com.mulesoft.raml1.java.parser.model.methodsAndResources" );

        this.packageMap.put( "MethodImpl", "com.mulesoft.raml1.java.parser.impl.methodsAndResources" );

        this.packageMap.put( "SecuritySchemaPart", "com.mulesoft.raml1.java.parser.model.methodsAndResources" );

        this.packageMap.put( "SecuritySchemaPartImpl", "com.mulesoft.raml1.java.parser.impl.methodsAndResources" );

        this.packageMap.put( "SecuritySchemaSettings", "com.mulesoft.raml1.java.parser.model.methodsAndResources" );

        this.packageMap.put( "SecuritySchemaSettingsImpl", "com.mulesoft.raml1.java.parser.impl.methodsAndResources" );

        this.packageMap.put( "SecuritySchemaHook", "com.mulesoft.raml1.java.parser.model.methodsAndResources" );

        this.packageMap.put( "SecuritySchemaHookImpl", "com.mulesoft.raml1.java.parser.impl.methodsAndResources" );

        this.packageMap.put( "OAuth1SecuritySchemeSettings", "com.mulesoft.raml1.java.parser.model.methodsAndResources" );

        this.packageMap.put( "OAuth1SecuritySchemeSettingsImpl", "com.mulesoft.raml1.java.parser.impl.methodsAndResources" );

        this.packageMap.put( "OAuth2SecuritySchemeSettings", "com.mulesoft.raml1.java.parser.model.methodsAndResources" );

        this.packageMap.put( "OAuth2SecuritySchemeSettingsImpl", "com.mulesoft.raml1.java.parser.impl.methodsAndResources" );

        this.packageMap.put( "APIKeySettings", "com.mulesoft.raml1.java.parser.model.methodsAndResources" );

        this.packageMap.put( "APIKeySettingsImpl", "com.mulesoft.raml1.java.parser.impl.methodsAndResources" );

        this.packageMap.put( "SecuritySchema", "com.mulesoft.raml1.java.parser.model.methodsAndResources" );

        this.packageMap.put( "SecuritySchemaImpl", "com.mulesoft.raml1.java.parser.impl.methodsAndResources" );

        this.packageMap.put( "Oath2", "com.mulesoft.raml1.java.parser.model.methodsAndResources" );

        this.packageMap.put( "Oath2Impl", "com.mulesoft.raml1.java.parser.impl.methodsAndResources" );

        this.packageMap.put( "Oath1", "com.mulesoft.raml1.java.parser.model.methodsAndResources" );

        this.packageMap.put( "Oath1Impl", "com.mulesoft.raml1.java.parser.impl.methodsAndResources" );

        this.packageMap.put( "APIKey", "com.mulesoft.raml1.java.parser.model.methodsAndResources" );

        this.packageMap.put( "APIKeyImpl", "com.mulesoft.raml1.java.parser.impl.methodsAndResources" );

        this.packageMap.put( "Basic", "com.mulesoft.raml1.java.parser.model.methodsAndResources" );

        this.packageMap.put( "BasicImpl", "com.mulesoft.raml1.java.parser.impl.methodsAndResources" );

        this.packageMap.put( "Digest", "com.mulesoft.raml1.java.parser.model.methodsAndResources" );

        this.packageMap.put( "DigestImpl", "com.mulesoft.raml1.java.parser.impl.methodsAndResources" );

        this.packageMap.put( "Custom", "com.mulesoft.raml1.java.parser.model.methodsAndResources" );

        this.packageMap.put( "CustomImpl", "com.mulesoft.raml1.java.parser.impl.methodsAndResources" );

        this.packageMap.put( "ResourceBase", "com.mulesoft.raml1.java.parser.model.methodsAndResources" );

        this.packageMap.put( "ResourceBaseImpl", "com.mulesoft.raml1.java.parser.impl.methodsAndResources" );

        this.packageMap.put( "ResourceType", "com.mulesoft.raml1.java.parser.model.methodsAndResources" );

        this.packageMap.put( "ResourceTypeImpl", "com.mulesoft.raml1.java.parser.impl.methodsAndResources" );

        this.packageMap.put( "Resource", "com.mulesoft.raml1.java.parser.model.methodsAndResources" );

        this.packageMap.put( "ResourceImpl", "com.mulesoft.raml1.java.parser.impl.methodsAndResources" );

        this.packageMap.put( "AnnotationType", "com.mulesoft.raml1.java.parser.model.declarations" );

        this.packageMap.put( "AnnotationTypeImpl", "com.mulesoft.raml1.java.parser.impl.declarations" );

        this.packageMap.put( "Library", "com.mulesoft.raml1.java.parser.model.api" );

        this.packageMap.put( "LibraryImpl", "com.mulesoft.raml1.java.parser.impl.api" );

        this.packageMap.put( "RAMLSimpleElement", "com.mulesoft.raml1.java.parser.model.common" );

        this.packageMap.put( "RAMLSimpleElementImpl", "com.mulesoft.raml1.java.parser.impl.common" );

        this.packageMap.put( "ImportDeclaration", "com.mulesoft.raml1.java.parser.model.api" );

        this.packageMap.put( "ImportDeclarationImpl", "com.mulesoft.raml1.java.parser.impl.api" );

        this.packageMap.put( "GlobalSchema", "com.mulesoft.raml1.java.parser.model.api" );

        this.packageMap.put( "GlobalSchemaImpl", "com.mulesoft.raml1.java.parser.impl.api" );

        this.packageMap.put( "Api", "com.mulesoft.raml1.java.parser.model.api" );

        this.packageMap.put( "ApiImpl", "com.mulesoft.raml1.java.parser.impl.api" );

        this.packageMap.put( "Overlay", "com.mulesoft.raml1.java.parser.model.api" );

        this.packageMap.put( "OverlayImpl", "com.mulesoft.raml1.java.parser.impl.api" );

        this.packageMap.put( "Extension", "com.mulesoft.raml1.java.parser.model.api" );

        this.packageMap.put( "ExtensionImpl", "com.mulesoft.raml1.java.parser.impl.api" );
    }

}