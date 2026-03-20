import org.springframework.stereotype.Component;

@Component
public class IsObjectCreatedWithAnnoation {

    // object will not be created by spring becasue in the applicationContext.xml you specified on the org.annoationbasedconfiguration
    public IsObjectCreatedWithAnnoation(){
        System.out.println("object is created");
    }
}
