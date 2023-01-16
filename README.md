## 🎉Building a Full Stack Oembed Project


<img width="800px" src="https://user-images.githubusercontent.com/69441691/212609374-1de05d82-8c42-4142-95e1-f48ddd32aac4.gif"/>



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
