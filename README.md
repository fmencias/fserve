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

### Adapters
 * Servlet API Adapter - provides a basic HTTP helper classes for calling fserve directly from the servlet API


### Additional Notes
Some ideas are taken from [Takes](https://github.com/yegor256/takes) framework, but with Servlet API support.

### Contributing
If you would like to contribute code to fserve you can do so through GitHub by forking the repository and sending
a pull request. When submitting code, please make every effort to follow existing conventions and style in order to
keep the code as readable as possible. Please also make sure your code compiles by running gradle clean build.