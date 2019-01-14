package si.inspirited.util.resolvers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Component;

import java.util.Locale;

//@Component
public class MessageResolver { //implements MessageSourceAware {

  //  @Autowired
    private MessageSource messageSource;

    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String getMessage(){
        return messageSource.getMessage("user.welcome", new Object[]{"Rama"} , Locale.US);
    }

}