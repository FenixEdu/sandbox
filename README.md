# Upload multipart/form-data with File and JSON part

Run with ```mvn spring-boot:run```

```curl -vvv -X POST -H "Content-Type: multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW" -F "file=@sample-data" -F "data={\"name\" : \"data-bean\", \"title\":\"This is a data bean\"};type=application/json" "http://localhost:8080/upload"```

