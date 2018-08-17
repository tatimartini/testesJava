package br.com.main;

import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;

import br.com.driver.Driver;
import cucumber.api.junit.Cucumber;
import cucumber.runtime.ClassFinder;
import cucumber.runtime.RuntimeOptions;
import cucumber.runtime.io.MultiLoader;
import cucumber.runtime.io.ResourceLoader;
import cucumber.runtime.io.ResourceLoaderClassFinder;

public class CustomCucumberRunner {

	
	public static void main(String args[]) {
		try {
			ClassLoader classLoader = CustomCucumberRunner.class.getClassLoader();
			ResourceLoader resourceLoader = new MultiLoader(classLoader);
			ClassFinder classFinder = new ResourceLoaderClassFinder(resourceLoader, classLoader);
			List<String> pluginList = new ArrayList<String>();
			//pluginList = Driver.pluginList();
			RuntimeOptions ro = new RuntimeOptions(pluginList);
			ro.getFeaturePaths().add("classpath:features");
			ro.getGlue().add("br/com/test");
			cucumber.runtime.Runtime runtime = new cucumber.runtime.Runtime(resourceLoader, classFinder, classLoader,
					ro);
			runtime.run();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}