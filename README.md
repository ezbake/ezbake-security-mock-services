# EzBake Protect Mock Services
Contains mock Java services for testing.

## Current services
EzCA Service: _ezbake.protect.mock.server.EzCAMockService_

## Using it
### In tests

```xml
<dependency>
    <groupId>ezbake.protect</groupId>
    <artifactId>mock-services</artifactId>
    <version>0.1-SNAPSHOT</version>
    <scope>test</scope>
</dependency>
```

### As thrift-runner service
The project builds an uber jar using the _maven-shade-plugin_. What this means is that multiple classes within the jar extend from __EZBakeBaseThriftService__. To avoid problems, you must pass the class you wish to run to the _thrift-runner_:

First pull in the jar with classifier __jar-with-dependencies__

```xml
<dependency>
    <groupId>ezbake.protect</groupId>
    <artifactId>mock-services</artifactId>
    <version>0.1-SNAPSHOT</version>
    <classifier>jar-with-dependencies</classifier>
</dependency>
```

Then run it with thrift-runner

```bash
$ java -jar ezbake-thrift-runner.jar -j mock-services*.jar -c ezbake.protect.mock.server.EzSecurityMockService -s EzSecurity
```


## Adding services
New services must extend from __EZBakeBaseThriftService__, and should be added in the __ezbake.protect.mock.servers__ package.

Ex:

```java
package ezbake.protect.mock.server;

public class EzSecurityMockService extends EZBakeBaseThriftService implements EzSecurity.Iface {

    // Implementation details

}
```

