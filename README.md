### FServe
A friendly API for serving HTTP http request (friendly http serving).

```java
  fork = new TkFork(
            new FkRegex("/hello", new Take() {
                @Override
                public Response ack(Request request) throws IOException {
                    return new RsText("Hello !!!");
                }
            })
  );
```

### Adding as dependency

In Gradle:
```groovy

repositories {
  mavenCentral()
  maven { url 'https://oss.sonatype.org/content/repositories/snapshots' }
}

dependencies {
     compile 'com.clouway.fserve:fserve:0.1-SNAPSHOT'
}
```

In Maven:

```xml

 <dependency>
    <groupId>com.clouway.fserve</groupId>
    <artifactId>fserve</artifactId>
    <version>0.1-SNAPSHOT</version>
 </dependency>

```

**Remarks:** library will be available and in maven central after version 0.1 is released.

### Adapters
 * Servlet API Adapter - provides a basic HTTP helper classes for calling fserve directly from the servlet API

```java
private ServletApiSupport servletApiSupport;

@Override
public void init(ServletConfig servletConfig) throws ServletException {
  super.init(servletConfig);

  fork = new TkFork(
        new FkRegex("/hello", new Take() {
            @Override
            public Response ack(Request request) throws IOException {
                return new RsText("Hello !!!");
            }
    })
  );

  servletApiSupport = new ServletApiSupport(fork);
}


@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  servletApiSupport.serve(req, resp);
}
```


### Additional Notes
Some ideas are taken from [Takes](https://github.com/yegor256/takes) framework, but with Servlet API support.

### Contributing
If you would like to contribute code to fserve you can do so through GitHub by forking the repository and sending
a pull request. When submitting code, please make every effort to follow existing conventions and style in order to
keep the code as readable as possible. Please also make sure your code compiles by running gradle clean build.
