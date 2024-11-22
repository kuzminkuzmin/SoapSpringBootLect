package com.kirillkotov.soapspringbootlect.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.validation.XmlValidator;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;
import org.springframework.xml.xsd.XsdSchemaCollection;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
	@Bean
	public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean<>(servlet, "/ws/*");
	}

	@Bean(name = "countries")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchemaCollection schema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("CountriesPort");
		wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setTargetNamespace("http://kirillkotov.com/soapspringbootlect/model");
		wsdl11Definition.setSchemaCollection(schema);
		return wsdl11Definition;
	}


	@Bean
	public XsdSchema studentSchema() {
		return new SimpleXsdSchema(new ClassPathResource("dto.xsd"));
	}

	@Bean
	public XsdSchema employeeSchema() {
		return new SimpleXsdSchema(new ClassPathResource("model.xsd"));
	}


	@Bean
	public XsdSchemaCollection getXsdCollection() {

		return new XsdSchemaCollection() {

			@Override
			public XmlValidator createValidator() {
				return null;
			}

			@Override
			public XsdSchema[] getXsdSchemas() {
				return new XsdSchema[]{studentSchema(), employeeSchema()};
			}
		};
	}
}
