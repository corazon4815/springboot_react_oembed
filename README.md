## 🎉Building a Full Stack Oembed Project


Uploading React App - Chrome 2023-01-16 12-02-16.mp4…


### ✔ Clone the application

	```bash
	git clone https://github.com/corazon4815/Springboot_react_oembed.git
	```

### ✔ Steps to Setup the React Back end app
    ※ version info
    JAVA - 11
    Spring - 2.7.8

	1. gradle -  Reload All Gradle Projects

    2. ▶ click 

	The server will start on port 8080.

### ✔ Steps to Setup the React Front end app
    ```bash
	cd oembed-web-FE
    npm i
    npm start
	```
	The server will start on port 3001.

### ✔ API TEST

| provider | url                                                                              |
|----------|----------------------------------------------------------------------------------|
| youtube  | http://localhost:8080/api/oembed?url=https://www.youtube.com/watch?v=dBD54EZIrZo |
| twitter  | http://localhost:8080/api/oembed?url=https://twitter.com/hellopolicy/status/867177144815804416 |
| vimeo    | http://localhost:8080/api/oembed?url=https://vimeo.com/20097015 | 
