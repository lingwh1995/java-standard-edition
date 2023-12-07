package string;


import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;

public class Test {

    public static void main(String[] args) throws UnsupportedEncodingException {
        Base64 base64 = new Base64();
        final String text = "eyJraWQiOiJJZjJNaDFTR25zN2RwWW1jelg2czZnK3Njc0xpaXFjeHREXC92TEcrYkZPbz0iLCJhbGciOiJSUzI1NiJ9.eyJzdWIiOiIwODZhMTkxNy1iNjZjLTRiZDctYmQ0Zi04YWE2NWEwZWUwNGIiLCJldmVudF9pZCI6IjNkM2I4ZGM1LTkyNGUtNDI0OC05NmY0LTI3MzhlYjNlYmQ5ZCIsInRva2VuX3VzZSI6ImFjY2VzcyIsInNjb3BlIjoiYXdzLmNvZ25pdG8uc2lnbmluLnVzZXIuYWRtaW4iLCJhdXRoX3RpbWUiOjE2ODI1MjE2NzQsImlzcyI6Imh0dHBzOlwvXC9jb2duaXRvLWlkcC5hcC1zb3V0aGVhc3QtMS5hbWF6b25hd3MuY29tXC9hcC1zb3V0aGVhc3QtMV9ENk04QkJ6RzkiLCJleHAiOjE2ODM2OTYwNjgsImlhdCI6MTY4MzYwOTY2OCwianRpIjoiNzVmNjAwYjAtZGU5Ny00Zjg3LThkNGMtZWVjMmEyNTNlMTBjIiwiY2xpZW50X2lkIjoiNDM3ZjN1MHNmaDdoMGF2NXJscnJqZHRtc2IiLCJ1c2VybmFtZSI6IjA4NmExOTE3LWI2NmMtNGJkNy1iZDRmLThhYTY1YTBlZTA0YiJ9.GDkR3BPBahA6eEB6OUbvKKlZfhuEDJP05_BTBzDwYRQRBPWMeZlUV9pPU-rFZU0Jkp63fhD0xfnS7m67PnW1jtAC9JKWtkaqdFEiXGnqkYa0_yYGEJ0n-mrSPajpx1EOcF28STFYAq3eYi5eGlG1uCS8Fz6NuR6_R_75GJiYPaJlmNcF2l6KqT7OJaxD1xhX0ktsrURDaGZW9dgNdeZa_YYQjg53MdiBoxZPbyHPc9HRXyqZmNMVF9sQezqpl6TSWnbAEkpLCQWJCUq109UNzcrBlJtmblJyXVOUsVeHUTINeZMeI2v_6-IgYuiYY62QNIY0qshDhH6AM4mr70BMWQ";
        byte[] decode = base64.decode(text.getBytes("UTF16"));
        String s = new String(decode);
        System.out.println(s);

    }
}




