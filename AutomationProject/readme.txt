To run features in parallel

comment TestNG dependency

Make driver instance non-static

Call LaunchBrowser and CloseBrowser from specific StepDefinition files

Add below in POM.

<plugin>
	<groupId>org.apache.maven.plugins</groupId>
	<artifactId>maven-surefire-plugin</artifactId>
	<version>2.22.0</version>
	<configuration>
	<includes>
		<include>**/*Runner.java</include>
	</includes>
	       <parallel>methods</parallel>
	       <useUnlimitedThreads>true</useUnlimitedThreads>
	</configuration>
</plugin>



