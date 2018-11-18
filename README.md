[![pipeline status](https://repo.dsi.tecnico.ulisboa.pt/FenixEdu/sandbox/badges/master/pipeline.svg)](https://repo.dsi.tecnico.ulisboa.pt/FenixEdu/sandbox/commits/master)

zen

# Upload multipart/form-data with File and JSON part

Run with ```mvn spring-boot:run```

Upload file with data

```curl -vvv -X POST -H "Content-Type: multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW" -F "file=@sample-data" -F "data={\"name\" : \"data-bean\", \"title\":\"This is a data bean\"};type=application/json" "http://localhost:8080/upload"```


POST just json with bean serialization

```curl -v -H 'Content-Type: application/json;charset=utf-8' -X POST -d '{"title" : "This is the title", "name" : "This is the name", "types" : ["READ", "WRITE"]}' http://localhost:8080/upload/json```
