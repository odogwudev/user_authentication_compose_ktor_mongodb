
# Utilising  Security in android for Authentication and Authorization for Android

I would be using mongo db to perform all basic operations no need for firebase so you can see clearly how the whole process is hhandled


## 🚀 About Me
I'm an android developer building this porject for and hands on with server side related authentication 


## Tech Stack

**Client:** Kotlin, Jetpack Compose, Dagger Hilt, Kotlin Serializer, Retrofit,Compose Navigation, Google Auth, Data Store Preferences, Coil

**Server:** Ktor, Koin, Kmongo and google client api library


## Documentation
Client Server Side Authentication: The backend server would use ktor framework(image). PSs use wire shark to track network activity

![image1](/images/image1.png)

### Authentication & Authorization:
Authentication process of verifying who the users are. Authorization verifying what oermission user has.

| Authentication     | Authorization      | 
| ------------- | ------------- |
| Determines whether users are who they claim to be| Determines what users can and can not acces| 
| Challenges users to validate credentials| Verifies whether access is allowes through policies and rules|
| Usually done before Authorization| Usually done after successful Authentication| 
| Usually transmits info through an id token| Genrally transmits info through access token|
| Generally governed through OpenID Connect(ODIC)| Generally GOverned through OAuth2.0 framework| 

### ID Token
ID token is proof that user is authenticated. It represents a jwt(json web token)standard that allows app to inspect its content that it comes from expected issuer. It is not readable by normal eyes. 

If you request a sign-in id from google. It would uses its private key to sign our token id and then when we receive it we use google public to verify that its sent by google.

![image2](/images/image2.png)

Id token demonstrates that user has been authenticated by an entity you trust(OPenId Provider -Google for example) and so you can trust the claims about their entity.
We can personalise the user experience by using the claims about the user that are included in the token. Id token is not encrypted but BAse64 encoded. 

![image3](/images/image3.png)

### ACCESS TOKEN: 
It allows client application to access a specific resource in order to perform a certain action on behalf of the user

![image4](/images/image4.png)

You have control over which app uses the token. For example you can give access to the file so to know it can be accessed not removed. Before giving access you can can see the permissions needed within a scope. 

Scopes are list of permissions required by applications which you are authorising to access a resource. Scopes are mechanism that allows user to authorise a 3rd  party application to perform only a specific set of instructions. Also known as jet

![image5](/images/image5.png)

Format of an access token can be a string in any format common format is jwt format with id token. Access token must be confidential both in transit and storage. 

The only parties that should see the token is application itself ,the authorisation server and resource server. The application should only be used in secured https connection. If you pass it through an unencrypted channel it can be stolen and modified.

![image6](/images/image6.png)

### OAuth2/OPenId

OAuth2 is an authorization framework that delegates user Authentication to the service Provider(google) that hosts the user account, and authorizes third party applications to access the user account.

It defines 4 diffferent roles:

1. Resource Owner: Its the user who authorizes an application to access the account.
3. Client: The application that wants to access the user account before it access it must be authorized and validated by the api.
4. Resource Server: Hosting that protects user account
5. Authorization Server: It verifys the identity of the user and issues access token to the application.


![image7](/images/image7.png)

![image8](/images/image8.png)

### OPenIdConnect

OPenIdConnect: Its an identity layer built on OAuth2 the highest level. it is a secure mechanism for the application to contact the identity service to get some user details and return in a secured way

![image9](/images/image9.png)id token

OAuth2 is about resource access and sharing and OPenIdConnect is about Authentication. Its purpose is to give one login for multiple sites.

### JSOn Web Token

Its an open stand (RFC 7510) that defines a compact and self-contained way for securely transmiting information between parties as a JSON object. It can be verified and trusted because its digitally signed. 

Jwt can also be signed using a secret with the HMAC algorithm or a public/private key pair using RSA or ECDSA.JWT is to hold or transfer claims to the other side. iTs commonly used for message exchange or authorization

![image10](/images/image10.png)

Most Common Scenario

![image11](/images/image11.png)

when establishing communication i would use session cookies. Trying other ways

JWT structure consists of three part seperated by a dot. Header payload(contians claims(registered:predefinedclaims, public, private:custom claims)) and signature takes encoded header, payload and secret an assigns jwt./signed token is readable no infomration should be used

### Sessions and cookies

![image12](/images/image12.png)

after we verify id token user would would receive session id which should be included in subsequent request or else user would have to verify id token all over again. The id token normally have an expiry period which is usually 1 hour but if it verifys with our backend server before expiry then a session id would be genrated and can be used so far as that session is live.


Sessions and cookies are used by different website for storing user data across different pages. Both are important as they keep track of information provided by visitor for different purposes. 

Main difference is sessions are saved on server side while cookies are saved on browser client side. The user is identified with the help of a session id which is a unique number saved in the server.

![image13](/images/image13.png)


| Sessions     | Cookies      | 
| ------------- | ------------- |
| Sessions are server side files that store user information|  Cookies are client side files that contain user information on a local computer| 
| Sessions can store an unlimited amount of data         | Cookies can only store limited amount of data         |
| We can store as much data as we want within a session but there is a maximum memory limit which a script can use at one time which is 128mb| The maximum on client side/browser is 4kb| 
| Sessions are secure compared to cookies as they're saved in encrpyted format| Cookies are not secure as they are stored in a text file and if any unauthorised user gets access to our device he can easily tamper with it         |

Cookies would be used in this project only for passing sessoin id to our backend server with each request we send
## Running Tests

To run tests, run the following command

```gradle
  .gradlew run test
```


## Usage/Examples

```kotlin

```


## Screenshots

![App Screenshot](https://via.placeholder.com/468x300?text=App+Screenshot+Here)


## Run Locally

Clone the project

```bash
  git clone https://link-to-project
```

Go to the project directory

```bash
  cd my-project
```

Install dependencies

```bash
 
```

Start the server

```bash
  
```


## Used By

This project is used by me
## Support

For support, email odogwudev@gmail.com.


## FAQ

#### CAN I USE THE APPLICATION LOCALLY AND LIVE

YES I WOULD ALSO DEPLOY ON HEROKU AND MONGODB

## License

[MIT](https://choosealicense.com/licenses/mit/)


## Badges

Add badges from somewhere like: [shields.io](https://shields.io/)

[![MIT License](https://img.shields.io/apm/l/atomic-design-ui.svg?)](https://github.com/tterb/atomic-design-ui/blob/master/LICENSEs)
[![GPLv3 License](https://img.shields.io/badge/License-GPL%20v3-yellow.svg)](https://opensource.org/licenses/)
[![AGPL License](https://img.shields.io/badge/license-AGPL-blue.svg)](http://www.gnu.org/licenses/agpl-3.0)


## Installation

Install my-project with the apk

```bash
 
```
    
## References

Here are some Links 

JWT
[JWT](https://jwt.io/)

