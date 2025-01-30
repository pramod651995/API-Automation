package TestClass;

import POJO.data;
import POJO.test1;

import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class apiClass {
    static String id;
    public static void main(String[] args){
        CreateObject();
        Update();
        GetAllObject();
        Delete();
    }

    public static void CreateObject(){
        String baseURI = "https://api.restful-api.dev/objects";
        data devicedata = new data();
        devicedata.setModel("M1");
        devicedata.setPrice("1849");
        devicedata.setYear("2023");
        devicedata.setSize("1 TB");
        test1 requestBody = new test1("xxs IPHONE xx", devicedata);
        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .post(baseURI);
        System.out.println("Status Code : " + response.getStatusCode());
        System.out.println("Response : " + response.getBody().asString());
        id = response.jsonPath().getString("id");
        Assert.assertNotNull("id");
        Assert.assertEquals(response.getStatusCode(), 200);
    }
    
    public static void Update(){
        String baseURI = "https://api.restful-api.dev/objects/";
        data devicedata = new data();
        devicedata.setModel("M1");
        devicedata.setPrice("1849");
        devicedata.setYear("2023");
        devicedata.setSize("1 TB");
        test1 requestBody = new test1("xxs IPHONE xx", devicedata);
        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .put(baseURI + id);
        System.out.println("Status Code : " + response.getStatusCode());
        System.out.println("Response : " + response.getBody().asString());
    }

    public static void GetAllObject(){
        String baseURI = "https://api.restful-api.dev/objects";
        Response response = given()
                .header("Content-Type", "application/json")
                .get(baseURI);

    }
    public static void Delete(){
        String baseURI = "https://api.restful-api.dev/objects/";
        Response response = given()
                .header("Content-Type", "application/json")
                .delete(baseURI+id);
        System.out.println("message: Object with id = " + id +" has been deleted.");
    }
}
