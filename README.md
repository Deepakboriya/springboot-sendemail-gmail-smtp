# springboot-sendemail-gmail-smtp

use below request and url to send simple email

http://localhost:8080/sendMail

{
    "recipient" : "deepak_boriya@company.com",
    "msgBody" : "Hello",
    "subject" : "simple email",
    "attachment" : ""
}

use below request and url to send simple email
http://localhost:8080/sendMailWithAttachment

{
    "recipient" : "deepak_boriya@company.com",
    "msgBody" : "Hello",
    "subject" : "attachment email",
    "attachment" : "C:/Users/Deepak_Boriya/Desktop/Untitled.png"
}


Login to Gmail 
    -> Manage your Google Account 
        -> Security 
            -> App Passwords 
                -> Provide your login password 
                    -> Select app with a custom name 
                        -> Click on Generate

![image](https://user-images.githubusercontent.com/90191647/172820956-3092aef4-ef80-478a-bd13-56fb1c10ca33.png)
